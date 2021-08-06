package com.service.banking.model.MadModel;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.service.banking.hibernateEntity.Branches;

public class EmployeeDetails {
	private Integer id;
	private Integer branchId;
	private String name;
	private String empCode;
	private String employeeName ;
	private String designation;
	private String contactNo;
	private String department;
	private Date dateOfJoining;
	private String emergencyNo;
	private String fatherName;
	private String motherName;
	private Date dob;
	private String maritalStatus;
	private String lastQualification;
	private String emailId;
	private String permanentAddress;
	private String presentAddress;
	private String panNo;
	private String drivingLicenceNo;
	private String validityOfDrivingLicence;
	private String bankName;
	private String bankAccountNo;
	private String experince;
	private String prevCompany;
	private String prevDepartment;
	private Date prevLeavingCompanyDate;
	private String leavingResion;
	private String pfJoiningDate;
	private String pfNo;
	private String pfNominee;
	private String relationWithNominee;
	private String pfDeduct;
	private String esiNo;
	private String agreementDate;
	private String paymemtMode;
	private String employeeStatus;
	private String basicSalary;
	private String otherAllowance;
	private String societyContri;
	private String netPayable;
	private String netSalary;
	private Integer employeeImagePhoto;
	private Integer employeeImageSignature;
	private Date dateOfLeaving;
	private Boolean isActive;
	private Date effectiveClDate;
	private String openingCl;
	public EmployeeDetails(Integer id,  Integer branchId, String branches, String empCode, String name, String designation,
			String contactNo, String department, Date dateOfJoining, String emergencyNo, String fatherName,
			String motherName, Date dob, String maritalStatus, String lastQualification, String emailId,
			String permanentAddress, String presentAddress, String panNo, String drivingLicenceNo,
			String validityOfDrivingLicence, String bankName, String bankAccountNo, String experince,
			String prevCompany, String prevDepartment, Date prevLeavingCompanyDate, String leavingResion,
			String pfJoiningDate, String pfNo, String pfNominee, String relationWithNominee, String pfDeduct,
			String esiNo, String agreementDate, String paymemtMode, String employeeStatus, String basicSalary,
			String otherAllowance, String societyContri, String netPayable, String netSalary,
			Integer employeeImagePhoto, Integer employeeImageSignature, Date dateOfLeaving, Boolean isActive,
			Date effectiveClDate, String openingCl) {
		super();
		this.id = id;
		this.branchId=branchId;
		this.name = branches;
		this.empCode = empCode;
		this.employeeName  = name;
		this.designation = designation;
		this.contactNo = contactNo;
		this.department = department;
		this.dateOfJoining = dateOfJoining;
		this.emergencyNo = emergencyNo;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.dob = dob;
		this.maritalStatus = maritalStatus;
		this.lastQualification = lastQualification;
		this.emailId = emailId;
		this.permanentAddress = permanentAddress;
		this.presentAddress = presentAddress;
		this.panNo = panNo;
		this.drivingLicenceNo = drivingLicenceNo;
		this.validityOfDrivingLicence = validityOfDrivingLicence;
		this.bankName = bankName;
		this.bankAccountNo = bankAccountNo;
		this.experince = experince;
		this.prevCompany = prevCompany;
		this.prevDepartment = prevDepartment;
		this.prevLeavingCompanyDate = prevLeavingCompanyDate;
		this.leavingResion = leavingResion;
		this.pfJoiningDate = pfJoiningDate;
		this.pfNo = pfNo;
		this.pfNominee = pfNominee;
		this.relationWithNominee = relationWithNominee;
		this.pfDeduct = pfDeduct;
		this.esiNo = esiNo;
		this.agreementDate = agreementDate;
		this.paymemtMode = paymemtMode;
		this.employeeStatus = employeeStatus;
		this.basicSalary = basicSalary;
		this.otherAllowance = otherAllowance;
		this.societyContri = societyContri;
		this.netPayable = netPayable;
		this.netSalary = netSalary;
		this.employeeImagePhoto = employeeImagePhoto;
		this.employeeImageSignature = employeeImageSignature;
		this.dateOfLeaving = dateOfLeaving;
		this.isActive = isActive;
		this.effectiveClDate = effectiveClDate;
		this.openingCl = openingCl;
	}
	
	
	public EmployeeDetails(Integer id, String name) {
		super();
		this.id = id;
		this.employeeName  = name;
	}


	public EmployeeDetails() {
		super();
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


	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public Integer getBranchId() {
		return branchId;
	}


	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}


	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getEmergencyNo() {
		return emergencyNo;
	}
	public void setEmergencyNo(String emergencyNo) {
		this.emergencyNo = emergencyNo;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getLastQualification() {
		return lastQualification;
	}
	public void setLastQualification(String lastQualification) {
		this.lastQualification = lastQualification;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getDrivingLicenceNo() {
		return drivingLicenceNo;
	}
	public void setDrivingLicenceNo(String drivingLicenceNo) {
		this.drivingLicenceNo = drivingLicenceNo;
	}
	public String getValidityOfDrivingLicence() {
		return validityOfDrivingLicence;
	}
	public void setValidityOfDrivingLicence(String validityOfDrivingLicence) {
		this.validityOfDrivingLicence = validityOfDrivingLicence;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	public String getExperince() {
		return experince;
	}
	public void setExperince(String experince) {
		this.experince = experince;
	}
	public String getPrevCompany() {
		return prevCompany;
	}
	public void setPrevCompany(String prevCompany) {
		this.prevCompany = prevCompany;
	}
	public String getPrevDepartment() {
		return prevDepartment;
	}
	public void setPrevDepartment(String prevDepartment) {
		this.prevDepartment = prevDepartment;
	}
	public Date getPrevLeavingCompanyDate() {
		return prevLeavingCompanyDate;
	}
	public void setPrevLeavingCompanyDate(Date prevLeavingCompanyDate) {
		this.prevLeavingCompanyDate = prevLeavingCompanyDate;
	}
	public String getLeavingResion() {
		return leavingResion;
	}
	public void setLeavingResion(String leavingResion) {
		this.leavingResion = leavingResion;
	}
	public String getPfJoiningDate() {
		return pfJoiningDate;
	}
	public void setPfJoiningDate(String pfJoiningDate) {
		this.pfJoiningDate = pfJoiningDate;
	}
	public String getPfNo() {
		return pfNo;
	}
	public void setPfNo(String pfNo) {
		this.pfNo = pfNo;
	}
	public String getPfNominee() {
		return pfNominee;
	}
	public void setPfNominee(String pfNominee) {
		this.pfNominee = pfNominee;
	}
	public String getRelationWithNominee() {
		return relationWithNominee;
	}
	public void setRelationWithNominee(String relationWithNominee) {
		this.relationWithNominee = relationWithNominee;
	}
	public String getPfDeduct() {
		return pfDeduct;
	}
	public void setPfDeduct(String pfDeduct) {
		this.pfDeduct = pfDeduct;
	}
	public String getEsiNo() {
		return esiNo;
	}
	public void setEsiNo(String esiNo) {
		this.esiNo = esiNo;
	}
	public String getAgreementDate() {
		return agreementDate;
	}
	public void setAgreementDate(String agreementDate) {
		this.agreementDate = agreementDate;
	}
	public String getPaymemtMode() {
		return paymemtMode;
	}
	public void setPaymemtMode(String paymemtMode) {
		this.paymemtMode = paymemtMode;
	}
	public String getEmployeeStatus() {
		return employeeStatus;
	}
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	public String getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(String basicSalary) {
		this.basicSalary = basicSalary;
	}
	public String getOtherAllowance() {
		return otherAllowance;
	}
	public void setOtherAllowance(String otherAllowance) {
		this.otherAllowance = otherAllowance;
	}
	public String getSocietyContri() {
		return societyContri;
	}
	public void setSocietyContri(String societyContri) {
		this.societyContri = societyContri;
	}
	public String getNetPayable() {
		return netPayable;
	}
	public void setNetPayable(String netPayable) {
		this.netPayable = netPayable;
	}
	public String getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(String netSalary) {
		this.netSalary = netSalary;
	}
	public Integer getEmployeeImagePhoto() {
		return employeeImagePhoto;
	}
	public void setEmployeeImagePhoto(Integer employeeImagePhoto) {
		this.employeeImagePhoto = employeeImagePhoto;
	}
	public Integer getEmployeeImageSignature() {
		return employeeImageSignature;
	}
	public void setEmployeeImageSignature(Integer employeeImageSignature) {
		this.employeeImageSignature = employeeImageSignature;
	}
	public Date getDateOfLeaving() {
		return dateOfLeaving;
	}
	public void setDateOfLeaving(Date dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Date getEffectiveClDate() {
		return effectiveClDate;
	}
	public void setEffectiveClDate(Date effectiveClDate) {
		this.effectiveClDate = effectiveClDate;
	}
	public String getOpeningCl() {
		return openingCl;
	}
	public void setOpeningCl(String openingCl) {
		this.openingCl = openingCl;
	}
	
	
}
