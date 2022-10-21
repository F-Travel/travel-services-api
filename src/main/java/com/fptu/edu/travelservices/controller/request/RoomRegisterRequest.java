package com.fptu.edu.travelservices.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRegisterRequest {

    private String typeRoom;

    private String description;

    private String price;

    private String numberPeople;

    private String area;

    private String image;

    List<RoomPropertiesRequest> properties;
}
