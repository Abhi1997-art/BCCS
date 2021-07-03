package com.service.banking.model.newStock;

public class StockContainerTypeDetails {
   Integer id;
   String name;
   
   
public StockContainerTypeDetails() {
	super();
}
public StockContainerTypeDetails(Integer id, String name) {
	super();
	this.id = id;
	this.name = name;
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
   
   
}
