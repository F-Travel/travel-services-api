package com.fptu.edu.travelservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Bills")
public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "PaymentMethod")
    private String paymentMethod;

    @Column(name = "TotalAmount")
    private String totalAmount;

    @Column(name = "IsRequested")
    private String isRequested;

    @Column(name = "DateRequested")
    private String dateRequested;

    @Column(name = "IsPaid")
    private String isPaid;

    @Column(name = "DatePaid")
    private String DatePaid;

    @Column(name = "ExternalInvoice")
    private String ExternalInvoice;

    @Column(name = "ExternalTransaction")
    private String ExternalTransaction;

    @Column(name = "UserId")
    private String UserId;

    @Column(name = "OwnerId")
    private String ownerId;

    @Column(name = "RoomId")
    private String roomId;
}
