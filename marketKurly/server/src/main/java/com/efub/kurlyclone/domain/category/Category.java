package com.efub.kurlyclone.domain.category;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Table(name = "category")
public class Category {

    @Id
    @Column(name="category_id")
    private Long id;

    @Column(name="category_name")
    private String name;


    @Builder
    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {

    }
}