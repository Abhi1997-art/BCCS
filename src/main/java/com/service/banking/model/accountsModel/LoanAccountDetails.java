package com.service.banking.model.accountsModel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class LoanAccountDetails {
	
	private Integer accountId;
	private String accountNumber;
	private Date createdAt;
	public Integer memberId;
	public String name;
	public Integer memberNo;
	private String permanentAddress;
	private Integer schemeId;
	private String schemeName;
	private Double amount;
	private Integer loanAgainstAccountId;
	private String loanAgainstAccountNumber;
	private Integer loanAgainstAccountMemberId;
	private String loanAgainstAccountMemberName;
	private String loanAgainstFatherName;
	private String loanAgainstAccountType;
	private Integer dealerId;
	private String dealerName;
	
	private String accountType;
	private String repaymentMode;
	
	private Boolean activeStatus;
	
	
	public LoanAccountDetails() {
		super();
	}

	
		
	public LoanAccountDetails(Integer dealerId, String dealerName) {
		super();
		this.dealerId = dealerId;
		this.dealerName = dealerName;
	}
	
	







	public LoanAccountDetails(Integer loanAgainstAccountId, String loanAgainstAccountNumber,
			Integer loanAgainstAccountMemberId, String loanAgainstAccountMemberName, String loanAgainstFatherName,
			String loanAgainstAccountType) {
		super();
		this.loanAgainstAccountId = loanAgainstAccountId;
		this.loanAgainstAccountNumber = loanAgainstAccountNumber;
		this.loanAgainstAccountMemberId = loanAgainstAccountMemberId;
		this.loanAgainstAccountMemberName = loanAgainstAccountMemberName;
		this.loanAgainstFatherName = loanAgainstFatherName;
		this.loanAgainstAccountType = loanAgainstAccountType;
	}



	public LoanAccountDetails(Integer accountId, String accountNumber, Date createdAt, Integer memberId,
			String name, Integer memberNo, String permanentAddress, Integer schemeId, String schemeName, Double amount,
			Integer loanAgainstAccountId, String loanAgainstAccountNumber, Integer loanAgainstAccountMemberId,
			String loanAgainstAccountMemberName, Integer dealerId, String dealerName, String accountType,
			String repaymentMode) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.createdAt = createdAt;
		this.memberId = memberId;
		this.name = name;
		this.memberNo = memberNo;
		this.permanentAddress = permanentAddress;
		this.schemeId = schemeId;
		this.schemeName = schemeName;
		this.amount = amount;
		this.loanAgainstAccountId = loanAgainstAccountId;
		this.loanAgainstAccountNumber = loanAgainstAccountNumber;
		this.loanAgainstAccountMemberId = loanAgainstAccountMemberId;
		this.loanAgainstAccountMemberName = loanAgainstAccountMemberName;
		this.dealerId = dealerId;
		this.dealerName = dealerName;
		this.accountType = accountType;
		this.repaymentMode = repaymentMode;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	

	public Integer getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	

	public Boolean getActiveStatus() {
		return activeStatus;
	}


	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}


	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public Integer getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(Integer schemeId) {
		this.schemeId = schemeId;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getLoanAgainstAccountId() {
		return loanAgainstAccountId;
	}

	public void setLoanAgainstAccountId(Integer loanAgainstAccountId) {
		this.loanAgainstAccountId = loanAgainstAccountId;
	}

	public String getLoanAgainstAccountNumber() {
		return loanAgainstAccountNumber;
	}

	public void setLoanAgainstAccountNumber(String loanAgainstAccountNumber) {
		this.loanAgainstAccountNumber = loanAgainstAccountNumber;
	}

	public Integer getLoanAgainstAccountMemberId() {
		return loanAgainstAccountMemberId;
	}

	public void setLoanAgainstAccountMemberId(Integer loanAgainstAccountMemberId) {
		this.loanAgainstAccountMemberId = loanAgainstAccountMemberId;
	}

	public String getLoanAgainstAccountMemberName() {
		return loanAgainstAccountMemberName;
	}

	public void setLoanAgainstAccountMemberName(String loanAgainstAccountMemberName) {
		this.loanAgainstAccountMemberName = loanAgainstAccountMemberName;
	}

	public Integer getDealerId() {
		return dealerId;
	}

	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
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

	public String getRepaymentMode() {
		return repaymentMode;
	}

	public void setRepaymentMode(String repaymentMode) {
		this.repaymentMode = repaymentMode;
	}



	public String getLoanAgainstFatherName() {
		return loanAgainstFatherName;
	}



	public void setLoanAgainstFatherName(String loanAgainstFatherName) {
		this.loanAgainstFatherName = loanAgainstFatherName;
	}



	public String getLoanAgainstAccountType() {
		return loanAgainstAccountType;
	}



	public void setLoanAgainstAccountType(String loanAgainstAccountType) {
		this.loanAgainstAccountType = loanAgainstAccountType;
	}


		
	

}