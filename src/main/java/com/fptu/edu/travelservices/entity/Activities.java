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
@Table(name = "Activities")
public class Activities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NameActivities")
    private String nameActivities;

    @Column(name = "Title")
    private String title;

    @Column(name = "Image")
    private String image;

    @Column(name = "Image1")
    private String image1;

    @Column(name = "Image2")
    private String image2;

    @Column(name = "StartTime")
    private String startTime;

    @Column(name = "endTime")
    private String endTime;

    @Column(name = "Description")
    private String description;

    @Column(name = "Description1")
    private String description1;

    @Column(name = "Description2")
    private String description2;

    @Column(name = "Latitude")
    private String latitude;

    @Column(name = "Longitude")
    private String longitude;

    @Column(name = "CreateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "CreateBy")
    private String createBy;

    @Column(name = "UpdatedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;

    @Column(name = "UpdatedBy")
    private String updatedBy;
}
