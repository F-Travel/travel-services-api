package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.controller.request.activities.ActivitiesAddNewRequest;
import com.fptu.edu.travelservices.controller.response.activities.ActivitiesDetailResponse;
import com.fptu.edu.travelservices.controller.response.activities.ActivitiesListResponse;
import com.fptu.edu.travelservices.controller.response.hotel.HotelGetListResponse;
import com.fptu.edu.travelservices.dto.in.activities.ActivitiesAddNewInputDto;
import com.fptu.edu.travelservices.dto.out.activities.ActivitiesDetailOutputDto;
import com.fptu.edu.travelservices.dto.out.activities.ActivitiesListOutputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelGetListOutputDto;
import com.fptu.edu.travelservices.service.ActivitiesService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/activities")
public class ActivitiesController {

    @Autowired
    private ActivitiesService activitiesService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/add-new")
    /*@PreAuthorize("hasRole('MODERATOR')")*/
    public ResponseEntity<?> createActivities(@RequestBody ActivitiesAddNewRequest request) {

        ActivitiesAddNewInputDto inputDto = mapper.map(request, ActivitiesAddNewInputDto.class);

        /*call hotel service register hotel info*/
        activitiesService.addNewActivities(inputDto);

        return ResponseEntity
                .status(HttpStatus.CREATED).build();
    }

    @GetMapping("/detail/{activitiesId}")
    /*@PreAuthorize("hasRole('MODERATOR')")*/
    public ResponseEntity<?> getDetailActivities(@PathVariable String activitiesId) {

        int id = Integer.parseInt(activitiesId);

        /*activities detail*/
        ActivitiesDetailOutputDto outputDtos = activitiesService.getActivitiesDetail(id);

        ActivitiesDetailResponse response = mapper.map(outputDtos, ActivitiesDetailResponse.class);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListActivities() {

        /*get list Activities*/
        List<ActivitiesListOutputDto> outputDtos = activitiesService.getListActivities();

        /*mapping hotel*/
        Type listType = new TypeToken<List<ActivitiesListResponse>>(){}.getType();
        List<ActivitiesListResponse> responses = mapper.map(outputDtos , listType);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responses);
    }

    @GetMapping("/delete/{activitiesId}")
    /*@PreAuthorize("hasRole('MODERATOR')")*/
    public ResponseEntity<?> deleteActivities(@PathVariable String activitiesId) {

        /*get list Activities*/
        int id = Integer.parseInt(activitiesId);

        activitiesService.deleteActivities(id);

        return ResponseEntity
                .status(HttpStatus.OK).build();
    }

}
