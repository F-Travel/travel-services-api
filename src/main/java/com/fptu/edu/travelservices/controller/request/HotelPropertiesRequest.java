package com.fptu.edu.travelservices.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelPropertiesRequest {
    private String propertiesTypeId;

    private String propertiesType;
}
