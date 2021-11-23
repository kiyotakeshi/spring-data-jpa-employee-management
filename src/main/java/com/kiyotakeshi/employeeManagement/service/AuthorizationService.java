package com.kiyotakeshi.employeeManagement.service;

import com.kiyotakeshi.employeeManagement.controller.AuthorizationRequest;
import com.kiyotakeshi.employeeManagement.repository.entity.Authorization;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;

import java.util.List;

public interface AuthorizationService {

    List<Authorization> getAuthorizations();

    List<Employee> listAuthorizationEmployees(String authorizationId);

    Authorization registerAuthorization(AuthorizationRequest request);
}
