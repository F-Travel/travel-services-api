package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.controller.response.activities.ActivitieSuggestionResponse;
import com.fptu.edu.travelservices.controller.response.home.CityGetListResponse;
import com.fptu.edu.travelservices.controller.response.home.CityTopSixResponse;
import com.fptu.edu.travelservices.dto.out.activities.ActivitieSuggestionOutputDto;
import com.fptu.edu.travelservices.dto.out.home.CityGetListOutputDto;
import com.fptu.edu.travelservices.service.ActivitiesService;
import com.fptu.edu.travelservices.service.CityService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CityService cityService;

    @Autowired
    private ActivitiesService activitiesService;

    @GetMapping("/list-city")
    public ResponseEntity<?> getListCity() {

        /*get list city*/
        List<CityGetListOutputDto> outputDtos = cityService.getListCity();

        Type listType = new TypeToken<List<CityGetListResponse>>(){}.getType();
        List<CityGetListResponse> cityListResponses = mapper.map(outputDtos , listType);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cityListResponses);
    }

    @GetMapping("/top-city")
    public ResponseEntity<?> getTopCity() {

        /*get list city*/
        List<CityGetListOutputDto> outputDtos = cityService.getTopListCity();

        Type listType = new TypeToken<List<CityTopSixResponse>>(){}.getType();
        List<CityTopSixResponse> cityTopSixResponses = mapper.map(outputDtos , listType);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(cityTopSixResponses);
    }

    @GetMapping("/suggest-event")
    public ResponseEntity<?> getSuggestEvent() {

        /*get list city*/
        List<ActivitieSuggestionOutputDto> outputDtos = activitiesService.getSuggestionActivities();

        Type listType = new TypeToken<List<ActivitieSuggestionResponse>>(){}.getType();
        List<ActivitieSuggestionResponse> suggestionResponses = mapper.map(outputDtos , listType);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(suggestionResponses);
    }

    @GetMapping("/suggest-hotel")
    public ResponseEntity<?> getSuggestHotel() {

        /*get list city*/
        List<CityGetListOutputDto> outputDtos = cityService.getListCity();

        Type listType = new TypeToken<List<CityGetListResponse>>(){}.getType();
        List<CityGetListResponse> cityListResponses = mapper.map(outputDtos , listType);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(null);
    }

}
