package com.studentBilling.api.services;

import com.studentBilling.api.models.School;
import com.studentBilling.api.models.Student;
import com.studentBilling.api.models.TuitionPlan;
import com.studentBilling.api.repositories.StudentRepository;
import com.studentBilling.api.repositories.TuitionPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TuitionPlanService {
    @Autowired
    TuitionPlanRepository tuitionPlanRepository;

    public List<TuitionPlan> listAllPlans() {
        return tuitionPlanRepository.findAll();
    }

    public void addTuitionPlan(TuitionPlan tuitionPlan) {
        tuitionPlanRepository.save(tuitionPlan);
    }

    public TuitionPlan getTuitionPlan(Integer id) {
        return tuitionPlanRepository.findById(id).get();
    }

    public void deleteTuitionPlan(Integer id) {
        tuitionPlanRepository.deleteById(id);
    }
}
