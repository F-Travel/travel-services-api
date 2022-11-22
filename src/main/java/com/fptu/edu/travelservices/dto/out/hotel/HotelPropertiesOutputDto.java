package com.fptu.edu.travelservices.dto.out.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelPropertiesOutputDto {

    private String propertiesTypeId;

    private String propertiesType;

    private String propertiesTypeName;
}
