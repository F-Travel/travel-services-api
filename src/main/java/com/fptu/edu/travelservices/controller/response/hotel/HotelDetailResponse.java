package com.fptu.edu.travelservices.controller.response.hotel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fptu.edu.travelservices.controller.response.FeedBackResponse;
import com.fptu.edu.travelservices.controller.response.room.RoomTypeGetListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDetailResponse {
    @JsonProperty("hotel_name")
    private String hotelName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("image")
    private String image;

    @JsonProperty("image1")
    private String image1;

    @JsonProperty("image2")
    private String image2;

    @JsonProperty("image3")
    private String image3;

    @JsonProperty("image4")
    private String image4;

    @JsonProperty("address")
    private String address;

    @JsonProperty("latitude")
    private String latitude;

    @JsonProperty("longitude")
    private String longitude;

    @JsonProperty("check_in_time")
    private String checkInTime;

    @JsonProperty("check_out_time")
    private String checkOutTime;

    @JsonProperty("is_payment_card")
    private String isPaymentCard;

    @JsonProperty("feed_back")
    private List<FeedBackResponse> feedBacks;

    @JsonProperty("hotel_properties")
    private List<HotelPropertiesResponse> hotelProperties;

    @JsonProperty("room_types")
    private List<RoomTypeGetListResponse> roomTypes;
}
