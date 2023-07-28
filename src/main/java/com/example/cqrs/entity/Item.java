package com.example.cqrs.entity;

import com.example.cqrs.dto.ItemRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;

    private int quantity;

    public static Item from(ItemRequestDto requestDto) {
        return Item.builder()
                .name(requestDto.getName())
                .quantity(requestDto.getQuantity())
                .build();
    }
}
