package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.repository.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee registerEmployee(Employee employee);

    void attachAuthorization(int employeeId, String authorizationId);
}
