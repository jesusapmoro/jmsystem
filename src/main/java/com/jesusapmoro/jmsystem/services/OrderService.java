package com.jesusapmoro.jmsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesusapmoro.jmsystem.dto.OrderDTO;
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
	}
	
	/*
	public OrderDTO insert(Order order) {
		var orderSaved = repository.save(order);
		return new OrderDTO(orderSaved);
		
	}
	*/
	public Order fromDTO(OrderDTO objDto) {
		return new Order();
	}
	
}
