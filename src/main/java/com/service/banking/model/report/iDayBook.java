package com.service.banking.model.report;

import java.math.BigDecimal;

public interface iDayBook {

	public Integer getVoucherNo();
	public String getNarration();
	public String getAccountNumber();
	public String getName();
	public String getFatherName();
	public BigDecimal getAmountDr();
	public BigDecimal getAmountCr();
	public Integer getBranchId();
	public String getBranchName();
	public Integer getCount();
}
