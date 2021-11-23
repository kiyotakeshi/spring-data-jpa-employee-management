package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.model.AuthorizationRequest;
import com.kiyotakeshi.employeeManagement.repository.AuthorizationRepository;
import com.kiyotakeshi.employeeManagement.repository.entity.Authorization;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    private final AuthorizationRepository authorizationRepository;

    public AuthorizationServiceImpl(AuthorizationRepository authorizationRepository) {
        this.authorizationRepository = authorizationRepository;
    }

    @Override
    public List<Authorization> getAuthorizations() {
        return authorizationRepository.findAll();
    }

    @Override
    public List<Employee> listAuthorizationEmployees(Integer authorizationId) {
        return authorizationRepository.findById(authorizationId).orElseThrow().getEmployees();
    }

    @Override
    public Authorization registerAuthorization(AuthorizationRequest request) {
        Authorization authorization = new Authorization(request.getName());
        return authorizationRepository.save(authorization);
    }
}
