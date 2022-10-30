package com.fptu.edu.travelservices.controller.request.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRegisterRequest {

    private String typeRoomName;

    private String price;

    private String numberPeople;

    private String roomArea;

    private String image;

    private String image1;

    private String image2;

    private String image3;

    private String image4;

    private String hotelId;

    List<RoomPropertiesRequest> properties;
}
