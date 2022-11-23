package com.fptu.edu.travelservices.controller.response.hotel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelListByOwnerIdResponse {

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String hotelName;

    @JsonProperty("address")
    private String address;
}
