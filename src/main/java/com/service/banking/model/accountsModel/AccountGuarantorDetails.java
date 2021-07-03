package com.service.banking.model.accountsModel;

import java.util.Date;

public class AccountGuarantorDetails {

	private Integer accountGuarantorId;
	private Integer accountId;
	private Integer memberId;
	private String memberName;
	private Integer memberNo; 
	private String permanentAddress;
	private String landmark;
	private Boolean isDefaulter;
	private Date createdAt;
	
	public AccountGuarantorDetails() {
		super();
	}
	
	public AccountGuarantorDetails(Integer accountGuarantorId, Integer accountId, Integer memberId, String memberName, Integer memberNo, 
			 String permanentAddress, String landmark, Boolean isDefaulter, Date createdAt) {
		super();
		this.accountGuarantorId = accountGuarantorId;
		this.accountId = accountId;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberNo = memberNo;
		this.permanentAddress = permanentAddress;
		this.landmark = landmark;
		this.isDefaulter = isDefaulter;
		this.createdAt = createdAt;
	}

	public Integer getAccountGuarantorId() {
		return accountGuarantorId;
	}

	public void setAccountGuarantorId(Integer accountGuarantorId) {
		this.accountGuarantorId = accountGuarantorId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
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

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
}