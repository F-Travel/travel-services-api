package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.config.Helper;
import com.fptu.edu.travelservices.config.PaymentConfig;
import com.fptu.edu.travelservices.dto.PaymentDTO;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Value("${host.url}")
    private String hostUrl;

    private final Logger log = LoggerFactory.getLogger(getClass());


    @PostMapping("/create-payment")
    public ResponseEntity<?> createPayment(
            @RequestBody PaymentDTO request) throws IOException {

//        Long orderAmount = Long.parseLong(request.getParameter("amount")) * 100;
        Long orderAmount = Long.parseLong(request.getAmount()) * 100;
//        String orderDes = request.getParameter("description");
        String orderDes = request.getDescription();
        Order newOrder = new Order(orderAmount, orderDes);
        String ipAddr = request.getRemoteAddr();
        log.info("ip: " + ipAddr);
        Long createdOrderId = orderService.createOrder(newOrder, ipAddr);

//        Query Parameter
        String vnp_Version = "2.0.1";

        String vnp_Command = "pay";

        String vnp_TmnCode = PaymentConfig.vnp_TmnCode;

        String vnp_Amount = orderAmount.toString();

        String vnp_BankCode = request.getBankCode();

        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String vnp_CreateDate = time.format(formatter);

        String vnp_CurrCode = "VND";

        String vnp_IpAddr = ipAddr;

        String vnp_Locale = "vn";

        String vnp_OrderInfo = orderDes;

        String vnp_OrderType = "billpayment";

//        String vnp_ReturnUrl = Config.vnp_Returnurl;
        String vnp_ReturnUrl = hostUrl + "return";

        String vnp_TxnRef = createdOrderId.toString();
//        String vnp_TxnRef = Helper.getRandomNumber(8);

        Map<String, String> params = new HashMap<>();

        params.put("vnp_Version", vnp_Version);
        params.put("vnp_Command", vnp_Command);
        params.put("vnp_TmnCode", vnp_TmnCode);
        params.put("vnp_Amount", vnp_Amount);
        params.put("vnp_BankCode", vnp_BankCode);
        params.put("vnp_CreateDate", vnp_CreateDate);
        params.put("vnp_CurrCode", vnp_CurrCode);
        params.put("vnp_IpAddr", vnp_IpAddr);
        params.put("vnp_Locale", vnp_Locale);
        params.put("vnp_OrderInfo", vnp_OrderInfo);
        params.put("vnp_OrderType", vnp_OrderType);
        params.put("vnp_ReturnUrl", vnp_ReturnUrl);
        params.put("vnp_TxnRef", vnp_TxnRef);

        List fieldNames = new ArrayList(params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(fieldValue);
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Helper.Sha256(PaymentConfig.vnp_HashSecret + hashData);
        log.info("Hash " + vnp_SecureHash);
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;

        String paymentUrl = PaymentConfig.vnp_PayUrl + '?' + queryUrl;
        log.info("Paymenr url: " + paymentUrl);

//        return "redirect:" + paymentUrl;
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }

}
