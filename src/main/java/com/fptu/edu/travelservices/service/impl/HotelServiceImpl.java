package com.fptu.edu.travelservices.service.impl;

import com.fptu.edu.travelservices.common.DateCommon;
import com.fptu.edu.travelservices.dto.in.hotel.HotelPropertiesInputDto;
import com.fptu.edu.travelservices.dto.in.hotel.HotelRegisterInputDto;
import com.fptu.edu.travelservices.dto.in.hotel.HotelUpdateInputDto;
import com.fptu.edu.travelservices.dto.out.feedback.FeedBackOutputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelDetailOutputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelGetListOutputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelListOutputDto;
import com.fptu.edu.travelservices.dto.out.hotel.HotelPropertiesOutputDto;
import com.fptu.edu.travelservices.dto.out.room.RoomTypeGetListOutputDto;
import com.fptu.edu.travelservices.dto.result.FeedBack;
import com.fptu.edu.travelservices.dto.result.HotelPropertiesList;
import com.fptu.edu.travelservices.dto.result.HotelSearch;
import com.fptu.edu.travelservices.dto.result.RoomTypeList;
import com.fptu.edu.travelservices.entity.Hotel;
import com.fptu.edu.travelservices.entity.HotelProperties;
import com.fptu.edu.travelservices.exception.ResourceNotFoundException;
import com.fptu.edu.travelservices.repository.FeedBackRepository;
import com.fptu.edu.travelservices.repository.HotelPropertiesRepository;
import com.fptu.edu.travelservices.repository.HotelRepository;
import com.fptu.edu.travelservices.repository.RoomTypeRepository;
import com.fptu.edu.travelservices.service.HotelService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    /*status hotel when begin register*/
    public static final String HOTEL_WAITING_APPROVE = "Waiting Approve";

    /*status hotel censored hotel*/
    public static final String CENSORED_HOTEL = "Censored Hotel";

    /*status hotel censored hotel*/
    public static final String DELETED_HOTEL = "Deleted Hotel";

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomTypeRepository roomRepository;

    @Autowired
    private HotelPropertiesRepository hotelPropertiesRepository;

    @Autowired
    private FeedBackRepository feedBackRepository;

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
    public int updateHotel(HotelUpdateInputDto i, int id) {
        hotelRepository.updateHotel(i.getHotelName(), i.getDescription(),i.getAddress(),i.getCityId(),
                i.getPhone(),i.getImage(), i.getImage1(), i.getImage2(),i.getImage3(), i.getImage4(),
                i.getLatitude(), i.getLongitude(), i.getIsPaymentCard(), i.getCheckOutTime(), i.getCheckInTime(), id);

        return 0;
    }

    @Override
    public List<HotelListOutputDto> getHotels() {
        /*get list hotel DB*/
        List<Hotel> hotels = hotelRepository.findAll();

        if(hotels.isEmpty()){
            new ResourceNotFoundException("");
        }

        Type listType = new TypeToken<List<HotelListOutputDto>>(){}.getType();
        List<HotelListOutputDto> hotelOutputDtos = mapper.map(hotels , listType);

        return hotelOutputDtos;
    }

    @Override
    public List<HotelListOutputDto> getHotelByOwnerId(long ownerId) {
        /*get list hotel DB*/
        List<Hotel> hotels = hotelRepository.findAll();

        if(hotels.isEmpty()){
            new ResourceNotFoundException("");
        }

        /*filter OwnerId*/
        List<HotelListOutputDto> outputDtos =  hotels.stream()
                .filter(item -> item.getOwnerId() == ownerId)
                .map(user -> { HotelListOutputDto result = mapper
                        .map(user, HotelListOutputDto.class);
                    return result;
                }).collect(Collectors.toList());

        return outputDtos;
    }

    @Override
    public List<HotelGetListOutputDto> searchHotels(String param) {

        List<HotelSearch> hotels = hotelRepository.searchHotel(param);

        if(hotels.isEmpty()){
            new ResourceNotFoundException("");
        }

        Type listType = new TypeToken<List<HotelGetListOutputDto>>(){}.getType();
        List<HotelGetListOutputDto> hotelOutputDtos = mapper.map(hotels , listType);

        return hotelOutputDtos;
    }

    @Override
    public List<HotelGetListOutputDto> getHotelsByCity(String cityId) {
        List<HotelSearch> hotels = hotelRepository.getHotelByCity(cityId);

        if(hotels.isEmpty()){
            new ResourceNotFoundException("");
        }

        Type listType = new TypeToken<List<HotelGetListOutputDto>>(){}.getType();
        List<HotelGetListOutputDto> hotelOutputDtos = mapper.map(hotels , listType);

        return hotelOutputDtos;
    }

    @Override
    public HotelDetailOutputDto getDetailHotel(int id) {

        int checkIdHotel = hotelRepository.getHotelId(id);
        if (checkIdHotel == 0){
            new ResourceNotFoundException("");
        }

        /*get hotel detail*/
        Optional<Hotel> hotels = hotelRepository.findById(id);

        HotelDetailOutputDto outputDto = HotelDetailOutputDto.builder()
                .hotelName(hotels.get().getHotelName())
                .description(hotels.get().getDescription())
                .phone(hotels.get().getPhone())
                .image(hotels.get().getImage())
                .image1(hotels.get().getImage1())
                .image2(hotels.get().getImage2())
                .image3(hotels.get().getImage3())
                .image4(hotels.get().getImage4())
                .address(hotels.get().getAddress())
                .checkOutTime(hotels.get().getCheckOutTime())
                .checkInTime(hotels.get().getCheckInTime())
                .latitude(String.valueOf(hotels.get().getLatitude()))
                .longitude(String.valueOf(hotels.get().getLongitude()))
                .isPaymentCard(String.valueOf(hotels.get().getIsPaymentCard()))
                .build();

        /*get properties hotel*/
        List<FeedBack> feedBacks = feedBackRepository.getListFeedBack(id);

        Type listTypeFeedback = new TypeToken<List<FeedBackOutputDto>>(){}.getType();
        List<FeedBackOutputDto> feedBackOutputDtos = mapper.map(feedBacks , listTypeFeedback);

        /*get properties hotel*/
        List<HotelPropertiesList> properties = hotelPropertiesRepository.getListHotelProperties(id);

        Type listTypeHotelProperties = new TypeToken<List<HotelPropertiesOutputDto>>(){}.getType();
        List<HotelPropertiesOutputDto> hotelPropertiesOutputDtos = mapper.map(properties , listTypeHotelProperties);

        /*get list room type in DB*/
        List<RoomTypeList> roomTypes = roomRepository.getListRoomType(id);

        Type listTypeRoom = new TypeToken<List<RoomTypeGetListOutputDto>>(){}.getType();
        List<RoomTypeGetListOutputDto> roomTypeOutputDtos = mapper.map(roomTypes , listTypeRoom);


        outputDto.setFeedBacks(feedBackOutputDtos);
        outputDto.setHotelProperties(hotelPropertiesOutputDtos);
        outputDto.setRoomTypes(roomTypeOutputDtos);

        return outputDto;
    }

    @Override
    public void deleteHotel(int id) {
        /*update status deleted hotel*/
        hotelRepository.updateStatusHotel(DELETED_HOTEL, id);
    }

    @Override
    public void approveHotel(int id) {
        /*update status censored hotel*/
        hotelRepository.updateStatusHotel(CENSORED_HOTEL, id);
    }

    @Override
    public List<HotelGetListOutputDto> getSuggestHotel(float latitudeIp, float longitudeIp) {
        List<Hotel> hotels = hotelRepository.findAll();

        double distance;

//        hotels.stream().filter(result -> distance =
//                Math.sqrt(Math.pow((latitudeIp - result.getLatitude()), 2) + Math.pow((longitudeIp - result.getLongitude()), 2)))
//                        .map(hotel -> {
//                            HotelGetListOutputDto outputDto = new HotelGetListOutputDto();
//
//                            return outputDto;
//                        }).findFirst().orElse(null);
        return null;
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
