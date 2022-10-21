package com.fptu.edu.travelservices.service.impl;
import com.fptu.edu.travelservices.dto.in.HotelRegisterInputDto;
import com.fptu.edu.travelservices.dto.out.GetListHotelOutputDto;
import com.fptu.edu.travelservices.dto.out.UserOutputDto;
import com.fptu.edu.travelservices.entity.Hotels;
import com.fptu.edu.travelservices.repository.HotelRepository;
import com.fptu.edu.travelservices.service.HotelService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveHotel(HotelRegisterInputDto inputDto) {
        hotelRepository.createHotel(inputDto.getTitle(), inputDto.getAddress(), inputDto.getStreet(),
                inputDto.getProvince(), inputDto.getDistrict(), inputDto.getCity(), inputDto.getLatitude(),
                inputDto.getLongitude(), inputDto.getPhone(), inputDto.getImage(), inputDto.getOwnerId());
    }

    @Override
    public List<GetListHotelOutputDto> getHotels() {
        //get list hotel DB
        List<Hotels> hotels = hotelRepository.findAll();

        //mapping hotel
        Type listType = new TypeToken<List<GetListHotelOutputDto>>(){}.getType();
        List<GetListHotelOutputDto> hotelOutputDtos = mapper.map(hotels , listType);

        return hotelOutputDtos;
    }
}
