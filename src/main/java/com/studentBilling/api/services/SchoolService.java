package com.studentBilling.api.services;

import com.studentBilling.api.repositories.SchoolRepository;
import com.studentBilling.api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SchoolService {
    @Autowired
    SchoolRepository schoolRepository;

}
