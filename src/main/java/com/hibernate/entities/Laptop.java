package com.hibernate.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sdj_laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int _id;
    private String model;
    private String description;

    @OneToOne
    @JoinColumn
    private Student student;

    @ManyToOne
    private Teacher teacher;
}
