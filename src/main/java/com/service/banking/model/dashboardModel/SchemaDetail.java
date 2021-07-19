package com.service.banking.model.dashboardModel;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.service.banking.utils.DateFormater;

@JsonInclude(Include.NON_NULL)
public class SchemaDetail {

	Long totalAccounts;
	Long activeAccounts;
	Integer id;
	String schemaName;
	String interest;
	Double processingFees;
	String validTill;
	String head;
	Double maxlimits;
	Double minlimits;
	String createdAt;

	Integer crpb;
	Integer percentLoanOnDeposit;
	Integer noLoanOnDepositTill;
	String preMatureInterests;
	BigDecimal matureInterestsForUncompleteProduct;
	Integer maturityPeriod;
	Double commission;
	String collectorCommissionRate;
	String accountOpenningCommission;
	String PremiumMode;

	Integer headId;

	public SchemaDetail(Integer id, String schemaName) {
		super();
		this.id = id;
		this.schemaName = schemaName;
	}

	public SchemaDetail(Integer id, String interest, String preMatureInterests,
			BigDecimal matureInterestsForUncompleteProduct, Integer maturityPeriod) {
		super();
		this.id = id;
		this.interest = interest;
		this.preMatureInterests = preMatureInterests;
		this.matureInterestsForUncompleteProduct = matureInterestsForUncompleteProduct;
		this.maturityPeriod = maturityPeriod;
	}

	public SchemaDetail(Integer id, String interest, String preMatureInterests,
			BigDecimal matureInterestsForUncompleteProduct, Integer maturityPeriod, Integer headId) {
		super();
		this.id = id;
		this.interest = interest;
		this.preMatureInterests = preMatureInterests;
		this.matureInterestsForUncompleteProduct = matureInterestsForUncompleteProduct;
		this.maturityPeriod = maturityPeriod;
		this.headId = headId;
	}

	public SchemaDetail(Long totalAccounts, Long activeAccounts, Integer id, String schemaName, String interest,
			Double processingFees, String validTill, Double maxlimits, Double minlimits, String head, Date createdAt,
			Integer crpb, Integer percentLoanOnDeposit, Integer noLoanOnDepositTill, String preMatureInterests,
			BigDecimal matureInterestsForUncompleteProduct, Integer maturityPeriod, Double commission,
			String collectorCommissionRate, String accountOpenningCommission, String PremiumMode, Integer headId) {
		super();
		this.totalAccounts = totalAccounts;
		this.activeAccounts = activeAccounts;
		this.id = id;
		this.schemaName = schemaName;
		this.interest = interest;
		this.processingFees = processingFees;
		this.validTill = validTill;
		this.maxlimits = maxlimits;
		this.minlimits = minlimits;
		this.head = head;
		this.createdAt = DateFormater.getformatDate(createdAt);
		this.crpb = crpb;
		this.percentLoanOnDeposit = percentLoanOnDeposit;
		this.noLoanOnDepositTill = noLoanOnDepositTill;
		this.preMatureInterests = preMatureInterests;
		this.matureInterestsForUncompleteProduct = matureInterestsForUncompleteProduct;
		this.maturityPeriod = maturityPeriod;
		this.commission = commission;
		this.collectorCommissionRate = collectorCommissionRate;
		this.accountOpenningCommission = accountOpenningCommission;
		this.PremiumMode = PremiumMode;
		this.headId = headId;
	}

	public SchemaDetail() {
		super();
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

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Double getProcessingFees() {
		return processingFees;
	}

	public void setProcessingFees(Double processingFees) {
		this.processingFees = processingFees;
	}

//public String getValidTill() {
//	return validTill;
//}
//public void setValidTill(String validTill) {
//	this.validTill = validTill;
//}
	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public Double getMaxlimits() {
		return maxlimits;
	}

	public void setMaxlimits(Double maxlimits) {
		this.maxlimits = maxlimits;
	}

	public Double getMinlimits() {
		return minlimits;
	}

	public void setMinlimits(Double minlimits) {
		this.minlimits = minlimits;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getCrpb() {
		return crpb;
	}

	public void setCrpb(Integer crpb) {
		this.crpb = crpb;
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

	public BigDecimal getMatureInterestsForUncompleteProduct() {
		return matureInterestsForUncompleteProduct;
	}

	public void setMatureInterestsForUncompleteProduct(BigDecimal matureInterestsForUncompleteProduct) {
		this.matureInterestsForUncompleteProduct = matureInterestsForUncompleteProduct;
	}

	public Integer getMaturityPeriod() {
		return maturityPeriod;
	}

	public void setMaturityPeriod(Integer maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public String getCollectorCommissionRate() {
		return collectorCommissionRate;
	}

	public void setCollectorCommissionRate(String collectorCommissionRate) {
		this.collectorCommissionRate = collectorCommissionRate;
	}

	public String getAccountOpenningCommission() {
		return accountOpenningCommission;
	}

	public void setAccountOpenningCommission(String accountOpenningCommission) {
		this.accountOpenningCommission = accountOpenningCommission;
	}

	public String getPremiumMode() {
		return PremiumMode;
	}

	public void setPremiumMode(String premiumMode) {
		PremiumMode = premiumMode;
	}

	public Integer getHeadId() {
		return headId;
	}

	public void setHeadId(Integer headId) {
		this.headId = headId;
	}

	@Override
	public String toString() {
		return "SchemaDetail [schemaId=" + id + ", interest=" + interest + ", preMatureInterests="
				+ preMatureInterests + ", matureInterestsForUncompleteProduct=" + matureInterestsForUncompleteProduct
				+ "]";
	}

}
