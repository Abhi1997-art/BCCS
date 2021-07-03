package com.service.banking.model.stockModel;

import java.math.BigDecimal;
import java.util.Date;

public class LedgerItemDetails {
	
	//int, java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.lang.String, java.lang.String
	
	int id;
	public String qty;
	public String itemName;
	public String narration;
	public Date createdAt;
	public String transactionType;
	public String toBranchId;
	
	
	public LedgerItemDetails(int id, String qty, String itemName, String narration, Date createdAt,
			String transactionType, String toBranchId) {
		super();
		this.id = id;
		this.qty = qty;
		this.itemName = itemName;
		this.narration = narration;
		this.createdAt = createdAt;
		this.transactionType = transactionType;
		this.toBranchId = toBranchId;
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
	public String getToBranchId() {
		return toBranchId;
	}
	public void setToBranchId(String toBranchId) {
		this.toBranchId = toBranchId;
	}
	
	
}
