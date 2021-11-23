package com.kiyotakeshi.employeeManagement.repository;

import com.kiyotakeshi.employeeManagement.repository.entity.Authentication;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthenticationRepository extends JpaRepository<Authentication, Integer> {
    Optional<Authentication> findByEmployee(Employee employee);
}
