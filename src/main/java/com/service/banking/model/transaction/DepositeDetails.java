package com.service.banking.model.transaction;

public class DepositeDetails {

	private Integer acFrom;
	private Integer acTo;
	private Double amount;
	private String narration;
	private Boolean shares;
	private Integer transactionTypeId;
	private Integer staffId;
	private Integer branchId;
	private String accountType;
	private Integer submittedIntoBranchId;
	private Integer tds;
	private Integer pf;
	private Integer esi;
	private Integer healthInsurance;
	private Integer Security;
	private Integer chargeAccount;
	private Integer chargeAmount;
	private Integer loginBranch;
	private String getStaffName;
	

	public DepositeDetails() {
		super();
	}

	public DepositeDetails(Integer acFrom, Integer acTo, Double amount, String narration, Boolean shares,
			Integer transactionTypeId, Integer staffId, Integer branchId, String accountType,
			Integer submittedIntoBranchId) {
		super();
		this.acFrom = acFrom;
		this.acTo = acTo;
		this.amount = amount;
		this.narration = narration;
		this.shares = shares;
		this.transactionTypeId = transactionTypeId;
		this.staffId = staffId;
		this.branchId = branchId;
		this.accountType = accountType;
		this.submittedIntoBranchId = submittedIntoBranchId;
	}
	
	

	public DepositeDetails(Integer acFrom, Integer acTo, Double amount, String narration, Boolean shares,
			Integer transactionTypeId, Integer staffId, Integer branchId, String accountType,
			Integer submittedIntoBranchId, Integer tds, Integer pf, Integer esi, Integer healthInsurance,
			Integer security) {
		super();
		this.acFrom = acFrom;
		this.acTo = acTo;
		this.amount = amount;
		this.narration = narration;
		this.shares = shares;
		this.transactionTypeId = transactionTypeId;
		this.staffId = staffId;
		this.branchId = branchId;
		this.accountType = accountType;
		this.submittedIntoBranchId = submittedIntoBranchId;
		this.tds = tds;
		this.pf = pf;
		this.esi = esi;
		this.healthInsurance = healthInsurance;
		Security = security;
	}
	
	

	public DepositeDetails(Integer acFrom, Integer acTo, Double amount, String narration, Boolean shares,
			Integer transactionTypeId, Integer staffId, Integer branchId, String accountType,
			Integer submittedIntoBranchId, Integer tds, Integer pf, Integer esi, Integer healthInsurance,
			Integer security, Integer chargeAccount, Integer chargeAmount, Integer loginBranch, String getStaffName) {
		super();
		this.acFrom = acFrom;
		this.acTo = acTo;
		this.amount = amount;
		this.narration = narration;
		this.shares = shares;
		this.transactionTypeId = transactionTypeId;
		this.staffId = staffId;
		this.branchId = branchId;
		this.accountType = accountType;
		this.submittedIntoBranchId = submittedIntoBranchId;
		this.tds = tds;
		this.pf = pf;
		this.esi = esi;
		this.healthInsurance = healthInsurance;
		Security = security;
		this.chargeAccount = chargeAccount;
		this.chargeAmount = chargeAmount;
		this.loginBranch = loginBranch;
		this.getStaffName = getStaffName;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public Integer getSubmittedIntoBranchId() {
		return submittedIntoBranchId;
	}

	public void setSubmittedIntoBranchId(Integer submittedIntoBranchId) {
		this.submittedIntoBranchId = submittedIntoBranchId;
	}

	public Integer getAcFrom() {
		return acFrom;
	}

	public void setAcFrom(Integer acFrom) {
		this.acFrom = acFrom;
	}

	public Integer getAcTo() {
		return acTo;
	}

	public void setAcTo(Integer acTo) {
		this.acTo = acTo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public Boolean getShares() {
		return shares;
	}

	public void setShares(Boolean shares) {
		this.shares = shares;
	}

	public Integer getTransactionTypeId() {
		return transactionTypeId;
	}

	public void setTransactionTypeId(Integer transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Integer getTds() {
		return tds;
	}

	public void setTds(Integer tds) {
		this.tds = tds;
	}

	public Integer getPf() {
		return pf;
	}

	public void setPf(Integer pf) {
		this.pf = pf;
	}

	public Integer getEsi() {
		return esi;
	}

	public void setEsi(Integer esi) {
		this.esi = esi;
	}

	public Integer getHealthInsurance() {
		return healthInsurance;
	}

	public void setHealthInsurance(Integer healthInsurance) {
		this.healthInsurance = healthInsurance;
	}

	public Integer getSecurity() {
		return Security;
	}

	public void setSecurity(Integer security) {
		Security = security;
	}

	public Integer getChargeAccount() {
		return chargeAccount;
	}

	public void setChargeAccount(Integer chargeAccount) {
		this.chargeAccount = chargeAccount;
	}

	public Integer getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(Integer chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public Integer getLoginBranch() {
		return loginBranch;
	}

	public void setLoginBranch(Integer loginBranch) {
		this.loginBranch = loginBranch;
	}

	public String getGetStaffName() {
		return getStaffName;
	}

	public void setGetStaffName(String getStaffName) {
		this.getStaffName = getStaffName;
	}

	
	
}
