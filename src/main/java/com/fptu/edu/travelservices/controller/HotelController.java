package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.controller.request.HotelRegisterRequest;
import com.fptu.edu.travelservices.controller.response.hotel.HotelDetailResponse;
import com.fptu.edu.travelservices.controller.response.hotel.HotelGetListResponse;
import com.fptu.edu.travelservices.dto.in.HotelRegisterInputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelGetListOutputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelDetailOutputDto;
import com.fptu.edu.travelservices.service.HotelService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

        HotelRegisterInputDto hotelRegisterInputDto = mapper.map(request, HotelRegisterInputDto.class);

        /*call hotel service register hotel info*/
        int hotelRegister =  hotelService.saveHotel(hotelRegisterInputDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(hotelRegister);
    }

    @GetMapping("/hotel-list")
    public ResponseEntity<?> getListHotel() {

        /*mapping form request register hotel*/
        List<HotelGetListOutputDto> outInputDtos = hotelService.getHotels();

        Type listType = new TypeToken<List<HotelGetListResponse>>(){}.getType();
        List<HotelGetListResponse> hotelResponses = mapper.map(outInputDtos , listType);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hotelResponses);
    }

    @GetMapping("/hotel-search")
    public ResponseEntity<?> searchListHotel(@Param("param") String param) {

        /*search list hotel*/
        List<HotelGetListOutputDto> outputDtos = hotelService.searchHotels(param);

        //mapping hotel
        Type listType = new TypeToken<List<HotelGetListResponse>>(){}.getType();
        List<HotelGetListResponse> hotelResponses = mapper.map(outputDtos , listType);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hotelResponses);
    }

    @GetMapping("/hotel-detail/{hotelId}")
    public ResponseEntity<?> getDetailHotel(@PathVariable String hotelId) {

        int id = Integer.parseInt(hotelId);

        /*mapping form request register hotel*/
        HotelDetailOutputDto outputDtos = hotelService.getDetailHotel(id);

        HotelDetailResponse hotelResponses = mapper.map(outputDtos, HotelDetailResponse.class);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hotelResponses);
    }
}
