package com.studentBilling.api.repositories;

import com.studentBilling.api.models.Payment;
import com.studentBilling.api.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> findByStudentId(Integer studentId);

    Payment findByStudentEmail(String studentEmail);

}
