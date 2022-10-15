package com.sample.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.service.PaymentRegistry;

@Configuration
public class ServiceLocaterConfig 
{
	@Bean
	public FactoryBean<?> getBean()
	{
		ServiceLocatorFactoryBean bean = new  ServiceLocatorFactoryBean();
		bean.setServiceLocatorInterface(PaymentRegistry.class);
		return bean;
	}
}
