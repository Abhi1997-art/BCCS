package com.service.banking.model.dashboardModel;

import java.util.Date;

import com.service.banking.utils.DateFormater;

public class RecurringSchemaDetails {

	Long totalAccounts;
	Long activeAccounts;
	public Integer id;
	public String name;
	private String interest;
	public Integer maturityPeriod;
	String premiumMode;
	Integer numberOfPremiums;
	public Integer crpb;
	public String accountOpenningCommission;
	public String collectorCommissionRate;
	public Integer percentLoanOnDeposit;
	public Integer noLoanOnDepositTill;
	public String preMatureInterests;
	String head;
	public String validTill;
	public Double minLimit;
	public Double maxLimit;
	public String createdAt;

	public RecurringSchemaDetails() {
		super();
	}

	public RecurringSchemaDetails(Long totalAccounts, Long activeAccounts, Integer id, String name, String interest,
			Integer maturityPeriod, String premiumMode,Integer numberOfPremiums, Integer crpb, String accountOpenningCommission,
			String collectorCommissionRate, Integer percentLoanOnDeposit, Integer noLoanOnDepositTill,
			String preMatureInterests, String validTill, Double minLimit, Double maxLimit, String head,
			Date createdAt) {
		super();
		this.totalAccounts = totalAccounts;
		this.activeAccounts = activeAccounts;
		this.id = id;
		this.name = name;
		this.interest = interest;
		this.maturityPeriod = maturityPeriod;
		this.premiumMode = premiumMode;
		this.numberOfPremiums=numberOfPremiums;
		this.crpb = crpb;
		this.accountOpenningCommission = accountOpenningCommission;
		this.collectorCommissionRate = collectorCommissionRate;
		this.percentLoanOnDeposit = percentLoanOnDeposit;
		this.noLoanOnDepositTill = noLoanOnDepositTill;
		this.preMatureInterests = preMatureInterests;
		this.validTill = validTill;
		this.minLimit = minLimit;
		this.maxLimit = maxLimit;
		this.head = head;
		this.createdAt = DateFormater.getformatDate(createdAt);
	}

	public Long getTotalAccounts() {
		return totalAccounts;
	}

	public void setTotalAccounts(Long totalAccounts) {
		this.totalAccounts = totalAccounts;
	}

	public Long getActiveAccounts() {
		return activeAccounts;
	}

	public void setActiveAccounts(Long activeAccounts) {
		this.activeAccounts = activeAccounts;
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

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Integer getMaturityPeriod() {
		return maturityPeriod;
	}

	public void setMaturityPeriod(Integer maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
	}

	public String getPremiumMode() {
		return premiumMode;
	}

	public void setPremiumMode(String premiumMode) {
		this.premiumMode = premiumMode;
	}

	public Integer getCrpb() {
		return crpb;
	}

	public void setCrpb(Integer crpb) {
		this.crpb = crpb;
	}

	public String getAccountOpenningCommission() {
		return accountOpenningCommission;
	}

	public void setAccountOpenningCommission(String accountOpenningCommission) {
		this.accountOpenningCommission = accountOpenningCommission;
	}

	public String getCollectorCommissionRate() {
		return collectorCommissionRate;
	}

	public void setCollectorCommissionRate(String collectorCommissionRate) {
		this.collectorCommissionRate = collectorCommissionRate;
	}

	public Integer getPercentLoanOnDeposit() {
		return percentLoanOnDeposit;
	}

	public void setPercentLoanOnDeposit(Integer percentLoanOnDeposit) {
		this.percentLoanOnDeposit = percentLoanOnDeposit;
	}

	public Integer getNoLoanOnDepositTill() {
		return noLoanOnDepositTill;
	}

	public void setNoLoanOnDepositTill(Integer noLoanOnDepositTill) {
		this.noLoanOnDepositTill = noLoanOnDepositTill;
	}

	public String getPreMatureInterests() {
		return preMatureInterests;
	}

	public void setPreMatureInterests(String preMatureInterests) {
		this.preMatureInterests = preMatureInterests;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public Double getMinLimit() {
		return minLimit;
	}

	public void setMinLimit(Double minLimit) {
		this.minLimit = minLimit;
	}

	public Double getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(Double maxLimit) {
		this.maxLimit = maxLimit;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getNumberOfPremiums() {
		return numberOfPremiums;
	}

	public void setNumberOfPremiums(Integer numberOfPremiums) {
		this.numberOfPremiums = numberOfPremiums;
	}
	
	

}
