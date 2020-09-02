package com.studentBilling.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TuitionPlan {
    private int tuitionPlanId;
    private int schoolId;
    private String tuitionPlanName;

    public TuitionPlan() {

    }
    public TuitionPlan(int tuitionPlanId, int schoolId, String tuitionPlanName) {
        this.tuitionPlanId = tuitionPlanId;
        this.schoolId = schoolId;
        this.tuitionPlanName = tuitionPlanName;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getTuitionPlanId() {
        return tuitionPlanId;
    }

    public void setTuitionPlanId(int tuitionPlanId) {
        tuitionPlanId = tuitionPlanId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        schoolId = schoolId;
    }

    public String getTuitionPlanName() {
        return tuitionPlanName;
    }

    public void setTuitionPlanName(String tuitionPlanName) {
        this.tuitionPlanName = tuitionPlanName;
    }
}
