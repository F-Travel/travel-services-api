package com.fptu.edu.travelservices.config;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaymentConfig {
    public static String vnp_PayUrl = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html";

    //    @Value("${host.url}/return")
    public static String vnp_Returnurl = "";
    public static String vnp_TmnCode = "DRHTBKTQ";
    public static String vnp_HashSecret = "SGAMCNSWNMBISPWKRLZXBUEQDZHDBPGT";
    //    TO DO: Change this
    public static String vnp_apiUrl = "https://sandbox.vnpayment.vn/merchant_webapi/merchant.html";
}
