package com.service.banking.model.accountsModel;

import java.time.LocalDateTime;
import java.util.Date;

public class SMAccountsDetails {
	
	
	public Integer id;
   	public String accountNumber;
   	public Date createdAt;
   	public String name;
   	public Integer memberNo;
   	public String currentAddress;
   	public String fatherName;
	public String branchName;
	public String schemaName;
	
	private Boolean activeStatus;
	private int memberId;
	private Integer schemeId;
	private String nominee;
	private Short nomineeAge;
	private String relationWithNominee;
	private Double amount;
	private String accountType;
	
	
	public SMAccountsDetails() {
		super();
	}
	public SMAccountsDetails(Integer id, String accountNumber, Date createdAt, String name, Integer memberNo,
			String currentAddress, String fatherName, String branchName, String schemeName) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.createdAt = createdAt;
		this.name = name;
		this.memberNo = memberNo;
		this.currentAddress = currentAddress;
		this.fatherName = fatherName;
		this.branchName = branchName;
		this.schemaName = schemeName;
	}
	
	
	
	public SMAccountsDetails(Integer id, String accountNumber, Date createdAt, String name, Integer memberNo,
			String currentAddress, String fatherName, String branchName, String schemeName, Boolean activeStatus,
			int memberId, Integer schemeId, String nominee, Short nomineeAge, String relationWithNominee, Double amount,
			String accountType) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.createdAt = createdAt;
		this.name = name;
		this.memberNo = memberNo;
		this.currentAddress = currentAddress;
		this.fatherName = fatherName;
		this.branchName = branchName;
		this.schemaName = schemeName;
		this.activeStatus = activeStatus;
		this.memberId = memberId;
		this.schemeId = schemeId;
		this.nominee = nominee;
		this.nomineeAge = nomineeAge;
		this.relationWithNominee = relationWithNominee;
		this.amount = amount;
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getSchemaName() {
		return schemaName;
	}
	public void setSchemeName(String schemaName) {
		this.schemaName = schemaName;
	}
	public Boolean getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Integer getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(Integer schemeId) {
		this.schemeId = schemeId;
	}
	public String getNominee() {
		return nominee;
	}
	public void setNominee(String nominee) {
		this.nominee = nominee;
	}
	public Short getNomineeAge() {
		return nomineeAge;
	}
	public void setNomineeAge(Short nomineeAge) {
		this.nomineeAge = nomineeAge;
	}
	public String getRelationWithNominee() {
		return relationWithNominee;
	}
	public void setRelationWithNominee(String relationWithNominee) {
		this.relationWithNominee = relationWithNominee;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	   
   	
   	
   	
}
