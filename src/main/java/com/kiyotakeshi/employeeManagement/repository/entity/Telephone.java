package com.kiyotakeshi.employeeManagement.repository.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

// 他のエンティティクラスに埋め込まれていることを示す
// 電話番号だけに単体でアクセスすることがなく、
// 必ず社員テーブルと結合してアクセスするため、エンティティとしては定義しない
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
