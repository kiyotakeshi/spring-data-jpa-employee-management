package com.kiyotakeshi.employeeManagement.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    public static enum Gender {
        male, female
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false)
    private String firstName;

    @Column(length = 20, nullable = false)
    private String lastName;

    // enum をデータベースの列に文字列としてマッピング
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    private LocalDate birthday;

    @Column(unique = true)
    private String mailAddress;

    // コレクション型のフィールドで別テーブルにマッピングする
    // マッピングされる別テーブルは主キーは持たず外部キー制約が設定される
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Telephone> telephones;

    // 所有者側(Employee) のフィールドに null を設定できないようにする
    // FetchType.LAZY の場合 Department に JsonIgnoreProperties の設定が必要
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "departmentId")
//    @JsonManagedReference
    private Department department;

    // 所有者(Authentication) のフィールド名を指定
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Authentication authentication;

    @ManyToMany
    // 結合テーブルの名前を設定
    // 指定しない場合は employee_authorizations(table), employees_id(column), authorizations_id(column) になった
    @JoinTable(
            name = "employeeAuthorization",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "authorizationId")
    )
    private List<Authorization> authorizations = new ArrayList<>();

    public void addAuthorizations(List<Authorization> authorizations) {
        this.authorizations.clear();
        this.authorizations.addAll(authorizations);
    }

    public Employee(String firstName, String lastName, Gender gender, LocalDate birthday, String mailAddress, List<Telephone> telephones, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.mailAddress = mailAddress;
        this.telephones = telephones;
        this.department = department;
    }
}
