package com.kiyotakeshi.employeeManagement.repository;

import com.kiyotakeshi.employeeManagement.repository.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Optional<Department> findByName(String name);
}
