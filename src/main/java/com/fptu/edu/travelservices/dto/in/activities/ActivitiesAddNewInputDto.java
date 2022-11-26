package com.fptu.edu.travelservices.dto.in.activities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivitiesAddNewInputDto {

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
}
