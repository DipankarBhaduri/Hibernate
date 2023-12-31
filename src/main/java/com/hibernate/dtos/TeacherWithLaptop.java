package com.hibernate.dtos;

import com.hibernate.entities.Laptop;
import com.hibernate.entities.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherWithLaptop {
    private Teacher teacher;
    private List<Laptop> laptopList;
}
