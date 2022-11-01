package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.booking.BookingRoomInputDto;
import com.fptu.edu.travelservices.dto.out.booking.BookingRoomListOutputDto;

import java.util.List;

public interface BookingService {

    int saveRequestBooking(BookingRoomInputDto inputDto);

    List<BookingRoomListOutputDto> getListBooking(int roomId);

    void approveBooking(int bookingId);

    void rejectBooking(int bookingId);
}
