package com.service.banking.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.banking.hibernateEntity.ContentFiles;
import com.service.banking.model.accountsModel.AccountStatementDetails;
import com.service.banking.model.accountsModel.AccountStatementReq;
import com.service.banking.model.dashboardModel.AccountsDetails;
import com.service.banking.model.printingModel.AcountDetails;
import com.service.banking.model.printingModel.ContentAccount;
import com.service.banking.model.printingModel.FDAccountDetails;
import com.service.banking.model.printingModel.InsertPrintCertificate;
import com.service.banking.model.printingModel.MeberAccountDetail;
import com.service.banking.model.printingModel.MemberDetail;
import com.service.banking.model.printingModel.PrintFileContentReq;
import com.service.banking.model.printingModel.ShareAccountDetail;
import com.service.banking.model.printingModel.ShareCertificateAccount;
import com.service.banking.service.PrintingService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service
@RequestMapping("/service/printing")
public class PrintController {
	
	@Autowired
	PrintingService printingService;

	// get F.D accounts....................................
	@GetMapping("/fd_bondAccounts")
	List<FDAccountDetails> getFdAccounts(@RequestParam("accountName") String accountName) {
		List<FDAccountDetails> fdAccounts = printingService.getFDAccounts(accountName); // null check already in service....
		System.out.println("**********"+fdAccounts.size());
	    return fdAccounts;	
	}
	
	// get accountsDetails by id for fd accounts...........
	@GetMapping("/accounts_details/{id}")
	AcountDetails getAccounts(@PathVariable("id") int id) {
		AcountDetails account = printingService.getAccountsDetails(id); // null check already in service....
		System.out.println("**********"+account.getName());
	    return account;		
	}
	
	// get all share certificate accounts...................................................
	@GetMapping("/sharecertificate_accounts")
	List<ShareCertificateAccount> fetSharecertificate(@RequestParam("accountName") String accountName) {
		List<ShareCertificateAccount> shareAcnt = printingService.getShareCertificate(accountName); // null check already in service....
		System.out.println("**********"+shareAcnt.size());
	    return shareAcnt;		
	}
	
	// get accountsDetails by id for share certificate accounts...........
	@GetMapping("/shareCertificate_account/{id}")
	ShareAccountDetail shareCertificateAccounts(@PathVariable("id") int id) {
		ShareAccountDetail shareAccountDetail = printingService.getShareDetails(id); // null check already in service....
		System.out.println("**********"+shareAccountDetail.getName());
	    return shareAccountDetail;		
	}
	
	// get all member accounts...................................................
	@GetMapping("/member_accounts")
	List<MemberDetail> getMember(@RequestParam("accountName") String accountName) {
		List<MemberDetail> memberAccnt = printingService.getMember(accountName); // null check already in service....
		System.out.println("**********"+memberAccnt.size());
	    return memberAccnt;	
	}
	
	//  get memberDetais statement for print interest..............................
	@PostMapping("/member_details") 
	InsertPrintCertificate getMemberDetails(@RequestBody AccountStatementReq accreq) {
		InsertPrintCertificate memacnt = printingService.getMemberAccount(accreq);  // null check already in service.... return ledgerItem;
		System.out.println("size of list*****************"+memacnt);
		return memacnt;
	  }
	
	// print file content..............................................................
	@GetMapping("/content_file") 
	  List<ContentFiles> getContentFile() {
	     List<ContentFiles> contentFiles = printingService.ContentFile();  // null check already in service.... return ledgerItem;
		System.out.println("size of list*****************"+contentFiles.size());
		return contentFiles;
	  }
	
	// print  content accnt details....................................
		@GetMapping("/print_file_content") 
		  List<ContentAccount> getPrintContentAccnt(@RequestBody PrintFileContentReq printFileContentReq) {
		   List<ContentAccount> acntList = printingService.printContentAcntDetails(printFileContentReq);  // null check already in service.... return ledgerItem;
			System.out.println("size of list*****************"+acntList.size());
			return acntList;
		  }
	
}
