package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.hotel.HotelRegisterInputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelGetListOutputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelDetailOutputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelListOutputDto;

import java.util.List;

public interface HotelService {
    int saveHotel(HotelRegisterInputDto inputDto);

    List<HotelListOutputDto> getHotels();

    List<HotelGetListOutputDto> searchHotels(String param);

    List<HotelGetListOutputDto> getHotelsByCity(String cityId);

    HotelDetailOutputDto getDetailHotel(int id);

    void deleteHotel(int id);

    void approveHotel(int id);

    List<HotelGetListOutputDto> getSuggestHotel(float latitudeIp, float longitudeIp);
}
