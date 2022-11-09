package com.fptu.edu.travelservices.dto.out.hotel;

import com.fptu.edu.travelservices.dto.out.feedback.FeedBackOutputDto;
import com.fptu.edu.travelservices.dto.out.room.RoomTypeGetListOutputDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelDetailOutputDto {
    private String hotelName;

    private String description;

    private String phone;

    private String image;

    private String image1;

    private String image2;

    private String image3;

    private String image4;

    private String address;

    private String latitude;

    private String longitude;

    private String checkInTime;

    private String checkOutTime;

    private String isPaymentCard;

    private List<FeedBackOutputDto> feedBacks;

    private List<HotelPropertiesOutputDto> hotelProperties;

    private List<RoomTypeGetListOutputDto> roomTypes;
}
