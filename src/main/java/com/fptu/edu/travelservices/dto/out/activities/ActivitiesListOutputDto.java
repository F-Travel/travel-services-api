package com.fptu.edu.travelservices.dto.out.activities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivitiesListOutputDto {

    private String id;

    private String nameActivities;

    private String startTime;

    private String endTime;

    private String image;
}
