package com.service.banking.model.printingModel;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.id.IntegralDataTypeHolder;

import com.service.banking.utils.DateFormater;

public class AcountDetails {

    Integer id;
    String accountNumber;
    String nominee;
    Short nomineeAge;
    String relationWithNominee;
    Double amount;
    Date maturityDate;
    String name;
    String fatherName;
    String currentAddress;
    String permanentAddress;
    Date createdAt;
    String NomineeDOB;
    String phoneNos;
    Integer maturityPeriod;
    String interest;
    String branchName;
    Long maturityAmount;
    String maturityAmountWords;
    String depositeAmountWords;
    String accountType;


    public AcountDetails() {
    }

    public AcountDetails(Integer id, String accountNumber, String nominee, Short nomineeAge, String relationWithNominee, Double amount, String name, String fatherName, String currentAddress, String permanentAddress, Date createdAt, String nomineeDOB, String phoneNos, Integer maturityPeriod, String interest, String branchName, String accountType) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.nominee = nominee;
        this.nomineeAge = nomineeAge;
        this.relationWithNominee = relationWithNominee;
        this.amount = amount;
        this.name = name;
        this.fatherName = fatherName;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
        this.createdAt = createdAt;
        NomineeDOB = nomineeDOB;
        this.phoneNos = phoneNos;
        this.maturityPeriod = maturityPeriod;
        this.interest = interest;
        this.branchName = branchName;
        this.accountType= accountType;
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

    public String getNominee() {
        return nominee;
    }

    public void setNominee(String nominee) {
        this.nominee = nominee;
    }

    public Short getNomineeAge() {
        return nomineeAge;
    }

    public void setNomineeAge(Short nomineeAge) {
        this.nomineeAge = nomineeAge;
    }

    public String getRelationWithNominee() {
        return relationWithNominee;
    }

    public void setRelationWithNominee(String relationWithNominee) {
        this.relationWithNominee = relationWithNominee;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getNomineeDOB() {
        return NomineeDOB;
    }

    public void setNomineeDOB(String nomineeDOB) {
        NomineeDOB = nomineeDOB;
    }

    public String getPhoneNos() {
        return phoneNos;
    }

    public void setPhoneNos(String phoneNos) {
        this.phoneNos = phoneNos;
    }

    public Integer getMaturityPeriod() {
        return maturityPeriod;
    }

    public void setMaturityPeriod(Integer maturityPeriod) {
        this.maturityPeriod = maturityPeriod;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Long getMaturityAmount() {
        return maturityAmount;
    }

    public void setMaturityAmount(Long maturityAmount) {
        this.maturityAmount = maturityAmount;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getMaturityAmountWords() {
        return maturityAmountWords;
    }

    public void setMaturityAmountWords(String maturityAmountWords) {
        this.maturityAmountWords = maturityAmountWords;
    }

    public String getDepositeAmountWords() {
        return depositeAmountWords;
    }

    public void setDepositeAmountWords(String depositeAmountWords) {
        this.depositeAmountWords = depositeAmountWords;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
