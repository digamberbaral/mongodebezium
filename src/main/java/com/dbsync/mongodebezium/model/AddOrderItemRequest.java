package com.dbsync.mongodebezium.model;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class AddOrderItemRequest {
    @NonNull
    private String productId;
    @NonNull
    private BigDecimal price;
    @NonNull
    private int quantity;
}
