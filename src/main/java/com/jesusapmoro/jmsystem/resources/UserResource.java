package com.jesusapmoro.jmsystem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesusapmoro.jmsystem.entities.User;
import com.jesusapmoro.jmsystem.services.UserService;

//essa clase é um recurso web que é implementado por um contolador leste. 
//Colocar uma anotação em cima da classe
//Dar um nome pro meu recurso, colocar aqui @RequestMapping

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;

	//Esse recurso é uses, criar um médoto que vai ser um end point para acessar os usúarios
	//O tipo de retorno desse método vair ser um ResponseEntity que é um tipo específico do spring para retornar respostas de requisição Web
	//Esse Response Entity é um tipo genéric ele espera um tipo, e o tipo da minha resposta vai ser a minha classe User.
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}

