package com.service.banking.model.transaction;

public class TransElementDetails {
	
	public Integer id;
	public String elementCode;
	public String elementType;
	public String elementDesc;
	
	
	
	public TransElementDetails() {
		super();
	}



	public TransElementDetails(Integer id, String elementCode, String elementType, String elementDesc) {
		super();
		this.id = id;
		this.elementCode = elementCode;
		this.elementType = elementType;
		this.elementDesc = elementDesc;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getElementCode() {
		return elementCode;
	}



	public void setElementCode(String elementCode) {
		this.elementCode = elementCode;
	}



	public String getElementType() {
		return elementType;
	}



	public void setElementType(String elementType) {
		this.elementType = elementType;
	}



	public String getElementDesc() {
		return elementDesc;
	}



	public void setElementDesc(String elementDesc) {
		this.elementDesc = elementDesc;
	}
	
	
	
	
}
