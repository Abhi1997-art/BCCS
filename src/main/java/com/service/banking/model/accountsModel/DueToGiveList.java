package com.service.banking.model.accountsModel;

import java.math.BigDecimal;
import java.util.Date;

import com.service.banking.utils.DateFormater;

public class DueToGiveList {


	Integer id;
	String accountNumber;
	String memberName; 
	String FatherName;
	String PermanentAddress;
	String PhoneNos;
	BigDecimal CurrentBalanceCr;
	String CurrentInterest; 
	String  dueDate;
	Integer codeNo;
	String agentName;
	Integer member_no;
	String agentAddress;
	String landmark;
	Boolean isDefaulter;
	Integer memberId;
  
	
	
	public DueToGiveList() {
		super();
	}
	public DueToGiveList(Integer id, String accountNumber, String memberName, String fatherName,
			String permanentAddress, String phoneNos, BigDecimal currentBalanceCr, String currentInterest,
			String dueDate, Integer codeNo, String agentName, Integer member_no, String agentAddress,
			String landmark, Boolean isDefaulter, Integer memberId) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.memberName = memberName;
		FatherName = fatherName;
		PermanentAddress = permanentAddress;
		PhoneNos = phoneNos;
		CurrentBalanceCr = currentBalanceCr;
		CurrentInterest = currentInterest;
		this.dueDate = dueDate;
		this.codeNo = codeNo;
		this.agentName = agentName;
		this.member_no = member_no;
		this.agentAddress = agentAddress;
		this.landmark = landmark;
		this.isDefaulter = isDefaulter;
		this.memberId=memberId;
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
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getFatherName() {
		return FatherName;
	}
	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}
	public String getPermanentAddress() {
		return PermanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		PermanentAddress = permanentAddress;
	}
	public String getPhoneNos() {
		return PhoneNos;
	}
	public void setPhoneNos(String phoneNos) {
		PhoneNos = phoneNos;
	}
	public BigDecimal getCurrentBalanceCr() {
		return CurrentBalanceCr;
	}
	public void setCurrentBalanceCr(BigDecimal currentBalanceCr) {
		CurrentBalanceCr = currentBalanceCr;
	}
	public String getCurrentInterest() {
		return CurrentInterest;
	}
	public void setCurrentInterest(String currentInterest) {
		CurrentInterest = currentInterest;
	}

	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public Integer getCodeNo() {
		return codeNo;
	}
	public void setCodeNo(Integer codeNo) {
		this.codeNo = codeNo;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public Integer getMember_no() {
		return member_no;
	}
	public void setMember_no(Integer member_no) {
		this.member_no = member_no;
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
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	
	
}
