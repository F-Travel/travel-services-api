package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.controller.request.room.RoomRegisterRequest;
import com.fptu.edu.travelservices.controller.response.room.RoomTypeDetailResponse;
import com.fptu.edu.travelservices.dto.in.room.RoomRegisterInputDto;
import com.fptu.edu.travelservices.dto.out.room.RoomTypeDetailOutputDto;
import com.fptu.edu.travelservices.service.RoomTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/room")
public class RoomController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private RoomTypeService roomService;

    @PostMapping("/register")
    /*@PreAuthorize("hasRole('MODERATOR')")*/
    public ResponseEntity<?> registerRoom(@RequestBody RoomRegisterRequest request) {

        /*mapping form request register hotel*/
        RoomRegisterInputDto inputDto = mapper.map(request, RoomRegisterInputDto.class);

        int roomId = roomService.saveRoom(inputDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(roomId);
    }

    @GetMapping("/detail/{roomId}")
    /*@PreAuthorize("hasRole('MODERATOR')")*/
    public ResponseEntity<?> getRoomTypeDetail(@PathVariable String roomId) {

        int roomTypeId = Integer.parseInt(roomId);

        /*get room type detail in service*/
        RoomTypeDetailOutputDto roomTypeDetailOutputDto = roomService.getDetailRoomType(roomTypeId);

        RoomTypeDetailResponse roomTypeDetailResponse = mapper.map(roomTypeDetailOutputDto, RoomTypeDetailResponse.class);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(roomTypeDetailResponse);
    }

    @PutMapping("/update/{roomId}")
    /*@PreAuthorize("hasRole('MODERATOR')")*/
    public ResponseEntity<?> updateRoomType(@PathVariable String roomId,
                                            @RequestBody RoomRegisterRequest request) {
        //To do
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(null);
    }

    @DeleteMapping("/delete/{roomId}")
    /*@PreAuthorize("hasRole('MODERATOR')")*/
    public ResponseEntity<?> deleteRoomType(@PathVariable String roomId) {
        //To do
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(null);
    }
}
