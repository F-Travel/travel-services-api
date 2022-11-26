package com.fptu.edu.travelservices.service.impl;

import com.fptu.edu.travelservices.common.DateCommon;
import com.fptu.edu.travelservices.dto.in.activities.ActivitiesAddNewInputDto;
import com.fptu.edu.travelservices.entity.Activities;
import com.fptu.edu.travelservices.repository.ActivitiesRepository;
import com.fptu.edu.travelservices.service.ActivitiesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivitiesImpl implements ActivitiesService {

    @Autowired
    private ActivitiesRepository activitiesRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DateCommon dateCommon;

    @Override
    public void addNewActivities(ActivitiesAddNewInputDto inputDto) {

        Activities activities = mapper.map(inputDto, Activities.class);
        activities.setCreateBy(inputDto.getUsername());
        activities.setUpdatedBy(inputDto.getUsername());
        activities.setCreateTime(dateCommon.getDate());
        activities.setUpdatedTime(dateCommon.getDate());

        /*insert activities in DB*/
        activitiesRepository.save(activities);
    }
}
