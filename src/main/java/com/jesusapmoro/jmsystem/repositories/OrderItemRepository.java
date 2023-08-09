package com.jesusapmoro.jmsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesusapmoro.jmsystem.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
