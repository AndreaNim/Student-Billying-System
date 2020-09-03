package com.studentBilling.api.services;

import com.studentBilling.api.models.Payment;
import com.studentBilling.api.models.Student;
import com.studentBilling.api.repositories.PaymentRepository;
import com.studentBilling.api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public List<Payment> listAllPayments() {
        return paymentRepository.findAll();
    }

    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public Payment getPayment(Integer id) {
        return paymentRepository.findById(id).get();
    }

    public void deletePayment(Integer id) {
        paymentRepository.deleteById(id);
    }

    public List<Payment> getByStudentIdPayment(Integer studentId) {
        return paymentRepository.findByStudentId(studentId);
    }

    public Payment getByStudentEmailPayment(String studentEmail) {
        return paymentRepository.findByStudentEmail(studentEmail);
    }

}
