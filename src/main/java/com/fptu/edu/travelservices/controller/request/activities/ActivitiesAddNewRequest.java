package com.fptu.edu.travelservices.controller.request.activities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fptu.edu.travelservices.controller.request.hotel.HotelPropertiesRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivitiesAddNewRequest {

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "image")
    private String image;

    @JsonProperty(value = "start_time")
    private String startTime;

    @JsonProperty(value = "end_time")
    private String endTime;

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

    @JsonProperty(value = "longitude")
    private String longitude;

    @JsonProperty(value = "check_in_time")
    private String checkInTime;

    @JsonProperty(value = "check_out_time")
    private String checkOutTime;

    @JsonProperty(value = "is_payment_card")
    private String isPaymentCard;

    @JsonProperty(value = "owner_id")
    private String ownerId;

    @JsonProperty(value = "hotel_properties")
    private List<HotelPropertiesRequest> hotelProperties;
}
