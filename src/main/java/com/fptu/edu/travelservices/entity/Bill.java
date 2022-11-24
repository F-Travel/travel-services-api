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

    @Column(name = "StatusBill")
    private String statusBill;

    @Column(name = "ExternalInvoice")
    private String externalInvoice;

    @Column(name = "ExternalTransaction")
    private String externalTransaction;

    @Column(name = "ToTalAmount")
    private float totalAmount;

    @Column(name = "BookingId")
    private int bookingId;

    @Column(name = "CreateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "CreatedBy")
    private String createBy;

    @Column(name = "UpdatedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;

    @Column(name = "UpdatedBy")
    private String UpdatedBy;
}
