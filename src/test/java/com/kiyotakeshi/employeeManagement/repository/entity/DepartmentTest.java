package com.kiyotakeshi.employeeManagement.repository.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class DepartmentTest {

    @Autowired
    TestEntityManager em;

    @Test
    void mapping() {
        Department department = new Department("general affairs");
        em.persistAndFlush(department);
    }
}
