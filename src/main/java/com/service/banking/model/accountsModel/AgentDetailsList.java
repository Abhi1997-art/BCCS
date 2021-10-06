package com.service.banking.model.accountsModel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgentDetailsList {
	

	Integer id;
	Integer moId;
	Integer agentId;
	String name;
	String accountNumber;
	Integer accountId;
	String username;
	Integer agentCodeNo;
	String gaurantor1address;
	Date fromDate;
	Date toDate;
	
	String permanentAddress;
	String agentCurrentAddress;
	String landmark;
	Boolean isDefaulter;
	Integer codeNo;

	String fatherName;
	String agentName;
	String moName;
	String currentAddress;
	
	public AgentDetailsList() {
		super();
	}
	
	public AgentDetailsList(Integer moId, String name) {
		this.moId = moId;
		this.name = name;
	}

	
	
	public AgentDetailsList(Integer codeNo, String agentName, Integer agentId, String permanentAddress, String landmark,Boolean isDefaulter) {
		this.codeNo = codeNo;
		this.agentName = agentName;
		this.agentId = agentId;
		this.permanentAddress = permanentAddress;
		this.landmark = landmark;
		this.isDefaulter=isDefaulter;
	}

	public AgentDetailsList(Integer agentCodeNo, String agentName, Integer agentId, String agentCurrentAddress, String landmark) {
		this.agentCodeNo = agentCodeNo;
		this.agentName = agentName;
		this.agentId = agentId;
		this.currentAddress = agentCurrentAddress;
		this.landmark = landmark;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public Integer getMoId() {
		return moId;
	}

	public void setMoId(Integer moId) {
		this.moId = moId;
	}
	
	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
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
	 * @return the memberName
	 */


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

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAgentCodeNo() {
		return agentCodeNo;
	}

	public void setAgentCodeNo(Integer agentCodeNo) {
		this.agentCodeNo = agentCodeNo;
	}

	public Boolean getDefaulter() {
		return isDefaulter;
	}

	public void setDefaulter(Boolean defaulter) {
		isDefaulter = defaulter;
	}

	/**
	 * @return the gaurantor1address
	 */
	public String getGaurantor1address() {
		return gaurantor1address;
	}

	/**
	 * @param gaurantor1address the gaurantor1address to set
	 */
	public void setGaurantor1address(String gaurantor1address) {
		this.gaurantor1address = gaurantor1address;
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
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public Boolean getIsDefaulter() {
		return isDefaulter;
	}

	public void setIsDefaulter(Boolean isDefaulter) {
		this.isDefaulter = isDefaulter;
	}

	public Integer getCodeNo() {
		return codeNo;
	}

	public void setCodeNo(Integer codeNo) {
		this.codeNo = codeNo;
	}

	public String getMoName() {
		return moName;
	}

	public void setMoName(String moName) {
		this.moName = moName;
	}

	public String getAgentCurrentAddress() {
		return agentCurrentAddress;
	}

	public void setAgentCurrentAddress(String agentCurrentAddress) {
		this.agentCurrentAddress = agentCurrentAddress;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
}
