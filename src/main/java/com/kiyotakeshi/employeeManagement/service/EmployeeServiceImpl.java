package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.repository.EmployeeRepository;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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
}
