package com.fptu.edu.travelservices.controller.response.booking;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRoomGetListResponse {

    @JsonProperty("room_name")
    private String roomName;

    @JsonProperty("check_in")
    private String checkIn;

    @JsonProperty("check_out")
    private String checkOut;

    @JsonProperty("user_booking")
    private String userBooking;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("total_price")
    private String totalPrice;

    @JsonProperty("date_booking")
    private String dateBooking;

    @JsonProperty("booking_status")
    private String bookingStatus;
}
