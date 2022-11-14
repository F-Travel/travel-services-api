package com.fptu.edu.travelservices.dto.out.home;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityGetListOutputDto {

    private String id;

    private String cityName;

    private String province;

    private String cityImage;
}
