package com.fptu.edu.travelservices.controller.request.booking;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRoomRequest {

    @JsonProperty(value = "check_in")
    private String checkIn;

    @JsonProperty(value = "check_out")
    private String checkOut;

    @JsonProperty(value = "total_price")
    private String totalPrice;

    @JsonProperty(value = "full_name")
    private String full_name;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "phone")
    private String phone;

    @JsonProperty(value = "user_id")
    private String userId;

    @JsonProperty(value = "room_type_id")
    private List[] roomTypeId;
}
