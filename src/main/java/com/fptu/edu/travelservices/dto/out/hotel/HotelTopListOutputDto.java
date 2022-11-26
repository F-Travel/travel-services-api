package com.fptu.edu.travelservices.dto.out.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelTopListOutputDto {

    private String id;

    private String hotelName;

    private String image;
}
