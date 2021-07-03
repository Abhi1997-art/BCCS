package com.service.banking.model.printingModel;

public class MemberDetail {
	//m.id,m.name ,m.permanentAddress,m.memberNo ,m.landmark,m.isDefaulte
	Integer id;
	String nameString;
	String permanentAddress;
	Integer memberNo;
	String landmark;
	Boolean isDefaulter;
	 String email;
	
	public MemberDetail() {
		super();
	}
	public MemberDetail(Integer id, String nameString, String permanentAddress, Integer memberNo, String landmark,
			Boolean isDefaulter) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.permanentAddress = permanentAddress;
		this.memberNo = memberNo;
		this.landmark = landmark;
		this.isDefaulter = isDefaulter;
	}
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public Integer getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
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
