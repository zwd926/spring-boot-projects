package com.itcast.zwd.springboot.controller;

import com.itcast.zwd.springboot.entity.Student;
import com.itcast.zwd.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 随风逐梦
 * @create 2019-11-05 13:56
 */
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/add")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    /**
     * http://localhost:8080/student/5dc112cb8a23aa674c7462bf    主键id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable("id") String id){
        return studentService.findStudentById(id);
    }


    @GetMapping("/list")
    public List<Student> findAllStudent(){
        return studentService.findAllStudent();
    }

    @PostMapping(value = "/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @GetMapping(value = "/delete/{id}")
    public void deleteStudentById(@PathVariable("id") String id){
        studentService.deleteById(id);
    }


}
