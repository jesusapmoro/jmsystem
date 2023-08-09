package com.jesusapmoro.jmsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesusapmoro.jmsystem.entities.Product;
import com.jesusapmoro.jmsystem.repositories.ProductRepository;

//registrar com dependência
@Service
public class ProductService {
	
	//o meu ProductService vai ter que ter uma dependência para o use repository
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
