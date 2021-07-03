package com.service.banking.model.hodAuthorityModel;

import java.util.Date;

public class AssociationDetails {
	// ms.id, ms.name ,angt.accountNumber,angt.username
	// ,angt.agentCode,angt.gaurantor1address ,magnt.fromDate,magnt.toDate

	Integer id;
	Integer memberId;
	Integer moId;
	Integer agentId;
	String name;
	String accountNumber;
	Integer accountId;
	String username;
	String agentCode;
	String gaurantor1address;
	Date fromDate;
	Date toDate;
	
	String permanentAddress;
	String landmark;
	Boolean isDefaulter;
	Integer codeNo;

	String fatherName;
	String memberName;
	String moName;
	
	public AssociationDetails() {
		super();
	}
	
	public AssociationDetails(Integer moId, String name) {
		this.moId = moId;
		this.name = name;
	}
	
	public AssociationDetails(Integer id, Integer agentId, Integer moId, String name, Integer codeNo, String memberName, Integer memberId, String permanentAddress, String landmark, boolean isDefaulter, Date fromDate, Date toDate) {
		super();
		this.id = id;
		this.agentId = agentId;
		this.moId = moId;
		this.name = name;
		this.codeNo = codeNo;
		this.memberName = memberName;
		this.memberId = memberId;
		this.permanentAddress = permanentAddress;
		this.landmark = landmark;
		this.isDefaulter = isDefaulter;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public AssociationDetails(Integer id, Integer memberId, String name, String accountNumber, String fatherName, String memberName,
			Date fromDate, Date toDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.name = name;
		this.accountNumber = accountNumber;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.fatherName = fatherName;
		this.memberName = memberName;
	}
	
	public AssociationDetails(Integer id, Integer memberId, String name, String accountNumber, String fatherName, String memberName,
			Date fromDate, Date toDate, Integer moId,Integer accountId) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.name = name;
		this.accountNumber = accountNumber;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.fatherName = fatherName;
		this.memberName = memberName;
		this.accountId=accountId;
		this.moId=moId;
	}



	public AssociationDetails(Integer id, String name, String accountNumber, String username, String agentCode,
			String gaurantor1address, Date fromDate, Date toDate) {
		super();
		this.id = id;
		this.name = name;
		this.accountNumber = accountNumber;
		this.username = username;
		this.agentCode = agentCode;
		this.gaurantor1address = gaurantor1address;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	
	public AssociationDetails(Integer id, String name, String accountNumber, String memberName, String fatherName, Date fromDate, Date toDate) {
		super();
		this.id = id;
		this.name = name;
		this.accountNumber = accountNumber;
		this.username = username;
		this.agentCode = agentCode;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	
	public AssociationDetails(Integer codeNo, String memberName, Integer memberId, String permanentAddress, String landmark,Boolean isDefaulter) {
		this.codeNo = codeNo;
		this.memberName = memberName;
		this.memberId = memberId;
		this.permanentAddress = permanentAddress;
		this.landmark = landmark;
		this.isDefaulter=isDefaulter;
	}
	
	public AssociationDetails(Integer memberId, Integer accountId, String accountNumber, String memberName, String fatherName) {
		this.memberId = memberId;
		this.accountNumber = accountNumber;
		this.accountId = accountId;
		this.memberName = memberName;
		this.fatherName = fatherName;
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
	
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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

	/**
	 * @return the agentCode
	 */
	public String getAgentCode() {
		return agentCode;
	}

	/**
	 * @param agentCode the agentCode to set
	 */
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
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
	
	
	
	

}