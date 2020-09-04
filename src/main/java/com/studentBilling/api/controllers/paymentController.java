package com.studentBilling.api.controllers;

import com.studentBilling.api.exceptions.AuthException;
import com.studentBilling.api.exceptions.NotFoundException;
import com.studentBilling.api.models.Payment;
import com.studentBilling.api.models.School;
import com.studentBilling.api.models.Student;
import com.studentBilling.api.services.PaymentService;
import com.studentBilling.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/payments")
public class paymentController {
    @Autowired
    PaymentService paymentService;
    @Autowired
    StudentService studentService;

    @GetMapping("")
    public List<Payment> allPayments() {
        try {
            return paymentService.listAllPayments();
        } catch (Exception e) {
            throw new NotFoundException("Payments could not found");

        }

    }

    @PostMapping("/")
    public ResponseEntity<Map<String, String>> addPayment(@RequestBody Payment payment) {
        try {
            double paymentAmount = payment.getPayment();
            String studentEmail = payment.getStudentEmail();
            Student registredEmail = studentService.StudentByEmail(studentEmail);
            int studentId = registredEmail.getStudentId();
            System.out.println(studentId);
            payment.setStudentId(studentId);
            int tuitionPlan = payment.getTuitionPlanId();
            if ((studentId > 0 && tuitionPlan > 0) && (paymentAmount > 0)) {
                paymentService.addPayment(payment);
                return new ResponseEntity<>(HttpStatus.OK);
            } else
                throw new AuthException("Invalid student Id or Tuition Plan Id");

        } catch (Exception e) {
            throw new AuthException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getById(@PathVariable(value = "id") int paymentId) throws NotFoundException {
        try {
            if (paymentService.getByStudentIdPayment(paymentId).isEmpty()) {
                throw new NotFoundException("Payments could not found");
            }
            Payment payment = paymentService.getPayment(paymentId);
            return new ResponseEntity<Payment>(payment, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/studentId/{id}")
    public List<Payment> getPaymentByStudentId(@PathVariable(value = "id") int studentId) throws NotFoundException {
        try {
            if (paymentService.getByStudentIdPayment(studentId).isEmpty()) {
                throw new NotFoundException("Payments could not found");
            }
            return paymentService.getByStudentIdPayment(studentId);


        } catch (Exception e) {
            throw new NotFoundException("Payments could not found");

        }
    }


}
