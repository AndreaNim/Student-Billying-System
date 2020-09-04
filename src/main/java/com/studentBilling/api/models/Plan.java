package com.studentBilling.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plan {
    private int planId;
    private int schoolId;
    private String planName;

    public Plan() {

    }
    public Plan(int planId, int schoolId, String planName) {
        this.planId = planId;
        this.schoolId = schoolId;
        this.planName = planName;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int tuitionPlanId) {
        tuitionPlanId = tuitionPlanId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        schoolId = schoolId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String tuitionPlanName) {
        this.planName = tuitionPlanName;
    }
}
