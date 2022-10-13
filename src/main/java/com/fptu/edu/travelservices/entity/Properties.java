package com.fptu.edu.travelservices.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Properties")
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "PropertyName")
    private String propertyName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Icon")
    private String icon;

    @Column(name = "IsExpense")
    private String isExpense;
}
