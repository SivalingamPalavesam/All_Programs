package com.sample.payload;


public class PaymentRequest 
{
	private String amount;
	
	private String paymentMethod;

	public String getamount() {
		return amount;
	}

	public void setamount(String amount) {
		this.amount = amount;
	}

	public String getpaymentMethod() {
		return paymentMethod;
	}

	public void setpaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	
	
}
