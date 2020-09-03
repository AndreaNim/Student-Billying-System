package com.studentBilling.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
    private int paymentId;
    private String payment_datetime;
    private double payment;
    private int studentId;
    private int tuitionPlanId;
    private String studentEmail;


    public Payment() {
    }

    public Payment(int paymentId, int studentId, int tuitionPlanId, String payment_datetime, double payment,String studentEmail) {
        this.paymentId = paymentId;
        this.studentId = studentId;
        this.tuitionPlanId = tuitionPlanId;
        this.payment_datetime = payment_datetime;
        this.payment = payment;
        this.studentEmail=studentEmail;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTuitionPlanId() {
        return tuitionPlanId;
    }

    public void setTuitionPlanId(int tuitionPlanId) {
        this.tuitionPlanId = tuitionPlanId;
    }

    public String getPayment_datetime() {
        return payment_datetime;
    }

    public void setPayment_datetime(String date) {
        this.payment_datetime = date;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
}
