package com.service.banking.repository.AccountsRepo;

import java.util.List;

import com.service.banking.model.accountsModel.*;
import com.service.banking.model.printingModel.*;
import com.service.banking.model.transaction.IPreviewDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Accounts;
import com.service.banking.model.GstModel.AccountDetail;
import com.service.banking.model.GstModel.PurchaseAccountDetails;
import com.service.banking.model.MadModel.iMemberInsuDetails;
import com.service.banking.model.dashboardModel.iAccountDetails;
import com.service.banking.model.hodAuthorityModel.AssociationDetails;
import com.service.banking.model.report.iAgentsAccount;
import com.service.banking.model.report.iBikeLegalReport;
import com.service.banking.model.report.iDepositeReport;
import com.service.banking.model.report.iGeneralReport;
import com.service.banking.model.report.iMemberReport;
import com.service.banking.model.superAdminModel.StaffModel;

public interface AccountsRepo extends JpaRepository<Accounts, Integer> {

    @Query(nativeQuery = true, value = "SELECT a.account_type  " + "FROM accounts as a "
            + "left join schemes as sch on (sch.id =a.scheme_id) " + "left join members m on m.id=a.member_id "
            + "left join premiums p on p.account_id =a.id " + "left  join agents agnt on agnt.id=a.agent_id "
            + "WHERE  a.account_type in ('FD', 'MIS') and  a.ActiveStatus = 1 and a.DefaultAC =0  and sch.SchemeType ='FixedAndMis' "
            + "and DATE_ADD(DATE(a.created_at) , INTERVAL sch.MaturityPeriod DAY) <='2020-09-06'  "
            + "and DATE_ADD(DATE(a.created_at) , INTERVAL sch.MaturityPeriod DAY) >='2020-08-31' ")
    List<Accounts> getDDSAcccccccccount();

    // for sm accounts..............................

    @Query("select new  com.service.banking.model.accountsModel.SMAccountsDetails(a.id,a.accountNumber,a.createdAt ,m.name ,m.memberNo ,m.currentAddress ,m.fatherName ,b.name, schm.name, a.activeStatus, a.memberId, a.schemeId, a.nominee, a.nomineeAge, a.relationWithNominee, a.amount, a.accountType) "
            + "from Accounts a \r\n" + "left join Members m on m.id =a.memberId \r\n"
            + "left join Branches b on b.id=m.branchId \r\n" + "left join Schemes schm on schm.id=a.schemeId \r\n"
            + "where a.accountType ='SM' order by a.id DESC")
    Page<SMAccountsDetails> smAccounts(Pageable pageable);

    // for SavingandCurrent accounts..............................
    @Query("select new  com.service.banking.model.accountsModel.SavingAccountDetails(a.id,a.accountNumber,a.createdAt ,m.name ,m.memberNo ,m.currentAddress,ag.codeNo ,agnt_m.name ,agnt_m.memberNo ,\r\n"
            + "agnt_m.currentAddress ,a.nominee ,a.nomineeAge ,a.relationWithNominee ,a.currentInterest ,a.lastCurrentInterestUpdatedAt ,tm.name, schm.name, a.amount,a.accountType, a.memberId, a.schemeId, a.agentId, a.activeStatus, a.modeOfOperation, a.minorNomineeParentName, a.teamId, a.memberId, a.memberId, a.memberId  ) \r\n"
            + "from Accounts a \r\n" + "left join Branches b on b.id=a.branchId \r\n"
            + "left join Members m on m.id =a.memberId \r\n" + "left join Schemes schm on schm.id=a.schemeId \r\n"
            + "left join Agents ag on ag.id=a.agentId \r\n" + "left join Members  agnt_m on agnt_m.id=ag.memberId \r\n"
            + "left join Teams tm on tm.id=a.teamId \r\n"
            + "where a.accountType ='Saving' or  a.accountType ='Current' order by a.id DESC")
    Page<SavingAccountDetails> savingAccounts(Pageable pageable);

    // for DDS2 accounts..............................
    @Query("select  distinct new  com.service.banking.model.accountsModel.DDSAccountDetails( a.id,a.accountNumber,a.createdAt ,m.name ,m.memberNo ,m.currentAddress,schm.name ,a.amount ,ag.codeNo ,agnt_m.name ,agnt_m.memberNo ,\r\n"
            + "agnt_m.currentAddress ,coll_agnt.codeNo ,coll_m.name ,coll_m.memberNo ,coll_m.permanentAddress , \r\n"
            + "coll_m.landmark  ,coll_m.isDefaulter,\r\n"
            + "a.nominee ,a.nomineeAge ,a.relationWithNominee ,a.newOrRenew ,tm.name,a.memberId, a.schemeId, a.agentId, a.collectorId, a.teamId,\r\n"
            + "			a.activeStatus, a.modeOfOperation, a.minorNomineeParentName, a.memberId,\r\n"
            + "			a.memberId, a.memberId ) \r\n" + "from Accounts a \r\n"
            + "left join Branches b on b.id=a.branchId \r\n" + "left join Members m on m.id =a.memberId \r\n"
            + "left join Schemes schm on schm.id=a.schemeId \r\n" + "left join Agents ag on ag.id=a.agentId \r\n"
            + "left join Members  agnt_m on agnt_m.id=ag.memberId \r\n" + "left join Teams tm on tm.id=a.teamId \r\n"
            + "left join Premiums p on p.accountId =a.id \r\n"
            + "left join Agents coll_agnt on coll_agnt.id=a.collectorId \r\n"
            + "left join Members coll_m on coll_m.id=coll_agnt.memberId \r\n" + "where a.accountType ='DDS' order by a.id DESC")
    List<DDSAccountDetails> DDSAccounts();

    // for recurring accounts..............................
    @Query("select distinct new  com.service.banking.model.accountsModel.RecurringAccountDetails( a.id,a.accountNumber,a.createdAt ,m.name ,m.memberNo ,m.currentAddress,schm.name ,a.amount ,ag.codeNo ,agnt_m.name ,agnt_m.memberNo ,\r\n"
            + "agnt_m.currentAddress ,coll_agnt.codeNo ,coll_m.name ,coll_m.memberNo ,coll_m.permanentAddress , \r\n"
            + "coll_m.landmark  ,coll_m.isDefaulter,\r\n"
            + "a.nominee ,a.nomineeAge ,a.relationWithNominee ,a.newOrRenew ,tm.name, a.memberId, a.schemeId, a.agentId, a.collectorId, a.teamId,\r\n"
            + "			a.activeStatus, a.modeOfOperation, a.minorNomineeParentName, a.memberId,\r\n"
            + "			a.memberId, a.memberId ) \r\n" + "from Accounts a \r\n"
            + "left join Branches b on b.id=a.branchId \r\n" + "left join Members m on m.id =a.memberId \r\n"
            + "left join Schemes schm on schm.id=a.schemeId \r\n" + "left join Agents ag on ag.id=a.agentId \r\n"
            + "left join Members  agnt_m on agnt_m.id=ag.memberId \r\n" + "left join Teams tm on tm.id=a.teamId \r\n"
            + "left join Agents coll_agnt on coll_agnt.id=a.collectorId \r\n"
            + "left join Members coll_m on coll_m.id=coll_agnt.memberId \r\n" +
            "where a.accountType ='Recurring' order by a.id DESC")
    Page<RecurringAccountDetails> RecurringAccounts(Pageable pageable);

    // for fixed accounts..............................

    @Query("select distinct new  com.service.banking.model.accountsModel.FixedAccountDetails( a.id,a.accountNumber,a.createdAt ,m.name ,m.memberNo ,m.currentAddress,schm.name ,a.amount ,ag.codeNo ,agnt_m.name ,agnt_m.memberNo ,\r\n"
            + "agnt_m.currentAddress ,coll_agnt.codeNo ,coll_m.name ,coll_m.memberNo ,coll_m.permanentAddress , \r\n"
            + "coll_m.landmark  ,coll_m.isDefaulter, a.intrestToAccountId ,a.maturityToAccountId , \r\n"
            + "a.nominee ,a.nomineeAge ,a.relationWithNominee ,a.newOrRenew ,tm.name, a.memberId,\r\n"
            + "			a.schemeId, a.agentId, a.collectorId, a.teamId, a.activeStatus,\r\n"
            + "			a.modeOfOperation, a.minorNomineeParentName, a.accountType, a.minorNomineeDob, a.moId, mos.name ) \r\n"
            + "from Accounts a \r\n" + "left join Branches b on b.id=a.branchId \r\n"
            + "left join Members m on m.id =a.memberId \r\n" + "left join Schemes schm on schm.id=a.schemeId \r\n"
            + "left join Agents ag on ag.id=a.agentId \r\n" + "left join Members  agnt_m on agnt_m.id=ag.memberId \r\n"
            + "left join Teams tm on tm.id=a.teamId \r\n" + "left join Premiums p on p.accountId =a.id \r\n"
            + "left join Agents coll_agnt on coll_agnt.id=a.collectorId \r\n"
            + "left join Members coll_m on coll_m.id=coll_agnt.memberId \r\n" +
            " left join Mos mos on mos.id = a.moId "
            + "where a.accountType ='FD' or a.accountType ='MIS' order by a.id DESC")
    Page<FixedAccountDetails> FixedAccounts(Pageable pageable);

    // for OTRHERS accounts..............................
    @Query("select  new  com.service.banking.model.accountsModel.OtherAccountDetails(a.id,a.accountNumber,a.createdAt ,m.name ,m.memberNo ,m.currentAddress,m.landmark,m.isDefaulter,schm.name, a.accountType, a.activeStatus, a.memberId, a.schemeId, a.pandLgroup) "
            + "from Accounts a \r\n" + "inner join Members m on m.id =a.memberId \r\n"
            + "inner join Schemes schm on schm.id=a.schemeId \r\n"
            + "where a.accountType= null or a.accountType='Default' or a.accountType ='Other'  or a.accountType ='Two Wheeler Loan' or a.accountType ='Personal Loan' or a.accountType ='CC' or a.accountType ='Loan Against Deposit' or a.accountType ='Auto Loan' or a.accountType ='Agriculture Loan' or a.accountType ='Home Loan' or a.accountType ='Mortgage Loan'  "
            + " order by a.id DESC")
    Page<OtherAccountDetails> OthersAccounts(Pageable pageable);

//********account statement********************			

    // all accounts.......................................
    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id, a.accountNumber, m.name ,m.fatherName) from Accounts a \r\n"
            + "left join Members m on m.id=a.memberId ")
    List<AccountDetails> getAccounts();


    // purchase account for gst
    // panel.................................................................................
    @Query("select new com.service.banking.model.GstModel.PurchaseAccountDetails(a.id, a.accountNumber,b.code ,b.name) from Accounts a  \r\n"
            + " left join Branches b on b.id=a.branchId \r\n" + " where a.branchId = 1 ")
    // remove hardcode one when
    // the user login api work
    List<PurchaseAccountDetails> purchaseAccount();

    // (amount from account) and (bank account) for gdt deposit in gst
    // panel.................................................................................
    @Query("select new com.service.banking.model.GstModel.PurchaseAccountDetails(a.id, a.accountNumber,b.code ,b.name) from Accounts a  \r\n"
            + " left join Branches b on b.id=a.branchId \r\n" + " where a.activeStatus = 1 ")
    List<PurchaseAccountDetails> gstAccount();

    // account for account statement in gst
    // panel.................................................................................
    @Query("select new com.service.banking.model.GstModel.PurchaseAccountDetails(a.id, a.accountNumber,b.code ,b.name) from Accounts a  \r\n"
            + " left join Branches b on b.id=a.branchId \r\n ")
    List<PurchaseAccountDetails> accountStatement();

    // DR Account for general gst in gst
    // panel.................................................................................
    @Query("select new com.service.banking.model.GstModel.PurchaseAccountDetails(a.id, a.accountNumber,b.code ,b.name) from Accounts a  \r\n"
            + " left join Branches b on b.id=a.branchId \r\n " + "where a.activeStatus = 1 and a.branchId = 1 ")
    // remove
    // hardcode
    // one
    // when
    // the
    // user
    // login
    // api
    // work
    List<PurchaseAccountDetails> DRaccount();

    // CR Account for general gst in gst
    // panel.................................................................................
    @Query("select new com.service.banking.model.GstModel.PurchaseAccountDetails(a.id, a.accountNumber,b.code ,b.name) from Accounts a  \r\n"
            + " left join Branches b on b.id=a.branchId \r\n "
            + "where a.activeStatus = 1 and a.branchId = 1 and a.schemeId =14 or a.schemeId =10 ")
    // remove hardcode
    // one when the user
    // login api work
    List<PurchaseAccountDetails> CRaccount();

    // get fd accounts..for printing..........................

    @Query("select new com.service.banking.model.printingModel.FDAccountDetails(a.id,a.accountNumber ,m.name,m.fatherName) from Accounts a "
            + "left join Schemes sch on sch.id=a.schemeId " + "left join Members m on m.id=a.memberId "
            + "left  join Agents agnt on agnt.id=a.agentId " + "left join Members mg on agnt.memberId =mg.id "
            + "where  a.accountType in ('FD', 'MIS') and (a.accountNumber LIKE %?1% or m.name LIKE %?1%) ")
    List<FDAccountDetails> FDAccounts(String accountName);

    // get accounts details..for account statement..........................
    @Query("select new com.service.banking.model.GstModel.AccountDetail(a.id,a.accountNumber ,m.name,m.fatherName) from Accounts a "
            + "left join Members m on m.id=a.memberId " + "where  a.accountNumber LIKE %?1% ")
    List<AccountDetail> account(String accountName);

    // @Query("SELECT m FROM Movie m WHERE m.rating LIKE ?1%")
    // List<Movie> searchByRatingStartsWith(String rating);

    // get accounts details by id...... for printing

    @Query("select new com.service.banking.model.printingModel.AcountDetails(a.id, a.accountNumber,a.nominee ,a.nomineeAge ,a.relationWithNominee ,a.amount,  "
            + "	m.name ,m.fatherName ,m.currentAddress ,m.permanentAddress ,a.createdAt ,a.minorNomineeDob, m.phoneNos ,sc.maturityPeriod ,sc.interest ,b.name, a.accountType )"
            + "	from Accounts a " + " left join Members  m on a.memberId=m.id  "
            + "	left join Schemes sc on sc.id =a.schemeId " + " left join Branches b on a.branchId =b.id "
            + " Where a.id =?1 ")
    public AcountDetails getAccountById(Integer id);

    // get all account for share certicicate printing...............

    @Query("select new com.service.banking.model.printingModel.ShareCertificateAccount(a.id,a.accountNumber,m.name ,m.fatherName) "
            + "	from Accounts a " + "	left join Members  m on a.memberId =m.id  "
            + "	left join Schemes s on s.id = a.schemeId "
            + "   where a.accountType ='SM' and s.schemeType ='Default'  and s.name ='Share Capital' and a.accountNumber LIKE %?1% ")
    List<com.service.banking.model.printingModel.ShareCertificateAccount> ShareCertificateAccount(String accountName);

    // get accounts details for share certificate...............................
    @Query("select new com.service.banking.model.printingModel.ShareAccountDetail(a.id, m.name, a.accountNumber, count(s.currentMemberId) as shares, a.createdAt)"
            + "	from Accounts a " + " left join Members m on a.memberId = m.id  "
            + "	left join Share s on s.currentMemberId = m.id " + " where a.id =?1  Group by (s.shareCertificateId) ")
    public ShareAccountDetail getShareAccountById(Integer id);


    // get accounts details for print CONTENT IN PRINT
    // ..................................

    @Query("select new  com.service.banking.model.printingModel.ContentAccount(a.id,m.name,m.fatherName ,m.permanentAddress ,a.createdAt ,a.amount ,a.accountNumber) from Accounts a "
            + "left join Schemes s on s.id=a.schemeId  and s.schemeType ='Loan' "
            + "left join Members m on m.id= a.memberId " + "where a.accountNumber =?1 and a.isLegalNoticeSent =1 ")
    public ContentAccount getAccountsDetails(String acntNum);

    // QUery for getting memberID in
    // MAD-MemberInsurance-ADD................................................
    @Query(nativeQuery = true, value = "select a.member_id from accounts as a where a.id = ?1 ")
    public Integer getMemberId(Integer accountId);

    // Search for saving account in MAD -
    // Agent.............................................................................
    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id, a.accountNumber, m.name, m.fatherName) from Accounts a left join Members m on m.id= a.memberId where a.accountType='saving' and m.name LIKE %?1% OR a.accountNumber LIKE %?1%")
    List<AccountDetails> getSaving(String name);

    // Search for accounts in MAD -
    // Agent.............................................................................
    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id, a.accountNumber, m.name, m.fatherName, a.accountType, a.id, a.id) from Accounts a left join Members m on m.id= a.memberId where a.accountNumber LIKE %?1% or m.name LIKE %?1% order by a.accountNumber")
    List<AccountDetails> getAllAccounts(String name);

    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id, a.accountNumber, m.name, m.fatherName, a.accountType) from Accounts a left join Members m on m.id= a.memberId where (a.accountNumber LIKE %?1% or m.name LIKE %?1%) and (NOT a.groupType = 'Loan') and (a.activeStatus = 1) order by a.accountNumber")
    List<AccountDetails> getAllAccountsForTransWithdrwal(String name);

    @Query("select new com.service.banking.model.accountsModel.LoanAccountDetails(a.id, a.accountNumber,m.id, m.name, m.fatherName, a.accountType) from Accounts a left join Members m on m.id= a.memberId where a.accountNumber LIKE %?1% or m.name LIKE %?1% order by a.accountNumber")
    List<LoanAccountDetails> getAllLoanAgainstAccounts(String name);

    @Query("select new com.service.banking.model.hodAuthorityModel.AssociationDetails(m.id, a.id, a.accountNumber, m.name, m.fatherName) "
            + "from Accounts a left join Members m on a.memberId = m.id where "
            + "(Concat( a.accountNumber, REPLACE(m.name, ' ', ''), REPLACE(m.fatherName, ' ', '') ) \r\n"
            + "like %?1%  OR Concat( a.accountNumber, REPLACE(m.fatherName, ' ', ''), REPLACE(m.name, ' ', '')) like %?1% ) ")
    List<AssociationDetails> getRoAccountAssociationList(String name);

    // for "Manage Surrender Bike and Legal" inside "Loan" tab............
    @Query("select new com.service.banking.model.accountsModel.MngSuurenderBikeDetails(a.id, a.accountNumber, a.bikeSurrendered, a.bikeSurrenderedOn, "
            + "a.bikeSurrenderedBy, a.isGivenForLegalProcess, a.legalProcessGivenDate, a.isInLegal, a.legalFilingDate, a.isGodownchargeDebited, a.godownchargeDebitedOn, "
            + "a.isLegalNoticeSentForBikeAuction, a.legalNoticeSentForBikeAuctionOn, a.isBikeAuctioned, a.bikeAuctionedOn, a.isFinalRecoveryNoticeSent, a.finalRecoveryNoticeSentOn, "
            + "a.isChequePresentedInBank, a.chequePresentedInBankOn, a.isChequeReturned, a.chequeReturnedOn, a.isNoticeSentAfterChequeReturned, a.noticeSentAfterChequeReturnedOn, "
            + "a.isLegalCaseFinalised, a.legalCaseFinalisedOn, a.isBikeReturned, a.bikeReturnedOn, a.bikeNotSoldReason, a.legalCaseNotSubmittedReason, a.isInArbitration, "
            + "a.arbitrationOn, a.isSocietyNoticeSent, a.societyNoticeSentOn, a.isLegalNoticeSent, a.legalNoticeSentOn, a.isVisitDone, a.visitDoneOn, a.isNocHandlingChargeReceived, "
            + "a.nocHandlingChargeReceivedOn) from Accounts a where a.groupType = 'Loan' and a.accountNumber LIKE %?1% " )
    public Page<MngSuurenderBikeDetails> manageSuurenderBike(String search, Pageable pageable);

    @Query("select new com.service.banking.model.accountsModel.MngLegalCaseHearing(a.id, a.accountNumber, m.id, m.name, m.fatherName, alc.name, alc.bccsFileNo, alc.court, alc.autorisedPerson, alc.caseType, \r\n"
            + "alc.stage, alc.caseOn, alc.fileVerifiedBy, alc.advocate, alc.remarks, a.legalFilingDate, MAX(alch.hearingDate), m.name, mag.id, mag.name, mag.permanentAddress, \r\n"
            + "mag.landmark, mag.isDefaulter, alc.id, alch.id) from Accounts a right join Members m \r\n"
            + "on a.memberId = m.id right join AccountLegalCase alc on a.id = alc.accountId left join AccountLegalCaseHearing alch on alc.id = alch.legalcaseId \r\n"
            + "left join AccountGuarantors ag on a.id = ag.accounts.id left join \r\n"
            + "Members mag on ag.members.id = mag.id \r\n" + "group by a.id  order by alc.id")
    public List<MngLegalCaseHearing> getLoanManageCaseAndHearing();

    // Get API of "Accounts" tab inside "Loan" tab inside "Accounts"
    // tab.............
    @Query("select new com.service.banking.model.accountsModel.LoanAccountDetails(a.id, a.accountNumber, a.createdAt, m.id, m.name, m.memberNo, m.permanentAddress, "
            + "s.id, s.name, a.amount, a2.id, a2.accountNumber, m2.id, m2.name, d.id, d.name, a.accountType, a.repaymentMode, m.currentAddress, m.landmark, m2.fatherName, a.activeStatus ) from Accounts a "
            + "left join Members m on a.memberId = m.id left join Schemes s on a.schemeId = s.id left join Accounts a2 on "
            + "a.loanAgainstAccountId = a2.id left join Members m2 on a2.memberId = m2.id left join Dealers d on a.dealerId = d.id "
            + "where (a.accountType = 'Two Wheeler Loan' or a.accountType = 'AutoLoan' or a.accountType = 'Personal Loan' or "
            + " a.accountType = 'Loan Against Deposit' or a.accountType = 'Home Loan' or a.accountType = 'Mortgage Loan' or "
            + "a.accountType = 'Agriculture Loan' or a.accountType = 'Education Loan' or a.accountType = 'Gold Loan' or "
            + "a.accountType = 'Other') and a.accountNumber like %?1% order by a.createdAt desc ")
    public Page<LoanAccountDetails> getAllAccount(String search , Pageable pageable);

    // Get "LegalCaseHearing" tab inside "Manage Legal Case & Hearing" tab form
    // "Loan" tab............
    @Query(value = "select alc.id as accountLegalCaseId, max(alch.id) as accountLegalCaseHearingId,\n" +
            "alc.name , max(alch.hearing_date) as lasttHearingDate, max(alch.stage) as stage,\n" +
            "max(alch.remarks) as remarks, m.name as owner, \n" +
            "d.id as dealerId, d.name as dealerName from account_legal_case_hearing alch \n" +
            "left join account_legal_case alc on alc.id = alch.legalcase_id \n" +
            "left join accounts a on a.id = alc.account_id \n" +
            "left join members m on m.id = a.member_id \n" +
            "left join dealers d on d.id = a.dealer_id\n" +
            "where alc.id = ?1 \n" +
            "group by alc.id",
            nativeQuery = true)
    public List<iMngLegalCaseHearing> getLegalCaseHearing(Integer id);


    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id, a.accountNumber) from Accounts a WHERE a.groupType = 'Bank Accounts'")
    List<AccountDetails> getBankAccounts();

    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id, a.accountNumber) from Accounts a WHERE a.groupType = 'Bank Accounts' and a.pandLgroup = 'Bank Accounts' and a.activeStatus=1")
    List<AccountDetails> getActiveBankAccounts();


    //a.AccountNumber , a.createdAt, m.name, m.fatherName, m.currentAddress, m.phoneNos ,m.dob , m.nominee ,a.relationWithNominee , a.currentBalanceDr , mi.next_insurance_due_date ,mi.nextInsuranceDueDate ,mi.id

    @Query(value = "Select a.id as accountId, m.title as gender, a.account_type ,a.AccountNumber , a.created_at as createdAt, m.name, m.FatherName, m.CurrentAddress , \n" +
            "m.PhoneNos , a2.nominee ,a2.relationWithNominee , a.currentBalanceDr , mi.next_insurance_due_date as NextInsuranceDueDate, mi.id,\n" +
            "m.DOB, mi.name as InsuranceNumber ,sum(tr.amountDr) - sum(tr.amountCr) as balance  from accounts a\n" +
            "right join member_insurance mi  on mi.accounts_id = a.id \n" +
            "left join members m on m.id = a.member_id \n" +
            "left join transaction_row tr on a.id = tr.account_id \n" +
            "left join accounts a2 on a2.member_id = m.id and a2.account_type = 'SM' " +
            "where mi.next_insurance_due_date >= ?1 and mi.next_insurance_due_date <= ?2 \n" +
            "and \n" +
            "a.account_type = IFNULL(?3, a.account_type) and a.ActiveStatus = 1\n" +
            "group by a.id", nativeQuery = true)
    public List<iMemberInsuDetails> getMultipleInsurance(String fromDate, String toDate, String acType, String currentDate);

    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id,a.branchId) from Accounts a WHERE a.groupType = 'PF'")
    List<AccountDetails> getPFaccount();

    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id,a.branchId) from Accounts a WHERE a.groupType = 'TDS'")
    List<AccountDetails> getTDSaccount();

    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id,a.branchId) from Accounts a WHERE a.groupType = 'ESI'")
    List<AccountDetails> getESIaccount();

    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id, a.branchId, a.accountType, a.createdAt, a.amount, a.schemeId, a.agentId) from Accounts a WHERE a.id = ?1")
    AccountDetails getAccountInfoById(Integer accountId);

    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id) from Accounts a WHERE a.accountNumber LIKE ?1% and a.branchId = ?2 ")
    AccountDetails getBranchDivisionId(String branchCode, Integer branchId);

    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id) from Accounts a WHERE a.branchId = ?1 and a.accountType ='Default' and a.groupType ='Indirect Income' and a.pandLgroup ='PRE MATURE INTEREST RECEIVED' ")
    AccountDetails getClosedAccounts(Integer loginBranch);

    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id) from Accounts a WHERE a.branchId = ?1 and a.pandLgroup ='CONVEYANCE EXPENSES' ")
    AccountDetails getConveyance(Integer loginBranch);

    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id) from Accounts a WHERE a.branchId = ?1 and a.pandLgroup ='FUEL EXPENSES' ")
    AccountDetails getFuel(Integer loginBranch);

    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id, a.branchId, a.accountType, a.createdAt, a.amount, a.schemeId) from Accounts a WHERE a.branchId = ?1 and a.groupType='Cash Account' and a.accountType='Default'")
    AccountDetails getCashAccounts(Integer branchId);

    @Query(value = "select a.AccountNumber, a.created_at, m.name, m.FatherName, m.CurrentAddress, m.PhoneNos, p.Amount ,a.ActiveStatus from accounts a\r\n"
            + "left join agents ag on ag.id=a.agent_id \r\n"
            + "left join members m on m.id=a.member_id \r\n"
            + "left join premiums p on p.account_id = a.id\r\n"
            + "where ag.id = ?1\r\n"
            + "group by a.id\r\n"
            + "order by a.id ", nativeQuery = true)
    List<iAgentsAccount> getAgentAccounts(Integer id);

    @Query(value = "select account_type , count(a.account_type) as numberOfAccounts, sum(a.Amount) as totalAmount from accounts a\r\n"
            + "group by account_type", nativeQuery = true)
    List<iGeneralReport> getPeriodicalAccounts();

    @Query(value = "select a.AccountNumber, a.created_at, m.name , m.FatherName , m.PermanentAddress , m.PhoneNos, s.name as schemeName, a.MaturedStatus from accounts a \r\n"
            + "left join members m on m.id= a.member_id \r\n"
            + "left join schemes s on s.id = a.scheme_id \r\n"
            + "where not a.account_type = \"Default\" ",
            countQuery = "SELECT count(*) from accounts a where not a.account_type = \"Default\" ",
            nativeQuery = true)
    public Page<iGeneralReport> getClosingBalanceOfAccounts(Pageable pageable);

    @Query(value = "select m.name , m.member_no , m.CurrentAddress , m.is_defaulter ,a.AccountNumber ,s.SchemeGroup , m.FatherName ,m.PermanentAddress , m.PhoneNos, a.created_at , s.name as schemeName, d.name as dealerName , a.ActiveStatus from accounts a \r\n"
            + "left join members m on m.id=a.member_id \r\n"
            + "left join schemes s on s.id =a.scheme_id \r\n"
            + "left join dealers d on d.id = a.dealer_id \r\n"
            + "where a.ActiveStatus = 0",
            countQuery = "SELECT count(*) from accounts a where a.ActiveStatus = 0",
            nativeQuery = true)
    Page<iGeneralReport> getAccountCloseReport(Pageable pageable);

    @Query(value = "select a.AccountNumber , a.created_at , s.name ,(a.CurrentBalanceCr-a.CurrentBalanceDr) as closingBalance from accounts a \r\n"
            + "left join members m on m.id=a.member_id \r\n"
            + "left join schemes s on s.id =a.scheme_id \r\n"
            + "where s.id = 12", nativeQuery = true)
    List<iGeneralReport> getFixedAssetReport();

    @Query(value = "select s.name ,  count(a.id) as numberOfAccounts, sum(a.Amount) as totalAmount from accounts a \r\n"
            + "left join members m on m.id= a.member_id \r\n"
            + "left join schemes s on s.id = a.scheme_id \r\n"
            + "group by s.id ", nativeQuery = true)
    List<iGeneralReport> getSchemeWiseAccount();

    @Query(value = "select m.name, m.member_no, m.PermanentAddress, m.PhoneNos ,count(a.id) as InActiveRdAccountCount, sum(a.Amount) as InActiveRdAmountSum from accounts a \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "where a.ActiveStatus = 0 and a.account_type =\"Recurring\"\r\n"
            + "group by a.member_id ", nativeQuery = true)
    List<iDepositeReport> getRDHolders();

    @Query(value = "select m.name, m.member_no, m.PermanentAddress, m.PhoneNos ,count(a.id) as InActiveRdAccountCount, sum(a.Amount) as InActiveRdAmountSum from accounts a \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "where a.ActiveStatus = 0 and a.account_type =\"FD\"\r\n"
            + "group by a.member_id ", nativeQuery = true)
    List<iDepositeReport> getFDHolders();


    @Query(value = "select a.AccountNumber, m.name , m.member_no , m.CurrentAddress , m.is_defaulter , m.FatherName , m.PermanentAddress , m.PhoneNos , d.name as dealerName, a.bike_surrendered_by ,a.bike_surrendered_on from accounts a \r\n"
            + "left join dealers d on d.id= a.dealer_id \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "where a.bike_surrendered =1 and a.ActiveStatus =1 and \r\n"
            + "a.is_bike_returned =0 and a.is_bike_auctioned =0", nativeQuery = true)
    List<iBikeLegalReport> getBikeInStock();

    @Query(value = "select a.AccountNumber , a.bike_surrendered_on, m.PhoneNos,m.landmark ,m.tehsil , m.district,\r\n"
            + "d.name, a.bike_surrendered_by from accounts a \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "left join dealers d on d.id = a.dealer_id \r\n"
            + "where a.bike_surrendered =1 and\r\n"
            + "a.bike_surrendered_on >= ?1 and a.bike_surrendered_on <=?2 ",
            countQuery = "select count(a.id)from accounts a \r\n"
                    + "where a.bike_surrendered =1 and  a.bike_surrendered_on >= ?1 and a.bike_surrendered_on <=?2",
            nativeQuery = true)
    Page<iBikeLegalReport> getBikeS(String fromDate, String toDate, Pageable pageable);

    @Query(value = "select a.AccountNumber , a.bike_returned_on , m.PhoneNos,m.landmark ,m.tehsil , m.district,\r\n"
            + "d.name, a.bike_surrendered_by from accounts a \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "left join dealers d on d.id = a.dealer_id \r\n"
            + "where a.is_bike_returned =1 and\r\n"
            + "a.bike_returned_on >= ?1 and a.bike_returned_on <= ?2 ",
            countQuery = "select count(a.id)from accounts a \r\n"
                    + "where a.is_bike_returned =1 and a.bike_returned_on >= ?1 and a.bike_returned_on <= ?2",
            nativeQuery = true)
    Page<iBikeLegalReport> getBikeR(String fromDate, String toDate, Pageable pageable);

    @Query(value = "select a.AccountNumber , a.bike_auctioned_on , m.PhoneNos,m.landmark ,m.tehsil , m.district,\r\n"
            + "d.name, a.bike_surrendered_by from accounts a \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "left join dealers d on d.id = a.dealer_id \r\n"
            + "where a.is_bike_auctioned =1 and\r\n"
            + "a.bike_auctioned_on >= ?1  and a.bike_auctioned_on <= ?2 ",
            countQuery = "select count(a.id)from accounts a \r\n"
                    + "where a.is_bike_auctioned =1 and a.bike_auctioned_on >= ?1  and a.bike_auctioned_on <= ?2 ",
            nativeQuery = true)
    Page<iBikeLegalReport> getBikeA(String fromDate, String toDate, Pageable pageable);

    @Query(value = "select a.AccountNumber, m.name, m.member_no , m.CurrentAddress, m.is_defaulter , m.FatherName , m.PermanentAddress , m.landmark , m.tehsil , m.district , \r\n"
            + "m.PhoneNos , d.name as dealerName , a.bike_surrendered_on , bike_auctioned_on , a.Amount , a.created_at from accounts a \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "left join dealers d on d.id = a.dealer_id \r\n"
            + "where \r\n"
            + "a.is_final_recovery_notice_sent =1 and\r\n"
            + "a.is_cheque_presented_in_bank =1 and\r\n"
            + "a.is_cheque_returned =1 and\r\n"
            + "a.is_notice_sent_after_cheque_returned =0 and \r\n"
            + "a.is_in_legal =0 and\r\n"
            + "a.is_legal_case_finalised =0 and\r\n"
            + "a.ActiveStatus =1 ", nativeQuery = true)
    List<iBikeLegalReport> getCheckReturnNoticeDue();

    @Query(value = "select a.AccountNumber, m.name, m.member_no , m.CurrentAddress, m.is_defaulter , m.FatherName , m.PermanentAddress , m.landmark , m.tehsil , m.district , \r\n"
            + "m.PhoneNos , d.name as dealerName , a.bike_surrendered_on , bike_auctioned_on , a.legal_process_given_date , a.Amount , a.created_at ,a.legal_case_not_submitted_reason ,\r\n"
            + "count(p.id) as NoOfEmi, p.Amount as EmiAmount from accounts a \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "left join dealers d on d.id = a.dealer_id \r\n"
            + "left join premiums p on p.account_id = a.id\r\n"
            + "where a.is_in_arbitration=0 and a.ActiveStatus =1 and a.is_final_recovery_notice_sent =0 and a.is_given_for_legal_process =1 and a.is_legal_case_finalised =0\r\n"
            + "and (a.legal_case_not_submitted_reason =\" \" or a.legal_case_not_submitted_reason = null or a.legal_case_not_submitted_reason = 0)\r\n"
            + "group by p.account_id ", nativeQuery = true)
    List<iBikeLegalReport> getFinalRecoveryNoticeDue();

    @Query(value = "select a.AccountNumber, m.name, m.member_no , m.CurrentAddress, m.is_defaulter , m.FatherName , m.PermanentAddress , m.landmark , m.tehsil , m.district , \r\n"
            + "m.PhoneNos , d.name as dealerName , a.bike_surrendered_on , bike_auctioned_on , a.Amount , a.created_at, a.cheque_returned_on , a.notice_sent_after_cheque_returned_on from accounts a \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "left join dealers d on d.id = a.dealer_id \r\n"
            + "where a.is_final_recovery_notice_sent =1 and a.is_cheque_presented_in_bank =1 and a.is_cheque_returned =1 and a.is_in_arbitration =0\r\n"
            + "and a.is_in_legal =0 and a.ActiveStatus =1 and a.is_notice_sent_after_cheque_returned =1 ", nativeQuery = true)
    List<iBikeLegalReport> getLegalCaseSubmitDue();

    @Query(value = "select a.AccountNumber, m.name, m.member_no , m.CurrentAddress, m.is_defaulter , m.FatherName , m.PermanentAddress , m.landmark , m.tehsil , m.district , \r\n"
            + "m.PhoneNos , d.name as dealerName , a.bike_surrendered_on , a.bike_not_sold_reason , a.Amount , a.created_at from accounts a \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "left join dealers d on d.id = a.dealer_id \r\n"
            + "where a.DefaultAC =0 and a.bike_surrendered =1 and a.is_bike_returned = 0 and a.is_bike_auctioned =0 and \r\n"
            + "(Not a.bike_not_sold_reason = null or not a.bike_not_sold_reason = \" \") ", nativeQuery = true)
    List<iBikeLegalReport> getBikeNotSoldDueTo();

    @Query(value = "select a.AccountNumber, m.name, m.member_no , m.CurrentAddress, m.is_defaulter , m.FatherName , m.PermanentAddress , m.landmark , m.tehsil , m.district , \r\n"
            + "m.PhoneNos , d.name as dealerName , a.bike_surrendered_on , a.final_recovery_notice_sent_on , a.legal_case_not_submitted_reason , a.Amount , a.created_at from accounts a \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "left join dealers d on d.id = a.dealer_id \r\n"
            + "where a.is_given_for_legal_process = 1 and a.is_in_legal =0 and \r\n"
            + "(not a.legal_case_not_submitted_reason = \" \" or not a.legal_case_not_submitted_reason= null) and \r\n"
            + "a.is_legal_case_finalised = 0 and a.is_in_arbitration =0", nativeQuery = true)
    List<iBikeLegalReport> getLegalCaseNotSubmitDueTo();

    @Query(value = "select a.AccountNumber, m.name, m.member_no , m.CurrentAddress, m.is_defaulter , m.FatherName , m.PermanentAddress , m.landmark , m.tehsil , m.district , \r\n"
            + "m.PhoneNos , d.name as dealerName , a.bike_surrendered_on , a.final_recovery_notice_sent_on , a.bike_auctioned_on , a.Amount , a.created_at from accounts a \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "left join dealers d on d.id = a.dealer_id \r\n"
            + "where a.ActiveStatus = 1 and a.is_final_recovery_notice_sent = 1 and \r\n"
            + "a.is_cheque_presented_in_bank = 1 and a.is_cheque_returned  = 0 and \r\n"
            + "a.is_legal_case_finalised = 0 and \r\n"
            + "(a.legal_case_not_submitted_reason = \"\" or a.legal_case_not_submitted_reason = null or a.legal_case_not_submitted_reason = 0)", nativeQuery = true)
    List<iBikeLegalReport> getChequeActionPending();

    @Query(value = "select a.AccountNumber, m.name, m.member_no , m.CurrentAddress, m.is_defaulter , m.FatherName , m.PermanentAddress , m.landmark , m.tehsil , m.district , \r\n"
            + "m.PhoneNos , d.name as dealerName , a.bike_surrendered_on  , a.Amount , a.created_at ,\r\n"
            + " a.arbitration_on from accounts a \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "left join dealers d on d.id = a.dealer_id \r\n"
            + "where a.is_legal_case_finalised = 0 and a.is_in_legal = 0 and \r\n"
            + "a.is_in_arbitration = 1", nativeQuery = true)
    List<iBikeLegalReport> getArbitrationCaseDetailReport();

    @Query(value = "select a.AccountNumber, m.name, m.member_no , m.CurrentAddress, m.is_defaulter , m.FatherName , m.PermanentAddress , m.landmark , m.tehsil , m.district , \r\n"
            + "m.PhoneNos , d.name as dealerName , a.legal_process_given_date  , a.legal_filing_date , a.legal_case_finalised_on , a.Amount , a.created_at from accounts a \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "left join dealers d on d.id = a.dealer_id \r\n"
            + "where \r\n"
            + "case\r\n"
            + "when a.is_in_legal = ?1 then ( a.is_in_legal = 1 and is_given_for_legal_process =1 and a.is_legal_case_finalised =1 )\r\n"
            + "when a.is_given_for_legal_process = ?2 then ( a.is_in_legal = 0 and a.is_in_arbitration =0 and a.is_given_for_legal_process = 1 and a.is_legal_case_finalised = 1 )\r\n"
            + "when a.is_in_arbitration = ?3 then ( is_in_legal = 0 and a.is_in_arbitration = 1 and a.is_legal_case_finalised = 1 and a.is_given_for_legal_process =1 )\r\n"
            + "when\r\n"
            + "(a.is_in_legal = ?1 and a.is_given_for_legal_process = ?2 and a.is_in_arbitration = ?3) then (a.is_in_legal =1 and a.is_given_for_legal_process =1 and a.is_in_arbitration =1 and a.is_legal_case_finalised =1)\r\n"
            + "end", nativeQuery = true)
    List<iBikeLegalReport> getLegalFinalised(Boolean legal, Boolean process, Boolean arbitration);

    @Query(value = "select a.id , a.AccountNumber from accounts a\r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "where m.id= ?1 and a.account_type = \"SM\" ",
            nativeQuery = true)
    List<iMemberReport> getSMAccounts(Integer memberId);

    @Query(value = "select m.id , m.member_no , a.AccountNumber from accounts a \r\n"
            + "left join members m on m.id = a.member_id\r\n"
            + "where a.account_type = \"SM\" ",
            nativeQuery = true)
    List<iMemberReport> getSMMember();

    @Query(value = "select a.AccountNumber from accounts a \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "where a.account_type =  \"Saving\" and m.id = ?1 ",
            nativeQuery = true)
    List<iMemberReport> getSaving(Integer memberId);

    @Query(value = "select a.AccountNumber from accounts a \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "where a.ActiveStatus = 0 and m.id = ?1 ",
            nativeQuery = true)
    List<iMemberReport> getNonActive(Integer memberId);

    @Query(value = "select a.id, d.name as documentName, a.AccountNumber , m.name , m.FatherName ,ds.Description , d2.name as dealerName, ds.submitted_on,\r\n"
            + "a2.code_no , m2.name as agentName, m2.member_no , m2.PermanentAddress , m2.is_defaulter \r\n"
            + "from documents_submitted ds \r\n"
            + "left join accounts a on a.id = ds.accounts_id \r\n"
            + "left join documents d on ds.documents_id = d.id\r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "left join dealers d2 on d2.id = a.dealer_id \r\n"
            + "left join agents a2 on a2.id= a.agent_id \r\n"
            + "left join members m2 on m2.id = a2.member_id \r\n"
            + "where a.id = ?1 ",
            nativeQuery = true)
    List<iAccountDetails> getAccountDocuments(Integer id);

    @Query(value = "select mi.insurance_start_date , mi.next_insurance_due_date , mi.narration from accounts a \r\n"
            + "left join member_insurance mi on a.member_id = mi.member_id \r\n"
            + "where a.id = ?1 ",
            nativeQuery = true)
    List<iAccountDetails> getAccountInsurance(Integer id);

    @Query(value = "select m.name, m.member_no , m.PermanentAddress , m.landmark, m.is_defaulter , m.FatherName , m.PhoneNos , m.created_at from accounts a \r\n"
            + "left join account_guarantors ag on ag.account_id = a.id \r\n"
            + "left join members m on m.id = ag.member_id \r\n"
            + "where a.id = ?1 ",
            nativeQuery = true)
    List<iAccountDetails> getAccountGaurantors(Integer id);

    @Query(value = "select a.account_type from accounts a \r\n"
            + "where a.id = ?1 ",
            nativeQuery = true)
    String getAccountType(Integer id);

    @Query(value = "select DATE_ADD(DATE(a.created_at) , INTERVAL s.MaturityPeriod DAY) as maturityDate from accounts a \r\n"
            + "left join schemes s on s.id = a.scheme_id \r\n"
            + "where a.id = ?1",
            nativeQuery = true)
    iAccountDetails getMaturityDateFDMIS(Integer id);

    @Query(value = "select DATE_ADD(DATE(a.created_at) , INTERVAL s.MaturityPeriod MONTH) as maturityDate from accounts a \r\n"
            + "left join schemes s on s.id = a.scheme_id \r\n"
            + "where a.id = ?1 ",
            nativeQuery = true)
    iAccountDetails getMaturityDate(Integer id);

    @Query("select new com.service.banking.model.superAdminModel.StaffModel(count(a.id) as accounts) from Accounts a left join Staffs s on s.id = a.staffId \r\n"
            + "where s.id = ?1 ")
    StaffModel getStaffAccounts(Integer id);

    @Query(value = "select a.id, a.AccountNumber , m.name , m.FatherName , m.PermanentAddress , m.is_defaulter , s.name as schemeName from accounts a \r\n"
            + "left join members m on m.id = a.member_id \r\n"
            + "left join schemes s on s.id = a.scheme_id \r\n"
            + "where a.is_dirty = 1",
            nativeQuery = true)
    List<iAccountDetails> getDirtyAccounts();

    @Query(value = "select count(*) from accounts a \r\n"
            + "where a.scheme_id = ?1 ",
            nativeQuery = true)
    Integer getAccountCount(Integer id);

    @Query(value = "select count(*) from transaction_row tr \r\n"
            + "where tr.scheme_id = ?1 ",
            nativeQuery = true)
    Integer getTransactionCount(Integer Id);

    @Query(value = "select * from accounts a \r\n"
            + "where a.AccountNumber LIKE CONCAT(?2,'%',?1)",
            nativeQuery = true)
    List<Accounts> getSchemeDefaultAccounts(String name, String code);

    @Query(value = "select a.id from accounts a \n" +
            "where a.AccountNumber = CONCAT(?1, ' ADMISSION FEE') ",
            nativeQuery = true)
    Integer getAdmissionAccounts(String branchCode);

    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id, a.accountNumber, m.name ,m.fatherName) from Accounts a \r\n"
            + "left join Members m on m.id=a.memberId " +
            " where a.memberId = IFNULL(?1, a.memberId) and a.accountType = 'saving' and a.activeStatus = 1 ")
    List<AccountDetails> getSavingAccount(Integer id);

    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id, a.accountNumber, m.name ,m.fatherName) from Accounts a \r\n"
            + "left join Members m on m.id=a.memberId " +
            " where (a.accountNumber Like '%CASH ACCOUNT' or a.accountNumber like '%MEMBERSHIP ADVANCE AMOUNT') and\n" +
            " a.branchId = ?1")
    List<AccountDetails> getDebitAccount(Integer branchId);

    @Query(value = "SELECT * from accounts a \n" +
            "where a.member_id = ?1",
            nativeQuery = true)
    List<Accounts> findAccounts(Integer id);

    @Query(value = "select a.AccountNumber from  accounts a \n" +
            "where a.account_type = \"SM\"\n" +
            "order by a.id DESC\n" +
            "limit 1",
            nativeQuery = true)
    String getLastSMAccount();

    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id, a.accountNumber, m.name, m.fatherName, a.accountType) from Accounts a left join Members m on m.id= a.memberId where (a.accountNumber LIKE %?1% or m.name LIKE %?1%) and (a.groupType = 'Loan') and (a.activeStatus = 1) order by a.accountNumber")
    List<AccountDetails> getAllLoanAccounts(String accountNumber);

    @Query(value = "select a.id from accounts a \n" +
            "where a.member_id = ?1 and a.account_type = \"SM\"",
            nativeQuery = true)
    Integer checkSMMember(int memberId);

    @Query(value = "select a.AccountNumber from accounts a \n" +
            "where a.group_type = ?2 \n" +
            "and a.PAndLGroup = ?2 \n" +
            "and a.branch_id = ?1 \n" +
            "order by a.id DESC limit 1 ",
            nativeQuery = true)
    String getLastSavingAccount(Integer branchId, String accountType);

    @Query(value = "select a.AccountNumber from accounts a \n" +
            "where a.account_type = ?2 \n" +
            "and a.branch_id = ?1 \n" +
            "order by a.id DESC limit 1 ",
            nativeQuery = true)
    String getLastFDMISaccount(Integer branchId, String accountType);

    @Query(value = "select a.id, a.AccountNumber , a.created_at, m.name, m.CurrentAddress , m.PermanentAddress , m.FatherName, a2.AccountNumber as smAccount, a.Amount,\n" +
            "m2.name as guarantorName, m2.FatherName as guarantorFatherName, m2.PermanentAddress as guarantorPermanentAddress,  m.PhoneNos from accounts a \n" +
            "left join members m on m.id = a.member_id \n" +
            "left join accounts a2 on m.id = a2.member_id  and a2.account_type = \"SM\"\n" +
            "left join branches b on b.id = a.branch_id \n" +
            "left join account_guarantors ag on ag.account_id = a.id \n" +
            "left join members m2 on m2.id = ag.member_id \n" +
            "where a.AccountNumber = ?1",
            nativeQuery = true)
    iPrintContent printContentAcntDetails(String ac);

    @Query(value = "select a.id  from accounts a \n" +
            "where a.AccountNumber like concat('%',?1,'%')\n" +
            "and a.branch_id = ?2 ",
            nativeQuery = true)
    Integer getTransactionTypeAccountId(String name, Integer branchId);

    @Query(value = "select a.id from accounts a \n" +
            "where a.AccountNumber like '%SGST 9%'\n" +
            "and a.branch_id = ?1 ",
            nativeQuery = true)
    Integer getAccountIdForSGST9(Integer branchId);

    @Query(value = "select a.id from accounts a \n" +
            "where a.AccountNumber like '%CGST 9%'\n" +
            "and a.branch_id = ?1 ",
            nativeQuery = true)
    Integer getAccountIdForCGST9(Integer branchId);

    @Query(value = "select a.id from accounts a \n" +
            "where a.AccountNumber like '%SGST 14%'\n" +
            "and a.branch_id = ?1 ",
            nativeQuery = true)
    Integer getAccountIdForSGST14(Integer branchId);

    @Query(value = "select a.id from accounts a \n" +
            "where a.AccountNumber like '%SGST 2.5'\n" +
            "and a.branch_id = ?1 ",
            nativeQuery = true)
    Integer getAccountIdForSGST2_5(Integer branchId);

    @Query(value = "select a.id from accounts a \n" +
            "where a.AccountNumber like '%SGST 6%'\n" +
            "and a.branch_id = ?1 ",
            nativeQuery = true)
    Integer getAccountIdForSGST6(Integer branchId);

    @Query(value = "select a.id from accounts a \n" +
            "where a.AccountNumber like '%CGST 14%'\n" +
            "and a.branch_id = ?1 ",
            nativeQuery = true)
    Integer getAccountIdForCGST14(Integer branchId);

    @Query(value = "select a.id from accounts a \n" +
            "where a.AccountNumber like '%CGST 2.5'\n" +
            "and a.branch_id = ?1 ",
            nativeQuery = true)
    Integer getAccountIdForCGST2_5(Integer branchId);

    @Query(value = "select a.id from accounts a \n" +
            "where a.AccountNumber like '%CGST 6%'\n" +
            "and a.branch_id = ?1 ",
            nativeQuery = true)
    Integer getAccountIdForCGST6(Integer branchId);

    @Query(value = "select a.id from accounts a \n" +
            "where a.AccountNumber like '%IGST 18%'\n" +
            "and a.branch_id = ?1 ",
            nativeQuery = true)
    Integer getAccountIdForIGST18(Integer branchId);

    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id, a.accountNumber, m.name, m.fatherName, a.accountType, a.groupType, a.maturedStatus) from Accounts a left join Members m on m.id= a.memberId where (a.accountNumber LIKE %?1% or m.name LIKE %?1%) and (NOT a.groupType = 'Loan') order by a.accountNumber")
    List<AccountDetails> getWithdrawAccounts(String accountNumber);

    @Query("select new com.service.banking.model.accountsModel.AccountDetails(a.id, a.accountNumber, m.name, m.fatherName, a.accountType) from Accounts a left join Members m on m.id= a.memberId where (a.accountNumber LIKE %?1% or m.name LIKE %?1%) and (a.groupType = 'Loan') and (a.activeStatus = 1) order by a.accountNumber")
    List<AccountDetails> getForClosedAccounts(String accountNumber);

    @Query(value = "select a.id from accounts a \r\n"
            + "where a.AccountNumber LIKE CONCAT(?1,' Collection Charges Paid On ',?2)",
            nativeQuery = true)
    Integer getCollectionSchemeAccountId(String code, String name);

    @Query(value = "select a.id from accounts a \r\n"
            + "where a.AccountNumber LIKE CONCAT(?1,' TDS') and a.group_type = 'TDS'",
            nativeQuery = true)
    Integer getTDSaccountID(String branchCode);

    @Query(value = "select a.id from accounts a \r\n"
            + "where a.AccountNumber LIKE CONCAT(?1,' Commission Paid On ',?2)",
            nativeQuery = true)
    Integer getCommissionSchemeAccountId(String branchCode, String name);

    @Query(value = "select a.id, s.`type` , s.name , p.Amount , MAX(p.DueDate) as lastPremiumDate, \n" +
            "a.AccountNumber , a.ModeOfOperation,\n" +
            "count (case when p.PaidOn is null then p.id else null end) as paidPremiums,\n" +
            "count (case when not p.PaidOn is null then p.id else null end) as duePremiums,\n" +
            "count (p.id) as totalPremiums ,\n" +
            "s.pre_mature_interests , a.created_at\n" +
            "from accounts a \n" +
            "left join schemes s on s.id = a.scheme_id \n" +
            "left join premiums p on p.account_id = a.id\n" +
            "where a.id = ?1 \n" +
            "group by p.account_id ",
            nativeQuery = true)
    IPreviewDetails getPreview(Integer accountId);

    @Query( "select new com.service.banking.model.GstModel.AccountDetail(a.id, a.accountNumber ) from Accounts a \n" +
            "where a.groupType = 'Sundry Creditor' and a.pandLgroup = 'Sundry Creditor' \n" +
            "and a.branchId = ?1 ")
    List<AccountDetail> getSuppliers(Integer branchId);
}
