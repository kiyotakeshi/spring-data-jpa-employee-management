package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.repository.entity.Department;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartments();

    List<Employee> listDeploymentEmployees(int departmentId);
}
