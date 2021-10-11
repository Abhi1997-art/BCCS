package com.service.banking.model.accountsModel;

import io.swagger.models.auth.In;

import java.util.Date;

public class AccountsPendingDetails {

    private Integer memberId;
    private Integer schemeId;
    private String accountNumber;
    private Date createdAt;
    private Date updatedAt;
    private Integer sigImageId;
    private Integer branchId;
    private Integer staffId;
    private Double amount;
    private Date loanInsurranceDate;
    private Integer dealerId;
    private String accountType;
    private String extraInfo;
    private Double SMAmount;
    public Integer otherAccountId;
    public Double accountCrAmount;
    private String repaymentMode;
    private String insuranceTenure;
    private Boolean activeStatus;
    public Integer loanFromAccountId;
    private String newOrRenew;
    private Integer bankAccountLimit;
    private Byte isInLegal;
    private Date legalFilingDate;
    private Byte bikeSurrendered;
    private Byte bikeSurrenderedOn;
    private String pandLgroup;
    private String group;
    public String jointMember[];
    public String documentFeeded[];

    private String policyNumber;
    private String ownerChequeNo;
    private String stamp;
    private String gaurantorStamp;
    private String keyNo;
    private String vehicleNo;
    private String recoveryStatus;
    private String legalCaseStatus;
    private String chassisNo;
    private String engineNo;
    private String loanChequePaidDetail;
    private String gaurantoeChaqueNo;
    private String fiStatus;
    private String phoneFollowUp;
    private String welcomeCall;
    private String nocStatus;
    private String notice;
    private String visitCharge;
    private String remark;
    private String bikeSurrender;
    private String legalCaseSubmitted;
    private String invastigationJanch;
    private String prasangGhyan;
    private String summons;
    private String bailableWarrantJamantiWarrant;
    private String arrestWarrant;
    private String allegationAarop;
    private String evidenceGawah;
    private String debateBahas;
    private String order;
    private String bikeLocation;
    private String loanSecurity;
    private String accountPendency;
    private String model;
    private String legalBikeStatus;
    private String arbitrationStage;
    private String arbitrationVisitStatus;
    private String loanRemark;
    private String taxReceipt;
    private String accountDontGiveToRo;
    private String rrTrackingNumber;



    public AccountsPendingDetails() {
    }

    public AccountsPendingDetails(Integer memberId, Integer schemeId, String accountNumber, Date createdAt, Date updatedAt, Integer sigImageId, Integer branchId, Integer staffId, Double amount, Date loanInsurranceDate, Integer dealerId, String accountType, String extraInfo, Double SMAmount, Integer otherAccount, Double accountCrAmount, String repaymentMode, String insuranceTenure, Boolean activeStatus, Integer loanFromAccount, String newOrRenew, Integer bankAccountLimit, Byte isInLegal, Date legalFilingDate, Byte bikeSurrendered, Byte bikeSurrenderedOn, String pandLgroup, String group) {
        this.memberId = memberId;
        this.schemeId = schemeId;
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.sigImageId = sigImageId;
        this.branchId = branchId;
        this.staffId = staffId;
        this.amount = amount;
        this.loanInsurranceDate = loanInsurranceDate;
        this.dealerId = dealerId;
        this.accountType = accountType;
        this.extraInfo = extraInfo;
        this.SMAmount = SMAmount;
        this.otherAccountId = otherAccount;
        this.accountCrAmount = accountCrAmount;
        this.repaymentMode = repaymentMode;
        this.insuranceTenure = insuranceTenure;
        this.activeStatus = activeStatus;
        this.loanFromAccountId = loanFromAccount;
        this.newOrRenew = newOrRenew;
        this.bankAccountLimit = bankAccountLimit;
        this.isInLegal = isInLegal;
        this.legalFilingDate = legalFilingDate;
        this.bikeSurrendered = bikeSurrendered;
        this.bikeSurrenderedOn = bikeSurrenderedOn;
        this.pandLgroup = pandLgroup;
        this.group = group;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Integer schemeId) {
        this.schemeId = schemeId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getSigImageId() {
        return sigImageId;
    }

    public void setSigImageId(Integer sigImageId) {
        this.sigImageId = sigImageId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getLoanInsurranceDate() {
        return loanInsurranceDate;
    }

    public void setLoanInsurranceDate(Date loanInsurranceDate) {
        this.loanInsurranceDate = loanInsurranceDate;
    }

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Double getSMAmount() {
        return SMAmount;
    }

    public void setSMAmount(Double SMAmount) {
        this.SMAmount = SMAmount;
    }

    public Integer getOtherAccountId() {
        return otherAccountId;
    }

    public void setOtherAccountId(Integer otherAccountId) {
        this.otherAccountId = otherAccountId;
    }

    public Double getAccountCrAmount() {
        return accountCrAmount;
    }

    public void setAccountCrAmount(Double accountCrAmount) {
        this.accountCrAmount = accountCrAmount;
    }

    public String getRepaymentMode() {
        return repaymentMode;
    }

    public void setRepaymentMode(String repaymentMode) {
        this.repaymentMode = repaymentMode;
    }

    public String getInsuranceTenure() {
        return insuranceTenure;
    }

    public void setInsuranceTenure(String insuranceTenure) {
        this.insuranceTenure = insuranceTenure;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Integer getLoanFromAccountId() {
        return loanFromAccountId;
    }

    public void setLoanFromAccountId(Integer loanFromAccountId) {
        this.loanFromAccountId = loanFromAccountId;
    }

    public String getNewOrRenew() {
        return newOrRenew;
    }

    public void setNewOrRenew(String newOrRenew) {
        this.newOrRenew = newOrRenew;
    }

    public Integer getBankAccountLimit() {
        return bankAccountLimit;
    }

    public void setBankAccountLimit(Integer bankAccountLimit) {
        this.bankAccountLimit = bankAccountLimit;
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

    public Byte getBikeSurrendered() {
        return bikeSurrendered;
    }

    public void setBikeSurrendered(Byte bikeSurrendered) {
        this.bikeSurrendered = bikeSurrendered;
    }

    public Byte getBikeSurrenderedOn() {
        return bikeSurrenderedOn;
    }

    public void setBikeSurrenderedOn(Byte bikeSurrenderedOn) {
        this.bikeSurrenderedOn = bikeSurrenderedOn;
    }

    public String getPandLgroup() {
        return pandLgroup;
    }

    public void setPandLgroup(String pandLgroup) {
        this.pandLgroup = pandLgroup;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String[] getJointMember() {
        return jointMember;
    }

    public void setJointMember(String[] jointMember) {
        this.jointMember = jointMember;
    }

    public String[] getDocumentFeeded() {
        return documentFeeded;
    }

    public void setDocumentFeeded(String[] documentFeeded) {
        this.documentFeeded = documentFeeded;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getOwnerChequeNo() {
        return ownerChequeNo;
    }

    public void setOwnerChequeNo(String ownerChequeNo) {
        this.ownerChequeNo = ownerChequeNo;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    public String getGaurantorStamp() {
        return gaurantorStamp;
    }

    public void setGaurantorStamp(String gaurantorStamp) {
        this.gaurantorStamp = gaurantorStamp;
    }

    public String getKeyNo() {
        return keyNo;
    }

    public void setKeyNo(String keyNo) {
        this.keyNo = keyNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getRecoveryStatus() {
        return recoveryStatus;
    }

    public void setRecoveryStatus(String recoveryStatus) {
        this.recoveryStatus = recoveryStatus;
    }

    public String getLegalCaseStatus() {
        return legalCaseStatus;
    }

    public void setLegalCaseStatus(String legalCaseStatus) {
        this.legalCaseStatus = legalCaseStatus;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getLoanChequePaidDetail() {
        return loanChequePaidDetail;
    }

    public void setLoanChequePaidDetail(String loanChequePaidDetail) {
        this.loanChequePaidDetail = loanChequePaidDetail;
    }

    public String getGaurantoeChaqueNo() {
        return gaurantoeChaqueNo;
    }

    public void setGaurantoeChaqueNo(String gaurantoeChaqueNo) {
        this.gaurantoeChaqueNo = gaurantoeChaqueNo;
    }

    public String getFiStatus() {
        return fiStatus;
    }

    public void setFiStatus(String fiStatus) {
        this.fiStatus = fiStatus;
    }

    public String getPhoneFollowUp() {
        return phoneFollowUp;
    }

    public void setPhoneFollowUp(String phoneFollowUp) {
        this.phoneFollowUp = phoneFollowUp;
    }

    public String getWelcomeCall() {
        return welcomeCall;
    }

    public void setWelcomeCall(String welcomeCall) {
        this.welcomeCall = welcomeCall;
    }

    public String getNocStatus() {
        return nocStatus;
    }

    public void setNocStatus(String nocStatus) {
        this.nocStatus = nocStatus;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getVisitCharge() {
        return visitCharge;
    }

    public void setVisitCharge(String visitCharge) {
        this.visitCharge = visitCharge;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBikeSurrender() {
        return bikeSurrender;
    }

    public void setBikeSurrender(String bikeSurrender) {
        this.bikeSurrender = bikeSurrender;
    }

    public String getLegalCaseSubmitted() {
        return legalCaseSubmitted;
    }

    public void setLegalCaseSubmitted(String legalCaseSubmitted) {
        this.legalCaseSubmitted = legalCaseSubmitted;
    }

    public String getInvastigationJanch() {
        return invastigationJanch;
    }

    public void setInvastigationJanch(String invastigationJanch) {
        this.invastigationJanch = invastigationJanch;
    }

    public String getPrasangGhyan() {
        return prasangGhyan;
    }

    public void setPrasangGhyan(String prasangGhyan) {
        this.prasangGhyan = prasangGhyan;
    }

    public String getSummons() {
        return summons;
    }

    public void setSummons(String summons) {
        this.summons = summons;
    }

    public String getBailableWarrantJamantiWarrant() {
        return bailableWarrantJamantiWarrant;
    }

    public void setBailableWarrantJamantiWarrant(String bailableWarrantJamantiWarrant) {
        this.bailableWarrantJamantiWarrant = bailableWarrantJamantiWarrant;
    }

    public String getArrestWarrant() {
        return arrestWarrant;
    }

    public void setArrestWarrant(String arrestWarrant) {
        this.arrestWarrant = arrestWarrant;
    }

    public String getAllegationAarop() {
        return allegationAarop;
    }

    public void setAllegationAarop(String allegationAarop) {
        this.allegationAarop = allegationAarop;
    }

    public String getEvidenceGawah() {
        return evidenceGawah;
    }

    public void setEvidenceGawah(String evidenceGawah) {
        this.evidenceGawah = evidenceGawah;
    }

    public String getDebateBahas() {
        return debateBahas;
    }

    public void setDebateBahas(String debateBahas) {
        this.debateBahas = debateBahas;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getBikeLocation() {
        return bikeLocation;
    }

    public void setBikeLocation(String bikeLocation) {
        this.bikeLocation = bikeLocation;
    }

    public String getLoanSecurity() {
        return loanSecurity;
    }

    public void setLoanSecurity(String loanSecurity) {
        this.loanSecurity = loanSecurity;
    }

    public String getAccountPendency() {
        return accountPendency;
    }

    public void setAccountPendency(String accountPendency) {
        this.accountPendency = accountPendency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLegalBikeStatus() {
        return legalBikeStatus;
    }

    public void setLegalBikeStatus(String legalBikeStatus) {
        this.legalBikeStatus = legalBikeStatus;
    }

    public String getArbitrationStage() {
        return arbitrationStage;
    }

    public void setArbitrationStage(String arbitrationStage) {
        this.arbitrationStage = arbitrationStage;
    }

    public String getArbitrationVisitStatus() {
        return arbitrationVisitStatus;
    }

    public void setArbitrationVisitStatus(String arbitrationVisitStatus) {
        this.arbitrationVisitStatus = arbitrationVisitStatus;
    }

    public String getLoanRemark() {
        return loanRemark;
    }

    public void setLoanRemark(String loanRemark) {
        this.loanRemark = loanRemark;
    }

    public String getTaxReceipt() {
        return taxReceipt;
    }

    public void setTaxReceipt(String taxReceipt) {
        this.taxReceipt = taxReceipt;
    }

    public String getAccountDontGiveToRo() {
        return accountDontGiveToRo;
    }

    public void setAccountDontGiveToRo(String accountDontGiveToRo) {
        this.accountDontGiveToRo = accountDontGiveToRo;
    }

    public String getRrTrackingNumber() {
        return rrTrackingNumber;
    }

    public void setRrTrackingNumber(String rrTrackingNumber) {
        this.rrTrackingNumber = rrTrackingNumber;
    }
}
