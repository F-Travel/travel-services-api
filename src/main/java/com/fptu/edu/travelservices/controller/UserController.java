package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.controller.request.user.UserUpdateRequest;
import com.fptu.edu.travelservices.controller.response.user.UserDetailResponse;
import com.fptu.edu.travelservices.controller.response.user.UserGetListResponse;
import com.fptu.edu.travelservices.dto.in.user.UserUpdateInputDto;
import com.fptu.edu.travelservices.dto.out.user.UserDetailOutputDto;
import com.fptu.edu.travelservices.dto.out.user.UserOutputDto;
import com.fptu.edu.travelservices.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> getAllUser(){
        /*get all list user activate*/
        List<UserOutputDto> outputDto = userService.getAllUsers();

        /*mapping data*/
        Type listType = new TypeToken<List<UserGetListResponse>>(){}.getType();
        List<UserGetListResponse> userResponses = mapper.map(outputDto , listType);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userResponses);
    }

    @GetMapping("/detail/{userId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> getUserInfoById(@PathVariable String userId) {

        Long id = Long.parseLong(userId);

        /*mapping form request register hotel*/
        UserDetailOutputDto outputDto = userService.getUserById(id);

        UserDetailResponse userDetailResponse = mapper.map(outputDto, UserDetailResponse.class);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userDetailResponse);
    }

    @PutMapping("/update/{userId}")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> updateUserById(@PathVariable String userId,
                                            @RequestBody UserUpdateRequest request) {

        Long id = Long.parseLong(userId);

        /*mapping data*/
        UserUpdateInputDto inputDto= mapper.map(request, UserUpdateInputDto.class);

        /*update user info*/
        userService.updateUser(inputDto, id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable String userId) {
        Long id = Long.parseLong(userId);

        /*lock account user*/
        userService.deleteUser(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
