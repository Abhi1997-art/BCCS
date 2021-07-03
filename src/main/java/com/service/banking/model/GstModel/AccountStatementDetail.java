package com.service.banking.model.GstModel;

import java.math.BigDecimal;
import java.util.Date;

public class AccountStatementDetail {
	
	public Integer id;
	public String memorandumType;
	public String accountNumber;
	public String name;
	public String fatherName;
	public String narration;
	 public Date createdAt;
	 public String tax;
	public BigDecimal taxAmount;
	public String taxNarration;
	public BigDecimal amountCr;
	public BigDecimal amountDr;
	
	public AccountStatementDetail() {
		super();
	}
	
	public AccountStatementDetail(Integer id, String memorandumType, String accountNumber, String name,
			String fatherName, String narration, Date createdAt, String tax, BigDecimal taxAmount, String taxNarration,
			BigDecimal amountCr, BigDecimal amountDr) {
		super();
		this.id = id;
		this.memorandumType = memorandumType;
		this.accountNumber = accountNumber;
		this.name = name;
		this.fatherName = fatherName;
		this.narration = narration;
		this.createdAt = createdAt;
		this.tax = tax;
		this.taxAmount = taxAmount;
		this.taxNarration = taxNarration;
		this.amountCr = amountCr;
		this.amountDr = amountDr;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMemorandumType() {
		return memorandumType;
	}
	public void setMemorandumType(String memorandumType) {
		this.memorandumType = memorandumType;
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
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}
	public String getTaxNarration() {
		return taxNarration;
	}
	public void setTaxNarration(String taxNarration) {
		this.taxNarration = taxNarration;
	}
	public BigDecimal getAmountCr() {
		return amountCr;
	}
	public void setAmountCr(BigDecimal amountCr) {
		this.amountCr = amountCr;
	}
	public BigDecimal getAmountDr() {
		return amountDr;
	}
	public void setAmountDr(BigDecimal amountDr) {
		this.amountDr = amountDr;
	}
	
	
	


}
