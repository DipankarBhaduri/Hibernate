package com.hibernate.dtos;

import com.hibernate.entities.Laptop;
import com.hibernate.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithLaptop {
    private Student student;
    private Laptop laptop;
}
