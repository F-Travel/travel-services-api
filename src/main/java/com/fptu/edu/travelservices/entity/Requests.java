package com.fptu.edu.travelservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Requests")
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "RequestType")
    private String RequestType;

    @Column(name = "RequestStatus")
    private String requestStatus;

    @Column(name = "DateApproved")
    private String dateApproved;

    @Column(name = "DateRejected")
    private String dateRejected;

    @Column(name = "DateReturned")
    private String dateReturned;

    @Column(name = "DateLeaveRequest")
    private String dateLeaveRequest;

    @Column(name = "DateStayRequest")
    private String dateStayRequest;

    @Column(name = "UserId")
    private String userId;

    @Column(name = "OwnerId")
    private String ownerId;

    @Column(name = "RoomId")
    private String roomId;
}
