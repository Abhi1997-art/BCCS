package com.service.banking.model.hodAuthorityModel;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public interface IAgentTdsDetail {
	public Integer getId();
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
	public Date getCreatedAt();
	public BigDecimal getTotalCommission();
	public BigDecimal getTds();
	public BigDecimal getNetCommission();
	public Integer getAgentId();
	public Integer getMemberId();
	public Integer getCodeNo();
	public String getMemberName();
	public Integer getMemberNo();
	public String getCurrentAddress();
	public String getLandmark();
	public Boolean getIsDefaulter();
	public Integer getAccountId();
	public String getAccountNumber();
	public Integer getRelatedAccountMemberId();
	public String getRelatedAccountMemberName();
	public String getRelatedAccountFatherName();
	public Integer getBranchId();
	public String getBranchName();
}