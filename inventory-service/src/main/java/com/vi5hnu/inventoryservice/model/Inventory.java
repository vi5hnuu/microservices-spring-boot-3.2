package com.vi5hnu.inventoryservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity()
@Table(name = "t_inventory")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false,unique = true,updatable = false)
    private String skuCode;

    @Column(nullable = false)
    private Integer quantity;
}
