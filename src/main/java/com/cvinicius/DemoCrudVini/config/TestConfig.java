package com.cvinicius.DemoCrudVini.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cvinicius.DemoCrudVini.entities.Category;
import com.cvinicius.DemoCrudVini.entities.Order;
import com.cvinicius.DemoCrudVini.entities.OrderItem;
import com.cvinicius.DemoCrudVini.entities.Payment;
import com.cvinicius.DemoCrudVini.entities.Product;
import com.cvinicius.DemoCrudVini.entities.User;
import com.cvinicius.DemoCrudVini.entities.enums.OrderStatus;
import com.cvinicius.DemoCrudVini.repositories.CategoryRepository;
import com.cvinicius.DemoCrudVini.repositories.OrderItemRepository;
import com.cvinicius.DemoCrudVini.repositories.OrderRepository;
import com.cvinicius.DemoCrudVini.repositories.ProductRepository;
import com.cvinicius.DemoCrudVini.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronicos");
		Category cat2 = new Category(null, "Livros");
		Category cat3 = new Category(null, "Computadores"); 
		
		Product p1 = new Product(null, "O Senhor dos Anéis", "Livro", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Full HD 1080p", 2190.0, "");
		Product p3 = new Product(null, "Notebook Acer", "1TB, i7 intelcore, 256GB ssd, gtx1080 nvidia geforce", 3200.0, "");
		Product p4 = new Product(null, "PC Gamer", "2tb, gtx1080, 524gb ssd, 32gb ram ddr4, i7 intelcore", 4000.0, "");
		Product p5 = new Product(null, "Celular samsumg s8", "64gb, 4gb ram, 28mp", 1600.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User u1 = new User(null, "Carlos Vinicius", "c.viniciussantos@outlook.com", "1191234567", "123456");
		User u2 = new User(null, "CCEE", "ccee@ccee.org.br", "977777777", "123456");
		User u3 = new User(null, "Pessoa Qualquer", "alguem@gmail.org.br", "977777777", "123456");
		User u4 = new User(null, "Qualquer um", "emailqualquer@outlook.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2020-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2020-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2020-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
	}
}
