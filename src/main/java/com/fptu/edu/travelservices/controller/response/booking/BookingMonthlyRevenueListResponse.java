package com.fptu.edu.travelservices.controller.response.booking;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingMonthlyRevenueListResponse {

    @JsonProperty("total_amount")
    private String totalAmount;

    @JsonProperty("number_booking")
    private String numberBooking;

    @JsonProperty("create_date")
    private String createDate;
}
