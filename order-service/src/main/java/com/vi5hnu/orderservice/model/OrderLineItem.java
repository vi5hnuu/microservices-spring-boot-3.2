package com.vi5hnu.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "t_order_line_item")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItem {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
