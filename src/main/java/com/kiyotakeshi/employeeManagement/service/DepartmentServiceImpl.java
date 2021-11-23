package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.model.DepartmentRequest;
import com.kiyotakeshi.employeeManagement.repository.DepartmentRepository;
import com.kiyotakeshi.employeeManagement.repository.entity.Department;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;
import org.springframework.stereotype.Service;

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
    public List<Employee> listDepartmentEmployees(int departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow().getEmployees();
    }

    @Override
    public Department register(DepartmentRequest request) {
        departmentRepository.findByName(request.getName()).ifPresent(d -> {
            // ユーザにエラーメッセージとして返す実装にしてもいい
            throw new RuntimeException("same department is already registered: " + d);
        });
        return departmentRepository.save(new Department(request.getName()));
    }
}
