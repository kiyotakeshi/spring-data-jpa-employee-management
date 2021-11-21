package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.repository.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartments();
}
