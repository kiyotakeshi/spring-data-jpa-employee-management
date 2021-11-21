package com.kiyotakeshi.employeeManagement;

import com.kiyotakeshi.employeeManagement.repository.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;

@DataJpaTest
class EmployeeManagementApplicationTests {

    @Autowired
    TestEntityManager em;

    @Test
    void mapping() {
        Employee employee = new Employee("mike", "popcorn", Employee.Gender.male, LocalDate.of(1989, 12, 20), "mike.popcorn@example.com");
        em.persistAndFlush(employee);
    }
}
