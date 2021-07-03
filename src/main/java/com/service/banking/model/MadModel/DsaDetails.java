package com.service.banking.model.MadModel;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.service.banking.hibernateEntity.Members;

public class DsaDetails {
	
	private Integer id;
	private String memberName;
	private Integer memberId;
	private String currentAddress;
	private String name;
	private String username;
	private String password;
	private String phoneNo1;
	private String phoneNo2;
	private String emailId1;
	private String emailId2;
	private Boolean isDefaulter;
	
	
	public DsaDetails() {
		super();
	}
	
	
	
	
	public DsaDetails(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}




	public DsaDetails(Integer id, String memberName, Integer memberId, String currentAddress, String name,
			String username, String password, String phoneNo1, String phoneNo2, String emailId1, String emailId2, Boolean isDefaulter) {
		super();
		this.id = id;
		this.memberName = memberName;
		this.memberId = memberId;
		this.currentAddress = currentAddress;
		this.name = name;
		this.username = username;
		this.password = password;
		this.phoneNo1 = phoneNo1;
		this.phoneNo2 = phoneNo2;
		this.emailId1 = emailId1;
		this.emailId2 = emailId2;
		this.isDefaulter=isDefaulter;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo1() {
		return phoneNo1;
	}
	public void setPhoneNo1(String phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}
	public String getPhoneNo2() {
		return phoneNo2;
	}
	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}
	public String getEmailId1() {
		return emailId1;
	}
	public void setEmailId1(String emailId1) {
		this.emailId1 = emailId1;
	}
	public String getEmailId2() {
		return emailId2;
	}
	public void setEmailId2(String emailId2) {
		this.emailId2 = emailId2;
	}

	public Boolean getIsDefaulter() {
		return isDefaulter;
	}

	public void setIsDefaulter(Boolean isDefaulter) {
		this.isDefaulter = isDefaulter;
	}
	

}
