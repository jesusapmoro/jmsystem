package com.jesusapmoro.jmsystem.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jesusapmoro.jmsystem.entities.User;
import com.jesusapmoro.jmsystem.repositories.UserRepository;

//Pra falar pro spring que essa aqui é uma classe especifica de configurações, colocar uma  @Configuration
//especifica para o perfil de teste, vou colocar também outra anotação @Profile

//como fazr p/ executar quando o programa for iniciado, usar macete colocando minha classe implementando uma interface chamada Command Line Runner

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	//declarar um atributo  do tipo repository
	//para que o spring consiga resolver essa dependência e associar uma instância do User repository no meu testConfig basta colocar em cima do atributo a anotacion @Autowired
	
	@Autowired
	private UserRepository useRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		useRepository.saveAll(Arrays.asList(u1, u2));
	}
}