package com.fptu.edu.travelservices.controller.response.activities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivitiesListResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name_activities")
    private String nameActivities;

    @JsonProperty("start_time")
    private String startTime;

    @JsonProperty("end_time")
    private String endTime;

    @JsonProperty("image")
    private String image;
}
