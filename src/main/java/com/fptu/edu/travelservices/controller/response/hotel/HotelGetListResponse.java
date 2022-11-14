package com.fptu.edu.travelservices.controller.response.hotel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelGetListResponse {
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

    @JsonProperty("description")
    private String description;

    @JsonProperty("start_point")
    private String startPoint;

    @JsonProperty("price")
    private String price;
}
