package com.kiyotakeshi.employeeManagement.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    // 非所有者(Department)側にも employee のフィールドを持ち、
    // OneToMany にすることで双方向のリレーションにできる
    // 所有者側の ManyToOne を指定したフィールド名を mappedBy に指定
    // EAGER にすると http://localhost:9090/departments/1/employees で department を取得する際に join して employee も取得する
    // @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "department")
    @OrderBy("id")
    @JsonBackReference
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
    }
}
