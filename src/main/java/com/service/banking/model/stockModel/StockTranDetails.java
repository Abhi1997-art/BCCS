package com.service.banking.model.stockModel;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.service.banking.hibernateEntity.Branches;
import com.service.banking.hibernateEntity.StockContainers;
import com.service.banking.hibernateEntity.StockItems;
import com.service.banking.hibernateEntity.StockMembers;
import com.service.banking.hibernateEntity.StockRows;

//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockTranDetails {
	  
	public Integer id;
	public String qty;
	public String itemName;
	public String narration;
	public BigDecimal amount;
	public Date createdAt;
	public String transactionType;
	public String memberName;
	public String issueDate;
	public String submitDate;
	public Boolean isUsedSubmit;
	public BigDecimal rate;
	public String toBranchName;
	public String branchName;
	
	public String fromContainer;
	public String toContainer;
	public String fromRow;
	public String  toRow;
	
	
	
// for move.............
		
	public StockTranDetails(Integer id, String qty, String itemName, String narration, Date createdAt, BigDecimal rate,
			String fromContainer, String toContainer, String fromRow, String toRow) {
		super();
		this.id = id;
		this.qty = qty;
		this.itemName = itemName;
		this.narration = narration;
		this.createdAt = createdAt;
		this.rate = rate;
		this.fromContainer = fromContainer;
		this.toContainer = toContainer;
		this.fromRow = fromRow;
		this.toRow = toRow;
	}
// for reamaing other.............

	public StockTranDetails(Integer id, String qty, String itemName, 
			 BigDecimal rate,Date createdAt, String narration, BigDecimal amount,String toBranchName, String branchName) {
		super();
		this.id = id;
		this.qty = qty;
		this.itemName = itemName;
		this.rate = rate;
		this.createdAt = createdAt;
		this.narration = narration;
		this.amount = amount;
		this.toBranchName = toBranchName;
		this.branchName = branchName;
	}


	public StockTranDetails(Integer id, String qty, String itemName, String narration, BigDecimal amount,
			Date createdAt, String transactionType, String memberName) {
		super();
		this.id = id;
		this.qty = qty;
		this.itemName = itemName;
		this.narration = narration;
		this.amount = amount;
		this.createdAt = createdAt;
		this.transactionType = transactionType;
		this.memberName = memberName;
	}

	


// for purchase and purchase return.............
	public StockTranDetails(Integer id, String branchName, String itemName ,  BigDecimal rate,Date createdAt,String narration,String memberName, String qty) {
		super();
		this.id = id;
		this.branchName = branchName;
		this.itemName = itemName;
		this.rate = rate;
		this.createdAt = createdAt;
		this.narration = narration;
		this.memberName= memberName;
		this.qty = qty;
		
	}
	
	
// for  opening .................
	public StockTranDetails(Integer id, String qty, String itemName, String narration, Date createdAt, BigDecimal rate,
			String branchName) {
		super();
		this.id = id;
		this.qty = qty;
		this.itemName = itemName;
		this.narration = narration;
		this.createdAt = createdAt;
		this.rate = rate;
		this.branchName = branchName;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
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


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}


	public String getSubmitDate() {
		return submitDate;
	}


	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}


	public Boolean getIsUsedSubmit() {
		return isUsedSubmit;
	}


	public void setIsUsedSubmit(Boolean isUsedSubmit) {
		this.isUsedSubmit = isUsedSubmit;
	}


	public BigDecimal getRate() {
		return rate;
	}


	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}


	public String getToBranchName() {
		return toBranchName;
	}


	public void setToBranchName(String toBranchName) {
		this.toBranchName = toBranchName;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public String getFromContainer() {
		return fromContainer;
	}


	public void setFromContainer(String fromContainer) {
		this.fromContainer = fromContainer;
	}


	public String getToContainer() {
		return toContainer;
	}


	public void setToContainer(String toContainer) {
		this.toContainer = toContainer;
	}


	public String getFromRow() {
		return fromRow;
	}


	public void setFromRow(String fromRow) {
		this.fromRow = fromRow;
	}


	public String getToRow() {
		return toRow;
	}


	public void setToRow(String toRow) {
		this.toRow = toRow;
	}
	
	
}
