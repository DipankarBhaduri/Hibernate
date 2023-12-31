package com.hibernate.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sdj_teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int _id;
    private String name;
    private String about;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Laptop> laptopList = new ArrayList<>();
}