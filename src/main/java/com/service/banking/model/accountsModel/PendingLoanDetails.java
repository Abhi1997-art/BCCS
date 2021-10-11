package com.service.banking.model.accountsModel;

import java.util.Date;

public class PendingLoanDetails {

	private Integer id;
	private String accountNumber;
	private Integer branchId;
	private String branchName;
	private Date createdAt;
	private Integer memberId;
	private String memberName;
	private String memberCurrentAddress;
	private Integer memberNo;
	private Boolean memberDefaulter;
	private Integer schemeId;
	private String schemeName;
	private Double loanAmount;
	private Double smAmount;
	private Integer otherAccountId;
	private String otherAccountNumber;
	private Double OtherAccountCrAmount;
	private String repaymentMode;
	private String insuranceTenure;
	private Boolean activeStatus;
	private String operationMode;
	private Date loanInsuranceDate;
	private String loanAgainstAccountId;
	private String loanAgainstAccountNumber;
	private Integer dealerId;
	private String dealerName;
	private Integer loanFromAccount;
	private Integer loanFromAccountNumber;

	public PendingLoanDetails() {
	}

	public PendingLoanDetails(Integer id, String  accountNumber, Integer branchId, String branchName, Date createdAt, Integer memberId, String memberName, Integer memberNo, String memberCurrentAddress, Boolean memberDefaulter, Integer schemeId, String schemeName, Double loanAmount, String repaymentMode, String insuranceTenure, Boolean activeStatus, String operationMode, Date loanInsuranceDate, Integer dealerId, String dealerName) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.branchId = branchId;
		this.branchName = branchName;
		this.createdAt = createdAt;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberCurrentAddress = memberCurrentAddress;
		this.memberNo = memberNo;
		this.memberDefaulter = memberDefaulter;
		this.schemeId = schemeId;
		this.schemeName = schemeName;
		this.loanAmount = loanAmount;
		this.smAmount = smAmount;
		this.otherAccountId = otherAccountId;
		this.repaymentMode = repaymentMode;
		this.insuranceTenure = insuranceTenure;
		this.activeStatus = activeStatus;
		this.operationMode = operationMode;
		this.loanInsuranceDate = loanInsuranceDate;
		this.dealerId = dealerId;
		this.dealerName = dealerName;
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

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberCurrentAddress() {
		return memberCurrentAddress;
	}

	public void setMemberCurrentAddress(String memberCurrentAddress) {
		this.memberCurrentAddress = memberCurrentAddress;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Boolean getMemberDefaulter() {
		return memberDefaulter;
	}

	public void setMemberDefaulter(Boolean memberDefaulter) {
		this.memberDefaulter = memberDefaulter;
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

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Double getSmAmount() {
		return smAmount;
	}

	public void setSmAmount(Double smAmount) {
		this.smAmount = smAmount;
	}

	public Integer getOtherAccountId() {
		return otherAccountId;
	}

	public void setOtherAccountId(Integer otherAccountId) {
		this.otherAccountId = otherAccountId;
	}

	public String getOtherAccountNumber() {
		return otherAccountNumber;
	}

	public void setOtherAccountNumber(String otherAccountNumber) {
		this.otherAccountNumber = otherAccountNumber;
	}

	public Double getOtherAccountCrAmount() {
		return OtherAccountCrAmount;
	}

	public void setOtherAccountCrAmount(Double otherAccountCrAmount) {
		OtherAccountCrAmount = otherAccountCrAmount;
	}

	public String getRepaymentMode() {
		return repaymentMode;
	}

	public void setRepaymentMode(String repaymentMode) {
		this.repaymentMode = repaymentMode;
	}

	public String getInsuranceTenure() {
		return insuranceTenure;
	}

	public void setInsuranceTenure(String insuranceTenure) {
		this.insuranceTenure = insuranceTenure;
	}

	public Boolean getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getOperationMode() {
		return operationMode;
	}

	public void setOperationMode(String operationMode) {
		this.operationMode = operationMode;
	}

	public Date getLoanInsuranceDate() {
		return loanInsuranceDate;
	}

	public void setLoanInsuranceDate(Date loanInsuranceDate) {
		this.loanInsuranceDate = loanInsuranceDate;
	}

	public String getLoanAgainstAccountId() {
		return loanAgainstAccountId;
	}

	public void setLoanAgainstAccountId(String loanAgainstAccountId) {
		this.loanAgainstAccountId = loanAgainstAccountId;
	}

	public String getLoanAgainstAccountNumber() {
		return loanAgainstAccountNumber;
	}

	public void setLoanAgainstAccountNumber(String loanAgainstAccountNumber) {
		this.loanAgainstAccountNumber = loanAgainstAccountNumber;
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

	public Integer getLoanFromAccount() {
		return loanFromAccount;
	}

	public void setLoanFromAccount(Integer loanFromAccount) {
		this.loanFromAccount = loanFromAccount;
	}

	public Integer getLoanFromAccountNumber() {
		return loanFromAccountNumber;
	}

	public void setLoanFromAccountNumber(Integer loanFromAccountNumber) {
		this.loanFromAccountNumber = loanFromAccountNumber;
	}
}
