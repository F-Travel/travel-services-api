package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.controller.request.RoomRegisterRequest;
import com.fptu.edu.travelservices.controller.response.room.RoomTypeDetailResponse;
import com.fptu.edu.travelservices.dto.in.RoomRegisterInputDto;
import com.fptu.edu.travelservices.dto.out.room.RoomTypeDetailOutputDto;
import com.fptu.edu.travelservices.service.RoomTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/")
public class RoomController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private RoomTypeService roomService;

    @PostMapping("/room-register")
    public ResponseEntity<?> registerRoom(@RequestBody RoomRegisterRequest request) {

        /*mapping form request register hotel*/
        RoomRegisterInputDto inputDto = mapper.map(request, RoomRegisterInputDto.class);

        int roomId = roomService.saveRoom(inputDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(roomId);
    }

    @GetMapping("/room-detail/{roomId}")
    public ResponseEntity<?> getRoomTypeDetail(@PathVariable String roomId) {

        int roomTypeId = Integer.parseInt(roomId);

        /*get room type detail in service*/
        RoomTypeDetailOutputDto roomTypeDetailOutputDto = roomService.getDetailRoomType(roomTypeId);

        RoomTypeDetailResponse roomTypeDetailResponse = mapper.map(roomTypeDetailOutputDto, RoomTypeDetailResponse.class);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(roomTypeDetailResponse);
    }
}
