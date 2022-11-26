package com.fptu.edu.travelservices.controller.response.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelTopListResponse {

    private String id;

    private String hotelName;

    private String image;
}
