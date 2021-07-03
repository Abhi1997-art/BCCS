package com.service.banking.model.dashboardModel;

import java.math.BigDecimal;
import java.util.Date;

import com.service.banking.utils.DateFormater;

public class DueDeatailsModel {
	
	    
         public Integer id;
		public String accountNumber; 
	    public String memberName; 
	    public String fatherName; 
	    public String permanentAddress; 
	    public String phoneNos; 
	    public String amount; 
	    public String dueDate; 
	    public Integer cadreNo;
	    public String agentName;
	    public Integer memberNo;
	    public String agentAddress;
	    public String landmark;
	    public Boolean isDefaulter;
	    public String dealerName;
	    public String accountType;
	    
	    public BigDecimal currentBalanceDr;
		public String agentCode="BCCSAG";
		public Integer memberId;
		
	    
		public DueDeatailsModel() {
		}

// for DDS AND FD AND MIS AND RECURRING VIEW....................

		public DueDeatailsModel(Integer id,String accountNumber, String memberName, String fatherName, String permanentAddress,
				String phoneNos, BigDecimal currentBalanceDr,Date dueDate, Integer cadreNo, String agentName, Integer memberNo, String agentAddress,
				String landmark, Boolean isDefaulter, String dealerName, Integer memberId) {
			super();
			this.id = id;		
			this.accountNumber = accountNumber;
			this.memberName = memberName;
			this.fatherName = fatherName;
			this.permanentAddress = permanentAddress;
			this.phoneNos = phoneNos;
			this.currentBalanceDr = currentBalanceDr;
	    	this.dueDate = DateFormater.getformatDate(dueDate);
			this.cadreNo = cadreNo;
			this.agentName = agentName;
			this.memberNo = memberNo;
			this.agentAddress = agentAddress;
			this.landmark = landmark;
			this.isDefaulter = isDefaulter;
			this.dealerName = dealerName;
			this.memberId=memberId;
			
		}

 //FOR DAILY ,MONTHLY,WEEKLY DUE............................

		public DueDeatailsModel(Integer id,String accountNumber, String memberName, String fatherName, String permanentAddress,
				String phoneNos, String amount, Date dueDate, Integer cadreNo, String agentName, Integer memberNo,
				String agentAddress, String landmark, Boolean isDefaulter, String dealerName,String accountType, Integer memberId ) {
			super();
			this.id = id;
			this.accountNumber = accountNumber;
			this.memberName = memberName;
			this.fatherName = fatherName;
			this.permanentAddress = permanentAddress;
			this.phoneNos = phoneNos;
			this.amount = amount;
			this.dueDate =  DateFormater.getformatDate(dueDate);
			this.cadreNo = cadreNo;
			this.agentName = agentName;
			this.memberNo = memberNo;
			this.agentAddress = agentAddress;
			this.landmark = landmark;
			this.isDefaulter = isDefaulter;
			this.dealerName = dealerName;
		    this.accountType = accountType;
		    this.memberId=memberId;
		}

		
		public Integer getId() {
			return id;
		}



		public void setId(Integer id) {
			this.id = id;
		}



		public BigDecimal getCurrentBalanceDr() {
			return currentBalanceDr;
		}



		public void setCurrentBalanceDr(BigDecimal currentBalanceDr) {
			this.currentBalanceDr = currentBalanceDr;
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



		public String getDueDate() {
			return dueDate;
		}



		public void setDueDate(String dueDate) {
			this.dueDate = dueDate;
		}



		public Integer getCadreNo() {
			return cadreNo;
		}



		public void setCadreNo(Integer cadreNo) {
			this.cadreNo = cadreNo;
		}



		public String getAgentCode() {
			return agentCode;
		}



		public void setAgentCode(String agentCode) {
			this.agentCode = agentCode;
		}



		public String getAgentName() {
			return agentName;
		}



		public void setAgentName(String agentName) {
			this.agentName = agentName;
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



		public String getDealerName() {
			return dealerName;
		}



		public void setDealerName(String dealerName) {
			this.dealerName = dealerName;
		}

		public String getAccountType() {
			return accountType;
		}

		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}

		public Integer getMemberId() {
			return memberId;
		}

		public void setMemberId(Integer memberId) {
			this.memberId = memberId;
		}



}
