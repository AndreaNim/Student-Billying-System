package com.studentBilling.api.services;

import com.studentBilling.api.repositories.StudentRepository;
import com.studentBilling.api.repositories.TuitionPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TuitionPlanService {
    @Autowired
    TuitionPlanRepository tuitionPlanRepository;
}
