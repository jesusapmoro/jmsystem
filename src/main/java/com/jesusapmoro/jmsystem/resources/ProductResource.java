package com.jesusapmoro.jmsystem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesusapmoro.jmsystem.entities.Product;
import com.jesusapmoro.jmsystem.services.ProductService;

//essa clase é um recurso web que é implementado por um contolador leste. 
//Colocar uma anotação em cima da classe
//Dar um nome pro meu recurso, colocar aqui @RequestMapping

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;

	//Esse recurso é uses, criar um médoto que vai ser um end point para acessar os usúarios
	//O tipo de retorno desse método vair ser um ResponseEntity que é um tipo específico do spring para retornar respostas de requisição Web
	//Esse Response Entity é um tipo genéric ele espera um tipo, e o tipo da minha resposta vai ser a minha classe Product.
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}

