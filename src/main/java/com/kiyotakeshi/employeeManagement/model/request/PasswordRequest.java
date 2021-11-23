package com.kiyotakeshi.employeeManagement.model.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PasswordRequest {
    private String password;
}
