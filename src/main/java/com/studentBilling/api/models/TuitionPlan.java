package com.studentBilling.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TuitionPlan {
    private int TuitionPlanId;
    private int SchoolId;
    private String TuitionPlanName;

    public TuitionPlan() {
    }

    public TuitionPlan(int tuitionPlanId, int schoolId, String tuitionPlanName) {
        TuitionPlanId = tuitionPlanId;
        SchoolId = schoolId;
        TuitionPlanName = tuitionPlanName;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getTuitionPlanId() {
        return TuitionPlanId;
    }

    public void setTuitionPlanId(int tuitionPlanId) {
        TuitionPlanId = tuitionPlanId;
    }

    public int getSchoolId() {
        return SchoolId;
    }

    public void setSchoolId(int schoolId) {
        SchoolId = schoolId;
    }

    public String getTuitionPlanName() {
        return TuitionPlanName;
    }

    public void setTuitionPlanName(String tuitionPlanName) {
        TuitionPlanName = tuitionPlanName;
    }
}
