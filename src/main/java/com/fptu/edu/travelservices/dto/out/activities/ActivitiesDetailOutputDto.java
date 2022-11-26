package com.fptu.edu.travelservices.dto.out.activities;

import com.fptu.edu.travelservices.dto.out.hotel.HotelTopListOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivitiesDetailOutputDto {

    private String nameActivities;

    private String title;

    private String image;

    private String image1;

    private String image2;

    private String startTime;

    private String endTime;

    private String description;

    private String description1;

    private String description2;

    private String latitude;

    private String longitude;

    private String username;

    List<HotelTopListOutputDto> hotelList;
}
