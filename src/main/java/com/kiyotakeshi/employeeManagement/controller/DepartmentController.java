package com.kiyotakeshi.employeeManagement.controller;

import com.kiyotakeshi.employeeManagement.model.DepartmentRequest;
import com.kiyotakeshi.employeeManagement.repository.entity.Department;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;
import com.kiyotakeshi.employeeManagement.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

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
        return departmentService.getDepartments();
    }

    @GetMapping("/{departmentId}/employees")
    public List<Employee> listDepartmentEmployees(@PathVariable int departmentId){
        return departmentService.listDepartmentEmployees(departmentId);
    }

    @PostMapping
    public Department register(@RequestBody DepartmentRequest request) {
        return departmentService.register(request);
    }
}
