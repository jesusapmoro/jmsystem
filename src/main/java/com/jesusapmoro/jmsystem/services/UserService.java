package com.jesusapmoro.jmsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesusapmoro.jmsystem.entities.User;
import com.jesusapmoro.jmsystem.repositories.UserRepository;

//registrar com dependência
@Service
public class UserService {
	
	//o meu UserService vai ter que ter uma dependência para o use repository
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
}
