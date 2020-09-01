package com.studentBilling.api.controllers;

import com.studentBilling.api.exceptions.AuthException;
import com.studentBilling.api.exceptions.NotFoundException;
import com.studentBilling.api.models.Student;
import com.studentBilling.api.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        }catch (Exception e){
            throw new NotFoundException("resoures(student) could not found");

        }


    }
    @PostMapping("/register")
    public void add(@RequestBody Student student) {
        try{

            String email=student.getEmail();
            //email format
            Pattern pattern = Pattern.compile("^(.+)@(.+)$");
            //setting the email to lowercase
            if(email != null) email = email.toLowerCase();
            if(!pattern.matcher(email).matches())
                throw new AuthException("Invalid email format");
            Student existing = studentService.StudentByEmail(email);
            if (existing != null)
                throw new AuthException("There is already an account registered with that email");
            studentService.registerStudent(student);

        }catch (Exception e){
           throw new AuthException("There is already an account registered with that email");
        }
    }

}
