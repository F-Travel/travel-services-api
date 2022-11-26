package com.fptu.edu.travelservices.controller.request.activities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivitiesAddNewRequest {

    @JsonProperty(value = "name_activities")
    private String nameActivities;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "image")
    private String image;

    @JsonProperty(value = "image1")
    private String image1;

    @JsonProperty(value = "image2")
    private String image2;

    @JsonProperty(value = "startTime")
    private String startTime;

    @JsonProperty(value = "endTime")
    private String endTime;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "description1")
    private String description1;

    @JsonProperty(value = "description2")
    private String description2;

    @JsonProperty(value = "latitude")
    private String latitude;

    @JsonProperty(value = "longitude")
    private String longitude;

    @JsonProperty(value = "user_name")
    private String username;
}
