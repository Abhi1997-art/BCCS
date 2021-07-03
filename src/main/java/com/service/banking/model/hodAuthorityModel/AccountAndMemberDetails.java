package com.service.banking.model.hodAuthorityModel;

public class AccountAndMemberDetails {
	int accountId;
	String accountNumber;
	String memberName;
	String fatherName;
	
	public AccountAndMemberDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AccountAndMemberDetails(int accountId, String accountNumber, String memberName, String fatherName) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.memberName = memberName;
		this.fatherName = fatherName;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public String getName() {
		return memberName;
	}
	
	public void setName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getFatherName() {
		return fatherName;
	}
	
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
	
}