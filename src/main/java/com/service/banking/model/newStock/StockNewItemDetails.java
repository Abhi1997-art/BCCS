package com.service.banking.model.newStock;

import java.util.HashSet;
import java.util.Set;

import com.service.banking.hibernateEntity.StocknewCategory;

public class StockNewItemDetails {
	
	//si.id,sc.name ,si.name ,si.code ,sc.allowedInTransactions ,si.description ,si.isActive ,si.isFixedAsset
	
	public Integer id;
	//public StocknewCategory stocknewCategory;
	public String name;
	public String catName;
	public String code;
	public String allowedInTransactions;
	public String description;
	public Boolean isActive;
	public Boolean isFixedAsset;
	public String currentLocation;
	
	public Integer catId;
	public Integer stocknewTransactiontemplateId;
	public Double opening;
	public Double purchase;
	public Double purchaseReturn;
	public Double internalMove;
	public Double branchTransfer;
	public Double issue;
	public Double consume;
	public Double submit;
	public Double usedSubmit;
	public Double deadSubmit;
	
	public Double totalIn;
	public Double totalOut;
	
	
	
	public StockNewItemDetails() {
		super();
	}
	public StockNewItemDetails(Integer id, String name, String catName, String code, String allowedInTransactions,
			String description, Boolean isActive, Boolean isFixedAsset) {
		super();
		this.id = id;
		this.name = name;
		this.catName = catName;
		this.code = code;
		this.allowedInTransactions = allowedInTransactions;
		this.description = description;
		this.isActive = isActive;
		this.isFixedAsset = isFixedAsset;
	}
	
//	(si.id, si.name, si.code, si.isActive, si.isFixedAsset, SUM(st.qty), SUM(IF(st.rate is NULL ,st.qty,0)))
	
	public StockNewItemDetails(Integer id, String name, String code, Boolean isActive, Boolean isFixedAsset, Double totalIn, Double totalOut) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.isActive = isActive;
		this.isFixedAsset = isFixedAsset;
		this.totalIn = totalIn;
		this.totalOut = totalOut;
	}
	

	public StockNewItemDetails(Integer id, String name,  String catName, String code, String allowedInTransactions,
			String description, Boolean isActive, Boolean isFixedAsset, Integer stocknewTransactiontemplateId, Double opening,
			Double purchase, Double purchaseReturn, 
			Double internalMove, Double branchTransfer, Double issue, Double consume, Double submit, Double usedSubmit, Double deadSubmit) {
		super();
		this.id = id;
		this.name = name;
		this.catName = catName;
		this.code = code;
		this.allowedInTransactions = allowedInTransactions;
		this.description = description;
		this.isActive = isActive;
		this.isFixedAsset = isFixedAsset;
		this.stocknewTransactiontemplateId = stocknewTransactiontemplateId;
		this.opening = opening;
		// for testing purpose uncommented below variables........
		this.purchase = purchase;
		this.purchaseReturn = purchaseReturn;
		this.internalMove = internalMove;
		this.branchTransfer = branchTransfer;
		this.issue = issue;
		this.consume = consume;
		this.submit = submit;
		this.usedSubmit = usedSubmit;
		this.deadSubmit = deadSubmit;
	}
	
	public StockNewItemDetails(Integer id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}
	

	
	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAllowedInTransactions() {
		return allowedInTransactions;
	}
	public void setAllowedInTransactions(String allowedInTransactions) {
		this.allowedInTransactions = allowedInTransactions;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getIsFixedAsset() {
		return isFixedAsset;
	}
	public void setIsFixedAsset(Boolean isFixedAsset) {
		this.isFixedAsset = isFixedAsset;
	}
	
	public Integer getStocknewTransactiontemplateId() {
		return stocknewTransactiontemplateId;
	}
	public void setStocknewTransactiontemplateId(Integer stocknewTransactiontemplateId) {
		this.stocknewTransactiontemplateId = stocknewTransactiontemplateId;
	}
	public Double getOpening() {
		return opening;
	}
	public void setOpening(Double opening) {
		this.opening = opening;
	}
	public Double getPurchase() {
		return purchase;
	}
	public void setPurchase(Double purchase) {
		this.purchase = purchase;
	}
	public Double getPurchaseReturn() {
		return purchaseReturn;
	}
	public void setPurchaseReturn(Double purchaseReturn) {
		this.purchaseReturn = purchaseReturn;
	}
	public Double getInternalMove() {
		return internalMove;
	}
	public void setInternalMove(Double internalMove) {
		this.internalMove = internalMove;
	}
	public Double getBranchTransfer() {
		return branchTransfer;
	}
	public void setBranchTransfer(Double branchTransfer) {
		this.branchTransfer = branchTransfer;
	}
	public Double getIssue() {
		return issue;
	}
	public void setIssue(Double issue) {
		this.issue = issue;
	}
	public Double getConsume() {
		return consume;
	}
	public void setConsume(Double consume) {
		this.consume = consume;
	}
	public Double getSubmit() {
		return submit;
	}
	public void setSubmit(Double submit) {
		this.submit = submit;
	}
	public Double getUsedSubmit() {
		return usedSubmit;
	}
	public void setUsedSubmit(Double usedSubmit) {
		this.usedSubmit = usedSubmit;
	}
	public Double getDeadSubmit() {
		return deadSubmit;
	}
	public void setDeadSubmit(Double deadSubmit) {
		this.deadSubmit = deadSubmit;
	}
	public Double getTotalIn() {
		return totalIn;
	}
	public void setTotalIn(Double totalIn) {
		this.totalIn = totalIn;
	}
	public Double getTotalOut() {
		return totalOut;
	}
	public void setTotalOut(Double totalOut) {
		this.totalOut = totalOut;
	}
	
	
	

}