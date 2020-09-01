package com.studentBilling.api.services;

import com.studentBilling.api.models.Student;
import com.studentBilling.api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

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

    public Student StudentByEmail(String email){ return studentRepository.findStudentByEmail(email);
    }
    public Student StudentByEmailAndPassword(String email,String password){ return studentRepository.findStudentByEmailAndPassword(email, password);
    }
}
