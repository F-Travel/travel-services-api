package com.fptu.edu.travelservices.dto.out;

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

    private List<FeedBackOutputDto> feedBack;

    private List<HotelPropertiesOutputDto> hotelProperties;
}
