package com.fptu.edu.travelservices.service.impl;

import com.fptu.edu.travelservices.common.DateCommon;
import com.fptu.edu.travelservices.dto.result.RoomPropertiesList;
import com.fptu.edu.travelservices.dto.result.RoomTypeList;
import com.fptu.edu.travelservices.dto.in.room.RoomPropertiesInputDto;
import com.fptu.edu.travelservices.dto.in.room.RoomRegisterInputDto;
import com.fptu.edu.travelservices.dto.out.room.RoomTypeDetailOutputDto;
import com.fptu.edu.travelservices.dto.out.room.RoomTypeGetListOutputDto;
import com.fptu.edu.travelservices.dto.out.room.RoomTypePropertiesOutputDto;
import com.fptu.edu.travelservices.entity.RoomType;
import com.fptu.edu.travelservices.entity.RoomProperties;
import com.fptu.edu.travelservices.repository.RoomPropertiesRepository;
import com.fptu.edu.travelservices.repository.RoomTypeRepository;
import com.fptu.edu.travelservices.service.RoomTypeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private RoomPropertiesRepository roomPropertiesRepository;

    @Autowired
    private DateCommon dateCommon;

    @Override
    public int saveRoom(RoomRegisterInputDto inputDto) {
        RoomType roomType = mapper.map(inputDto, RoomType.class);
        roomType.setPrice(Float.parseFloat(inputDto.getPrice()));
        roomType.setHotelId(Integer.parseInt(inputDto.getHotelId()));
        roomType.setCreatedBy("User");
        roomType.setCreateTime(dateCommon.getDate());
        roomType.setUpdatedBy("User");
        roomType.setUpdatedTime(dateCommon.getDate());
        roomTypeRepository.save(roomType);

        int roomId = roomTypeRepository.getFistId();

        /*insert list room properties*/
        insertRoomProperties(inputDto.getProperties(),roomId);

        return roomId;
    }

    @Override
    public List<RoomTypeGetListOutputDto> getListRoomType(int hotelId) {
        /*get list room type in DB*/
        List<RoomTypeList> roomTypes = roomTypeRepository.getListRoomType(hotelId);

        Type listType = new TypeToken<List<RoomTypeGetListOutputDto>>(){}.getType();
        List<RoomTypeGetListOutputDto> outputDtos = mapper.map(roomTypes , listType);

        return outputDtos;
    }

    @Override
    public RoomTypeDetailOutputDto getDetailRoomType(int id) {

        /*get detail room type in DB*/
        Optional<RoomType> roomType = roomTypeRepository.findById(id);

        RoomTypeDetailOutputDto outputDto = new RoomTypeDetailOutputDto();
        outputDto.setTypeRoomName(roomType.get().getTypeRoomName());
        outputDto.setRoomArea(roomType.get().getRoomArea());
        outputDto.setNumberPeople(roomType.get().getNumberPeople());
        outputDto.setPrice(roomType.get().getPrice());
        outputDto.setImage(roomType.get().getImage());
        outputDto.setImage1(roomType.get().getImage1());
        outputDto.setImage2(roomType.get().getImage2());
        outputDto.setImage3(roomType.get().getImage3());
        outputDto.setImage4(roomType.get().getImage4());

        /*get list room type properties in DB*/
        List<RoomPropertiesList> roomTypeLists = roomPropertiesRepository.getListRoomProperties(id);

        Type listType = new TypeToken<List<RoomTypePropertiesOutputDto>>(){}.getType();
        List<RoomTypePropertiesOutputDto> outputDtos = mapper.map(roomTypeLists , listType);

        outputDto.setRoomTypeProperties(outputDtos);

        return outputDto;
    }

    private void insertRoomProperties(final List<RoomPropertiesInputDto> roomProperties,final int roomId){

        roomProperties.stream().map(r -> {
            RoomProperties properties  = new RoomProperties();
            properties.setPropertiesTypeId(Integer.parseInt(r.getPropertiesTypeId()));
            properties.setPropertyName(r.getPropertiesName());
            properties.setRoomTypeId(roomId);
            properties.setCreatedBy("User");
            properties.setCreateTime(dateCommon.getDate());
            properties.setUpdatedBy("User");
            properties.setUpdatedTime(dateCommon.getDate());
            roomPropertiesRepository.save(properties);
            return properties;
        }).collect(Collectors.toList());
    }

}
