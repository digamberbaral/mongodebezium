package com.dbsync.mongodebezium.model;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class AddOrderRequest {
    @NonNull
    private String userId;
    @NonNull
    private String addressId;
    @NonNull
    private List<AddOrderItemRequest> orderItems;
}
