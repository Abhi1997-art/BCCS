package com.service.banking.model.printingModel;

import java.math.BigDecimal;
import java.util.Date;

public class ContentAccount {
//a.id,m.name,m.fatherName ,m.permanentAddress ,a.createdAt ,a.amount ,a.accountNumber
	Integer id;
	String name;
	String fatherName;
	String permanentAddress;
	Date createdAt;
	double amount;
	String accountNumber;
	
	

	public ContentAccount() {
		super();
	}



	public ContentAccount(Integer id, String name, String fatherName, String permanentAddress, Date createdAt,
			double amount, String accountNumber) {
		super();
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.permanentAddress = permanentAddress;
		this.createdAt = createdAt;
		this.amount = amount;
		this.accountNumber = accountNumber;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getFatherName() {
		return fatherName;
	}



	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}



	public String getPermanentAddress() {
		return permanentAddress;
	}



	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public String getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	
	
	
}
