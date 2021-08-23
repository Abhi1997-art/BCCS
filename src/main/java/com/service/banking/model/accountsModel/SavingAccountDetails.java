package com.service.banking.model.accountsModel;

import java.util.Date;

public class SavingAccountDetails {


    public Integer id;
    public String accountNumber;
    public Date createdAt;
    public String name;
    public Integer memberNo;
    public String currentAddress;
    public Integer agentCodeNo;
    public String agentName;
    public Integer agentNo;
    public String agentCurrentAddress;
    public String nominee;
    public Short nomineeAge;
    public String relationWithNominee;
    public String currentInterest;
    public Date lastCurrentInterestUpdatedAt;
    public String teamName;
    public String schemaName;
    public Double amount;

    private String accountType;
    private int memberId;
    private Integer schemeId;
    private Integer agentId;
    private Boolean activeStatus;
    private String modeOfOperation;
    private String minorNomineeParentName;
    private Integer teamId;
    private Integer member2;
    private Integer member3;
    private Integer member4;
    private Integer branchId;
    private Integer staffId;

    public SavingAccountDetails() {
        super();
    }


    public SavingAccountDetails(Integer id, String accountNumber, Date createdAt, String memberName, Integer memberNo,
                                String currentAddress, Integer agentCodeNo, String agentName, Integer agentNo, String agentCurrentAddress,
                                String nominee, Short nomineeAge, String relationWithNominee, String currentInterest,
                                Date lastCurrentInterestUpdatedAt, String teamName, String schemaName, Double amount) {
        super();
        this.id = id;
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
        this.name = memberName;
        this.memberNo = memberNo;
        this.currentAddress = currentAddress;
        this.agentCodeNo = agentCodeNo;
        this.agentName = agentName;
        this.agentNo = agentNo;
        this.agentCurrentAddress = agentCurrentAddress;
        this.nominee = nominee;
        this.nomineeAge = nomineeAge;
        this.relationWithNominee = relationWithNominee;
        this.currentInterest = currentInterest;
        this.lastCurrentInterestUpdatedAt = lastCurrentInterestUpdatedAt;
        this.teamName = teamName;
        this.schemaName = schemaName;
        this.amount = amount;
    }


    public SavingAccountDetails(Integer id, String accountNumber, Date createdAt, String memberName, Integer memberNo,
                                String currentAddress, Integer agentCodeNo, String agentName, Integer agentNo, String agentCurrentAddress,
                                String nominee, Short nomineeAge, String relationWithNominee, String currentInterest,
                                Date lastCurrentInterestUpdatedAt, String teamName, String schemaName, Double amount, String accountType,
                                int memberId, Integer schemeId, Integer agentId, Boolean activeStatus, String modeOfOperation,
                                String minorNomineeParentName, Integer teamId, Integer member2, Integer member3, Integer member4) {
        super();
        this.id = id;
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
        this.name = memberName;
        this.memberNo = memberNo;
        this.currentAddress = currentAddress;
        this.agentCodeNo = agentCodeNo;
        this.agentName = agentName;
        this.agentNo = agentNo;
        this.agentCurrentAddress = agentCurrentAddress;
        this.nominee = nominee;
        this.nomineeAge = nomineeAge;
        this.relationWithNominee = relationWithNominee;
        this.currentInterest = currentInterest;
        this.lastCurrentInterestUpdatedAt = lastCurrentInterestUpdatedAt;
        this.teamName = teamName;
        this.schemaName = schemaName;
        this.amount = amount;
        this.accountType = accountType;
        this.memberId = memberId;
        this.schemeId = schemeId;
        this.agentId = agentId;
        this.activeStatus = activeStatus;
        this.modeOfOperation = modeOfOperation;
        this.minorNomineeParentName = minorNomineeParentName;
        this.teamId = teamId;
        this.member2 = member2;
        this.member3 = member3;
        this.member4 = member4;
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


    public String getCurrentInterest() {
        return currentInterest;
    }


    public void setCurrentInterest(String currentInterest) {
        this.currentInterest = currentInterest;
    }


    public Date getLastCurrentInterestUpdatedAt() {
        return lastCurrentInterestUpdatedAt;
    }


    public void setLastCurrentInterestUpdatedAt(Date lastCurrentInterestUpdatedAt) {
        this.lastCurrentInterestUpdatedAt = lastCurrentInterestUpdatedAt;
    }


    public String getTeamName() {
        return teamName;
    }


    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    public String getSchemaName() {
        return schemaName;
    }


    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }


    public Double getAmount() {
        return amount;
    }


    public void setAmount(Double amount) {
        this.amount = amount;
    }


    public String getAccountType() {
        return accountType;
    }


    public void setAccountType(String accountType) {
        this.accountType = accountType;
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


    public Integer getAgentId() {
        return agentId;
    }


    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
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


    public Integer getMember2() {
        return member2;
    }


    public void setMember2(Integer member2) {
        this.member2 = member2;
    }


    public Integer getMember3() {
        return member3;
    }


    public void setMember3(Integer member3) {
        this.member3 = member3;
    }


    public Integer getMember4() {
        return member4;
    }


    public void setMember4(Integer member4) {
        this.member4 = member4;
    }


    public Integer getTeamId() {
        return teamId;
    }


    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
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
}
