package com.service.banking.model.superAdminModel;

import java.util.Date;

import com.service.banking.utils.DateFormater;

public class ShareDetails {
	
	
	Integer id;
	Integer memberId;
	String name;
	Integer memberNo;
	String currentAddress;
	String landmark;
	boolean isDefaulter;
	Integer shareCertificateId;
	Integer no;
	String buybackLockingMonths;
	String transferLockingMonths;
	String status;
	String accountNumber;
	Date createdAt;
	Integer shareCertificateName;
	
	
	public ShareDetails() {
		super();
	}



	public ShareDetails(Integer id, Integer memberId, String name, Integer memberNo, String currentAddress,
			String landmark, boolean isDefaulter, Integer shareCertificateId, Integer no, String buybackLockingMonths,
			String transferLockingMonths, String status, String accountNumber, Date createdAt, Integer shareCertificateName) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.name = name;
		this.memberNo = memberNo;
		this.currentAddress = currentAddress;
		this.landmark = landmark;
		this.isDefaulter = isDefaulter;
		this.shareCertificateId = shareCertificateId;
		this.no = no;
		this.buybackLockingMonths = buybackLockingMonths;
		this.transferLockingMonths = transferLockingMonths;
		this.status = status;
		this.accountNumber = accountNumber;
		this.createdAt = createdAt;
		this.shareCertificateName=shareCertificateName;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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



	public Integer getMemberNo() {
		return memberNo;
	}



	public void setMemberNo(Integer memberNo) {
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



	public boolean isDefaulter() {
		return isDefaulter;
	}



	public void setDefaulter(boolean isDefaulter) {
		this.isDefaulter = isDefaulter;
	}



	public Integer getShareCertificateId() {
		return shareCertificateId;
	}



	public void setShareCertificateId(Integer shareCertificateId) {
		this.shareCertificateId = shareCertificateId;
	}



	public Integer getNo() {
		return no;
	}



	public void setNo(Integer no) {
		this.no = no;
	}



	public String getBuybackLockingMonths() {
		return buybackLockingMonths;
	}



	public void setBuybackLockingMonths(String buybackLockingMonths) {
		this.buybackLockingMonths = buybackLockingMonths;
	}



	public String getTransferLockingMonths() {
		return transferLockingMonths;
	}



	public void setTransferLockingMonths(String transferLockingMonths) {
		this.transferLockingMonths = transferLockingMonths;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Integer getShareCertificateName() {
		return shareCertificateName;
	}



	public void setShareCertificateName(Integer shareCertificateName) {
		this.shareCertificateName = shareCertificateName;
	}



	@Override
	public String toString() {
		return "ShareDetails [id=" + id + ", memberId=" + memberId + ", name=" + name + ", memberNo=" + memberNo
				+ ", currentAddress=" + currentAddress + ", landmark=" + landmark + ", isDefaulter=" + isDefaulter
				+ ", shareCertificateId=" + shareCertificateId + ", no=" + no + ", buybackLockingMonths="
				+ buybackLockingMonths + ", transferLockingMonths=" + transferLockingMonths + ", status=" + status
				+ ", accountNumber=" + accountNumber + ", createdAt=" + createdAt + ", shareCertificateName="
				+ shareCertificateName + "]";
	}

	
	



}