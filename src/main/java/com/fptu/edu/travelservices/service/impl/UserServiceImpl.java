package com.fptu.edu.travelservices.service.impl;

import com.fptu.edu.travelservices.dto.in.UserInputDto;
import com.fptu.edu.travelservices.dto.out.UserOutputDto;
import com.fptu.edu.travelservices.entity.User;
import com.fptu.edu.travelservices.repository.UserRepository;
import com.fptu.edu.travelservices.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public UserOutputDto registerUser(UserInputDto inputDto) {
        return null;
    }

    @Override
    public List<UserOutputDto> getAllUsers() {

        List<User> users = userRepository.findAll();

        Type listType = new TypeToken<List<UserOutputDto>>(){}.getType();
        List<UserOutputDto> userOutputDtos = mapper.map(users , listType);

        return userOutputDtos;
    }

    @Override
    public UserOutputDto getEmployeeById(long id) {
        return null;
    }

    @Override
    public UserOutputDto updateUser(UserInputDto employee, long id) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }
}
