package com.kiyotakeshi.employeeManagement.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Authorization implements Serializable {

    @Id
    private String id;

    private String name;

    // 被所有者(Authorization) のフィールドに
    // 所有者側のエンティティのフィールド名を指定
    @ManyToMany(mappedBy = "authorizations", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JsonIgnore
    private List<Employee> employees;

    public Authorization(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
