package com.studentBilling.api.repositories;

import com.studentBilling.api.models.Payment;
import com.studentBilling.api.models.School;
import com.studentBilling.api.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
