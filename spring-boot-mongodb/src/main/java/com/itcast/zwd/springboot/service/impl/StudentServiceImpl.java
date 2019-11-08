package com.itcast.zwd.springboot.service.impl;

import com.itcast.zwd.springboot.entity.Student;
import com.itcast.zwd.springboot.mapper.StudentRepository;
import com.itcast.zwd.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 随风逐梦
 * @create 2019-11-05 13:54
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    /**
     * 添加学生
     * @param student
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudentById(String id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        Student oldStuent = this.findStudentById(student.getId());
        if(oldStuent!=null){
            oldStuent.setStudentId(student.getStudentId());
            oldStuent.setAge(student.getAge());
            oldStuent.setName(student.getName());
            oldStuent.setGender(student.getGender());
            return studentRepository.save(oldStuent);
        }else{
            return null;
        }
    }

    @Override
    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }
}
