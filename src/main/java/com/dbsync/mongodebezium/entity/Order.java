package com.dbsync.mongodebezium.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("orders")
public class Order {
    @Id
    private String id;
    private List<OrderItem> orderItemList = new ArrayList<>();
    private OrderStatus orderStatus;
    private BigDecimal totalPrice;
    private String userId;
    private String addressId;
    @CreatedDate
    private OffsetDateTime createdAt;
    @LastModifiedDate
    private OffsetDateTime updatedAt;
}
