package com.fptu.edu.travelservices.dto.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListHotelOutputDto {
    private int id;

    private String title;

    private String address;

    private String image;

    private String phone;

    private String statusHotel;
}
