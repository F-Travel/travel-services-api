package com.fptu.edu.travelservices.controller.response.home;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityTopSixResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("city_image")
    private String cityImage;
}
