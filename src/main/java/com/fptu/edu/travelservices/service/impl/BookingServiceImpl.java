package com.fptu.edu.travelservices.service.impl;

import com.fptu.edu.travelservices.common.DateCommon;
import com.fptu.edu.travelservices.dto.result.BookingList;
import com.fptu.edu.travelservices.dto.in.booking.BookingRoomInputDto;
import com.fptu.edu.travelservices.dto.out.booking.BookingRoomListOutputDto;
import com.fptu.edu.travelservices.entity.Booking;
import com.fptu.edu.travelservices.entity.BookingRoom;
import com.fptu.edu.travelservices.exception.ResourceNotFoundException;
import com.fptu.edu.travelservices.repository.BookingRepository;
import com.fptu.edu.travelservices.repository.BookingRoomRepository;
import com.fptu.edu.travelservices.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    /*status waiting approve booking*/
    public static final String BOOKING_WAITING_APPROVE = "booking waiting approve";

    /*status approved booking*/
    public static final String BOOKING_APPROVED = "booking approved";

    /*status rejected booking*/
    public static final String BOOKING_REJECTED = "booking rejected";

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingRoomRepository bookingRoomRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DateCommon dateCommon;

    @Override
    public int saveRequestBooking(BookingRoomInputDto inputDto) {

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        Booking booking = new Booking();
        try {
            booking.setCheckIn(df.parse(inputDto.getCheckIn()));
            booking.setCheckOut(df.parse(inputDto.getCheckOut()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        booking.setUserBooking(inputDto.getUserBooking());
        booking.setEmail(inputDto.getEmail());
        booking.setTotalPrice(Float.parseFloat(inputDto.getTotalPrice()));
        booking.setPhone(Integer.parseInt(inputDto.getPhone()));
        if (inputDto.getUserId().isEmpty()){
            booking.setUserId(null);
        }else {
            booking.setUserId(Integer.parseInt(inputDto.getUserId()));
        }
        booking.setOwnerId(Integer.parseInt(inputDto.getOwnerId()));
        booking.setBookingStatus(BOOKING_WAITING_APPROVE);
        booking.setCreatedBy("User");
        booking.setCreateTime(dateCommon.getDate());
        booking.setUpdatedBy("User");
        booking.setUpdatedTime(dateCommon.getDate());

        bookingRepository.save(booking);

        int bookingId = bookingRepository.getFistIdBooking();

        saveRoomType(inputDto.getRoomTypeId(), bookingId);

        return bookingId;
    }

    @Override
    public List<BookingRoomListOutputDto> getListBooking(int hotelId) {

        /*get list request booking in DB*/
        List<BookingList> bookingLists = bookingRepository.getListBooking(hotelId);

        if (bookingLists.isEmpty()){
            new ResourceNotFoundException("");
        }

        Type listType = new TypeToken<List<BookingRoomListOutputDto>>(){}.getType();
        List<BookingRoomListOutputDto> bookingOutputDtos = mapper.map(bookingLists , listType);

        return bookingOutputDtos;
    }

    @Override
    public void approveBooking(int bookingId) {
        bookingRepository.updateStatusBooking(BOOKING_APPROVED, bookingId);
    }

    @Override
    public void rejectBooking(int bookingId) {
        bookingRepository.updateStatusBooking(BOOKING_REJECTED, bookingId);
    }

    private void saveRoomType(final String[] roomTypeIds , int bookingId){

        List<BookingRoom> bookingRooms =
                Arrays.stream(roomTypeIds).map(roomId -> {
                    BookingRoom bookingEntity = new BookingRoom();
                    bookingEntity.setBookingId(bookingId);
                    bookingEntity.setRoomId(Integer.parseInt(roomId));

                    bookingRoomRepository.save(bookingEntity);
                    return bookingEntity;
                }).collect(Collectors.toList());
    }
}
