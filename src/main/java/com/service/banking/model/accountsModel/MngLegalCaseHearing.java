package com.service.banking.model.accountsModel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MngLegalCaseHearing {
	private Integer accountId;
	private Integer memberId;
	private Integer accountLegalCaseId;
	private Integer accountLegalCaseHearingId;
	private Integer dealerId;
	
	private String accountNumber;
	private String memberName;
	private String fatherName;
	private String legalCaseNo;
	private String bccsFileNo;
	private String court;
	private String authorisedPerson;
	private String caseType;
	private String stage;
	private String caseOn;
	private String fileVerifiedBy;
	private String advocate;
	private String remarks;
	private Date legalFillingDate;
	private Date lasttHearingDate;
	private String owner;
	private Integer accountGuarantorId;
	private String accountGuarantorName;
	private String accountGuarantorAddress;
	private String accountGuarantorLandmark;
	private String dealerName;
	private Boolean isAccountGuarantorDefualter;
	
	public MngLegalCaseHearing() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	(a.id, a.AccountNumber, m.id, m.name, m.fatherName, alc.name, alc.bccsFileNo, alc.court, alc.autorisedPerson, alc.caseType, \r\n"
//			+ "alc.stage, alc.caseOn, alc.fileVerifiedBy, alc.advocate, alc.remarks, a.legalFilingDate, MAX(alch.hearingDate), m.name, mag.id, mag.name, mag.permanentAddress, \r\n"
//			+ "mag.landmark, mag.isDefaulter)
//	
//			(Integer accountId, String AccountNumber, Integer memberId, String memberName, String fatherName, String legalCaseNo, 
//					String bccsFileNo, String court, String authorisedPerson, String caseType, String stage, String caseOn, String fileVerifiedBy, 
//					String advocate, String remarks, Date legalFillingDate, Date lasttHearingDate, String owner, Integer accountGuarantorId, 
//					String accountGuarantorName, String accountGuarantorAddress, String accountGuarantorLandmark, Boolean isAccountGuarantorDefualter)
	
	public MngLegalCaseHearing(Integer accountId, String accountNumber, Integer memberId, String memberName, String fatherName, String legalCaseNo, 
			String bccsFileNo, String court, String authorisedPerson, String caseType, String stage, String caseOn, String fileVerifiedBy, 
			String advocate, String remarks, Date legalFillingDate, Date lasttHearingDate, String owner, Integer accountGuarantorId, 
			String accountGuarantorName, String accountGuarantorAddress, String accountGuarantorLandmark, Boolean isAccountGuarantorDefualter
			, Integer accountLegalCaseId, Integer accountLegalCaseHearingId) {
		super();
		this.accountId = accountId;
		this.memberId = memberId;
		this.accountNumber = accountNumber;
		this.memberName = memberName;
		this.fatherName = fatherName;
		this.legalCaseNo = legalCaseNo;
		this.bccsFileNo = bccsFileNo;
		this.court = court;
		this.authorisedPerson = authorisedPerson;
		this.caseType = caseType;
		this.stage = stage;
		this.caseOn = caseOn;
		this.fileVerifiedBy = fileVerifiedBy;
		this.advocate = advocate;
		this.remarks = remarks;
		this.legalFillingDate = legalFillingDate;
		this.lasttHearingDate = lasttHearingDate;
		this.owner = owner;
		this.accountGuarantorId = accountGuarantorId;
		this.accountGuarantorName = accountGuarantorName;
		this.accountGuarantorAddress = accountGuarantorAddress;
		this.accountGuarantorLandmark = accountGuarantorLandmark;
		this.isAccountGuarantorDefualter = isAccountGuarantorDefualter;
		this.accountLegalCaseId = accountLegalCaseId;
		this.accountLegalCaseHearingId = accountLegalCaseHearingId;
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
	public Integer getAccountGuarantorId() {
		return accountGuarantorId;
	}
	public void setAccountGuarantorId(Integer accountGuarantorId) {
		this.accountGuarantorId = accountGuarantorId;
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
	public String getLegalCaseNo() {
		return legalCaseNo;
	}
	public void setLegalCaseNo(String legalCaseNo) {
		this.legalCaseNo = legalCaseNo;
	}
	public String getBccsFileNo() {
		return bccsFileNo;
	}
	public void setBccsFileNo(String bccsFileNo) {
		this.bccsFileNo = bccsFileNo;
	}
	public String getCourt() {
		return court;
	}
	public void setCourt(String court) {
		this.court = court;
	}
	public String getAuthorisedPerson() {
		return authorisedPerson;
	}
	public void setAuthorisedPerson(String authorisedPerson) {
		this.authorisedPerson = authorisedPerson;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getCaseOn() {
		return caseOn;
	}
	public void setCaseOn(String caseOn) {
		this.caseOn = caseOn;
	}
	public String getFileVerifiedBy() {
		return fileVerifiedBy;
	}
	public void setFileVerifiedBy(String fileVerifiedBy) {
		this.fileVerifiedBy = fileVerifiedBy;
	}
	public String getAdvocate() {
		return advocate;
	}
	public void setAdvocate(String advocate) {
		this.advocate = advocate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getLegalFillingDate() {
		return legalFillingDate;
	}
	public void setLegalFillingDate(Date legalFillingDate) {
		this.legalFillingDate = legalFillingDate;
	}
	public Date getLasttHearingDate() {
		return lasttHearingDate;
	}
	public void setLasttHearingDate(Date lasttHearingDate) {
		this.lasttHearingDate = lasttHearingDate;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getAccountGuarantorName() {
		return accountGuarantorName;
	}
	public void setAccountGuarantorName(String accountGuarantorName) {
		this.accountGuarantorName = accountGuarantorName;
	}
	public String getAccountGuarantorAddress() {
		return accountGuarantorAddress;
	}
	public void setAccountGuarantorAddress(String accountGuarantorAddress) {
		this.accountGuarantorAddress = accountGuarantorAddress;
	}
	public String getAccountGuarantorLandmark() {
		return accountGuarantorLandmark;
	}
	public void setAccountGuarantorLandmark(String accountGuarantorLandmark) {
		this.accountGuarantorLandmark = accountGuarantorLandmark;
	}
	public Boolean getIsAccountGuarantorDefualter() {
		return isAccountGuarantorDefualter;
	}
	public void setIsAccountGuarantorDefualter(Boolean isAccountGuarantorDefualter) {
		this.isAccountGuarantorDefualter = isAccountGuarantorDefualter;
	}

	public Integer getAccountLegalCaseId() {
		return accountLegalCaseId;
	}

	public void setAccountLegalCaseId(Integer accountLegalCaseId) {
		this.accountLegalCaseId = accountLegalCaseId;
	}

	public Integer getAccountLegalCaseHearingId() {
		return accountLegalCaseHearingId;
	}

	public void setAccountLegalCaseHearingId(Integer accountLegalCaseHearingId) {
		this.accountLegalCaseHearingId = accountLegalCaseHearingId;
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
	
	
	
}