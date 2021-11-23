package com.kiyotakeshi.employeeManagement.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductUpdateRequest {
    private int price;
}
