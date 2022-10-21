package com.fptu.edu.travelservices.controller;
import com.fptu.edu.travelservices.controller.request.HotelRegisterRequest;
import com.fptu.edu.travelservices.controller.response.GetAllUserResponse;
import com.fptu.edu.travelservices.controller.response.GetListHotelResponse;
import com.fptu.edu.travelservices.dto.in.HotelRegisterInputDto;
import com.fptu.edu.travelservices.dto.out.GetListHotelOutputDto;
import com.fptu.edu.travelservices.service.HotelService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class HotelController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private HotelService hotelService;

    @PostMapping("/hotel-register")
    public ResponseEntity<?> registerHotel(@RequestBody HotelRegisterRequest request) {

        //Mapping form request register hotel
        HotelRegisterInputDto hotelRegisterInputDto = mapper.map(request, HotelRegisterInputDto.class);

        // Create hotel
        hotelService.saveHotel(hotelRegisterInputDto);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/hotel-list")
    public ResponseEntity<?> getListHotel() {
        //mapping form request register hotel
        List<GetListHotelOutputDto> outInputDtos = hotelService.getHotels();

        //mapping hotel
        Type listType = new TypeToken<List<GetListHotelResponse>>(){}.getType();
        List<GetListHotelResponse> hotelResponses = mapper.map(outInputDtos , listType);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hotelResponses);
    }
}
