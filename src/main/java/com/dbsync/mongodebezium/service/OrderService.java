package com.dbsync.mongodebezium.service;

import com.dbsync.mongodebezium.entity.Order;
import com.dbsync.mongodebezium.entity.OrderItem;
import com.dbsync.mongodebezium.entity.OrderStatus;
import com.dbsync.mongodebezium.model.AddOrderItemRequest;
import com.dbsync.mongodebezium.model.AddOrderRequest;
import com.dbsync.mongodebezium.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void createOrder(AddOrderRequest addOrderRequest){
        Order order = Order.builder()
                .userId(addOrderRequest.getUserId())
                .addressId(addOrderRequest.getAddressId())
                .orderStatus(OrderStatus.ORDERED)
                .build();

        List<OrderItem> orderItemList = new ArrayList<>();
        BigDecimal totalPrice =  BigDecimal.ZERO;
        for(AddOrderItemRequest addOrderRequest1 : addOrderRequest.getOrderItems()){
            int orderQuantity = addOrderRequest1.getQuantity();
            BigDecimal productPrice = addOrderRequest1.getPrice();
            OrderItem orderItem = OrderItem.builder()
                    .price(productPrice)
                    .quantity(orderQuantity)
                    .productId(addOrderRequest1.getProductId())
                    .build();

            BigDecimal totalPriceForProduct = productPrice.multiply(BigDecimal.valueOf(orderQuantity));
            totalPrice = totalPrice.add(totalPriceForProduct);
            orderItemList.add(orderItem);
        }
        order.setOrderItemList(orderItemList);
        order.setTotalPrice(totalPrice);
        orderRepository.save(order);
    }
}
