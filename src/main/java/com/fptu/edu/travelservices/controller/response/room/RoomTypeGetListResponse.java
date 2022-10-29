package com.fptu.edu.travelservices.controller.response.room;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomTypeGetListResponse {
    @JsonProperty("room_type_id")
    private String roomTypeId;

    @JsonProperty("type_room_name")
    private String typeRoomName;

    @JsonProperty("room_area")
    private int roomArea;

    @JsonProperty("price")
    private float price;

    @JsonProperty("number_people")
    private int numberPeople;
}
