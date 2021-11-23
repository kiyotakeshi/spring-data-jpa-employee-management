package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.model.request.AuthorizationRequest;
import com.kiyotakeshi.employeeManagement.model.request.PasswordRequest;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee registerEmployee(Employee employee);

    List<String> attachAuthorization(int employeeId, List<AuthorizationRequest> authorizations);

    String updatePassword(int employeeId, PasswordRequest request);
}
