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
@Table(name = "Room_Type")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TypeRoomName")
    private String typeRoomName;

    @Column(name = "RoomArea")
    private int roomArea;

    @Column(name = "Image")
    private String Image;

    @Column(name = "Image1")
    private String Image1;

    @Column(name = "Image2")
    private String Image2;

    @Column(name = "Image3")
    private String Image3;

    @Column(name = "Image4")
    private String Image4;

    @Column(name = "Price")
    private float price;

    @Column(name = "NumberPeople")
    private int numberPeople;

    @Column(name = "HotelId")
    private int hotelId;

    @Column(name = "CreateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "UpdatedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;

    @Column(name = "UpdatedBy")
    private String updatedBy;
}
