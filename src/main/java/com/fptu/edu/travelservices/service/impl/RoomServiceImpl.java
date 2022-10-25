package com.fptu.edu.travelservices.service.impl;

import com.fptu.edu.travelservices.common.DateCommon;
import com.fptu.edu.travelservices.dto.in.RoomPropertiesInputDto;
import com.fptu.edu.travelservices.dto.in.RoomRegisterInputDto;
import com.fptu.edu.travelservices.entity.Room_Type;
import com.fptu.edu.travelservices.entity.RoomProperties;
import com.fptu.edu.travelservices.repository.RoomPropertiesRepository;
import com.fptu.edu.travelservices.repository.RoomRepository;
import com.fptu.edu.travelservices.service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Room_Type room = mapper.map(inputDto, Room_Type.class);
        room.setPrice(Float.parseFloat(inputDto.getPrice()));
        room.setHotelId(Integer.parseInt(inputDto.getHotelId()));
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
