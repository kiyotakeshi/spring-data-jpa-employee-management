package com.kiyotakeshi.employeeManagement.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Authentication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore // フロントに不要な値のため
    private Integer id;

    private String password;

    // 所有者側(認証テーブル)のフィールドに null 値を設定できないようにする
    @OneToOne(optional = false)
    @JoinColumn(name = "employeeId", nullable = false, unique = true) // エンティティ自身のテーブル名の列名を指定
    @JsonIgnore // Jackson によるシリアライズを行わない(循環参照になるため)
    private Employee employee;

    public Authentication(String password) {
        this.password = password;
    }

    public Authentication(String password, Employee employee) {
        this.password = password;
        this.employee = employee;
    }
}
