package com.service.banking.model.superAdminModel;

import java.util.Date;

import com.service.banking.utils.DateFormater;

public class ShareHistoryDetails {

	private Integer id;
	private Integer ShareId;
	private Integer memberId;
	private String name;
	private Integer memberNo;
	private String currentAddress;
	private String landmark;
	private boolean isDefaulter;
	private Integer shareCertificateId;
	private Integer no;
	private String status;
	private String accountNumber;
	private Date createdAt;
	private Integer shareCertificateName;
	private Date fromDate;
	private Date finalToDate;
	
	

	public ShareHistoryDetails() {
		super();
	}
	
	

	public ShareHistoryDetails(Integer memberId, Integer shareCertificateId, Date fromDate, Date finalToDate) {
		super();
		this.memberId = memberId;
		this.shareCertificateId = shareCertificateId;
		this.fromDate = fromDate;
		this.finalToDate = finalToDate;
	}



	public ShareHistoryDetails(Integer id, Integer ShareId, Integer memberId, String name, Integer memberNo,
			String currentAddress, String landmark, boolean isDefaulter, Integer shareCertificateId, Integer no,
			String status, String accountNumber, Date createdAt, Integer shareCertificateName, Date fromDate,
			Date finalToDate) {
		super();
		this.id = id;
		this.ShareId = ShareId;
		this.memberId = memberId;
		this.name = name;
		this.memberNo = memberNo;
		this.currentAddress = currentAddress;
		this.landmark = landmark;
		this.isDefaulter = isDefaulter;
		this.shareCertificateId = shareCertificateId;
		this.no = no;
		this.status = status;
		this.accountNumber = accountNumber;
		this.createdAt = createdAt;
		this.shareCertificateName = shareCertificateName;
		this.fromDate = fromDate;
		this.finalToDate = finalToDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShareId() {
		return ShareId;
	}

	public void setShareId(Integer shareId) {
		ShareId = shareId;
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

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getFinalToDate() {
		return finalToDate;
	}

	public void setFinalToDate(Date finalToDate) {
		this.finalToDate = finalToDate;
	}

	@Override
	public String toString() {
		return "ShareHistoryDetails [id=" + id + ", ShareId=" + ShareId + ", memberId=" + memberId + ", name=" + name
				+ ", memberNo=" + memberNo + ", currentAddress=" + currentAddress + ", landmark=" + landmark
				+ ", isDefaulter=" + isDefaulter + ", shareCertificateId=" + shareCertificateId + ", no=" + no
				+ ", status=" + status + ", accountNumber=" + accountNumber + ", createdAt=" + createdAt
				+ ", shareCertificateName=" + shareCertificateName + ", fromDate=" + fromDate + ", finalToDate="
				+ finalToDate + "]";
	}

}
