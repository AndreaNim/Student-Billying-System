package com.studentBilling.api.services;

import com.studentBilling.api.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.regex.Pattern;

public class StudentServiceImpl extends StudentService {
    @Override
    public List<Student> listAllStudents() {

        return super.listAllStudents();
    }

    @Override
    public void registerStudent(Student student) {

        super.registerStudent(student);
    }

    @Override
    public Student getStudent(Integer id) {
        return super.getStudent(id);
    }

    @Override
    public void deleteStudent(Integer id) {
        super.deleteStudent(id);
    }

    @Override
    public Student StudentByEmail(String email) {
        return super.StudentByEmail(email);
    }
}
