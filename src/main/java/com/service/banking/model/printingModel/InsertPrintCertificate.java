package com.service.banking.model.printingModel;

import java.util.List;

public class InsertPrintCertificate {
	
	PrintMemberDetail printMemberDetail;
	List<MeberAccountDetail> memAccountDetails;
	
	
	
	public InsertPrintCertificate() {
		super();
	}

	public InsertPrintCertificate(PrintMemberDetail printMemberDetail, List<MeberAccountDetail> memAccountDetails) {
		super();
		this.printMemberDetail = printMemberDetail;
		this.memAccountDetails = memAccountDetails;
	}
	
	public PrintMemberDetail getPrintMemberDetail() {
		return printMemberDetail;
	}
	public void setPrintMemberDetail(PrintMemberDetail printMemberDetail) {
		this.printMemberDetail = printMemberDetail;
	}
	public List<MeberAccountDetail> getMemAccountDetails() {
		return memAccountDetails;
	}
	public void setMemAccountDetails(List<MeberAccountDetail> memAccountDetails) {
		this.memAccountDetails = memAccountDetails;
	}
	
	

}
