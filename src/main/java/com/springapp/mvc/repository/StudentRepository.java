package com.springapp.mvc.repository;

import com.springapp.mvc.dto.StudentDto;
import com.springapp.mvc.model.Student;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by moiseencoo on 13.03.2017.
 */
@Repository
public class StudentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<StudentDto> getAllStudents() {
        List<Student> list = new ArrayList<Student>();
        Query query = sessionFactory.getCurrentSession().createQuery("select st from Student st");
        list = query.list();

        List<StudentDto> studentDtoList = new ArrayList<StudentDto>();

        for (Student student : list) {
            StudentDto studentDto = new StudentDto();
            studentDto.setIdStudent(student.getIdStudent());
            studentDto.setName(student.getName());
            studentDto.setSurname(student.getSurname());
            studentDto.setDate(student.getDate());
            studentDto.setAdmin(student.getIsAdmin());
            studentDto.setAge(student.getAge());
            studentDtoList.add(studentDto);
        }

        return studentDtoList;
    }

    @Transactional
    public void addStudents(StudentDto studentDto) {

        Student st = new Student();


        st.setDate(new Date(System.currentTimeMillis()));
        st.setAge(studentDto.getAge());
        st.setName(studentDto.getName());
        st.setSurname(studentDto.getSurname());
        st.setIsAdmin(studentDto.isAdmin());
        sessionFactory.getCurrentSession().save(st);

    }

    @Transactional
    public void deleteStudent(Long id) {

        Query query = sessionFactory.getCurrentSession().createQuery("delete Student where idStudent = :stockCode");
        query.setParameter("stockCode", id);
        int result = query.executeUpdate();

    }

    @Transactional
    public void update(StudentDto studentDto) {
        Student st = new Student();
        st.setIdStudent(studentDto.getIdStudent());
        st.setDate(new Date(System.currentTimeMillis()));
        st.setAge(studentDto.getAge());
        st.setName(studentDto.getName());
        st.setSurname(studentDto.getSurname());
        st.setIsAdmin(studentDto.isAdmin());
        this.sessionFactory.getCurrentSession().update(st);
    }

    @Transactional
    public List<StudentDto> searchbyName(String name) {
        List<Student> list = new ArrayList<Student>();
        Query query = sessionFactory.getCurrentSession().createQuery("from Student where name = :code ");
        query.setParameter("code", name);
        list = query.list();

        List<StudentDto> studentDtoList = new ArrayList<StudentDto>();

        for (Student student : list) {
            StudentDto studentDto = new StudentDto();
            studentDto.setIdStudent(student.getIdStudent());
            studentDto.setName(student.getName());
            studentDto.setSurname(student.getSurname());
            studentDto.setDate(student.getDate());
            studentDto.setAdmin(student.getIsAdmin());
            studentDto.setAge(student.getAge());
            studentDtoList.add(studentDto);
        }

        return studentDtoList;
    }


}
