package com.fptu.edu.travelservices.dto.in.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomPropertiesInputDto {
    private String propertiesTypeId;

    private String propertiesName;
}
