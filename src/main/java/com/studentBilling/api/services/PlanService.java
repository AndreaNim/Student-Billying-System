package com.studentBilling.api.services;

import com.studentBilling.api.models.Plan;
import com.studentBilling.api.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlanService {
    @Autowired
    PlanRepository planRepository;

    public List<Plan> listAllPlans() {
        return planRepository.findAll();
    }

    public void addTuitionPlan(Plan plan) {
        planRepository.save(plan);
    }

    public Plan getTuitionPlan(Integer id) {
        return planRepository.findById(id).get();
    }

    public void deleteTuitionPlan(Integer id) {
        planRepository.deleteById(id);
    }
}
