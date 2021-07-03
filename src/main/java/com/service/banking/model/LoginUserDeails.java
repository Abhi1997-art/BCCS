package com.service.banking.model;

import java.util.Date;

public class LoginUserDeails {

	private Integer id;
	private String username;
	private Integer branchId;
	private String accessLevel;
	private String name;
	private String fatherName;
	private String createdAt;
	private String mobileNo;
	private Boolean isActive;
	private String role;
	private String accountNo;
	
	private String exits;
	
	private String token;
	
	
	
	public LoginUserDeails(String exits) {
		super();
		this.exits = exits;
	}
	
	
	public LoginUserDeails() {
		super();
	}
	public LoginUserDeails(Integer id, String username, Integer branchId, String accessLevel, String name,
			String fatherName, String createdAt, String mobileNo, Boolean isActive, String role, String accountNo,
			String exits, String token) {
		super();
		this.id = id;
		this.username = username;
		this.branchId = branchId;
		this.accessLevel = accessLevel;
		this.name = name;
		this.fatherName = fatherName;
		this.createdAt = createdAt;
		this.mobileNo = mobileNo;
		this.isActive = isActive;
		this.role = role;
		this.accountNo = accountNo;
		this.exits = exits;
		this.token = token;
	}


	public LoginUserDeails(Integer id, String username, Integer branchId, String accessLevel, String name,
			String fatherName, String createdAt, String mobileNo, Boolean isActive, String role, String accountNo) {
		super();
		this.id = id;
		this.username = username;
		this.branchId = branchId;
		this.accessLevel = accessLevel;
		this.name = name;
		this.fatherName = fatherName;
		this.createdAt = createdAt;
		this.mobileNo = mobileNo;
		this.isActive = isActive;
		this.role = role;
		this.accountNo = accountNo;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the exits
	 */
	public String getExits() {
		return exits;
	}
	/**
	 * @param exits the exits to set
	 */
	public void setExits(String exits) {
		this.exits = exits;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public String getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
}
