package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.activities.ActivitiesAddNewInputDto;
import com.fptu.edu.travelservices.dto.out.activities.ActivitieSuggestionOutputDto;
import com.fptu.edu.travelservices.dto.out.activities.ActivitiesDetailOutputDto;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.List;

public interface ActivitiesService {
    void addNewActivities(ActivitiesAddNewInputDto inputDto);

    List<ActivitieSuggestionOutputDto>  getSuggestionActivities();

    ActivitiesDetailOutputDto getActivitiesDetail(int id);
}
