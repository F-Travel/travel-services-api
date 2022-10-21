package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.controller.request.RoomRegisterRequest;
import com.fptu.edu.travelservices.dto.in.RoomRegisterInputDto;
import com.fptu.edu.travelservices.service.RoomService;
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
    private RoomService roomService;

    @PostMapping("/room-register")
    public ResponseEntity<?> registerRoom(@RequestBody RoomRegisterRequest request) {

        //mapping form request register hotel
        RoomRegisterInputDto inputDto = mapper.map(request, RoomRegisterInputDto.class);

        roomService.saveRoom(inputDto);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
