package com.fptu.edu.travelservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Feedbacks")
public class Feedbacks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "StarPoint")
    private String starPoint;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "UserId ")
    private String userId ;

//    @ManyToOne
//    @JoinColumn(name = "HostelId")
//    private Hotels hostelId;

}
