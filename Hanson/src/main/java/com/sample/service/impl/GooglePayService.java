package com.sample.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.GooglePay;
import com.sample.payload.PaymentRequest;
import com.sample.repository.GooglePayRepo;
import com.sample.service.PaymentService;

@Service("GooglePay")
public class GooglePayService  implements PaymentService
{
	@Autowired
	GooglePayRepo googlePayRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(GooglePayService.class);

	@Override
	public String Pay(PaymentRequest request)
	{
		GooglePay googlePay =new GooglePay( request.getamount(),request.getpaymentMethod());
		googlePayRepo.save(googlePay);
		logger.info("Amount Paid Successfull In GooglePay");
		return request.getamount()+"~Amount Paid Successfull In..!"+request.getpaymentMethod();
	}

}
