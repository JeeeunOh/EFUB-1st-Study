package com.efub.kurlyclone.web.dto;

import com.efub.kurlyclone.domain.event.Event;
import lombok.Getter;

@Getter
public class EventResponseDto {
    private Long event_id;
    private String event_name;
    private String event_description;
    private String image;

    public EventResponseDto(Event entity){
        this.event_id = entity.getId();
        this.event_name = entity.getName();
        this.event_description = entity.getDescript();
        this.image = entity.getProductList().get(0).getProduct_image();
    }
}
