package com.service.banking.model.MadModel;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.service.banking.hibernateEntity.Branches;

public class XbankEmployeesDetails {
	
	private Integer id;
	private Integer branches;
	private String name;
	private String designation;
	private String department;
	private Date dob;
	private String experince;
	private String prevCompany;
	private String prevDepartment;
	private Date prevLeavingCompanyDate;
	private String leavingResion;
	private String fatherName;
	private String motherName;
	private String maritalStatus;
	private String contactNo;
	private String emailId;
	private String permanentAddress;
	private String presentAddress;
	private Date dateOfJoining;
	private Date dateOfLeaving;
	private String pfNo;
	private String pfNominee;
	private String esiNo;
	private String esiNominee;
	private String panNo;
	private String drivingLicenceNo;
	private String validityOfDrivingLicence;
	private String bankName;
	private String bankAccountNo;
	private String paymemtMode;
	private String pfDeduct;
	private String employeeStatus;
	private String basicSalary;
	private String otherAllowance;
	private String societyContri;
	private String netPayable;
	private String netSalary;
	private String empCode;
	private String relationWithNominee;
	private String lastQualification;
	private String pfJoiningDate;
	private String agreementDate;
	private Boolean isActive;
	private Integer employeeImagePhoto;
	private Integer employeeImageSignature;
	private String emergencyNo;
	private String openingCl;
	private Date effectiveClDate;
	private Integer employeeImagePhotoId;
	private Integer employeeImageSignatureId;
	
	public XbankEmployeesDetails() {
	}

	public XbankEmployeesDetails(Integer branches, String name, String designation, String department, Date dob,
			String experince, String prevCompany, String prevDepartment, Date prevLeavingCompanyDate,
			String leavingResion, String fatherName, String motherName, String maritalStatus, String contactNo,
			String emailId, String permanentAddress, String presentAddress, Date dateOfJoining, Date dateOfLeaving,
			String pfNo, String pfNominee, String esiNo, String esiNominee, String panNo, String drivingLicenceNo,
			String validityOfDrivingLicence, String bankName, String bankAccountNo, String paymemtMode, String pfDeduct,
			String employeeStatus, String basicSalary, String otherAllowance, String societyContri, String netPayable,
			String netSalary, String empCode, String relationWithNominee, String lastQualification,
			String pfJoiningDate, String agreementDate, Boolean isActive, Integer employeeImagePhoto,
			Integer employeeImageSignature, String emergencyNo, String openingCl, Date effectiveClDate,
			Integer employeeImagePhotoId, Integer employeeImageSignatureId, Set employeeSalaryRecords) {
		this.branches = branches;
		this.name = name;
		this.designation = designation;
		this.department = department;
		this.dob = dob;
		this.experince = experince;
		this.prevCompany = prevCompany;
		this.prevDepartment = prevDepartment;
		this.prevLeavingCompanyDate = prevLeavingCompanyDate;
		this.leavingResion = leavingResion;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.maritalStatus = maritalStatus;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.permanentAddress = permanentAddress;
		this.presentAddress = presentAddress;
		this.dateOfJoining = dateOfJoining;
		this.dateOfLeaving = dateOfLeaving;
		this.pfNo = pfNo;
		this.pfNominee = pfNominee;
		this.esiNo = esiNo;
		this.esiNominee = esiNominee;
		this.panNo = panNo;
		this.drivingLicenceNo = drivingLicenceNo;
		this.validityOfDrivingLicence = validityOfDrivingLicence;
		this.bankName = bankName;
		this.bankAccountNo = bankAccountNo;
		this.paymemtMode = paymemtMode;
		this.pfDeduct = pfDeduct;
		this.employeeStatus = employeeStatus;
		this.basicSalary = basicSalary;
		this.otherAllowance = otherAllowance;
		this.societyContri = societyContri;
		this.netPayable = netPayable;
		this.netSalary = netSalary;
		this.empCode = empCode;
		this.relationWithNominee = relationWithNominee;
		this.lastQualification = lastQualification;
		this.pfJoiningDate = pfJoiningDate;
		this.agreementDate = agreementDate;
		this.isActive = isActive;
		this.employeeImagePhoto = employeeImagePhoto;
		this.employeeImageSignature = employeeImageSignature;
		this.emergencyNo = emergencyNo;
		this.openingCl = openingCl;
		this.effectiveClDate = effectiveClDate;
		this.employeeImagePhotoId = employeeImagePhotoId;
		this.employeeImageSignatureId = employeeImageSignatureId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBranches() {
		return branches;
	}

	public void setBranches(Integer branches) {
		this.branches = branches;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getDateOfLeaving() {
		return dateOfLeaving;
	}

	public void setDateOfLeaving(Date dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
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

	public String getEsiNo() {
		return esiNo;
	}

	public void setEsiNo(String esiNo) {
		this.esiNo = esiNo;
	}

	public String getEsiNominee() {
		return esiNominee;
	}

	public void setEsiNominee(String esiNominee) {
		this.esiNominee = esiNominee;
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

	public String getPaymemtMode() {
		return paymemtMode;
	}

	public void setPaymemtMode(String paymemtMode) {
		this.paymemtMode = paymemtMode;
	}

	public String getPfDeduct() {
		return pfDeduct;
	}

	public void setPfDeduct(String pfDeduct) {
		this.pfDeduct = pfDeduct;
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

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getRelationWithNominee() {
		return relationWithNominee;
	}

	public void setRelationWithNominee(String relationWithNominee) {
		this.relationWithNominee = relationWithNominee;
	}

	public String getLastQualification() {
		return lastQualification;
	}

	public void setLastQualification(String lastQualification) {
		this.lastQualification = lastQualification;
	}

	public String getPfJoiningDate() {
		return pfJoiningDate;
	}

	public void setPfJoiningDate(String pfJoiningDate) {
		this.pfJoiningDate = pfJoiningDate;
	}

	public String getAgreementDate() {
		return agreementDate;
	}

	public void setAgreementDate(String agreementDate) {
		this.agreementDate = agreementDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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

	public String getEmergencyNo() {
		return emergencyNo;
	}

	public void setEmergencyNo(String emergencyNo) {
		this.emergencyNo = emergencyNo;
	}

	public String getOpeningCl() {
		return openingCl;
	}

	public void setOpeningCl(String openingCl) {
		this.openingCl = openingCl;
	}

	public Date getEffectiveClDate() {
		return effectiveClDate;
	}

	public void setEffectiveClDate(Date effectiveClDate) {
		this.effectiveClDate = effectiveClDate;
	}

	public Integer getEmployeeImagePhotoId() {
		return employeeImagePhotoId;
	}

	public void setEmployeeImagePhotoId(Integer employeeImagePhotoId) {
		this.employeeImagePhotoId = employeeImagePhotoId;
	}

	public Integer getEmployeeImageSignatureId() {
		return employeeImageSignatureId;
	}

	public void setEmployeeImageSignatureId(Integer employeeImageSignatureId) {
		this.employeeImageSignatureId = employeeImageSignatureId;
	}

	
}
