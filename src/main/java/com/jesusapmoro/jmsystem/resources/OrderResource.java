package com.jesusapmoro.jmsystem.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jesusapmoro.jmsystem.dto.OrderDTO;
import com.jesusapmoro.jmsystem.dto.UserDTO;
import com.jesusapmoro.jmsystem.entities.Order;
import com.jesusapmoro.jmsystem.entities.User;
import com.jesusapmoro.jmsystem.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;

	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll() {
		List<Order> list = service.findAll();
		List<OrderDTO> listDto = list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(new OrderDTO(obj));
	}
	/*
	@PostMapping
	public ResponseEntity<OrderDTO> insert(@RequestBody Order obj) {
		var createOrder = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(createOrder);
	}
	*/
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody OrderDTO objDto) {
		Order obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}

