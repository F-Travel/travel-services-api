package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.controller.request.hotel.HotelRegisterRequest;
import com.fptu.edu.travelservices.controller.request.hotel.HotelUpdateRequest;
import com.fptu.edu.travelservices.controller.response.hotel.HotelDetailResponse;
import com.fptu.edu.travelservices.controller.response.hotel.HotelGetListResponse;
import com.fptu.edu.travelservices.controller.response.hotel.HotelListByOwnerIdResponse;
import com.fptu.edu.travelservices.controller.response.hotel.HotelListResponse;
import com.fptu.edu.travelservices.dto.in.hotel.HotelRegisterInputDto;
import com.fptu.edu.travelservices.dto.in.hotel.HotelUpdateInputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelGetListOutputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelDetailOutputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelListOutputDto;
import com.fptu.edu.travelservices.service.HotelService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private HotelService hotelService;

    @PreAuthorize("hasRole('MODERATOR')")
    @PostMapping("/register")
    public ResponseEntity<?> registerHotel(@RequestBody HotelRegisterRequest request) {

        HotelRegisterInputDto hotelRegisterInputDto = mapper.map(request, HotelRegisterInputDto.class);

        /*call hotel service register hotel info*/
        int hotelRegister =  hotelService.saveHotel(hotelRegisterInputDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(hotelRegister);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListHotel() {

        /*mapping form request register hotel*/
        List<HotelListOutputDto> outInputDtos = hotelService.getHotels();

        Type listType = new TypeToken<List<HotelListResponse>>(){}.getType();
        List<HotelListResponse> hotelResponses = mapper.map(outInputDtos , listType);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hotelResponses);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @GetMapping("/list-by-ownerId/{ownerId}")
    public ResponseEntity<?> getListHotelByHotelOwner(@PathVariable String ownerId) {

        long id =  Long.parseLong(ownerId);

        /*mapping form request register hotel*/
        List<HotelListOutputDto> outInputDtos = hotelService.getHotelByOwnerId(id);

        Type listType = new TypeToken<List<HotelListByOwnerIdResponse>>(){}.getType();
        List<HotelListByOwnerIdResponse> hotelResponses = mapper.map(outInputDtos , listType);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hotelResponses);
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchListHotel(@Param("param") String param) {

        /*search list hotel*/
        List<HotelGetListOutputDto> outputDtos = hotelService.searchHotels(param);

        /*mapping hotel*/
        Type listType = new TypeToken<List<HotelGetListResponse>>(){}.getType();
        List<HotelGetListResponse> hotelResponses = mapper.map(outputDtos , listType);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hotelResponses);
    }

    @GetMapping("/detail/{hotelId}")
    public ResponseEntity<?> getDetailHotel(@PathVariable String hotelId) {

        int id = Integer.parseInt(hotelId);

        /*mapping form request register hotel*/
        HotelDetailOutputDto outputDtos = hotelService.getDetailHotel(id);

        HotelDetailResponse hotelResponses = mapper.map(outputDtos, HotelDetailResponse.class);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hotelResponses);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @PutMapping("/update/{hotelId}")
    public ResponseEntity<?> updateHotel(@PathVariable String hotelId,
                                         @RequestBody HotelUpdateRequest request) {

        int id = Integer.parseInt(hotelId);

        HotelUpdateInputDto inputDto = mapper.map(request , HotelUpdateInputDto.class);

        int i =  hotelService.updateHotel(inputDto, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(null);
    }

    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    @DeleteMapping("/delete/{hotelId}")
    public ResponseEntity<?> deleteHotel(@PathVariable String hotelId) {

        int id = Integer.parseInt(hotelId);

        /*delete hotel*/
        hotelService.deleteHotel(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/approve/{hotelId}")
    public ResponseEntity<?> approveHotel(@PathVariable String hotelId) {

        int id = Integer.parseInt(hotelId);

        /*approved hotel*/
        hotelService.approveHotel(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<?> getListHotelByCity(@PathVariable String cityId) {

        /*search list hotel*/
        List<HotelGetListOutputDto> outputDtos = hotelService.getHotelsByCity(cityId);

        /*mapping hotel*/
        Type listType = new TypeToken<List<HotelGetListResponse>>(){}.getType();
        List<HotelGetListResponse> hotelResponses = mapper.map(outputDtos , listType);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(hotelResponses);
    }

}
