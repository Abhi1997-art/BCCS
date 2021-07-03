package com.service.banking.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.banking.hibernateEntity.ContentFiles;
import com.service.banking.model.accountsModel.AccountStatementReq;
import com.service.banking.model.dashboardModel.AccountsDetails;
import com.service.banking.model.printingModel.AcountDetails;
import com.service.banking.model.printingModel.ContentAccount;
import com.service.banking.model.printingModel.FDAccountDetails;
import com.service.banking.model.printingModel.InsertPrintCertificate;
import com.service.banking.model.printingModel.MeberAccountDetail;
import com.service.banking.model.printingModel.MemberDetail;
import com.service.banking.model.printingModel.PrintFileContentReq;
import com.service.banking.model.printingModel.PrintMemberDetail;
import com.service.banking.model.printingModel.ShareAccountDetail;
import com.service.banking.model.printingModel.ShareCertificateAccount;
import com.service.banking.repository.AccountsRepo.AccountsRepo;
import com.service.banking.repository.PrintRepo.ContentFileRepo;
import com.service.banking.repository.madRepository.MembersRepo;
import com.service.banking.repository.newStock.MemberRepo;
import com.service.banking.utils.DateFormater;

@Service
public class PrintingService {
	
@Autowired
AccountsRepo accountsRepo;
  
@Autowired
MembersRepo memRepo;

@Autowired
ContentFileRepo contFile;

DateFormater dateformater= new DateFormater();
// get all fd accounts..................
public List<FDAccountDetails>  getFDAccounts(String accountName)
{
	List<FDAccountDetails> fdAccounts=accountsRepo.FDAccounts(accountName);
	if (fdAccounts.size()!=0) {
		return fdAccounts;
	}
	else {
		return  new  ArrayList<FDAccountDetails>();
	}
	
	
}
// get accounts details  for fd.............

public AcountDetails  getAccountsDetails(Integer id)
{
	AcountDetails accounts=accountsRepo.getAccountById(id);
	if (accounts!=null) {
		return accounts;
	}
	else {
		return  new AcountDetails();
	}
}
	
	// get all share certificate accounts..................
	public List<ShareCertificateAccount>  getShareCertificate(String accountName)
	{
		List<ShareCertificateAccount> shareAcnt=accountsRepo.ShareCertificateAccount(accountName);
		if (shareAcnt.size()!=0) {
			return shareAcnt;
		}
		else {
			return  new  ArrayList<ShareCertificateAccount>();
		}
		
		
	}

	// get accounts details  for share certificate.............

	public ShareAccountDetail  getShareDetails(Integer id)
	{
		ShareAccountDetail accounts=accountsRepo.getShareAccountById(id);
		if (accounts!=null) {
			return accounts;
		}
		else {
			return  new ShareAccountDetail();
		}
	}
	
	// get member accounts  for interest certificate.............

	public List<MemberDetail>  getMember(String accountName)
	{
		List<MemberDetail> shareAcnt=memRepo.getPrintMember(accountName);
		if (shareAcnt.size()!=0) {
			return shareAcnt;
		}
		else {
			return  new  ArrayList<MemberDetail>();
		}
	}
	
	// get member accounts details  for interest certificate.............

	public InsertPrintCertificate getMemberAccount(AccountStatementReq accreq)	{
		
		InsertPrintCertificate inserPrintCert= new InsertPrintCertificate();
		
		 Date from_Date=dateformater.getFromatDate(accreq.getFromDate());
		  Date to_Date= dateformater.getFromatDate(accreq.getToDate());
		  
		  PrintMemberDetail printMember= memRepo.printMember(accreq.getId());
		  inserPrintCert.setPrintMemberDetail(printMember);
		List<MeberAccountDetail> memacnt=accountsRepo.getMeberAccount(accreq.getId(),from_Date,to_Date);
		if (memacnt.size()!=0) {
			inserPrintCert.setMemAccountDetails(memacnt);
		}
		else {
			inserPrintCert.setMemAccountDetails(new  ArrayList<MeberAccountDetail>());
		}
		return inserPrintCert;
	}
	
	
	// get content file for print content  4 .............

		public List<ContentFiles> ContentFile()
		{
			List<ContentFiles> contentFiles=contFile.getContentFile();
			if (contentFiles.size()!=0) {
				return contentFiles;
			}
			else {
				return  new  ArrayList<ContentFiles>();
			}
		}

		// get Account details for print content 4 ..................
		 public List<ContentAccount> printContentAcntDetails(PrintFileContentReq printFileContentReq) 
		 {
		   String accountNumbers = printFileContentReq.getAccountNumber();  
		  String[] accountNum = accountNumbers.split(",");
		 
		  Integer contentFileId=printFileContentReq.getContentFileId();
		  
		 List<ContentAccount> contAcntList= new ArrayList<ContentAccount>();
		 for(int i=0;i<accountNum.length;i++) 
		 { 
			 ContentAccount contAcnt= new ContentAccount();
			  contAcnt=accountsRepo.getAccountsDetails(accountNum[i]);
			 if (contAcnt !=null) {
		      contAcntList.add(contAcnt); 
		  }
			 else {
				  contAcntList.add(new ContentAccount()); 
					 
				 }
			
			 }
		 
		  return contAcntList;
		  
		 }
		 

		
}
