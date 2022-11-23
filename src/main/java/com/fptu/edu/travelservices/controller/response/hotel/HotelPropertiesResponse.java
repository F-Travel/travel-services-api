package com.fptu.edu.travelservices.controller.response.hotel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelPropertiesResponse {

    @JsonProperty("properties_type_id")
    private String propertiesTypeId;

    @JsonProperty("properties_type")
    private String propertiesType;

    @JsonProperty("properties_name")
    private String propertiesTypeName;
}
