package com.fptu.edu.travelservices.service.impl;

import com.fptu.edu.travelservices.common.DateCommon;
import com.fptu.edu.travelservices.dto.in.activities.ActivitiesAddNewInputDto;
import com.fptu.edu.travelservices.dto.out.activities.ActivitieSuggestionOutputDto;
import com.fptu.edu.travelservices.dto.out.activities.ActivitiesDetailOutputDto;
import com.fptu.edu.travelservices.dto.out.activities.ActivitiesListOutputDto;
import com.fptu.edu.travelservices.dto.out.bill.BillHistoryListOutputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelTopListOutputDto;
import com.fptu.edu.travelservices.dto.result.HotelTopList;
import com.fptu.edu.travelservices.entity.Activities;
import com.fptu.edu.travelservices.repository.ActivitiesRepository;
import com.fptu.edu.travelservices.repository.HotelRepository;
import com.fptu.edu.travelservices.service.ActivitiesService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActivitiesImpl implements ActivitiesService {

    @Autowired
    private ActivitiesRepository activitiesRepository;

    @Autowired
    private HotelRepository hotelRepository;

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

    @Override
    public List<ActivitieSuggestionOutputDto> getSuggestionActivities() {
        List<Activities> activities = activitiesRepository.findAll();

        /*filter OwnerId*/
        List<ActivitieSuggestionOutputDto> outputDtos =  activities.stream()
                .filter(item -> item.getId()<=9)
                .map(activiti -> { ActivitieSuggestionOutputDto result = mapper
                        .map(activiti, ActivitieSuggestionOutputDto.class);
                    return result;
                }).collect(Collectors.toList());

        return outputDtos;
    }

    @Override
    public ActivitiesDetailOutputDto getActivitiesDetail(int id) {
        Optional<Activities> hotels = activitiesRepository.findById(id);

        ActivitiesDetailOutputDto outputDto = new ActivitiesDetailOutputDto();
        outputDto.setNameActivities(hotels.get().getNameActivities());
        outputDto.setTitle(hotels.get().getTitle());
        outputDto.setImage(hotels.get().getImage());
        outputDto.setImage1(hotels.get().getImage1());
        outputDto.setImage2(hotels.get().getImage2());
        outputDto.setStartTime(hotels.get().getStartTime());
        outputDto.setEndTime(hotels.get().getEndTime());
        outputDto.setDescription(hotels.get().getDescription());
        outputDto.setDescription1(hotels.get().getDescription1());
        outputDto.setDescription1(hotels.get().getDescription1());
        outputDto.setLongitude(hotels.get().getLongitude());
        outputDto.setLatitude(hotels.get().getLatitude());
        outputDto.setUsername(hotels.get().getCreateBy());

        List<HotelTopList> hotelTopLists = hotelRepository.getHotelTopList();

        Type listType = new TypeToken<List<HotelTopListOutputDto>>(){}.getType();
        List<HotelTopListOutputDto> outputDtos = mapper.map(hotelTopLists , listType);

        outputDto.setHotelList(outputDtos);

        return outputDto;
    }

    @Override
    public List<ActivitiesListOutputDto> getListActivities() {

        List<Activities> activitiesList = activitiesRepository.findAll();

        Type listType = new TypeToken<List<ActivitiesListOutputDto>>(){}.getType();
        List<ActivitiesListOutputDto> outputDtos = mapper.map(activitiesList , listType);

        return outputDtos;
    }

    @Override
    public void deleteActivities(int id) {
        activitiesRepository.deleteById(id);
    }
}
