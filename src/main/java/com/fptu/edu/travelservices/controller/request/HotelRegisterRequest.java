package com.fptu.edu.travelservices.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelRegisterRequest {

    private String title;

    private String address;

    private String street;

    private String province;

    private String district;

    private String city;

    private String latitude;

    private String longitude;

    private String phone;

    private String image;

    private String description;

    private int ownerId;
}
