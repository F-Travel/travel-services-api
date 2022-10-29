package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.RoomRegisterInputDto;
import com.fptu.edu.travelservices.dto.out.room.RoomTypeDetailOutputDto;
import com.fptu.edu.travelservices.dto.out.room.RoomTypeGetListOutputDto;

import java.util.List;

public interface RoomTypeService {
    int saveRoom(RoomRegisterInputDto inputDto);

    List<RoomTypeGetListOutputDto> getListRoomType(int hotelId);

    RoomTypeDetailOutputDto getDetailRoomType(int id);
}
