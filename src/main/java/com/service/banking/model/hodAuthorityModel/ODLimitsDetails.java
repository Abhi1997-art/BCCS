package com.service.banking.model.hodAuthorityModel;

import java.math.BigDecimal;

public class ODLimitsDetails {

	int id;
	String accountNumber;
	String accountType;
	BigDecimal currentBalanceCr;
	int bankAccountLimit;
	
	
	

	public ODLimitsDetails() {
		super();
	}

	public ODLimitsDetails(int id, String accountNumber, String accountType, BigDecimal currentBalanceCr,
			int bankAccountLimit) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.currentBalanceCr = currentBalanceCr;
		this.bankAccountLimit = bankAccountLimit;
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
	 * @return the bankAccountLimit
	 */
	public int getBankAccountLimit() {
		return bankAccountLimit;
	}

	/**
	 * @param bankAccountLimit the bankAccountLimit to set
	 */
	public void setBankAccountLimit(int bankAccountLimit) {
		this.bankAccountLimit = bankAccountLimit;
	}

}
