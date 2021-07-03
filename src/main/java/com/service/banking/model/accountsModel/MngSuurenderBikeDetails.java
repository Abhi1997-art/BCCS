package com.service.banking.model.accountsModel;

import java.util.Date;

public class MngSuurenderBikeDetails {
	
	private Integer id;
	private Integer memberId;
	private String accountNumber;
	private Byte bikeSurrendered;
	private Date bikeSurrenderedOn;
	private String bikeSurrenderedBy;
	private Byte isGivenForLegalProcess;
	private Date legalProcessGivenDate;
	private Byte isInLegal;
	private Date legalFilingDate;
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
	private Byte isInArbitration;
	private Date arbitrationOn;
	private Byte isSocietyNoticeSent;
	private Date societyNoticeSentOn;
	private Byte isLegalNoticeSent;
	private Date legalNoticeSentOn;
	private Byte isVisitDone;
	private Date visitDoneOn;
	private Byte isNocHandlingChargeReceived;
	private Date nocHandlingChargeReceivedOn;
	
	
	
	public MngSuurenderBikeDetails() {
		super();
	}
	
	public MngSuurenderBikeDetails(Integer id, String accountNumber, Byte bikeSurrendered, Date bikeSurrenderedOn) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.bikeSurrendered = bikeSurrendered;
		this.bikeSurrenderedOn = bikeSurrenderedOn;
	}

	public MngSuurenderBikeDetails(Integer id, String accountNumber, Byte bikeSurrendered, Date bikeSurrenderedOn, 
			String bikeSurrenderedBy, Byte isGivenForLegalProcess, Date legalProcessGivenDate, Byte isInLegal, Date legalFilingDate, Byte isGodownchargeDebited, Date godownchargeDebitedOn, 
			Byte isLegalNoticeSentForBikeAuction, Date legalNoticeSentForBikeAuctionOn, Byte isBikeAuctioned, Date bikeAuctionedOn, Byte isFinalRecoveryNoticeSent, Date finalRecoveryNoticeSentOn, 
			Byte isChequePresentedInBank, Date chequePresentedInBankOn, Byte isChequeReturned, Date chequeReturnedOn, Byte isNoticeSentAfterChequeReturned, Date noticeSentAfterChequeReturnedOn, 
			Byte isLegalCaseFinalised, Date legalCaseFinalisedOn, Byte isBikeReturned, Date bikeReturnedOn, String bikeNotSoldReason, String legalCaseNotSubmittedReason, Byte isInArbitration, 
			Date arbitrationOn, Byte isSocietyNoticeSent, Date societyNoticeSentOn, Byte isLegalNoticeSent, Date legalNoticeSentOn, Byte isVisitDone, Date visitDoneOn, Byte isNocHandlingChargeReceived, 
			Date nocHandlingChargeReceivedOn) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.bikeSurrendered = bikeSurrendered;
		this.bikeSurrenderedOn = bikeSurrenderedOn;
		this.bikeSurrenderedBy = bikeSurrenderedBy;
		this.isGivenForLegalProcess = isGivenForLegalProcess;
		this.legalProcessGivenDate = legalProcessGivenDate;
		this.isInLegal = isInLegal;
		this.legalFilingDate = legalFilingDate;
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
		this.isInArbitration = isInArbitration;
		this.arbitrationOn = arbitrationOn;
		this.isSocietyNoticeSent = isSocietyNoticeSent;
		this.societyNoticeSentOn = societyNoticeSentOn;
		this.isLegalNoticeSent = isLegalNoticeSent;
		this.legalNoticeSentOn = legalNoticeSentOn;
		this.isVisitDone = isVisitDone;
		this.visitDoneOn = visitDoneOn;
		this.isNocHandlingChargeReceived = isNocHandlingChargeReceived;
		this.nocHandlingChargeReceivedOn = nocHandlingChargeReceivedOn;
	}
	
	
//	{
//	("a.id, a.accountNumber, a.bikeSurrendered, a.bikeSurrenderedOn, "
//			+ "a.bikeSurrenderedBy, a.isGivenForLegalProcess, a.legalProcessGivenDate, a.isInLegal, a.legalFilingDate, a.isGodownchargeDebited a.godownchargeDebitedOn, "
//			+ "a.isLegalNoticeSentForBikeAuction, a.legalNoticeSentForBikeAuctionOn, a.isBikeAuctioned, a.bikeAuctionedOn, a.isFinalRecoveryNoticeSent, a.finalRecoveryNoticeSentOn, "
//			+ "a.isChequePresentedInBank, a.chequePresentedInBankOn, a.isChequeReturned, a.chequeReturnedOn, a.isNoticeSentAfterChequeReturned, a.noticeSentAfterChequeReturnedOn, "
//			+ "a.isLegalCaseFinalised, a.legalCaseFinalisedOn, a.isBikeReturned, a.bikeReturnedOn, a.bikeNotSoldReason, a.legalCaseNotSubmittedReason, a.isInArbitration, "
//			+ "a.arbitrationOn, a.isSocietyNoticeSent, a.societyNoticeSentOn, a.isLegalNoticeSent, a.legalNoticeSentOn, a.isVisitDone, a.visitDoneOn, a.isNocHandlingChargeReceived, "
//			+ "a.nocHandlingChargeReceivedOn)}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Byte getBikeSurrendered() {
		return bikeSurrendered;
	}

	public void setBikeSurrendered(Byte bikeSurrendered) {
		this.bikeSurrendered = bikeSurrendered;
	}

	public Date getBikeSurrenderedOn() {
		return bikeSurrenderedOn;
	}

	public void setBikeSurrenderedOn(Date bikeSurrenderedOn) {
		this.bikeSurrenderedOn = bikeSurrenderedOn;
	}

	public String getBikeSurrenderedBy() {
		return bikeSurrenderedBy;
	}

	public void setBikeSurrenderedBy(String bikeSurrenderedBy) {
		this.bikeSurrenderedBy = bikeSurrenderedBy;
	}

	public Byte getIsGivenForLegalProcess() {
		return isGivenForLegalProcess;
	}

	public void setIsGivenForLegalProcess(Byte isGivenForLegalProcess) {
		this.isGivenForLegalProcess = isGivenForLegalProcess;
	}

	public Date getLegalProcessGivenDate() {
		return legalProcessGivenDate;
	}

	public void setLegalProcessGivenDate(Date legalProcessGivenDate) {
		this.legalProcessGivenDate = legalProcessGivenDate;
	}

	public Byte getIsInLegal() {
		return isInLegal;
	}

	public void setIsInLegal(Byte isInLegal) {
		this.isInLegal = isInLegal;
	}

	public Date getLegalFilingDate() {
		return legalFilingDate;
	}

	public void setLegalFilingDate(Date legalFilingDate) {
		this.legalFilingDate = legalFilingDate;
	}

	public Byte getIsGodownchargeDebited() {
		return isGodownchargeDebited;
	}

	public void setIsGodownchargeDebited(Byte isGodownchargeDebited) {
		this.isGodownchargeDebited = isGodownchargeDebited;
	}

	public Date getGodownchargeDebitedOn() {
		return godownchargeDebitedOn;
	}

	public void setGodownchargeDebitedOn(Date godownchargeDebitedOn) {
		this.godownchargeDebitedOn = godownchargeDebitedOn;
	}

	public Byte getIsLegalNoticeSentForBikeAuction() {
		return isLegalNoticeSentForBikeAuction;
	}

	public void setIsLegalNoticeSentForBikeAuction(Byte isLegalNoticeSentForBikeAuction) {
		this.isLegalNoticeSentForBikeAuction = isLegalNoticeSentForBikeAuction;
	}

	public Date getLegalNoticeSentForBikeAuctionOn() {
		return legalNoticeSentForBikeAuctionOn;
	}

	public void setLegalNoticeSentForBikeAuctionOn(Date legalNoticeSentForBikeAuctionOn) {
		this.legalNoticeSentForBikeAuctionOn = legalNoticeSentForBikeAuctionOn;
	}

	public Byte getIsBikeAuctioned() {
		return isBikeAuctioned;
	}

	public void setIsBikeAuctioned(Byte isBikeAuctioned) {
		this.isBikeAuctioned = isBikeAuctioned;
	}

	public Date getBikeAuctionedOn() {
		return bikeAuctionedOn;
	}

	public void setBikeAuctionedOn(Date bikeAuctionedOn) {
		this.bikeAuctionedOn = bikeAuctionedOn;
	}

	public Byte getIsFinalRecoveryNoticeSent() {
		return isFinalRecoveryNoticeSent;
	}

	public void setIsFinalRecoveryNoticeSent(Byte isFinalRecoveryNoticeSent) {
		this.isFinalRecoveryNoticeSent = isFinalRecoveryNoticeSent;
	}

	public Date getFinalRecoveryNoticeSentOn() {
		return finalRecoveryNoticeSentOn;
	}

	public void setFinalRecoveryNoticeSentOn(Date finalRecoveryNoticeSentOn) {
		this.finalRecoveryNoticeSentOn = finalRecoveryNoticeSentOn;
	}

	public Byte getIsChequePresentedInBank() {
		return isChequePresentedInBank;
	}

	public void setIsChequePresentedInBank(Byte isChequePresentedInBank) {
		this.isChequePresentedInBank = isChequePresentedInBank;
	}

	public Date getChequePresentedInBankOn() {
		return chequePresentedInBankOn;
	}

	public void setChequePresentedInBankOn(Date chequePresentedInBankOn) {
		this.chequePresentedInBankOn = chequePresentedInBankOn;
	}

	public Byte getIsChequeReturned() {
		return isChequeReturned;
	}

	public void setIsChequeReturned(Byte isChequeReturned) {
		this.isChequeReturned = isChequeReturned;
	}

	public Date getChequeReturnedOn() {
		return chequeReturnedOn;
	}

	public void setChequeReturnedOn(Date chequeReturnedOn) {
		this.chequeReturnedOn = chequeReturnedOn;
	}

	public Byte getIsNoticeSentAfterChequeReturned() {
		return isNoticeSentAfterChequeReturned;
	}

	public void setIsNoticeSentAfterChequeReturned(Byte isNoticeSentAfterChequeReturned) {
		this.isNoticeSentAfterChequeReturned = isNoticeSentAfterChequeReturned;
	}

	public Date getNoticeSentAfterChequeReturnedOn() {
		return noticeSentAfterChequeReturnedOn;
	}

	public void setNoticeSentAfterChequeReturnedOn(Date noticeSentAfterChequeReturnedOn) {
		this.noticeSentAfterChequeReturnedOn = noticeSentAfterChequeReturnedOn;
	}

	public Byte getIsLegalCaseFinalised() {
		return isLegalCaseFinalised;
	}

	public void setIsLegalCaseFinalised(Byte isLegalCaseFinalised) {
		this.isLegalCaseFinalised = isLegalCaseFinalised;
	}

	public Date getLegalCaseFinalisedOn() {
		return legalCaseFinalisedOn;
	}

	public void setLegalCaseFinalisedOn(Date legalCaseFinalisedOn) {
		this.legalCaseFinalisedOn = legalCaseFinalisedOn;
	}

	public Byte getIsBikeReturned() {
		return isBikeReturned;
	}

	public void setIsBikeReturned(Byte isBikeReturned) {
		this.isBikeReturned = isBikeReturned;
	}

	public Date getBikeReturnedOn() {
		return bikeReturnedOn;
	}

	public void setBikeReturnedOn(Date bikeReturnedOn) {
		this.bikeReturnedOn = bikeReturnedOn;
	}

	public String getBikeNotSoldReason() {
		return bikeNotSoldReason;
	}

	public void setBikeNotSoldReason(String bikeNotSoldReason) {
		this.bikeNotSoldReason = bikeNotSoldReason;
	}

	public String getLegalCaseNotSubmittedReason() {
		return legalCaseNotSubmittedReason;
	}

	public void setLegalCaseNotSubmittedReason(String legalCaseNotSubmittedReason) {
		this.legalCaseNotSubmittedReason = legalCaseNotSubmittedReason;
	}

	public Byte getIsInArbitration() {
		return isInArbitration;
	}

	public void setIsInArbitration(Byte isInArbitration) {
		this.isInArbitration = isInArbitration;
	}

	public Date getArbitrationOn() {
		return arbitrationOn;
	}

	public void setArbitrationOn(Date arbitrationOn) {
		this.arbitrationOn = arbitrationOn;
	}

	public Byte getIsSocietyNoticeSent() {
		return isSocietyNoticeSent;
	}

	public void setIsSocietyNoticeSent(Byte isSocietyNoticeSent) {
		this.isSocietyNoticeSent = isSocietyNoticeSent;
	}

	public Date getSocietyNoticeSentOn() {
		return societyNoticeSentOn;
	}

	public void setSocietyNoticeSentOn(Date societyNoticeSentOn) {
		this.societyNoticeSentOn = societyNoticeSentOn;
	}

	public Byte getIsLegalNoticeSent() {
		return isLegalNoticeSent;
	}

	public void setIsLegalNoticeSent(Byte isLegalNoticeSent) {
		this.isLegalNoticeSent = isLegalNoticeSent;
	}

	public Date getLegalNoticeSentOn() {
		return legalNoticeSentOn;
	}

	public void setLegalNoticeSentOn(Date legalNoticeSentOn) {
		this.legalNoticeSentOn = legalNoticeSentOn;
	}

	public Byte getIsVisitDone() {
		return isVisitDone;
	}

	public void setIsVisitDone(Byte isVisitDone) {
		this.isVisitDone = isVisitDone;
	}

	public Date getVisitDoneOn() {
		return visitDoneOn;
	}

	public void setVisitDoneOn(Date visitDoneOn) {
		this.visitDoneOn = visitDoneOn;
	}

	public Byte getIsNocHandlingChargeReceived() {
		return isNocHandlingChargeReceived;
	}

	public void setIsNocHandlingChargeReceived(Byte isNocHandlingChargeReceived) {
		this.isNocHandlingChargeReceived = isNocHandlingChargeReceived;
	}

	public Date getNocHandlingChargeReceivedOn() {
		return nocHandlingChargeReceivedOn;
	}

	public void setNocHandlingChargeReceivedOn(Date nocHandlingChargeReceivedOn) {
		this.nocHandlingChargeReceivedOn = nocHandlingChargeReceivedOn;
	}
	
	
	
}


