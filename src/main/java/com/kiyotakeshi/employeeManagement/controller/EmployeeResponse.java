package com.kiyotakeshi.employeeManagement.controller;

import com.kiyotakeshi.employeeManagement.repository.entity.Department;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;
import com.kiyotakeshi.employeeManagement.repository.entity.Telephone;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EmployeeResponse {
    private String firstName;
    private String lastName;
    private Employee.Gender gender;
    private LocalDate birthday;
    private String mailAddress;
    private List<Telephone> telephones;
    private Department department;
    private String initialPassword;
}

