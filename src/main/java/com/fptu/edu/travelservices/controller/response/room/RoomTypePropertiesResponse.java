package com.fptu.edu.travelservices.controller.response.room;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomTypePropertiesResponse {
    @JsonProperty("properties_name")
    private String propertiesName;

    @JsonProperty("properties_type_name")
    private String propertiesTypeName;
}
