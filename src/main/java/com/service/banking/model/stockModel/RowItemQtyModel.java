package com.service.banking.model.stockModel;

public class RowItemQtyModel {
  int id;
  String qty;
  String bName;
  String conName;
  String rowName;
  String itemName;
  
  

public RowItemQtyModel(int id, String qty, String bName, String conName, String rowName,String itemName) {
	super();
	this.id = id;
	this.qty = qty;
	this.bName = bName;
	this.conName = conName;
	this.rowName = rowName;
	this.itemName = itemName;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getQty() {
	return qty;
}
public void setQty(String qty) {
	this.qty = qty;
}
public String getbName() {
	return bName;
}
public void setbName(String bName) {
	this.bName = bName;
}
public String getConName() {
	return conName;
}
public void setConName(String conName) {
	this.conName = conName;
}
public String getRowName() {
	return rowName;
}
public void setRowName(String rowName) {
	this.rowName = rowName;
}
  
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}  
  
}
