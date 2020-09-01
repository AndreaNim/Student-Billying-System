package com.studentBilling.api.repositories;

import com.studentBilling.api.models.Payment;
import com.studentBilling.api.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
