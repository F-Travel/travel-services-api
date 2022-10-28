package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.HotelRegisterInputDto;
import com.fptu.edu.travelservices.dto.out.GetListHotelOutputDto;
import com.fptu.edu.travelservices.dto.out.HotelDetailOutputDto;
import com.fptu.edu.travelservices.entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    int saveHotel(HotelRegisterInputDto inputDto);

    List<GetListHotelOutputDto> getHotels();

    List<GetListHotelOutputDto> searchHotels(String param);

    HotelDetailOutputDto getDetailHotel(int id);
}
