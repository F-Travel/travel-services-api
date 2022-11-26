package com.fptu.edu.travelservices.dto.out.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingMonthlyRevenueReportOutputDto {

    private String id;

    private String userBooking;

    private String phone;

    private String totalAmount;

    private String createDate;
}
