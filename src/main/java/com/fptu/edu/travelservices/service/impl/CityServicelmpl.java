package com.fptu.edu.travelservices.service.impl;

import com.fptu.edu.travelservices.dto.out.home.CityGetListOutputDto;
import com.fptu.edu.travelservices.dto.result.CityTopList;
import com.fptu.edu.travelservices.entity.City;
import com.fptu.edu.travelservices.repository.CityRepository;
import com.fptu.edu.travelservices.service.CityService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class CityServicelmpl implements CityService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CityGetListOutputDto> getListCity() {

        /*find all list city in DB*/
        List<City> cities = cityRepository.findAll();

        Type listType = new TypeToken<List<CityGetListOutputDto>>(){}.getType();
        List<CityGetListOutputDto> cityOutputDtos = mapper.map(cities , listType);

        return cityOutputDtos;
    }

    @Override
    public List<CityGetListOutputDto> getTopListCity() {

        List<CityTopList> topSixCity = cityRepository.getTopListCity();

        Type listType = new TypeToken<List<CityGetListOutputDto>>(){}.getType();
        List<CityGetListOutputDto> cityTopSixCity = mapper.map(topSixCity , listType);

        return cityTopSixCity;
    }
}
