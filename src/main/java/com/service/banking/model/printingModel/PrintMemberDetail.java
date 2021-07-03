package com.service.banking.model.printingModel;

public class PrintMemberDetail {
	
	Integer id;
	String name;
	String permanentAddress;
	Integer memberNo;
	String phoneNumber;
	String email;
	
	public PrintMemberDetail(Integer id, String name, String permanentAddress, Integer memberNo, String phoneNumber,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.permanentAddress = permanentAddress;
		this.memberNo = memberNo;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 
	 
}
