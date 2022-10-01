package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.controller.response.GetAllUserResponse;
import com.fptu.edu.travelservices.dto.out.UserOutputDto;
import com.fptu.edu.travelservices.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<GetAllUserResponse>> getAllUser(){
        //get all list user
        List<UserOutputDto> outputDto = userService.getAllUsers();

        //mapper
        Type listType = new TypeToken<List<GetAllUserResponse>>(){}.getType();
        List<GetAllUserResponse> userResponses = mapper.map(outputDto , listType);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userResponses);
    }
}
