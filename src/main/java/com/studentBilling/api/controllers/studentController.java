package com.studentBilling.api.controllers;

import com.studentBilling.api.models.Student;
import com.studentBilling.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class studentController {

    @Autowired
    StudentService studentService;

    @GetMapping("")
    public List<Student> AllStudents() {

        return studentService.listAllStudents();
    }
    @PostMapping("/register")
    public void add(@RequestBody Student student) {
        studentService.registerStudent(student);
    }

}
