package com.fptu.edu.travelservices.controller.request.hotel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelUpdateRequest {

    @JsonProperty(value = "hotel_name")
    private String hotelName;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "phone")
    private String phone;

    @JsonProperty(value = "image")
    private String image;

    @JsonProperty(value = "image1")
    private String image1;

    @JsonProperty(value = "image2")
    private String image2;

    @JsonProperty(value = "image3")
    private String image3;

    @JsonProperty(value = "image4")
    private String image4;

    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value = "city_id")
    private String cityId;

    @JsonProperty(value = "latitude")
    private String latitude;

    @JsonProperty(value = "longtitude")
    private String longitude;

    @JsonProperty(value = "check_in_time")
    private String checkInTime;

    @JsonProperty(value = "check_out_time")
    private String checkOutTime;

    @JsonProperty(value = "is_payment_card")
    private String isPaymentCard;

    @JsonProperty(value = "hotel_properties")
    private List<HotelPropertiesRequest> hotelProperties;
}
