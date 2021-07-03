package com.service.banking.model.dashboardModel;

import java.util.Date;

import org.hibernate.id.IntegralDataTypeHolder;

import com.service.banking.utils.DateFormater;

public class InsurenceDueList {
    
	
	Integer id;
	private String accountNumber;
	private String memberName;
	private String fatherName;
	private String phoneNos;
	       String  loanInsurenceDate;
	private String dealerName;
	private String permanentAddress;
	
	
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
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getPhoneNos() {
		return phoneNos;
	}

	public void setPhoneNos(String phoneNos) {
		this.phoneNos = phoneNos;
	}

	public String getLoanInsurenceDate() {
		return loanInsurenceDate;
	}

	public void setLoanInsurenceDate(String loanInsurenceDate) {
		this.loanInsurenceDate = loanInsurenceDate;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public InsurenceDueList(Integer id,String accountNumber, String memberName, String fatherName, String phoneNos,
			Date loanInsurenceDate, String dealerName, String permanentAddress) {
		super();
		this.id=id;
		this.accountNumber = accountNumber;
		this.memberName = memberName;
		this.fatherName = fatherName;
		this.phoneNos = phoneNos;
		this.loanInsurenceDate = DateFormater.getformatDate(loanInsurenceDate) ;
		this.dealerName = dealerName;
		this.permanentAddress = permanentAddress;
	}

}
