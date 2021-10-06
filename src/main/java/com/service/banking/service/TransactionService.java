package com.service.banking.service;

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.math.BigDecimal;

import com.service.banking.hibernateEntity.*;
import com.service.banking.model.GstModel.AccountDetail;
import com.service.banking.model.transaction.*;
import com.service.banking.repository.gstRepository.MemorandomAccountStatement;
import com.service.banking.repository.gstRepository.MemorandumTransactionRepo;
import com.service.banking.repository.madRepository.AgentsRepositoty;
import com.service.banking.repository.madRepository.MembersRepo;
import com.service.banking.repository.superAdminRepo.AgentCadreRepo;
import com.service.banking.repository.superAdminRepo.ShareCertificateRepo;
import com.service.banking.repository.superAdminRepo.ShareRepository;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.LongArraySerializer;
import com.service.banking.model.GstModel.TransactionType;
import com.service.banking.model.accountsModel.AccountDetails;
import com.service.banking.model.accountsModel.SMAccountsDetails;
import com.service.banking.model.dashboardModel.SchemaDetail;
import com.service.banking.model.hodAuthorityModel.PremiumDetails;
import com.service.banking.model.superAdminModel.BranchDetail;
import com.service.banking.model.superAdminModel.SchemeDetails;
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

	@Autowired
	MemorandomAccountStatement memorandomTransactionRowRepo;

	@Autowired
	MemorandumTransactionRepo memorandumTransactionRepo;

	@Autowired
	AgentsRepositoty agentsRepositoty;

	@Autowired
	ShareRepository shareRepository;

	@Autowired
	ShareCertificateRepo shareCertificateRepo;

	@Autowired
	AgentCadreRepo agentCadreRepo;

	@Autowired
	MembersRepo membersRepo;
	
	
	
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
		System.out.println("ACTYPE" + accountType );
		
		
		Integer transactionType = 0;

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
			
			createTransactions(depositeDetails, accountDetailsBranchDivison1.getId(), depositeDetails.getAcTo(), transactionType, depositeDetails.getAcTo(), branchIdTo);
			createTransactions(depositeDetails, accountDetailsFrom.getId(), accountDetailsBranchDivison.getId(), transactionType, accountDetailsFrom.getId(), branchIdFrom);
		}
		else {
			System.out.println("transactionType" + transactionType);
			createTransactions(depositeDetails, accountDetailsFrom.getId(), depositeDetails.getAcTo(), transactionType, depositeDetails.getAcTo(), branchIdTo);
		}

		Premiums premiums = new Premiums();
			if(accountType.equals("DDS") || accountType.equals("Recurring")){
				Integer bal = getBalanceForRD_DDS(depositeDetails.getAcTo());
				System.out.println(accountDetailsTo.getId());
				System.out.println(bal);
				Premiums premium1 = premiumRepo.getFirstPremium(accountDetailsTo.getId());
				premiums = premiumRepo.getFirstUnpaidPremium(accountDetailsTo.getId());
				Integer rowNo = premiumRepo.getRowNoOfLastPaidPremium(accountDetailsTo.getId());

				Integer rowNoOfUnpaidPremium = rowNo + 1;

				Integer Amount = Integer.parseInt(premiums.getAmount());

				Integer chargeMultiply = 0;
				Boolean eligible = false;

				Date currentDate= new Date();

				for(int i = 0; i < 10; i++) {
					if (bal >= (Amount * rowNoOfUnpaidPremium)) {
						Premiums premium = premiumRepo.getFirstUnpaidPremium(accountDetailsTo.getId());
						//Mark premium
						Premiums markPremium = premiumRepo.findById(premium.getId()).get();
						markPremium.setAccountId(accountDetailsTo.getId());
						markPremium.setPaidOn(new Date());
						markPremium.setAgentCommissionSend(true);
						markPremium.setAgentCollectionChargesSend(true);

						Integer setPaid=0;
						if(premium1.getPaid() == 0) {
							setPaid=0;
						}else{
							Premiums lastPremiumPaid = premiumRepo.getlastPremiumPaid(accountDetailsTo.getId());
							setPaid = lastPremiumPaid.getPaid();
						}

						if(premium.getDueDate().equals(currentDate) || premium.getDueDate().after(currentDate)){
							setPaid = setPaid+ 1;

						}else{
							DateFormater dateFormater = new DateFormater();
							setPaid = dateFormater.getMonthsBetween(premium1.getDueDate(), currentDate);
							setPaid++;
						}
						markPremium.setPaid(setPaid);

						premiumRepo.save(markPremium);

						rowNoOfUnpaidPremium++;
						chargeMultiply++;
						eligible = true;

					} else if (eligible.equals(true)){
						Accounts accounts = accountsRepo.findById(accountDetailsTo.getId()).get();
						if(accounts.getAgentId() != null){

							Branches branches = branchesRepository.getOne(accountDetailsTo.getBranchId());
							String branchCode = branches.getCode();
							Schemes schemes = dashBoardSchemeRepo.findById(accountDetailsTo.getSchemeId()).get();
							System.out.println("Scheme " + schemes.getId());
							System.out.println("Branch " + branchCode);
							System.out.println("Sneme " + schemes.getName());

							Integer collectionSchemeAccountId = accountsRepo.getCollectionSchemeAccountId(branchCode, schemes.getName());
							System.out.println("collectionSchemeAccountId" + collectionSchemeAccountId);
							Integer commissionSchemeAccountId = accountsRepo.getCommissionSchemeAccountId(branchCode, schemes.getName());
							System.out.println("commissionSchemeAccountId" + commissionSchemeAccountId);
							Agents agent = agentsRepositoty.getOne(accountDetailsTo.getAgentId());
							System.out.println("Agent Id" + agent.getId());
							Accounts agentSavingAccount = accountsRepo.findById(agent.getAccountId()).get();
							Integer agentSavingAccountId = agentSavingAccount.getId();
							System.out.println("agentSavingAccountId" + agentSavingAccountId);
							Integer tdsAccountId = accountsRepo.getTDSaccountID(branchCode);
							System.out.println(tdsAccountId + tdsAccountId);

							Double doubleValue = 0.0;

							if(premiums.getAgentCommissionPercentage().doubleValue() != 0 ){

								Transactions transactions = createSingleTransaction(depositeDetails, transactionType, depositeDetails.getAcTo(), branchIdTo);

								Double perecentageShare = (double)agentCadreRepo.getPercentageShare(agent.getId());
								System.out.println("perecentageShare" + perecentageShare);
								Double agentCommissionPrecentage = premiums.getAgentCommissionPercentage() * (perecentageShare/100);

								System.out.println("agentCommissionPrecentage" + agentCommissionPrecentage);

								Double amountAgent = Double.parseDouble(premiums.getAmount())*(agentCommissionPrecentage/100);
								System.out.println(chargeMultiply);
								amountAgent = amountAgent * chargeMultiply;
								depositeDetails.setAmount(amountAgent);
								createSingleTransactionRowDr(depositeDetails, commissionSchemeAccountId, branchIdTo, transactions);

								Integer memberId = membersRepo.findMember(agent.getMemberId());
								double tdsPercent = 0.05;
								String panNo = membersRepo.getPanNo(memberId);
								if(panNo == null || panNo.equals("0") || panNo.equals("")){
									tdsPercent = 0.2;
								}

								depositeDetails.setAmount(amountAgent - (amountAgent * (tdsPercent)));
								createSingleTransactionRowCr(depositeDetails, agentSavingAccountId, transactions);

								depositeDetails.setAmount(amountAgent * tdsPercent);

								createSingleTransactionRowCr(depositeDetails, tdsAccountId, transactions);

								if(agent.getSponsorId() != null){

									Agents a1 = agentsRepositoty.findById(accountDetailsTo.getAgentId()).get();
									Agents a2 = agentsRepositoty.findById(a1.getSponsorId()).get();

									if(a1.getCadreId() != a2.getCadreId()){

										transactions = createSingleTransaction(depositeDetails, transactionType, depositeDetails.getAcTo(), branchIdTo);

										perecentageShare = (double)agentCadreRepo.getPercentageShare(agent.getSponsorId());
										agentCommissionPrecentage = premiums.getAgentCommissionPercentage() * (perecentageShare/100);
										System.out.println("agentCommissionPrecentage" + agentCommissionPrecentage);

										Double amountSponsor = Double.parseDouble(premiums.getAmount())*(agentCommissionPrecentage/100);
										System.out.println(chargeMultiply);
										amountSponsor = amountSponsor * chargeMultiply;
										depositeDetails.setAmount(amountSponsor-amountAgent);
										createSingleTransactionRowDr(depositeDetails, commissionSchemeAccountId, branchIdTo, transactions);

										Agents sponsor = agentsRepositoty.findById(agent.getSponsorId()).get();
										Accounts sponsorSavingAccount = accountsRepo.findById(sponsor.getAccountId()).get();

										memberId = membersRepo.findMember(agent.getMemberId());
										tdsPercent = 0.05;
										panNo = membersRepo.getPanNo(memberId);
										if(panNo == null || panNo.equals("0") || panNo.equals("")){
											tdsPercent = 0.2;
										}

										depositeDetails.setAmount((amountSponsor - amountAgent) - ((amountSponsor - amountAgent) * tdsPercent));
										createSingleTransactionRowCr(depositeDetails, sponsorSavingAccount.getId(), transactions);

										depositeDetails.setAmount((amountSponsor - amountAgent) * (tdsPercent));
										createSingleTransactionRowCr(depositeDetails, tdsAccountId, transactions);

									}

								}

							}

							if(premiums.getAgentCollectionChargesPercentage().doubleValue() != 0 ){

								Transactions transactions = createSingleTransaction(depositeDetails, transactionType, depositeDetails.getAcTo(), branchIdTo);

								Double amount = Double.parseDouble(premiums.getAmount())*(premiums.getAgentCollectionChargesPercentage().doubleValue()/100);
								System.out.println(chargeMultiply);
								amount = amount * chargeMultiply;
								depositeDetails.setAmount(amount);
								createSingleTransactionRowDr(depositeDetails, collectionSchemeAccountId, branchIdTo, transactions);

								Integer memberId = membersRepo.findMember(agent.getMemberId());
								double tdsPercent = 0.05;
								String panNo = membersRepo.getPanNo(memberId);
								if(panNo == null || panNo.equals("0") || panNo.equals("")){
									tdsPercent = 0.2;
								}

								depositeDetails.setAmount(amount - (amount * tdsPercent));
								createSingleTransactionRowCr(depositeDetails, agentSavingAccountId, transactions);

								depositeDetails.setAmount(amount * tdsPercent);
								createSingleTransactionRowCr(depositeDetails, tdsAccountId, transactions);

							}
						}
						break;
					}
				}
			}

		if(depositeDetails.getShares().equals(true)){
			//Create Shares..............................................
			ShareCertificate shareCertificate = new ShareCertificate();

			Integer lastShareCertificateName = shareCertificateRepo.getLastShareCertificateName();
			Integer currentSCName = lastShareCertificateName + 1;

			shareCertificate.setName(currentSCName);
			shareCertificate.setStatus("Issued");
			shareCertificate.setCreatedAt(new Date());
			shareCertificate.setSubmittedAt(new Date());
			shareCertificateRepo.save(shareCertificate);

			Integer SharesAmount = (depositeDetails.getAmount().intValue());
			Integer ShareCount = SharesAmount / 100;

			Integer lastNo = shareRepository.getLastNo();
			for (int i = 0; i < ShareCount; i++) {
				Share share = new Share();
				Accounts sm = accountsRepo.getOne(accountDetailsTo.getId());
				share.setCurrentMemberId(sm.getMemberId());
				share.setBuybackLockingMonths("36");
				share.setTransferLockingMonths("36");
				share.setShareCertificateId(shareCertificate.getId());
				share.setStatus("Issued");
				lastNo++;
				share.setNo(lastNo);
				shareRepository.save(share);
			}
		}

		if(accountType.equals("FD") || accountType.equals("MIS")){

			Accounts accounts = accountsRepo.findById(accountDetailsTo.getId()).get();
			if(accounts.getAgentId() != null) {

				Double originalAmount = depositeDetails.getAmount();

				Branches branches = branchesRepository.getOne(accountDetailsTo.getBranchId());
				String branchCode = branches.getCode();
				Schemes schemes = dashBoardSchemeRepo.findById(accountDetailsTo.getSchemeId()).get();
				System.out.println("Scheme " + schemes.getId());
				System.out.println("Branch " + branchCode);
				System.out.println("Sneme " + schemes.getName());

				Integer commissionSchemeAccountId = accountsRepo.getCommissionSchemeAccountId(branchCode, schemes.getName());
				System.out.println("commissionSchemeAccountId" + commissionSchemeAccountId);
				Agents agent = agentsRepositoty.getOne(accountDetailsTo.getAgentId());
				System.out.println("Agent Id" + agent.getId());
				Accounts agentSavingAccount = accountsRepo.findById(agent.getAccountId()).get();
				Integer agentSavingAccountId = agentSavingAccount.getId();
				System.out.println("agentSavingAccountId" + agentSavingAccountId);
				Integer tdsAccountId = accountsRepo.getTDSaccountID(branchCode);
				System.out.println(tdsAccountId + tdsAccountId);

				Transactions transactions = createSingleTransaction(depositeDetails, transactionType, depositeDetails.getAcTo(), branchIdTo);
				Double perecentageShare = (double) agentCadreRepo.getPercentageShare(agent.getId());
				System.out.println("perecentageShare" + perecentageShare);

				Double agentCommissionPrecentage = Double.valueOf(schemes.getAccountOpenningCommission()) * (perecentageShare / 100);

				Double amountAgent = depositeDetails.getAmount() * (agentCommissionPrecentage / 100);
				depositeDetails.setAmount(amountAgent);
				createSingleTransactionRowDr(depositeDetails, commissionSchemeAccountId, branchIdTo, transactions);

				Members members = membersRepo.findById(agent.getMemberId()).get();
				double tdsPercent = 0.05;
				if (members.getPanNo() == null || members.getPanNo().equals("0") || members.getPanNo().equals("")) {
					tdsPercent = 0.2;
				}

				depositeDetails.setAmount(amountAgent - (amountAgent * (tdsPercent)));
				createSingleTransactionRowCr(depositeDetails, agentSavingAccountId, transactions);

				depositeDetails.setAmount(amountAgent * tdsPercent);
				createSingleTransactionRowCr(depositeDetails, tdsAccountId, transactions);

				if (agent.getSponsorId() != null) {

					Agents a1 = agentsRepositoty.findById(accountDetailsTo.getAgentId()).get();
					Agents a2 = agentsRepositoty.findById(a1.getSponsorId()).get();

					if(a1.getCadreId() != a2.getCadreId()){
						transactions = createSingleTransaction(depositeDetails, transactionType, depositeDetails.getAcTo(), branchIdTo);

						perecentageShare = (double) agentCadreRepo.getPercentageShare(agent.getSponsorId());
						Double sponsorCommissionPrecentage = Double.valueOf(schemes.getAccountOpenningCommission()) * (perecentageShare / 100);

						depositeDetails.setAmount(originalAmount);
						Double amountSponsor = depositeDetails.getAmount() * (sponsorCommissionPrecentage / 100);
						depositeDetails.setAmount(amountSponsor-amountAgent);
						createSingleTransactionRowDr(depositeDetails, commissionSchemeAccountId, branchIdTo, transactions);

						Agents sponsor = agentsRepositoty.findById(agent.getSponsorId()).get();
						Accounts sponsorSavingAccount = accountsRepo.findById(sponsor.getAccountId()).get();

						members = membersRepo.findById(agent.getMemberId()).get();

						tdsPercent = 0.05;
						if (members.getPanNo() == null || members.getPanNo().equals("0")  || members.getPanNo().equals("")) {
							tdsPercent = 0.2;
						}

						depositeDetails.setAmount((amountSponsor - amountAgent) - ((amountSponsor - amountAgent) * tdsPercent));
						createSingleTransactionRowCr(depositeDetails, sponsorSavingAccount.getId(), transactions);

						depositeDetails.setAmount((amountSponsor - amountAgent) * tdsPercent);
						createSingleTransactionRowCr(depositeDetails, tdsAccountId, transactions);

					}
				}
			}

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
			else if(accountType.equals("Recurring")){
				System.out.println("break");
				transactionType = 10;
				System.out.println(transactionType);}
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


		if(accountDetailsFrom.getBranchId() != accountDetailsTo.getBranchId()) {
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
		else {;
			createTransactions(depositeDetails, accountDetailsFrom.getId(), depositeDetails.getAcTo(), depositeDetails.getTransactionTypeId(), accountDetailsFrom.getId(), depositeDetails.getLoginBranch());
		}
			return "Transaction successfully Done";
	}
	
	public String performFuel(DepositeDetails depositeDetails) {

		//If AccountFrom is NULL...
		AccountDetails accountDetailsFrom = new AccountDetails();
		if(depositeDetails.getAcFrom() == null) {
			accountDetailsFrom = accountsRepo.getCashAccounts(depositeDetails.getLoginBranch());
		}
		else {
			accountDetailsFrom = accountsRepo.getAccountInfoById(depositeDetails.getAcFrom());
		}

		//AccountDetails accountDetailsFrom = accountsRepo.getAccountInfoById(depositeDetails.getAcFrom());
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

			
			createTransactions(depositeDetails, accountDetailsBranchDivison1.getId(), accountDetailsFrom.getId(), depositeDetails.getTransactionTypeId(), accountDetailsFrom.getId(), branchIdFrom);
			createTransactions(depositeDetails, accountDetails.getId(), accountDetailsBranchDivison.getId(), depositeDetails.getTransactionTypeId(), accountDetails.getId(), depositeDetails.getLoginBranch());
			return "Transaction successfully Done";
		}
		else {
			AccountDetails accountDetails = accountsRepo.getFuel(depositeDetails.getLoginBranch());
			createTransactions(depositeDetails, accountDetails.getId(), accountDetailsFrom.getId(), depositeDetails.getTransactionTypeId(),accountDetailsFrom.getId(), depositeDetails.getLoginBranch());
			return "Transaction successfully Done";
		}
		
	}

	
	public String performConveyance(DepositeDetails depositeDetails) {

		//If AccountFrom is NULL...
		AccountDetails accountDetailsFrom = new AccountDetails();
		if(depositeDetails.getAcFrom() == null) {
			accountDetailsFrom = accountsRepo.getCashAccounts(depositeDetails.getLoginBranch());
		}
		else {
			accountDetailsFrom = accountsRepo.getAccountInfoById(depositeDetails.getAcFrom());
		}

		//AccountDetails accountDetailsFrom = accountsRepo.getAccountInfoById(depositeDetails.getAcFrom());
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

			
			createTransactions(depositeDetails, accountDetailsBranchDivison1.getId(), accountDetailsFrom.getId(), depositeDetails.getTransactionTypeId(), accountDetailsFrom.getId(), branchIdFrom);
			createTransactions(depositeDetails, accountDetails.getId(), accountDetailsBranchDivison.getId(), depositeDetails.getTransactionTypeId(), accountDetails.getId(), depositeDetails.getLoginBranch());
			return "Transaction successfully Done";
		}
		else {
			AccountDetails accountDetails = accountsRepo.getConveyance(depositeDetails.getLoginBranch());
			createTransactions(depositeDetails, accountDetails.getId(), accountDetailsFrom.getId(), depositeDetails.getTransactionTypeId(), accountDetailsFrom.getId(), depositeDetails.getLoginBranch());
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
	    		  if(countPaid < (int)Math.round(preMatureInt[i])){
					  nowIntrest = preMatureInt[i-1];
				  }
	    		  if(countPaid > (int)Math.round(preMatureInt[preMatureInt.length-2])){
					  	nowIntrest = preMatureInt[i+1];
				  }
//	    		  if(countPaid >= (int)Math.round(preMatureInt[i]) && countPaid < (int)Math.round(preMatureInt[i+2])) {
////	    			  nowIntrest = preMatureInt[i+1];
////	    		  }
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
		transactions.setVoucherNo(BigDecimal.valueOf(getVoucherNo(depositeDetails.getAcFrom())));
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
		transactionRow.setVoucherNo(transactions.getVoucherNo().longValue());
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
			transactionRow.setVoucherNo(transactions.getVoucherNo().longValue());
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
		transactionRow.setVoucherNo(transactions.getVoucherNo().longValue());
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

	public Integer getBalanceForRD_DDS(Integer id) {
		iBalance ibalance = transactionRowRepo.getBalanceForRD_DDS(id);
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

	public void memorandumApply(MemorandumDetails memorandumDetails) {

		MemorandumTransactions memorandumTransactions = new MemorandumTransactions();
		MemorandumTransactionsrow memorandumTransactionsrow1= new MemorandumTransactionsrow();
		MemorandumTransactionsrow memorandumTransactionsrow2= new MemorandumTransactionsrow();
		MemorandumTransactionsrow memorandumTransactionsrow3= new MemorandumTransactionsrow();
		MemorandumTransactionsrow memorandumTransactionsrow4= new MemorandumTransactionsrow();

		memorandumTransactions.setStaffId(memorandumDetails.getStaffId());
		memorandumTransactions.setBranchId(memorandumDetails.getBranchId());
		memorandumTransactions.setName(0);
		memorandumTransactions.setMemorandumType(memorandumDetails.getMemorandumType());
		memorandumTransactions.setNarration(memorandumDetails.getNarration());
		memorandumTransactions.setCreatedAt(new Date());
		memorandumTransactionRepo.save(memorandumTransactions);

		memorandumTransactionsrow1.setMemorandumTransactionId(memorandumTransactions.getId());
		memorandumTransactionsrow1.setAccountId(memorandumDetails.getAccountDr());
		memorandumTransactionsrow1.setAmountDr(BigDecimal.valueOf(memorandumDetails.getAmount()));
		memorandumTransactionsrow1.setAmountCr(BigDecimal.valueOf(0));
		memorandumTransactionsrow1.setTax("GST " + memorandumDetails.getTax());

		//Formula..
		Double baseAmount = (memorandumDetails.getAmount() * 100) / (100 + memorandumDetails.getTax());
		Double taxAmount = memorandumDetails.getAmount() - baseAmount;
		Double SGST = taxAmount/2;
		Double CGST = taxAmount/2;

		memorandumTransactionsrow1.setTaxAmount(BigDecimal.valueOf(taxAmount));
		memorandumTransactionsrow1.setTaxNarration("{\"SGST 9%\":" + SGST + ",\"CGST 9%\":" + CGST + "}");
		memorandumTransactionsrow1.setTaxPercentage(BigDecimal.valueOf(memorandumDetails.getTax()));
		memorandumTransactionsrow1.setTaxExcludedAmount(Double.toString(baseAmount));
		memorandumTransactionsrow1.setCreatedAt(new Date());
		memorandomTransactionRowRepo.save(memorandumTransactionsrow1);

		memorandumTransactionsrow2.setMemorandumTransactionId(memorandumTransactions.getId());
		TransactionTypes transactionTypes = transTypeRepo.findById(memorandumDetails.getMemorandumTypeId()).get();
		Integer transactionTypeAccountId = accountsRepo.getTransactionTypeAccountId(transactionTypes.getName(), memorandumDetails.getBranchId());
		memorandumTransactionsrow2.setAccountId(transactionTypeAccountId);
		memorandumTransactionsrow2.setAmountDr(BigDecimal.valueOf(0));
		memorandumTransactionsrow2.setAmountCr(BigDecimal.valueOf(baseAmount));
		memorandumTransactionsrow2.setCreatedAt(new Date());
		memorandomTransactionRowRepo.save(memorandumTransactionsrow2);

		memorandumTransactionsrow3.setMemorandumTransactionId(memorandumTransactions.getId());
		Integer accountIdForSGST9 = accountsRepo.getAccountIdForSGST9(memorandumDetails.getBranchId());
		memorandumTransactionsrow3.setAccountId(accountIdForSGST9);
		memorandumTransactionsrow3.setAmountDr(BigDecimal.valueOf(0));
		memorandumTransactionsrow3.setAmountCr(BigDecimal.valueOf(SGST));
		memorandumTransactionsrow3.setCreatedAt(new Date());
		memorandomTransactionRowRepo.save(memorandumTransactionsrow3);

		memorandumTransactionsrow4.setMemorandumTransactionId(memorandumTransactions.getId());
		Integer accountIdForCGST9 = accountsRepo.getAccountIdForCGST9(memorandumDetails.getBranchId());
		memorandumTransactionsrow4.setAccountId(accountIdForSGST9);
		memorandumTransactionsrow4.setAmountDr(BigDecimal.valueOf(0));
		memorandumTransactionsrow4.setAmountCr(BigDecimal.valueOf(CGST));
		memorandumTransactionsrow4.setCreatedAt(new Date());
		memorandomTransactionRowRepo.save(memorandumTransactionsrow4);

    }

	public void transactionMemorandum(MemorandumDetails memorandumDetails) {

		Transactions transactions = new Transactions();
		TransactionRow transactionRow1 = new TransactionRow();
		TransactionRow transactionRow2 = new TransactionRow();
		TransactionRow transactionRow3 = new TransactionRow();
		TransactionRow transactionRow4 = new TransactionRow();

		transactions.setTransactionTypeId(memorandumDetails.getMemorandumTypeId());
		transactions.setStaffId(memorandumDetails.getStaffId());
		transactions.setNarration(memorandumDetails.getNarration());
		Date date = new Date();
		transactions.setCreatedAt(date);
		transactions.setUpdatedAt(date);
		transactions.setBranchId(memorandumDetails.getBranchId());
		transactions.setVoucherNo(BigDecimal.valueOf(getVoucherNo(memorandumDetails.getAccountDr())));
		Integer lastInvoiceNo = transactionsRepo.getLastInvoiceNo();
		transactions.setInvoiceNo(1+lastInvoiceNo);
		transactions.setIsSaleInvoice((byte)1);
		transactions.setReferenceId(memorandumDetails.getAccountDr());
		transactionsRepo.save(transactions);

		//Formula..
		Double baseAmount = (memorandumDetails.getAmount() * 100) / (100 + memorandumDetails.getTax());
		Double taxAmount = memorandumDetails.getAmount() - baseAmount;
		Double SGST = taxAmount/2;
		Double CGST = taxAmount/2;

		transactionRow1.setAccountId(memorandumDetails.getAccountDr());
		transactionRow1.setTransactionTypeId(memorandumDetails.getMemorandumTypeId());
		transactionRow1.setStaffId(memorandumDetails.getStaffId());
		transactionRow1.setNarration(memorandumDetails.getNarration());
		transactionRow1.setAmountDr(BigDecimal.valueOf(memorandumDetails.getAmount()));
		transactionRow1.setAmountCr(BigDecimal.valueOf(0));
		transactionRow1.setCreatedAt(date);
		transactionRow1.setUpdatedAt(date);
		transactionRow1.setBranchId(memorandumDetails.getBranchId());
		transactionRow1.setSide("DR");
		transactionRow1.setAccountsInSide(1);
		transactionRow1.setTransactionId(transactions.getId());
		transactionRow1.setSchemeId(getSchemeID(memorandumDetails.getAccountDr()));
		transactionRow1.setBalanceSheetId(getBalanceSheetID(memorandumDetails.getAccountDr()));
		transactionRow1.setVoucherNo(transactions.getVoucherNo().longValue());
		transactionRowRepo.save(transactionRow1);

		TransactionTypes transactionTypes = transTypeRepo.findById(memorandumDetails.getMemorandumTypeId()).get();
		Integer transactionTypeAccountId = accountsRepo.getTransactionTypeAccountId(transactionTypes.getName(), memorandumDetails.getBranchId());
		transactionRow2.setAccountId(transactionTypeAccountId);
		transactionRow2.setTransactionTypeId(memorandumDetails.getMemorandumTypeId());
		transactionRow2.setStaffId(memorandumDetails.getStaffId());
		transactionRow2.setNarration(memorandumDetails.getNarration());
		transactionRow2.setAmountDr(BigDecimal.valueOf(0));
		transactionRow2.setAmountCr(BigDecimal.valueOf(baseAmount));
		transactionRow2.setCreatedAt(date);
		transactionRow2.setUpdatedAt(date);
		transactionRow2.setBranchId(memorandumDetails.getBranchId());
		transactionRow2.setSide("CR");
		transactionRow2.setAccountsInSide(1);
		transactionRow2.setTransactionId(transactions.getId());
		transactionRow2.setSchemeId(getSchemeID(transactionTypeAccountId));
		transactionRow2.setBalanceSheetId(getBalanceSheetID(transactionTypeAccountId));
		transactionRow2.setVoucherNo(transactions.getVoucherNo().longValue());
		transactionRowRepo.save(transactionRow2);

		Integer accountIdForSGST9 = accountsRepo.getAccountIdForSGST9(memorandumDetails.getBranchId());
		transactionRow3.setAccountId(accountIdForSGST9);
		transactionRow3.setTransactionTypeId(memorandumDetails.getMemorandumTypeId());
		transactionRow3.setStaffId(memorandumDetails.getStaffId());
		transactionRow3.setNarration(memorandumDetails.getNarration());
		transactionRow3.setAmountDr(BigDecimal.valueOf(0));
		transactionRow3.setAmountCr(BigDecimal.valueOf(SGST));
		transactionRow3.setCreatedAt(date);
		transactionRow3.setUpdatedAt(date);
		transactionRow3.setBranchId(memorandumDetails.getBranchId());
		transactionRow3.setSide("CR");
		transactionRow3.setAccountsInSide(1);
		transactionRow3.setTransactionId(transactions.getId());
		transactionRow3.setSchemeId(getSchemeID(accountIdForSGST9));
		transactionRow3.setBalanceSheetId(getBalanceSheetID(accountIdForSGST9));
		transactionRow3.setVoucherNo(transactions.getVoucherNo().longValue());
		transactionRowRepo.save(transactionRow3);

		Integer accountIdForCGST9 = accountsRepo.getAccountIdForCGST9(memorandumDetails.getBranchId());
		transactionRow4.setAccountId(accountIdForCGST9);
		transactionRow4.setTransactionTypeId(memorandumDetails.getMemorandumTypeId());
		transactionRow4.setStaffId(memorandumDetails.getStaffId());
		transactionRow4.setNarration(memorandumDetails.getNarration());
		transactionRow4.setAmountDr(BigDecimal.valueOf(0));
		transactionRow4.setAmountCr(BigDecimal.valueOf(CGST));
		transactionRow4.setCreatedAt(date);
		transactionRow4.setUpdatedAt(date);
		transactionRow4.setBranchId(memorandumDetails.getBranchId());
		transactionRow4.setSide("CR");
		transactionRow4.setAccountsInSide(1);
		transactionRow4.setTransactionId(transactions.getId());
		transactionRow4.setSchemeId(getSchemeID(accountIdForCGST9));
		transactionRow4.setBalanceSheetId(getBalanceSheetID(accountIdForCGST9));
		transactionRow4.setVoucherNo(transactions.getVoucherNo().longValue());
		transactionRowRepo.save(transactionRow4);
	}


	public void gstDeposite(MemorandumDetails memorandumDetails) {

		if(memorandumDetails.getAccountCr() == null){
			AccountDetails accountDetails = accountsRepo.getCashAccounts(memorandumDetails.getBranchId());
			memorandumDetails.setAccountCr(accountDetails.getId());
		}

		MemorandumTransactions memorandumTransactions = new MemorandumTransactions();
		MemorandumTransactionsrow memorandumTransactionsrow1= new MemorandumTransactionsrow();
		MemorandumTransactionsrow memorandumTransactionsrow2= new MemorandumTransactionsrow();

		memorandumTransactions.setStaffId(memorandumDetails.getStaffId());
		memorandumTransactions.setBranchId(memorandumDetails.getBranchId());
		memorandumTransactions.setName(0);
		memorandumTransactions.setMemorandumType(memorandumDetails.getMemorandumType());
		memorandumTransactions.setNarration(memorandumDetails.getNarration());
		memorandumTransactions.setCreatedAt(new Date());
		memorandumTransactionRepo.save(memorandumTransactions);

		memorandumTransactionsrow1.setMemorandumTransactionId(memorandumTransactions.getId());
		memorandumTransactionsrow1.setAccountId(memorandumDetails.getAccountDr());
		memorandumTransactionsrow1.setAmountDr(BigDecimal.valueOf(0));
		memorandumTransactionsrow1.setAmountCr(BigDecimal.valueOf(memorandumDetails.getAmount()));
		memorandumTransactionsrow1.setCreatedAt(new Date());
		memorandumTransactionsrow1.setTax("GST " + memorandumDetails.getTax());

		//Formula..
		Double baseAmount = (memorandumDetails.getAmount() * 100) / (100 + memorandumDetails.getTax());
		Double taxAmount = memorandumDetails.getAmount() - baseAmount;
		Double SGST = taxAmount/2;
		Double CGST = taxAmount/2;

		memorandumTransactionsrow1.setTaxAmount(BigDecimal.valueOf(taxAmount));
		memorandumTransactionsrow1.setTaxNarration("{\"SGST 9%\":" + SGST + ",\"CGST 9%\":" + CGST + "}");
		memorandumTransactionsrow1.setTaxPercentage(BigDecimal.valueOf(memorandumDetails.getTax()));
		memorandumTransactionsrow1.setTaxExcludedAmount(Double.toString(baseAmount));
		memorandomTransactionRowRepo.save(memorandumTransactionsrow1);

		memorandumTransactionsrow2.setMemorandumTransactionId(memorandumTransactions.getId());
		memorandumTransactionsrow2.setAccountId(memorandumDetails.getAccountCr());
		memorandumTransactionsrow2.setAmountDr(BigDecimal.valueOf(memorandumDetails.getAmount()));
		memorandumTransactionsrow2.setAmountCr(BigDecimal.valueOf(0));
		memorandumTransactionsrow2.setCreatedAt(new Date());
		memorandomTransactionRowRepo.save(memorandumTransactionsrow2);

		transactionMemorandum(memorandumDetails);

		DepositeDetails depositeDetails = new DepositeDetails();
		depositeDetails.setAcTo(memorandumDetails.getAccountDr());
		depositeDetails.setAcFrom(memorandumDetails.getAccountCr());
		depositeDetails.setAmount(memorandumDetails.getAmount());
		memorandumDetails.setNarration(memorandumDetails.getNarration2());
		depositeDetails.setNarration(memorandumDetails.getNarration());
		depositeDetails.setTransactionTypeId(memorandumDetails.getMemorandumTypeId());
		depositeDetails.setStaffId(memorandumDetails.getStaffId());
		depositeDetails.setBranchId(memorandumDetails.getBranchId());

		createTransactionsGST(depositeDetails, depositeDetails.getAcFrom(), depositeDetails.getAcTo(), depositeDetails.getTransactionTypeId(), depositeDetails.getAcTo(), depositeDetails.getBranchId());


	}

	public void generalGstDeposite(MemorandumDetails memorandumDetails) {

		Transactions transactions = new Transactions();
		TransactionRow transactionRow1 = new TransactionRow();
		TransactionRow transactionRow2 = new TransactionRow();
		TransactionRow transactionRow3 = new TransactionRow();
		TransactionRow transactionRow4 = new TransactionRow();

		transactions.setTransactionTypeId(memorandumDetails.getMemorandumTypeId());
		transactions.setStaffId(memorandumDetails.getStaffId());
		transactions.setNarration(memorandumDetails.getNarration());
		Date date = new Date();
		transactions.setCreatedAt(date);
		transactions.setUpdatedAt(date);
		transactions.setBranchId(memorandumDetails.getBranchId());
		transactions.setVoucherNo(BigDecimal.valueOf(getVoucherNo(memorandumDetails.getAccountDr())));
		transactions.setReferenceId(memorandumDetails.getAccountDr());
		Integer lastInvoiceNo = transactionsRepo.getLastInvoiceNo();
		transactions.setInvoiceNo(1+lastInvoiceNo);
		transactions.setIsSaleInvoice((byte)1);
		transactionsRepo.save(transactions);

		//Formula..
		Double baseAmount = (memorandumDetails.getAmount() * 100) / (100 + memorandumDetails.getTax());
		Double taxAmount = memorandumDetails.getAmount() - baseAmount;
		Double SGST = taxAmount/2;
		Double CGST = taxAmount/2;

		transactionRow1.setAccountId(memorandumDetails.getAccountDr());
		transactionRow1.setTransactionTypeId(memorandumDetails.getMemorandumTypeId());
		transactionRow1.setStaffId(memorandumDetails.getStaffId());
		transactionRow1.setNarration(memorandumDetails.getNarration());
		transactionRow1.setAmountDr(BigDecimal.valueOf(memorandumDetails.getAmount()));
		transactionRow1.setAmountCr(BigDecimal.valueOf(0));
		transactionRow1.setCreatedAt(date);
		transactionRow1.setUpdatedAt(date);
		transactionRow1.setBranchId(memorandumDetails.getBranchId());
		transactionRow1.setSide("DR");
		transactionRow1.setAccountsInSide(1);
		transactionRow1.setTransactionId(transactions.getId());
		transactionRow1.setSchemeId(getSchemeID(memorandumDetails.getAccountDr()));
		transactionRow1.setBalanceSheetId(getBalanceSheetID(memorandumDetails.getAccountDr()));
		transactionRow1.setVoucherNo(transactions.getVoucherNo().longValue());
		transactionRowRepo.save(transactionRow1);

		transactionRow2.setAccountId(memorandumDetails.getAccountCr());
		transactionRow2.setTransactionTypeId(memorandumDetails.getMemorandumTypeId());
		transactionRow2.setStaffId(memorandumDetails.getStaffId());
		transactionRow2.setNarration(memorandumDetails.getNarration());
		transactionRow2.setAmountDr(BigDecimal.valueOf(0));
		transactionRow2.setAmountCr(BigDecimal.valueOf(baseAmount));
		transactionRow2.setCreatedAt(date);
		transactionRow2.setUpdatedAt(date);
		transactionRow2.setBranchId(memorandumDetails.getBranchId());
		transactionRow2.setSide("CR");
		transactionRow2.setAccountsInSide(1);
		transactionRow2.setTransactionId(transactions.getId());
		transactionRow2.setSchemeId(getSchemeID(memorandumDetails.getAccountCr()));
		transactionRow2.setBalanceSheetId(getBalanceSheetID(memorandumDetails.getAccountCr()));
		transactionRow2.setVoucherNo(transactions.getVoucherNo().longValue());
		transactionRowRepo.save(transactionRow2);

		Integer accountIdForSGST9 = accountsRepo.getAccountIdForSGST9(memorandumDetails.getBranchId());
		transactionRow3.setAccountId(accountIdForSGST9);
		transactionRow3.setTransactionTypeId(memorandumDetails.getMemorandumTypeId());
		transactionRow3.setStaffId(memorandumDetails.getStaffId());
		transactionRow3.setNarration(memorandumDetails.getNarration());
		transactionRow3.setAmountDr(BigDecimal.valueOf(0));
		transactionRow3.setAmountCr(BigDecimal.valueOf(SGST));
		transactionRow3.setCreatedAt(date);
		transactionRow3.setUpdatedAt(date);
		transactionRow3.setBranchId(memorandumDetails.getBranchId());
		transactionRow3.setSide("CR");
		transactionRow3.setAccountsInSide(1);
		transactionRow3.setTransactionId(transactions.getId());
		transactionRow3.setSchemeId(getSchemeID(accountIdForSGST9));
		transactionRow3.setBalanceSheetId(getBalanceSheetID(accountIdForSGST9));
		transactionRow3.setVoucherNo(transactions.getVoucherNo().longValue());
		transactionRowRepo.save(transactionRow3);

		Integer accountIdForCGST9 = accountsRepo.getAccountIdForCGST9(memorandumDetails.getBranchId());
		transactionRow4.setAccountId(accountIdForCGST9);
		transactionRow4.setTransactionTypeId(memorandumDetails.getMemorandumTypeId());
		transactionRow4.setStaffId(memorandumDetails.getStaffId());
		transactionRow4.setNarration(memorandumDetails.getNarration());
		transactionRow4.setAmountDr(BigDecimal.valueOf(0));
		transactionRow4.setAmountCr(BigDecimal.valueOf(CGST));
		transactionRow4.setCreatedAt(date);
		transactionRow4.setUpdatedAt(date);
		transactionRow4.setBranchId(memorandumDetails.getBranchId());
		transactionRow4.setSide("CR");
		transactionRow4.setAccountsInSide(1);
		transactionRow4.setTransactionId(transactions.getId());
		transactionRow4.setSchemeId(getSchemeID(accountIdForCGST9));
		transactionRow4.setBalanceSheetId(getBalanceSheetID(accountIdForCGST9));
		transactionRow4.setVoucherNo(transactions.getVoucherNo().longValue());
		transactionRowRepo.save(transactionRow4);
	}

	public void createTransactionsGST(DepositeDetails depositeDetails, Integer acFrom, Integer acTo,  Integer JVtype, Integer idForVoucher, Integer branchId) {
		Transactions transactions = new Transactions();
		transactions.setTransactionTypeId(JVtype);
		transactions.setStaffId(depositeDetails.getStaffId());
		transactions.setNarration(depositeDetails.getNarration());
		System.out.println(depositeDetails.getNarration());
		Date date = new Date();
		transactions.setCreatedAt(date);
		transactions.setUpdatedAt(date);
		transactions.setReferenceId(acTo);
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

    public List<AccountDetails> getWithdrawAccounts(String accountNumber) {
		List<AccountDetails> list = accountsRepo.getWithdrawAccounts(accountNumber);
		if (list.size() != 0) {
			return list;
		} else {
			return new ArrayList<AccountDetails>();
		}
    }

	public List<AccountDetails> getForClosedAccounts(String accountNumber) {
		List<AccountDetails> list = accountsRepo.getForClosedAccounts(accountNumber);
		if (list.size() != 0) {
			return list;
		} else {
			return new ArrayList<AccountDetails>();
		}
	}


	public Transactions createSingleTransaction(DepositeDetails depositeDetails, Integer JVtype, Integer idForVoucher, Integer branchId){
		Transactions transactions = new Transactions();
		transactions.setTransactionTypeId(JVtype); //Need to change for correct
		transactions.setStaffId(depositeDetails.getStaffId());
		transactions.setNarration(depositeDetails.getNarration());
		System.out.println(depositeDetails.getNarration());
		Date date = new Date();
		transactions.setCreatedAt(date);
		transactions.setUpdatedAt(date);
		transactions.setBranchId(branchId);
		transactions.setVoucherNo(BigDecimal.valueOf(getVoucherNo(idForVoucher)));
		transactionsRepo.save(transactions);
		return transactions;
	}

	public void createSingleTransactionRowDr(DepositeDetails depositeDetails, Integer acFrom, Integer branchId, Transactions transactions){
		Date date = new Date();
		TransactionRow transactionRow = new TransactionRow();
		transactionRow.setAccountId(acFrom);
		transactionRow.setTransactionTypeId(transactions.getTransactionTypeId()); //Need to change
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
	}

	public void createSingleTransactionRowCr(DepositeDetails depositeDetails, Integer acTo,  Transactions transactions){
		Date date = new Date();
		TransactionRow transactionRow2 = new TransactionRow();
		transactionRow2.setAccountId(acTo);
		transactionRow2.setTransactionTypeId(transactions.getTransactionTypeId());
		transactionRow2.setStaffId(depositeDetails.getStaffId());
		transactionRow2.setNarration(depositeDetails.getNarration());
		transactionRow2.setAmountDr(BigDecimal.valueOf(0));
		transactionRow2.setAmountCr(BigDecimal.valueOf(depositeDetails.getAmount()));
		transactionRow2.setCreatedAt(date);
		transactionRow2.setUpdatedAt(date);
		transactionRow2.setBranchId(transactions.getBranchId());
		transactionRow2.setSide("CR");
		transactionRow2.setAccountsInSide(1);
		transactionRow2.setTransactionId(transactions.getId());
		transactionRow2.setSchemeId(getSchemeID(depositeDetails.getAcTo()));
		transactionRow2.setBalanceSheetId(getBalanceSheetID(depositeDetails.getAcTo()));
		transactionRow2.setVoucherNo(transactions.getVoucherNo().longValue());
		transactionRowRepo.save(transactionRow2);
	}

	public IPreviewDetails getPreview(Integer accountId) {
		return accountsRepo.getPreview(accountId);
	}

	public void purchaseTransaction(PurchaseDetails purchaseDetails) {

		Double gst18 = 0.0;
		Double igst18 = 0.0;
		Double gst28 = 0.0;
		Double igst28 = 0.0;
		Double gst12 = 0.0;
		Double igst12 = 0.0;
		Double gst5 = 0.0;
		Double igst5 = 0.0;
		Double gst6 = 0.0;
		Double igst6 = 0.0;
		Double totalAmount = 0.0;

		Integer accountSGST14Id = 0;
		Integer accountCGST14Id = 0;
		Integer accountSGST9Id = 0;
		Integer accountCGST9Id = 0;
		Integer accountSGST6Id = 0;
		Integer accountCGST6Id = 0;
		Integer accountSGST2_5Id = 0;
		Integer accountCGST2_5Id = 0;
		Integer accountIGST18Id = 0;


		for(PurchaseItemDetail pid:purchaseDetails.getItems()){
			if(pid.getTaxType().equals("GST 18%")){
				gst18 += pid.getTaxAmount();
				accountCGST9Id = accountsRepo.getAccountIdForCGST9(purchaseDetails.getBranchId());
				accountSGST9Id = accountsRepo.getAccountIdForSGST9(purchaseDetails.getBranchId());
			}
			if(pid.getTaxType().equals("IGST 18%")){
				igst18 += pid.getTaxAmount();
				accountIGST18Id = accountsRepo.getAccountIdForIGST18(purchaseDetails.getBranchId());
			}
			if(pid.getTaxType().equals("GST 28%")){
				gst28 += pid.getTaxAmount();
				accountCGST14Id = accountsRepo.getAccountIdForCGST14(purchaseDetails.getBranchId());
				accountSGST14Id = accountsRepo.getAccountIdForSGST14(purchaseDetails.getBranchId());
			}
			if(pid.getTaxType().equals("IGST 28%")){
				igst28 += pid.getTaxAmount();
			}
			if(pid.getTaxType().equals("GST 12%")){
				gst12 += pid.getTaxAmount();
				accountCGST6Id = accountsRepo.getAccountIdForCGST6(purchaseDetails.getBranchId());
				accountSGST6Id = accountsRepo.getAccountIdForSGST6(purchaseDetails.getBranchId());
			}
			if(pid.getTaxType().equals("IGST 12%")){
				igst12 += pid.getTaxAmount();
			}
			if(pid.getTaxType().equals("GST 5%")){
				gst5 += pid.getTaxAmount();
				accountCGST2_5Id = accountsRepo.getAccountIdForCGST2_5(purchaseDetails.getBranchId());
				accountSGST2_5Id = accountsRepo.getAccountIdForSGST2_5(purchaseDetails.getBranchId());
			}
			if(pid.getTaxType().equals("IGST 5%")){
				igst5 += pid.getTaxAmount();
			}
			if(pid.getTaxType().equals("GST 6%")){
				gst6 += pid.getTaxAmount();
			}
			if(pid.getTaxType().equals("IGST 6%")){
				igst6 += pid.getTaxAmount();
			}

			totalAmount += pid.getTaxIncludedAmount();
		}

		Transactions transactions = new Transactions();
		transactions.setTransactionTypeId(purchaseDetails.getTransactionTypeId());
		transactions.setStaffId(purchaseDetails.getStaffId());
		transactions.setNarration(purchaseDetails.getNarration());
		Date date = new Date();
		transactions.setCreatedAt(date);
		transactions.setUpdatedAt(date);
		transactions.setBranchId(purchaseDetails.getBranchId());
		transactions.setVoucherNo(BigDecimal.valueOf(getVoucherNo(purchaseDetails.getSupplierId())));
		transactions.setReferenceId(purchaseDetails.getSupplierId());
		Integer lastInvoiceNo = transactionsRepo.getLastInvoiceNo();
		transactions.setInvoiceNo(1+lastInvoiceNo);
		transactions.setIsSaleInvoice((byte)1);
		transactionsRepo.save(transactions);

		for(PurchaseItemDetail pid:purchaseDetails.getItems()){
			TransactionRow transactionRow1 = new TransactionRow();
			transactionRow1.setAccountId(pid.getPurchaseAccountId());
			transactionRow1.setTransactionTypeId(purchaseDetails.getTransactionTypeId());
			transactionRow1.setStaffId(purchaseDetails.getStaffId());
			transactionRow1.setNarration(purchaseDetails.getNarration());
			transactionRow1.setAmountDr(BigDecimal.valueOf(pid.getTaxExcludedAmount()));
			transactionRow1.setAmountCr(BigDecimal.valueOf(0));
			transactionRow1.setCreatedAt(date);
			transactionRow1.setUpdatedAt(date);
			transactionRow1.setBranchId(purchaseDetails.getBranchId());
			transactionRow1.setSide("DR");
			transactionRow1.setAccountsInSide(1);
			transactionRow1.setTransactionId(transactions.getId());
			transactionRow1.setSchemeId(getSchemeID(pid.getPurchaseAccountId()));
			transactionRow1.setBalanceSheetId(getBalanceSheetID(pid.getPurchaseAccountId()));
			transactionRow1.setVoucherNo(transactions.getVoucherNo().longValue());
			transactionRowRepo.save(transactionRow1);
		}

		if(accountSGST14Id != 0){
			DepositeDetails depositeDetails = new DepositeDetails();
			depositeDetails.setAmount(gst28/2.0);
			depositeDetails.setStaffId(purchaseDetails.getStaffId());
			depositeDetails.setNarration(purchaseDetails.getNarration());
			depositeDetails.setLoginBranch(purchaseDetails.getBranchId());
			depositeDetails.setBranchId(purchaseDetails.getBranchId());
			depositeDetails.setAcFrom(accountSGST14Id);
			createSingleTransactionRowDr(depositeDetails, accountSGST14Id,  purchaseDetails.getBranchId(), transactions);
			createSingleTransactionRowDr(depositeDetails, accountCGST14Id,  purchaseDetails.getBranchId(), transactions);
		}
		if(accountSGST9Id != 0){
			DepositeDetails depositeDetails = new DepositeDetails();
			depositeDetails.setAmount(gst18/2.0);
			depositeDetails.setStaffId(purchaseDetails.getStaffId());
			depositeDetails.setNarration(purchaseDetails.getNarration());
			depositeDetails.setLoginBranch(purchaseDetails.getBranchId());
			depositeDetails.setBranchId(purchaseDetails.getBranchId());
			depositeDetails.setAcFrom(accountSGST9Id);
			createSingleTransactionRowDr(depositeDetails, accountSGST9Id,  purchaseDetails.getBranchId(), transactions);
			createSingleTransactionRowDr(depositeDetails, accountCGST9Id,  purchaseDetails.getBranchId(), transactions);
		}
		if(accountSGST6Id != 0){
			DepositeDetails depositeDetails = new DepositeDetails();
			depositeDetails.setAmount(gst12/2.0);
			depositeDetails.setStaffId(purchaseDetails.getStaffId());
			depositeDetails.setNarration(purchaseDetails.getNarration());
			depositeDetails.setLoginBranch(purchaseDetails.getBranchId());
			depositeDetails.setBranchId(purchaseDetails.getBranchId());
			depositeDetails.setAcFrom(accountSGST6Id);
			createSingleTransactionRowDr(depositeDetails, accountSGST6Id,  purchaseDetails.getBranchId(), transactions);
			createSingleTransactionRowDr(depositeDetails, accountCGST6Id,  purchaseDetails.getBranchId(), transactions);
		}
		if(accountSGST2_5Id != 0){
			DepositeDetails depositeDetails = new DepositeDetails();
			depositeDetails.setAmount(gst5/2.0);
			depositeDetails.setStaffId(purchaseDetails.getStaffId());
			depositeDetails.setNarration(purchaseDetails.getNarration());
			depositeDetails.setLoginBranch(purchaseDetails.getBranchId());
			depositeDetails.setBranchId(purchaseDetails.getBranchId());
			depositeDetails.setAcFrom(accountSGST2_5Id);
			createSingleTransactionRowDr(depositeDetails, accountSGST2_5Id,  purchaseDetails.getBranchId(), transactions);
			createSingleTransactionRowDr(depositeDetails, accountCGST2_5Id,  purchaseDetails.getBranchId(), transactions);
		}
		if(accountIGST18Id != 0){
			DepositeDetails depositeDetails = new DepositeDetails();
			depositeDetails.setAmount(igst18);
			depositeDetails.setStaffId(purchaseDetails.getStaffId());
			depositeDetails.setNarration(purchaseDetails.getNarration());
			depositeDetails.setLoginBranch(purchaseDetails.getBranchId());
			depositeDetails.setBranchId(purchaseDetails.getBranchId());
			depositeDetails.setAcFrom(accountIGST18Id);
			createSingleTransactionRowDr(depositeDetails, accountIGST18Id,  purchaseDetails.getBranchId(), transactions);
		}

		DepositeDetails depositeDetails = new DepositeDetails();
		depositeDetails.setAmount(totalAmount);
		depositeDetails.setStaffId(purchaseDetails.getStaffId());
		depositeDetails.setNarration(purchaseDetails.getNarration());
		depositeDetails.setLoginBranch(purchaseDetails.getBranchId());
		depositeDetails.setBranchId(purchaseDetails.getBranchId());
		depositeDetails.setAcTo(purchaseDetails.getSupplierId());
		createSingleTransactionRowCr(depositeDetails, purchaseDetails.getSupplierId(), transactions);

		//Final TDS Transaction..
		DepositeDetails deposit = new DepositeDetails();
		deposit.setAmount(purchaseDetails.getTdsAmount());
		deposit.setStaffId(purchaseDetails.getStaffId());
		deposit.setNarration(purchaseDetails.getNarration());
		deposit.setLoginBranch(purchaseDetails.getBranchId());
		deposit.setBranchId(purchaseDetails.getBranchId());
		Branches branches = branchesRepository.getOne(purchaseDetails.getBranchId());
		String branchCode = branches.getCode();
		Integer tdsAccountId = accountsRepo.getTDSaccountID(branchCode);

		deposit.setAcTo(tdsAccountId);
		deposit.setAcFrom(purchaseDetails.getSupplierId());
		deposit.setTransactionTypeId(purchaseDetails.getTransactionTypeId());
		createTransactions(deposit, deposit.getAcFrom(), deposit.getAcTo(), deposit.getTransactionTypeId(), deposit.getAcTo(), deposit.getBranchId());

	}

	public List<AccountDetail> getSuppliers(Integer branchId) {
		return accountsRepo.getSuppliers(branchId);
	}
}
	
	

	


