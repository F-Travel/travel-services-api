package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.activities.ActivitiesAddNewInputDto;
import com.fptu.edu.travelservices.dto.out.activities.ActivitieSuggestionOutputDto;

import java.util.List;

public interface ActivitiesService {
    void addNewActivities(ActivitiesAddNewInputDto inputDto);

    List<ActivitieSuggestionOutputDto>  getSuggestionActivities();
}
