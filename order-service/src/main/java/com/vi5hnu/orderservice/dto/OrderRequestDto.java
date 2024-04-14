package com.vi5hnu.orderservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDto {
    @NotNull(message = "orderNumber cannot be null")
    @NotEmpty(message = "orderNumber cannot be empty")
    @NotBlank(message = "orderNumber cannot blank")
    private String orderNumber;

    @NotNull(message = "invalid items")
    @NotEmpty(message = "list cannot be empty")
    private List<OrderLineItemDto> orderLineItems;
}
