package com.studentBilling.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class School {
    private int schoolId;
    private String schoolName;
    private String schoolType;

    public School(int schoolId, String schoolName, String schoolType) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolType = schoolType;
    }

    public School() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }
}
