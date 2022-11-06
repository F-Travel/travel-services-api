package com.fptu.edu.travelservices.controller.request.room;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRegisterRequest {

    @JsonProperty(value = "type_room_name")
    private String typeRoomName;

    @JsonProperty(value = "price")
    private String price;

    @JsonProperty(value = "number_people")
    private String numberPeople;

    @JsonProperty(value = "room_area")
    private String roomArea;

    @JsonProperty(value = "image")
    private String image;

    @JsonProperty(value = "image1")
    private String image1;

    @JsonProperty(value = "image2")
    private String image2;

    @JsonProperty(value = "image3")
    private String image3;

    @JsonProperty(value = "image4")
    private String image4;

    @JsonProperty(value = "hotel_id")
    private String hotelId;

    @JsonProperty(value = "properties")
    List<RoomPropertiesRequest> properties;
}
