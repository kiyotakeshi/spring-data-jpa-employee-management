package com.kiyotakeshi.employeeManagement.repository;

import com.kiyotakeshi.employeeManagement.repository.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
