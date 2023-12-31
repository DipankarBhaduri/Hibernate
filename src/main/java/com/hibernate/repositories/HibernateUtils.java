package com.hibernate.repositories;

import com.hibernate.entities.Laptop;
import com.hibernate.entities.Student;
import com.hibernate.entities.Teacher;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;
import java.util.Properties;

@Component
public class HibernateUtils {
    public static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties properties = new Properties();

                properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                properties.put(Environment.URL, "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12673708?createTableIfNotExists=true");
                properties.put(Environment.USER, "sql12673708");
                properties.put(Environment.PASS, "R58nhZkln8");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(properties);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Teacher.class);
                configuration.addAnnotatedClass(Laptop.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                // Build the SessionFactory
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
