package com.service.banking.model.accountsModel;

public class OtherValues {

    public String jointMember[];
    public String documentFeeded[];
    public String loanFromAccount;
    public String smAmount;
    public String otherAccount;
    public String accountCrAmount;


    public OtherValues() {
    }

    public OtherValues(String[] jointMember, String[] documentFeeded, String loanFromAccount, String smAmount, String otherAccount, String accountCrAmount) {
        this.jointMember = jointMember;
        this.documentFeeded = documentFeeded;
        this.loanFromAccount = loanFromAccount;
        this.smAmount = smAmount;
        this.otherAccount = otherAccount;
        this.accountCrAmount = accountCrAmount;
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

    public String getLoanFromAccount() {
        return loanFromAccount;
    }

    public void setLoanFromAccount(String loanFromAccount) {
        this.loanFromAccount = loanFromAccount;
    }

    public String getSmAmount() {
        return smAmount;
    }

    public void setSmAmount(String smAmount) {
        this.smAmount = smAmount;
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
}
