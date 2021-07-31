package com.service.banking.model.hodAuthorityModel;

import java.math.BigDecimal;
import java.util.Date;

public interface IInvoiceDetails {
	public Integer getTransactionId();
	public Integer getTransactionTypeId();
	public String getTransactionTypeName();
	public Integer getStaffId();
	public String getStaffName();
	public String getAccountNumber();
	public Integer getId();
	public Integer getMemberId();
	public String getName();
	public String getFatherName();
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