package com.fptu.edu.travelservices.dto.in.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRegisterInputDto {

    private String typeRoomName;

    private String numberPeople;

    private String roomArea;

    private String image;

    private String image1;

    private String image2;

    private String image3;

    private String image4;

    private String price;

    private String hotelId;

    private List<RoomPropertiesInputDto> properties;
}
