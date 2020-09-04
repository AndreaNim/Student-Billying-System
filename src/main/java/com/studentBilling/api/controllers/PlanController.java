package com.studentBilling.api.controllers;

import com.studentBilling.api.exceptions.AuthException;
import com.studentBilling.api.models.Plan;
import com.studentBilling.api.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plans")
public class PlanController {
    @Autowired
    PlanService planService;

    @GetMapping("")
    public List<Plan> AllPlans() {

        return planService.listAllPlans();
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, String>> addPlan(@RequestBody Plan plan) {
        try {
            String planName = plan.getPlanName();
            int schoolId = plan.getSchoolId();
            if (schoolId > 0) {
                planService.addTuitionPlan(plan);
                return new ResponseEntity<>(HttpStatus.OK);
            } else throw new AuthException("Invalid school Id");

        } catch (Exception e) {
            throw new AuthException(e.getMessage());
        }
    }


}
