package com.kiyotakeshi.employeeManagement.repository.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
@ToString
@Getter
@Setter
public class Telephone {
    private String number;
    private String type;

    public Telephone() {
    }

    public Telephone(String number, String type) {
        this.number = number;
        this.type = type;
    }
}
