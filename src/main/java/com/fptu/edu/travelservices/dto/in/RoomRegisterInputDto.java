package com.fptu.edu.travelservices.dto.in;

import com.fptu.edu.travelservices.controller.request.RoomPropertiesRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomRegisterInputDto {

    private String typeRoom;

    private String description;

    private String price;

    private String numberPeople;

    private String area;

    private String image;

    private List<RoomPropertiesInputDto> properties;
}
