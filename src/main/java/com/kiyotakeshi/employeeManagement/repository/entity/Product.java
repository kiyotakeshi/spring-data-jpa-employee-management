package com.kiyotakeshi.employeeManagement.repository.entity;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * 複合主キーの定義方法の確認
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
