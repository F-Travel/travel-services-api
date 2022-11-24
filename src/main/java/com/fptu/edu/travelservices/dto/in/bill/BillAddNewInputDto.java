package com.fptu.edu.travelservices.dto.in.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillAddNewInputDto {

    private String paymentMethod;

    private String externalInvoice;

    private String externalTransaction;

    private String totalAmount;

    private String bookingId;

    private String statusBill;
}
