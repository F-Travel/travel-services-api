package com.fptu.edu.travelservices.service.impl;

import com.fptu.edu.travelservices.dto.in.UserInputDto;
import com.fptu.edu.travelservices.dto.in.user.UserUpdateInputDto;
import com.fptu.edu.travelservices.dto.out.user.UserDetailOutputDto;
import com.fptu.edu.travelservices.dto.out.user.UserOutputDto;
import com.fptu.edu.travelservices.entity.User;
import com.fptu.edu.travelservices.exception.ResourceNotFoundException;
import com.fptu.edu.travelservices.repository.UserRepository;
import com.fptu.edu.travelservices.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    /*status lock account*/
    public static final String LOOK_ACCOUNT = "lock";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public UserOutputDto registerUser(UserInputDto inputDto) {
        return null;
    }

    @Override
    public List<UserOutputDto> getAllUsers() {

        /*get all list user*/
        List<User> users = userRepository.findAll();

        /*filter user activate*/
        List<UserOutputDto> userOutputDtos =  users.stream()
                .filter(item -> item
                        .getUserStatus().equals("activate"))
                            .map(user -> { UserOutputDto result = mapper
                                    .map(user, UserOutputDto.class);
                                    return result;
                            }).collect(Collectors.toList());

        return userOutputDtos;
    }

    @Override
    public UserDetailOutputDto getUserById(long id) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()){
            new ResourceNotFoundException("");
        }

        UserDetailOutputDto userOutputDto = new UserDetailOutputDto();
        userOutputDto.setId(user.get().getId().toString());
        userOutputDto.setFullName(user.get().getFullName());
        userOutputDto.setAddress(user.get().getAddress());
        userOutputDto.setEmail(user.get().getEmail());
        userOutputDto.setPhone(user.get().getPhone());
        userOutputDto.setAvatar(user.get().getAvatar());
        if (user.get().getBirthday() == null){
            userOutputDto.setBirthday("");
        } else{
            userOutputDto.setBirthday(df.format(user.get().getBirthday()));
        }

        return userOutputDto;
    }

    @Override
    public void updateUser(UserUpdateInputDto inputDto, long id) {
        /*save info user updated*/
        userRepository.updateUser(inputDto.getFullName(),inputDto.getAddress(),
                inputDto.getPhone(), inputDto.getBirthday(), inputDto.getAvatar(), id);
    }

    @Override
    public void deleteUser(long id) {
        /*lock account*/
        userRepository.deleteUser(LOOK_ACCOUNT, id);
    }
}
