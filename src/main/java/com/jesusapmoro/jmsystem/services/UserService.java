package com.jesusapmoro.jmsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jesusapmoro.jmsystem.entities.User;
import com.jesusapmoro.jmsystem.repositories.UserRepository;
import com.jesusapmoro.jmsystem.services.exceptions.DatabaseException;
import com.jesusapmoro.jmsystem.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);//deixa objeto monitorado pelo JPA, para eu trabalhar com  e em seguida eu posso efefuar uma operação c/ banco de dados
			updateData(entity, obj);
			return repository.save(entity);		
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	//updateData: vai atualizar os dados com base que chegou aqui no obj
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
