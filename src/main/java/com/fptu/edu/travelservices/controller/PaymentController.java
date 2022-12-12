package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.config.Helper;
import com.fptu.edu.travelservices.config.PaymentConfig;
import com.fptu.edu.travelservices.controller.request.bill.BillAddNewRequest;
import com.fptu.edu.travelservices.controller.response.bill.PaymentUrlResponse;
import com.fptu.edu.travelservices.dto.in.bill.BillAddNewInputDto;
import com.fptu.edu.travelservices.dto.in.bill.BillUpateInfoInputDto;
import com.fptu.edu.travelservices.service.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private BillService billService;

//    @Value("${host.url}")
//    private String hostUrl;

    private final Logger log = LoggerFactory.getLogger(getClass());


    @PostMapping("/create-payment")
    public ResponseEntity<?> createPayment(
            @RequestBody BillAddNewRequest request) throws IOException {

        Long orderAmount = Long.parseLong(request.getTotalAmount()) * 100;
        String orderDes = "payment";

        String SecureHash_External_Invoice = Helper.Sha256(PaymentConfig.vnp_TmnCode_External_Invoice + request.getBookingId());
        String externalInvoice = SecureHash_External_Invoice.substring(0,8);
        log.info("externalInvoice-------: " + externalInvoice);


        BillAddNewInputDto inputDto = new BillAddNewInputDto();
        inputDto.setPaymentMethod(request.getPaymentMethod());
        inputDto.setExternalInvoice(externalInvoice);
        inputDto.setExternalTransaction(externalInvoice);
        inputDto.setTotalAmount(request.getTotalAmount());
        inputDto.setBookingId(request.getBookingId());

        billService.saveBill(inputDto);

//        Query Parameter
        String vnp_Version = "2.1.0";

        String vnp_Command = "pay";

        String vnp_TmnCode = PaymentConfig.vnp_TmnCode;

        String vnp_Amount = orderAmount.toString();

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));

        cld.add(Calendar.HOUR, 7);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());

        String vnp_CurrCode = "VND";

        String vnp_IpAddr = "13.160.92.202";

        String vnp_Locale = "vn";

        String vnp_OrderInfo = orderDes;

        String vnp_OrderType = "other";

//        String vnp_ReturnUrl = "http://localhost:3000/bill/payment/booking";

        String vnp_ReturnUrl = "https://www.f-travel.online/bill/payment/booking";

        String vnp_TxnRef = externalInvoice;

        Map<String, String> params = new HashMap<>();

        params.put("vnp_Version", vnp_Version);
        params.put("vnp_Command", vnp_Command);
        params.put("vnp_TmnCode", vnp_TmnCode);
        params.put("vnp_Amount", vnp_Amount);
        params.put("vnp_BankCode", "NCB");
        params.put("vnp_CreateDate", vnp_CreateDate);
        params.put("vnp_ExpireDate", vnp_ExpireDate);
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
            String fieldValue = (String) params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
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

        String vnp_SecureHash = Helper.hmacSHA512(PaymentConfig.vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;

        String paymentUrl = PaymentConfig.vnp_PayUrl + '?' + queryUrl;
        log.info("Paymenr url: " + paymentUrl);

        PaymentUrlResponse urlResponse = new PaymentUrlResponse();
        urlResponse.setPaymentUrl(paymentUrl);

        return ResponseEntity
                .status(HttpStatus.OK).body(urlResponse);
    }

}
