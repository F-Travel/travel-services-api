package com.fptu.edu.travelservices.controller.response.hotel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelListResponse {

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String hotelName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("image")
    private String image;

    @Column(name = "phone")
    private String phone;

    @JsonProperty("status_hotel")
    private String statusHotel;
}
