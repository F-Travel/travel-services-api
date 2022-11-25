package com.fptu.edu.travelservices.dto.out.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingMonthlyRevenueListOutputDto {

    private String totalAmount;

    private String numberBooking;

    private String createDate;
}
