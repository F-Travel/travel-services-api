package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.HotelRegisterInputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelGetListOutputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelDetailOutputDto;

import java.util.List;

public interface HotelService {
    int saveHotel(HotelRegisterInputDto inputDto);

    List<HotelGetListOutputDto> getHotels();

    List<HotelGetListOutputDto> searchHotels(String param);

    HotelDetailOutputDto getDetailHotel(int id);
}
