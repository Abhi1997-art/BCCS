package com.service.banking.model.GstModel;

public class TransactionType {
     
	Integer id;
	String transactionType;
	
	
	public TransactionType() {
		super();
	}
	public TransactionType( String transactionType) {
		super();
		//this.id = id;
		this.transactionType = transactionType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	
	
	
}
