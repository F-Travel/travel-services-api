package com.fptu.edu.travelservices.dto.in.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRoomInputDto {

    private String checkIn;

    private String checkOut;

    private String totalPrice;

    private String userBooking;

    private String email;

    private String phone;

    private String userId;

    private String ownerId;

    private String[] roomTypeId;
}
