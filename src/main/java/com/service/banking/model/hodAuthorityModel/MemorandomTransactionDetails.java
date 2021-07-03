package com.service.banking.model.hodAuthorityModel;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL) 
public class MemorandomTransactionDetails {
	
	private Integer memorandumTransactionrowId;
	private Integer staffId;
	private String staffName;
	private Integer branchId;
	private String branchName;
	private Integer name;
	private String memorandumType;
	private String narration;
	private Date createdAt;
	private BigDecimal amountCr;
	private BigDecimal amountDr;
	private String crAccountNumber;
	private String drAccountNumber;
	private String crMemberName;
	private String drMemberName;
	private String crFatherName;
	private String drFatherName;
	private BigDecimal taxAmount;
	private Integer memorandomTransactionId;
	
	
	private String drAccountNo;
	private String crAccountNo;
	
	
	public MemorandomTransactionDetails() {
		super();
	}


	public MemorandomTransactionDetails(Integer memorandumTransactionrowId, Integer staffId, String staffName,
			Integer branchId, String branchName, Integer name, String memorandumType, String narration, Date createdAt,
			BigDecimal amountCr, BigDecimal amountDr, String crAccountNumber, String drAccountNumber,
			String crMemberName, String drMemberName, String crFatherName, String drFatherName, BigDecimal taxAmount,
			Integer memorandomTransactionId) {
		super();
		this.memorandumTransactionrowId = memorandumTransactionrowId;
		this.staffId = staffId;
		this.staffName = staffName;
		this.branchId = branchId;
		this.branchName = branchName;
		this.name = name;
		this.memorandumType = memorandumType;
		this.narration = narration;
		this.createdAt = createdAt;
		this.amountCr = amountCr;
		this.amountDr = amountDr;
		this.crAccountNumber = crAccountNumber;
		this.drAccountNumber = drAccountNumber;
		this.crMemberName = crMemberName;
		this.drMemberName = drMemberName;
		this.crFatherName = crFatherName;
		this.drFatherName = drFatherName;
		this.taxAmount = taxAmount;
		this.memorandomTransactionId = memorandomTransactionId;
	}


	public Integer getMemorandumTransactionrowId() {
		return memorandumTransactionrowId;
	}


	public void setMemorandumTransactionrowId(Integer memorandumTransactionrowId) {
		this.memorandumTransactionrowId = memorandumTransactionrowId;
	}


	public Integer getStaffId() {
		return staffId;
	}


	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}


	public String getStaffName() {
		return staffName;
	}


	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}


	public Integer getBranchId() {
		return branchId;
	}


	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public Integer getName() {
		return name;
	}


	public void setName(Integer name) {
		this.name = name;
	}


	public String getMemorandumType() {
		return memorandumType;
	}


	public void setMemorandumType(String memorandumType) {
		this.memorandumType = memorandumType;
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


	public String getCrAccountNumber() {
		return crAccountNumber;
	}


	public void setCrAccountNumber(String crAccountNumber) {
		this.crAccountNumber = crAccountNumber;
	}


	public String getDrAccountNumber() {
		return drAccountNumber;
	}


	public void setDrAccountNumber(String drAccountNumber) {
		this.drAccountNumber = drAccountNumber;
	}


	public String getCrMemberName() {
		return crMemberName;
	}


	public void setCrMemberName(String crMemberName) {
		this.crMemberName = crMemberName;
	}


	public String getDrMemberName() {
		return drMemberName;
	}


	public void setDrMemberName(String drMemberName) {
		this.drMemberName = drMemberName;
	}


	public String getCrFatherName() {
		return crFatherName;
	}


	public void setCrFatherName(String crFatherName) {
		this.crFatherName = crFatherName;
	}


	public String getDrFatherName() {
		return drFatherName;
	}


	public void setDrFatherName(String drFatherName) {
		this.drFatherName = drFatherName;
	}


	public BigDecimal getTaxAmount() {
		return taxAmount;
	}


	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}


	public Integer getMemorandomTransactionId() {
		return memorandomTransactionId;
	}


	public void setMemorandomTransactionId(Integer memorandomTransactionId) {
		this.memorandomTransactionId = memorandomTransactionId;
	}


	public String getDrAccountNo() {
		return drAccountNo;
	}


	public void setDrAccountNo(String drAccountNo) {
		this.drAccountNo = drAccountNo;
	}


	public String getCrAccountNo() {
		return crAccountNo;
	}


	public void setCrAccountNo(String crAccountNo) {
		this.crAccountNo = crAccountNo;
	}
	
	
	
	
}