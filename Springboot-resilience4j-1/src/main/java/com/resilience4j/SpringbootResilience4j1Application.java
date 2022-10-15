package com.resilience4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootResilience4j1Application {

		public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SpringbootResilience4j1Application.class, args);

	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
