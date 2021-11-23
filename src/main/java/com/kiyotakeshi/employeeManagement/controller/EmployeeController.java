package com.kiyotakeshi.employeeManagement.controller;

import com.kiyotakeshi.employeeManagement.model.request.AuthorizationRequest;
import com.kiyotakeshi.employeeManagement.model.request.NewEmployeeRequest;
import com.kiyotakeshi.employeeManagement.model.request.PasswordRequest;
import com.kiyotakeshi.employeeManagement.model.response.NewEmployeeResponse;
import com.kiyotakeshi.employeeManagement.repository.entity.Department;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;
import com.kiyotakeshi.employeeManagement.service.AuthenticationService;
import com.kiyotakeshi.employeeManagement.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final AuthenticationService authenticationService;

    public EmployeeController(EmployeeService employeeService, AuthenticationService authenticationService) {
        this.employeeService = employeeService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public List<Employee> list() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable Integer employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping
    public NewEmployeeResponse register(@RequestBody NewEmployeeRequest request) {
        Employee employee = new Employee(
                request.getFirstName(),
                request.getLastName(),
                request.getGender(),
                request.getBirthday(),
                request.getMailAddress(),
                request.getTelephones(),
                Department.newEmployeeAffiliation()
        );
        Employee createdEmployee = employeeService.registerEmployee(employee);

        var newAuthentication = authenticationService.registerInitial(createdEmployee);

        return new NewEmployeeResponse(
                createdEmployee.getFirstName(),
                createdEmployee.getLastName(),
                createdEmployee.getGender(),
                createdEmployee.getBirthday(),
                createdEmployee.getMailAddress(),
                createdEmployee.getTelephones(),
                createdEmployee.getDepartment(),
                newAuthentication.getPassword()
        );
    }

    @PutMapping("/{employeeId}/authorizations/")
    public String attachAuthorization(@PathVariable int employeeId,
                                      @RequestBody List<AuthorizationRequest> authorizations) {
        var attachedAuthorizations = employeeService.attachAuthorization(employeeId, authorizations);
        return "attach authorizations: " + attachedAuthorizations.toString();
    }

    @PutMapping("/{employeeId}/password")
    public String updatePassword(@PathVariable int employeeId, @RequestBody PasswordRequest request) {
        return employeeService.updatePassword(employeeId, request);
    }

    @PutMapping("/{employeeId}/department/{departmentId}")
    public Employee updateDepartment(@PathVariable int employeeId, @PathVariable Integer departmentId) {
        return employeeService.updateDepartment(employeeId, departmentId);
    }
}
