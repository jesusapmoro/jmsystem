package com.jesusapmoro.jmsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesusapmoro.jmsystem.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
