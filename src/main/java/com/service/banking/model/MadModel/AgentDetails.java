package com.service.banking.model.MadModel;

import java.util.Date;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

public class AgentDetails {
	public Integer id;
	public String moName;
	public Date createdAt;
	public Integer memberId;
	public String memmberName;	
	public String city;
	public String fatherName;
	public String district;
	public String tehsil;
	public String state;
	public String currentAddress;
	public String accountNumber;
	public String cadreName;
	public Boolean activeStatus;
	public String userName;
	public Integer codeNo;
	public String addedBy;
	public String password;
	
	public String landmark;
	public Boolean defaulter;
	public Integer sponsorId;
	public String sponsorName;
	public String sponsorCurrentAddres;
	public Integer sponsorMemberId;
	public String sponsorLandmark;
	public Boolean sponsorDefaulter;
	public String sponsorCadre;
	public Integer currentIndividualCrpb;
	public Integer modId;
	public Integer accountId;
	public Integer cadreId;
	 


	public AgentDetails() {
		super();
	}


	public AgentDetails(Integer id, String moName, Date createdAt, Integer memberId, String memmberName, String city,
			String fatherName, String district, String tehsil, String state, String currentAddress,
			String accountNumber, String cadreName, Boolean activeStatus, String userName, Integer codeNo,
			String addedBy, String password, String landmark, Boolean defaulter, Integer sponsorId, String sponsorName,
			String sponsorCurrentAddres, Integer sponsorMemberId, String sponsorLandmark, Boolean sponsorDefaulter, String sponsorCadre,
			Integer currentIndividualCrpb,Integer moId, Integer accountId, Integer cadreId) {
		super();
		this.id = id;
		this.moName = moName;
		this.createdAt = createdAt;
		this.memberId = memberId;
		this.memmberName = memmberName;
		this.city = city;
		this.fatherName = fatherName;
		this.district = district;
		this.tehsil = tehsil;
		this.state = state;
		this.currentAddress = currentAddress;
		this.accountNumber = accountNumber;
		this.cadreName = cadreName;
		this.activeStatus = activeStatus;
		this.userName = userName;
		this.codeNo = codeNo;
		this.addedBy = addedBy;
		this.password = password;
		this.landmark = landmark;
		this.defaulter = defaulter;
		this.sponsorId = sponsorId;
		this.sponsorName = sponsorName;
		this.sponsorCurrentAddres = sponsorCurrentAddres;
		this.sponsorMemberId=sponsorMemberId;
		this.sponsorLandmark = sponsorLandmark;
		this.sponsorDefaulter = sponsorDefaulter;
		this.sponsorCadre = sponsorCadre;
		this.currentIndividualCrpb = currentIndividualCrpb;
		this.modId=moId;
		this.accountId=accountId;
		this.cadreId=cadreId;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getMoName() {
		return moName;
	}



	public void setMoName(String moName) {
		this.moName = moName;
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



	public String getMemmberName() {
		return memmberName;
	}



	public void setMemmberName(String memmberName) {
		this.memmberName = memmberName;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getFatherName() {
		return fatherName;
	}



	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}



	public String getDistrict() {
		return district;
	}



	public void setDistrict(String district) {
		this.district = district;
	}



	public String getTehsil() {
		return tehsil;
	}



	public void setTehsil(String tehsil) {
		this.tehsil = tehsil;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCurrentAddress() {
		return currentAddress;
	}



	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}



	public String getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public String getCadreName() {
		return cadreName;
	}



	public void setCadreName(String cadreName) {
		this.cadreName = cadreName;
	}



	public Boolean getActiveStatus() {
		return activeStatus;
	}



	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public Integer getCodeNo() {
		return codeNo;
	}



	public void setCodeNo(Integer codeNo) {
		this.codeNo = codeNo;
	}



	public String getAddedBy() {
		return addedBy;
	}



	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	public String getLandmark() {
		return landmark;
	}


	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}


	public Boolean getDefaulter() {
		return defaulter;
	}


	public void setDefaulter(Boolean defaulter) {
		this.defaulter = defaulter;
	}


	public Integer getSponsorId() {
		return sponsorId;
	}


	public void setSponsorId(Integer sponsorId) {
		this.sponsorId = sponsorId;
	}


	public String getSponsorName() {
		return sponsorName;
	}


	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}


	public String getSponsorCurrentAddres() {
		return sponsorCurrentAddres;
	}


	public void setSponsorCurrentAddres(String sponsorCurrentAddres) {
		this.sponsorCurrentAddres = sponsorCurrentAddres;
	}


	public String getSponsorLandmark() {
		return sponsorLandmark;
	}


	public void setSponsorLandmark(String sponsorLandmark) {
		this.sponsorLandmark = sponsorLandmark;
	}


	public Boolean getSponsorDefaulter() {
		return sponsorDefaulter;
	}


	public void setSponsorDefaulter(Boolean sponsorDefaulter) {
		this.sponsorDefaulter = sponsorDefaulter;
	}


	public String getSponsorCadre() {
		return sponsorCadre;
	}


	public void setSponsorCadre(String sponsorCadre) {
		this.sponsorCadre = sponsorCadre;
	}


	public Integer getCurrentIndividualCrpb() {
		return currentIndividualCrpb;
	}


	public void setCurrentIndividualCrpb(Integer currentIndividualCrpb) {
		this.currentIndividualCrpb = currentIndividualCrpb;
	}


	public Integer getSponsorMemberId() {
		return sponsorMemberId;
	}


	public void setSponsorMemberId(Integer sponsorMemberId) {
		this.sponsorMemberId = sponsorMemberId;
	}


	public Integer getModId() {
		return modId;
	}


	public void setModId(Integer modId) {
		this.modId = modId;
	}


	public Integer getAccountId() {
		return accountId;
	}


	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}


	public Integer getCadreId() {
		return cadreId;
	}


	public void setCadreId(Integer cadreId) {
		this.cadreId = cadreId;
	}

	
	
	




	
}