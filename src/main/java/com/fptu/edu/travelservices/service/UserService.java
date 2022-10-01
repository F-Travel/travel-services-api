package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.UserInputDto;
import com.fptu.edu.travelservices.dto.out.UserOutputDto;

import java.util.List;

public interface UserService {
    UserOutputDto registerUser(UserInputDto inputDto);

    List<UserOutputDto> getAllUsers();

    UserOutputDto getEmployeeById(long id);

    UserOutputDto updateUser(UserInputDto employee, long id);

    void deleteUser(long id);
}
