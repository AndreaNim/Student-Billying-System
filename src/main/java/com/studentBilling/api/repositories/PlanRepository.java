package com.studentBilling.api.repositories;

import com.studentBilling.api.models.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Integer> {
}
