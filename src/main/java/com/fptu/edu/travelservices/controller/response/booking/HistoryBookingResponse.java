package com.fptu.edu.travelservices.controller.response.booking;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fptu.edu.travelservices.dto.out.booking.RoomBookingHistoryOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryBookingResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("hotel_name")
    private String hotelName;

    @JsonProperty("image")
    private String image;

    @JsonProperty("address")
    private String address;

    @JsonProperty("bookingStatus")
    private String bookingStatus;

    List<RoomBookingHistoryOutputDto> roomBookingHistory;
}
