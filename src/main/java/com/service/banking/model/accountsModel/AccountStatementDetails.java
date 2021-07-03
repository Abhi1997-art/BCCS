package com.service.banking.model.accountsModel;

import java.math.BigDecimal;
import java.util.Date;

public class AccountStatementDetails {
	 
	Integer id;
	String accountNumber;
	String name;
	String fatherName;
	public Double amount;
	public BigDecimal voucherNo;
	public Date createdAt;
	public Integer invoiceNo;
	public String narration;
	public BigDecimal amountDr;
	public BigDecimal amountCr;
	public String side;
	
	
	
	
	public AccountStatementDetails() {
		super();
	}
	public AccountStatementDetails(Integer id, String accountNumber, String name, String fatherName, Double amount,
			BigDecimal voucherNo, Date createdAt, Integer invoiceNo, String narration, BigDecimal amountDr,
			BigDecimal amountCr, String side) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.name = name;
		this.fatherName = fatherName;
		this.amount = amount;
		this.voucherNo = voucherNo;
		this.createdAt = createdAt;
		this.invoiceNo = invoiceNo;
		this.narration = narration;
		this.amountDr = amountDr;
		this.amountCr = amountCr;
		this.side = side;
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
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public BigDecimal getVoucherNo() {
		return voucherNo;
	}
	public void setVoucherNo(BigDecimal voucherNo) {
		this.voucherNo = voucherNo;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(Integer invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getNarration() {
		return narration;
	}
	public void setNarration(String narration) {
		this.narration = narration;
	}
	public BigDecimal getAmountDr() {
		return amountDr;
	}
	public void setAmountDr(BigDecimal amountDr) {
		this.amountDr = amountDr;
	}
	public BigDecimal getAmountCr() {
		return amountCr;
	}
	public void setAmountCr(BigDecimal amountCr) {
		this.amountCr = amountCr;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	
	
	

}
