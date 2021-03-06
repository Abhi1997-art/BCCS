package com.service.banking.hibernateEntity;
// Generated Feb 20, 2020 6:19:12 PM by Hibernate Tools 5.2.12.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AccountsPending generated by hbm2java
 */
@Entity
@Table(name = "accounts_pending")
public class AccountsPending implements java.io.Serializable {

	private Integer id;
	private Integer agentId;
	private Double openingBalanceDr;
	private Double openingBalanceCr;
	private Double closingBalance;
	private Double currentBalanceDr;
	private String currentInterest;
	private Boolean activeStatus;
	private String nominee;
	private Short nomineeAge;
	private String relationWithNominee;
	private String minorNomineeDob;
	private String minorNomineeParentName;
	private String modeOfOperation;
	private int memberId;
	private Boolean defaultAc;
	private Integer schemeId;
	private String accountNumber;
	private Date createdAt;
	private Date updatedAt;
	private int sigImageId;
	private int branchId;
	private int staffId;
	private Double currentBalanceCr;
	private Date lastCurrentInterestUpdatedAt;
	private Integer intrestToAccountId;
	private Integer maturityToAccountId;
	private Double amount;
	private Date loanInsurranceDate;
	private int dealerId;
	private Boolean lockingStatus;
	private Integer loanAgainstAccountId;
	private Boolean affectsBalanceSheet;
	private Boolean maturedStatus;
	private Integer collectorId;
	private String collectorAccountNumber;
	private String accountDisplayName;
	private String pandLgroup;
	private String groupType;
	private String accountType;
	private Integer relatedAccountId;
	private String extraInfo;
	private Boolean isApproved;
	private Integer docImageId;
	private Integer moId;
	private Integer teamId;
	private Byte isDirty;
	private byte bikeSurrendered;
	private byte bikeSurrenderedOn;
	private Byte isGivenForLegalProcess;
	private Date legalProcessGivenDate;
	private byte isInLegal;
	private Date legalFilingDate;
	private String repaymentMode;
	private String insuranceTenure;
	private String bikeSurrenderedBy;
	private Byte isGodownchargeDebited;
	private Date godownchargeDebitedOn;
	private Byte isLegalNoticeSentForBikeAuction;
	private Date legalNoticeSentForBikeAuctionOn;
	private Byte isBikeAuctioned;
	private Date bikeAuctionedOn;
	private Byte isFinalRecoveryNoticeSent;
	private Date finalRecoveryNoticeSentOn;
	private Byte isChequePresentedInBank;
	private Date chequePresentedInBankOn;
	private Byte isChequeReturned;
	private Date chequeReturnedOn;
	private Byte isNoticeSentAfterChequeReturned;
	private Date noticeSentAfterChequeReturnedOn;
	private Byte isLegalCaseFinalised;
	private Date legalCaseFinalisedOn;
	private Byte isBikeReturned;
	private Date bikeReturnedOn;
	private String bikeNotSoldReason;
	private String legalCaseNotSubmittedReason;
	private String newOrRenew;
	private Byte isInArbitration;
	private Date arbitrationOn;
	private Byte isSocietyNoticeSent;
	private Date societyNoticeSentOn;
	private Byte isVisitDone;
	private Date visitDoneOn;
	private Byte isLegalNoticeSent;
	private Date legalNoticeSentOn;
	private Byte isNocHandlingChargeReceived;
	private Date nocHandlingChargeReceivedOn;
	private String lockStatusChangedReason;
	private Integer telecallerId;
	private int bankAccountLimit;
	private Integer relatedTypeId;
	private String relatedType;

	public AccountsPending() {
	}

	public AccountsPending(int memberId, String accountNumber, int sigImageId, int branchId, int staffId, int dealerId,
			String pandLgroup, byte bikeSurrendered, byte bikeSurrenderedOn, byte isInLegal, Date legalFilingDate,
			String insuranceTenure, String newOrRenew, int bankAccountLimit) {
		this.memberId = memberId;
		this.accountNumber = accountNumber;
		this.sigImageId = sigImageId;
		this.branchId = branchId;
		this.staffId = staffId;
		this.dealerId = dealerId;
		this.pandLgroup = pandLgroup;
		this.bikeSurrendered = bikeSurrendered;
		this.bikeSurrenderedOn = bikeSurrenderedOn;
		this.isInLegal = isInLegal;
		this.legalFilingDate = legalFilingDate;
		this.insuranceTenure = insuranceTenure;
		this.newOrRenew = newOrRenew;
		this.bankAccountLimit = bankAccountLimit;
	}

	public AccountsPending(Integer agentId, Double openingBalanceDr, Double openingBalanceCr, Double closingBalance,
			Double currentBalanceDr, String currentInterest, Boolean activeStatus, String nominee, Short nomineeAge,
			String relationWithNominee, String minorNomineeDob, String minorNomineeParentName, String modeOfOperation,
			int memberId, Boolean defaultAc, Integer schemeId, String accountNumber, Date createdAt, Date updatedAt,
			int sigImageId, int branchId, int staffId, Double currentBalanceCr, Date lastCurrentInterestUpdatedAt,
			Integer intrestToAccountId, Integer maturityToAccountId, Double amount, Date loanInsurranceDate,
			int dealerId, Boolean lockingStatus, Integer loanAgainstAccountId, Boolean affectsBalanceSheet,
			Boolean maturedStatus, Integer collectorId, String collectorAccountNumber, String accountDisplayName,
			String pandLgroup, String group, String accountType, Integer relatedAccountId, String extraInfo,
			Boolean isApproved, Integer docImageId, Integer moId, Integer teamId, Byte isDirty, byte bikeSurrendered,
			byte bikeSurrenderedOn, Byte isGivenForLegalProcess, Date legalProcessGivenDate, byte isInLegal,
			Date legalFilingDate, String repaymentMode, String insuranceTenure, String bikeSurrenderedBy,
			Byte isGodownchargeDebited, Date godownchargeDebitedOn, Byte isLegalNoticeSentForBikeAuction,
			Date legalNoticeSentForBikeAuctionOn, Byte isBikeAuctioned, Date bikeAuctionedOn,
			Byte isFinalRecoveryNoticeSent, Date finalRecoveryNoticeSentOn, Byte isChequePresentedInBank,
			Date chequePresentedInBankOn, Byte isChequeReturned, Date chequeReturnedOn,
			Byte isNoticeSentAfterChequeReturned, Date noticeSentAfterChequeReturnedOn, Byte isLegalCaseFinalised,
			Date legalCaseFinalisedOn, Byte isBikeReturned, Date bikeReturnedOn, String bikeNotSoldReason,
			String legalCaseNotSubmittedReason, String newOrRenew, Byte isInArbitration, Date arbitrationOn,
			Byte isSocietyNoticeSent, Date societyNoticeSentOn, Byte isVisitDone, Date visitDoneOn,
			Byte isLegalNoticeSent, Date legalNoticeSentOn, Byte isNocHandlingChargeReceived,
			Date nocHandlingChargeReceivedOn, String lockStatusChangedReason, Integer telecallerId,
			int bankAccountLimit, Integer relatedTypeId, String relatedType) {
		this.agentId = agentId;
		this.openingBalanceDr = openingBalanceDr;
		this.openingBalanceCr = openingBalanceCr;
		this.closingBalance = closingBalance;
		this.currentBalanceDr = currentBalanceDr;
		this.currentInterest = currentInterest;
		this.activeStatus = activeStatus;
		this.nominee = nominee;
		this.nomineeAge = nomineeAge;
		this.relationWithNominee = relationWithNominee;
		this.minorNomineeDob = minorNomineeDob;
		this.minorNomineeParentName = minorNomineeParentName;
		this.modeOfOperation = modeOfOperation;
		this.memberId = memberId;
		this.defaultAc = defaultAc;
		this.schemeId = schemeId;
		this.accountNumber = accountNumber;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.sigImageId = sigImageId;
		this.branchId = branchId;
		this.staffId = staffId;
		this.currentBalanceCr = currentBalanceCr;
		this.lastCurrentInterestUpdatedAt = lastCurrentInterestUpdatedAt;
		this.intrestToAccountId = intrestToAccountId;
		this.maturityToAccountId = maturityToAccountId;
		this.amount = amount;
		this.loanInsurranceDate = loanInsurranceDate;
		this.dealerId = dealerId;
		this.lockingStatus = lockingStatus;
		this.loanAgainstAccountId = loanAgainstAccountId;
		this.affectsBalanceSheet = affectsBalanceSheet;
		this.maturedStatus = maturedStatus;
		this.collectorId = collectorId;
		this.collectorAccountNumber = collectorAccountNumber;
		this.accountDisplayName = accountDisplayName;
		this.pandLgroup = pandLgroup;
		this.groupType = group;
		this.accountType = accountType;
		this.relatedAccountId = relatedAccountId;
		this.extraInfo = extraInfo;
		this.isApproved = isApproved;
		this.docImageId = docImageId;
		this.moId = moId;
		this.teamId = teamId;
		this.isDirty = isDirty;
		this.bikeSurrendered = bikeSurrendered;
		this.bikeSurrenderedOn = bikeSurrenderedOn;
		this.isGivenForLegalProcess = isGivenForLegalProcess;
		this.legalProcessGivenDate = legalProcessGivenDate;
		this.isInLegal = isInLegal;
		this.legalFilingDate = legalFilingDate;
		this.repaymentMode = repaymentMode;
		this.insuranceTenure = insuranceTenure;
		this.bikeSurrenderedBy = bikeSurrenderedBy;
		this.isGodownchargeDebited = isGodownchargeDebited;
		this.godownchargeDebitedOn = godownchargeDebitedOn;
		this.isLegalNoticeSentForBikeAuction = isLegalNoticeSentForBikeAuction;
		this.legalNoticeSentForBikeAuctionOn = legalNoticeSentForBikeAuctionOn;
		this.isBikeAuctioned = isBikeAuctioned;
		this.bikeAuctionedOn = bikeAuctionedOn;
		this.isFinalRecoveryNoticeSent = isFinalRecoveryNoticeSent;
		this.finalRecoveryNoticeSentOn = finalRecoveryNoticeSentOn;
		this.isChequePresentedInBank = isChequePresentedInBank;
		this.chequePresentedInBankOn = chequePresentedInBankOn;
		this.isChequeReturned = isChequeReturned;
		this.chequeReturnedOn = chequeReturnedOn;
		this.isNoticeSentAfterChequeReturned = isNoticeSentAfterChequeReturned;
		this.noticeSentAfterChequeReturnedOn = noticeSentAfterChequeReturnedOn;
		this.isLegalCaseFinalised = isLegalCaseFinalised;
		this.legalCaseFinalisedOn = legalCaseFinalisedOn;
		this.isBikeReturned = isBikeReturned;
		this.bikeReturnedOn = bikeReturnedOn;
		this.bikeNotSoldReason = bikeNotSoldReason;
		this.legalCaseNotSubmittedReason = legalCaseNotSubmittedReason;
		this.newOrRenew = newOrRenew;
		this.isInArbitration = isInArbitration;
		this.arbitrationOn = arbitrationOn;
		this.isSocietyNoticeSent = isSocietyNoticeSent;
		this.societyNoticeSentOn = societyNoticeSentOn;
		this.isVisitDone = isVisitDone;
		this.visitDoneOn = visitDoneOn;
		this.isLegalNoticeSent = isLegalNoticeSent;
		this.legalNoticeSentOn = legalNoticeSentOn;
		this.isNocHandlingChargeReceived = isNocHandlingChargeReceived;
		this.nocHandlingChargeReceivedOn = nocHandlingChargeReceivedOn;
		this.lockStatusChangedReason = lockStatusChangedReason;
		this.telecallerId = telecallerId;
		this.bankAccountLimit = bankAccountLimit;
		this.relatedTypeId = relatedTypeId;
		this.relatedType = relatedType;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "agent_id")
	public Integer getAgentId() {
		return this.agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	@Column(name = "OpeningBalanceDr", precision = 22, scale = 0)
	public Double getOpeningBalanceDr() {
		return this.openingBalanceDr;
	}

	public void setOpeningBalanceDr(Double openingBalanceDr) {
		this.openingBalanceDr = openingBalanceDr;
	}

	@Column(name = "OpeningBalanceCr", precision = 22, scale = 0)
	public Double getOpeningBalanceCr() {
		return this.openingBalanceCr;
	}

	public void setOpeningBalanceCr(Double openingBalanceCr) {
		this.openingBalanceCr = openingBalanceCr;
	}

	@Column(name = "ClosingBalance", precision = 22, scale = 0)
	public Double getClosingBalance() {
		return this.closingBalance;
	}

	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}

	@Column(name = "CurrentBalanceDr", precision = 22, scale = 0)
	public Double getCurrentBalanceDr() {
		return this.currentBalanceDr;
	}

	public void setCurrentBalanceDr(Double currentBalanceDr) {
		this.currentBalanceDr = currentBalanceDr;
	}

	@Column(name = "CurrentInterest", length = 45)
	public String getCurrentInterest() {
		return this.currentInterest;
	}

	public void setCurrentInterest(String currentInterest) {
		this.currentInterest = currentInterest;
	}

	@Column(name = "ActiveStatus")
	public Boolean getActiveStatus() {
		return this.activeStatus;
	}

	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Column(name = "Nominee", length = 45)
	public String getNominee() {
		return this.nominee;
	}

	public void setNominee(String nominee) {
		this.nominee = nominee;
	}

	@Column(name = "NomineeAge")
	public Short getNomineeAge() {
		return this.nomineeAge;
	}

	public void setNomineeAge(Short nomineeAge) {
		this.nomineeAge = nomineeAge;
	}

	@Column(name = "RelationWithNominee", length = 45)
	public String getRelationWithNominee() {
		return this.relationWithNominee;
	}

	public void setRelationWithNominee(String relationWithNominee) {
		this.relationWithNominee = relationWithNominee;
	}

	@Column(name = "MinorNomineeDOB", length = 20)
	public String getMinorNomineeDob() {
		return this.minorNomineeDob;
	}

	public void setMinorNomineeDob(String minorNomineeDob) {
		this.minorNomineeDob = minorNomineeDob;
	}

	@Column(name = "MinorNomineeParentName", length = 45)
	public String getMinorNomineeParentName() {
		return this.minorNomineeParentName;
	}

	public void setMinorNomineeParentName(String minorNomineeParentName) {
		this.minorNomineeParentName = minorNomineeParentName;
	}

	@Column(name = "ModeOfOperation", length = 6)
	public String getModeOfOperation() {
		return this.modeOfOperation;
	}

	public void setModeOfOperation(String modeOfOperation) {
		this.modeOfOperation = modeOfOperation;
	}

	@Column(name = "member_id", nullable = false)
	public int getMemberId() {
		return this.memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	@Column(name = "DefaultAC")
	public Boolean getDefaultAc() {
		return this.defaultAc;
	}

	public void setDefaultAc(Boolean defaultAc) {
		this.defaultAc = defaultAc;
	}

	@Column(name = "scheme_id")
	public Integer getSchemeId() {
		return this.schemeId;
	}

	public void setSchemeId(Integer schemeId) {
		this.schemeId = schemeId;
	}

	@Column(name = "AccountNumber", nullable = false, length = 100)
	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", length = 19)
	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Column(name = "sig_image_id", nullable = false)
	public int getSigImageId() {
		return this.sigImageId;
	}

	public void setSigImageId(int sigImageId) {
		this.sigImageId = sigImageId;
	}

	@Column(name = "branch_id", nullable = false)
	public int getBranchId() {
		return this.branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	@Column(name = "staff_id", nullable = false)
	public int getStaffId() {
		return this.staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	@Column(name = "CurrentBalanceCr", precision = 22, scale = 0)
	public Double getCurrentBalanceCr() {
		return this.currentBalanceCr;
	}

	public void setCurrentBalanceCr(Double currentBalanceCr) {
		this.currentBalanceCr = currentBalanceCr;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastCurrentInterestUpdatedAt", length = 19)
	public Date getLastCurrentInterestUpdatedAt() {
		return this.lastCurrentInterestUpdatedAt;
	}

	public void setLastCurrentInterestUpdatedAt(Date lastCurrentInterestUpdatedAt) {
		this.lastCurrentInterestUpdatedAt = lastCurrentInterestUpdatedAt;
	}

	@Column(name = "intrest_to_account_id")
	public Integer getIntrestToAccountId() {
		return this.intrestToAccountId;
	}

	public void setIntrestToAccountId(Integer intrestToAccountId) {
		this.intrestToAccountId = intrestToAccountId;
	}

	@Column(name = "MaturityToAccount_id")
	public Integer getMaturityToAccountId() {
		return this.maturityToAccountId;
	}

	public void setMaturityToAccountId(Integer maturityToAccountId) {
		this.maturityToAccountId = maturityToAccountId;
	}

	@Column(name = "Amount", precision = 22, scale = 0)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LoanInsurranceDate", length = 19)
	public Date getLoanInsurranceDate() {
		return this.loanInsurranceDate;
	}

	public void setLoanInsurranceDate(Date loanInsurranceDate) {
		this.loanInsurranceDate = loanInsurranceDate;
	}

	@Column(name = "dealer_id", nullable = false)
	public int getDealerId() {
		return this.dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	@Column(name = "LockingStatus")
	public Boolean getLockingStatus() {
		return this.lockingStatus;
	}

	public void setLockingStatus(Boolean lockingStatus) {
		this.lockingStatus = lockingStatus;
	}

	@Column(name = "LoanAgainstAccount_id")
	public Integer getLoanAgainstAccountId() {
		return this.loanAgainstAccountId;
	}

	public void setLoanAgainstAccountId(Integer loanAgainstAccountId) {
		this.loanAgainstAccountId = loanAgainstAccountId;
	}

	@Column(name = "affectsBalanceSheet")
	public Boolean getAffectsBalanceSheet() {
		return this.affectsBalanceSheet;
	}

	public void setAffectsBalanceSheet(Boolean affectsBalanceSheet) {
		this.affectsBalanceSheet = affectsBalanceSheet;
	}

	@Column(name = "MaturedStatus")
	public Boolean getMaturedStatus() {
		return this.maturedStatus;
	}

	public void setMaturedStatus(Boolean maturedStatus) {
		this.maturedStatus = maturedStatus;
	}

	@Column(name = "collector_id")
	public Integer getCollectorId() {
		return this.collectorId;
	}

	public void setCollectorId(Integer collectorId) {
		this.collectorId = collectorId;
	}

	@Column(name = "CollectorAccountNumber", length = 50)
	public String getCollectorAccountNumber() {
		return this.collectorAccountNumber;
	}

	public void setCollectorAccountNumber(String collectorAccountNumber) {
		this.collectorAccountNumber = collectorAccountNumber;
	}

	@Column(name = "AccountDisplayName", length = 50)
	public String getAccountDisplayName() {
		return this.accountDisplayName;
	}

	public void setAccountDisplayName(String accountDisplayName) {
		this.accountDisplayName = accountDisplayName;
	}

	@Column(name = "PAndLGroup", nullable = false)
	public String getPandLgroup() {
		return this.pandLgroup;
	}

	public void setPandLgroup(String pandLgroup) {
		this.pandLgroup = pandLgroup;
	}

	@Column(name = "group_type")
	public String getGroupType() {
		return this.groupType;
	}

	public void setGroupType(String group) {
		this.groupType = group;
	}

	@Column(name = "account_type")
	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Column(name = "related_account_id")
	public Integer getRelatedAccountId() {
		return this.relatedAccountId;
	}

	public void setRelatedAccountId(Integer relatedAccountId) {
		this.relatedAccountId = relatedAccountId;
	}

	@Column(name = "extra_info", length = 65535)
	public String getExtraInfo() {
		return this.extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	@Column(name = "is_approved")
	public Boolean getIsApproved() {
		return this.isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	@Column(name = "doc_image_id")
	public Integer getDocImageId() {
		return this.docImageId;
	}

	public void setDocImageId(Integer docImageId) {
		this.docImageId = docImageId;
	}

	@Column(name = "mo_id")
	public Integer getMoId() {
		return this.moId;
	}

	public void setMoId(Integer moId) {
		this.moId = moId;
	}

	@Column(name = "team_id")
	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	@Column(name = "is_dirty")
	public Byte getIsDirty() {
		return this.isDirty;
	}

	public void setIsDirty(Byte isDirty) {
		this.isDirty = isDirty;
	}

	@Column(name = "bike_surrendered", nullable = false)
	public byte getBikeSurrendered() {
		return this.bikeSurrendered;
	}

	public void setBikeSurrendered(byte bikeSurrendered) {
		this.bikeSurrendered = bikeSurrendered;
	}

	@Column(name = "bike_surrendered_on", nullable = false)
	public byte getBikeSurrenderedOn() {
		return this.bikeSurrenderedOn;
	}

	public void setBikeSurrenderedOn(byte bikeSurrenderedOn) {
		this.bikeSurrenderedOn = bikeSurrenderedOn;
	}

	@Column(name = "is_given_for_legal_process")
	public Byte getIsGivenForLegalProcess() {
		return this.isGivenForLegalProcess;
	}

	public void setIsGivenForLegalProcess(Byte isGivenForLegalProcess) {
		this.isGivenForLegalProcess = isGivenForLegalProcess;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "legal_process_given_date", length = 10)
	public Date getLegalProcessGivenDate() {
		return this.legalProcessGivenDate;
	}

	public void setLegalProcessGivenDate(Date legalProcessGivenDate) {
		this.legalProcessGivenDate = legalProcessGivenDate;
	}

	@Column(name = "is_in_legal", nullable = false)
	public byte getIsInLegal() {
		return this.isInLegal;
	}

	public void setIsInLegal(byte isInLegal) {
		this.isInLegal = isInLegal;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "legal_filing_date", nullable = false, length = 10)
	public Date getLegalFilingDate() {
		return this.legalFilingDate;
	}

	public void setLegalFilingDate(Date legalFilingDate) {
		this.legalFilingDate = legalFilingDate;
	}

	@Column(name = "repayment_mode")
	public String getRepaymentMode() {
		return this.repaymentMode;
	}

	public void setRepaymentMode(String repaymentMode) {
		this.repaymentMode = repaymentMode;
	}

	@Column(name = "insurance_tenure", nullable = false)
	public String getInsuranceTenure() {
		return this.insuranceTenure;
	}

	public void setInsuranceTenure(String insuranceTenure) {
		this.insuranceTenure = insuranceTenure;
	}

	@Column(name = "bike_surrendered_by")
	public String getBikeSurrenderedBy() {
		return this.bikeSurrenderedBy;
	}

	public void setBikeSurrenderedBy(String bikeSurrenderedBy) {
		this.bikeSurrenderedBy = bikeSurrenderedBy;
	}

	@Column(name = "is_godowncharge_debited")
	public Byte getIsGodownchargeDebited() {
		return this.isGodownchargeDebited;
	}

	public void setIsGodownchargeDebited(Byte isGodownchargeDebited) {
		this.isGodownchargeDebited = isGodownchargeDebited;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "godowncharge_debited_on", length = 19)
	public Date getGodownchargeDebitedOn() {
		return this.godownchargeDebitedOn;
	}

	public void setGodownchargeDebitedOn(Date godownchargeDebitedOn) {
		this.godownchargeDebitedOn = godownchargeDebitedOn;
	}

	@Column(name = "is_legal_notice_sent_for_bike_auction")
	public Byte getIsLegalNoticeSentForBikeAuction() {
		return this.isLegalNoticeSentForBikeAuction;
	}

	public void setIsLegalNoticeSentForBikeAuction(Byte isLegalNoticeSentForBikeAuction) {
		this.isLegalNoticeSentForBikeAuction = isLegalNoticeSentForBikeAuction;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "legal_notice_sent_for_bike_auction_on", length = 19)
	public Date getLegalNoticeSentForBikeAuctionOn() {
		return this.legalNoticeSentForBikeAuctionOn;
	}

	public void setLegalNoticeSentForBikeAuctionOn(Date legalNoticeSentForBikeAuctionOn) {
		this.legalNoticeSentForBikeAuctionOn = legalNoticeSentForBikeAuctionOn;
	}

	@Column(name = "is_bike_auctioned")
	public Byte getIsBikeAuctioned() {
		return this.isBikeAuctioned;
	}

	public void setIsBikeAuctioned(Byte isBikeAuctioned) {
		this.isBikeAuctioned = isBikeAuctioned;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bike_auctioned_on", length = 19)
	public Date getBikeAuctionedOn() {
		return this.bikeAuctionedOn;
	}

	public void setBikeAuctionedOn(Date bikeAuctionedOn) {
		this.bikeAuctionedOn = bikeAuctionedOn;
	}

	@Column(name = "is_final_recovery_notice_sent")
	public Byte getIsFinalRecoveryNoticeSent() {
		return this.isFinalRecoveryNoticeSent;
	}

	public void setIsFinalRecoveryNoticeSent(Byte isFinalRecoveryNoticeSent) {
		this.isFinalRecoveryNoticeSent = isFinalRecoveryNoticeSent;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "final_recovery_notice_sent_on", length = 19)
	public Date getFinalRecoveryNoticeSentOn() {
		return this.finalRecoveryNoticeSentOn;
	}

	public void setFinalRecoveryNoticeSentOn(Date finalRecoveryNoticeSentOn) {
		this.finalRecoveryNoticeSentOn = finalRecoveryNoticeSentOn;
	}

	@Column(name = "is_cheque_presented_in_bank")
	public Byte getIsChequePresentedInBank() {
		return this.isChequePresentedInBank;
	}

	public void setIsChequePresentedInBank(Byte isChequePresentedInBank) {
		this.isChequePresentedInBank = isChequePresentedInBank;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "cheque_presented_in_bank_on", length = 19)
	public Date getChequePresentedInBankOn() {
		return this.chequePresentedInBankOn;
	}

	public void setChequePresentedInBankOn(Date chequePresentedInBankOn) {
		this.chequePresentedInBankOn = chequePresentedInBankOn;
	}

	@Column(name = "is_cheque_returned")
	public Byte getIsChequeReturned() {
		return this.isChequeReturned;
	}

	public void setIsChequeReturned(Byte isChequeReturned) {
		this.isChequeReturned = isChequeReturned;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "cheque_returned_on", length = 19)
	public Date getChequeReturnedOn() {
		return this.chequeReturnedOn;
	}

	public void setChequeReturnedOn(Date chequeReturnedOn) {
		this.chequeReturnedOn = chequeReturnedOn;
	}

	@Column(name = "is_notice_sent_after_cheque_returned")
	public Byte getIsNoticeSentAfterChequeReturned() {
		return this.isNoticeSentAfterChequeReturned;
	}

	public void setIsNoticeSentAfterChequeReturned(Byte isNoticeSentAfterChequeReturned) {
		this.isNoticeSentAfterChequeReturned = isNoticeSentAfterChequeReturned;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "notice_sent_after_cheque_returned_on", length = 19)
	public Date getNoticeSentAfterChequeReturnedOn() {
		return this.noticeSentAfterChequeReturnedOn;
	}

	public void setNoticeSentAfterChequeReturnedOn(Date noticeSentAfterChequeReturnedOn) {
		this.noticeSentAfterChequeReturnedOn = noticeSentAfterChequeReturnedOn;
	}

	@Column(name = "is_legal_case_finalised")
	public Byte getIsLegalCaseFinalised() {
		return this.isLegalCaseFinalised;
	}

	public void setIsLegalCaseFinalised(Byte isLegalCaseFinalised) {
		this.isLegalCaseFinalised = isLegalCaseFinalised;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "legal_case_finalised_on", length = 19)
	public Date getLegalCaseFinalisedOn() {
		return this.legalCaseFinalisedOn;
	}

	public void setLegalCaseFinalisedOn(Date legalCaseFinalisedOn) {
		this.legalCaseFinalisedOn = legalCaseFinalisedOn;
	}

	@Column(name = "is_bike_returned")
	public Byte getIsBikeReturned() {
		return this.isBikeReturned;
	}

	public void setIsBikeReturned(Byte isBikeReturned) {
		this.isBikeReturned = isBikeReturned;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bike_returned_on", length = 19)
	public Date getBikeReturnedOn() {
		return this.bikeReturnedOn;
	}

	public void setBikeReturnedOn(Date bikeReturnedOn) {
		this.bikeReturnedOn = bikeReturnedOn;
	}

	@Column(name = "bike_not_sold_reason", length = 65535)
	public String getBikeNotSoldReason() {
		return this.bikeNotSoldReason;
	}

	public void setBikeNotSoldReason(String bikeNotSoldReason) {
		this.bikeNotSoldReason = bikeNotSoldReason;
	}

	@Column(name = "legal_case_not_submitted_reason", length = 65535)
	public String getLegalCaseNotSubmittedReason() {
		return this.legalCaseNotSubmittedReason;
	}

	public void setLegalCaseNotSubmittedReason(String legalCaseNotSubmittedReason) {
		this.legalCaseNotSubmittedReason = legalCaseNotSubmittedReason;
	}

	@Column(name = "new_or_renew", nullable = false)
	public String getNewOrRenew() {
		return this.newOrRenew;
	}

	public void setNewOrRenew(String newOrRenew) {
		this.newOrRenew = newOrRenew;
	}

	@Column(name = "is_in_arbitration")
	public Byte getIsInArbitration() {
		return this.isInArbitration;
	}

	public void setIsInArbitration(Byte isInArbitration) {
		this.isInArbitration = isInArbitration;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "arbitration_on", length = 19)
	public Date getArbitrationOn() {
		return this.arbitrationOn;
	}

	public void setArbitrationOn(Date arbitrationOn) {
		this.arbitrationOn = arbitrationOn;
	}

	@Column(name = "is_society_notice_sent")
	public Byte getIsSocietyNoticeSent() {
		return this.isSocietyNoticeSent;
	}

	public void setIsSocietyNoticeSent(Byte isSocietyNoticeSent) {
		this.isSocietyNoticeSent = isSocietyNoticeSent;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "society_notice_sent_on", length = 19)
	public Date getSocietyNoticeSentOn() {
		return this.societyNoticeSentOn;
	}

	public void setSocietyNoticeSentOn(Date societyNoticeSentOn) {
		this.societyNoticeSentOn = societyNoticeSentOn;
	}

	@Column(name = "is_visit_done")
	public Byte getIsVisitDone() {
		return this.isVisitDone;
	}

	public void setIsVisitDone(Byte isVisitDone) {
		this.isVisitDone = isVisitDone;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "visit_done_on", length = 19)
	public Date getVisitDoneOn() {
		return this.visitDoneOn;
	}

	public void setVisitDoneOn(Date visitDoneOn) {
		this.visitDoneOn = visitDoneOn;
	}

	@Column(name = "is_legal_notice_sent")
	public Byte getIsLegalNoticeSent() {
		return this.isLegalNoticeSent;
	}

	public void setIsLegalNoticeSent(Byte isLegalNoticeSent) {
		this.isLegalNoticeSent = isLegalNoticeSent;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "legal_notice_sent_on", length = 19)
	public Date getLegalNoticeSentOn() {
		return this.legalNoticeSentOn;
	}

	public void setLegalNoticeSentOn(Date legalNoticeSentOn) {
		this.legalNoticeSentOn = legalNoticeSentOn;
	}

	@Column(name = "is_noc_handling_charge_received")
	public Byte getIsNocHandlingChargeReceived() {
		return this.isNocHandlingChargeReceived;
	}

	public void setIsNocHandlingChargeReceived(Byte isNocHandlingChargeReceived) {
		this.isNocHandlingChargeReceived = isNocHandlingChargeReceived;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "noc_handling_charge_received_on", length = 19)
	public Date getNocHandlingChargeReceivedOn() {
		return this.nocHandlingChargeReceivedOn;
	}

	public void setNocHandlingChargeReceivedOn(Date nocHandlingChargeReceivedOn) {
		this.nocHandlingChargeReceivedOn = nocHandlingChargeReceivedOn;
	}

	@Column(name = "lock_status_changed_reason")
	public String getLockStatusChangedReason() {
		return this.lockStatusChangedReason;
	}

	public void setLockStatusChangedReason(String lockStatusChangedReason) {
		this.lockStatusChangedReason = lockStatusChangedReason;
	}

	@Column(name = "telecaller_id")
	public Integer getTelecallerId() {
		return this.telecallerId;
	}

	public void setTelecallerId(Integer telecallerId) {
		this.telecallerId = telecallerId;
	}

	@Column(name = "bank_account_limit", nullable = false)
	public int getBankAccountLimit() {
		return this.bankAccountLimit;
	}

	public void setBankAccountLimit(int bankAccountLimit) {
		this.bankAccountLimit = bankAccountLimit;
	}

	@Column(name = "related_type_id")
	public Integer getRelatedTypeId() {
		return this.relatedTypeId;
	}

	public void setRelatedTypeId(Integer relatedTypeId) {
		this.relatedTypeId = relatedTypeId;
	}

	@Column(name = "related_type")
	public String getRelatedType() {
		return this.relatedType;
	}

	public void setRelatedType(String relatedType) {
		this.relatedType = relatedType;
	}

}
