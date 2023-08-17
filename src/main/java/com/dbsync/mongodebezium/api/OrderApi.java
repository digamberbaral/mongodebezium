package com.dbsync.mongodebezium.api;

import com.dbsync.mongodebezium.model.AddOrderRequest;
import com.dbsync.mongodebezium.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderApi {
    private final OrderService orderService;

    @PostMapping("/create-order")
    public ResponseEntity<String> createOrder(@RequestBody @Valid AddOrderRequest addOrderRequest) {
        orderService.createOrder(addOrderRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
