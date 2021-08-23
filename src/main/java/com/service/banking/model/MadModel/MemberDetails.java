package com.service.banking.model.MadModel;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.service.banking.utils.DateFormater;

public class MemberDetails {
	
	public Integer id;
	public Integer memberNo;
	public Integer branchId;
	public String branchName;
	public String title;
	public String name;
	public String cast;
	public String phoneNos;
	public String fatherName;
	public String landmark;
	public String tehsil;
	public String district;
	public String city;
	public String state;
	public String pinCode;
	public String currentAddress;
	public String username;
	public String password;
	public String relationWithParent;
	public String occupation;
	public String dob;
	public String witness1name;
	public String witness1fatherName;
	public String witness1address;
	public String witness2name;
	public String witness2fatherName;
	public String witness2address;
	public String createdAt;
	public Boolean isActive;
	public Boolean isDefaulter;
	public String defaulterOn;
	public String panNo;
	public String adharNumber;
	public String gstin;
	public Integer bankbranchAId;
	public String bankAccountNumber1;
	public Integer bankbranchBId;
	public String bankAccountNumber2;
	public String memebrType;
	public Boolean isAgent;
	public String nominee;
	public Short nomineeAge;
	public String relationWithNominee;
	public String relationWithFather;
	public String minorDob;
	public String parentName;
	public String accountNumber;
	public Byte filledForm60;
	public Integer sigImageId;
	public Long shareCount;
	public String bankBranchAName;
	public String bankBranchBName;
	public String bankBranchAIFSC;
	public String bankBranchBIFSC;
	public Integer debitAccount;
	public Integer loginBranch;
	public Integer staffId;
	public String bankAName;
	public String bankBName;
	
	
	

	public MemberDetails() {
		super();
	}

	public MemberDetails(Integer id, Integer memberNo, Integer branchId, String branchName, String title, String name, String cast, String phoneNos,
			String fatherName, String landmark, String tehsil, String district, String city, String state,
			String pinCode, String currentAddress, String username, String password, String relationWithParent,
			String occupation, String dob, String witness1name, String witness1fatherName, String witness1address,
			String witness2name, String witness2fatherName, String witness2address, String createdAt, Boolean isActive,
			Boolean isDefaulter, Date defaulterOn, String panNo, String adharNumber, String gstin, Integer bankbranchAId,
			String bankAccountNumber1, Integer bankbranchBId, String bankAccountNumber2, String memebrType,
			Boolean isAgent, String nominee, Short nomineeAge, String relationWithNominee, String relationWithFather, String minorDob,
			String parentName, String accountNumber, Byte filledForm60, Integer sigImageId) {
		super();
		this.id = id;
		this.memberNo=memberNo;
		this.branchId=branchId;
		this.branchName = branchName;
		this.title = title;
		this.name = name;
		this.cast = cast;
		this.phoneNos = phoneNos;
		this.fatherName = fatherName;
		this.landmark = landmark;
		this.tehsil = tehsil;
		this.district = district;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.currentAddress = currentAddress;
		this.username = username;
		this.password = password;
		this.relationWithParent = relationWithParent;
		this.occupation = occupation;
		this.dob = dob;
		this.witness1name = witness1name;
		this.witness1fatherName = witness1fatherName;
		this.witness1address = witness1address;
		this.witness2name = witness2name;
		this.witness2fatherName = witness2fatherName;
		this.witness2address = witness2address;
		this.createdAt = createdAt;
		this.isActive = isActive;
		this.isDefaulter = isDefaulter;
		this.defaulterOn=DateFormater.getformatDate(defaulterOn);
		this.panNo = panNo;
		this.adharNumber = adharNumber;
		this.gstin = gstin;
		this.bankbranchAId = bankbranchAId;
		this.bankAccountNumber1 = bankAccountNumber1;
		this.bankbranchBId = bankbranchBId;
		this.bankAccountNumber2 = bankAccountNumber2;
		this.memebrType = memebrType;
		this.isAgent = isAgent;
		this.nominee = nominee;
		this.nomineeAge = nomineeAge;
		this.relationWithNominee = relationWithNominee;
		this.relationWithFather=relationWithFather;
		this.minorDob = minorDob;
		this.parentName = parentName;
		this.accountNumber=accountNumber;
		this.filledForm60=filledForm60;
		this.sigImageId=sigImageId;
	}
	
	public MemberDetails(Integer id, Integer memberNo, Integer branchId, String branchName, String title, String name, String cast, String phoneNos,
			String fatherName, String landmark, String tehsil, String district, String city, String state,
			String pinCode, String currentAddress, String username, String password, String relationWithParent,
			String occupation, String dob, String witness1name, String witness1fatherName, String witness1address,
			String witness2name, String witness2fatherName, String witness2address, String createdAt, Boolean isActive,
			Boolean isDefaulter, Date defaulterOn, String panNo, String adharNumber, String gstin, Integer bankbranchAId,
			String bankAccountNumber1, Integer bankbranchBId, String bankAccountNumber2, String memebrType,
			Boolean isAgent, String nominee, Short nomineeAge, String relationWithNominee, String relationWithFather, String minorDob,
			String parentName, String accountNumber, Byte filledForm60, Integer sigImageId, Long shareCount, String bankBranchAName, String bankBranchBName,
			String bankBranchAIFSC, String bankBranchBIFSC, String bankAName, String bankBName) {
		super();
		this.id = id;
		this.memberNo=memberNo;
		this.branchId=branchId;
		this.branchName = branchName;
		this.title = title;
		this.name = name;
		this.cast = cast;
		this.phoneNos = phoneNos;
		this.fatherName = fatherName;
		this.landmark = landmark;
		this.tehsil = tehsil;
		this.district = district;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.currentAddress = currentAddress;
		this.username = username;
		this.password = password;
		this.relationWithParent = relationWithParent;
		this.occupation = occupation;
		this.dob = dob;
		this.witness1name = witness1name;
		this.witness1fatherName = witness1fatherName;
		this.witness1address = witness1address;
		this.witness2name = witness2name;
		this.witness2fatherName = witness2fatherName;
		this.witness2address = witness2address;
		this.createdAt = createdAt;
		this.isActive = isActive;
		this.isDefaulter = isDefaulter;
		this.defaulterOn=DateFormater.getformatDate(defaulterOn);
		this.panNo = panNo;
		this.adharNumber = adharNumber;
		this.gstin = gstin;
		this.bankbranchAId = bankbranchAId;
		this.bankAccountNumber1 = bankAccountNumber1;
		this.bankbranchBId = bankbranchBId;
		this.bankAccountNumber2 = bankAccountNumber2;
		this.memebrType = memebrType;
		this.isAgent = isAgent;
		this.nominee = nominee;
		this.nomineeAge = nomineeAge;
		this.relationWithNominee = relationWithNominee;
		this.relationWithFather=relationWithFather;
		this.minorDob = minorDob;
		this.parentName = parentName;
		this.accountNumber=accountNumber;
		this.filledForm60=filledForm60;
		this.sigImageId=sigImageId;
		this.shareCount=shareCount;
		this.bankBranchAName=bankBranchAName;
		this.bankBranchBName= bankBranchBName;
		this.bankBranchAIFSC= bankBranchAIFSC;
		this.bankBranchBIFSC=bankBranchBIFSC;
		this.bankAName= bankAName;
		this.bankBName= bankBName;
	}


	
	public MemberDetails(Integer id, Integer memberNo, Integer branchId, String branchName, String title, String name,
			String cast, String phoneNos, String fatherName, String landmark, String tehsil, String district,
			String city, String state, String pinCode, String currentAddress, String username, String password,
			String relationWithParent, String occupation, String dob, String witness1name, String witness1fatherName,
			String witness1address, String witness2name, String witness2fatherName, String witness2address,
			String createdAt, Boolean isActive, Boolean isDefaulter, String defaulterOn, String panNo,
			String adharNumber, String gstin, Integer bankbranchAId, String bankAccountNumber1, Integer bankbranchBId,
			String bankAccountNumber2, String memebrType, Boolean isAgent, String nominee, Short nomineeAge,
			String relationWithNominee, String relationWithFather, String minorDob, String parentName,
			String accountNumber, Byte filledForm60, Integer sigImageId) {
		super();
		this.id = id;
		this.memberNo = memberNo;
		this.branchId = branchId;
		this.branchName = branchName;
		this.title = title;
		this.name = name;
		this.cast = cast;
		this.phoneNos = phoneNos;
		this.fatherName = fatherName;
		this.landmark = landmark;
		this.tehsil = tehsil;
		this.district = district;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.currentAddress = currentAddress;
		this.username = username;
		this.password = password;
		this.relationWithParent = relationWithParent;
		this.occupation = occupation;
		this.dob = dob;
		this.witness1name = witness1name;
		this.witness1fatherName = witness1fatherName;
		this.witness1address = witness1address;
		this.witness2name = witness2name;
		this.witness2fatherName = witness2fatherName;
		this.witness2address = witness2address;
		this.createdAt = createdAt;
		this.isActive = isActive;
		this.isDefaulter = isDefaulter;
		this.defaulterOn = defaulterOn;
		this.panNo = panNo;
		this.adharNumber = adharNumber;
		this.gstin = gstin;
		this.bankbranchAId = bankbranchAId;
		this.bankAccountNumber1 = bankAccountNumber1;
		this.bankbranchBId = bankbranchBId;
		this.bankAccountNumber2 = bankAccountNumber2;
		this.memebrType = memebrType;
		this.isAgent = isAgent;
		this.nominee = nominee;
		this.nomineeAge = nomineeAge;
		this.relationWithNominee = relationWithNominee;
		this.relationWithFather = relationWithFather;
		this.minorDob = minorDob;
		this.parentName = parentName;
		this.accountNumber = accountNumber;
		this.filledForm60 = filledForm60;
		this.sigImageId = sigImageId;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}
	
	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getPhoneNos() {
		return phoneNos;
	}

	public void setPhoneNos(String phoneNos) {
		this.phoneNos = phoneNos;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getTehsil() {
		return tehsil;
	}

	public void setTehsil(String tehsil) {
		this.tehsil = tehsil;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
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

	public String getRelationWithParent() {
		return relationWithParent;
	}

	public void setRelationWithParent(String relationWithParent) {
		this.relationWithParent = relationWithParent;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getWitness1name() {
		return witness1name;
	}

	public void setWitness1name(String witness1name) {
		this.witness1name = witness1name;
	}

	public String getWitness1fatherName() {
		return witness1fatherName;
	}

	public void setWitness1fatherName(String witness1fatherName) {
		this.witness1fatherName = witness1fatherName;
	}

	public String getWitness1address() {
		return witness1address;
	}

	public void setWitness1address(String witness1address) {
		this.witness1address = witness1address;
	}

	public String getWitness2name() {
		return witness2name;
	}

	public void setWitness2name(String witness2name) {
		this.witness2name = witness2name;
	}

	public String getWitness2fatherName() {
		return witness2fatherName;
	}

	public void setWitness2fatherName(String witness2fatherName) {
		this.witness2fatherName = witness2fatherName;
	}

	public String getWitness2address() {
		return witness2address;
	}

	public void setWitness2address(String witness2address) {
		this.witness2address = witness2address;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDefaulter() {
		return isDefaulter;
	}

	public void setIsDefaulter(Boolean isDefaulter) {
		this.isDefaulter = isDefaulter;
	}
	

	public String getDefaulterOn() {
		return defaulterOn;
	}

	public void setDefaulterOn(String defaulterOn) {
		this.defaulterOn = defaulterOn;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public Integer getBankbranchAId() {
		return bankbranchAId;
	}

	public void setBankbranchAId(Integer bankbranchAId) {
		this.bankbranchAId = bankbranchAId;
	}

	public String getBankAccountNumber1() {
		return bankAccountNumber1;
	}

	public void setBankAccountNumber1(String bankAccountNumber1) {
		this.bankAccountNumber1 = bankAccountNumber1;
	}

	public Integer getBankbranchBId() {
		return bankbranchBId;
	}

	public void setBankbranchBId(Integer bankbranchBId) {
		this.bankbranchBId = bankbranchBId;
	}

	public String getBankAccountNumber2() {
		return bankAccountNumber2;
	}

	public void setBankAccountNumber2(String bankAccountNumber2) {
		this.bankAccountNumber2 = bankAccountNumber2;
	}

	public String getMemebrType() {
		return memebrType;
	}

	public void setMemebrType(String memebrType) {
		this.memebrType = memebrType;
	}

	public Boolean getIsAgent() {
		return isAgent;
	}

	public void setIsAgent(Boolean isAgent) {
		this.isAgent = isAgent;
	}

	public String getNominee() {
		return nominee;
	}

	public void setNominee(String nominee) {
		this.nominee = nominee;
	}

	public Short getNomineeAge() {
		return nomineeAge;
	}

	public void setNomineeAge(Short nomineeAge) {
		this.nomineeAge = nomineeAge;
	}

	public String getRelationWithNominee() {
		return relationWithNominee;
	}

	public void setRelationWithNominee(String relationWithNominee) {
		this.relationWithNominee = relationWithNominee;
	}

	public String getRelationWithFather() {
		return relationWithFather;
	}

	public void setRelationWithFather(String relationWithFather) {
		this.relationWithFather = relationWithFather;
	}

	public String getMinorDob() {
		return minorDob;
	}

	public void setMinorDob(String minorDob) {
		this.minorDob = minorDob;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Byte getFilledForm60() {
		return filledForm60;
	}

	public void setFilledForm60(Byte filledForm60) {
		this.filledForm60 = filledForm60;
	}

	public Integer getSigImageId() {
		return sigImageId;
	}

	public void setSigImageId(Integer sigImageId) {
		this.sigImageId = sigImageId;
	}

	public Long getShareCount() {
		return shareCount;
	}

	public void setShareCount(Long shareCount) {
		this.shareCount = shareCount;
	}

	public String getBankBranchAName() {
		return bankBranchAName;
	}

	public void setBankBranchAName(String bankBranchAName) {
		this.bankBranchAName = bankBranchAName;
	}

	public String getBankBranchBName() {
		return bankBranchBName;
	}

	public void setBankBranchBName(String bankBranchBName) {
		this.bankBranchBName = bankBranchBName;
	}

	public String getBankBranchAIFSC() {
		return bankBranchAIFSC;
	}

	public void setBankBranchAIFSC(String bankBranchAIFSC) {
		this.bankBranchAIFSC = bankBranchAIFSC;
	}

	public String getBankBranchBIFSC() {
		return bankBranchBIFSC;
	}

	public void setBankBranchBIFSC(String bankBranchBIFSC) {
		this.bankBranchBIFSC = bankBranchBIFSC;
	}

	public Boolean getActive() {
		return isActive;
	}

	public void setActive(Boolean active) {
		isActive = active;
	}

	public Boolean getDefaulter() {
		return isDefaulter;
	}

	public void setDefaulter(Boolean defaulter) {
		isDefaulter = defaulter;
	}

	public Boolean getAgent() {
		return isAgent;
	}

	public void setAgent(Boolean agent) {
		isAgent = agent;
	}

	public Integer getDebitAccount() {
		return debitAccount;
	}

	public void setDebitAccount(Integer debitAccount) {
		this.debitAccount = debitAccount;
	}

	public Integer getLoginBranch() {
		return loginBranch;
	}

	public void setLoginBranch(Integer loginBranch) {
		this.loginBranch = loginBranch;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getBankAName() {
		return bankAName;
	}

	public void setBankAName(String bankAName) {
		this.bankAName = bankAName;
	}

	public String getBankBName() {
		return bankBName;
	}

	public void setBankBName(String bankBName) {
		this.bankBName = bankBName;
	}
}