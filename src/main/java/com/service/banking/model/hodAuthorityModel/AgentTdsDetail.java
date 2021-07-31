package com.service.banking.model.hodAuthorityModel;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.service.banking.hibernateEntity.Accounts;
import com.service.banking.hibernateEntity.Agents;
import com.service.banking.hibernateEntity.Transactions;

public class AgentTdsDetail {

	private Integer id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
	private Date createdAt;
	private BigDecimal totalCommission;
	private BigDecimal tds;
	private BigDecimal netCommission;

	private Integer agentId;
	private Integer memberId;
	private Integer codeNo;
	private String memberName;
	private Integer memberNo;
	private String currentAddress;
	private String landmark;
	private Boolean isDefaulter;
	private Integer accountId;
	private String accountNumber;
	private Integer relatedAccountMemberId;
	private String name;
	private String fatherName;
	private Integer branchId;
	private String branchName;
	private String permanentAddress;

	public AgentTdsDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AgentTdsDetail(Integer id) {
		super();
		this.id = id;
	}

	public AgentTdsDetail(Integer id, Integer agentId, Integer memberId, Integer codeNo, String memberName,
			Integer memberNo, String currentAddress, String landmark, Boolean isDefaulter, Integer accountId,
			String accountNumber, Integer relatedAccountMemberId, String relatedAccountMemberName,
			String relatedAccountFatherName, Date createdAt, BigDecimal totalCommission, BigDecimal tds,
			BigDecimal netCommission, Integer branchId, String branchName, String permanentAddress) {
		super();
		this.id = id;
		this.agentId = agentId;
		this.memberId = memberId;
		this.codeNo = codeNo;
		this.memberName = memberName;
		this.memberNo = memberNo;
		this.currentAddress = currentAddress;
		this.landmark = landmark;
		this.isDefaulter = isDefaulter;
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.relatedAccountMemberId = relatedAccountMemberId;
		this.name = relatedAccountMemberName;
		this.fatherName = relatedAccountFatherName;
		this.createdAt = createdAt;
		this.totalCommission = totalCommission;
		this.tds = tds;
		this.netCommission = netCommission;
		this.branchId = branchId;
		this.branchName = branchName;
		this.permanentAddress = permanentAddress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public BigDecimal getTotalCommission() {
		return totalCommission;
	}

	public void setTotalCommission(BigDecimal totalCommission) {
		this.totalCommission = totalCommission;
	}

	public BigDecimal getTds() {
		return tds;
	}

	public void setTds(BigDecimal tds) {
		this.tds = tds;
	}

	public BigDecimal getNetCommission() {
		return netCommission;
	}

	public void setNetCommission(BigDecimal netCommission) {
		this.netCommission = netCommission;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getCodeNo() {
		return codeNo;
	}

	public void setCodeNo(Integer codeNo) {
		this.codeNo = codeNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public Boolean getIsDefaulter() {
		return isDefaulter;
	}

	public void setIsDefaulter(Boolean isDefaulter) {
		this.isDefaulter = isDefaulter;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getRelatedAccountMemberId() {
		return relatedAccountMemberId;
	}

	public void setRelatedAccountMemberId(Integer relatedAccountMemberId) {
		this.relatedAccountMemberId = relatedAccountMemberId;
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

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

}