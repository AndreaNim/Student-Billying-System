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
            if(schoolId>0){
                tuitionPlanService.addTuitionPlan(tuitionPlan);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else throw new AuthException("Invalid student Id");

        } catch (Exception e) {
            throw new AuthException(e.getMessage());
        }
    }



}
