package com.service.banking.model.accountsModel;

import java.util.Date;

public class AccountsPendingDetails {

    private int memberId;
    private Integer schemeId;
    private String accountNumber;
    private Date createdAt;
    private Date updatedAt;
    private int sigImageId;
    private int branchId;
    private int staffId;
    private Double amount;
    private Date loanInsurranceDate;
    private int dealerId;
    private String accountType;
    private String extraInfo;
    private String SMAmount;
    public String otherAccount;
    public String accountCrAmount;
    private String repaymentMode;
    private String insuranceTenure;
    private Boolean activeStatus;
    public String loanFromAccount;
    private String newOrRenew;
    private int bankAccountLimit;
    private byte isInLegal;
    private Date legalFilingDate;
    private byte bikeSurrendered;
    private byte bikeSurrenderedOn;
    private String pandLgroup;
    private String group;
    public String jointMember[];
    public String documentFeeded[];


    public AccountsPendingDetails() {
    }

    public AccountsPendingDetails(int memberId, Integer schemeId, String accountNumber, Date createdAt, Date updatedAt, int sigImageId, int branchId, int staffId, Double amount, Date loanInsurranceDate, int dealerId, String accountType, String extraInfo, String SMAmount, String otherAccount, String accountCrAmount, String repaymentMode, String insuranceTenure, Boolean activeStatus, String loanFromAccount, String newOrRenew, int bankAccountLimit, byte isInLegal, Date legalFilingDate, byte bikeSurrendered, byte bikeSurrenderedOn, String pandLgroup, String group) {
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
        this.otherAccount = otherAccount;
        this.accountCrAmount = accountCrAmount;
        this.repaymentMode = repaymentMode;
        this.insuranceTenure = insuranceTenure;
        this.activeStatus = activeStatus;
        this.loanFromAccount = loanFromAccount;
        this.newOrRenew = newOrRenew;
        this.bankAccountLimit = bankAccountLimit;
        this.isInLegal = isInLegal;
        this.legalFilingDate = legalFilingDate;
        this.bikeSurrendered = bikeSurrendered;
        this.bikeSurrenderedOn = bikeSurrenderedOn;
        this.pandLgroup = pandLgroup;
        this.group = group;
    }


    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
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

    public int getSigImageId() {
        return sigImageId;
    }

    public void setSigImageId(int sigImageId) {
        this.sigImageId = sigImageId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
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

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
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

    public String getSMAmount() {
        return SMAmount;
    }

    public void setSMAmount(String SMAmount) {
        this.SMAmount = SMAmount;
    }

    public String getOtherAccount() {
        return otherAccount;
    }

    public void setOtherAccount(String otherAccount) {
        this.otherAccount = otherAccount;
    }

    public String getAccountCrAmount() {
        return accountCrAmount;
    }

    public void setAccountCrAmount(String accountCrAmount) {
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

    public String getLoanFromAccount() {
        return loanFromAccount;
    }

    public void setLoanFromAccount(String loanFromAccount) {
        this.loanFromAccount = loanFromAccount;
    }

    public String getNewOrRenew() {
        return newOrRenew;
    }

    public void setNewOrRenew(String newOrRenew) {
        this.newOrRenew = newOrRenew;
    }

    public int getBankAccountLimit() {
        return bankAccountLimit;
    }

    public void setBankAccountLimit(int bankAccountLimit) {
        this.bankAccountLimit = bankAccountLimit;
    }

    public byte getIsInLegal() {
        return isInLegal;
    }

    public void setIsInLegal(byte isInLegal) {
        this.isInLegal = isInLegal;
    }

    public Date getLegalFilingDate() {
        return legalFilingDate;
    }

    public void setLegalFilingDate(Date legalFilingDate) {
        this.legalFilingDate = legalFilingDate;
    }

    public byte getBikeSurrendered() {
        return bikeSurrendered;
    }

    public void setBikeSurrendered(byte bikeSurrendered) {
        this.bikeSurrendered = bikeSurrendered;
    }

    public byte getBikeSurrenderedOn() {
        return bikeSurrenderedOn;
    }

    public void setBikeSurrenderedOn(byte bikeSurrenderedOn) {
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
}
