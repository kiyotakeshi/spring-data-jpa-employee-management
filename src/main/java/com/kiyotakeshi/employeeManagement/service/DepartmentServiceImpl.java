package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.repository.DepartmentRepository;
import com.kiyotakeshi.employeeManagement.repository.entity.Department;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Employee> listDeploymentEmployees(int departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow().getEmployees();
//        Department department = departmentRepository.findById(departmentId).orElseThrow();
//        ArrayList<Employee> employees = new ArrayList<>();
//        employees.addAll(department.getEmployees());
//        return employees;
    }
}
