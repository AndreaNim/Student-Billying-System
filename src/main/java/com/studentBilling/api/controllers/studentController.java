package com.studentBilling.api.controllers;

import com.studentBilling.api.Constants.Constants;
import com.studentBilling.api.exceptions.AuthException;
import com.studentBilling.api.exceptions.NotFoundException;
import com.studentBilling.api.models.Student;
import com.studentBilling.api.services.StudentService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<Map<String, String>>addStudent(@RequestBody Student student) {
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
            return new ResponseEntity<>(generateJWTToken(student), HttpStatus.OK);

        } catch (Exception e) {
            throw new AuthException("There is already an account registered with that email");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> lodinuser(@RequestBody Student student) {
        String email = student.getEmail();
        String password = student.getPassword();
        System.out.println(student.getEmail());
        System.out.println(student.getPassword());
        if (email.isEmpty() || password.isEmpty())
            throw new NotFoundException("invalid email or password ");

        try {

            Student registredEmail = studentService.StudentByEmail(email);
            System.out.println(registredEmail.getPassword());

            if(!BCrypt.checkpw(password, registredEmail.getPassword())){
                throw new AuthException("Invalid email/password");
            }
            else {
                System.out.println("login sucessful");
                return new ResponseEntity<>(generateJWTToken(student), HttpStatus.OK);
            }

        } catch (Exception e) {
            throw new AuthException("invalid email or password");
        }

    }

    private Map<String, String> generateJWTToken(Student student) {
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("studentId", student.getStudentId())
                .claim("email", student.getEmail())
                .claim("firstName", student.getFirstName())
                .claim("lastName", student.getLastName())
                .compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }

}
