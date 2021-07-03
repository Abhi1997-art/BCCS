package com.service.banking.model.hodAuthorityModel;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL) 
public class MemoRandomTransactionRowDetails {
	
	Integer memorandomTransactionRowId;
	Integer memorandumTransactionId;
	Integer name;
	Integer accountId;
	String accountNumber;
	Integer memberId;
	String memberName;
	String fatherName;
	String tax;
	BigDecimal taxPercentage;
	BigDecimal taxAmount;
	String taxNarration;
	String taxExcludedAmount;
	BigDecimal amountCr;
	BigDecimal amountDr;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
	Date createdAt;
	String memorandumType;
	
	public MemoRandomTransactionRowDetails() {
		super();
	}
	
//	(mtr.id, mtr.memorandumTransactionId, mt.name, "
//			+ "mtr.accountId, a.accountNumber, m.id, m.name, m.fatherName, mtr.tax, mtr.taxAmount, mtr.taxNarration, mtr.amountCr, mtr.amountDr, "
//			+ "mtr.createdAt, mt.memorandumType)"
//			+ ""
	
//	public MemoRandomTransactionRowDetails(Integer memorandomTransactionRowId, Integer memorandumTransactionId, Integer name, 
//			Integer accountId, String accountNumber, Integer memberId, String memberName, String fatherName, String tax, 
//			BigDecimal taxAmount, String taxNarration, BigDecimal amountCr, BigDecimal amountDr, 
//			Date createdAt, String memorandumType) {
//		super();
//	}
	
	
	public MemoRandomTransactionRowDetails(Integer memorandomTransactionRowId, Integer memorandumTransactionId,
		Integer name, Integer accountId, String accountNumber, Integer memberId, String memberName, String fatherName,
		String tax, BigDecimal taxPercentage, BigDecimal taxAmount, String taxNarration,String taxExcludedAmount, BigDecimal amountCr, BigDecimal amountDr, Date createdAt,
		String memorandumType) {
			super();
			this.memorandomTransactionRowId = memorandomTransactionRowId;
			this.memorandumTransactionId = memorandumTransactionId;
			this.name = name;
			this.accountId = accountId;
			this.accountNumber = accountNumber;
			this.memberId = memberId;
			this.memberName = memberName;
			this.fatherName = fatherName;
			this.tax = tax;
			this.taxPercentage = taxPercentage;
			this.taxAmount = taxAmount;
			this.taxNarration = taxNarration;
			this.taxExcludedAmount = taxExcludedAmount;
			this.amountCr = amountCr;
			this.amountDr = amountDr;
			this.createdAt = createdAt;
			this.memorandumType = memorandumType;
	}
	

	public Integer getMemorandomTransactionRowId() {
		return memorandomTransactionRowId;
	}

	public void setMemorandomTransactionRowId(Integer memorandomTransactionRowId) {
		this.memorandomTransactionRowId = memorandomTransactionRowId;
	}

	public Integer getMemorandumTransactionId() {
		return memorandumTransactionId;
	}

	public void setMemorandumTransactionId(Integer memorandumTransactionId) {
		this.memorandumTransactionId = memorandumTransactionId;
	}

	public Integer getName() {
		return name;
	}

	public void setName(Integer name) {
		this.name = name;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public BigDecimal getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(BigDecimal taxPercentage) {
		this.taxPercentage = taxPercentage;
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
	
	public String getTaxExcludedAmount() {
		return taxExcludedAmount;
	}

	public void setTaxExcludedAmount(String taxExcludedAmount) {
		this.taxExcludedAmount = taxExcludedAmount;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getMemorandumType() {
		return memorandumType;
	}

	public void setMemorandumType(String memorandumType) {
		this.memorandumType = memorandumType;
	}
	
	
	
}