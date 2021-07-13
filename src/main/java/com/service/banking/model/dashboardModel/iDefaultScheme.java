package com.service.banking.model.dashboardModel;

public interface iDefaultScheme {
	
	public Integer getFirstId();
	public Integer getSecondId();
	public String getName();
	public Long getTotalAccounts();
	public Boolean getActiveStatus();
	public Long getActiveAccounts();
	public Byte getIsDepriciable();
	public String getDepriciationPercentBeforeSep();
	public String getDepriciationPercentAfterSep();
	public String getValid_Till();
	public Double getMinLimit();
	public Double getMaxLimit();
	public String getHead();
	public String getCreated_At();
	
	

}
