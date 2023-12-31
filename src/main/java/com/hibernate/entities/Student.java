package com.hibernate.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sdj_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int _id;
    private String name;
    private String about;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Laptop laptop;
}
