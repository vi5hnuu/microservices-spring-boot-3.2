package com.vi5hnu.orderservice.repository;

import com.vi5hnu.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {
}
