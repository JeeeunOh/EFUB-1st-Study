package com.efub.kurlyclone.web.dto;

import com.efub.kurlyclone.domain.product.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductSaveRequestDto {
    private String name;
    private Integer price;
    private Long event;
    private Long category;
    private Float sale;
    private Integer recommend;
    private String image;

    @Builder
    public ProductSaveRequestDto(String name, Integer price, Long event, Long category, Float sale, Integer recommend, String image){
        this.name = name;
        this.price = price;
        this.event = event;
        this.category = category;
        this.sale = sale;
        this.recommend = recommend;
        this.image = image;
    }

    public Product toEntity(){
        return Product.builder()
                .product_name(name)
                .product_price(price)
                .event(event)
                .category(category)
                .sale(sale)
                .recommend(recommend)
                .product_image(image)
                .build();
    }

}
