package com.fptu.edu.travelservices.controller.request.room;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomPropertiesRequest {

    @JsonProperty(value = "properties_type_id")
    private String propertiesTypeId;

    @JsonProperty(value = "properties_name")
    private String propertiesName;
}
