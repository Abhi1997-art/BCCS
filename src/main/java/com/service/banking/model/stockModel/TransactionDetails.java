package com.service.banking.model.stockModel;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionDetails {
	
	int id;
	private String qty;
	public String itemName;
	private String narration;
	private BigDecimal amount;
	private Date createdAt;
	private String transactionType;
	private String smemberName;
	
	public TransactionDetails(int id, String qty, String itemName, String narration, BigDecimal amount, Date createdAt,
			String transactionType, String smemberName) {
		super();
		this.id = id;
		this.qty = qty;
		this.itemName = itemName;
		this.narration = narration;
		this.amount = amount;
		this.createdAt = createdAt;
		this.transactionType = transactionType;
		this.smemberName = smemberName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getNarration() {
		return narration;
	}
	public void setNarration(String narration) {
		this.narration = narration;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getSmemberName() {
		return smemberName;
	}
	public void setSmemberName(String smemberName) {
		this.smemberName = smemberName;
	}
	
	

}
