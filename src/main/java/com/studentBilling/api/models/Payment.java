package com.studentBilling.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
    private int paymentId;
    private int studentId;
    private int tuitionPlanId;
    private String date;
    private double payment;

    public Payment() {
    }

    public Payment(int paymentId, int studentId, int tuitionPlanId, String date, double payment) {
        this.paymentId = paymentId;
        this.studentId = studentId;
        this.tuitionPlanId = tuitionPlanId;
        this.date = date;
        this.payment = payment;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }
}
