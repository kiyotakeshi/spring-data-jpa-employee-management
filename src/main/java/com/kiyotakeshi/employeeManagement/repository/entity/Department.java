package com.kiyotakeshi.employeeManagement.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
//@JsonIgnoreProperties({"hibernateLazyInitializer"}) // LAZY fetch の場合は設定が必要
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department(String name) {
        this.name = name;
    }

    /**
     * 新規追加した従業員を未所属に指定する
     * @return
     */
    public static Department newEmployeeAffiliation() {
        return new Department(999, "Independent");
    }
}
