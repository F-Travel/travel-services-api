package com.fptu.edu.travelservices.controller.response.activities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivitiesDetailResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("total_amount")
    private String totalAmount;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("status_bill")
    private String statusBill;

    @JsonProperty("hotel_name")
    private String hotelName;
}
