package com.service.banking.repository.dashBoardRepo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Accounts;
import com.service.banking.model.dashboardModel.AccountsDetails;
import com.service.banking.model.dashboardModel.AccountsOpenTodayDetails;
import com.service.banking.model.hodAuthorityModel.LockUnlockAcntDetails;
import com.service.banking.model.hodAuthorityModel.ODLimitsDetails;
import com.service.banking.model.hodAuthorityModel.UnlockAccountsDetails;

public interface AccountsOpenTodayRepo extends JpaRepository<Accounts, Integer> {
	

	// Get all SM today open accounts details.....................
	@Query(" select new com.service.banking.model.dashboardModel.AccountsOpenTodayDetails(a.id,a.accountNumber ,m.name,m.fatherName ,m.permanentAddress ,m.phoneNos ,s.name ,a.amount ,d.name ,a.currentBalanceCr, \r\n"
			+ "agnt.codeNo,agntmem.name,agntmem.memberNo ,agntmem.permanentAddress ,agntmem.landmark ,agntmem.isDefaulter) from Accounts a \r\n"
			+ "left join Members m on m.id=a.memberId \r\n" + "left join Schemes s on s.id=a.schemeId \r\n"
			+ "left join Agents agnt on agnt.id=a.agentId \r\n"
			+ "left join Members agntmem on agntmem .id=agnt.memberId \r\n"
			+ "left join Dealers d on d.id=a.dealerId \r\n"
			+ "where date(a.createdAt) =?1 and a.activeStatus =1 and a.accountNumber like 'SM%' order by a.accountNumber ASC")
	List<AccountsOpenTodayDetails> accountsOpenToday(Date date);

	// Get CC,recurring,fixed,saving - Open accounts details.....................
	@Query(" select new com.service.banking.model.dashboardModel.AccountsOpenTodayDetails(a.id,a.accountNumber ,m.name,m.fatherName ,m.permanentAddress ,m.phoneNos ,s.name ,a.amount ,d.name ,a.currentBalanceCr, \r\n"
			+ "agnt.codeNo,agntmem.name,agntmem.memberNo ,agntmem.permanentAddress ,agntmem.landmark ,agntmem.isDefaulter) from Accounts a \r\n"
			+ "left join Members m on m.id=a.memberId \r\n" + "left join Schemes s on s.id=a.schemeId \r\n"
			+ "left join Agents agnt on agnt.id=a.agentId \r\n"
			+ "left join Members agntmem on agntmem .id=agnt.memberId \r\n"
			+ "left join Dealers d on d.id=a.dealerId \r\n"
			+ "where date(a.createdAt) =?1 and a.activeStatus =1 and  s.schemeType =?2 order by a.accountNumber ASC")
	List<AccountsOpenTodayDetails> acntOpenToday(Date date, String schematype);

	// Get loan Vl, Pl, Sl type - Accounts open today.............................
	@Query(" select new com.service.banking.model.dashboardModel.AccountsOpenTodayDetails(a.id,a.accountNumber ,m.name,m.fatherName ,m.permanentAddress ,m.phoneNos ,s.name ,a.amount ,d.name ,a.currentBalanceCr, \r\n"
			+ "agnt.codeNo,agntmem.name,agntmem.memberNo ,agntmem.permanentAddress ,agntmem.landmark ,agntmem.isDefaulter) from Accounts a \r\n"
			+ "left join Members m on m.id=a.memberId \r\n" + "left join Schemes s on s.id=a.schemeId \r\n"
			+ "left join Agents agnt on agnt.id=a.agentId \r\n"
			+ "left join Members agntmem on agntmem .id=agnt.memberId \r\n"
			+ "left join Dealers d on d.id=a.dealerId \r\n"
			+ "where date(a.createdAt) =?1 and a.activeStatus =1 and s.schemeType ='Loan' and a.accountType =?2 order by a.accountNumber ASC")
	List<AccountsOpenTodayDetails> loanAccountsOpenToday(Date date, String accountType);

	// Get other accounts details - Accounts open today .........................
	@Query(" select new com.service.banking.model.dashboardModel.AccountsOpenTodayDetails(a.id,a.accountNumber ,m.name,m.fatherName ,m.permanentAddress ,m.phoneNos ,s.name ,a.amount ,d.name ,a.currentBalanceCr, \r\n"
			+ "agnt.codeNo,agntmem.name,agntmem.memberNo ,agntmem.permanentAddress ,agntmem.landmark ,agntmem.isDefaulter) from Accounts a \r\n"
			+ "left join Members m on m.id=a.memberId \r\n" + "left join Schemes s on s.id=a.schemeId \r\n"
			+ "left join Agents agnt on agnt.id=a.agentId \r\n"
			+ "left join Members agntmem on agntmem .id=agnt.memberId \r\n"
			+ "left join Dealers d on d.id=a.dealerId \r\n"
			+ "where date(a.createdAt) =?1 and a.activeStatus =1 and s.schemeType ='Loan' and a.accountType not in ('Auto Loan','Two Wheeler Loan','Loan Against Deposit','Personal Loan') order by a.accountNumber ASC")
	List<AccountsOpenTodayDetails> otherAccountsOpenToday(Date date);

	// Get ALL other accounts details - Accounts open today .....................
	@Query(" select new com.service.banking.model.dashboardModel.AccountsOpenTodayDetails(a.id,a.accountNumber ,m.name,m.fatherName ,m.permanentAddress ,m.phoneNos ,s.name ,a.amount ,d.name ,a.currentBalanceCr, \r\n"
			+ "agnt.codeNo,agntmem.name,agntmem.memberNo ,agntmem.permanentAddress ,agntmem.landmark ,agntmem.isDefaulter) from Accounts a \r\n"
			+ "left join Members m on m.id=a.memberId \r\n" + "left join Schemes s on s.id=a.schemeId \r\n"
			+ "left join Agents agnt on agnt.id=a.agentId \r\n"
			+ "left join Members agntmem on agntmem .id=agnt.memberId \r\n"
			+ "left join Dealers d on d.id=a.dealerId \r\n"
			+ "where date(a.createdAt) =?1 and a.activeStatus =1 and s.schemeType ='Default' and a.accountNumber not Like 'SM%' order by a.accountNumber ASC")
	List<AccountsOpenTodayDetails> AllotherAccountsOpenToday(Date date);
	
	
	
	

	// od overlimit accounts FOR HOD AUTHORITY...........

	@Query("select new com.service.banking.model.hodAuthorityModel.ODLimitsDetails(a2.id,a2.accountNumber,a2.accountType ,a2.currentBalanceCr,a2.bankAccountLimit ) from Accounts a2 where a2.currentBalanceCr > a2.bankAccountLimit and a2.bankAccountLimit > 0 ")
	public List<ODLimitsDetails> getOdLimits();

	// Get Lock and Unlock accounts....
	@Query("select new com.service.banking.model.hodAuthorityModel.LockUnlockAcntDetails( a.id, a.accountNumber, b.name, s.username , m.id, m.name, m.currentAddress ,m.isDefaulter,a.lockingStatus ,a.maturedStatus,a.lockStatusChangedReason ,a.activeStatus)  from Accounts a "
			+ "left join Branches b on b.id = a.branchId " + "left join Staffs s on s.id = a.staffId "
			+ "left join Members m on m.id = a.memberId " + "where a.accountNumber = ?1 ")
	public List<LockUnlockAcntDetails> getAccounts(String accountNumber);

	// get accounts details for lock unlock............
	// @Query("from Accounts a ,Members m where a.accountNumber = 'UDRRD001' and
	// a.memberId =m.id")
	// public List<Object> getAccountsDetails();

	// get accounts details for lock unlock............
	@Query("select  new com.service.banking.model.hodAuthorityModel.UnlockAccountsDetails(a.id,a.openingBalanceDr,a.openingBalanceCr,a.accountNumber,a.createdAt,a.currentBalanceCr,a.accountType,m.name,m.currentAddress,m.fatherName,m.permanentAddress,m.isActive) from Accounts a ,Members m where a.accountNumber = 'UDRRD001' and a.memberId =m.id")
	public List<UnlockAccountsDetails> getAccountsDetails();
	
	
	// get accounts details for lock unlock...............................
	@Query("select new com.service.banking.model.dashboardModel.AccountsDetails(a.id,a.accountNumber ,a.modeOfOperation ,a.createdAt ,m.name ,m.fatherName ,a.memberId,m.panNo ,m.adharNumber  \r\n"
			+ "	 		 ,m.permanentAddress ,m.phoneNos ,a.amount ,a.repaymentMode,mg.name ,d.name ,a.maturityToAccountId,\r\n"
			+ "			  sc.name ,sc.interest ,sc.accountOpenningCommission ,sc.processingFees ,sc.premiumMode ,sc.maturityPeriod ,sc.numberOfPremiums ,\r\n"
			+ "			 sc.schemeType, sc.type ,sc.schemeGroup,sc.interestMode,  \r\n"
			+ "			 mi.insuranceStartDate ,mi.nextInsuranceDueDate ,mi.narration,m.memberNo, max(p.dueDate), p.amount, ag.codeNo, mg.permanentAddress, sc.reducingOrFlatRate ) " + "from Accounts a  \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "left join Dealers d on a.dealerId = d.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Premiums  p on p.accountId  = a.id \r\n"
			+ "left join MemberInsurance mi on mi.accountsId =a.id \r\n" + "Where a.id= ?1 group by a.id")
	public List<AccountsDetails> getAccountsDetails(Integer id);

	// get accounts details for pop-up...............................
	@Query("select new com.service.banking.model.dashboardModel.AccountsDetails(a.id,a.accountNumber ,a.modeOfOperation ,a.createdAt ,m.name ,m.fatherName ,a.memberId,m.panNo ,m.adharNumber  \r\n"
			+ "	 		,m.permanentAddress ,m.phoneNos ,a.amount ,a.repaymentMode,mg.name ,d.name ,a.maturityToAccountId,\r\n"
			+ "			  sc.name ,sc.interest ,sc.accountOpenningCommission ,sc.processingFees ,sc.premiumMode ,sc.maturityPeriod ,sc.numberOfPremiums ,\r\n"
			+ "			 sc.schemeType, sc.type ,sc.schemeGroup,sc.interestMode,  \r\n"
			+ "			 mi.insuranceStartDate ,mi.nextInsuranceDueDate ,mi.narration, m.memberNo)" + "from Accounts a  \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "left join Dealers d on a.dealerId = d.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" 
			+ "left join MemberInsurance mi on mi.accountsId =a.id \r\n" + "Where a.memberId= ?1 and a.accountType='SM'")
	public AccountsDetails getAccountsDetails1(Integer memberId);

	// get Account List only.............
		@Query("select new com.service.banking.model.hodAuthorityModel.LockUnlockAcntDetails(a.id, a.accountNumber, m.id, m.name, m.fatherName) from Accounts a left join "
				+ "Members m on a.memberId=m.id where a.accountNumber like %?1%")
		public List<LockUnlockAcntDetails> getAccountList(String name);

}
