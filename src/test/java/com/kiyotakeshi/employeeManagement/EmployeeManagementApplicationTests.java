package com.kiyotakeshi.employeeManagement;

import com.kiyotakeshi.employeeManagement.repository.EmployeeRepository;
import com.kiyotakeshi.employeeManagement.repository.entity.Authentication;
import com.kiyotakeshi.employeeManagement.repository.entity.Department;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;
import com.kiyotakeshi.employeeManagement.repository.entity.Telephone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class EmployeeManagementApplicationTests {

    @Autowired
    TestEntityManager em;

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void mapping() {
        Department department = new Department("sales");

        Employee employee = new Employee(
                "mike",
                "popcorn",
                Employee.Gender.male,
                LocalDate.of(1989, 12, 20),
                "mike.popcorn@example.com",
                new ArrayList<Telephone>(Arrays.asList(
                        new Telephone("0120-444-444", "bussiness"),
                        new Telephone("0120-555-555", "bussiness")
                )),
                department
        );
        em.persistAndFlush(department);
        em.persistAndFlush(employee);

        Authentication authentication = new Authentication("password", employee);
        em.persistAndFlush(authentication);
    }

    @Test
    void retrieve() {
        assertEquals(2, employeeRepository.findAll().size());
    }
}
