package com.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableConfigServer
@EnableScheduling
@EnableCircuitBreaker
public class ActuatorApplication {

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(ActuatorApplication.class, args);
	}

}
