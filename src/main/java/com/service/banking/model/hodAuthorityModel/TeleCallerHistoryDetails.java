package com.service.banking.model.hodAuthorityModel;

import java.util.Date;

public class TeleCallerHistoryDetails {

	int id;
	int accountId;
	int telecallerId;
	String name;
	String accountNumber;
	String memberName;
	String fatherName;

	Date fromDate;
	Date finalToDate;

	public TeleCallerHistoryDetails() {
		super();
	}

	public TeleCallerHistoryDetails(int id, int accountId, int telecallerId, String name, String accountNumber,
			String memberName, String fatherName, Date fromDate, Date finalToDate) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.telecallerId = telecallerId;
		this.name = name;
		this.accountNumber = accountNumber;
		this.memberName = memberName;
		this.fatherName = fatherName;
		this.fromDate = fromDate;
		this.finalToDate = finalToDate;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the accountId
	 */
	public int getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the telecallerId
	 */
	public int getTelecallerId() {
		return telecallerId;
	}

	/**
	 * @param telecallerId the telecallerId to set
	 */
	public void setTelecallerId(int telecallerId) {
		this.telecallerId = telecallerId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the finalToDate
	 */
	public Date getFinalToDate() {
		return finalToDate;
	}

	/**
	 * @param finalToDate the finalToDate to set
	 */
	public void setFinalToDate(Date finalToDate) {
		this.finalToDate = finalToDate;
	}

}
