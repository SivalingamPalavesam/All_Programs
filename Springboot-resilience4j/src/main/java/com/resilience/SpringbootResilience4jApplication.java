package com.resilience;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resilience.entity.Order;
import com.resilience.repository.OrderRepository;


@SpringBootApplication
@RestController
@RequestMapping("/orders")
public class SpringbootResilience4jApplication 
{
	private static final Logger logger = LoggerFactory.getLogger(SpringbootResilience4jApplication.class);
	
	@Autowired
    private OrderRepository orderRepository;

    @PostConstruct
    public void initOrdersTable() {
        orderRepository.saveAll(Stream.of(
                        new Order("mobile", "electronics", "white", 20000),
                        new Order("T-Shirt", "clothes", "black", 999),
                        new Order("Jeans", "clothes", "blue", 1999),
                        new Order("Laptop", "electronics", "gray", 50000),
                        new Order("digital watch", "electronics", "black", 2500),
                        new Order("Fan", "electronics", "black", 50000)
                ).
                collect(Collectors.toList()));
    }

	@GetMapping
	public List<Order> getOrders(){
		return orderRepository.findAll();
	}
	@GetMapping("/{category}")
	public List<Order> getOrdersByCategory(@PathVariable String category){
		return orderRepository.findByCategory(category);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootResilience4jApplication.class, args);
	}

}
