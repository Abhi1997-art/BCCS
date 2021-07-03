package com.service.banking.model.stockModel;

public class SupplierReqModel {
	
	int itemid;
	int nameId;
	String fromDate;
	String toDate;
	public SupplierReqModel(int itemid, int nameId, String fromDate, String toDate) {
		super();
		this.itemid = itemid;
		this.nameId = nameId;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getNameId() {
		return nameId;
	}
	public void setNameId(int nameId) {
		this.nameId = nameId;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	

}
