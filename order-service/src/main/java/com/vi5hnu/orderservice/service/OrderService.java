package com.vi5hnu.orderservice.service;

import com.vi5hnu.orderservice.dto.OrderLineItemDto;
import com.vi5hnu.orderservice.dto.OrderRequestDto;
import com.vi5hnu.orderservice.model.Order;
import com.vi5hnu.orderservice.model.OrderLineItem;
import com.vi5hnu.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequestDto orderRequestDto) {
        final var savedOrder = orderRepository.save(mapToDto(orderRequestDto));
        log.info("order received for order number {}",savedOrder.getOrderNumber());
    }

    private OrderLineItem mapToDto(OrderLineItemDto orderItem){
        return OrderLineItem.builder().skuCode(orderItem.getSkuCode()).quantity(orderItem.getQuantity()).quantity(orderItem.getQuantity()).price(orderItem.getPrice()).build();
    }
    private Order mapToDto(OrderRequestDto orderRequestDto){
        return Order.builder()
                .orderNumber(orderRequestDto.getOrderNumber())
                .orderLineItems(orderRequestDto.getOrderLineItems().stream().map(this::mapToDto).toList()).build();
    }
}
