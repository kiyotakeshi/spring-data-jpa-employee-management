package com.kiyotakeshi.employeeManagement.repository;

import com.kiyotakeshi.employeeManagement.repository.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
