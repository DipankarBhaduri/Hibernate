package com.hibernate.services;

import com.hibernate.dtos.StudentWithLaptop;
import com.hibernate.dtos.TeacherWithLaptop;
import com.hibernate.entities.Laptop;
import com.hibernate.entities.Student;
import com.hibernate.entities.Teacher;
import com.hibernate.repositories.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class SaveRestServices {
    private static Logger logger = Logger.getLogger("SaveRestServices");
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public ResponseEntity<String> saveStudent (Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(student);
            transaction.commit();
            session.close();
        }catch (Exception e) {
            e.printStackTrace();
            logger.info("Error during save Student data : {} "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(student.getName() + " Saved!!", HttpStatus.OK);
    }

    public ResponseEntity<String> saveLaptop(Laptop laptop) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(laptop);
            transaction.commit();
            session.close();
        }catch (Exception e) {
            logger.info("Error during save laptop data : {} ");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(laptop.getModel()+" Saved!!", HttpStatus.OK);
    }

    public ResponseEntity<String> saveStudentWithLaptop(StudentWithLaptop studentWithLaptop) {
        Student student = studentWithLaptop.getStudent();
        Laptop laptop = studentWithLaptop.getLaptop();

        try {
            if (student != null && laptop != null) {
                // set the student object to laptop
                laptop.setStudent(student);

                //set the laptop object to student
                student.setLaptop(laptop);
                saveStudent(student);

                return new ResponseEntity<>(student.getName()+" Saved!!", HttpStatus.OK);
            }
        }catch (Exception e) {
            logger.info("Error during save the student and laptop object : {} ");
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> saveTeacherWithLaptop(TeacherWithLaptop teacherWithLaptop) {
        Teacher teacher = teacherWithLaptop.getTeacher();
        List<Laptop> laptopList = teacherWithLaptop.getLaptopList();

        try {
            if (teacher != null && laptopList != null) {
                // set the student object to laptop
                laptopList.forEach(laptop -> laptop.setTeacher(teacher));

                //set the laptop object to student
                teacher.setLaptopList(laptopList);
                saveTeacher(teacher);
                return new ResponseEntity<>(teacher.getName()+" Saved!!", HttpStatus.OK);
            }
        }catch (Exception e) {
            logger.info("Error during save the Teacher and laptop object : {} ");
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<String> saveTeacher(Teacher teacher) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(teacher);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            logger.info("Error during save Teacher data : {} "+teacher.getName());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(teacher.getName() + " Saved!!", HttpStatus.OK);
    }
}
