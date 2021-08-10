package com.service.banking.service;

import java.util.Date;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.LongArraySerializer;
import com.service.banking.hibernateEntity.Accounts;
import com.service.banking.hibernateEntity.Branches;
import com.service.banking.hibernateEntity.TransactionPage;
import com.service.banking.hibernateEntity.TransactionPageElement;
import com.service.banking.hibernateEntity.TransactionRow;
import com.service.banking.hibernateEntity.TransactionTypes;
import com.service.banking.hibernateEntity.Transactions;
import com.service.banking.model.GstModel.TransactionType;
import com.service.banking.model.accountsModel.AccountDetails;
import com.service.banking.model.accountsModel.SMAccountsDetails;
import com.service.banking.model.dashboardModel.SchemaDetail;
import com.service.banking.model.hodAuthorityModel.PremiumDetails;
import com.service.banking.model.superAdminModel.BranchDetail;
import com.service.banking.model.superAdminModel.SchemeDetails;
import com.service.banking.model.transaction.DepositeDetails;
import com.service.banking.model.transaction.ITransactionModel;
import com.service.banking.model.transaction.JournalDetails;
import com.service.banking.model.transaction.NewPageReq;
import com.service.banking.model.transaction.PageElementDetails;
import com.service.banking.model.transaction.PageElementReq;
import com.service.banking.model.transaction.PageUpdateReq;
import com.service.banking.model.transaction.TransElementDetails;
import com.service.banking.model.transaction.TransPageDetails;
import com.service.banking.model.transaction.iBalance;
import com.service.banking.model.transaction.transactionModel;
import com.service.banking.repository.AccountsRepo.AccountsRepo;
import com.service.banking.repository.dashBoardRepo.DashBoardSchemeRepo;
import com.service.banking.repository.hodAuthorityRepo.AgentsTdsRepo;
import com.service.banking.repository.hodAuthorityRepo.PremuimRepo;
import com.service.banking.repository.superAdminRepo.BranchesRepository;
import com.service.banking.repository.transaction.TranElementRepo;
import com.service.banking.repository.transaction.TransPageElementRepo;
import com.service.banking.repository.transaction.TransTypeRepo;
import com.service.banking.repository.transaction.TransactionPageRepo;
import com.service.banking.repository.transaction.TransactionRowRepo;
import com.service.banking.repository.transaction.TransactionsRepo;
import com.service.banking.utils.DateFormater;

import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.util.Duration;
import javassist.tools.framedump;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;
  
@Service
public class TransactionService {
	
	
	@Autowired
	TransactionPageRepo transPageRepo;   // for page
	
	@Autowired
	TransPageElementRepo pageElentRepo;   // for page element 
	
	@Autowired
	TranElementRepo ElentRepo;   // all element
	
	@Autowired
	TransactionsRepo transactionsRepo;
	
	@Autowired
	TransactionRowRepo transactionRowRepo;
	
	@Autowired
	TransTypeRepo transTypeRepo;
	
	@Autowired
	AccountsRepo accountsRepo;
	
	@Autowired
	BranchesRepository branchesRepository;
	
	@Autowired
	PremuimRepo premiumRepo;
	
	@Autowired
	DashBoardSchemeRepo dashBoardSchemeRepo;
	
	
	
	// get all transaction page.....................................................
	public List<TransactionPage> getTransPage() {
		List<TransactionPage> transpage = transPageRepo.getTransPage();
		if (transpage.size() != 0) {
			return transpage;
		} else {
			return new ArrayList<TransactionPage>();
		}
	}

	// get page elements
	// details..........................................................
	public List<PageElementDetails> getPageElement(Integer id) {

		List<PageElementDetails> pageElmnt = pageElentRepo.getPageElements(id);
		if (pageElmnt.size() != 0) {
			return pageElmnt;
		} else {
			return new ArrayList<PageElementDetails>();
		}
	}

	// get all elements details.....................................................
	public List<TransElementDetails> getAllElemnts() {

		List<TransElementDetails> elements = ElentRepo.getAllElements();
		if (elements.size() != 0) {
			return elements;
		} else {
			return new ArrayList<TransElementDetails>();
		}
	}

	// create transaction page and
	// save.....................................................
	public void createNewTransPage(NewPageReq pageDetails) {
		TransactionPage page = new TransactionPage();
		if (pageDetails.getTransactionPage() != null) {
			page = transPageRepo.save(pageDetails.getTransactionPage()); // save page details and get id............
			System.out.print("************id" + page.getId());
		}

		// saving page element ...................
		List<PageElementReq> pageElement = pageDetails.getPageElementReqs();
		for (PageElementReq pageElementReq : pageElement) {
			TransactionPageElement transactionPageElement = new TransactionPageElement();
			transactionPageElement.setPageId(page.getId());
			transactionPageElement.setElementId(pageElementReq.getElementId());
			transactionPageElement.setElementOrder(pageElementReq.getElementOrder());
			transactionPageElement.setPageElementStatus(pageElementReq.getPageElementStatus());
			pageElentRepo.save(transactionPageElement);
		}
	}

	// update transaction page.....................................................
	public void UpdateTransPage(PageUpdateReq pageDetails) {
		TransactionPage transPage = transPageRepo.getOne(pageDetails.getId());
		transPage.setTransactionName(pageDetails.getPageName());
		transPage.setTransactionType(pageDetails.getPageType());
		transPage.setPageOrderNumber(pageDetails.getPageOrder());
		transPage.setStatus(pageDetails.getStatus());
		transPageRepo.save(transPage); // update the page details.............
		System.out.print("************id" + pageDetails.getId());

		// for updating page element.....................
		List<PageElementReq> pageElement = pageDetails.getPageElementReqs();

		for (PageElementReq pageElementReq : pageElement) {
			TransactionPageElement transactionPageElement = pageElentRepo.getOne(pageElementReq.getElementId());
			transactionPageElement.setElementId(pageElementReq.getElementId());
			transactionPageElement.setPageId(2);
			transactionPageElement.setElementOrder(pageElementReq.getElementOrder());
			transactionPageElement.setPageElementStatus(pageElementReq.getPageElementStatus());
			pageElentRepo.save(transactionPageElement);
		}

	}


	public void transactionDeposite(DepositeDetails depositeDetails) {
		
		//If AccountFrom is NULL...
		AccountDetails accountDetailsFrom = new AccountDetails();
		if(depositeDetails.getAcFrom() == null) {
			accountDetailsFrom = accountsRepo.getCashAccounts(depositeDetails.getLoginBranch());
		}
		else {
			accountDetailsFrom = accountsRepo.getAccountInfoById(depositeDetails.getAcFrom());
		}
		
		AccountDetails accountDetailsTo = accountsRepo.getAccountInfoById(depositeDetails.getAcTo());
		
		Integer branchIdFrom = accountDetailsFrom.getBranchId();
		Integer branchIdTo = accountDetailsTo.getBranchId();
		String accountType = accountDetailsTo.getAccountType();
		
		
		Integer transactionType = 0;
		
		if(accountDetailsFrom.getBranchId() != accountDetailsTo.getBranchId()) {
			Branches branches = branchesRepository.getOne(accountDetailsTo.getBranchId());
			String branchCode = branches.getCode();
			System.out.println(branchCode);
			
			Branches branches1 = branchesRepository.getOne(depositeDetails.getLoginBranch());
			String branchCode1 = branches1.getCode();
			System.out.println(branchCode1);
			
			
			AccountDetails accountDetailsBranchDivison = accountsRepo.getBranchDivisionId(branchCode, depositeDetails.getLoginBranch());
			AccountDetails accountDetailsBranchDivison1 = accountsRepo.getBranchDivisionId(branchCode1, accountDetailsTo.getBranchId());
			System.out.println(accountDetailsBranchDivison.getId());
			System.out.println(accountDetailsBranchDivison1.getId());
			
			if(accountType.equals("Saving"))
				transactionType= 4;
			else if(accountType.equals("Recurring"))
				transactionType = 10;
			else if(accountType.equals("CC"))
				transactionType = 21;
			else if(accountType.equals("DDS"))
				transactionType = 20;
			else if(accountType.equals("FD")) 
				transactionType = 9;
			else if(accountType.equals("Default"))
				transactionType = 38;
			else if(accountType.equals("SM"))
				transactionType = 38;
			else
				transactionType = 1;
			
			createTransactions(depositeDetails, accountDetailsBranchDivison1.getId(), depositeDetails.getAcTo(), transactionType, depositeDetails.getAcTo(), branchIdTo);
			createTransactions(depositeDetails, accountDetailsFrom.getId(), accountDetailsBranchDivison.getId(), transactionType, accountDetailsFrom.getId(), branchIdFrom);
		}
		else {
			createTransactions(depositeDetails, accountDetailsFrom.getId(), depositeDetails.getAcTo(), transactionType, depositeDetails.getAcTo(), branchIdTo);
		}
	}
	
	public void transactionWithdrawl(DepositeDetails depositeDetails) {
		
//		iBalance iBalance = transactionRowRepo.getBalance(depositeDetails.getAcFrom());	
//		Integer balance = iBalance.getBalance();
//		
//		if(balance <= 0 || balance < depositeDetails.getAmount()) {
//			return ;
//		}
		
		AccountDetails accountDetailsFrom = accountsRepo.getAccountInfoById(depositeDetails.getAcFrom());
		Integer branchIdFrom = accountDetailsFrom.getBranchId();
		
		AccountDetails accountDetailsTo = new AccountDetails();
		if(depositeDetails.getAcTo() == null) {
			accountDetailsTo = accountsRepo.getCashAccounts(depositeDetails.getLoginBranch());
		}
		else {
			accountDetailsTo = accountsRepo.getAccountInfoById(depositeDetails.getAcTo());
		}
		
		Integer branchIdTo = accountDetailsTo.getBranchId();
		String accountType = accountDetailsTo.getAccountType();
		
		Integer transactionType = 0;
		
		if(accountDetailsFrom.getBranchId() != accountDetailsTo.getBranchId()) {
			Branches branches = branchesRepository.getOne(branchIdFrom);
			String branchCode = branches.getCode();
			System.out.println(branchCode);
			
			Branches branches1 = branchesRepository.getOne(branchIdTo);
			String branchCode1 = branches1.getCode();
			System.out.println(branchCode1);
			
			
			AccountDetails accountDetailsBranchDivison = accountsRepo.getBranchDivisionId(branchCode, branchIdTo);
			AccountDetails accountDetailsBranchDivison1 = accountsRepo.getBranchDivisionId(branchCode1, branchIdFrom);
			System.out.println(accountDetailsBranchDivison.getId());
			System.out.println(accountDetailsBranchDivison1.getId());
			
			if(accountType.equals("Saving"))
				transactionType= 4;
			else if(accountType.equals("Recurring"))
				transactionType = 10;
			else if(accountType.equals("CC"))
				transactionType = 21;
			else if(accountType.equals("DDS"))
				transactionType = 20;
			else if(accountType.equals("FD")) 
				transactionType = 9;
			else if(accountType.equals("Default"))
				transactionType = 38;
			else if(accountType.equals("SM"))
				transactionType = 38;
			else
				transactionType = 1;
			
			createTransactions(depositeDetails, depositeDetails.getAcFrom(), accountDetailsBranchDivison1.getId(), transactionType, depositeDetails.getAcFrom(), branchIdFrom);
			createTransactions(depositeDetails, accountDetailsBranchDivison.getId(), accountDetailsTo.getId(), transactionType,accountDetailsTo.getId(), branchIdTo);
		}
		else {
			createTransactions(depositeDetails, depositeDetails.getAcFrom(), accountDetailsTo.getId(), transactionType, accountDetailsTo.getId(), branchIdTo);
		}
	}
	
	
	public void createTransactions(DepositeDetails depositeDetails, Integer acFrom, Integer acTo,  Integer JVtype, Integer idForVoucher, Integer branchId) {
		Transactions transactions = new Transactions();
		transactions.setTransactionTypeId(JVtype);
		transactions.setStaffId(depositeDetails.getStaffId());
		transactions.setNarration(depositeDetails.getNarration());
		System.out.println(depositeDetails.getNarration());
		Date date = new Date();
		transactions.setCreatedAt(date);
		transactions.setUpdatedAt(date);
		transactions.setBranchId(branchId);
		transactions.setVoucherNo(BigDecimal.valueOf(getVoucherNo(idForVoucher)));
		transactionsRepo.save(transactions);
		
		TransactionRow transactionRow = new TransactionRow();
		transactionRow.setAccountId(acFrom);
		transactionRow.setTransactionTypeId(JVtype);
		transactionRow.setStaffId(depositeDetails.getStaffId());
		transactionRow.setNarration(depositeDetails.getNarration());
		transactionRow.setAmountDr(BigDecimal.valueOf(depositeDetails.getAmount()));
		transactionRow.setAmountCr(BigDecimal.valueOf(0));
		transactionRow.setCreatedAt(date);
		transactionRow.setUpdatedAt(date);
		transactionRow.setBranchId(branchId);
		transactionRow.setSide("DR");
		transactionRow.setAccountsInSide(1);
		transactionRow.setTransactionId(transactions.getId());
		transactionRow.setSchemeId(getSchemeID(acFrom));
		transactionRow.setBalanceSheetId(getBalanceSheetID(acFrom));
		transactionRow.setVoucherNo(transactions.getVoucherNo().longValue());
		System.out.println(transactions.getVoucherNo().longValue());
		transactionRowRepo.save(transactionRow);
		
		TransactionRow transactionRow2 = new TransactionRow();
		transactionRow2.setAccountId(acTo);
		transactionRow2.setTransactionTypeId(JVtype);
		transactionRow2.setStaffId(1);
		transactionRow2.setNarration(depositeDetails.getNarration());
		transactionRow2.setAmountDr(BigDecimal.valueOf(0));
		transactionRow2.setAmountCr(BigDecimal.valueOf(depositeDetails.getAmount()));
		transactionRow2.setCreatedAt(date);
		transactionRow2.setUpdatedAt(date);
		transactionRow2.setBranchId(branchId);
		transactionRow2.setSide("CR");
		transactionRow2.setAccountsInSide(1);
		transactionRow2.setTransactionId(transactions.getId());
		transactionRow2.setSchemeId(getSchemeID(acTo));
		transactionRow2.setBalanceSheetId(getBalanceSheetID(acTo));
		transactionRow2.setVoucherNo(transactions.getVoucherNo().longValue());
		transactionRowRepo.save(transactionRow2);
	}
	


	public void transactionJournal(JournalDetails journalDetails) {
		
		Transactions transactions = new Transactions();
		transactions.setTransactionTypeId(journalDetails.getJvtypeid());
		transactions.setStaffId(journalDetails.getStaffId());
		transactions.setNarration(journalDetails.getNarration());
		Date date = new Date();
		transactions.setCreatedAt(date);
		transactions.setUpdatedAt(date);
		transactions.setBranchId(journalDetails.getBranchId());
		BigDecimal voucherNo = BigDecimal.valueOf(getVoucherNo(journalDetails.getAcFrom1()));
		transactions.setVoucherNo(voucherNo);
		transactionsRepo.save(transactions);
		
		if(journalDetails.getAcFrom1() != null) {
			JournalTransactionDr(journalDetails.getAcFrom1(), journalDetails.getNarration(), journalDetails.getJvtypeid(),journalDetails.getAmtFrom1(),journalDetails.getStaffId(),journalDetails.getBranchId(),transactions.getId(), voucherNo);
		}
		if(journalDetails.getAcFrom2() != null) {
			JournalTransactionDr(journalDetails.getAcFrom2(), journalDetails.getNarration(), journalDetails.getJvtypeid(),journalDetails.getAmtFrom2(),journalDetails.getStaffId(),journalDetails.getBranchId(),transactions.getId(), voucherNo);
		}
		if(journalDetails.getAcFrom3() != null) {
			JournalTransactionDr(journalDetails.getAcFrom3(), journalDetails.getNarration(), journalDetails.getJvtypeid(),journalDetails.getAmtFrom3(),journalDetails.getStaffId(),journalDetails.getBranchId(),transactions.getId(), voucherNo);
		}
		if(journalDetails.getAcFrom4() != null) {
			JournalTransactionDr(journalDetails.getAcFrom4(), journalDetails.getNarration(), journalDetails.getJvtypeid(),journalDetails.getAmtFrom4(),journalDetails.getStaffId(),journalDetails.getBranchId(),transactions.getId(), voucherNo);
		}
		if(journalDetails.getAcFrom5() != null) {
			JournalTransactionDr(journalDetails.getAcFrom5(), journalDetails.getNarration(), journalDetails.getJvtypeid(),journalDetails.getAmtFrom5(),journalDetails.getStaffId(),journalDetails.getBranchId(),transactions.getId(), voucherNo);
		}
		
		
		if(journalDetails.getAcTo1() != null) {
			JournalTransactionCr(journalDetails.getAcTo1(), journalDetails.getNarration(), journalDetails.getJvtypeid(),journalDetails.getAmtTo1(),journalDetails.getStaffId(),journalDetails.getBranchId(),transactions.getId(), voucherNo);
		}
		
		if(journalDetails.getAcTo2() != null) {
			JournalTransactionCr(journalDetails.getAcTo2(), journalDetails.getNarration(), journalDetails.getJvtypeid(),journalDetails.getAmtTo2(),journalDetails.getStaffId(),journalDetails.getBranchId(),transactions.getId(), voucherNo);
		}
		
		if(journalDetails.getAcTo3() != null) {
			JournalTransactionCr(journalDetails.getAcTo3(), journalDetails.getNarration(), journalDetails.getJvtypeid(),journalDetails.getAmtTo3(),journalDetails.getStaffId(),journalDetails.getBranchId(),transactions.getId(), voucherNo);
		}
		
		if(journalDetails.getAcTo4() != null) {
			JournalTransactionCr(journalDetails.getAcTo4(), journalDetails.getNarration(), journalDetails.getJvtypeid(),journalDetails.getAmtTo4(),journalDetails.getStaffId(),journalDetails.getBranchId(),transactions.getId(), voucherNo);
		}
		
		if(journalDetails.getAcTo5() != null) {
			JournalTransactionCr(journalDetails.getAcTo5(), journalDetails.getNarration(), journalDetails.getJvtypeid(),journalDetails.getAmtTo5(),journalDetails.getStaffId(),journalDetails.getBranchId(),transactions.getId(), voucherNo);
		}
		

		
		
	}
	
	public void JournalTransactionDr(Integer accountId, String narration, Integer JVtype, Double amount, Integer staffId, Integer branchId, Integer TransactionId,  BigDecimal voucherNo) {

		TransactionRow transactionRow = new TransactionRow();
		transactionRow.setAccountId(accountId);
		transactionRow.setTransactionTypeId(JVtype);
		transactionRow.setStaffId(staffId);
		transactionRow.setNarration(narration);
		transactionRow.setAmountDr(BigDecimal.valueOf(amount));
		transactionRow.setAmountCr(BigDecimal.valueOf(0));
		
		Date date = new Date();
		transactionRow.setCreatedAt(date);
		transactionRow.setUpdatedAt(date);
		transactionRow.setBranchId(branchId);
		transactionRow.setSide("DR");
		transactionRow.setAccountsInSide(1);
		transactionRow.setTransactionId(TransactionId);
		transactionRow.setSchemeId(getSchemeID(accountId));
		transactionRow.setBalanceSheetId(getBalanceSheetID(accountId));
		transactionRow.setVoucherNo(voucherNo.longValue());
		transactionRowRepo.save(transactionRow);	
	}
	
	public void JournalTransactionCr(Integer accountId, String narration, Integer JVtype, Double amount, Integer staffId, Integer branchId, Integer TransactionId,  BigDecimal voucherNo) {

		TransactionRow transactionRow = new TransactionRow();
		transactionRow.setAccountId(accountId);
		transactionRow.setTransactionTypeId(JVtype);
		transactionRow.setStaffId(staffId);
		transactionRow.setNarration(narration);
		transactionRow.setAmountDr(BigDecimal.valueOf(0));
		transactionRow.setAmountCr(BigDecimal.valueOf(amount));
		
		Date date = new Date();
		transactionRow.setCreatedAt(date);
		transactionRow.setUpdatedAt(date);
		transactionRow.setBranchId(branchId);
		transactionRow.setSide("CR");
		transactionRow.setAccountsInSide(1);
		transactionRow.setTransactionId(TransactionId);
		transactionRow.setSchemeId(getSchemeID(accountId));
		transactionRow.setBalanceSheetId(getBalanceSheetID(accountId));
		transactionRow.setVoucherNo(voucherNo.longValue());
		transactionRowRepo.save(transactionRow);	
	}
	
	
	public String forClose(DepositeDetails depositeDetails) {
		AccountDetails accountDetails = accountsRepo.getClosedAccounts(depositeDetails.getLoginBranch());
		createTransactions(depositeDetails, depositeDetails.getAcFrom(), accountDetails.getId(), depositeDetails.getTransactionTypeId(), depositeDetails.getAcFrom(), depositeDetails.getLoginBranch());
		return "Transaction successfully Done";
	}
	

	public String performPenalty(DepositeDetails depositeDetails) {
		
		//If AccountFrom is NULL...
		AccountDetails accountDetailsFrom = new AccountDetails();
		if(depositeDetails.getAcFrom() == null) {
			accountDetailsFrom = accountsRepo.getCashAccounts(depositeDetails.getLoginBranch());
		}
		else {
			accountDetailsFrom = accountsRepo.getAccountInfoById(depositeDetails.getAcFrom());
		}
		
		AccountDetails accountDetailsTo = accountsRepo.getAccountInfoById(depositeDetails.getAcTo());
		
		Integer branchIdFrom = accountDetailsFrom.getBranchId();
		Integer branchIdTo = accountDetailsTo.getBranchId();


		if(accountDetailsFrom.getBranchId() != depositeDetails.getAcTo()) {
			Branches branches = branchesRepository.getOne(branchIdFrom);
			String branchCode = branches.getCode();
			System.out.println(branchCode);
			
			Branches branches1 = branchesRepository.getOne(branchIdTo);
			String branchCode1 = branches1.getCode();
			System.out.println(branchCode1);
			
			
			AccountDetails accountDetailsBranchDivison = accountsRepo.getBranchDivisionId(branchCode, branchIdTo); 
			AccountDetails accountDetailsBranchDivison1 = accountsRepo.getBranchDivisionId(branchCode1, branchIdFrom); 
			System.out.println(accountDetailsBranchDivison.getId());  //UDR Branch & Divisions for JHD
			System.out.println(accountDetailsBranchDivison1.getId());
			
		
			createTransactions(depositeDetails,  accountDetailsBranchDivison.getId(), depositeDetails.getAcTo(),  depositeDetails.getTransactionTypeId(), depositeDetails.getAcTo(), branchIdTo);
			createTransactions(depositeDetails, accountDetailsFrom.getId(), accountDetailsBranchDivison1.getId() , depositeDetails.getTransactionTypeId(), accountDetailsFrom.getId(), branchIdFrom);
		}
		else {
			createTransactions(depositeDetails, accountDetailsFrom.getId(), depositeDetails.getAcTo(), depositeDetails.getTransactionTypeId(), accountDetailsFrom.getId(), depositeDetails.getLoginBranch());
		}
			return "Transaction successfully Done";
	}
	
	public String performFuel(DepositeDetails depositeDetails) {
		AccountDetails accountDetailsFrom = accountsRepo.getAccountInfoById(depositeDetails.getAcFrom());
		Integer branchIdFrom = accountDetailsFrom.getBranchId();

		if(accountDetailsFrom.getBranchId() != depositeDetails.getLoginBranch()) {
			Branches branches = branchesRepository.getOne(branchIdFrom);
			String branchCode = branches.getCode();
			System.out.println(branchCode);
			
			Branches branches1 = branchesRepository.getOne(depositeDetails.getLoginBranch());
			String branchCode1 = branches1.getCode();
			System.out.println(branchCode1);
			
			
			AccountDetails accountDetailsBranchDivison = accountsRepo.getBranchDivisionId(branchCode, depositeDetails.getLoginBranch()); //jhd
			AccountDetails accountDetailsBranchDivison1 = accountsRepo.getBranchDivisionId(branchCode1, branchIdFrom); //udr
			System.out.println(accountDetailsBranchDivison.getId());
			System.out.println(accountDetailsBranchDivison1.getId());
			
			AccountDetails accountDetails = accountsRepo.getFuel(depositeDetails.getLoginBranch());

			
			createTransactions(depositeDetails, accountDetailsBranchDivison1.getId(), depositeDetails.getAcFrom(), depositeDetails.getTransactionTypeId(), depositeDetails.getAcFrom(), branchIdFrom);
			createTransactions(depositeDetails, accountDetails.getId(), accountDetailsBranchDivison.getId(), depositeDetails.getTransactionTypeId(), accountDetails.getId(), depositeDetails.getLoginBranch());
			return "Transaction successfully Done";
		}
		else {
			AccountDetails accountDetails = accountsRepo.getFuel(depositeDetails.getLoginBranch());
			createTransactions(depositeDetails, accountDetails.getId(), depositeDetails.getAcFrom(), depositeDetails.getTransactionTypeId(), depositeDetails.getAcFrom(), depositeDetails.getLoginBranch());
			return "Transaction successfully Done";
		}
		
	}

	
	public String performConveyance(DepositeDetails depositeDetails) {
		
		AccountDetails accountDetailsFrom = accountsRepo.getAccountInfoById(depositeDetails.getAcFrom());
		Integer branchIdFrom = accountDetailsFrom.getBranchId();

		if(accountDetailsFrom.getBranchId() != depositeDetails.getLoginBranch()) {
			Branches branches = branchesRepository.getOne(branchIdFrom);
			String branchCode = branches.getCode();
			System.out.println(branchCode);
			
			Branches branches1 = branchesRepository.getOne(depositeDetails.getLoginBranch());
			String branchCode1 = branches1.getCode();
			System.out.println(branchCode1);
			
			
			AccountDetails accountDetailsBranchDivison = accountsRepo.getBranchDivisionId(branchCode, depositeDetails.getLoginBranch()); //jhd
			AccountDetails accountDetailsBranchDivison1 = accountsRepo.getBranchDivisionId(branchCode1, branchIdFrom); //udr
			System.out.println(accountDetailsBranchDivison.getId());
			System.out.println(accountDetailsBranchDivison1.getId());
			
			AccountDetails accountDetails = accountsRepo.getConveyance(depositeDetails.getLoginBranch());

			
			createTransactions(depositeDetails, accountDetailsBranchDivison1.getId(), depositeDetails.getAcFrom(), depositeDetails.getTransactionTypeId(), depositeDetails.getAcFrom(), branchIdFrom);
			createTransactions(depositeDetails, accountDetails.getId(), accountDetailsBranchDivison.getId(), depositeDetails.getTransactionTypeId(), accountDetails.getId(), depositeDetails.getLoginBranch());
			return "Transaction successfully Done";
		}
		else {
			AccountDetails accountDetails = accountsRepo.getConveyance(depositeDetails.getLoginBranch());
			createTransactions(depositeDetails, accountDetails.getId(), depositeDetails.getAcFrom(), depositeDetails.getTransactionTypeId(), depositeDetails.getAcFrom(), depositeDetails.getLoginBranch());
			return "Transaction successfully Done";
		}
		
		
	}
	
	
	
	public List<TransactionTypes> getTransType() {
		List<TransactionTypes> transtype = transTypeRepo.getTransType();
		if (transtype.size() != 0) {
			return transtype;
		} else {
			return new ArrayList<TransactionTypes>();
		}
	}

	public List<AccountDetails> getBankAccount() {
		List <AccountDetails> bankAccounts =  accountsRepo.getBankAccounts();
		if(bankAccounts.size() != 0) {
			return bankAccounts;
		} else {
			return new ArrayList<AccountDetails>();
		}
	}

	public String salaryAllowance(DepositeDetails depositeDetails) {
		Transactions transactions = new Transactions();
		transactions.setTransactionTypeId(depositeDetails.getTransactionTypeId());
		transactions.setStaffId(depositeDetails.getStaffId());
		transactions.setBranchId(depositeDetails.getBranchId());
		transactions.setNarration(depositeDetails.getNarration());
		Date date = new Date();
		transactions.setCreatedAt(date);
		transactions.setUpdatedAt(date);
		transactionsRepo.save(transactions);
		
		TransactionRow transactionRow = new TransactionRow();
		transactionRow.setAccountId(depositeDetails.getAcFrom());
		transactionRow.setTransactionTypeId(transactions.getTransactionTypeId());
		transactionRow.setStaffId(depositeDetails.getStaffId());
		transactionRow.setNarration(depositeDetails.getNarration());
		transactionRow.setAmountDr(BigDecimal.valueOf(depositeDetails.getAmount()));
		transactionRow.setAmountCr(BigDecimal.valueOf(0));
		transactionRow.setCreatedAt(date);
		transactionRow.setUpdatedAt(date);
		transactionRow.setBranchId(depositeDetails.getBranchId());
		transactionRow.setSide("DR");
		transactionRow.setAccountsInSide(1);
		transactionRow.setTransactionId(transactions.getId());
		transactionRow.setSchemeId(getSchemeID(depositeDetails.getAcFrom()));
		transactionRow.setBalanceSheetId(getBalanceSheetID(depositeDetails.getAcFrom()));
		transactionRowRepo.save(transactionRow);
		
		TransactionRow transactionRow2 = new TransactionRow();
		transactionRow2.setAccountId(depositeDetails.getAcTo());
		transactionRow2.setTransactionTypeId(transactions.getTransactionTypeId()); 
		transactionRow2.setStaffId(depositeDetails.getStaffId());
		transactionRow2.setNarration(depositeDetails.getNarration());
		transactionRow2.setAmountDr(BigDecimal.valueOf(0));
		transactionRow2.setAmountCr(BigDecimal.valueOf(depositeDetails.getAmount() - (depositeDetails.getTds() + depositeDetails.getEsi()+depositeDetails.getPf())));
		transactionRow2.setCreatedAt(date);
		transactionRow2.setUpdatedAt(date);
		transactionRow2.setBranchId(transactions.getBranchId());
		transactionRow2.setSide("CR");
		transactionRow2.setAccountsInSide(1);
		transactionRow2.setTransactionId(transactions.getId());
		transactionRow2.setSchemeId(getSchemeID(depositeDetails.getAcTo()));
		transactionRow2.setBalanceSheetId(getBalanceSheetID(depositeDetails.getAcTo()));
		transactionRowRepo.save(transactionRow2);
		
		if (depositeDetails.getPf() != 0) {
			TransactionRow transactionRow3 = new TransactionRow();
			Integer count = 0;
			BranchDetail branchDetail = branchesRepository.getBranchesId(depositeDetails.getAcTo());
			Integer branchid =branchDetail.getId();
			System.out.println(branchesRepository.getBranchesId(depositeDetails.getAcTo()));
	
			List<AccountDetails> pfAccounts = accountsRepo.getPFaccount();
			for(AccountDetails a:pfAccounts) {
				if(branchid == a.getBranchId()) {
					transactionRow3.setAccountId(a.getId());
					transactionRow3.setTransactionTypeId(transactions.getTransactionTypeId()); 
					transactionRow3.setStaffId(depositeDetails.getStaffId());
					transactionRow3.setNarration(depositeDetails.getNarration());
					transactionRow3.setAmountDr(BigDecimal.valueOf(0));
					transactionRow3.setAmountCr(BigDecimal.valueOf(depositeDetails.getPf()));
					transactionRow3.setCreatedAt(date);
					transactionRow3.setUpdatedAt(date);
					transactionRow3.setBranchId(transactions.getBranchId());
					transactionRow3.setSide("CR");
					transactionRow3.setAccountsInSide(1);
					transactionRow3.setTransactionId(transactions.getId());
					transactionRow3.setSchemeId(getSchemeID(a.getId()));
					transactionRow3.setBalanceSheetId(getBalanceSheetID(a.getId()));
					transactionRowRepo.save(transactionRow3);
				}
				count++;
			}
		}
		
		
		if (depositeDetails.getTds() != 0) {
			TransactionRow transactionRow4 = new TransactionRow();
			Integer count = 0;
			BranchDetail branchDetail = branchesRepository.getBranchesId(depositeDetails.getAcTo());
			Integer branchid =branchDetail.getId();
			System.out.println(branchesRepository.getBranchesId(depositeDetails.getAcTo()));
	
			List<AccountDetails> tdsAccounts = accountsRepo.getTDSaccount();
			for(AccountDetails a:tdsAccounts) {
				if(branchid == a.getBranchId()) {
					transactionRow4.setAccountId(a.getId());
					transactionRow4.setTransactionTypeId(transactions.getTransactionTypeId()); 
					transactionRow4.setStaffId(depositeDetails.getStaffId());
					transactionRow4.setNarration(depositeDetails.getNarration());
					transactionRow4.setAmountDr(BigDecimal.valueOf(0));
					transactionRow4.setAmountCr(BigDecimal.valueOf(depositeDetails.getTds()));
					transactionRow4.setCreatedAt(date);
					transactionRow4.setUpdatedAt(date);
					transactionRow4.setBranchId(transactions.getBranchId());
					transactionRow4.setSide("CR");
					transactionRow4.setAccountsInSide(1);
					transactionRow4.setTransactionId(transactions.getId());
					transactionRow4.setSchemeId(getSchemeID(a.getId()));
					transactionRow4.setBalanceSheetId(getBalanceSheetID(a.getId()));
					transactionRowRepo.save(transactionRow4);
				}
				count++;
			}
		}
		
		if (depositeDetails.getEsi() != 0) {
			TransactionRow transactionRow5 = new TransactionRow();
			Integer count = 0;
			BranchDetail branchDetail = branchesRepository.getBranchesId(depositeDetails.getAcTo());
			Integer branchid =branchDetail.getId();
			System.out.println(branchesRepository.getBranchesId(depositeDetails.getAcTo()));
	
			List<AccountDetails> esiAccounts = accountsRepo.getESIaccount();
			for(AccountDetails a:esiAccounts) {
				if(branchid == a.getBranchId()) {
					transactionRow5.setAccountId(a.getId());
					transactionRow5.setTransactionTypeId(transactions.getTransactionTypeId()); 
					transactionRow5.setStaffId(depositeDetails.getStaffId());
					transactionRow5.setNarration(depositeDetails.getNarration());
					transactionRow5.setAmountDr(BigDecimal.valueOf(0));
					transactionRow5.setAmountCr(BigDecimal.valueOf(depositeDetails.getTds()));
					transactionRow5.setCreatedAt(date);
					transactionRow5.setUpdatedAt(date);
					transactionRow5.setBranchId(transactions.getBranchId());
					transactionRow5.setSide("CR");
					transactionRow5.setAccountsInSide(1);
					transactionRow5.setTransactionId(transactions.getId());
					transactionRow5.setSchemeId(getSchemeID(a.getId()));
					transactionRow5.setBalanceSheetId(getBalanceSheetID(a.getId()));
					transactionRowRepo.save(transactionRow5);
				}
				count++;
			}
		}
		return "Transaction successfully Done";
	}

	//Get maturity amount....
	public Double getMaturityAmount(Integer accountId) {
		
		AccountDetails accountDetails = accountsRepo.getAccountInfoById(accountId);
		String accountType = accountDetails.getAccountType();
		System.out.println(accountType);
		
		Double finalMaturityAmount=0.0;
		if (accountType.equals("Recurring") || accountType.equals("DDS")) {
			 finalMaturityAmount = getMaturityInterestRDDDS(accountId);
		}
		else if (accountType.equals("FD")) {
			 finalMaturityAmount = getMaturityInterestFD(accountId);
		}
		else if (accountType.equals("MIS")) {
			finalMaturityAmount = getMaturityInterestMIS(accountId);
		}
		return finalMaturityAmount;
		
	}
	
	//Function definition for determining interest...
	Double getMaturityInterestRDDDS(Integer accountId){
		
		//Getting premium details by account ID.................
		List<PremiumDetails> premiumDetails=premiumRepo.getByPremiumAmounts(accountId);
		//getting schemeDetails by account ID..................
		SchemaDetail schemaDetail=dashBoardSchemeRepo.getSchemeByAccountId(accountId);
		System.out.println(schemaDetail);


		 int countPaidOn=0;
		 int countPaid=0;	
		 Double nowIntrest= 0.0;
		 
		 //Counting Paid and PaidOn.......
		 for(PremiumDetails p:premiumDetails) {
			 if(p.getPaidOn() != null) {
				 countPaidOn++;
			 }
			 if(p.getPaid() != 0) {
				 countPaid++;
			 }
		 }
		 System.out.println("Count paid: " + countPaid);
		 
		//Get Interest for complete product....
		 Double intrest= Double.parseDouble(schemaDetail.getInterest()); 
		 System.out.println(intrest);
		 
		//Get Interest for incomplete product....
		 BigDecimal tempUncompleteIntrest = schemaDetail.getMatureInterestsForUncompleteProduct(); 
		 Double uncompleteIntrest = tempUncompleteIntrest.doubleValue();
		 System.out.println(uncompleteIntrest);
		 
		 
	      //If Ending status then Get Interest for from premature interest column........
	      if(countPaid != schemaDetail.getMaturityPeriod()) {
	    	  
	    	//Splitting Premature interest....
	 		 String arr[] = (schemaDetail.getPreMatureInterests().split("[,:]+"));
	 		 int size = arr.length;
	 		 //Converting string array to double....
	 		 Double [] preMatureInt = new Double [size];
	 	      for(int i=0; i<size; i++) {
	 	    	  preMatureInt[i] = Double.parseDouble(arr[i]);
	 	      }
	 	      System.out.println(Arrays.toString(preMatureInt));
	    	  
	    	  //Determining interest.....
	    	  for(int i=1;i<=preMatureInt.length-1;i=i+2) {
	    		  System.out.println("--"+(int)Math.round(preMatureInt[i]));
	    		  if(countPaid >= (int)Math.round(preMatureInt[i]) && countPaid < (int)Math.round(preMatureInt[i+2])) {
	    			  nowIntrest = preMatureInt[i+1];
	    		  }
	    	  }
	    	  
	      }
		 
	      System.out.println("Now Intrest" + nowIntrest);
		 
		 //Finding Status............
			if (countPaidOn == schemaDetail.getMaturityPeriod()) {

				System.out.println("Complete");
				return -1.0;

			} else if (countPaid == schemaDetail.getMaturityPeriod()) {

				// Calling function for calculating maturity amount....
				System.out.println("UnComplete");
				return maturityAmount(premiumDetails, schemaDetail, countPaid, countPaidOn, uncompleteIntrest);
				
			} else {

				// Calling function for calculating maturity amount....
				System.out.println("Ending");
				return maturityAmount(premiumDetails, schemaDetail, countPaid, countPaidOn, nowIntrest);

			}
	}
	
	//Function definition for calculating maturity amount....
	Double maturityAmount(List<PremiumDetails> premiumDetails, SchemaDetail schemaDetail, int countPaid, int countPaidOn, Double nowIntrest){

		 Double product=0.0;
		 Double InterestTemp2=0.0;
		 Integer Amount=0;
		 Double totalAmount=0.0;
		 Double intrestAdded=0.0;
		 Double totalIntrest=0.0;
		 
		 int countMonth=0;
		 Integer amountPaid=0;
		 
		 //Calculating premium table....
		 for(PremiumDetails p:premiumDetails) {
			  
			 Amount=Integer.parseInt(p.getAmount()); 
			 product = Amount * p.getPaid() + intrestAdded;
			 InterestTemp2 = (product * ((nowIntrest/100)) / 12);
			 totalIntrest+=InterestTemp2;
			 
			 if(p.getPaidOn() != null) {
				 amountPaid += Amount;
			 }
			 
			 totalAmount += Amount + intrestAdded;
			 countMonth++;
			 
			 //After 12 month add interest in the amount....
			 if(countMonth == 12) {
				 countMonth =0;
				 intrestAdded = totalIntrest; 				 
			 }
			 
			 System.out.println("Amount: " + Amount+ "| Paid: " + p.getPaid()+ "| PaidOn: " + p.getPaidOn()+ "| Total Amount: " + amountPaid+ "| Intrest-AMount: "+ product+ "|  Intrest: " + InterestTemp2+ "|  Intrest added: " + intrestAdded +"|  Total Intrest: " + totalIntrest);
		 }
		 
		 //Final amount....
		 double finalAmount = Math.round((amountPaid + intrestAdded));
		 System.out.println("Final:" + Math.round((amountPaid + intrestAdded)));	 
		 return finalAmount;
		
	}
	
	
	//Function definition for calculating maturity interest for FD.............................................
	Double getMaturityInterestFD(Integer accountId){
		
		//Getting account information
		AccountDetails accountDetails = accountsRepo.getAccountInfoById(accountId);
		//Getting opening date (createdAt)
		Date openingDate = accountDetails.getCreatedAt();
		System.out.println(openingDate);
		
		//Getting scheme details...
		SchemaDetail schemaDetail = dashBoardSchemeRepo.getSchemeByAccountId(accountId);
		//Getting premature information....
		String preMatureInterest = schemaDetail.getPreMatureInterests(); 
		System.out.println(preMatureInterest);
		
		//Getting number of years between two dates....
		Date currentDate= new Date();
		System.out.println(currentDate);
		Integer years =currentDate.getYear()- openingDate.getYear();
		System.out.println(years);
		
		//Finding completing days....
		Long CompleteDays=0L;
		for(int i=0; i<years;i++) {
			if(i != years-1) {
				CompleteDays += 365;
			}
			else {
				Long time = currentDate.getTime() - openingDate.getTime();
				Long days = (time/(1000*60*60*24));
				System.out.println("Days: "+days);
				System.out.println("total year Days: "+ 365*(years-1));
				Long remainingDays = days - (365*(years-1));
				System.out.println("remainingDays: "+remainingDays);
				CompleteDays+=remainingDays;
				CompleteDays+=1;
			}		
		}
		System.out.println("CompleteDays: "+CompleteDays);
		
		//Splitting Premature interest....
		 String arr[] = (schemaDetail.getPreMatureInterests().split("[,:]+"));
		 int size = arr.length;
		 //Converting string array to double....
		 Double [] preMatureInt = new Double [size];
	      for(int i=0; i<size; i++) {
	    	  preMatureInt[i] = Double.parseDouble(arr[i]);
	      }
	      System.out.println(Arrays.toString(preMatureInt));
	      
    	  //Determining interest.....
	      Double nowIntrest=0.0;
    	  for(int i=0;i<=preMatureInt.length-1;i=i+2) {
    		  System.out.println("--"+(int)Math.round(preMatureInt[i]));
    		  if(CompleteDays.intValue() >= (int)Math.round(preMatureInt[i])) {
    			  nowIntrest = preMatureInt[i+1];
    			  break;
    		  }
    	  }
    	 
    	  System.out.println("Intrest applied" + nowIntrest);
		
    	//Calculating maturity interest for FD
		Double amount = accountDetails.getAmount();
		Double Interest=0.0;
		Double totalInterest=0.0;
		Double Finalamount=0.0;
		
		//Loop number of year times....
		for (int i = 0; i < years; i++) {

			// If last year ....
			if (i == years - 1) {

				Long time = currentDate.getTime() - openingDate.getTime();
				Long days = (time / (1000 * 60 * 60 * 24));
				System.out.println("Days: " + days);
				Long remainingDays = days - (365 * (years - 1));
				System.out.println("remainingDays: " + remainingDays);

				System.out.println("AmountLast: " + amount);

				Interest = ((amount * (nowIntrest / 100)) / 365) * remainingDays;
				totalInterest += Interest;
				System.out.println("InterestLast: " + Interest);
				System.out.println("totalInterest: " + totalInterest);

				Finalamount = accountDetails.getAmount() + totalInterest;

				System.out.println("Final: " + Finalamount);
				
			//If not last year.....
			} else {

				Interest = ((amount * (nowIntrest / 100)) / 365) * 365;
				totalInterest += Interest;

				System.out.println("Amount:" + amount + "| Interest:" + Interest + "| Total Intreset:" + totalInterest);

				amount = amount + Interest;
			}	
		}
		
		return Finalamount;
	
	}
	
	//Function definition for calculating maturity interest for MIS.............................................
	Double getMaturityInterestMIS (Integer accountId){
		
				//Getting account information
				AccountDetails accountDetails = accountsRepo.getAccountInfoById(accountId);
				//Getting opening date (createdAt)
				Date openingDate = accountDetails.getCreatedAt();
				System.out.println(openingDate);
				
				//Getting scheme details...
				SchemaDetail schemaDetail = dashBoardSchemeRepo.getSchemeByAccountId(accountId);
				//Getting premature information....
				String preMatureInterest = schemaDetail.getPreMatureInterests(); 
				System.out.println(preMatureInterest);
				
				//Getting number of years between two dates....
				Date currentDate= new Date();
				System.out.println(currentDate);
				Integer years =currentDate.getYear()- openingDate.getYear();
				System.out.println(years);
				
				//Finding completing days....
				Long CompleteDays=0L;
				for(int i=0; i<years;i++) {
					if(i != years-1) {
						CompleteDays += 365;
					}
					else {
						Long time = currentDate.getTime() - openingDate.getTime();
						Long days = (time/(1000*60*60*24));
						System.out.println("Days: "+days);
						System.out.println("total year Days: "+ 365*(years-1));
						Long remainingDays = days - (365*(years-1));
						System.out.println("remainingDays: "+remainingDays);
						CompleteDays+=remainingDays;
						CompleteDays+=1;
					}		
				}
				System.out.println("CompleteDays: "+CompleteDays);
				
				//Splitting Premature interest....
				 String arr[] = (schemaDetail.getPreMatureInterests().split("[,:]+"));
				 int size = arr.length;
				 //Converting string array to double....
				 Double [] preMatureInt = new Double [size];
			      for(int i=0; i<size; i++) {
			    	  preMatureInt[i] = Double.parseDouble(arr[i]);
			      }
			      System.out.println(Arrays.toString(preMatureInt));
			      
		    	  //Determining interest.....
			      Double nowIntrest=0.0;
		    	  for(int i=0;i<=preMatureInt.length-1;i=i+2) {
		    		  System.out.println("--"+(int)Math.round(preMatureInt[i]));
		    		  if(CompleteDays.intValue() >= (int)Math.round(preMatureInt[i])) {
		    			  nowIntrest = preMatureInt[i+1];
		    			  break;
		    		  }
		    	  }
		    	  
		    	  System.out.println("Intrest applied" + nowIntrest);
				
		    	//Calculating maturity interest for MIS
				Double initialAmount = accountDetails.getAmount();
				Double amount=initialAmount;
				Double Interest=0.0;
				Double totalInterest=0.0;
				Double Finalamount=0.0;
				
				Long time = currentDate.getTime() - openingDate.getTime();
				Long days = (time / (1000 * 60 * 60 * 24));
				System.out.println("Days: " + days);
				Long remainingDays = days - (365 * (years-1));
				System.out.println("remainingDays: " + remainingDays);
				
				int Status = 0;
				if(remainingDays > 365) {
					years+=1;
					remainingDays=remainingDays-365;
					Status = 1;
				}
				
				//Loop number of year times....
				for (int i = 0; i < years; i++) {

					// If last year ....
					if (i == years-1) {
						
						System.out.println("AmountLast: " + amount);
						
						if(Status == 1)
								Interest = ((amount * (nowIntrest / 100)) / 365) * (remainingDays);
						else 
							Interest = ((amount * (nowIntrest / 100)) / 365) * (remainingDays+1);
						
						totalInterest += Interest;
						
						
						System.out.println("InterestLast: " + Interest);
						System.out.println("totalInterest: " + totalInterest);
						
					//If not last year.....
					} else {

						Interest = ((amount * (nowIntrest / 100)) / 365) * 365;
						totalInterest += Interest;

						System.out.println("Amount:" + amount + "| Interest:" + Interest + "| Total Intreset:" + totalInterest);

						amount = amount + Interest;
					}	
				}
				
				ITransactionModel totalDebitSide = transactionRowRepo.getTotalDebitSide(accountId);
				Double givenAmount = totalDebitSide.getTotalAmountDr();
				System.out.println("Given amount: " + givenAmount);
				System.out.println("Actual amount: " + totalInterest);
				
				Double DiffAmount = givenAmount - totalInterest; 
				System.out.println("Difference amount: " + DiffAmount);
				
				
				Double finalAmount = initialAmount - DiffAmount;
				System.out.println("Final amount: " + Math.round(finalAmount));

				return finalAmount;
	
	
}

	public void performPreMaturePayment(DepositeDetails depositeDetails) {
		
		Transactions transactions = new Transactions();
		transactions.setStaffId(depositeDetails.getStaffId());
		transactions.setBranchId(depositeDetails.getBranchId());
		transactions.setNarration(depositeDetails.getNarration());
		Date date = new Date();
		transactions.setCreatedAt(date);
		transactions.setUpdatedAt(date);
		
		AccountDetails accountDetails = accountsRepo.getAccountInfoById(depositeDetails.getAcFrom());
		Integer transactionType=0; 
		System.out.println(accountDetails.getAccountType());
		if(accountDetails.getAccountType().equals("Recurring")) {
			transactionType=26;
		}else if (accountDetails.getAccountType().equals("FD") || accountDetails.getAccountType().equals("MIS")) {
			transactionType=25;
		}else if (accountDetails.getAccountType().equals("DDS")) {
			transactionType=24;
		}
		transactions.setTransactionTypeId(transactionType);
		transactionsRepo.save(transactions);
		
		TransactionRow transactionRow = new TransactionRow();
		transactionRow.setAccountId(depositeDetails.getAcFrom());
		transactionRow.setTransactionTypeId(transactionType);
		transactionRow.setStaffId(depositeDetails.getStaffId());
		transactionRow.setNarration(depositeDetails.getNarration());
		transactionRow.setAmountDr(BigDecimal.valueOf(depositeDetails.getAmount()));
		transactionRow.setAmountCr(BigDecimal.valueOf(0));
		transactionRow.setCreatedAt(date);
		transactionRow.setUpdatedAt(date);
		transactionRow.setBranchId(depositeDetails.getBranchId());
		transactionRow.setSide("DR");
		transactionRow.setAccountsInSide(1);
		transactionRow.setTransactionId(transactions.getId());
		transactionRow.setSchemeId(getSchemeID(depositeDetails.getAcFrom()));
		transactionRow.setBalanceSheetId(getBalanceSheetID(depositeDetails.getAcFrom()));
		transactionRowRepo.save(transactionRow);
		
		if(depositeDetails.getChargeAccount() != null) {
			TransactionRow transactionRow2 = new TransactionRow();
			transactionRow2.setAccountId(depositeDetails.getChargeAccount());
			transactionRow2.setTransactionTypeId(transactionType); 
			transactionRow2.setStaffId(depositeDetails.getStaffId());
			transactionRow2.setNarration(depositeDetails.getNarration());
			transactionRow2.setAmountDr(BigDecimal.valueOf(0));
			transactionRow2.setAmountCr(BigDecimal.valueOf(depositeDetails.getChargeAmount()));
			transactionRow2.setCreatedAt(date);
			transactionRow2.setUpdatedAt(date);
			transactionRow2.setBranchId(transactions.getBranchId());
			transactionRow2.setSide("CR");
			transactionRow2.setAccountsInSide(1);
			transactionRow2.setTransactionId(transactions.getId());
			transactionRow2.setSchemeId(getSchemeID(depositeDetails.getChargeAccount()));
			transactionRow2.setBalanceSheetId(getBalanceSheetID(depositeDetails.getChargeAccount()));
			transactionRowRepo.save(transactionRow2);
		}
		
		TransactionRow transactionRow3 = new TransactionRow();
		transactionRow3.setAccountId(depositeDetails.getAcTo());
		transactionRow3.setTransactionTypeId(transactionType); 
		transactionRow3.setStaffId(depositeDetails.getStaffId());
		transactionRow3.setNarration(depositeDetails.getNarration());
		transactionRow3.setAmountDr(BigDecimal.valueOf(0));
		transactionRow3.setAmountCr(BigDecimal.valueOf(depositeDetails.getAmount() - depositeDetails.getChargeAmount()));
		transactionRow3.setCreatedAt(date);
		transactionRow3.setUpdatedAt(date);
		transactionRow3.setBranchId(transactions.getBranchId());
		transactionRow3.setSide("CR");
		transactionRow3.setAccountsInSide(1);
		transactionRow3.setTransactionId(transactions.getId());
		transactionRow3.setSchemeId(getSchemeID(depositeDetails.getAcTo()));
		transactionRow3.setBalanceSheetId(getBalanceSheetID(depositeDetails.getAcTo()));
		transactionRowRepo.save(transactionRow3);
	}
	
	
	Integer getSchemeID(Integer accountId) {
		//Getting account information
		AccountDetails accountDetails = accountsRepo.getAccountInfoById(accountId);
		Integer scheme = accountDetails.getSchemeId();
		return scheme;
	}
	
	Integer getBalanceSheetID(Integer accountId) {
		// Getting account information
		AccountDetails accountDetails = accountsRepo.getAccountInfoById(accountId);
		Integer scheme = accountDetails.getSchemeId();
		// Getting scheme details...
		SchemaDetail schemaDetail = dashBoardSchemeRepo.getSchemeById(scheme);
		Integer balanceSheet = schemaDetail.getHeadId();
		return balanceSheet;
	}
	
	public Double getVoucherNo(Integer accountId) {
		
		// Getting account information
		AccountDetails accountDetails = accountsRepo.getAccountInfoById(accountId);
		ITransactionModel lastVoucher = transactionsRepo.getTotalDebitSide(accountDetails.getBranchId());
		
		//Testing purpose
		if(lastVoucher == null) {
			return 1.0;
		}
		
		System.out.println("last voucher" + lastVoucher.getLastVoucherNo());
		

		Date currentDate = new Date();
		Double nowVoucher = 0.0;
		Date range1 = new Date();
		Date range2 = new Date();
		range1.setDate(1);
		range1.setMonth(3);
		range1.setYear(currentDate.getYear());

		range2.setDate(30);
		range2.setMonth(3);
		range2.setYear(currentDate.getYear());
		
		
		String rangeFrom = DateFormater.getformatDate(range1);
		String rangeTo = DateFormater.getformatDate(range2);
		
		if(currentDate.getMonth() == 3) {
			System.out.println("Restart month!");
			List<ITransactionModel> listVoucher = transactionsRepo.getListVoucher(accountDetails.getBranchId(), rangeFrom, rangeTo);
			System.out.println("sizze:" + listVoucher.size());
			
			if(listVoucher.size() != 0) {
				nowVoucher = lastVoucher.getLastVoucherNo() + 1.0;
				System.out.println("Now Vocher" + nowVoucher);
			}else {
				System.out.println("No voucher Yet !");
				nowVoucher = 1.0;
				System.out.println("Now Vocher" + nowVoucher);
			}
		}else {
			nowVoucher = lastVoucher.getLastVoucherNo() + 1.0;
			System.out.println("Now Vocher" + nowVoucher);
		}
		
		return nowVoucher;
	
	}

	public void performBankDeposit(DepositeDetails depositeDetails) {
		
		//Get Cash-Account of Login branch....
		AccountDetails accountDetailsTo = accountsRepo.getCashAccounts(depositeDetails.getLoginBranch());
		AccountDetails accountDetailsInfo = accountsRepo.getAccountInfoById(depositeDetails.getAcFrom());
		
		Integer branchIdFrom = accountDetailsInfo.getBranchId();
		Integer branchIdTo = accountDetailsTo.getBranchId();
		
		
		Integer transactionType = 0;
		
		if(accountDetailsInfo.getBranchId() != accountDetailsTo.getBranchId()) {
			Branches branches = branchesRepository.getOne(branchIdFrom);
			String branchCode = branches.getCode();
			System.out.println(branchCode);
			
			Branches branches1 = branchesRepository.getOne(branchIdTo);
			String branchCode1 = branches1.getCode();
			System.out.println(branchCode1);
			
			
			AccountDetails accountDetailsBranchDivison = accountsRepo.getBranchDivisionId(branchCode, branchIdTo);
			AccountDetails accountDetailsBranchDivison1 = accountsRepo.getBranchDivisionId(branchCode1, branchIdFrom);
			System.out.println(accountDetailsBranchDivison.getId());
			System.out.println(accountDetailsBranchDivison1.getId());
			
			createTransactions(depositeDetails, accountDetailsBranchDivison.getId(), accountDetailsTo.getId(), transactionType, accountDetailsTo.getId(), branchIdTo);
			createTransactions(depositeDetails, depositeDetails.getAcFrom(), accountDetailsBranchDivison1.getId(), transactionType, depositeDetails.getAcFrom(), branchIdFrom);
		}
		else {
		
		//Perform Transaction
		createTransactions(depositeDetails, depositeDetails.getAcFrom(), accountDetailsTo.getId(), depositeDetails.getTransactionTypeId(), depositeDetails.getAcFrom(), depositeDetails.getLoginBranch());
	}
}
	
public void performBankWithdrawl(DepositeDetails depositeDetails) {
		
		//Get Cash-Account of Login branch....
		AccountDetails accountDetailsFrom = accountsRepo.getCashAccounts(depositeDetails.getLoginBranch()); //UDR cash account
		AccountDetails accountDetailsInfo = accountsRepo.getAccountInfoById(depositeDetails.getAcTo()); //JHD account
		
		Integer branchIdTo = accountDetailsInfo.getBranchId();  //JHD
		Integer branchIdFrom = accountDetailsFrom.getBranchId();  //UDR
		
		
		Integer transactionType = 0;
		
		if(accountDetailsInfo.getBranchId() != accountDetailsFrom.getBranchId()) {
			Branches branches = branchesRepository.getOne(branchIdTo);
			String branchCode = branches.getCode();
			System.out.println(branchCode); //JHD
			
			Branches branches1 = branchesRepository.getOne(branchIdFrom);
			String branchCode1 = branches1.getCode();
			System.out.println(branchCode1);  //UDR
			
			
			AccountDetails accountDetailsBranchDivison = accountsRepo.getBranchDivisionId(branchCode, branchIdFrom);  
			AccountDetails accountDetailsBranchDivison1 = accountsRepo.getBranchDivisionId(branchCode1, branchIdTo);  
			System.out.println(accountDetailsBranchDivison.getId()); //JHD BD
			System.out.println(accountDetailsBranchDivison1.getId()); //UDR BD
			
			createTransactions(depositeDetails, accountDetailsFrom.getId(), accountDetailsBranchDivison.getId(), transactionType, accountDetailsFrom.getId(), branchIdFrom);
			createTransactions(depositeDetails, accountDetailsBranchDivison1.getId(), depositeDetails.getAcTo(), transactionType,depositeDetails.getAcTo(), branchIdTo);
		}
		else {
		
		//Perform Transaction
		createTransactions(depositeDetails, accountDetailsFrom.getId(), depositeDetails.getAcTo(), depositeDetails.getTransactionTypeId(), accountDetailsFrom.getId(), depositeDetails.getLoginBranch());
	}
}




	public List<AccountDetails> getAllAccounts(String accountNumber) {
		List<AccountDetails> list = accountsRepo.getAllAccountsForTransWithdrwal(accountNumber);
		if (list.size() != 0) {
			return list;
		} else {
			return new ArrayList<AccountDetails>();
		}
}

	public Integer getBalance(Integer id) {
		iBalance ibalance = transactionRowRepo.getBalance(id);
		Integer balance = ibalance.getBalance();
		return balance;
		
		 
		
	}

	public List<AccountDetails> getBankAccounts() {
		List<AccountDetails> list = accountsRepo.getActiveBankAccounts();
		if (list.size() != 0) {
			return list;
		} else {
			return new ArrayList<AccountDetails>();
		}
	}
	
	
	
	
}
	
	

	


