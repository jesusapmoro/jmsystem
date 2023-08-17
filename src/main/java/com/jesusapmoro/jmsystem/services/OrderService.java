package com.jesusapmoro.jmsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesusapmoro.jmsystem.entities.Order;
import com.jesusapmoro.jmsystem.repositories.OrderRepository;

//registrar com dependência
@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	//private Product product;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
	
	
	public Order insert(Order obj) {
		return repository.save(obj);
		
		
		/*
		OrderItem orderItem = new OrderItem();
		orderItem.setOrder(obj);
		orderItem.setProduct();
		orderItem.setPrice(product.getPrice());
		orderItem.setQuantity(null);
		OrderItem newOrderItem = orderRepository.save(orderItem);
		*/
	}
	
}
