package com.kiyotakeshi.employeeManagement.controller;

import com.kiyotakeshi.employeeManagement.repository.entity.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private Employee.Gender gender;
    private LocalDate birthday;
    private String mailAddress;
    private List<Telephone> telephones;
    private Department department;
}
