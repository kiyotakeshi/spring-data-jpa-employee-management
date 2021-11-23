package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.repository.entity.Authentication;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;

public interface AuthenticationService {
    /**
     * 管理者がユーザを払い出し、後からユーザ自身でパスワードを変えてもらう運用を想定
     * @param newCreatedEmployee
     * @return
     */
    Authentication registerInitial(Employee newCreatedEmployee);
}
