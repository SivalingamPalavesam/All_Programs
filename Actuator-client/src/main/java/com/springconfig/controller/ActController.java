package com.springconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
public class ActController 
{
	@Value("${my.message: default value}")
	private String message;
	
	@Autowired
	private Environment env;
	
	
	@GetMapping("/message")
	public String message()
	{
		return message ;
	}
	@GetMapping("/envdetails")
	public String envDetails()
	{
		return env.toString();
	}
	
}

