package com.fptu.edu.travelservices.dto.out.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebtMonthOutputDto {

    private String boutBooking;

    private String debtBooking;

    private String cash;

    private String onlinePayment;

    private String totalAmount;
}
