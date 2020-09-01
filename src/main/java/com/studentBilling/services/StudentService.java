package com.studentBilling.services;

import com.studentBilling.models.Student;
import com.studentBilling.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> listAllStudents() {
        return studentRepository.findAll();
    }

    public void registerStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudent(Integer id) {
        return studentRepository.findById(id).get();
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
