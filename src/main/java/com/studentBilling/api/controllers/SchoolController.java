package com.studentBilling.api.controllers;

import com.studentBilling.api.exceptions.AuthException;
import com.studentBilling.api.exceptions.NotFoundException;
import com.studentBilling.api.models.School;
import com.studentBilling.api.models.Student;
import com.studentBilling.api.services.SchoolService;
import com.studentBilling.api.services.StudentService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @GetMapping("")
    public List<School> AllSchools() {
        try {
            return schoolService.listAllSchools();
        } catch (Exception e) {
            throw new NotFoundException("Schools could not found");

        }
    }
    @PostMapping("/")
    public ResponseEntity<Map<String, String>> addSchool(@RequestBody School school) {
        try {

            String schoolType = school.getSchoolType();
            String schoolName=school.getSchoolName();
            schoolService.addSchool(school);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            throw new AuthException("There is already an school registered with that name");
        }
    }

}
