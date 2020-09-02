package com.studentBilling.api.controllers;

import com.studentBilling.api.exceptions.AuthException;
import com.studentBilling.api.models.TuitionPlan;
import com.studentBilling.api.services.StudentService;
import com.studentBilling.api.services.TuitionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tuitionPlans")
public class tuitionPlanController {
    @Autowired
    TuitionPlanService tuitionPlanService;

    @GetMapping("")
    public List<TuitionPlan> AllPlans() {

        return tuitionPlanService.listAllPlans();
    }
    @PostMapping("/addPlan")
    public ResponseEntity<Map<String, String>> addPlan(@RequestBody TuitionPlan tuitionPlan) {
        try {
            String planName=tuitionPlan.getTuitionPlanName();
            int schoolId = tuitionPlan.getSchoolId();
            tuitionPlanService.addTuitionPlan(tuitionPlan);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            throw new AuthException("There is already an school registered with that name");
        }
    }



}
