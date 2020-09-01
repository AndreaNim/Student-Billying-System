package com.studentBilling.api.controllers;

import com.studentBilling.api.exceptions.NotFoundException;
import com.studentBilling.api.models.Payment;
import com.studentBilling.api.models.Student;
import com.studentBilling.api.services.PaymentService;
import com.studentBilling.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/payments")
public class paymentController {
    @Autowired
    PaymentService paymentService;
    @GetMapping("")
    public String AllPayments(HttpServletRequest request) {
        String email = (String) request.getAttribute("email");
        return "ayth"+email;

    }


//    @GetMapping("")
//    public List<Payment> AllPayments() {
//        try {
//            return paymentService.listAllPayments();
//        } catch (Exception e) {
//            throw new NotFoundException("payments could not found");
//
//        }
//    }
    @GetMapping("/{studentid}")
    public ResponseEntity<Payment> getById(@PathVariable(value = "studentid") int studentId)throws NotFoundException  {
        try {
            Payment payment = paymentService.getByStudentIdPayment(studentId);
            return new ResponseEntity<Payment>(payment, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        }
    }

}
