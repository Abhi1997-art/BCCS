package com.service.banking.model.dashboardModel;

import java.math.BigDecimal;

public class AccountsOpenTodayDetails {

//	a.id,a.accountNumber ,m.name,m.fatherName ,m.permanentAddress ,m.phoneNos ,s.name ,a.amount ,d.name ,a.currentBalanceCr, \r\n" + 
	//"agnt.codeNo,agntmem.name,agntmem.memberNo ,agntmem.permanentAddress ,agntmem.landmark ,agntmem.isDefaulter
// java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double
	Integer id;
	String accountNumber;
	String memebrName;
	String fatherName;
	String permanentAddress;
	String phoneNos;
	String schemename;
	Double amount;
	String dealername;
	BigDecimal currentBalanceCr;
	Integer codeNo;
	String name;
	Integer memberNo;
	String agentAddress;
	String landmark;
	Boolean isDefaulter;
	
	public AccountsOpenTodayDetails() {
		super();
	}
	public AccountsOpenTodayDetails(Integer id, String accountNumber, String memebrName, String fatherName,
			String permanentAddress, String phoneNos, String schemename, Double amount, String dealername,
			BigDecimal currentBalanceCr, Integer codeNo, String name, Integer memberNo, String agentAddress,
			String landmark, Boolean isDefaulter) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.memebrName = memebrName;
		this.fatherName = fatherName;
		this.permanentAddress = permanentAddress;
		this.phoneNos = phoneNos;
		this.schemename = schemename;
		this.amount = amount;
		this.dealername = dealername;
		this.currentBalanceCr = currentBalanceCr;
		this.codeNo = codeNo;
		this.name = name;
		this.memberNo = memberNo;
		this.agentAddress = agentAddress;
		this.landmark = landmark;
		this.isDefaulter = isDefaulter;
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
	public String getMemebrName() {
		return memebrName;
	}
	public void setMemebrName(String memebrName) {
		this.memebrName = memebrName;
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
	public String getSchemename() {
		return schemename;
	}
	public void setSchemename(String schemename) {
		this.schemename = schemename;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDealername() {
		return dealername;
	}
	public void setDealername(String dealername) {
		this.dealername = dealername;
	}
	public BigDecimal getCurrentBalanceCr() {
		return currentBalanceCr;
	}
	public void setCurrentBalanceCr(BigDecimal currentBalanceCr) {
		this.currentBalanceCr = currentBalanceCr;
	}
	public Integer getCodeNo() {
		return codeNo;
	}
	public void setCodeNo(Integer codeNo) {
		this.codeNo = codeNo;
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
	public String getAgentAddress() {
		return agentAddress;
	}
	public void setAgentAddress(String agentAddress) {
		this.agentAddress = agentAddress;
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
	
	
	
	
	
	
	
	
	
}
