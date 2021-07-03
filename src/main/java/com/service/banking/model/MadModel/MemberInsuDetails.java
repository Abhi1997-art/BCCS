package com.service.banking.model.MadModel;

import java.math.BigDecimal;
import java.util.Date;

public class MemberInsuDetails {
	
    public String accountNumber;
    public String memberName;
    public Integer memberId;
    public String landmark;
    public String tehsil;
    public String city;
    public String district;
    public String state;
    public String currentAddress;
    public Integer id;
    public Date insuranceStartDate;
	public Byte insuranceDuration;
	public String narration;
	public Date nextInsuranceDueDate;
	public Integer accountId;
	public String name;
	public Integer memberNo;
	public Boolean isDefaulter;
	public Date createdAt;
	public String gender;
	public String fatherName;
	public String phoneNos;
	public Date dob;
	public String nominee;
	private String relationWithNominee;
	private BigDecimal currentBalance;


	public MemberInsuDetails() {
		super();
	}


	public MemberInsuDetails(String accountNumber, String memberName, int memberId, String landmark, String tehsil,
			String city, String district, String state, String currentAddress, Integer id, Date insuranceStartDate,
			byte insuranceDuration, String narration, Date nextInsuranceDueDate, Integer accounId, String name, Integer memberNo, Boolean isDefaulter) {
		super();
		this.accountNumber = accountNumber;
		this.memberName = memberName;
		this.memberId = memberId;
		this.landmark = landmark;
		this.tehsil = tehsil;
		this.city = city;
		this.district = district;
		this.state = state;
		this.currentAddress = currentAddress;
		this.id = id;
		this.insuranceStartDate = insuranceStartDate;
		this.insuranceDuration = insuranceDuration;
		this.narration = narration;
		this.nextInsuranceDueDate = nextInsuranceDueDate;
		this.accountId=accounId;
		this.name=name;
		this.memberNo=memberNo;
		this.isDefaulter=isDefaulter;
	}
	
	
	
	public MemberInsuDetails(String accountNumber, String memberName, Integer memberId, String landmark, String tehsil,
			String city, String district, String state, String currentAddress, Integer id, Date insuranceStartDate,
			Byte insuranceDuration, String narration, Date nextInsuranceDueDate, Integer accountId, String name,
			Integer memberNo, Boolean isDefaulter, Date createdAt, String gender, String fatherName, String phoneNos,
			Date dob, String nominee, String relationWithNominee, BigDecimal currentBalance) {
		super();
		this.accountNumber = accountNumber;
		this.memberName = memberName;
		this.memberId = memberId;
		this.landmark = landmark;
		this.tehsil = tehsil;
		this.city = city;
		this.district = district;
		this.state = state;
		this.currentAddress = currentAddress;
		this.id = id;
		this.insuranceStartDate = insuranceStartDate;
		this.insuranceDuration = insuranceDuration;
		this.narration = narration;
		this.nextInsuranceDueDate = nextInsuranceDueDate;
		this.accountId = accountId;
		this.name = name;
		this.memberNo = memberNo;
		this.isDefaulter = isDefaulter;
		this.createdAt = createdAt;
		this.gender = gender;
		this.fatherName = fatherName;
		this.phoneNos = phoneNos;
		this.dob = dob;
		this.nominee = nominee;
		this.relationWithNominee = relationWithNominee;
		this.currentBalance = currentBalance;
	}


	public String getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getDistrict() {
		return district;
	}



	public void setDistrict(String district) {
		this.district = district;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCurrentAddress() {
		return currentAddress;
	}



	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Date getInsuranceStartDate() {
		return insuranceStartDate;
	}



	public void setInsuranceStartDate(Date insuranceStartDate) {
		this.insuranceStartDate = insuranceStartDate;
	}



	public Byte getInsuranceDuration() {
		return insuranceDuration;
	}



	public void setInsuranceDuration(Byte insuranceDuration) {
		this.insuranceDuration = insuranceDuration;
	}



	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public Date getNextInsuranceDueDate() {
		return nextInsuranceDueDate;
	}

	public void setNextInsuranceDueDate(Date nextInsuranceDueDate) {
		this.nextInsuranceDueDate = nextInsuranceDueDate;
	}


	public Integer getAccountId() {
		return accountId;
	}


	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public String getPhoneNos() {
		return phoneNos;
	}


	public void setPhoneNos(String phoneNos) {
		this.phoneNos = phoneNos;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getNominee() {
		return nominee;
	}


	public void setNominee(String nominee) {
		this.nominee = nominee;
	}


	public String getRelationWithNominee() {
		return relationWithNominee;
	}


	public void setRelationWithNominee(String relationWithNominee) {
		this.relationWithNominee = relationWithNominee;
	}


	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}


	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

	
	

}
