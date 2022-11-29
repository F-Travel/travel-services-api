package com.fptu.edu.travelservices.dto.in.bill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillUpateInfoInputDto {

    private String externalInvoice;

    private String externalTransaction;

    private String totalAmount;
}
