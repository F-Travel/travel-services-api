package com.fptu.edu.travelservices.dto.in.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelPropertiesInputDto {
    private String propertiesTypeId;

    private String propertiesType;
}
