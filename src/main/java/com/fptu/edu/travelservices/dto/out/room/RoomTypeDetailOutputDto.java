package com.fptu.edu.travelservices.dto.out.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomTypeDetailOutputDto {
    private String typeRoomName;

    private int roomArea;

    private float price;

    private int numberPeople;

    private String image;

    private String image1;

    private String image2;

    private String image3;

    private String image4;

    List<RoomTypePropertiesOutputDto> roomTypeProperties;
}
