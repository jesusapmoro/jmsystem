package com.jesusapmoro.jmsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesusapmoro.jmsystem.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
