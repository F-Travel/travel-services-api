package com.fptu.edu.travelservices.controller.response.booking;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebtMonthResponse {

    @JsonProperty("cash")
    private String cash;

    @JsonProperty("vnpay")
    private String vnpay;

    @JsonProperty("payment_services")
    private String paymentServices;
}
