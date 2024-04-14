package com.vi5hnu.orderservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity()
@Table(name = "t_orders")
@Builder
@Getter
@Setter
public class Order {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false,unique = true,updatable = false)
    private String orderNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItem> orderLineItems;
}
