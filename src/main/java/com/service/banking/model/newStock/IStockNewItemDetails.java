package com.service.banking.model.newStock;

public interface IStockNewItemDetails {
	public Integer getCatId();
	public String getCurrentLocation();
	public Integer getItemId();
	public Integer getId();
	public String getName();
	public String getCatName();
	public String getCode();
	public String getAllowedInTransactions();
	public String getDescription();
	public Boolean getIsActive();
	public Boolean getIsFixedAsset();
	public Integer getStocknewTransactiontemplateId();
	public Double getOpening();
	public Double getPurchase();
	public Double getPurchaseReturn();
	public Double getInternalMove();
	public Double getBranchTransfer();
	public Double getIssue();
	public Double getConsume();
	public Double getSubmit();
	public Double getUsedSubmit();
	public Double getDeadSubmit();
//	public Double getTotalIn();
//	public Double getTotalOut();

}


