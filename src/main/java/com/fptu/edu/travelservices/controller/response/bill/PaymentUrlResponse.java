package com.fptu.edu.travelservices.controller.response.bill;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentUrlResponse {
    @JsonProperty("payment_url")
    private String paymentUrl;
}
