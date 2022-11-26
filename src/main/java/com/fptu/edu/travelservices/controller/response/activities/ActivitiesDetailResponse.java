package com.fptu.edu.travelservices.controller.response.activities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fptu.edu.travelservices.controller.response.hotel.HotelTopListResponse;
import com.fptu.edu.travelservices.dto.out.hotel.HotelListOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivitiesDetailResponse {

    @JsonProperty("name_activities")
    private String nameActivities;

    @JsonProperty("title")
    private String title;

    @JsonProperty("image")
    private String image;

    @JsonProperty("image1")
    private String image1;

    @JsonProperty("image2")
    private String image2;

    @JsonProperty("start_time")
    private String startTime;

    @JsonProperty("end_time")
    private String endTime;

    @JsonProperty("description")
    private String description;

    @JsonProperty("description1")
    private String description1;

    @JsonProperty("description2")
    private String description2;

    @JsonProperty("latitude")
    private String latitude;

    @JsonProperty("longitude")
    private String longitude;

    @JsonProperty("user_name")
    private String username;

    @JsonProperty("hotel_list")
    List<HotelTopListResponse> hotelList;
}
