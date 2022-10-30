package com.fptu.edu.travelservices.controller.request.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomPropertiesRequest {
    private String propertiesTypeId;

    private String propertiesName;
}
