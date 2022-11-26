package com.fptu.edu.travelservices.controller.response.booking;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingMonthlyRevenueReportResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("user_booking")
    private String userBooking;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("total_amount")
    private String totalAmount;

    @JsonProperty("create_date")
    private String createDate;
}
