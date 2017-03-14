package com.springapp.mvc.repository;

import com.springapp.mvc.dto.StudentDto;
import com.springapp.mvc.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by moiseencoo on 14.03.2017.
 */
@Repository
public class AutoFillRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addStudents1() {
        Student student = new Student();
        student.setName("Mike");
        student.setSurname("Mikov");
        student.setAge(23);
        student.setIsAdmin(true);
        student.setDate(new Date(System.currentTimeMillis()));
        sessionFactory.getCurrentSession().save(student);

        Student studentDto2 = new Student();
        studentDto2.setName("Nike");
        studentDto2.setSurname("Nike");
        studentDto2.setAge(13);
        studentDto2.setIsAdmin(true);
        studentDto2.setDate(new Date(System.currentTimeMillis()));
        sessionFactory.getCurrentSession().save(studentDto2);

        Student studentDto3 = new Student();
        studentDto3.setName("Иван");
        studentDto3.setSurname("Пупкин");
        studentDto3.setAge(26);
        studentDto3.setIsAdmin(false);
        studentDto3.setDate(new Date(System.currentTimeMillis()));
        sessionFactory.getCurrentSession().save(studentDto3);

        Student studentDto4 = new Student();
        studentDto4.setName("Иван");
        studentDto4.setSurname("Иванов");
        studentDto4.setAge(21);
        studentDto4.setIsAdmin(true);
        studentDto4.setDate(new Date(System.currentTimeMillis()));
        sessionFactory.getCurrentSession().save(studentDto4);

        Student studentDto5 = new Student();
        studentDto5.setName("Mike");
        studentDto5.setSurname("Mikov");
        studentDto5.setAge(23);
        studentDto5.setIsAdmin(true);
        studentDto5.setDate(new Date(System.currentTimeMillis()));
        sessionFactory.getCurrentSession().save(studentDto5);

        Student studentDto6 = new Student();
        studentDto6.setName("Маша");
        studentDto6.setSurname("Иванова");
        studentDto6.setAge(40);
        studentDto6.setIsAdmin(false);
        studentDto6.setDate(new Date(System.currentTimeMillis()));
        sessionFactory.getCurrentSession().save(studentDto6);

        Student studentDto7 = new Student();
        studentDto7.setName("Наташа");
        studentDto7.setSurname("Соболева");
        studentDto7.setAge(53);
        studentDto7.setIsAdmin(true);
        studentDto7.setDate(new Date(System.currentTimeMillis()));
        sessionFactory.getCurrentSession().save(studentDto7);

        Student studentDto8 = new Student();
        studentDto8.setName("Jhon");
        studentDto8.setSurname("Tyson");
        studentDto8.setAge(39);
        studentDto8.setIsAdmin(false);
        studentDto8.setDate(new Date(System.currentTimeMillis()));
        sessionFactory.getCurrentSession().save(studentDto8);

        Student studentDto9 = new Student();
        studentDto9.setName("Jack");
        studentDto9.setSurname("Bartles");
        studentDto9.setAge(63);
        studentDto9.setIsAdmin(true);
        studentDto9.setDate(new Date(System.currentTimeMillis()));
        sessionFactory.getCurrentSession().save(studentDto9);

        Student studentDto10 = new Student();
        studentDto10.setName("Natasha");
        studentDto10.setSurname("Mikova");
        studentDto10.setAge(55);
        studentDto10.setIsAdmin(false);
        studentDto10.setDate(new Date(System.currentTimeMillis()));
        sessionFactory.getCurrentSession().save(studentDto10);

    }

}
