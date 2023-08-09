package com.jesusapmoro.jmsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesusapmoro.jmsystem.entities.Category;
import com.jesusapmoro.jmsystem.repositories.CategoryRepository;

//registrar com dependência
@Service
public class CategoryService {
	
	//o meu CategoryService vai ter que ter uma dependência para o use repository
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
