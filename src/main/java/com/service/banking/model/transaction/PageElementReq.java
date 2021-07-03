package com.service.banking.model.transaction;

public class PageElementReq {
	
	 Integer elementId;
	 Integer elementOrder;
	 byte pageElementStatus;
	
	
	
	public PageElementReq() {
		super();
	}



	public PageElementReq(Integer elementId, Integer elementOrder, byte pageElementStatus) {
		super();
		this.elementId = elementId;
		this.elementOrder = elementOrder;
		this.pageElementStatus = pageElementStatus;
	}



	public Integer getElementId() {
		return elementId;
	}



	public void setElementId(Integer elementId) {
		this.elementId = elementId;
	}



	public Integer getElementOrder() {
		return elementOrder;
	}



	public void setElementOrder(Integer elementOrder) {
		this.elementOrder = elementOrder;
	}



	public byte getPageElementStatus() {
		return pageElementStatus;
	}



	public void setPageElementStatus(byte pageElementStatus) {
		this.pageElementStatus = pageElementStatus;
	}
	
	
	

}
