package com.efub.kurlyclone.domain.event;

import com.efub.kurlyclone.domain.product.Product;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table (name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="event_id")
    private Long id;

    @Column(name="event_name")
    private String name;

    @Column(name="event_descript")
    private String descript;

    @JoinColumn(name="event")
    @OneToMany
    private List<Product> productList;

    @Builder
    public Event(Long Id, String name, String descript) {
        this.descript = descript;
        this.name = name;
    }



}
