package com.kiyotakeshi.employeeManagement.controller;

import com.kiyotakeshi.employeeManagement.repository.entity.Authorization;
import com.kiyotakeshi.employeeManagement.repository.entity.Employee;
import com.kiyotakeshi.employeeManagement.service.AuthorizationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authorizations")
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @GetMapping
    public List<Authorization> list(){
        return authorizationService.getAuthorizations();
    }

    @PostMapping
    public Authorization register(@RequestBody AuthorizationRequest request){
        return authorizationService.registerAuthorization(request);
    }

    @GetMapping("/{authorizationId}/employees")
    public List<Employee> listAuthorizationEmployees(@PathVariable String authorizationId){
        return authorizationService.listAuthorizationEmployees(authorizationId);
    }
}
