package com.service.banking.model.printingModel;

import java.math.BigDecimal;

public class MeberAccountDetail {
	
	Integer id;
	String accountNumber;
	 BigDecimal amountCr;
	 
	 
	public MeberAccountDetail() {
		super();
	}
	public MeberAccountDetail(Integer id, String accountNumber, BigDecimal amountCr) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.amountCr = amountCr;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getAmountCr() {
		return amountCr;
	}
	public void setAmountCr(BigDecimal amountCr) {
		this.amountCr = amountCr;
	}
	 
	 

}
