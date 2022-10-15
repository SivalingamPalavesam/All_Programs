package com.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="phonepay")
public class PhonePay 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@Column(name ="amount")
	private String amount;
	
	@Column(name ="paymentMethod")
	private String paymentMethod;

	public PhonePay(String amount, String paymentMethod) {
		this.amount = amount;
		this.paymentMethod = paymentMethod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getamount() {
		return amount;
	}

	public void setUserName(String amount) {
		this.amount = amount;
	}

	public String getpaymentMethod() {
		return paymentMethod;
	}

	public void setpaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
}
