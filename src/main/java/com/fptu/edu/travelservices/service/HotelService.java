package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.HotelRegisterInputDto;
import com.fptu.edu.travelservices.dto.out.GetListHotelOutputDto;

import java.util.List;

public interface HotelService {
    void saveHotel(HotelRegisterInputDto inputDto);

    List<GetListHotelOutputDto> getHotels();
}
