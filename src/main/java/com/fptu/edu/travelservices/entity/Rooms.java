package com.fptu.edu.travelservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "ImageJson")
    private String imageJson;

    @Column(name = "IsBooked")
    private String isBooked;

    @Column(name = "HostelId")
    private String hostelId;

    @Column(name = "RoomTypeId")
    private String roomTypeId ;
}