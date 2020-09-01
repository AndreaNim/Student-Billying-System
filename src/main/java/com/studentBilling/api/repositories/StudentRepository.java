package com.studentBilling.api.repositories;

import com.studentBilling.api.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {
   Student findStudentByEmail(String email);
   Student findStudentByPassword(String password);
   Student findStudentByEmailAndPassword(String email,String password);


}
