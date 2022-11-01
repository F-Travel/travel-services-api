package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.controller.request.booking.BookingRoomRequest;
import com.fptu.edu.travelservices.controller.response.booking.BookingRoomGetListResponse;
import com.fptu.edu.travelservices.dto.in.booking.BookingRoomInputDto;
import com.fptu.edu.travelservices.dto.out.booking.BookingRoomListOutputDto;
import com.fptu.edu.travelservices.service.BookingService;
import com.fptu.edu.travelservices.service.impl.EmailSenderService;
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
public class BookingController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private EmailSenderService senderService;

    @PostMapping("/booking/add-new")
    public ResponseEntity<?> createRequestBooking(@RequestBody BookingRoomRequest request) {

        BookingRoomInputDto bookingRoomInputDto = mapper.map(request, BookingRoomInputDto.class);

        /*call hotel service register hotel info*/
        int bookingId =  bookingService.saveRequestBooking(bookingRoomInputDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookingId);
    }

    @GetMapping("/booking/list-request/{roomId}")
    public ResponseEntity<?> getListRequestBooking(@PathVariable String roomId) {

        int id = Integer.parseInt(roomId);

        /*search list hotel*/
        List<BookingRoomListOutputDto> outputDtos = bookingService.getListBooking(id);

        Type listType = new TypeToken<List<BookingRoomGetListResponse>>(){}.getType();
        List<BookingRoomGetListResponse> bookingResponses = mapper.map(outputDtos , listType);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookingResponses);
    }

    @PutMapping("/booking/approve/{bookingId}")
    public ResponseEntity<?> approveBooking(@PathVariable String bookingId) {

        int id = Integer.parseInt(bookingId);

        bookingService.approveBooking(id);

        senderService.sendSimpleEmail("nguyentanhuy2711@gmail.com",
                "tessaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/booking/reject/{bookingId}")
    public ResponseEntity<?> rejectBooking(@PathVariable String bookingId) {

        int id = Integer.parseInt(bookingId);

        bookingService.rejectBooking(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
