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
@Table(name = "RoomProperties")
public class RoomProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "RoomId")
    private int roomId;

    @Column(name = "PropertiesId")
    private String propertiesId;

    @Column(name = "PropertyName")
    private String propertyName;

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
