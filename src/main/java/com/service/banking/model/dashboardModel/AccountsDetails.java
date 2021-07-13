package com.service.banking.model.dashboardModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.service.banking.hibernateEntity.AccountGuarantors;
import com.service.banking.utils.DateFormater;

public class AccountsDetails {

	public Integer id;
	public String accountNumber;
	public String modeOfOperation;
	public Date createdAt;
	public String memberName;
	public String fatherName;
	public Integer memberId;
	public String panNo;
	public String adharNumber;
	public String permanentAddress;
	public String phoneNos;
	public Double amount;
	public String repaymentMode;
	public String agentName;
	public String dealerName;
	public Integer maturityToAccountId;

	public String name;
	public String interest;
	public String commission;
	public Double processingFees;
	public String premiumMode;
	public Integer maturityPeriod;
	public Integer numberOfPremiums;
	public String schemeType;
	public String type;
	public String schemeGroup;
	public String interestMode;
	public Date insuranceStartDate;
	public Date nextInsuranceDueDate;
	public String narration;
	public Integer memberNo;
	public Date dueDate;
	public String premiumAmount;
	public Integer codeNo;
	public String agentAddress;
	public String reducingOrFlatRate;
	public String agentLandmark;
	public Integer agentMemberNo;
	

	public AccountsDetails() {
		super();
	}

	public AccountsDetails(Integer id, String accountNumber, String modeOfOperation, Date createdAt, String memberName,
			String fatherName, Integer memberId, String panNo, String adharNumber, String permanentAddress,
			String phoneNos, Double amount, String repaymentMode, String agentName, String dealerName,
			Integer maturityToAccountId, String name, String interest, String commission, Double processingFees,
			String premiumMode, Integer maturityPeriod, Integer numberOfPremiums, String schemeType, String type,
			String schemeGroup, String interestMode, Date insuranceStartDate, Date nextInsuranceDueDate,
			String narration, Integer memberNo) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.modeOfOperation = modeOfOperation;
		this.createdAt = createdAt;
		this.memberName = memberName;
		this.fatherName = fatherName;
		this.memberId = memberId;
		this.panNo = panNo;
		this.adharNumber = adharNumber;
		this.permanentAddress = permanentAddress;
		this.phoneNos = phoneNos;
		this.amount = amount;
		this.repaymentMode = repaymentMode;
		this.agentName = agentName;
		this.dealerName = dealerName;
		this.maturityToAccountId = maturityToAccountId;
		this.name = name;
		this.interest = interest;
		this.commission = commission;
		this.processingFees = processingFees;
		this.premiumMode = premiumMode;
		this.maturityPeriod = maturityPeriod;
		this.numberOfPremiums = numberOfPremiums;
		this.schemeType = schemeType;
		this.type = type;
		this.schemeGroup = schemeGroup;
		this.interestMode = interestMode;
		this.insuranceStartDate = insuranceStartDate;
		this.nextInsuranceDueDate = nextInsuranceDueDate;
		this.narration = narration;
		this.memberNo = memberNo;
	}

	public AccountsDetails(Integer id, String accountNumber, String modeOfOperation, Date createdAt, String memberName,
			String fatherName, Integer memberId, String panNo, String adharNumber, String permanentAddress,
			String phoneNos, Double amount, String repaymentMode, String agentName, String dealerName,
			Integer maturityToAccountId, String name, String interest, String commission, Double processingFees,
			String premiumMode, Integer maturityPeriod, Integer numberOfPremiums, String schemeType, String type,
			String schemeGroup, String interestMode, Date insuranceStartDate, Date nextInsuranceDueDate,
			String narration, Integer memberNo, Date dueDate, String premiumAmount, Integer codeNo, String agentAddress, String reducingOrFlatRate,
			String agentLandmark, Integer agentMemberNo) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.modeOfOperation = modeOfOperation;
		this.createdAt = createdAt;
		this.memberName = memberName;
		this.fatherName = fatherName;
		this.memberId = memberId;
		this.panNo = panNo;
		this.adharNumber = adharNumber;
		this.permanentAddress = permanentAddress;
		this.phoneNos = phoneNos;
		this.amount = amount;
		this.repaymentMode = repaymentMode;
		this.agentName = agentName;
		this.dealerName = dealerName;
		this.maturityToAccountId = maturityToAccountId;
		this.name = name;
		this.interest = interest;
		this.commission = commission;
		this.processingFees = processingFees;
		this.premiumMode = premiumMode;
		this.maturityPeriod = maturityPeriod;
		this.numberOfPremiums = numberOfPremiums;
		this.schemeType = schemeType;
		this.type = type;
		this.schemeGroup = schemeGroup;
		this.interestMode = interestMode;
		this.insuranceStartDate = insuranceStartDate;
		this.nextInsuranceDueDate = nextInsuranceDueDate;
		this.narration = narration;
		this.memberNo = memberNo;
		this.dueDate = dueDate;
		this.premiumAmount = premiumAmount;
		this.codeNo = codeNo;
		this.agentAddress=agentAddress;
		this.reducingOrFlatRate=reducingOrFlatRate;
		this.agentLandmark= agentLandmark;
		this.agentMemberNo=agentMemberNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public Double getProcessingFees() {
		return processingFees;
	}

	public void setProcessingFees(Double processingFees) {
		this.processingFees = processingFees;
	}

	public String getPremiumMode() {
		return premiumMode;
	}

	public void setPremiumMode(String premiumMode) {
		this.premiumMode = premiumMode;
	}

	public Integer getMaturityPeriod() {
		return maturityPeriod;
	}

	public void setMaturityPeriod(Integer maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
	}

	public Integer getNumberOfPremiums() {
		return numberOfPremiums;
	}

	public void setNumberOfPremiums(Integer numberOfPremiums) {
		this.numberOfPremiums = numberOfPremiums;
	}

	public String getSchemeType() {
		return schemeType;
	}

	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSchemeGroup() {
		return schemeGroup;
	}

	public void setSchemeGroup(String schemeGroup) {
		this.schemeGroup = schemeGroup;
	}

	public String getInterestMode() {
		return interestMode;
	}

	public void setInterestMode(String interestMode) {
		this.interestMode = interestMode;
	}

	public Date getInsuranceStartDate() {
		return insuranceStartDate;
	}

	public void setInsuranceStartDate(Date insuranceStartDate) {
		this.insuranceStartDate = insuranceStartDate;
	}

	public Date getNextInsuranceDueDate() {
		return nextInsuranceDueDate;
	}

	public void setNextInsuranceDueDate(Date nextInsuranceDueDate) {
		this.nextInsuranceDueDate = nextInsuranceDueDate;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getModeOfOperation() {
		return modeOfOperation;
	}

	public void setModeOfOperation(String modeOfOperation) {
		this.modeOfOperation = modeOfOperation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPhoneNos() {
		return phoneNos;
	}

	public void setPhoneNos(String phoneNos) {
		this.phoneNos = phoneNos;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getRepaymentMode() {
		return repaymentMode;
	}

	public void setRepaymentMode(String repaymentMode) {
		this.repaymentMode = repaymentMode;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public Integer getMaturityToAccountId() {
		return maturityToAccountId;
	}

	public void setMaturityToAccountId(Integer maturityToAccountId) {
		this.maturityToAccountId = maturityToAccountId;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(String premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public Integer getCodeNo() {
		return codeNo;
	}

	public void setCodeNo(Integer codeNo) {
		this.codeNo = codeNo;
	}

	public String getAgentAddress() {
		return agentAddress;
	}

	public void setAgentAddress(String agentAddress) {
		this.agentAddress = agentAddress;
	}

	public String getReducingOrFlatRate() {
		return reducingOrFlatRate;
	}

	public void setReducingOrFlatRate(String reducingOrFlatRate) {
		this.reducingOrFlatRate = reducingOrFlatRate;
	}

	public String getAgentLandmark() {
		return agentLandmark;
	}

	public void setAgentLandmark(String agentLandmark) {
		this.agentLandmark = agentLandmark;
	}

	public Integer getAgentMemberNo() {
		return agentMemberNo;
	}

	public void setAgentMemberNo(Integer agentMemberNo) {
		this.agentMemberNo = agentMemberNo;
	}
	

}
