package com.service.banking.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;
import com.service.banking.hibernateEntity.Accounts;
import com.service.banking.hibernateEntity.AgentTds;
import com.service.banking.hibernateEntity.Agents;
import com.service.banking.hibernateEntity.Bank;
import com.service.banking.hibernateEntity.BankBranches;
import com.service.banking.hibernateEntity.Branches;
import com.service.banking.hibernateEntity.Documents;
import com.service.banking.hibernateEntity.MemorandumTransactions;
import com.service.banking.hibernateEntity.MemorandumTransactionsrow;
import com.service.banking.hibernateEntity.MoAccountAssociation;
import com.service.banking.hibernateEntity.MoAgentAssociation;
import com.service.banking.hibernateEntity.Mos;
import com.service.banking.hibernateEntity.Premiums;
import com.service.banking.hibernateEntity.Staffs;
import com.service.banking.hibernateEntity.Teams;
import com.service.banking.hibernateEntity.Telecaller;
import com.service.banking.hibernateEntity.TelecallerAccountHistory;
import com.service.banking.hibernateEntity.TransactionRow;
import com.service.banking.hibernateEntity.Transactions;
import com.service.banking.model.dashboardModel.DailyDueResultModel;
import com.service.banking.model.dashboardModel.iAccountDetails;
import com.service.banking.model.hodAuthorityModel.AccountAndMemberDetails;
import com.service.banking.model.hodAuthorityModel.AgentTdsDetail;
import com.service.banking.model.hodAuthorityModel.AssociationDetails;
import com.service.banking.model.hodAuthorityModel.BankBranchesDetails;
import com.service.banking.model.hodAuthorityModel.BranchDetails;
import com.service.banking.model.hodAuthorityModel.FilterMoAgentUpdateDetails;
import com.service.banking.model.hodAuthorityModel.IAgentTdsDetail;
import com.service.banking.model.hodAuthorityModel.IBranchDetails;
import com.service.banking.model.hodAuthorityModel.IInvoiceDetails;
import com.service.banking.model.hodAuthorityModel.InvoiceDetails;
import com.service.banking.model.hodAuthorityModel.LockUnlockAcntDetails;
import com.service.banking.model.hodAuthorityModel.LogCheckDetails;
import com.service.banking.model.hodAuthorityModel.LogCheckModel;
import com.service.banking.model.hodAuthorityModel.LogCheckReq;
import com.service.banking.model.hodAuthorityModel.MemoRandomTransactionRowDetails;
import com.service.banking.model.hodAuthorityModel.MemorandomTransactionDetails;
import com.service.banking.model.hodAuthorityModel.MoRoDetails;
import com.service.banking.model.hodAuthorityModel.ODLimitsDetails;
import com.service.banking.model.hodAuthorityModel.PremiumDetails;
import com.service.banking.model.hodAuthorityModel.TeleCallerHistoryDetails;
import com.service.banking.model.hodAuthorityModel.TransactionRowDetails;
import com.service.banking.model.hodAuthorityModel.UnlockAccountsDetails;
import com.service.banking.model.hodAuthorityModel.changeMoDetail;
import com.service.banking.model.hodAuthorityModel.iDeleteVoucherDetails;
import com.service.banking.model.superAdminModel.StaffModel;
import com.service.banking.repository.AccountsRepo.AccountsRepo;
import com.service.banking.repository.dashBoardRepo.AccountsOpenTodayRepo;
import com.service.banking.repository.hodAuthorityRepo.AgentsTdsRepo;
import com.service.banking.repository.hodAuthorityRepo.BankBranchRepo;
import com.service.banking.repository.hodAuthorityRepo.BankListRepo;
import com.service.banking.repository.hodAuthorityRepo.BranchRepo;
import com.service.banking.repository.hodAuthorityRepo.DocumentsMangmntRepo;
import com.service.banking.repository.hodAuthorityRepo.LogCheckRepo;
import com.service.banking.repository.hodAuthorityRepo.MemoRandomRepo;
import com.service.banking.repository.hodAuthorityRepo.MemorandomTransactionRowRepo;
import com.service.banking.repository.hodAuthorityRepo.MoAssociationRepo;
import com.service.banking.repository.hodAuthorityRepo.MoRoRepository;
import com.service.banking.repository.hodAuthorityRepo.PremuimRepo;
import com.service.banking.repository.hodAuthorityRepo.RoAssociationsRepo;
import com.service.banking.repository.hodAuthorityRepo.TeamRepository;
import com.service.banking.repository.hodAuthorityRepo.TelecallerHistoryRepo;
import com.service.banking.repository.hodAuthorityRepo.TelecallerMangntRepo;
import com.service.banking.repository.hodAuthorityRepo.TransactionRepo;
import com.service.banking.repository.hodAuthorityRepo.memberRepository;
import com.service.banking.repository.madRepository.AgentsRepositoty;
import com.service.banking.repository.superAdminRepo.StaffRepo;
import com.service.banking.repository.transaction.TransactionRowRepo;
import com.service.banking.utils.DateFormater;


@Service
public class HodAuthorityService {

	@Autowired
	TeamRepository teamRepository;

	@Autowired
	MoRoRepository moroRepo;

	@Autowired
	BranchRepo branchRepo;

	@Autowired
	MoAssociationRepo moAssociationRepo;

	@Autowired
	RoAssociationsRepo roAssociationsRepo;

	@Autowired
	TelecallerMangntRepo telecallerMangntRepo;

	@Autowired
	TelecallerHistoryRepo telecallerHistoryRepo;

	@Autowired
	BankListRepo bankListRepo;

	@Autowired
	BankBranchRepo bankBranchRepo;

	@Autowired
	DocumentsMangmntRepo documentsMangmntRepo;

	@Autowired
	AccountsOpenTodayRepo accountsOpenTodayRepo;

	@Autowired
	PremuimRepo premiumRepo;

	@Autowired
	LogCheckRepo logCheckRepo;

	@Autowired
	TransactionRepo transactionRepo;

	@Autowired
	MemoRandomRepo memoRandomRepo;

	@Autowired
	AgentsTdsRepo agentsTdsRepo;
	
	@Autowired
	AccountsRepo accountsRepo;
	
	@Autowired
	memberRepository memberRepository;
	
	@Autowired
	AgentsRepositoty agentsRepo;
	
	@Autowired
	TransactionRowRepo transactionRowRepo;
	
	@Autowired
	StaffRepo staffRepo;
	
	@Autowired
	MemorandomTransactionRowRepo memorandomTransactionRowRepo;

	// get mo and ro list................
	public List<MoRoDetails> getMoRo() {
		List<MoRoDetails> moroList = moroRepo.getMoRoDetails();
		if (moroList.size() != 0) {
			return moroList;
		}
		return moroList;

	}

	// get BRANCHES FOR MO agents update ...............
	public List<BranchDetails> getAllBranches() {
		List<BranchDetails> branches = branchRepo.getAllBranches();
		if (branches.size() != 0) {
			return branches;
		} else {
			return new ArrayList<BranchDetails>();
		}

	}

	// get mo agents update mo details ................
	public List<MoRoDetails> getAllMo() {
		List<MoRoDetails> allMo = moroRepo.getMos();
		if (allMo.size() != 0) {
			return allMo;
		} else {
			return new ArrayList<MoRoDetails>();
		}

	}

	// get all mo associations.............................
	public List<AssociationDetails> getMoAssociation() {
		List<AssociationDetails> moAssociationsList = moAssociationRepo.getAllMoAssociation();
		if (moAssociationsList.size() != 0) {
			return moAssociationsList;
		} else {
			return new ArrayList<AssociationDetails>();
		}

	}

	// get all ro associations.............................
		public Map<String, Object> getRoAssociation(Integer setPageNumber, Integer setMaxResults) {
			Pageable paging = PageRequest.of(setPageNumber, setMaxResults);
			Page<AssociationDetails> roAssociationsList = roAssociationsRepo.getAllRoAssociation(paging);
			Map<String, Object> monthMap = new HashMap<String, Object>();
			if(roAssociationsList.hasContent()) {
				monthMap.put("pageSize", roAssociationsList.getSize());
				monthMap.put("totalElement", roAssociationsList.getTotalElements());
				monthMap.put("totalPage", roAssociationsList.getTotalPages());
				monthMap.put("ShareDetail", roAssociationsList.getContent());
				return monthMap;
			}
			else {
				return monthMap;
			}
		}
		
		public static Integer pageNumberr(Integer pageNmber) {
			if (pageNmber > 0) {
				return pageNmber - 1;
			} else {
				return pageNmber;
			}

		}

	// get all tellecaller .............................
	public List<Telecaller> getalltellecaller() {
		List<Telecaller> tellecallerList = telecallerMangntRepo.getTelecaller();
		if (tellecallerList.size() != 0) {
			return tellecallerList;
		} else {
			return new ArrayList<Telecaller>();
		}

	}

	// get all tellecaller history.............................
		public Map<String, Object> getAllTelecallerHistiory(Integer setPageNumber, Integer setMaxResults) {
			Pageable pageable = PageRequest.of(setPageNumber, setMaxResults);
			Page<TeleCallerHistoryDetails> tellecallerHistory = telecallerHistoryRepo.telecallerHistory(pageable);
			Map<String, Object> monthMap = new HashMap<String, Object>();
			if(tellecallerHistory.hasContent()) {
				monthMap.put("pageSize", tellecallerHistory.getSize());
				monthMap.put("totalElement", tellecallerHistory.getTotalElements());
				monthMap.put("totalPage", tellecallerHistory.getTotalPages());
				monthMap.put("ShareDetail", tellecallerHistory.getContent());
				return monthMap;
			}
			else {
				return monthMap;
			}
			
		}

	// get all premium ............................
		public Map<String, Object> getAllPremiums(Integer setPageNumber, Integer setMaxResults) {
			Pageable pageable = PageRequest.of(setPageNumber, setMaxResults);
			Page<PremiumDetails> premiumDetails = premiumRepo.allPremiums(pageable);
			Map<String, Object> monthMap = new HashMap<String, Object>();
			if(premiumDetails.hasContent()) {
				monthMap.put("pageSize", premiumDetails.getSize());
				monthMap.put("totalElement", premiumDetails.getTotalElements());
				monthMap.put("totalPage", premiumDetails.getTotalPages());
				monthMap.put("ShareDetail", premiumDetails.getContent());
				return monthMap;
			}
			else {
				return monthMap;
			}
			
		}
	
	
	//Get Premiums....
		public List<PremiumDetails> getPremiums(String accountNumber) {
			List<PremiumDetails> premiumDetails1=premiumRepo.getByAccountNumber(accountNumber);
			if (premiumDetails1.size() != 0) {
				return premiumDetails1;
			} else {
				return new ArrayList<PremiumDetails>();
			}
		}	
		
	
	
	// get all xlog details ............................
	public List<LogCheckDetails> getallXlog(LogCheckReq logCheckReq) {
		
		//Page<LogCheckDetails> logCheckDetails = logCheckRepo.alllogCheck();
		/*
		 * if (logCheckDetails.hasContent()) { return logCheckDetails.getContent();
		 * 
		 * } else { return new ArrayList<LogCheckDetails>(); }
		 */

		// To get proper date format.........
		DateFormater dateformater = new DateFormater();
		Date fromDate= dateformater.getFromatDate(logCheckReq.getFromDate());
		Date toDate= dateformater.getFromatDate(logCheckReq.getToDate());
		List<LogCheckDetails> xlogList = logCheckRepo.alllogCheck(fromDate,toDate);
		  if (xlogList.size() != 0) 
		  { 
			  return xlogList; 
			  } 
		  else
			  {
			  return new ArrayList<LogCheckDetails>(); 
		  
		  }
		 

	}
	
	// get all xlog details ............................
		public List<LogCheckModel> getLogCheckModel() {
			
			
			List<LogCheckModel> xlogList = logCheckRepo.logCheckModel();
			 if (xlogList.size() != 0) 
			 { 
				 return xlogList;
			 }
			 else { 
				 return new ArrayList<LogCheckModel>();
				 
			 }
			 

		}

	//Extra
	public List<UnlockAccountsDetails> getLockUnlockDetails() {
		List<UnlockAccountsDetails> lockunlockDetails = accountsOpenTodayRepo.getAccountsDetails();
		if (lockunlockDetails.size() != 0) {
			return lockunlockDetails;
		} else {
			return new ArrayList<UnlockAccountsDetails>();
		}

	}

	// get all transactions.....

	// get all transaction details ............................
	public List<Transactions> getTransactions() {
		List<Transactions> transactions = transactionRepo.allTransactions();
		if (transactions.size() != 0) {
			return transactions;
		} else {
			return new ArrayList<Transactions>();
		}

	}

	// get all memorandom details ............................
	public List<MemorandumTransactions> getMemorandoms() {
		List<MemorandumTransactions> memeRandom = memoRandomRepo.allMemorandoms();
		if (memeRandom.size() != 0) {
			return memeRandom;
		} else {
			return new ArrayList<MemorandumTransactions>();
		}

	}

	// get all agentTds details ............................
	public List<AgentTds> getAllAgentdTds() {
		List<AgentTds> agentTds = agentsTdsRepo.allAgentTds();
		if (agentTds.size() != 0) {
			return agentTds;
		} else {
			return new ArrayList<AgentTds>();
		}

	}

	// get team list.................
	public List<Teams> getTeams() {
		List<Teams> teams = teamRepository.getAllTeam();
		if (teams.size() != 0) {
			return teams;
		} else {
			return new ArrayList<Teams>();

		}
	}

	//Edit team....
	public void updateTeam(Teams teams) {
		teamRepository.save(teams);	
	}

	//Add team....
	public void addTeam(Teams teams) {
		teamRepository.save(teams);	
	}

	//Delete team....
	public String deleteTeam(Integer id) {
		try {
			teamRepository.deleteById(id);
			
			}
			catch(Exception e)
			{
				return "Try again after sometime"+e;
			}
			return "Item Deleted Successfully";
		}

	//Get all document............................
	public List<Documents> getAllDocument() {
		List<Documents> documents = documentsMangmntRepo.allDocument();
		if (documents.size() != 0) {
			return documents;
		} else {
			return new ArrayList<Documents>();
		}

	}
	
	//Update Documents....
	public void updateDocuments(Documents documents) {
		documentsMangmntRepo.save(documents);	
		
	}

	//Add Documents....
	public void addDocuments(Documents documents) {
		documentsMangmntRepo.save(documents);
		
	}

	//Delete Documents....
	public String deleteDocuments(Integer id) {
		try {
			documentsMangmntRepo.deleteById(id);	
			}
			catch(Exception e)
			{
				return "Try again after sometime"+e;
			}
			return "Item Deleted Successfully";
		
		
	}
	
	//Get all bank list....
	public List<Bank> getAllBank() {
		List<Bank> bankList = bankListRepo.bankList();
		if (bankList.size() != 0) {
			return bankList;
		} else {
			return new ArrayList<Bank>();
		}
	}
	
	//Get all bank branches list....
	public List<BankBranchesDetails> getAllBankBranche(int bankId) {
		List<BankBranchesDetails> bankBranches = bankBranchRepo.bankBranches(bankId);
		if (bankBranches.size() != 0) {
			return bankBranches;
		} else {
			return new ArrayList<BankBranchesDetails>();
		}
	}
	
	
	//Edit Bank....
	public void updateBank(Bank bank) {
		bankListRepo.save(bank);
		
	}

	//Add Bank....
	public void addBank(Bank bank) {
		bankListRepo.save(bank);
		
	}

	//Delete Bank....
	public String deleteBank(Integer id) {
		
		try {
			bankListRepo.deleteById(id);
			}
			catch(Exception e)
			{
				return "Try again after sometime"+e;
			}
			return "Item Deleted Successfully";
	}
	
	//Edit Bank Branch....
	public void updateBankBranch(BankBranches bank) {
		bankBranchRepo.save(bank);
	}

	//Add Bank Branch....
	public void addBankBranch(BankBranches bank) {
		bankBranchRepo.save(bank);
	}

	//Delete bank Branch....
	public String  deleteBankBranch(Integer id) {
		try {
			bankBranchRepo.deleteById(id);	
			}
			catch(Exception e)
			{
				return "Try again after sometime"+e;
			}
			return "Item Deleted Successfully";
		
	}

	// get all OD LIMIT............................
	public List<ODLimitsDetails> getodLimit() {
		List<ODLimitsDetails> odLimits = accountsOpenTodayRepo.getOdLimits();
		if (odLimits.size() != 0) {
			return odLimits;
		} else {
			return new ArrayList<ODLimitsDetails>();
		}

	}

	//Update OD limit
	public void updateODLimit(ODLimitsDetails odlimitsDetails) {
		Accounts accounts=accountsOpenTodayRepo.getOne(odlimitsDetails.getId());
		accounts.setBankAccountLimit(odlimitsDetails.getBankAccountLimit());	
		System.out.println(odlimitsDetails.getBankAccountLimit());
		accountsOpenTodayRepo.save(accounts);
	}


	// get all lock/unlock details ............................
	public List<LockUnlockAcntDetails> getUnlockDetails(String accountNumber) {
		List<LockUnlockAcntDetails> lockUnlock = accountsOpenTodayRepo.getAccounts(accountNumber);
		if (lockUnlock.size() != 0) {
			return lockUnlock;
		} else {
			return new ArrayList<LockUnlockAcntDetails>();
		}
	}
	
	public void updateLockingStatus(LockUnlockAcntDetails lockUnlockAcntDetails) {
		Accounts accounts=accountsOpenTodayRepo.getOne(lockUnlockAcntDetails.getAccountId());
		accounts.setLockingStatus(lockUnlockAcntDetails.getLockingStatus());
		accounts.setLockStatusChangedReason(lockUnlockAcntDetails.getLockReason());
		accountsOpenTodayRepo.save(accounts);
	}
	
	public void updateActiveStatus(LockUnlockAcntDetails lockUnlockAcntDetails) {
		Accounts accounts=accountsOpenTodayRepo.getOne(lockUnlockAcntDetails.getAccountId());
		accounts.setActiveStatus(lockUnlockAcntDetails.getIsActive());
		accountsOpenTodayRepo.save(accounts);
	}

	public void updateMaturedStatus(LockUnlockAcntDetails lockUnlockAcntDetails) {
		Accounts accounts=accountsOpenTodayRepo.getOne(lockUnlockAcntDetails.getAccountId());
		accounts.setMaturedStatus(lockUnlockAcntDetails.getMaturedStatus());
		accountsOpenTodayRepo.save(accounts);		
	}

	public void updateMoro(MoRoDetails moroDetails) {
		Mos mos= moroRepo.getOne(moroDetails.getId());
		Branches branches=branchRepo.getOne(moroDetails.getBranchId());
		mos.setName(moroDetails.getMoName());
		mos.setIsActive(moroDetails.getIsActive());
		mos.setBranches(branches);
		moroRepo.save(mos);
	}

	public void addMoro(MoRoDetails moroDetails) {
		Mos mos= new Mos();
		Branches branches=branchRepo.getOne(moroDetails.getBranchId());
		mos.setName(moroDetails.getMoName());
		mos.setIsActive(moroDetails.getIsActive());
		mos.setBranches(branches);
		moroRepo.save(mos);
		
	}

	//Delete Mo/Ro List....
	public String deleteMoro(Integer id) {
		try {
		moroRepo.deleteById(id);	
		}
		catch(Exception e)
		{
			return "Try again after sometime"+e;
		}
		return "Item Deleted Successfully";
	}

	//Edit Telecallers....
	public void updateTelecaller(Telecaller telecaller) {
		telecallerMangntRepo.save(telecaller);		
	}

	//Add Telecallers....
	public void addTeleCaller(Telecaller telecaller) {
		telecallerMangntRepo.save(telecaller);
		
	}
	
	//Delete Telecaller....
		public String deleteTeleCaller(Integer id) {
			try {
			telecallerMangntRepo.deleteById(id);	
			}
			catch(Exception e)
			{
				return "Try again after sometime"+e;
			}
			return "Item Deleted Successfully";
		}
		
		
		// addMoAgentAssociationAdd................
		public void addMoAgentAssociationAdd(AssociationDetails details) {
			MoAgentAssociation maa = new MoAgentAssociation();
			maa.setMoId(details.getMoId());
			maa.setAgentId(details.getAgentId());
			maa.setFromDate(details.getFromDate());
			maa.setToDate(details.getToDate());
			moAssociationRepo.save(maa);
		}
		
		// update MoAgentAssociation..................
		public void updateMoAgentAssociation(AssociationDetails details) {
			MoAgentAssociation maa = moAssociationRepo.getOne(details.getId());
			maa.setAgentId(details.getAgentId());
			maa.setMoId(maa.getMoId());
			maa.setFromDate(details.getFromDate());
			maa.setToDate(details.getToDate());
			moAssociationRepo.save(maa);
		}
		
		// delete MoAgentAssociation...........................
		public String deleteMoAgentAssociation(int id) {
			try {
				moAssociationRepo.deleteById(id);
				
				}
				catch(Exception e)
				{
					return "Try again after sometime"+e;
				}
				return "Item Deleted Successfully";
		}
		
		// getfilterMoAssociationsMoDetails
		public List<AssociationDetails> getFilterMoAgentAssociationsDetails(Integer id) {
			List<AssociationDetails> moAssociationsList = moAssociationRepo.getMoAgentAssociationByMosId(id);
			if (moAssociationsList.size() != 0) {
				return moAssociationsList;
			} else {
				return new ArrayList<AssociationDetails>();
			}
		}
		
		// for add Mo accountAssociation button........
		public void addMoAccountAssociation(AssociationDetails details) {
			MoAccountAssociation maa = new MoAccountAssociation();
			maa.setMos(Optional.ofNullable(details.getMoId()).isPresent() ?  moroRepo.findById(details.getMoId()).orElse(null) : null);
			maa.setAccounts(Optional.ofNullable(details.getAccountId()).isPresent() ? accountsRepo.findById(details.getAccountId()).orElse(null) : null);
			maa.setFromDate(details.getFromDate());
			maa.setToDate(details.getToDate());
			roAssociationsRepo.save(maa);
		}
		
		// for update Mo accountAssociation button........
		public void updateMoAccountAssociation(AssociationDetails details) {
			MoAccountAssociation maa = roAssociationsRepo.getOne(details.getId());
			maa.setMos(Optional.ofNullable(details.getMoId()).isPresent() ?  moroRepo.findById(details.getMoId()).orElse(null) : null);
			maa.setAccounts(Optional.ofNullable(details.getAccountId()).isPresent() ? accountsRepo.findById(details.getAccountId()).orElse(null) : null);
			maa.setFromDate(details.getFromDate());
			maa.setToDate(details.getToDate());
			roAssociationsRepo.save(maa);
		}
		
		// for delete update Mo accountAssociation button........
			public String deleteMoAccountAssociation(int id) {
				try {
					roAssociationsRepo.deleteById(id);
					
					}
					catch(Exception e)
					{
						return "Try again after sometime"+e;
					}
					return "Item Deleted Successfully";
			}
			
			//getFilterRoAccountAssociation
			public List<AssociationDetails> getFilterRoAccountAssociation(Integer id){
				List<AssociationDetails> moAssociationsList = roAssociationsRepo.getRoAccountAssociationByMosId(id);
				if (moAssociationsList.size() != 0) {
					return moAssociationsList;
				} else {
					return new ArrayList<AssociationDetails>();
				}
			}
			
			
			// TeleCallerHistoryDetails
			// add TelecallerAccountHistory button Service from Telecaller History tab..........................
			public void addTeleCallerHistoryDetails(TeleCallerHistoryDetails details) {
				TelecallerAccountHistory telecallerAccountHistory = new TelecallerAccountHistory();
				telecallerAccountHistory.setAccountId(details.getAccountId());
				telecallerAccountHistory.setTelecallerId(details.getTelecallerId());
				telecallerAccountHistory.setFromDate(details.getFromDate());
				telecallerAccountHistory.setFinalToDate(details.getFinalToDate());
				telecallerHistoryRepo.save(telecallerAccountHistory);
			}
			
			// update TelecallerAccountHistory button Service from Telecaller History tab........................
			public void updateTelecallerAccountHistory(TeleCallerHistoryDetails details) {
				TelecallerAccountHistory telecallerAccountHistory = telecallerHistoryRepo.getOne(details.getId());
				telecallerAccountHistory.setAccountId(details.getAccountId());
				telecallerAccountHistory.setTelecallerId(details.getTelecallerId());
				telecallerAccountHistory.setFromDate(details.getFromDate());
				telecallerAccountHistory.setFinalToDate(details.getFinalToDate());
				telecallerHistoryRepo.save(telecallerAccountHistory);
			}

			// delete TelecallerAccountHistory button Service from Telecaller History tab........................
			public String deleteTelecallerAuthorityHistory(Integer id) {
				try {
					telecallerHistoryRepo.deleteById(id);	
					}
					catch(Exception e)
					{
						return "Try again after sometime"+e;
					}
					return "Item Deleted Successfully";
			}
			
			// Service for 'filter' button present inside 'Mo Agent Update' tab................
			public List<FilterMoAgentUpdateDetails> getFilterMoAgentUpdateDetails(Integer id) {
				List<FilterMoAgentUpdateDetails> filterMoAgentUpdateDetails = memberRepository.getFilterMoAgentUpdateDetails(id);
				return filterMoAgentUpdateDetails;
			}

			// three character suggestion service for 'Agent' that appears in 'Add MoAgentAssociation' tag pop up box....................
			public List<AssociationDetails> getMoAgentAssociationList(String names){
				String name = names.replaceAll("\\s", "");
				List<AssociationDetails> moAgentAssociationList = moAssociationRepo.getMoAgentAssociationList(name);
				if(moAgentAssociationList.size() == 0) {
					String[] s1 = names.split("\\s");
					List<AssociationDetails> moAgentAssociationSubList = new ArrayList<AssociationDetails>();
//					List<AssociationDetails> moAgentAssociationListArray = new ArrayList<AssociationDetails>();
					for(String nameList: s1) {
						if(!nameList.isEmpty()) {
							moAgentAssociationSubList =  moAssociationRepo.getMoAgentAssociationList(nameList);
							moAgentAssociationList.addAll(moAgentAssociationSubList);
						}
					}
				}
//				List<AssociationDetails> moAgentAssociationList = moAssociationRepo.getMoAgentAssociationList(name);
				return moAgentAssociationList;
			}
			
			// get telle-caller name for pop-up box that appears when Add TeleCallerAccountHistory button (from Telecaller History Edit tab) is pressed..................
			public List<Telecaller> getTellecallerList(String name){
				List<Telecaller> telecallerNew = telecallerMangntRepo.getTelecallerList(name);
				if(telecallerNew.size() !=0) {
					return telecallerNew;
				}
				return new ArrayList<Telecaller>();
			}
			
			// for Telecaller History Edit tab
			// get account and member details (Account number + Member name + Father name) for pop-up box that appears when Add TeleCallerAccountHistory button
			// (from Telecaller History Edit tab) is pressed.......................
			public List<AccountAndMemberDetails> getAccountAndMemberDetails(String name){
				name = name.replaceAll("\\s", "");
				List<AccountAndMemberDetails> accountAndMemberList = memberRepository.getAccountAndMemberList(name);
				return accountAndMemberList;
			}
			
			// get mo name by string............
			public List<AssociationDetails> getmoAssociationList(String name){
				name.replaceAll("\\s", "");
				List<AssociationDetails> accountAndMemberList = moroRepo.getmoAssociationList(name);
				return accountAndMemberList;
			}

			// three character suggestion service for 'Mo' that appears in 'Add MoAgentAssociation' tag pop up box....................
	public List<MoRoDetails> getMoList(String name) {
		List<MoRoDetails> moList = moroRepo.getMoList(name);
		System.out.println(moList);
		if (moList.size() != 0) {
			return moList;
		} else {
			return new ArrayList<MoRoDetails>();
		}
	}

	// account list only.....................
		public List<LockUnlockAcntDetails> getAccountList(String name){
			List<LockUnlockAcntDetails> accountList = accountsOpenTodayRepo.getAccountList(name);
			System.out.println("***************"+accountList.size());
			if(accountList.size() !=0) {
				return accountList;
			}
			else {
				return new ArrayList<LockUnlockAcntDetails>();
			}
		}

		// get account association details that appears in popup box when Add MoAccount Association is 
		//clicked which is inside Ro Associations inside MO/Ro Association Edit.............. 
		public List<AssociationDetails> getRoAccountAssociationList(String name){
			List<AssociationDetails> associationDetails = accountsRepo.getRoAccountAssociationList(name);
			return associationDetails;
		}

		public Map<String, Object> getAllAgentTds(Integer agentId, Integer accountId, Integer setPageNumber, Integer setMaxResults) {
			Pageable pageable = PageRequest.of(setPageNumber, setMaxResults);
			Page<AgentTdsDetail> agentTds = agentsTdsRepo.allAgentTds(agentId, accountId, pageable);
			Map<String, Object> monthMap = new HashMap<String, Object>();
			if(agentTds.hasContent()) {
				monthMap.put("pageSize", agentTds.getSize());
				monthMap.put("totalElement", agentTds.getTotalElements());
				monthMap.put("totalPage", agentTds.getTotalPages());
				monthMap.put("ShareDetail", agentTds.getContent());
				return monthMap;
			}
			else {
				return monthMap;
			}

		}

		// get filtered agentTds details............
		public Map<String, Object> getFilteredAgentTds(Integer agentId, Integer relatedAccountId, Integer setPageNumber, Integer setMaxResults){
			Pageable pageable = PageRequest.of(setPageNumber, setMaxResults);
			Page<IAgentTdsDetail> agentTds = agentsTdsRepo.getFilteredAgentTds(agentId, relatedAccountId, pageable);
			Map<String, Object> monthMap = new HashMap<String, Object>();
			if(agentTds.hasContent()) {
				monthMap.put("pageSize", agentTds.getSize());
				monthMap.put("totalElement", agentTds.getTotalElements());
				monthMap.put("totalPage", agentTds.getTotalPages());
				monthMap.put("ShareDetail", agentTds.getContent());
				return monthMap;
			}
			else {
				return monthMap;
			}
		}

		// add agentTds details............
		public void addAgentTds(AgentTdsDetail details) {
			AgentTds agtds = new AgentTds();
			Agents agents = agentsRepo.getOne(details.getAgentId());
			Accounts accounts = accountsRepo.getOne(details.getAccountId());
			agtds.setAccounts(accounts);
			agtds.setAgents(agents);
			agtds.setCreatedAt(details.getCreatedAt());
			agtds.setTotalCommission(details.getTotalCommission());
			agtds.setTds(details.getTds());
			agtds.setNetCommission(details.getNetCommission());
			agentsTdsRepo.save(agtds);
		}

		// update agentTds details............
	public void updateAgentTds(AgentTdsDetail details) {
		AgentTds agtds = agentsTdsRepo.getOne(details.getId());
		Agents agents = agentsRepo.getOne(details.getAgentId());
		Accounts accounts = accountsRepo.getOne(details.getAccountId());
		agtds.setAccounts(accounts);
		agtds.setAgents(agents);
		agtds.setCreatedAt(details.getCreatedAt());
		agtds.setTotalCommission(details.getTotalCommission());
		agtds.setTds(details.getTds());
		agtds.setNetCommission(details.getNetCommission());
		agentsTdsRepo.save(agtds);
	}

	// delete agentTds details...............
	public String deleteAgentTds(Integer id) {
		try {
			agentsTdsRepo.deleteById(id);

		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";
	}

	// get all invoice details..............
	public Map<String, Object> getInvoice(Integer setPageNumber, Integer setMaxResults){
		Pageable pageable = PageRequest.of(setPageNumber, setMaxResults);

		Page<IInvoiceDetails> list = transactionRepo.getInvoices(pageable);
		Map<String, Object> monthMap = new HashMap<String, Object>();
		if(list.hasContent()) {
			monthMap.put("pageSize", list.getSize());
			monthMap.put("totalElement", list.getTotalElements());
			monthMap.put("totalPage", list.getTotalPages());
			monthMap.put("ShareDetail", list.getContent());
			return monthMap;
		}
		else {
			return monthMap;
		}
	}
	
	// edit invoice...................
		public void updateInvoice(InvoiceDetails details) {
			Transactions transactions = transactionRepo.getOne(details.getId());
			transactions.setTransactionTypeId(details.getTransactionTypeId());
			transactions.setStaffId(details.getStaffId());
			transactions.setReferenceId(details.getReferenceAccountId());
			transactions.setBranchId(details.getBranchId());
			transactions.setVoucherNoOriginal(details.getVoucherNoOriginal());
			transactions.setVoucherNo(details.getVoucherNo());
			transactions.setNarration(details.getNarration());
			transactions.setCreatedAt(details.getCreatedAt());
			transactions.setUpdatedAt(details.getUpdatedAt());
			transactions.setInvoiceNo(details.getInvoiceNo());
			transactions.setIsInvoiceCancel(details.getIsInvoiceCancel());
			transactionRepo.save(transactions);
		}
			
		
		// API for "Detail" tab inside invoice tab...............
		public List<TransactionRowDetails> getTransactionRowForInvoice(Integer id) {
			List<TransactionRowDetails> transactionRowForInvoice = transactionRepo.getTransactionRowForInvoice(id);
			System.out.println("size:" + transactionRowForInvoice.size());
			if(transactionRowForInvoice.size() != 0) {
				return transactionRowForInvoice;
			}
			else {
				return new ArrayList<TransactionRowDetails>();
			}
		}
		
	//  API for add detail tab inside invoice tab.............
		public void addTransactionRowForInvoice(TransactionRowDetails details) {
			TransactionRow tr = new TransactionRow();
			tr.setTransactionId(details.getTransactionId());
			tr.setAccountId(details.getAccountId());
			tr.setSchemeId(details.getScemeId());
			tr.setBalanceSheetId(details.getBalanceId());
			tr.setAmountDr(details.getDebit());
			tr.setAmountCr(details.getCredit());
			tr.setSide(details.getSide());
			tr.setAccountsInSide(details.getAccountsInSide());
			tr.setCreatedAt(details.getCreatedAt());
			tr.setVoucherNo(details.getVoucherNo().longValue());
			tr.setNarration(details.getNarration());
			tr.setTransactionTypeId(details.getTransactionTypeId());
			tr.setBranchId(details.getBranchId());
			tr.setReferenceAccountId(details.getReferenceAccountId());
			transactionRowRepo.save(tr);
		}

	//  API for edit detail tab inside invoice tab.............
		public void updateTransactionRowForInvoice(TransactionRowDetails details) {
			TransactionRow tr = transactionRowRepo.getOne(details.getId());
			tr.setTransactionId(details.getTransactionId());
			tr.setAccountId(details.getAccountId());
			tr.setSchemeId(details.getScemeId());
			tr.setBalanceSheetId(details.getBalanceId());
			tr.setAmountDr(details.getDebit());
			tr.setAmountCr(details.getCredit());
			tr.setSide(details.getSide());
			tr.setAccountsInSide(details.getAccountsInSide());
			tr.setCreatedAt(details.getCreatedAt());
			tr.setUpdatedAt(new Date());
			tr.setVoucherNo(details.getVoucherNo().longValue());
			tr.setNarration(details.getNarration());
			tr.setTransactionTypeId(details.getTransactionTypeId());
			tr.setBranchId(details.getBranchId());
			tr.setReferenceAccountId(details.getReferenceAccountId());
			transactionRowRepo.save(tr);
		}

		// API for delete detail tab inside invoice tab............. 
		public String deleteTransactionRowForInvoice(Integer id) {
			try {
				transactionRowRepo.deleteById(id);
				
				}
				catch(Exception e)
				{
					return "Try again after sometime"+e;
				}
				return "Item Deleted Successfully";
		}
		
		// API for Invoicecancel inside Invoice tab...............
		public void cancelInvoice(Integer id) {
			Transactions transactions = transactionRepo.getOne(id);
			byte isInvoiceCancel = 1;
			transactions.setIsInvoiceCancel(isInvoiceCancel);
			transactionRepo.save(transactions);
		}

		// get all memorandom details ............................
		public Map<String, Object> getMemorandoms(Integer setPageNumber, Integer setMaxResults) {
			Pageable pageable = PageRequest.of(setPageNumber, setMaxResults);
			List<MemorandomTransactionDetails> conList = new ArrayList<MemorandomTransactionDetails>();
			Page<Object []> memoRandom = memoRandomRepo.getAllMemorandoms(pageable);
			
			for(Object[] ob: memoRandom) {
				MemorandomTransactionDetails legal = new MemorandomTransactionDetails();
				System.out.println("****** "+ ob.length);
				
//				Integer memorandumTransactionrowId, Integer staffId, String staffName,
//				Integer branchId, String branchName, Integer name, Integer memorandumType, String narration, Date createdAt,
//				BigDecimal amountCr, BigDecimal amountDr, String crAccountNumber, String drAccountNumber,
//				String crMemberName, String drMemberName, String crFatherName, String drFatherName, BigDecimal taxAmount,
//				Integer memorandomTransactionId
				
				legal.setMemorandumTransactionrowId(Optional.ofNullable(ob[0]).isPresent() ? (Integer)ob[0] : 0);
				legal.setStaffId(Optional.ofNullable(ob[1]).isPresent() ? (Integer)ob[1] : 0);
				legal.setStaffName(Optional.ofNullable(ob[2]).isPresent() ? ob[2].toString() : "");
				legal.setBranchId(Optional.ofNullable(ob[3]).isPresent() ? (Integer)ob[3] : 0);
				legal.setBranchName(Optional.ofNullable(ob[4]).isPresent() ? ob[4].toString() : "");
				legal.setName(Optional.ofNullable(ob[5]).isPresent() ? (Integer)ob[5] : 0);
				legal.setMemorandumType(Optional.ofNullable(ob[6]).isPresent() ? ob[6].toString() : "");
				legal.setNarration(Optional.ofNullable(ob[7]).isPresent() ? ob[7].toString() : "");
				legal.setCreatedAt(Optional.ofNullable(ob[8]).isPresent() ? (Date)ob[8] : null);
				legal.setAmountCr(Optional.ofNullable(ob[9]).isPresent() ? (BigDecimal)ob[9] : null);
				legal.setAmountDr(Optional.ofNullable(ob[10]).isPresent() ? (BigDecimal)ob[10] : null);
				legal.setCrAccountNumber(Optional.ofNullable(ob[11]).isPresent() ? ob[11].toString() : "");
				legal.setDrAccountNumber(Optional.ofNullable(ob[12]).isPresent() ? ob[12].toString() : "");
				legal.setCrMemberName(Optional.ofNullable(ob[13]).isPresent() ? ob[13].toString() : "");
				legal.setDrMemberName(Optional.ofNullable(ob[14]).isPresent() ? ob[14].toString() : "");
				legal.setCrFatherName(Optional.ofNullable(ob[15]).isPresent() ? ob[15].toString() : "");
				legal.setDrFatherName(Optional.ofNullable(ob[16]).isPresent() ? ob[16].toString() : "");
				
				legal.setTaxAmount(Optional.ofNullable(ob[17]).isPresent() ? (BigDecimal)ob[17] : null);
				legal.setMemorandomTransactionId(Optional.ofNullable(ob[18]).isPresent() ? (Integer)ob[18] : 0);
				String[] drAcNo = legal.getDrAccountNumber().split(", ");
				String[] drmName = legal.getDrMemberName().split(", ");
				String[] drfName = legal.getDrFatherName().split(", ");
				String demo = "";
				for(int i=0; i < drAcNo.length; i++) {
							String demo1 = drAcNo[i] + " : " + drmName[i] + " [ " + drfName[i] + " ] - ";
							demo += demo1;
				}
				legal.setDrAccountNo(demo);
				System.out.println(legal.getDrAccountNo());
				String[] crAcNo = legal.getCrAccountNumber().split(", ");
				String[] crmName = legal.getCrMemberName().split(", ");
				String[] crfName = legal.getCrFatherName().split(", ");
				demo = "";
				System.out.println("*******************");
				for(int i=0; i < crAcNo.length; i++) {
							String demo1 = crAcNo[i] + " : " + crmName[i] + " [ " + crfName[i] + " ] - ";
							demo += demo1;
				}
				legal.setCrAccountNo(demo);
				System.out.println(legal.getCrAccountNo());
				
				legal.setDrAccountNumber(null);
				legal.setDrMemberName(null);
				legal.setDrFatherName(null);
				legal.setCrAccountNumber(null);
				legal.setCrMemberName(null);
				legal.setCrFatherName(null);
				
				conList.add(legal);
			}
			System.out.print("***" + conList.size());
//			return conList;
			
			Map<String, Object> monthMap = new HashMap<String, Object>();
			if(memoRandom.hasContent()) {
				monthMap.put("pageSize", memoRandom.getSize());
				monthMap.put("totalElement", memoRandom.getTotalElements());
				monthMap.put("totalPage", memoRandom.getTotalPages());
				monthMap.put("ShareDetail", conList);
				return monthMap;
			}
			else {
				return monthMap;
			}
		}
		
		// add memorandoms................
		public void addMemorandoms(MemorandomTransactionDetails details) {
			MemorandumTransactions mt = new MemorandumTransactions();
			mt.setStaffId(details.getStaffId());
			Staffs staffs = staffRepo.getOne(details.getStaffId());
			mt.setBranchId(staffs.getBranchId());
			mt.setName(details.getName());
			mt.setMemorandumType(details.getMemorandumType());
			mt.setNarration(details.getNarration());
			mt.setCreatedAt(details.getCreatedAt());
			memoRandomRepo.save(mt);
		}
		
		// update memorandoms................
		public void updateMemorandoms(MemorandomTransactionDetails details) {
			MemorandumTransactions mt = memoRandomRepo.findById(details.getMemorandomTransactionId()).get();
			mt.setStaffId(details.getStaffId());
			Staffs staffs = staffRepo.getOne(details.getStaffId());
			mt.setBranchId(staffs.getBranchId());
			mt.setName(details.getName());
			mt.setMemorandumType(details.getMemorandumType());
			mt.setNarration(details.getNarration());
			mt.setCreatedAt(details.getCreatedAt());
			memoRandomRepo.save(mt);
		}
		
		// delete memorandoms.............
		public String deleteMemorandoms(Integer id) {
			try {
				memoRandomRepo.deleteById(id);
				memorandomTransactionRowRepo.deleteByMemorandumTransactionId(id);
			}
			catch (Exception e) {
				return "Try again after sometime"+e;
			}
			return "Item Deleted Successfully";
		}
		
		// get detail api tab for memorandoms tab......................
		public List<MemoRandomTransactionRowDetails> getDetailsMemodandom( Integer memorandomTransactionId) {
			List<MemoRandomTransactionRowDetails> list = memorandomTransactionRowRepo.getDetailsMemodandom(memorandomTransactionId);
			if(list.size() != 0) {
				return list;
			}
			else {
				return new ArrayList<MemoRandomTransactionRowDetails>();
			}
//			return null;
		}
		
		// add detail api for memorandoms tab..............
		public void addDetailsMemorandom(MemoRandomTransactionRowDetails details) {
			MemorandumTransactionsrow mtr =  new MemorandumTransactionsrow();
			mtr.setAccountId(details.getAccountId());
			mtr.setMemorandumTransactionId(details.getMemorandumTransactionId());
			mtr.setTax(details.getTax());
			mtr.setTaxPercentage(details.getTaxPercentage());
			mtr.setTaxAmount(details.getTaxAmount());
			mtr.setTaxNarration(details.getTaxNarration());
			mtr.setTaxExcludedAmount(details.getTaxExcludedAmount());
			mtr.setAmountCr(details.getAmountCr());
			mtr.setAmountDr(details.getAmountDr());
			mtr.setCreatedAt(details.getCreatedAt());
			memorandomTransactionRowRepo.save(mtr);
		}
		
		// update detail api for memorandoms tab..............
		public void updateDetailsMemorandom(MemoRandomTransactionRowDetails details) {
			MemorandumTransactionsrow mtr =  memorandomTransactionRowRepo.getOne(details.getMemorandomTransactionRowId());
			mtr.setAccountId(details.getAccountId());
			mtr.setMemorandumTransactionId(details.getMemorandumTransactionId());
			mtr.setTax(details.getTax());
			mtr.setTaxPercentage(details.getTaxPercentage());
			mtr.setTaxAmount(details.getTaxAmount());
			mtr.setTaxNarration(details.getTaxNarration());
			mtr.setTaxExcludedAmount(details.getTaxExcludedAmount());
			mtr.setAmountCr(details.getAmountCr());
			mtr.setAmountDr(details.getAmountDr());
			mtr.setCreatedAt(details.getCreatedAt());
			memorandomTransactionRowRepo.save(mtr);
		}
		
		// delete detail api for memorandoms tab...............
		public String deleteDetailsMemorandom(Integer id) {
			try {
				memorandomTransactionRowRepo.deleteById(id);
			}
			catch (Exception e) {
				return "Try again after sometime"+e;
			}
			return "Item Deleted Successfully";
		}

		//Change Mo in the MO agent update.....
		public void changeMo(changeMoDetail changeMoDetail) {
			for (Integer ids : changeMoDetail.getIds()) {
				Agents agents = agentsRepo.getOne(ids);

				if (agents.getMoId() == null && changeMoDetail.getRemoveMo() == false) {
					MoAgentAssociation maa = new MoAgentAssociation();
					maa.setMoId(changeMoDetail.getMoId());
					maa.setAgentId(ids);
					Date date = new Date();
					maa.setFromDate(date);
					moAssociationRepo.save(maa);
					agents.setMoId(changeMoDetail.getMoId());
					agentsRepo.save(agents);
				} 
				
			 if ((agents.getMoId() != changeMoDetail.getMoId()) && changeMoDetail.getRemoveMo() == false) {
					Integer moAgentAssociationId = moAssociationRepo.getMoAgentAssociationId(agents.getId(),agents.getMoId());
					MoAgentAssociation moAgentAssociation = moAssociationRepo.findById(moAgentAssociationId).get();
					Date date = new Date();
					moAgentAssociation.setToDate(date);
					moAssociationRepo.save(moAgentAssociation);
					agents.setMoId(changeMoDetail.getMoId());
					agentsRepo.save(agents);

					MoAgentAssociation maa = new MoAgentAssociation();
					maa.setMoId(changeMoDetail.getMoId());
					maa.setAgentId(ids);
					maa.setFromDate(date);
					moAssociationRepo.save(maa);

				}

			 if (changeMoDetail.getRemoveMo() == true && agents.getMoId() != null) {
					Integer moAgentAssociationId = moAssociationRepo.getMoAgentAssociationId(agents.getId(), agents.getMoId());
					MoAgentAssociation moAgentAssociation = moAssociationRepo.findById(moAgentAssociationId).get();
					Date date = new Date();
					moAgentAssociation.setToDate(date);
					moAssociationRepo.save(moAgentAssociation);
					agents.setMoId(null);
					agentsRepo.save(agents);
				}
			}
		}

		@SuppressWarnings("deprecation")
		public List<iDeleteVoucherDetails> getDirtyVoucher(Integer branchId, Integer voucherNo, Integer vouchUuid, String currentDate) throws Exception {
			
			Date date = transactionRepo.getDirtyVoucherDate(branchId, voucherNo, vouchUuid);
			System.out.println(date);
			if (date== null) {
				date=new Date();
				date.setDate(01);
				date.setMonth(01);
				date.setYear(0001);
			}
			int year = date.getYear() +1900;  
			System.out.println(year);
			Date cDate= new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);  
			int cYear = cDate.getYear() + 1900;
			System.out.println(cYear);
			if(year == cYear) {
				List<iDeleteVoucherDetails> list = transactionRowRepo.getDirtyVoucher(branchId, voucherNo, vouchUuid);
				if(list.size() != 0) {
					return list;
				}
				else {
					return new ArrayList<iDeleteVoucherDetails>();
				}
			}
			else {
				return new ArrayList<iDeleteVoucherDetails>();
			}
		}

		public void removeTransaction(Integer branchId, Integer voucherNo, Integer voucherUuid, Integer accountId) {
			transactionRepo.removeTransaction(branchId,voucherNo,voucherUuid);
			transactionRowRepo.removeTransaction(branchId,voucherNo,voucherUuid);
			
			Accounts accounts= accountsRepo.findById(accountId).get();
			accounts.setIsDirty((byte)1);
			accountsRepo.save(accounts);
			
		}

		public void narrationEdit(Integer branchId, Integer voucherNo, Integer voucherUuid, String narration) {
			Transactions transactions = transactionRepo.findById(voucherUuid).get();
			transactions.setNarration(narration);
			transactionRepo.save(transactions);
			
			List<TransactionRow> transactionRows = transactionRowRepo.getTransactions( branchId,  voucherNo,  voucherUuid);
			for(TransactionRow tr : transactionRows) {
				System.out.println(tr.getId());
				tr.setNarration(narration);
				transactionRowRepo.save(tr);
			}	
		}

		public void editAccounts(Integer id, Integer accountId) {
			TransactionRow transactionRows = transactionRowRepo.findById(id).get();
			transactionRows.setAccountId(accountId);
			transactionRowRepo.save(transactionRows);
		}

		public List<StaffModel> getStaffName(String search) {
			List<StaffModel> name = staffRepo.getStaffName(search);
			return name;
		}

		public List<IBranchDetails> getBranchName(String search) {
			List<IBranchDetails> name = branchRepo.getBranchName(search);
			return name;
		}

		public List<iAccountDetails> getDirtyAccounts() {
			List<iAccountDetails> accounts = accountsRepo.getDirtyAccounts();
			return accounts;
		}

		public void updatePremiums(PremiumDetails premiumDetails) {
			Premiums premiums = premiumRepo.findById(premiumDetails.getId()).get();
			premiums.setPaid(premiumDetails.getPaid());
			premiums.setPaidOn(premiumDetails.getPaidOn());
			premiums.setAgentCommissionSend(premiumDetails.getAgentCommissionSend());
			premiums.setAgentCommissionPercentage(premiumDetails.getAgentCommissionPercentage());
			premiums.setAgentCollectionChargesSend(premiumDetails.getAgentCollectionChargesSend());
			premiums.setAgentCollectionChargesPercentage(premiumDetails.getAgentCollectionChargesPercentage());
			premiumRepo.save(premiums);	
		}

		public void clearDirtyAccount(Integer accountId) {
			Accounts accounts = accountsRepo.findById(accountId).get();
			accounts.setIsDirty((byte)0);
			accountsRepo.save(accounts);
			
		}
}