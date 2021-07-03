package com.service.banking.model.GstModel;

public class PurchaseAccountDetails {
  
	 Integer id;
	 String accountNumber;
	 String code;
	 String name;
	 
	 
	 
	 
	public PurchaseAccountDetails(Integer id, String accountNumber, String code, String name) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.code = code;
		this.name = name;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	 
	 
}
