package com.fptu.edu.travelservices.controller.request.hotel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelPropertiesRequest {

    @JsonProperty(value = "properties_type_id")
    private String propertiesTypeId;

    @JsonProperty(value = "properties_type")
    private String propertiesType;
}
