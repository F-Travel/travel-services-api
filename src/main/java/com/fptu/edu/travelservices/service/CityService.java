package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.out.home.CityGetListOutputDto;

import java.util.List;

public interface CityService {

    List<CityGetListOutputDto> getListCity();

    List<CityGetListOutputDto> getTopListCity();
}
