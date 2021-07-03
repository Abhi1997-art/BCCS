package com.service.banking.model.newStock;

public class StockNewCategoryDetails {

	String opening;
	String purchase;
	String purchaseReturn;
	String internalMove;
	String branchTransfer;
	String issue;
	String consumes;
	String submit;
	String deadSubmit;
	String usedSubmit;
	String name;
	
	
	public StockNewCategoryDetails() {
		super();
	}
	
	public StockNewCategoryDetails(String opening, String purchase, String purchaseReturn, String internalMove,
			String branchTransfer, String issue, String consumes, String submit, String deadSubmit, String usedSubmit,
			String name) {
		super();
		this.opening = opening;
		this.purchase = purchase;
		this.purchaseReturn = purchaseReturn;
		this.internalMove = internalMove;
		this.branchTransfer = branchTransfer;
		this.issue = issue;
		this.consumes = consumes;
		this.submit = submit;
		this.deadSubmit = deadSubmit;
		this.usedSubmit = usedSubmit;
		this.name = name;
	}
	public String getOpening() {
		return opening;
	}
	public void setOpening(String opening) {
		this.opening = opening;
	}
	public String getPurchase() {
		return purchase;
	}
	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}
	public String getPurchaseReturn() {
		return purchaseReturn;
	}
	public void setPurchaseReturn(String purchaseReturn) {
		this.purchaseReturn = purchaseReturn;
	}
	public String getInternalMove() {
		return internalMove;
	}
	public void setInternalMove(String internalMove) {
		this.internalMove = internalMove;
	}
	public String getBranchTransfer() {
		return branchTransfer;
	}
	public void setBranchTransfer(String branchTransfer) {
		this.branchTransfer = branchTransfer;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getConsumes() {
		return consumes;
	}
	public void setConsumes(String consumes) {
		this.consumes = consumes;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getDeadSubmit() {
		return deadSubmit;
	}
	public void setDeadSubmit(String deadSubmit) {
		this.deadSubmit = deadSubmit;
	}
	public String getUsedSubmit() {
		return usedSubmit;
	}
	public void setUsedSubmit(String usedSubmit) {
		this.usedSubmit = usedSubmit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StockNewCategoryDetails [opening=" + opening + ", purchase=" + purchase + ", purchaseReturn="
				+ purchaseReturn + ", internalMove=" + internalMove + ", branchTransfer=" + branchTransfer + ", issue="
				+ issue + ", consumes=" + consumes + ", submit=" + submit + ", deadSubmit=" + deadSubmit
				+ ", usedSubmit=" + usedSubmit + "]";
	}
	
	
	
}
