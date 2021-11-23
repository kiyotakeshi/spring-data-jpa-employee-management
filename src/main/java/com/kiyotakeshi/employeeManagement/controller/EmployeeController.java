package com.kiyotakeshi.employeeManagement.controller;

import com.kiyotakeshi.employeeManagement.model.AuthorizationRequest;
import com.kiyotakeshi.employeeManagement.model.EmployeeRequest;
import com.kiyotakeshi.employeeManagement.model.EmployeeResponse;
import com.kiyotakeshi.employeeManagement.model.PasswordRequest;
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

    @PostMapping
    public EmployeeResponse register(@RequestBody EmployeeRequest request) {
        Employee employee = new Employee(
                request.getFirstName(),
                request.getLastName(),
                request.getGender(),
                request.getBirthday(),
                request.getMailAddress(),
                request.getTelephones(),
                request.getDepartment()
        );
        Employee createdEmployee = employeeService.registerEmployee(employee);

        var newAuthentication = authenticationService.registerInitial(createdEmployee);

        return new EmployeeResponse(
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
}
