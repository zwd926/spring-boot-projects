package com.itcast.zwd.springboot.service;


import com.itcast.zwd.springboot.entity.Student;

import java.util.List;

/**
 * @author 随风逐梦
 * @create 2019-11-05 13:54
 */
public interface StudentService {

    Student addStudent(Student student);

    Student findStudentById(String id);

    List<Student> findAllStudent();

    Student updateStudent(Student student);

    void deleteById(String id);
}
