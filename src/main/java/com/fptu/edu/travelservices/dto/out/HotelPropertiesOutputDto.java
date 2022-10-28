package com.fptu.edu.travelservices.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelPropertiesOutputDto {
    private String propertiesType;

    private String propertiesTypeName;
}
