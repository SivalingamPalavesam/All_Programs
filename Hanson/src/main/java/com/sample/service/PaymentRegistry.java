package com.sample.service;

public interface PaymentRegistry 
{
	public PaymentService getServiceBean(String serviceName);
}
