package com.service.banking.model.hodAuthorityModel;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InvoiceDetails {
	
	private Integer id;
	private Integer transactionTypeId;
	private String transactionTypeName;
	private Integer staffId;
	private String staffName;
	private String referenceAccountNumber;
	private Integer referenceAccountId;
	private Integer referenceMemberId;
	private String referenceMemberName;
	private String referenceFatherName;
	private Integer branchId;
	private String branchName;
	private Integer voucherNoOriginal;
	private BigDecimal voucherNo;
	private String narration;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
	private Date createdAt;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
	private Date updatedAt;
	private Integer invoiceNo;
	private Byte isInvoiceCancel;
	private Integer transactionRowId;
	private BigDecimal crSum;
	private BigDecimal drSum;
	
	
	public InvoiceDetails() {
		super();
	}
	
	public InvoiceDetails(Integer id, Integer transactionTypeId, String transactionTypeName, Integer staffId, String staffName, String referenceAccountNumber, 
			Integer referenceAccountId, Integer referenceMemberId, String referenceMemberName, String referenceFatherName, Integer branchId, String branchName, Integer voucherNoOriginal, BigDecimal voucherNo, 
			String narration, Date createdAt, Date updatedAt, Integer invoiceNo, Byte isInvoiceCancel, Integer transactionRowId, BigDecimal drSum, BigDecimal crSum) {
		super();
		this.id = id;
		this.transactionTypeId = transactionTypeId;
		this.transactionTypeName = transactionTypeName;
		this.staffId = staffId;
		this.staffName = staffName;
		this.referenceAccountNumber = referenceAccountNumber;
		this.referenceAccountId = referenceAccountId;
		this.referenceMemberId = referenceMemberId;
		this.referenceMemberName = referenceMemberName;
		this.referenceFatherName = referenceFatherName;
		this.branchId = branchId;
		this.branchName = branchName;
		this.voucherNoOriginal = voucherNoOriginal;
		this.voucherNo = voucherNo;
		this.narration =narration;
		this.createdAt =createdAt;
		this.updatedAt = updatedAt;
		this.invoiceNo = invoiceNo;
		this.isInvoiceCancel = isInvoiceCancel;
		this.transactionRowId = transactionRowId;
//		this.crSum = crSum;
//		this.drSum = drSum;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
	public String getReferenceAccountNumber() {
		return referenceAccountNumber;
	}

	public void setReferenceAccountNumber(String referenceAccountNumber) {
		this.referenceAccountNumber = referenceAccountNumber;
	}

	public Integer getReferenceAccountId() {
		return referenceAccountId;
	}

	public void setReferenceAccountId(Integer referenceAccountId) {
		this.referenceAccountId = referenceAccountId;
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
	public Integer getVoucherNoOriginal() {
		return voucherNoOriginal;
	}
	public void setVoucherNoOriginal(Integer voucherNoOriginal) {
		this.voucherNoOriginal = voucherNoOriginal;
	}
	
	public String getNarration() {
		return narration;
	}
	public void setNarration(String narration) {
		this.narration = narration;
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
	public Integer getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(Integer invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	
	public BigDecimal getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(BigDecimal voucherNo) {
		this.voucherNo = voucherNo;
	}

	public Byte getIsInvoiceCancel() {
		return isInvoiceCancel;
	}

	public void setIsInvoiceCancel(Byte isInvoiceCancel) {
		this.isInvoiceCancel = isInvoiceCancel;
	}

	public Integer getTransactionRowId() {
		return transactionRowId;
	}
	public void setTransactionRowId(Integer transactionRowId) {
		this.transactionRowId = transactionRowId;
	}

	public BigDecimal getCrSum() {
		return crSum;
	}

	public void setCrSum(BigDecimal crSum) {
		this.crSum = crSum;
	}

	public BigDecimal getDrSum() {
		return drSum;
	}

	public void setDrSum(BigDecimal drSum) {
		this.drSum = drSum;
	}
	
	
	
}