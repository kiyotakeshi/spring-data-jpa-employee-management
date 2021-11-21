package com.kiyotakeshi.employeeManagement.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer"}) // LAZY fetch の場合は設定が必要
public class Department implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    public Department(String name) {
        this.name = name;
    }
}
