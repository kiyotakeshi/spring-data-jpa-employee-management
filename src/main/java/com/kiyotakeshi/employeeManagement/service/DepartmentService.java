package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.model.request.DepartmentRequest;
import com.kiyotakeshi.employeeManagement.repository.entity.Department;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartments();

    List<Employee> listDepartmentEmployees(int departmentId);

    Department register(DepartmentRequest request);
}
