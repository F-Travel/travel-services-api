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
@Table(name = "HotelSurroundings")
public class HotelSurroundings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SurroundingNm")
    private String surroundingNm;

    @Column(name = "Latitude")
    private String latitude;

    @Column(name = "Longitude")
    private String longitude;

    @Column(name = "SurroundingTypeId")
    private String surroundingTypeId;

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
