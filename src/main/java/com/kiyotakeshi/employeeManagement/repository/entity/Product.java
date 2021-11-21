package com.kiyotakeshi.employeeManagement.repository.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * 複合主キーの定義方法の確認
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class) // 監査情報の設定を有効化
public class Product implements Serializable {


    /**
     * 主キーを定義するためのクラス
     * Serializable interface の実装と
     * hasCode, equals の実装により、主キーの一意性が保たれる
     */
    @Embeddable
    @Getter
    @Setter
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Id implements Serializable {
        private String categoryName;
        private String productName;
    }

    @EmbeddedId
    private Id id;

    private int price;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private LocalDate createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private LocalDate lastModifiedDate;

    public Product(Id id, int price) {
        this.id = id;
        this.price = price;
    }
}
