package com.service.banking.model.hodAuthorityModel;

public class LockUnlockAcntDetails {
	Integer accountId;
	String accountNumber;
	String branch;
	String staffName;
	Integer memberId;
	String memberName;
	String memberAddress;
	Boolean isDefaulter;
	Boolean lockingStatus;
	Boolean maturedStatus;
	String lockReason;
	Boolean isActive;
	String fatherName;
	String landmark;

	public LockUnlockAcntDetails() {

	}

	public LockUnlockAcntDetails(Integer accountId, String accountNumber, String branch, String staffName,
			Integer memberId, String memberName, String memberAddress, Boolean isDefaulter, Boolean lockingStatus,
			Boolean maturedStatus, String lockReason, Boolean isActive, String landmark) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.branch = branch;
		this.staffName = staffName;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberAddress = memberAddress;
		this.isDefaulter = isDefaulter;
		this.lockingStatus = lockingStatus;
		this.maturedStatus = maturedStatus;
		this.lockReason = lockReason;
		this.isActive = isActive;
		this.landmark=landmark;
	}

	public LockUnlockAcntDetails(Integer accountId, String accountNumber, Integer memberId, String memberName,
			String fatherName) {
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.memberId = memberId;
		this.memberName = memberName;
		this.fatherName = fatherName;
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
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

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public Boolean getIsDefaulter() {
		return isDefaulter;
	}

	public void setIsDefaulter(Boolean isDefaulter) {
		this.isDefaulter = isDefaulter;
	}

	public Boolean getLockingStatus() {
		return lockingStatus;
	}

	public void setLockingStatus(Boolean lockingStatus) {
		this.lockingStatus = lockingStatus;
	}

	public Boolean getMaturedStatus() {
		return maturedStatus;
	}

	public void setMaturedStatus(Boolean maturedStatus) {
		this.maturedStatus = maturedStatus;
	}

	public String getLockReason() {
		return lockReason;
	}

	public void setLockReason(String lockReason) {
		this.lockReason = lockReason;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	
}