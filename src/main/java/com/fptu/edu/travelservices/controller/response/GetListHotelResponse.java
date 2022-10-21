package com.fptu.edu.travelservices.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListHotelResponse {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("address")
    private String address;

    @JsonProperty("image")
    private String image;

    @Column(name = "Phone")
    private String phone;

    @JsonProperty("status_hotel")
    private String statusHotel;
}
