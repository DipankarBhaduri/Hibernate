package com.hibernate.controllers;

import com.hibernate.dtos.StudentWithLaptop;
import com.hibernate.dtos.TeacherWithLaptop;
import com.hibernate.entities.Laptop;
import com.hibernate.entities.Student;
import com.hibernate.services.SaveRestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class SaveRestController {
    @Autowired
    private SaveRestServices saveRestServices;

    @PostMapping("/save/studentWithLaptop")
    public ResponseEntity<String> saveStudentWithLaptop(@RequestBody StudentWithLaptop studentWithLaptop) {
        return saveRestServices.saveStudentWithLaptop(studentWithLaptop);
    }

    @PostMapping("/save/teacherWithLaptop")
    public ResponseEntity<String> saveTeacherWithLaptop(@RequestBody TeacherWithLaptop teacherWithLaptop) {
        return saveRestServices.saveTeacherWithLaptop(teacherWithLaptop);
    }

    @PostMapping("/save/student")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        return saveRestServices.saveStudent(student);
    }

    @PostMapping("/save/laptop")
    public ResponseEntity<String> saveLaptop(@RequestBody Laptop laptop) {
        return saveRestServices.saveLaptop(laptop);
    }
}
