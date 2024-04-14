package com.vi5hnu.orderservice.controller;

import com.vi5hnu.orderservice.dto.OrderRequestDto;
import com.vi5hnu.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("new")
    public ResponseEntity<Map<String, Object>> placeOrder(@RequestBody() @Valid() OrderRequestDto orderRequestDto){
        orderService.placeOrder(orderRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.ofEntries(Map.entry("success",true),Map.entry("message","order placed successfully")));
    }
}
