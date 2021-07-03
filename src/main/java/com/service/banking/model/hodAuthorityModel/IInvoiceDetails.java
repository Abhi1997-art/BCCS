package com.service.banking.model.hodAuthorityModel;

import java.math.BigDecimal;
import java.util.Date;

public interface IInvoiceDetails {
	public Integer getId();
	public Integer getTransactionTypeId();
	public String getTransactionTypeName();
	public Integer getStaffId();
	public String getStaffName();
	public String getReferenceAccountNumber();
	public Integer getReferenceAccountId();
	public Integer getReferenceMemberId();
	public String getReferenceMemberName();
	public String getReferenceFatherName();
	public Integer getBranchId();
	public String getBranchName();
	public Integer getVoucherNoOriginal();
	public String getNarration();
	public Date getCreatedAt();
	public Date getUpdatedAt();
	public Integer getInvoiceNo();
	public BigDecimal getVoucherNo();
	public Byte getIsInvoiceCancel();
	public Integer getTransactionRowId();
	public BigDecimal getCrSum();
	public BigDecimal getDrSum();

}