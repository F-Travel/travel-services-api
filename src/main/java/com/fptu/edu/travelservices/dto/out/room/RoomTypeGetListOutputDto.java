package com.fptu.edu.travelservices.dto.out.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomTypeGetListOutputDto {
    private String roomTypeId;

    private String image;

    private String typeRoomName;

    private int roomArea;

    private float price;

    private int numberPeople;
}
