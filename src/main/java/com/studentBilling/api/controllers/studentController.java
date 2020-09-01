package com.studentBilling.api.controllers;

import com.studentBilling.api.exceptions.AuthException;
import com.studentBilling.api.exceptions.NotFoundException;
import com.studentBilling.api.models.Student;
import com.studentBilling.api.services.StudentService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/students")
public class studentController {

    @Autowired
    StudentService studentService;

    @GetMapping("")
    public List<Student> AllStudents() {
        try {
            return studentService.listAllStudents();
        } catch (Exception e) {
            throw new NotFoundException("resoures(student) could not found");

        }
    }

    @PostMapping("/register")
    public void add(@RequestBody Student student) {
        try {
            String hashedPassword = BCrypt.hashpw(student.getPassword(), BCrypt.gensalt(10));
            student.setPassword(hashedPassword);
            String email = student.getEmail();
            //email format
            Pattern pattern = Pattern.compile("^(.+)@(.+)$");
            //setting the email to lowercase
            if (email != null) email = email.toLowerCase();
            if (!pattern.matcher(email).matches())
                throw new AuthException("Invalid email format");
            Student existing = studentService.StudentByEmail(email);
            if (existing != null)
                throw new AuthException("There is already an account registered with that email");
            studentService.registerStudent(student);

        } catch (Exception e) {
            throw new AuthException("There is already an account registered with that email");
        }
    }

    @PostMapping("/login")
    public void lodinuser(@RequestBody Student student) {
        String email = student.getEmail();
        String password = student.getPassword();
        System.out.println(student.getEmail());
        System.out.println(student.getPassword());
        if (email.isEmpty() || password.isEmpty())
            throw new NotFoundException("invalid email or password ");

        try {
            Student registred = studentService.StudentByEmailAndPassword(email, password);
            if (registred != null)
                System.out.println("loged in");
            else throw new AuthException("invalid email or password");
        } catch (Exception e) {
            throw new AuthException("invalid email or password");
        }

    }




}
