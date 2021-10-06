package com.service.banking.model.accountsModel;

import java.math.BigDecimal;
import java.util.Date;

public class FixedAccountDetails {
    public Integer id;
    public String accountNumber;
    public Date createdAt;
    public String name;
    public Integer memberNo;
    public String currentAddress;
    public String schemaName;
    public BigDecimal currentBalanceCr;
    public Double amount;
    public Integer agentCodeNo;
    public String agentName;
    public Integer agentNo;
    public String agentCurrentAddress;
    public Integer collecterCodeNo;
    public String collecterName;
    public Integer collectorNo;
    public String collecterCurrentAddress;
    public String collecterLandmark;
    public Boolean collectorDeafulter;
    public Integer intrestToAccountId;
    public Integer maturityToAccountId;
    public String nominee;
    public Short nomineeAge;
    public String relationWithNominee;
    public String newOrRenew;
    public String teamName;

    public Integer memberId;
    private Integer schemaId;
    private Integer agentId;
    private Integer collectorId;
    private Integer teamId;
    private Boolean activeStatus;
    private String modeOfOperation;
    private String minorNomineeParentName;
    private String accountType;
    private String minorNomineeDob;
    private Integer branchId;
    private String narration;
    private Integer staffId;
    private Integer moId;
    private String moName;
    private Integer debitAccountId;


    public FixedAccountDetails() {
        super();
    }

    public FixedAccountDetails(Integer id, String accountNumber, Date createdAt, String name, Integer memberNo,
                               String currentAddress, String schemaName, Double amount, Integer agentCodeNo,
                               String agentName, Integer agentNo, String agentCurrentAddress, Integer collecterCodeNo,
                               String collecterName, Integer collectorNo, String collecterCurrentAddress, String collecterLandmark,
                               Boolean collectorDeafulter, Integer intrestToAccountId, Integer maturityToAccountId, String nominee,
                               Short nomineeAge, String relationWithNominee, String newOrRenew, String teamName) {
        super();
        this.id = id;
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
        this.name = name;
        this.memberNo = memberNo;
        this.currentAddress = currentAddress;
        this.schemaName = schemaName;
        this.amount = amount;
        this.agentCodeNo = agentCodeNo;
        this.agentName = agentName;
        this.agentNo = agentNo;
        this.agentCurrentAddress = agentCurrentAddress;
        this.collecterCodeNo = collecterCodeNo;
        this.collecterName = collecterName;
        this.collectorNo = collectorNo;
        this.collecterCurrentAddress = collecterCurrentAddress;
        this.collecterLandmark = collecterLandmark;
        this.collectorDeafulter = collectorDeafulter;
        this.intrestToAccountId = intrestToAccountId;
        this.maturityToAccountId = maturityToAccountId;
        this.nominee = nominee;
        this.nomineeAge = nomineeAge;
        this.relationWithNominee = relationWithNominee;
        this.newOrRenew = newOrRenew;
        this.teamName = teamName;
    }


    public FixedAccountDetails(Integer id, String accountNumber, Date createdAt, String name, Integer memberNo,
                               String currentAddress, String schemaName, Double amount, Integer agentCodeNo,
                               String agentName, Integer agentNo, String agentCurrentAddress, Integer collecterCodeNo,
                               String collecterName, Integer collectorNo, String collecterCurrentAddress, String collecterLandmark,
                               Boolean collectorDeafulter, Integer intrestToAccountId, Integer maturityToAccountId, String nominee,
                               Short nomineeAge, String relationWithNominee, String newOrRenew, String teamName, Integer memberId,
                               Integer schemaId, Integer agentId, Integer collectorId, Integer teamId, Boolean activeStatus,
                               String modeOfOperation, String minorNomineeParentName, String accountType, String minorNomineeDob, Integer moId, String moName) {
        super();
        this.id = id;
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
        this.name = name;
        this.memberNo = memberNo;
        this.currentAddress = currentAddress;
        this.schemaName = schemaName;
        this.amount = amount;
        this.agentCodeNo = agentCodeNo;
        this.agentName = agentName;
        this.agentNo = agentNo;
        this.agentCurrentAddress = agentCurrentAddress;
        this.collecterCodeNo = collecterCodeNo;
        this.collecterName = collecterName;
        this.collectorNo = collectorNo;
        this.collecterCurrentAddress = collecterCurrentAddress;
        this.collecterLandmark = collecterLandmark;
        this.collectorDeafulter = collectorDeafulter;
        this.intrestToAccountId = intrestToAccountId;
        this.maturityToAccountId = maturityToAccountId;
        this.nominee = nominee;
        this.nomineeAge = nomineeAge;
        this.relationWithNominee = relationWithNominee;
        this.newOrRenew = newOrRenew;
        this.teamName = teamName;
        this.memberId = memberId;
        this.schemaId = schemaId;
        this.agentId = agentId;
        this.collectorId = collectorId;
        this.teamId = teamId;
        this.activeStatus = activeStatus;
        this.modeOfOperation = modeOfOperation;
        this.minorNomineeParentName = minorNomineeParentName;
        this.accountType = accountType;
        this.minorNomineeDob = minorNomineeDob;
        this.moId= moId;
        this.moName=moName;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public BigDecimal getCurrentBalanceCr() {
        return currentBalanceCr;
    }

    public void setCurrentBalanceCr(BigDecimal currentBalanceCr) {
        this.currentBalanceCr = currentBalanceCr;
    }

    public Integer getAgentCodeNo() {
        return agentCodeNo;
    }

    public void setAgentCodeNo(Integer agentCodeNo) {
        this.agentCodeNo = agentCodeNo;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Integer getAgentNo() {
        return agentNo;
    }

    public void setAgentNo(Integer agentNo) {
        this.agentNo = agentNo;
    }

    public String getAgentCurrentAddress() {
        return agentCurrentAddress;
    }

    public void setAgentCurrentAddress(String agentCurrentAddress) {
        this.agentCurrentAddress = agentCurrentAddress;
    }

    public Integer getCollecterCodeNo() {
        return collecterCodeNo;
    }

    public void setCollecterCodeNo(Integer collecterCodeNo) {
        this.collecterCodeNo = collecterCodeNo;
    }

    public String getCollecterName() {
        return collecterName;
    }

    public void setCollecterName(String collecterName) {
        this.collecterName = collecterName;
    }

    public Integer getCollectorNo() {
        return collectorNo;
    }

    public void setCollectorNo(Integer collectorNo) {
        this.collectorNo = collectorNo;
    }

    public String getCollecterCurrentAddress() {
        return collecterCurrentAddress;
    }

    public void setCollecterCurrentAddress(String collecterCurrentAddress) {
        this.collecterCurrentAddress = collecterCurrentAddress;
    }

    public String getCollecterLandmark() {
        return collecterLandmark;
    }

    public void setCollecterLandmark(String collecterLandmark) {
        this.collecterLandmark = collecterLandmark;
    }

    public Boolean getCollectorDeafulter() {
        return collectorDeafulter;
    }

    public void setCollectorDeafulter(Boolean collectorDeafulter) {
        this.collectorDeafulter = collectorDeafulter;
    }

    public Integer getIntrestToAccountId() {
        return intrestToAccountId;
    }

    public void setIntrestToAccountId(Integer intrestToAccountId) {
        this.intrestToAccountId = intrestToAccountId;
    }

    public Integer getMaturityToAccountId() {
        return maturityToAccountId;
    }

    public void setMaturityToAccountId(Integer maturityToAccountId) {
        this.maturityToAccountId = maturityToAccountId;
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

    public String getNewOrRenew() {
        return newOrRenew;
    }

    public void setNewOrRenew(String newOrRenew) {
        this.newOrRenew = newOrRenew;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(Integer schemaId) {
        this.schemaId = schemaId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(Integer collectorId) {
        this.collectorId = collectorId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getModeOfOperation() {
        return modeOfOperation;
    }

    public void setModeOfOperation(String modeOfOperation) {
        this.modeOfOperation = modeOfOperation;
    }

    public String getMinorNomineeParentName() {
        return minorNomineeParentName;
    }

    public void setMinorNomineeParentName(String minorNomineeParentName) {
        this.minorNomineeParentName = minorNomineeParentName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getMinorNomineeDob() {
        return minorNomineeDob;
    }

    public void setMinorNomineeDob(String minorNomineeDob) {
        this.minorNomineeDob = minorNomineeDob;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getMoId() {
        return moId;
    }

    public void setMoId(Integer moId) {
        this.moId = moId;
    }

    public String getMoName() {
        return moName;
    }

    public void setMoName(String moName) {
        this.moName = moName;
    }

    public Integer getDebitAccountId() {
        return debitAccountId;
    }

    public void setDebitAccountId(Integer debitAccountId) {
        this.debitAccountId = debitAccountId;
    }
}