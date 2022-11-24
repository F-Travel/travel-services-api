package com.fptu.edu.travelservices.dto.out.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillHistoryListOutputDto {

    private String id;

    private String totalAmount;

    private String paymentMethod;

    private String statusBill;

    private String hotelName;
}
