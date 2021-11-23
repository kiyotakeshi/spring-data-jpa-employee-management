package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.repository.AuthenticationRepository;
import com.kiyotakeshi.employeeManagement.repository.entity.Authentication;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationRepository authenticationRepository;

    public AuthenticationServiceImpl(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    public Authentication registerInitial(Employee newCreatedEmployee) {
        Authentication authentication = new Authentication(UUID.randomUUID().toString(), newCreatedEmployee);
        return authenticationRepository.save(authentication);
    }
}
