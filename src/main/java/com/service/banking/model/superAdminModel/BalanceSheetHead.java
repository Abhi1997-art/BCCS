package com.service.banking.model.superAdminModel;

public class BalanceSheetHead {

	Integer headId;
	String head;

	public BalanceSheetHead() {
		super();
	}

	public BalanceSheetHead(Integer headId, String head) {
		super();
		this.headId = headId;
		this.head = head;
	}

	public Integer getHeadId() {
		return headId;
	}

	public void setHeadId(Integer headId) {
		this.headId = headId;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

}
