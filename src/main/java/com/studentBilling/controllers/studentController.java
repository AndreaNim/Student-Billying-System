package com.studentBilling.controllers;

import com.studentBilling.models.Student;
import com.studentBilling.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class studentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> list() {
        return studentService.listAllStudents();
    }
}
