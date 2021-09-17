package com.service.banking.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.service.banking.model.printingModel.*;
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
import com.service.banking.service.PrintingService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service
@RequestMapping("/service/printing")
public class PrintController {
	
	@Autowired
	PrintingService printingService;

	// Get F.D accounts....................................
	@GetMapping("/fd_bondAccounts")
	List<FDAccountDetails> getFdAccounts(@RequestParam("accountName") String accountName) {
		List<FDAccountDetails> fdAccounts = printingService.getFDAccounts(accountName); // null check already in service....
		System.out.println("**********"+fdAccounts.size());
	    return fdAccounts;	
	}
	
	// FD bond accounts....
	@GetMapping("/fd_bond_accounts/{id}")
	AcountDetails getAccounts(@PathVariable("id") Integer id) {
		AcountDetails account = printingService.getAccountsDetails(id); // null check already in service....
	    return account;		
	}
	
	// get all share certificate accounts...................................................
	@GetMapping("/sharecertificate_accounts")
	List<ShareCertificateAccount> fetSharecertificate(@RequestParam("accountName") String accountName) {
		List<ShareCertificateAccount> shareAcnt = printingService.getShareCertificate(accountName); // null check already in service....
		System.out.println("**********"+shareAcnt.size());
	    return shareAcnt;		
	}
	
	//Share certificate Print....
	@GetMapping("/share_certificate_account/{id}")
	ShareAccountDetail shareCertificateAccounts(@PathVariable("id") Integer id) {
		ShareAccountDetail shareAccountDetail = printingService.getShareDetails(id); // null check already in service....
		System.out.println("**********"+shareAccountDetail.getName());
	    return shareAccountDetail;		
	}
	
	// get all member accounts................................................... HAVE TO DELETE IG NO USED..
	@GetMapping("/member_accounts")
	List<MemberDetail> getMember(@RequestParam("accountName") String accountName) {
		List<MemberDetail> memberAccnt = printingService.getMember(accountName); // null check already in service....
		System.out.println("**********"+memberAccnt.size());
	    return memberAccnt;	
	}
	
	//Interest Certificate....
	@PostMapping("/interest_certificate")
	PrintMemberDetail getMemberDetails(@RequestParam Integer memberId) {
		PrintMemberDetail memberDetail = printingService.getMemberAccount(memberId);
		return memberDetail;
	  }
	@GetMapping("/interest_certificate_detail")
	List<iInterestCertificate> getIntCertificate(@RequestParam Integer memberId,
												 @RequestParam String dateFrom,
												 @RequestParam String dateTo) {
		List<iInterestCertificate> intCertificate = printingService.getIntCertificate(memberId, dateFrom, dateTo); // null check already in service....
		return intCertificate;
	}


	
	// print file content.............................................................. HAVE TO DELETE IF NO USED
	@GetMapping("/content_file") 
	  List<ContentFiles> getContentFile() {
	     List<ContentFiles> contentFiles = printingService.ContentFile();  // null check already in service.... return ledgerItem;
		System.out.println("size of list*****************"+contentFiles.size());
		return contentFiles;
	  }
	
	// print  content accnt details....................................
		@PostMapping("/print_file_content")
		  List<iPrintContent> getPrintContentAccnt(@RequestBody PrintFileContentReq printFileContentReq) {
		   List<iPrintContent> acntList = printingService.printContentAcntDetails(printFileContentReq);
			return acntList;
		  }
	
}
