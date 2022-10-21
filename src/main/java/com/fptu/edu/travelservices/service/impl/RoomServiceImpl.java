package com.fptu.edu.travelservices.service.impl;

import com.fptu.edu.travelservices.common.DateCommon;
import com.fptu.edu.travelservices.dto.in.RoomPropertiesInputDto;
import com.fptu.edu.travelservices.dto.in.RoomRegisterInputDto;
import com.fptu.edu.travelservices.entity.Room;
import com.fptu.edu.travelservices.entity.RoomProperties;
import com.fptu.edu.travelservices.repository.RoomPropertiesRepository;
import com.fptu.edu.travelservices.repository.RoomRepository;
import com.fptu.edu.travelservices.service.RoomService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomPropertiesRepository roomPropertiesRepository;

    @Autowired
    private DateCommon dateCommon;

    @Override
    public void saveRoom(RoomRegisterInputDto inputDto) {
        Room room = mapper.map(inputDto, Room.class);
        room.setCreatedBy("User");
        room.setCreateTime(dateCommon.getDate());
        room.setUpdatedBy("User");
        room.setUpdatedTime(dateCommon.getDate());
        roomRepository.save(room);

        int roomId = roomRepository.getFistId();

        insertRoomProperties(inputDto.getProperties(),roomId);
    }

    private void insertRoomProperties(final List<RoomPropertiesInputDto> roomProperties,final int roomId){
        //check list empaty

        roomProperties.stream().map(r -> {
            RoomProperties properties  = new RoomProperties();
            properties.setPropertiesId(r.getPropertiesId());
            properties.setPropertyName(r.getPropertiesName());
            properties.setRoomId(roomId);
            properties.setCreatedBy("User");
            properties.setCreateTime(dateCommon.getDate());
            properties.setUpdatedBy("User");
            properties.setUpdatedTime(dateCommon.getDate());
            roomPropertiesRepository.save(properties);
            return properties;
        }).collect(Collectors.toList());
    }

}
