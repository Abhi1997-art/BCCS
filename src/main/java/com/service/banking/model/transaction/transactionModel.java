package com.service.banking.model.transaction;

import com.service.banking.model.MadModel.TotalMember;

public class transactionModel {

	private Double totalDebitSide;
	
	

	public transactionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public transactionModel(Double totalDebitSide) {
		super();
		this.totalDebitSide = totalDebitSide;
	}

	public Double getTotalDebitSide() {
		return totalDebitSide;
	}

	public void setTotalDebitSide(Double totalDebitSide) {
		this.totalDebitSide = totalDebitSide;
	}

}
