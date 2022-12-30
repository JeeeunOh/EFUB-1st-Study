package com.efub.kurlyclone.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductUpdateDto {
    private Float sale;
    private Long event;
    private Integer recommend;

    @Builder
    public ProductUpdateDto(Float sale, Long event, Integer recommend){
        this.sale = sale;
        this.event = event;
        this.recommend = recommend;
    }
}
