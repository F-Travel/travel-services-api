package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.hotel.HotelRegisterInputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelGetListOutputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelDetailOutputDto;

import java.util.List;

public interface HotelService {
    int saveHotel(HotelRegisterInputDto inputDto);

    List<HotelGetListOutputDto> getHotels();

    List<HotelGetListOutputDto> searchHotels(String param);

    List<HotelGetListOutputDto> getHotelsByCity(String cityId);

    HotelDetailOutputDto getDetailHotel(int id);

    void deleteHotel(int id);

    void approveHotel(int id);
}
