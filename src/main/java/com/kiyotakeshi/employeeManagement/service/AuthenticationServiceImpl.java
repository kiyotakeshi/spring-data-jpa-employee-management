package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.repository.AuthenticationRepository;
import com.kiyotakeshi.employeeManagement.repository.entity.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private AuthenticationRepository authenticationRepository;

    public AuthenticationServiceImpl(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    public void registerInitial(Authentication authentication) {
        authenticationRepository.save(authentication);
    }
}
