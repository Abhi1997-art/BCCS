package com.service.banking.model.hodAuthorityModel;

import java.math.BigDecimal;
import java.util.Date;

public class UnlockAccountsDetails {

	int id;
	BigDecimal openingBalanceDr;
	BigDecimal openingBalanceCr;
	String accountNumber;
	Date createdAt;
	BigDecimal currentBalanceCr;
	String accountType;
	String name;
	String currentAddress;
	String fatherName;
	String permanentAddress;
	boolean isActive;

	public UnlockAccountsDetails() {
		super();
	}

	public UnlockAccountsDetails(int id, BigDecimal openingBalanceDr, BigDecimal openingBalanceCr, String accountNumber,
			Date createdAt, BigDecimal currentBalanceCr, String accountType, String name, String currentAddress,
			String fatherName, String permanentAddress, boolean isActive) {
		super();
		this.id = id;
		this.openingBalanceDr = openingBalanceDr;
		this.openingBalanceCr = openingBalanceCr;
		this.accountNumber = accountNumber;
		this.createdAt = createdAt;
		this.currentBalanceCr = currentBalanceCr;
		this.accountType = accountType;
		this.name = name;
		this.currentAddress = currentAddress;
		this.fatherName = fatherName;
		this.permanentAddress = permanentAddress;
		this.isActive = isActive;
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
	 * @return the openingBalanceDr
	 */
	public BigDecimal getOpeningBalanceDr() {
		return openingBalanceDr;
	}

	/**
	 * @param openingBalanceDr the openingBalanceDr to set
	 */
	public void setOpeningBalanceDr(BigDecimal openingBalanceDr) {
		this.openingBalanceDr = openingBalanceDr;
	}

	/**
	 * @return the openingBalanceCr
	 */
	public BigDecimal getOpeningBalanceCr() {
		return openingBalanceCr;
	}

	/**
	 * @param openingBalanceCr the openingBalanceCr to set
	 */
	public void setOpeningBalanceCr(BigDecimal openingBalanceCr) {
		this.openingBalanceCr = openingBalanceCr;
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
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the currentBalanceCr
	 */
	public BigDecimal getCurrentBalanceCr() {
		return currentBalanceCr;
	}

	/**
	 * @param currentBalanceCr the currentBalanceCr to set
	 */
	public void setCurrentBalanceCr(BigDecimal currentBalanceCr) {
		this.currentBalanceCr = currentBalanceCr;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
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
	 * @return the currentAddress
	 */
	public String getCurrentAddress() {
		return currentAddress;
	}

	/**
	 * @param currentAddress the currentAddress to set
	 */
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
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
	 * @return the permanentAddress
	 */
	public String getPermanentAddress() {
		return permanentAddress;
	}

	/**
	 * @param permanentAddress the permanentAddress to set
	 */
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
