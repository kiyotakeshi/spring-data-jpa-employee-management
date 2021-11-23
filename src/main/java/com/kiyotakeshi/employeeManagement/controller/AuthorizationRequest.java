package com.kiyotakeshi.employeeManagement.controller;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AuthorizationRequest {
    private String name;
}
