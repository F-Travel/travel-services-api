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
@Table(name = "Bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PaymentMethod")
    private String paymentMethod;

    @Column(name = "TotalAmount")
    private float totalAmount;

    @Column(name = "isBooking")
    private String isBooking;

    @Column(name = "DateBooking")
    private String dateBooking;

    @Column(name = "PaymentStatus")
    private String paymentStatus;

    @Column(name = "PaymentDate")
    private String paymentDate;

    @Column(name = "ExternalInvoice")
    private String ExternalInvoice;

    @Column(name = "ExternalTransaction")
    private String ExternalTransaction;

    @Column(name = "BookingId")
    private String BookingId;

    @Column(name = "UserId")
    private String UserId;

    @Column(name = "OwnerId")
    private String ownerId;

    @Column(name = "RoomId")
    private String roomId;

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
