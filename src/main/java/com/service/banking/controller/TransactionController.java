package com.service.banking.controller;

import java.util.Date;
import java.util.List;

import com.service.banking.model.GstModel.AccountDetail;
import com.service.banking.model.transaction.*;
import org.hibernate.engine.query.spi.ReturnMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.integration.config.IntegrationEvaluationContextFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.banking.hibernateEntity.Accounts;
import com.service.banking.hibernateEntity.TransactionPage;
import com.service.banking.hibernateEntity.TransactionTypes;
import com.service.banking.model.LoginModel;
import com.service.banking.model.GstModel.TransactionType;
import com.service.banking.model.accountsModel.AccountDetails;
import com.service.banking.model.accountsModel.ReturnNocDetails;
import com.service.banking.model.dashboardModel.DueDeatailsModel;
import com.service.banking.model.errorHandleModel.DataNotFoundException;
import com.service.banking.service.TransactionService;

import net.bytebuddy.asm.Advice.Return;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service
@RequestMapping("/service/transaction")
public class TransactionController {

	@Autowired
	TransactionService transService;

	@PostMapping("/deposit")
	public void transactionDeposite(@RequestBody DepositeDetails depositeDetails) {
		 transService.transactionDeposite(depositeDetails);
	}

	@PostMapping("/withdrwal")
	public void transactionWithdrawl(@RequestBody DepositeDetails depositeDetails) {
		transService.transactionWithdrawl(depositeDetails);
	}

	@PostMapping("/journal_voucher")
	public void transactionJournal(@RequestBody JournalDetails journalDetails) {
		transService.transactionJournal(journalDetails);
	}

	@PostMapping("/for_close")
	public void forClose(@RequestBody DepositeDetails depositeDetails) {

		transService.forClose(depositeDetails);
	}

	@PostMapping("/conveyance")
	public void conveyance(@RequestBody DepositeDetails depositeDetails) {
		transService.performConveyance(depositeDetails);
	}

	@PostMapping("/fuel")
	public void fuel(@RequestBody DepositeDetails depositeDetails) {
		transService.performFuel(depositeDetails);
	}

	@PostMapping("/penalty")
	public void penalty(@RequestBody DepositeDetails depositeDetails) {
		transService.performPenalty(depositeDetails);
	}
	
	@PostMapping("/bankDeposit")
	public void bankDeposit(@RequestBody DepositeDetails depositeDetails) {
		transService.performBankDeposit(depositeDetails);
	}
	
	@PostMapping("/bankWithdrawl")
	public void bankWithdrawl(@RequestBody DepositeDetails depositeDetails) {
		transService.performBankWithdrawl(depositeDetails);
	}
	
	@PostMapping("/salary_allowance")
	public void salaryAllowance(@RequestBody DepositeDetails depositeDetails) {
		transService.salaryAllowance(depositeDetails);
	}
	
	// get all transaction type
	// details.............................................................................
	@GetMapping("/getTransactionType")
	List<TransactionTypes> getTransType() {
		List<TransactionTypes> transtype = transService.getTransType(); // null check already in service....
		return transtype;
	}

	@GetMapping("/maturity_amount")
	Double getMaturityAmount(@RequestParam Integer accountId) {
		Double maturityAmount = transService.getMaturityAmount(accountId);
		return maturityAmount;
	}
	
	@PostMapping("/Premature_payment")
	void preMaturePayments(@RequestBody DepositeDetails depositeDetails) {
		transService.performPreMaturePayment(depositeDetails);
	}

	//GST.........

	@PostMapping("/memorandum_apply")
	public void memorandumApply(@RequestBody MemorandumDetails memorandumDetails) {
		transService.memorandumApply(memorandumDetails);
	}

	@PostMapping("/gst_deposite")
	public void gstDeposite(@RequestBody MemorandumDetails memorandumDetails) {
		transService.gstDeposite(memorandumDetails);
	}

	@PostMapping("/general_gst_deposite")
	public void generalGstDeposite(@RequestBody MemorandumDetails memorandumDetails) {
		transService.generalGstDeposite(memorandumDetails);
	}

	@GetMapping("/deposit_preview")
	IPreviewDetails getPreview(@RequestParam Integer accountId) {
		IPreviewDetails preview = transService.getPreview(accountId);
		return preview;
	}

    @GetMapping("/suppliers")
    List<AccountDetail> getSuppliers(@RequestParam Integer branchId) {
		List<AccountDetail> accounts = transService.getSuppliers(branchId);
        return accounts;
    }



	@PostMapping("/purchase_transaction")
	public void purchaseTransaction(@RequestBody PurchaseDetails purchaseDetails) {
		transService.purchaseTransaction(purchaseDetails);
	}


	// get all transaction page
	// details.............................................................................
	@GetMapping("/getPage")
	List<TransactionPage> getTransPage() {
		List<TransactionPage> transPage = transService.getTransPage(); // null check already in service....
		return transPage;
	}
	
	// get page elements details............................................change
	// may be later.. with page details also by dao class
	@GetMapping("/getPage_elements/{id}")
	List<PageElementDetails> getPageElements(@PathVariable("id") Integer id) {
		List<PageElementDetails> pageElement = transService.getPageElement(id); // null check already in service....
		return pageElement;

	}

	// get page elements
	// details.............................................................................
	@GetMapping("/all_elements")
	List<TransElementDetails> getAllElements() {
		List<TransElementDetails> elements = transService.getAllElemnts(); // null check already in service....
		return elements;

	}

	// new created transaction page save with elements
	// .............................................................................
	@PostMapping("/create_page")
	String transNewPageCreate(@RequestBody NewPageReq pageDetials) {
		transService.createNewTransPage(pageDetials);
		return "successfully created";

	}

	// created transaction page update with elements
	// .............................................................................
	@PostMapping("/update_page")
	String transPageUpdate(@RequestBody PageUpdateReq pageDetials) {
		// transService.UpdateTransPage(pageDetials);
		return "successfully updated";

	}

	@GetMapping("/accounts")
	List<AccountDetails> getAllAccounts(@RequestParam("accountNumber") String accountNumber) {
		List<AccountDetails> allaccounts = transService.getAllAccounts(accountNumber); // null check already in service....
		System.out.println("**********" + allaccounts.size());
		return allaccounts;
	}
	
	@GetMapping("/active_bank_accounts")
	List<AccountDetails> getBankAccounts() {
		List<AccountDetails> allaccounts = transService.getBankAccounts(); // null check already in service....
		return allaccounts;
	}
	
	@GetMapping("/balance/{acId}")
	public Integer getBalance(@PathVariable("acId") Integer id) {
		return transService.getBalance(id);
		
	}

	@GetMapping("/withdraw_accounts")
	List<AccountDetails> getWithdrawAccounts(@RequestParam("accountNumber") String accountNumber) {
		List<AccountDetails> allaccounts = transService.getWithdrawAccounts(accountNumber); // null check already in service....
		return allaccounts;
	}

	//All LOAN active accounts....
	@GetMapping("/for_closed_accounts")
	List<AccountDetails> getForClosedAccounts(@RequestParam("accountNumber") String accountNumber) {
		List<AccountDetails> allaccounts = transService.getForClosedAccounts(accountNumber); // null check already in service....
		return allaccounts;
	}

	//Get All bank accounts...... Active/Deactive...
	@GetMapping("/getBankAccount")
	List<AccountDetails> getBankAccount() {
		List<AccountDetails> bankAccounts = transService.getBankAccount(); // null check already in service....
		return bankAccounts;
	}
	
}
