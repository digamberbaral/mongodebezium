package com.dbsync.mongodebezium.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    private String productId;
    private BigDecimal price;
    private int quantity;
}
