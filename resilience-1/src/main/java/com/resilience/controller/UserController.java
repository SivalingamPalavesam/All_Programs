package com.resilience.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.resilience.dto.OrderDTO;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.bulkhead.annotation.Bulkhead.Type;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/user-service")
public class UserController 
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	@Lazy
	private RestTemplate restTemplate;

	public static final String USER_SERVICE="userService";
	
	public static final String ORDER_SERVICE="orderService";

	private static final String BASEURL = "http://localhost:9092/orders";

	private int attempt=1;
	@GetMapping("/displayOrders")
	@CircuitBreaker(name =USER_SERVICE,fallbackMethod = "getAllAvailableProducts")
	//@Bulkhead(name = USER_SERVICE,fallbackMethod = "getAllAvailableProducts",type=Type.SEMAPHORE)
	//@Retry(name = USER_SERVICE,fallbackMethod = "getAllAvailableProducts")
	public List<OrderDTO> displayOrders(@RequestParam("category") String category)  
	{
		String url = category == null ? BASEURL : BASEURL + "/" + category;
		logger.info("now i enter the method!!!,{}");
		//Thread.sleep(5000);
		logger.info("now i exist the method!!!  "+attempt++ +"times "+" at "+new Date());
		return restTemplate.getForObject(url, ArrayList.class);
	}
	@GetMapping("/displayOrders1")
	@Bulkhead(name = USER_SERVICE,fallbackMethod = "getAllAvailableProducts")
	public List<OrderDTO> displayOrders1(@RequestParam("category") String category) throws Exception  
	{
		String url = category == null ? BASEURL : BASEURL + "/" + category;
		logger.info("now i enter the method!!!,{}");
	    Thread.sleep(5000);
		System.out.println("Circuitbreaker method called "+attempt++ +" times "+" at "+new Date());
		return restTemplate.getForObject(url, ArrayList.class);
	}

	public List<OrderDTO> getAllAvailableProducts(Exception e){
		return Stream.of(
				new OrderDTO(119, "LED TV", "electronics", "white", 45000),
				new OrderDTO(345, "Headset", "electronics", "black", 7000),
				new OrderDTO(475, "Sound bar", "electronics", "black", 13000),
				new OrderDTO(574, "Puma Shoes", "foot wear", "black & white", 4600),
				new OrderDTO(678, "Vegetable chopper", "kitchen", "blue", 999),
				new OrderDTO(532, "Oven Gloves", "kitchen", "gray", 745)
		).collect(Collectors.toList());
	}
}
