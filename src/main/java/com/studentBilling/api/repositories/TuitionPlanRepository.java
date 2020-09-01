package com.studentBilling.api.repositories;

import com.studentBilling.api.models.Student;
import com.studentBilling.api.models.TuitionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuitionPlanRepository extends JpaRepository<TuitionPlan, Integer> {
}
