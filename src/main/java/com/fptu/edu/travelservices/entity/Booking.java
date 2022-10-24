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
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CheckIn")
    private String checkIn;

    @Column(name = "CheckOut")
    private String checkOut;

    @Column(name = "DateBooking")
    private String DateBooking;

    @Column(name = "DateApproved")
    private String dateApproved;

    @Column(name = "RequestStatus")
    private Integer requestStatus;

    @Column(name = "UserId")
    private Integer userId;

    @Column(name = "OwnerId")
    private Integer ownerId;

    @Column(name = "RoomId")
    private Integer roomId;

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
