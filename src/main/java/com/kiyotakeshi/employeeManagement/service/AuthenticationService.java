package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.repository.entity.Authentication;

public interface AuthenticationService {
    void registerInitial(Authentication authentication);
}
