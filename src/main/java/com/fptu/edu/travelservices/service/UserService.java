package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.UserInputDto;
import com.fptu.edu.travelservices.dto.in.user.UserUpdateInputDto;
import com.fptu.edu.travelservices.dto.out.user.UserDetailOutputDto;
import com.fptu.edu.travelservices.dto.out.user.UserOutputDto;

import java.util.List;

public interface UserService {

    UserOutputDto registerUser(UserInputDto inputDto);

    List<UserOutputDto> getAllUsers();

    UserDetailOutputDto getUserById(long id);

    void updateUser(UserUpdateInputDto inputDto, long id);

    void deleteUser(long id);
}
