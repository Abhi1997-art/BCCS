package com.service.banking.model.dashboardModel;

import java.util.Date;

public class DailyDueResultModel {

	private String accountNumber; // account table
	private String memberName; // memeber table...
	private String fatherName; // memeber table...
	private String permanentAddress; // member table
	private String phoneNos; // member table
	private String amount; // premiums
	private Date dueDate; // premiums
	// agent........./always null
	private String dealerName; // dealer table....
	private String accountType;

	public DailyDueResultModel(String accountNumber, String memberName, String fatherName, String permanentAddress,
			String phoneNos, String amount, Date dueDate, String dealerName, String accountType) {
		super();
		this.accountNumber = accountNumber;
		this.memberName = memberName;
		this.fatherName = fatherName;
		this.permanentAddress = permanentAddress;
		this.phoneNos = phoneNos;
		this.amount = amount;
		this.dueDate = dueDate;
		this.dealerName = dealerName;
		this.accountType = accountType;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPhoneNos() {
		return phoneNos;
	}

	public void setPhoneNos(String phoneNos) {
		this.phoneNos = phoneNos;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
}
