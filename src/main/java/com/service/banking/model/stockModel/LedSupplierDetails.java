package com.service.banking.model.stockModel;

import java.util.Date;

public class LedSupplierDetails {
	int id;
	public String qty;
	public String itemName;
	public String narration;
	public Date createdAt;
	public String transactionType;
	public String toBranchId;
	
	
	
	public LedSupplierDetails(int id, String qty, String itemName, String narration, Date createdAt,
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
