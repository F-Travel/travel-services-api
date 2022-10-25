package com.fptu.edu.travelservices.service.impl;

import com.fptu.edu.travelservices.common.DateCommon;
import com.fptu.edu.travelservices.dto.in.HotelPropertiesInputDto;
import com.fptu.edu.travelservices.dto.in.HotelRegisterInputDto;
import com.fptu.edu.travelservices.dto.out.GetListHotelOutputDto;
import com.fptu.edu.travelservices.entity.Hotel;
import com.fptu.edu.travelservices.entity.HotelProperties;
import com.fptu.edu.travelservices.repository.HotelPropertiesRepository;
import com.fptu.edu.travelservices.repository.HotelRepository;
import com.fptu.edu.travelservices.service.HotelService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    /*status hotel when begin register*/
    public static final String HOTEL_WAITING_APPROVE = "Waiting Approve";

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private HotelPropertiesRepository hotelPropertiesRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DateCommon dateCommon;

    @Override
    public int saveHotel(HotelRegisterInputDto inputDto) {

        /*mapping data hotel entity*/
        Hotel hotel = mapper.map(inputDto, Hotel.class);
        hotel.setLatitude(Float.parseFloat(inputDto.getLatitude()));
        hotel.setLongitude(Float.parseFloat(inputDto.getLongitude()));
        hotel.setCityId(Integer.parseInt(inputDto.getCityId()));
        hotel.setIsPaymentCard(Boolean.parseBoolean(inputDto.getIsPaymentCard()));
        hotel.setOwnerId(Long.parseLong(inputDto.getOwnerId()));
        hotel.setStatusHotel(HOTEL_WAITING_APPROVE);
        hotel.setCreatedBy("User");
        hotel.setCreateTime(dateCommon.getDate());
        hotel.setUpdatedBy("User");
        hotel.setUpdatedTime(dateCommon.getDate());

        /*save info hotel*/
        hotelRepository.save(hotel);

        /*get hotelId*/
        int hotelId = hotelRepository.getFistIdHotel();

        /*save info hotel properties*/
        saveHotelProperties(inputDto.getHotelProperties(), hotelId);

        return hotelId;
    }

    @Override
    public List<GetListHotelOutputDto> getHotels() {
        //get list hotel DB
        List<Hotel> hotels = hotelRepository.findAll();

        //mapping hotel
        Type listType = new TypeToken<List<GetListHotelOutputDto>>(){}.getType();
        List<GetListHotelOutputDto> hotelOutputDtos = mapper.map(hotels , listType);

        return hotelOutputDtos;
    }

    private void saveHotelProperties(final List<HotelPropertiesInputDto> hotelPropertiesInputDtos, final int hotelId){

        hotelPropertiesInputDtos.stream().map(r -> {
            HotelProperties properties  = new HotelProperties();
            properties.setPropertiesTypeId(Integer.parseInt(r.getPropertiesTypeId()));
            properties.setPropertiesType(r.getPropertiesType());
            properties.setHotelId(hotelId);
            properties.setCreatedBy("User");
            properties.setCreateTime(dateCommon.getDate());
            properties.setUpdatedBy("User");
            properties.setUpdatedTime(dateCommon.getDate());

            /*save hotel property*/
            hotelPropertiesRepository.save(properties);
            return properties;
        }).collect(Collectors.toList());
    }
}
