package com.kiyotakeshi.employeeManagement.repository.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductTest {

    @Autowired
    TestEntityManager em;

    @Test
    void mapping() {
//        Product product = new Product(
//                new Product.Id("bussiness", "display1"),
//                20000,
//                "user",
//                LocalDate.now(),
//                null,
//                null
//        );
        Product product = new Product(
                new Product.Id("bussiness", "display1"),
                20000
        );
        em.persistAndFlush(product);
    }
}
