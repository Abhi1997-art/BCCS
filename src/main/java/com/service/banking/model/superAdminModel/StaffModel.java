package com.service.banking.model.superAdminModel;

import java.util.Date;

public class StaffModel {

	private Integer id;
	private String branchName;
	private String staffName;
	private String userName;
	private Boolean isActive;
	private String password;
	private String accountNo;
	private String accessLevel;
	private Long totalCount;
	private Integer branchId;
	private String createdAt;
	private Long number;
	private String name;
	private String fatherName;
	private String pfAmount;
	private String basicPay;
	private String variablePay;
	private String presentAddress;
	private String parmanentAddress;
	private String mobileNo;
	private String landlineNo;
	private String dob;
	private String motherName;
	private String marriatalStatus;
	private String bloodGroup;
	private String empCode;
	private String emergencyNo;
	private String panNo;
	private String role;
	private String lastQualification;
	private String designation;
	private String remark;
	private String amountOfIncrement;
	private String yearlyIncrementAmount;
	private String salary;
	private String relavingDateIfNotActive;
	private String securityAmount;
	private Date depositDate;
	private String totalDepAmount;
	private String postingAt;
	private String pfNo;
	private String bankName;
	private String lastDateOfIncrement;
	private String nomineeName;
	private String nomineeAge;
	private String relationWithNominee;

	public StaffModel(Long number) {
		super();
		this.number = number;
	}

	public StaffModel(Integer id, String branchName, String staffName, String userName, boolean isActive,
			String password, String accountNo, String accessLevel, Integer branchId) {
		super();
		this.id = id;
		this.branchName = branchName;
		this.staffName = staffName;
		this.userName = userName;
		this.isActive = isActive;
		this.password = password;
		this.accountNo = accountNo;
		this.accessLevel = accessLevel;
		// this.totalCount=totalCount;
		this.branchId = branchId;
	}

	public StaffModel(Integer id, String branchName, String staffName, String userName, boolean isActive,
			String password, String accountNo, String accessLevel, Integer branchId, String createdAt) {
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
	}

	public StaffModel(Integer id, String branchName, String staffName, String userName, boolean isActive,
			String password, String accountNo, String accessLevel, Integer branchId, String createdAt,
			Integer staffId) {
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
	}

	
	
	public StaffModel(Integer id, String branchName, String staffName, String userName, Boolean isActive,
			String password, String accountNo, String accessLevel, Integer branchId, String createdAt,
			String fatherName, String pfAmount, String basicPay,
			String variablePay, String presentAddress, String parmanentAddress, String mobileNo, String landlineNo,
			String dob, String motherName, String marriatalStatus, String bloodGroup, String empCode,
			String emergencyNo, String panNo, String role, String lastQualification, String designation, String remark,
			String amountOfIncrement, String yearlyIncrementAmount, String salary, String relavingDateIfNotActive,
			String securityAmount, Date depositDate, String totalDepAmount, String postingAt, String pfNo,
			String bankName, String lastDateOfIncrement, String nomineeName, String nomineeAge,
			String relationWithNominee) {
		super();
		this.id = id;
		this.branchName = branchName;
		this.staffName = staffName;
		this.userName = userName;
		this.isActive = isActive;
		this.password = password;
		this.accountNo = accountNo;
		this.accessLevel = accessLevel;
		this.totalCount = totalCount;
		this.branchId = branchId;
		this.createdAt = createdAt;
		this.number = number;
		this.name = name;
		this.fatherName = fatherName;
		this.pfAmount = pfAmount;
		this.basicPay = basicPay;
		this.variablePay = variablePay;
		this.presentAddress = presentAddress;
		this.parmanentAddress = parmanentAddress;
		this.mobileNo = mobileNo;
		this.landlineNo = landlineNo;
		this.dob = dob;
		this.motherName = motherName;
		this.marriatalStatus = marriatalStatus;
		this.bloodGroup = bloodGroup;
		this.empCode = empCode;
		this.emergencyNo = emergencyNo;
		this.panNo = panNo;
		this.role = role;
		this.lastQualification = lastQualification;
		this.designation = designation;
		this.remark = remark;
		this.amountOfIncrement = amountOfIncrement;
		this.yearlyIncrementAmount = yearlyIncrementAmount;
		this.salary = salary;
		this.relavingDateIfNotActive = relavingDateIfNotActive;
		this.securityAmount = securityAmount;
		this.depositDate = depositDate;
		this.totalDepAmount = totalDepAmount;
		this.postingAt = postingAt;
		this.pfNo = pfNo;
		this.bankName = bankName;
		this.lastDateOfIncrement = lastDateOfIncrement;
		this.nomineeName = nomineeName;
		this.nomineeAge = nomineeAge;
		this.relationWithNominee = relationWithNominee;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
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

	public String getPfAmount() {
		return pfAmount;
	}

	public void setPfAmount(String pfAmount) {
		this.pfAmount = pfAmount;
	}

	public String getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(String basicPay) {
		this.basicPay = basicPay;
	}

	public String getVariablePay() {
		return variablePay;
	}

	public void setVariablePay(String variablePay) {
		this.variablePay = variablePay;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getParmanentAddress() {
		return parmanentAddress;
	}

	public void setParmanentAddress(String parmanentAddress) {
		this.parmanentAddress = parmanentAddress;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getLandlineNo() {
		return landlineNo;
	}

	public void setLandlineNo(String landlineNo) {
		this.landlineNo = landlineNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMarriatalStatus() {
		return marriatalStatus;
	}

	public void setMarriatalStatus(String marriatalStatus) {
		this.marriatalStatus = marriatalStatus;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmergencyNo() {
		return emergencyNo;
	}

	public void setEmergencyNo(String emergencyNo) {
		this.emergencyNo = emergencyNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLastQualification() {
		return lastQualification;
	}

	public void setLastQualification(String lastQualification) {
		this.lastQualification = lastQualification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAmountOfIncrement() {
		return amountOfIncrement;
	}

	public void setAmountOfIncrement(String amountOfIncrement) {
		this.amountOfIncrement = amountOfIncrement;
	}

	public String getYearlyIncrementAmount() {
		return yearlyIncrementAmount;
	}

	public void setYearlyIncrementAmount(String yearlyIncrementAmount) {
		this.yearlyIncrementAmount = yearlyIncrementAmount;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getRelavingDateIfNotActive() {
		return relavingDateIfNotActive;
	}

	public void setRelavingDateIfNotActive(String relavingDateIfNotActive) {
		this.relavingDateIfNotActive = relavingDateIfNotActive;
	}

	public String getSecurityAmount() {
		return securityAmount;
	}

	public void setSecurityAmount(String securityAmount) {
		this.securityAmount = securityAmount;
	}

	public Date getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}

	public String getTotalDepAmount() {
		return totalDepAmount;
	}

	public void setTotalDepAmount(String totalDepAmount) {
		this.totalDepAmount = totalDepAmount;
	}

	public String getPostingAt() {
		return postingAt;
	}

	public void setPostingAt(String postingAt) {
		this.postingAt = postingAt;
	}

	public String getPfNo() {
		return pfNo;
	}

	public void setPfNo(String pfNo) {
		this.pfNo = pfNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getLastDateOfIncrement() {
		return lastDateOfIncrement;
	}

	public void setLastDateOfIncrement(String lastDateOfIncrement) {
		this.lastDateOfIncrement = lastDateOfIncrement;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public String getNomineeAge() {
		return nomineeAge;
	}

	public void setNomineeAge(String nomineeAge) {
		this.nomineeAge = nomineeAge;
	}

	public String getRelationWithNominee() {
		return relationWithNominee;
	}

	public void setRelationWithNominee(String relationWithNominee) {
		this.relationWithNominee = relationWithNominee;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
