package com.fptu.edu.travelservices.controller.response.room;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomTypeDetailResponse {
    @JsonProperty("type_room_name")
    private String typeRoomName;

    @JsonProperty("room_area")
    private int roomArea;

    @JsonProperty("price")
    private float price;

    @JsonProperty("number_people")
    private int numberPeople;

    @JsonProperty("image")
    private String image;

    @JsonProperty("image1")
    private String image1;

    @JsonProperty("image2")
    private String image2;

    @JsonProperty("image3")
    private String image3;

    @JsonProperty("image4")
    private String image4;

    @JsonProperty("room_type_properties")
    List<RoomTypePropertiesResponse> roomTypeProperties;
}
