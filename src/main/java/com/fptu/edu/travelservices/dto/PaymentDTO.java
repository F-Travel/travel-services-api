package com.fptu.edu.travelservices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    private Long isServicePack;

    private String amount;

    private String description;

    private String bankCode;
}
