package com.studentBilling.api.services;

import com.studentBilling.api.models.Student;

import java.util.List;

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
}
