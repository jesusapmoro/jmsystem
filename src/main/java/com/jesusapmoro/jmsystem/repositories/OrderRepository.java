package com.jesusapmoro.jmsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesusapmoro.jmsystem.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
