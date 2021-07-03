package com.service.banking.model.superAdminModel;

import java.util.Date;

import com.service.banking.utils.DateFormater;

public class ShareCertificateDetails {
	int id;
	int name;
	String status;
	int startShareNo;
	int endShareNo;
	String createdAt;
	String submittedAt;
	long shareCount;
	String memberName;
	int memberNo;
	String currentAddress;
	String landmark;
	boolean isDefaulter;
	String accountNumber;
	Integer memberId;

	public ShareCertificateDetails() {
		super();
	}

	public ShareCertificateDetails(int id, int name, String status, int startShareNo, int endShareNo, Date createdAt, Date submittedAt,
			long shareCount, String memberName, int memberNo, String currentAddress, String landmark,
			boolean isDefaulter, String accountNumber, Integer memberId) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.startShareNo = startShareNo;
		this.createdAt = DateFormater.getformatDate(createdAt);
		this.submittedAt = DateFormater.getformatDate(submittedAt);
		this.shareCount = shareCount;
		this.memberName = memberName;
		this.memberNo = memberNo;
		this.currentAddress = currentAddress;
		this.landmark = landmark;
		this.isDefaulter = isDefaulter;
		this.accountNumber=accountNumber;
		this.endShareNo = endShareNo;
		this.memberId=memberId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStartShareNo() {
		return startShareNo;
	}

	public void setStartShareNo(int startShareNo) {
		this.startShareNo = startShareNo;
	}

	public int getEndShareNo() {
		return endShareNo;
	}

	public void setEndShareNp(int endShareNp) {
		this.endShareNo = endShareNo;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmittedAt(String submittedAt) {
		this.submittedAt = submittedAt;
	}

	public long getShareCount() {
		return shareCount;
	}

	public void setShareCount(long shareCount) {
		this.shareCount = shareCount;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public boolean getIsDefaulter() {
		return isDefaulter;
	}

	public void setIsDefaulter(boolean isDefaulter) {
		this.isDefaulter = isDefaulter;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setDefaulter(boolean isDefaulter) {
		this.isDefaulter = isDefaulter;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public void setEndShareNo(int endShareNo) {
		this.endShareNo = endShareNo;
	}
	
	
	

}
