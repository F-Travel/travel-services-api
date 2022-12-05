package com.fptu.edu.travelservices.dto.out.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRoomListOutputDto {

    private String id;

    private String roomName;

    private String checkIn;

    private String checkOut;

    private String userBooking;

    private String email;

    private String phone;

    private String totalPrice;

    private String dateBooking;

    private String paymentMethod;

    private String bookingStatus;
}
