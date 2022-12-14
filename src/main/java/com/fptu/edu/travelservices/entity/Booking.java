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
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkIn;

    @Column(name = "CheckOut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;

    @Column(name = "TotalPrice")
    private float totalPrice;

    @Column(name = "userBooking")
    private String userBooking;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private int phone;

    @Column(name = "DateApproved")
    private String dateApproved;

    @Column(name = "BookingStatus")
    private String bookingStatus;

    @Column(name = "UserId")
    private Integer userId;

    @Column(name = "OwnerId")
    private Integer ownerId;

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
