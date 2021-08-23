package com.service.banking.model.MadModel;

public class DsaGuarantorDetails {

	Integer dsId;
	String guarantorName;
	Integer dsgId;
	Integer guarantorId;
	String name;
	Integer memberNo;
	String currentAddress;
	String landmark;
	Boolean isDefaulter;
	
	
	
	public DsaGuarantorDetails(Integer dsId, String name, Integer dsgId, Integer guarantorId, String guarantorName, Integer memberNo, String currentAddress, String landmark, Boolean isDefaulter) {
		super();
		this.dsId = dsId;
		this.guarantorName = name;
		this.dsgId = dsgId;
		this.guarantorId = guarantorId;
		this.name = guarantorName;
		this.memberNo = memberNo;
		this.currentAddress = currentAddress;
		this.landmark = landmark;
		this.isDefaulter = isDefaulter;
	}



	public Integer getDsId() {
		return dsId;
	}



	public void setDsId(Integer dsId) {
		this.dsId = dsId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getDsgId() {
		return dsgId;
	}



	public void setDsgId(Integer dsgId) {
		this.dsgId = dsgId;
	}



	public Integer getGuarantorId() {
		return guarantorId;
	}



	public void setGuarantorId(Integer guarantorId) {
		this.guarantorId = guarantorId;
	}



	public String getGuarantorName() {
		return guarantorName;
	}



	public void setGuarantorName(String guarantorName) {
		this.guarantorName = guarantorName;
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



	public Boolean getIsDefaulter() {
		return isDefaulter;
	}



	public void setIsDefaulter(Boolean isDefaulter) {
		this.isDefaulter = isDefaulter;
	}
	
	
}