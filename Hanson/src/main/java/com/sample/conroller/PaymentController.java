package com.sample.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.payload.PaymentRequest;
import com.sample.service.PaymentRegistry;

@RestController
@RequestMapping(value="/payment")
public class PaymentController
{

	@Autowired
	PaymentRegistry registry;
	
	@PostMapping("/pay")
	public String paymentProcess(@RequestBody PaymentRequest request)
	{
		String response ="";
		response =registry.getServiceBean(request.getpaymentMethod()).Pay(request);
		return response;

	}
	
	
	
	/*	@Autowired 
	private GooglePayService googlePayService;
	
	@Autowired
	private PhonePayService phonePayService;
	
	@PostMapping("/pay")
	public String payNow(@RequestBody PaymentRequest request)
	{
		String response ="";
		if(request.getpaymentMethod().equals("googlePayService"))
		{
			response=	googlePayService.Pay(request);
		}
		if(request.getpaymentMethod().equals("phonePayService"))
		{
			response = phonePayService.Pay(request);	
		}
		return response;

	}*/
	
	
}
