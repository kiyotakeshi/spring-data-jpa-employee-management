package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.repository.AuthorizationRepository;
import com.kiyotakeshi.employeeManagement.repository.EmployeeRepository;
import com.kiyotakeshi.employeeManagement.repository.entity.Authorization;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AuthorizationRepository authorizationRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AuthorizationRepository authorizationRepository) {
        this.employeeRepository = employeeRepository;
        this.authorizationRepository = authorizationRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        // キーを指定して複数レコード取得することも可能
        // return employeeRepository.findAllById(Arrays.asList(1,3));
        return employeeRepository.findAll();
    }

    @Override
    public Employee registerEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void attachAuthorization(int employeeId, String authorizationId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        Authorization authorization = authorizationRepository.findById(authorizationId).orElseThrow();
        employee.getAuthorizations().add(authorization);
        employeeRepository.saveAndFlush(employee);
    }
}
