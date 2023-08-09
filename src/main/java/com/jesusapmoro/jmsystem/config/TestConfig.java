package com.jesusapmoro.jmsystem.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jesusapmoro.jmsystem.entities.Category;
import com.jesusapmoro.jmsystem.entities.Order;
import com.jesusapmoro.jmsystem.entities.User;
import com.jesusapmoro.jmsystem.entities.enums.OrderStatus;
import com.jesusapmoro.jmsystem.repositories.CategoryRepository;
import com.jesusapmoro.jmsystem.repositories.OrderRepository;
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
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1); 

		
		useRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	
}
