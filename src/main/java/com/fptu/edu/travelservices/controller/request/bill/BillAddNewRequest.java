package com.fptu.edu.travelservices.controller.request.bill;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillAddNewRequest {

    @JsonProperty(value = "booking_id")
    private String bookingId;

    @JsonProperty(value = "payment_method")
    private String paymentMethod;

//    @JsonProperty(value = "external_invoice")
//    private String totalPrice;

    @JsonProperty(value = "total_amount")
    private String totalAmount;
}
