package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.controller.request.activities.ActivitiesAddNewRequest;
import com.fptu.edu.travelservices.dto.in.activities.ActivitiesAddNewInputDto;
import com.fptu.edu.travelservices.service.ActivitiesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
