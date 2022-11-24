package com.fptu.edu.travelservices.dto.out.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDetailOutputDto {

    private String hotelName;

    private String addressHotel;

    private String checkIn;

    private String checkOut;

    private String totalAmount;

    private String billMethod;

    private String billStatus;
}
