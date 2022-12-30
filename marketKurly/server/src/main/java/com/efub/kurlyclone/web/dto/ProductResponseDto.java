package com.efub.kurlyclone.web.dto;

import com.efub.kurlyclone.domain.product.Product;
import lombok.Getter;

@Getter
public class ProductResponseDto {
    private Long id;
    private String name;
    private Integer price;
    private Long category;
    private Long event;
    private Float sale;
    private Integer recommend;
    private String image;

    public ProductResponseDto(Product entity){
        this.id = entity.getProduct_id();
        this.name = entity.getProduct_name();
        this.price = entity.getProduct_price();
        this.category = entity.getCategory();
        this.event = entity.getEvent();
        this.sale = entity.getSale();
        this.recommend = entity.getRecommend();
        this.image = entity.getProduct_image();
    }

}
