package com.kiyotakeshi.employeeManagement.controller;

import com.kiyotakeshi.employeeManagement.repository.entity.Department;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;
import com.kiyotakeshi.employeeManagement.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> list() {
        List<Department> departments = departmentService.getDepartments();
        departments.forEach(department -> {
            ArrayList<Employee> employees = new ArrayList<>();
            department.getEmployees().forEach(employee -> {
                employees.add(
                        new Employee(employee.getId(),
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getGender(),
                                employee.getBirthday(),
                                employee.getMailAddress(),
                                employee.getTelephones(),
                                employee.getAuthentication())
                );
            });
            department.setEmployees(employees);
        });
        return departments;
    }
}
