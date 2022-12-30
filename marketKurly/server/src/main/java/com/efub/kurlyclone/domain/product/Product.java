package com.efub.kurlyclone.domain.product;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(nullable = false)
    private String product_name;

    @Column(nullable = false)
    private Integer product_price;

    private Long event;

    @Column(nullable = false)
    private Long category;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Float sale;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer recommend;

    @ColumnDefault("")
    private String product_image;

    @Builder
    public Product (String product_name, Integer product_price, Long event, Long category, Float sale, Integer recommend, String product_image){
        this.product_name = product_name;
        this.product_price = product_price;
        this.event = event;
        this.category = category;
        this.sale = sale;
        this.recommend = recommend;
        this.product_image = product_image;
    }

    @PrePersist
    public void PrePersist(){
        this.sale = this.sale == null ? 0:this.sale;
        this.recommend = this.recommend == null ? 0:this.recommend;
    }

    public void update(Float sale, Long event, Integer recommend){
        this.sale = sale;
        this.event = event;
        this.recommend = recommend;
    }
}
