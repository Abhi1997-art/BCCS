package com.service.banking.model.dashboardModel;

import java.math.BigDecimal;
import java.util.Date;

import com.service.banking.utils.DateFormater;

public class DDSSchemaDetails {

	public Integer id;
	public String name;
	private String interest;
	public Integer maturityPeriod;
	public Integer crpb;
	public String accountOpenningCommission;
	public String collectorCommissionRate;
	public Integer percentLoanOnDeposit;
	public Integer noLoanOnDepositTill;
	public String preMatureInterests;
	public String validTill;
	public Double minLimit;
	public Double maxLimit;
	public Boolean activeStatus;
	public String createdAt;

	public DDSSchemaDetails() {

	}

	public DDSSchemaDetails(Integer id, String name, String interest, Integer maturityPeriod, Integer crpb,
			String accountOpenningCommission, String collectorCommissionRate, Integer percentLoanOnDeposit,
			Integer noLoanOnDepositTill, String preMatureInterests, String validTill, Boolean activestatus,
			Double minLimit, Double maxLimit, Date createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.interest = interest;
		this.maturityPeriod = maturityPeriod;
		this.crpb = crpb;
		this.accountOpenningCommission = accountOpenningCommission;
		this.collectorCommissionRate = collectorCommissionRate;
		this.percentLoanOnDeposit = percentLoanOnDeposit;
		this.noLoanOnDepositTill = noLoanOnDepositTill;
		this.preMatureInterests = preMatureInterests;
		this.validTill = validTill;
		this.activeStatus = activestatus;
		this.minLimit = minLimit;
		this.maxLimit = maxLimit;
		this.createdAt = DateFormater.getformatDate(createdAt);
	}

	public String getAccountOpenningCommission() {
		return accountOpenningCommission;
	}

	public void setAccountOpenningCommission(String accountOpenningCommission) {
		this.accountOpenningCommission = accountOpenningCommission;
	}

	public Boolean getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
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

	public Integer getCrpb() {
		return crpb;
	}

	public void setCrpb(Integer crpb) {
		this.crpb = crpb;
	}

	public String getCommission() {
		return accountOpenningCommission;
	}

	public void setCommission(String accountOpenningCommission) {
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

}
