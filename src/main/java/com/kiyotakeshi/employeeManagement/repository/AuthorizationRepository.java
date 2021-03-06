package com.kiyotakeshi.employeeManagement.repository;

import com.kiyotakeshi.employeeManagement.repository.entity.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorizationRepository extends JpaRepository<Authorization, Integer> {
    // @see https://stackoverflow.com/a/60532225
    // @see https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    List<Authorization> findAllByNameIn(List<String> names);

    Authorization findByName(String name);
}
