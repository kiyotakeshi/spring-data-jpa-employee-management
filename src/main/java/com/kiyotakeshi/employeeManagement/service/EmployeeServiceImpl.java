package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.model.request.AuthorizationRequest;
import com.kiyotakeshi.employeeManagement.model.request.PasswordRequest;
import com.kiyotakeshi.employeeManagement.repository.AuthenticationRepository;
import com.kiyotakeshi.employeeManagement.repository.AuthorizationRepository;
import com.kiyotakeshi.employeeManagement.repository.DepartmentRepository;
import com.kiyotakeshi.employeeManagement.repository.EmployeeRepository;
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
    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AuthorizationRepository authorizationRepository, AuthenticationRepository authenticationRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.authorizationRepository = authorizationRepository;
        this.authenticationRepository = authenticationRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        // キーを指定して複数レコード取得することも可能
        // return employeeRepository.findAllById(Arrays.asList(1,3));
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Integer employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow();
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
        // employee.addAuthorizations(foundAuthorizations);
        employee.removeAuthorization(foundAuthorizations.get(0));

        var updatedEmployee = employeeRepository.saveAndFlush(employee);

        List<String> attachedAuthorizationName = updatedEmployee.getAuthorizations()
                .stream()
                .map(Authorization::getName)
                .collect(Collectors.toList());

        return attachedAuthorizationName;
    }

    @Override
    public String detachAuthorization(int employeeId, AuthorizationRequest authorization) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        // TODO: employee に含まれている authorization か確認する処理
        Authorization foundAuthorization = authorizationRepository.findByName(authorization.getName());
        employee.removeAuthorization(foundAuthorization);

        employeeRepository.saveAndFlush(employee);
        return foundAuthorization.getName();
    }

    @Override
    public String updatePassword(int employeeId, PasswordRequest request) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        var authentication = authenticationRepository.findByEmployee(employee).orElseThrow();
        authentication.setPassword(request.getPassword());
        authenticationRepository.save(authentication);
        return "password updated!";
    }

    @Override
    public Employee updateDepartment(int employeeId, Integer departmentId) {
        var department = departmentRepository.findById(departmentId).orElseThrow();
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }
}
