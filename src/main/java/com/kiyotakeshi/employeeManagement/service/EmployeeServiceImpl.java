package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.controller.AuthorizationRequest;
import com.kiyotakeshi.employeeManagement.controller.PasswordRequest;
import com.kiyotakeshi.employeeManagement.repository.AuthenticationRepository;
import com.kiyotakeshi.employeeManagement.repository.AuthorizationRepository;
import com.kiyotakeshi.employeeManagement.repository.EmployeeRepository;
import com.kiyotakeshi.employeeManagement.repository.entity.Authentication;
import com.kiyotakeshi.employeeManagement.repository.entity.Authorization;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AuthorizationRepository authorizationRepository;
    private final AuthenticationRepository authenticationRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AuthorizationRepository authorizationRepository, AuthenticationRepository authenticationRepository) {
        this.employeeRepository = employeeRepository;
        this.authorizationRepository = authorizationRepository;
        this.authenticationRepository = authenticationRepository;
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
    public List<String> attachAuthorization(int employeeId, List<AuthorizationRequest> authorizations) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        var authorizationNames = authorizations
                .stream()
                .map(AuthorizationRequest::getName)
                .collect(Collectors.toList());

        List<Authorization> foundAuthorizations = authorizationRepository.findAllByNameIn(authorizationNames);
        employee.addAuthorizations(foundAuthorizations);

        var updatedEmployee = employeeRepository.saveAndFlush(employee);

        List<String> attachedAuthorizationName = updatedEmployee.getAuthorizations()
                .stream()
                .map(Authorization::getName)
                .collect(Collectors.toList());

        return attachedAuthorizationName;
    }

    @Override
    public String updatePassword(int employeeId, PasswordRequest request) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        var authentication = authenticationRepository.findByEmployee(employee).orElseThrow();
        authentication.setPassword(request.getPassword());
        authenticationRepository.save(authentication);
        return "password updated!";
    }
}
