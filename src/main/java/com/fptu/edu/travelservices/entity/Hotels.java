package com.fptu.edu.travelservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Hotels")
public class Hotels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hostelId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Address")
    private String address;

    @Column(name = "Street")
    private String street;

    @Column(name = "Province")
    private String province;

    @Column(name = "District")
    private String district;

    @Column(name = "City")
    private String city;

    @Column(name = "Latitude")
    private String latitude;

    @Column(name = "Longitude")
    private String longitude;

    @Column(name = "Price")
    private String phone;

    @Column(name = "Image")
    private String image;

    @Column(name = "Description")
    private String description;

    @Column(name = "Deposit")
    private String deposit;

    @Column(name = "Status")
    private String status;

    @Column(name = "OwnerId")
    private String ownerId;
}


