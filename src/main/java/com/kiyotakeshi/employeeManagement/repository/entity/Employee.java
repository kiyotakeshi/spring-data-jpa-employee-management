package com.kiyotakeshi.employeeManagement.repository.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    public static enum Gender {
        male, female
    }

    @Id
    @GeneratedValue
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

    public Employee(String firstName, String lastName, Gender gender, LocalDate birthday, String mailAddress, List<Telephone> telephones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.mailAddress = mailAddress;
        this.telephones = telephones;
    }

    public Employee() {
    }
}
