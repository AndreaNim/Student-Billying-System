package com.studentBilling.api.services;

import com.studentBilling.api.models.Payment;
import com.studentBilling.api.models.School;
import com.studentBilling.api.repositories.SchoolRepository;
import com.studentBilling.api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SchoolService {
    @Autowired
    SchoolRepository schoolRepository;

    public List<School> listAllSchools() {
        return schoolRepository.findAll();
    }

    public void addSchool(School school) {
        schoolRepository.save(school);
    }

    public School getSchool(Integer id) {
        return schoolRepository.findById(id).get();
    }

    public void deleteSchool(Integer id) {
        schoolRepository.deleteById(id);
    }


}
