package com.service.banking.model.hodAuthorityModel;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransactionRowDetails {
	
	private Integer id;
	private Integer transactionId;
	private Integer accountId;
	private String accountNumber;
	private Integer memberId;
	private String memberName;
	private String fatherName; 
	private Integer scemeId;
	private String schemeName;
	private Integer balanceId;
	private String balanceName;
	private BigDecimal debit;
	private BigDecimal credit;
	private String side; 
	private Integer accountsInSide;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
	private Date createdAt;
	private Long voucherNo;
	private String narration;
	private Integer transactionTypeId; 
	private String transactionTypeName;
	private Integer branchId;
	private String branchName;
	private Integer referenceAccountId;
	private String referenceAccountNumber; 
	private Integer referenceMemberId;
	private String referenceMemberName;
	private String referenceFatherName;
	
	

	
	public TransactionRowDetails() {
		super();
	}
	
	public TransactionRowDetails(Integer transactionId, Integer accountId, String accountNumber, Integer memberId, String memberName, String fatherName, 
			Integer scemeId, String schemeName, Integer balanceId, String balanceName, BigDecimal debit, BigDecimal credit, String side, 
			Integer accountsInSide, Date createdAt, Long voucherNo, String narration, Integer transactionTypeId, 
			String transactionTypeName, Integer branchId, String branchName, Integer referenceAccountId, String referenceAccountNumber, 
			Integer referenceMemberId, String referenceMemberName, String referenceFatherName) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.memberId = memberId;
		this.memberName = memberName;
		this.fatherName = fatherName;
		this.scemeId = scemeId;
		this.schemeName = schemeName;
		this.balanceId = balanceId;
		this.balanceName = balanceName;
		this.debit = debit;
		this.credit = credit;
		this.side = side;
		this.accountsInSide = accountsInSide;
		this.createdAt = createdAt;
		this.voucherNo = voucherNo;
		this.narration = narration;
		this.transactionTypeId = transactionTypeId;
		this.transactionTypeName = transactionTypeName;
		this.branchId = branchId;
		this.branchName = branchName;
		this.referenceAccountId = referenceAccountId;
		this.referenceAccountNumber = referenceAccountNumber;
		this.referenceMemberId = referenceMemberId;
		this.referenceMemberName = referenceMemberName;
		this.referenceFatherName = referenceFatherName;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
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

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Integer getScemeId() {
		return scemeId;
	}

	public void setScemeId(Integer scemeId) {
		this.scemeId = scemeId;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public Integer getBalanceId() {
		return balanceId;
	}

	public void setBalanceId(Integer balanceId) {
		this.balanceId = balanceId;
	}

	public String getBalanceName() {
		return balanceName;
	}

	public void setBalanceName(String balanceName) {
		this.balanceName = balanceName;
	}

	

	public BigDecimal getDebit() {
		return debit;
	}

	public void setDebit(BigDecimal debit) {
		this.debit = debit;
	}

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public Integer getAccountsInSide() {
		return accountsInSide;
	}

	public void setAccountsInSide(Integer accountsInSide) {
		this.accountsInSide = accountsInSide;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	
	public Long getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(Long voucherNo) {
		this.voucherNo = voucherNo;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public Integer getTransactionTypeId() {
		return transactionTypeId;
	}

	public void setTransactionTypeId(Integer transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

	public String getTransactionTypeName() {
		return transactionTypeName;
	}

	public void setTransactionTypeName(String transactionTypeName) {
		this.transactionTypeName = transactionTypeName;
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

	public Integer getReferenceAccountId() {
		return referenceAccountId;
	}

	public void setReferenceAccountId(Integer referenceAccountId) {
		this.referenceAccountId = referenceAccountId;
	}

	public String getReferenceAccountNumber() {
		return referenceAccountNumber;
	}

	public void setReferenceAccountNumber(String referenceAccountNumber) {
		this.referenceAccountNumber = referenceAccountNumber;
	}

	public Integer getReferenceMemberId() {
		return referenceMemberId;
	}

	public void setReferenceMemberId(Integer referenceMemberId) {
		this.referenceMemberId = referenceMemberId;
	}

	public String getReferenceMemberName() {
		return referenceMemberName;
	}

	public void setReferenceMemberName(String referenceMemberName) {
		this.referenceMemberName = referenceMemberName;
	}

	public String getReferenceFatherName() {
		return referenceFatherName;
	}

	public void setReferenceFatherName(String referenceFatherName) {
		this.referenceFatherName = referenceFatherName;
	}
	
	
}