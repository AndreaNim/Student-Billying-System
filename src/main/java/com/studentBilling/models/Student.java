package com.studentBilling.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private int student_tele_number ;
    private String email ;
    private String password;
    private String gender;
    private String date_of_birth;

    public Student(int studentId, String firstName, String lastName, int student_tele_number, String email, String password, String gender, String date_of_birth) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.student_tele_number = student_tele_number;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
    }

    public Student() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudent_tele_number() {
        return student_tele_number;
    }

    public void setStudent_tele_number(int student_tele_number) {
        this.student_tele_number = student_tele_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
