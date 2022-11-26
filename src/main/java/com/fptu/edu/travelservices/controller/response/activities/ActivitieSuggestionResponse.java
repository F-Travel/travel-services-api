package com.fptu.edu.travelservices.controller.response.activities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivitieSuggestionResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name_activities")
    private String nameActivities;

    @JsonProperty("image")
    private String image;
}
