package com.service.banking.model.printingModel;

public class MemberDetail {


	Integer id;
	String nameString;
	String permanentAddress;
	Integer memberNo;
	String phoneNos;
	Boolean isDefaulter;
	String email;
	
	public MemberDetail() {
		super();
	}
	public MemberDetail(Integer id, String nameString, String permanentAddress, Integer memberNo, String phoneNos,
			Boolean isDefaulter) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.permanentAddress = permanentAddress;
		this.memberNo = memberNo;
		this.phoneNos = phoneNos;
		this.isDefaulter = isDefaulter;
	}

	public MemberDetail(Integer id, String nameString, String permanentAddress, Integer memberNo, String phoneNos, String email) {
		this.id = id;
		this.nameString = nameString;
		this.permanentAddress = permanentAddress;
		this.phoneNos = phoneNos;
		this.memberNo = memberNo;
		this.phoneNos = phoneNos;
		this.email = email;
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

	public Boolean getIsDefaulter() {
		return isDefaulter;
	}
	public void setIsDefaulter(Boolean isDefaulter) {
		this.isDefaulter = isDefaulter;
	}

	public String getPhoneNos() {
		return phoneNos;
	}

	public void setPhoneNos(String phoneNos) {
		this.phoneNos = phoneNos;
	}

	public Boolean getDefaulter() {
		return isDefaulter;
	}

	public void setDefaulter(Boolean defaulter) {
		isDefaulter = defaulter;
	}
}
