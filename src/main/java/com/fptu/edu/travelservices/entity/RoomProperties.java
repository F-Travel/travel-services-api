package com.fptu.edu.travelservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RoomProperties")
public class RoomProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "PropertyName")
    private String propertyName;

    @Column(name = "Value")
    private String value;

    @Column(name = "Description")
    private String description;

    @Column(name = "RoomId")
    private String RoomsId;

    @Column(name = "PropertyId")
    private String RoomProperties;
}
