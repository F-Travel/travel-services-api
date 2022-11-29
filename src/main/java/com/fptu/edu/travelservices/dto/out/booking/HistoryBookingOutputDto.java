package com.fptu.edu.travelservices.dto.out.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryBookingOutputDto {

    private String id;

    private String hotelName;

    private String image;

    private String address;

    private String bookingStatus;

    List<RoomBookingHistoryOutputDto> roomBookingHistory;

}
