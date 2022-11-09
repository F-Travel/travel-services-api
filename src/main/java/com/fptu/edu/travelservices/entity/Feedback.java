package com.fptu.edu.travelservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "StarPoint")
    private Integer starPoint;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "UserId")
    private long userId ;

    @Column(name = "HotelId")
    private Integer hotelId;

    @Column(name = "StatusFeedback")
    private String statusFeedback;
}
