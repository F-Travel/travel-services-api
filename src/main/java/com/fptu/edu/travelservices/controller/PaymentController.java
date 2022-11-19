package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.config.Helper;
import com.fptu.edu.travelservices.config.PaymentConfig;
import com.fptu.edu.travelservices.dto.PaymentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

//    @Value("${host.url}")
//    private String hostUrl;

    private final Logger log = LoggerFactory.getLogger(getClass());


    @PostMapping("/create-payment")
    public ResponseEntity<?> createPayment(
            @RequestBody PaymentDTO request) throws IOException {

//        Long orderAmount = Long.parseLong(request.getParameter("amount")) * 100;
        Long orderAmount = Long.parseLong(request.getAmount()) * 100;
//        String orderDes = request.getParameter("description");
        String orderDes = request.getDescription();
//        Order newOrder = new Order(orderAmount, orderDes);
//        String ipAddr = request.getRemoteAddr();
//        log.info("ip: " + ipAddr);
//        Long createdOrderId = orderService.createOrder(newOrder, ipAddr);

//        Query Parameter
        String vnp_Version = "2.1.0";

        String vnp_Command = "pay";

        String vnp_TmnCode = PaymentConfig.vnp_TmnCode;

        String vnp_Amount = orderAmount.toString();

//        String vnp_BankCode = request.getBankCode();

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());

//        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        //Add Params of 2.0.1 Version
//        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        String vnp_CurrCode = "VND";

        String vnp_IpAddr = "13.160.92.202";

        String vnp_Locale = "vn";

        String vnp_OrderInfo = orderDes;

        String vnp_OrderType = "other";

//        String vnp_ReturnUrl = Config.vnp_Returnurl;
        String vnp_ReturnUrl = "https://f-travel.azurewebsites.net/api/feedback/list-report";

//        String vnp_TxnRef = createdOrderId.toString();
        String vnp_TxnRef = "1500";
//        String vnp_TxnRef = Helper.getRandomNumber(8);

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

//        String vnp_SecureHash = Helper.hmacSHA512(PaymentConfig.vnp_HashSecret , hashData.toString());
//        log.info("Hash " + vnp_SecureHash);
//        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;

//        String paymentUrl = PaymentConfig.vnp_PayUrl + '?' + queryUrl;
        String paymentUrl = PaymentConfig.vnp_PayUrl + '?' + queryUrl;
        log.info("Paymenr url: " + paymentUrl);

//        URL url = new URL(paymentUrl);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        String inputLine;
//        StringBuilder response = new StringBuilder();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//        String Rsp = response.toString();
//        String respDecode = URLDecoder.decode(Rsp, "UTF-8");
//        String[] responseData = respDecode.split("&|\\=");
//        com.google.gson.JsonObject job = new JsonObject();
//        job.addProperty("data", Arrays.toString(responseData));
//        Gson gson = new Gson();
//        resp.getWriter().write(gson.toJson(job));

//        return "redirect:" + paymentUrl;
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }

}