package com.fptu.edu.travelservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "HotelName")
    private String hotelName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Image")
    private String image;

    @Column(name = "Image1")
    private String image1;

    @Column(name = "Image2")
    private String image2;

    @Column(name = "Image3")
    private String image3;

    @Column(name = "Image4")
    private String image4;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private Integer city;

    @Column(name = "Latitude")
    private String latitude;

    @Column(name = "Longitude")
    private String longitude;

    @Column(name = "StatusHotel")
    private String statusHotel;

    @Column(name = "CheckInTime")
    private String checkInTime;

    @Column(name = "CheckOutTime")
    private String checkOutTime;

    @Column(name = "IsPaymentCard")
    private Boolean isPaymentCard;

    @Column(name = "OwnerId")
    private long ownerId;

    @Column(name = "CreateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "UpdatedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;

    @Column(name = "UpdatedBy")
    private String UpdatedBy;
}


