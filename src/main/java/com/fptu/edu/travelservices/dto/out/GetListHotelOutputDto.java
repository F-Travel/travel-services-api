package com.fptu.edu.travelservices.dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListHotelOutputDto {
    private int id;

    private String hotelName;

    private String address;

    private String image;

    private int phone;

    private String description;

    private int startPoint;
}
