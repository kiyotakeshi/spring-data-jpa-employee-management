package com.kiyotakeshi.employeeManagement.repository;

import com.kiyotakeshi.employeeManagement.repository.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository extends JpaRepository<Authentication, Integer> {
}
