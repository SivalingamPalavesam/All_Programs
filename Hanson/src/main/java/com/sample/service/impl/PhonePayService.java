package com.sample.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.GooglePay;
import com.sample.model.PhonePay;
import com.sample.payload.PaymentRequest;
import com.sample.repository.PhonePayRepo;
import com.sample.service.PaymentService;

@Service("PhonePay")
public class PhonePayService implements PaymentService
{
	@Autowired
	PhonePayRepo phPayRepo;

	private static final Logger logger = LoggerFactory.getLogger(PhonePayService.class);
			@Override
			public String Pay(PaymentRequest request) 
			{
				PhonePay phonePay =new PhonePay( request.getamount(),request.getpaymentMethod());
				phPayRepo.save(phonePay);
				logger.info("Amount Paid Successfull in PhonePay");
				return request.getamount()+"~Amount Paid Successfull In..!"+request.getpaymentMethod();
			}

}
