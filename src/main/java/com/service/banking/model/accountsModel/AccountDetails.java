package com.service.banking.model.accountsModel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AccountDetails {

	Integer id;
	String accountNumber;
	String name;
	String fatherName;
	String accountType;
	Integer branchId;
	Date createdAt;
	Double amount;
	Integer schemeId;
	String groupType;

	public AccountDetails() {
		super();
	}

	public AccountDetails(Integer id) {
		super();
		this.id = id;
	}

	public AccountDetails(Integer id, Integer branchId) {
		super();
		this.id = id;
		this.branchId = branchId;
	}

	public AccountDetails(Integer id, Integer branchId, String accountType, Date createdAt, Double amount, Integer schemeId) {
		super();
		this.id = id;
		this.branchId = branchId;
		this.accountType = accountType;
		this.createdAt = createdAt;
		this.amount=amount;
		this.schemeId=schemeId;
	}

	
	
	public AccountDetails(Integer id, String accountNumber, String name, String fatherName, String accountType,
			Integer branchId, Date createdAt, Double amount, Integer schemeId, String groupType) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.name = name;
		this.fatherName = fatherName;
		this.accountType = accountType;
		this.branchId = branchId;
		this.createdAt = createdAt;
		this.amount = amount;
		this.schemeId = schemeId;
		this.groupType = groupType;
	}

	public AccountDetails(Integer id, String accountNumber) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
	}

	public AccountDetails(Integer id, String accountNumber, String name, String fatherName) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.name = name;
		this.fatherName = fatherName;
	}

	public AccountDetails(Integer id, String accountNumber, String name, String fatherName, String accountType) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.name = name;
		this.fatherName = fatherName;
		this.accountType = accountType;
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(Integer schemeId) {
		this.schemeId = schemeId;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	
	
	
	
}
