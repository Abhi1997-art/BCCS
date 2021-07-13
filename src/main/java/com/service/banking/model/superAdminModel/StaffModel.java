package com.service.banking.model.superAdminModel;

public class StaffModel {

	Integer id;
	String branchName;
	String staffName;
	String userName;
	boolean isActive;
	String password;
	String accountNo;
	String accessLevel;
	Long totalCount;
	Integer branchId;
	String createdAt;
	Long accounts;
	Long transactions;
	
	public StaffModel(Integer id, String branchName, String staffName, String userName, boolean isActive, String password,
			String accountNo, String accessLevel,Integer branchId) {
		super();
		this.id=id;
		this.branchName = branchName;
		this.staffName = staffName;
		this.userName = userName;
		this.isActive = isActive;
		this.password = password;
		this.accountNo = accountNo;
		this.accessLevel = accessLevel;
	//	this.totalCount=totalCount;
		this.branchId=branchId;
	}

	public StaffModel(Integer id, String branchName, String staffName, String userName, boolean isActive, String password,
			String accountNo, String accessLevel,Integer branchId, String createdAt) {
		super();
		this.id=id;
		this.branchName = branchName;
		this.staffName = staffName;
		this.userName = userName;
		this.isActive = isActive;
		this.password = password;
		this.accountNo = accountNo;
		this.accessLevel = accessLevel;
	//	this.totalCount=totalCount;
		this.branchId=branchId;
		this.createdAt = createdAt;
	}
	
	

	public StaffModel(Integer id, String branchName, String staffName, String userName, boolean isActive,
			String password, String accountNo, String accessLevel, Integer branchId, String createdAt,
			Long accounts) {
		super();
		this.id = id;
		this.branchName = branchName;
		this.staffName = staffName;
		this.userName = userName;
		this.isActive = isActive;
		this.password = password;
		this.accountNo = accountNo;
		this.accessLevel = accessLevel;
		this.branchId = branchId;
		this.createdAt = createdAt;
		this.accounts = accounts;
	}

	public Long getAccounts() {
		return accounts;
	}

	public void setAccounts(Long accounts) {
		this.accounts = accounts;
	}

	public Long getTransactions() {
		return transactions;
	}

	public void setTransactions(Long transactions) {
		this.transactions = transactions;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}
