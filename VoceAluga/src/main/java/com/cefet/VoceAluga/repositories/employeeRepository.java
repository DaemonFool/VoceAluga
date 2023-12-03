package com.cefet.VoceAluga.repositories;

import com.cefet.VoceAluga.models.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepository extends JpaRepository<employee, Integer > {
}
