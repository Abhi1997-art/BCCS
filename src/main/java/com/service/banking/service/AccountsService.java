package com.service.banking.service;

import java.math.BigDecimal;
import java.util.*;

import com.google.gson.Gson;
import com.service.banking.hibernateEntity.*;
import com.service.banking.model.GstModel.AccountStatementDetail;
import com.service.banking.model.accountsModel.*;
import com.service.banking.model.hodAuthorityModel.iDeleteVoucherDetails;
import com.service.banking.model.transaction.DepositeDetails;
import com.service.banking.repository.AccountsRepo.*;
import com.service.banking.repository.gstRepository.MemorandomAccountStatement;
import com.service.banking.repository.hodAuthorityRepo.PremuimRepo;
import com.service.banking.repository.madRepository.AgentsRepositoty;
import com.service.banking.repository.superAdminRepo.BranchesRepository;
import com.service.banking.repository.superAdminRepo.ShareCertificateRepo;
import com.service.banking.repository.superAdminRepo.ShareRepository;
import com.service.banking.repository.transaction.TransactionRowRepo;
import com.service.banking.repository.transaction.TransactionsRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.service.banking.model.MadModel.DealerDeatails;
import com.service.banking.model.dashboardModel.DueDeatailsModel;
import com.service.banking.model.dashboardModel.SchemaDetail;
import com.service.banking.model.hodAuthorityModel.AssociationDetails;
import com.service.banking.model.hodAuthorityModel.MoRoDetails;
import com.service.banking.model.hodAuthorityModel.Teamdetails;
import com.service.banking.model.stockModel.LedgerItemDetails;
import com.service.banking.repository.dashBoardRepo.DashBoardSchemeRepo;
import com.service.banking.repository.hodAuthorityRepo.MoAssociationRepo;
import com.service.banking.repository.hodAuthorityRepo.TeamRepository;
import com.service.banking.repository.madRepository.DealerRepository;
import com.service.banking.repository.madRepository.MembersRepo;
import com.service.banking.utils.DateFormater;

@Service
public class AccountsService {

    @Autowired
    AccountsRepo smAccountsRepo;

    @Autowired
    AccountNocMangRepo nocRepo;

    @Autowired
    LoanPendingRepo loanRepo;

    @Autowired
    MembersRepo membersRepo;

    @Autowired
    JointMemberRepo jointmemberrepo;

    @Autowired
    DashBoardSchemeRepo schemeRepo;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    DocumentsSubmittedRepo docSubmittedRepo;

    @Autowired
    CommentsRepo commentRepo;

    @Autowired
    AccountGuarantorRepo accountGuarantorRepo;

    @Autowired
    AccountLegalCaseRepo alcRepo;

    @Autowired
    AccountLegalCaseHearingRepo alchRepo;

    @Autowired
    MoAssociationRepo moAssociationRepo;

    @Autowired
    DealerRepository dealerRepo;

    @Autowired
    DocumentsRepo documnetsRepo;

    @Autowired
    AccountsRepo accountsRepo;

    @Autowired
    BranchesRepository branchesRepository;

    @Autowired
    TransactionService transactionService;

    @Autowired
    ShareRepository shareRepository;

    @Autowired
    ShareCertificateRepo shareCertificateRepo;

    @Autowired
    TransactionRowRepo transactionRowRepo;

    @Autowired
    TransactionsRepo transactionsRepo;

    @Autowired
    PremuimRepo premuimRepo;

    @Autowired
    BikeSurrenderHistoryRepo bikeSurrenderHistoryRepo;

    @Autowired
    AgentsRepositoty agentsRepositoty;

    @Autowired
    MemorandomAccountStatement memorandomTransRow;


    DateFormater dateformater = new DateFormater();

    // get all sm accounts  .....................................................
    public Map<String, Object> smAccounts(Integer setPageNumber, Integer setMaxResults) {
        //Pageable paging = PageRequest.of(setFirstResults, setMaxResults);
        Pageable pageable = PageRequest.of(setPageNumber, setMaxResults);
        Page<SMAccountsDetails> smList = smAccountsRepo.smAccounts(pageable);
        Map<String, Object> monthMap = new HashMap<String, Object>();
        if (smList.hasContent()) {
            monthMap.put("pageSize", smList.getSize());
            monthMap.put("totalElement", smList.getTotalElements());
            monthMap.put("totalPage", smList.getTotalPages());
            monthMap.put("ShareDetail", smList.getContent());
            return monthMap;
        } else {
            return monthMap;
        }
    }


    // get all saving  accounts  .....................................................
    public Map<String, Object> savingAccounts(Integer setPageNumber, Integer setMaxResults) {
        // Pageable paging = PageRequest.of(setFirstResults, setMaxResults);
        Pageable pageable = PageRequest.of(setPageNumber, setMaxResults);
        Page<SavingAccountDetails> svList = smAccountsRepo.savingAccounts(pageable);
        Map<String, Object> monthMap = new HashMap<String, Object>();
        if (svList.hasContent()) {
            monthMap.put("pageSize", svList.getSize());
            monthMap.put("totalElement", svList.getTotalElements());
            monthMap.put("totalPage", svList.getTotalPages());
            monthMap.put("ShareDetail", svList.getContent());
            return monthMap;
        } else {
            return monthMap;
        }
    }

    // get all DDS accounts .....................................................
    public List<DDSAccountDetails> DDSAccounts() {
        // Pageable paging = PageRequest.of(setFirstResults, setMaxResults);
        List<DDSAccountDetails> ddsList = smAccountsRepo.DDSAccounts();
        if (ddsList.size() != 0) {
            return ddsList;
        } else {
            return new ArrayList<DDSAccountDetails>();
        }
    }

    // get all recuring accounts
    // .....................................................
    public Map<String, Object> RecurringAccounts(Integer setPageNumber, Integer setMaxResults) {
        // Pageable paging = PageRequest.of(setFirstResults, setMaxResults);
        Pageable pageable = PageRequest.of(setPageNumber, setMaxResults);
        Page<RecurringAccountDetails> reccList = smAccountsRepo.RecurringAccounts(pageable);
        Map<String, Object> monthMap = new HashMap<String, Object>();
        if (reccList.hasContent()) {
            monthMap.put("pageSize", reccList.getSize());
            monthMap.put("totalElement", reccList.getTotalElements());
            monthMap.put("totalPage", reccList.getTotalPages());
            monthMap.put("ShareDetail", reccList.getContent());
            return monthMap;
        } else {
            return monthMap;
        }
    }

    // get all fixedand mixed  accounts  .....................................................
    public Map<String, Object> fixedAccounts(Integer setPageNumber, Integer setMaxResults) {
        //Pageable paging = PageRequest.of(setFirstResults, setMaxResults);
        Pageable pageable = PageRequest.of(setPageNumber, setMaxResults);
        Page<FixedAccountDetails> fixedList = smAccountsRepo.FixedAccounts(pageable);
        Map<String, Object> monthMap = new HashMap<String, Object>();
        if (fixedList.hasContent()) {
            monthMap.put("pageSize", fixedList.getSize());
            monthMap.put("totalElement", fixedList.getTotalElements());
            monthMap.put("totalPage", fixedList.getTotalPages());
            monthMap.put("ShareDetail", fixedList.getContent());
            return monthMap;
        } else {
            return monthMap;
        }
    }

    // get all others  accounts  .......................................................
    public Map<String, Object> otherAccounts(Integer setPageNumber, Integer setMaxResults) {
        //Pageable paging = PageRequest.of(setFirstResults, setMaxResults);
        Pageable pageable = PageRequest.of(setPageNumber, setMaxResults);
        Page<OtherAccountDetails> otherList = smAccountsRepo.OthersAccounts(pageable);
        Map<String, Object> monthMap = new HashMap<String, Object>();
        if (otherList.hasContent()) {
            monthMap.put("pageSize", otherList.getSize());
            monthMap.put("totalElement", otherList.getTotalElements());
            monthMap.put("totalPage", otherList.getTotalPages());
            monthMap.put("ShareDetail", otherList.getContent());
            return monthMap;
        } else {
            return monthMap;
        }
    }


    // get LOAN PENDING accounts  .......................................................
    public List<PendingLoanDetails> loanPending() {
        //Pageable paging = PageRequest.of(setFirstResults, setMaxResults);
        List<PendingLoanDetails> pendList = loanRepo.loanPending();
        if (pendList.size() != 0) {
            return pendList;
        } else {
            return new ArrayList<PendingLoanDetails>();
        }
    }

    // get manage surrender bike legal accounts  .......................................................
    public Map<String, Object> manageSuurenderBike(Integer setPageNumber, Integer setMaxResults, String search) {
        //Pageable paging = PageRequest.of(setFirstResults, setMaxResults);

        Pageable pageable = PageRequest.of(setPageNumber, setMaxResults);
        Page<MngSuurenderBikeDetails> manageSuurenderBike = smAccountsRepo.manageSuurenderBike(search, pageable);
        Map<String, Object> monthMap = new HashMap<String, Object>();
        if (manageSuurenderBike.hasContent()) {
            monthMap.put("pageSize", manageSuurenderBike.getSize());
            monthMap.put("totalElement", manageSuurenderBike.getTotalElements());
            monthMap.put("totalPage", manageSuurenderBike.getTotalPages());
            monthMap.put("ShareDetail", manageSuurenderBike.getContent());
            return monthMap;
        } else {
            return monthMap;
        }

    }

    // Get "Manage Legal Case & Hearing" tab form "Loan" tab............
    public List<MngLegalCaseHearing> getLoanManageCaseAndHearing() {
        List<MngLegalCaseHearing> loanManageCaseAndHearing = smAccountsRepo.getLoanManageCaseAndHearing();
        System.out.println("*********" + loanManageCaseAndHearing.size());
        if (loanManageCaseAndHearing.size() != 0) {
            return loanManageCaseAndHearing;
        } else {
            return new ArrayList<>();
        }
    }
    //***************************** get accounts statement ****************************

    // all account ........................................
    @PostMapping("/account_statement/accounts")
    public List<AccountDetails> getAccounts() {
        List<AccountDetails> accList = smAccountsRepo.getAccounts();  // null check already in service.... return ledgerItem;
        if (accList.size() != 0) {
            return accList;
        } else {
            return new ArrayList<AccountDetails>();
        }
    }


    // account statement.......................................................
    public List<AccountStatementDetails> getAccountStatement(Integer accountId, String fromDate, String toDate) {
        Date from_Date1 = null;
        Date to_Date1 = null;
        if (fromDate == null) {
            from_Date1 = DateFormater.getOldDate();
        } else {
            from_Date1 = dateformater.getFromatDate(fromDate);
        }
        if (toDate == null) {
            to_Date1 = DateFormater.getCurrentDate();
        } else {
            to_Date1 = dateformater.getFromatDate(toDate);
        }

        Date firstTransactionDate = new Date();
        if(!from_Date1.equals("2001-01-01")){
            firstTransactionDate = transactionRowRepo.firstTransactionDate(accountId);
        }

        Double openingBalance= 0.0;
        if(from_Date1.after(firstTransactionDate)){
            openingBalance = transactionRowRepo.getOpeningbalance(accountId, firstTransactionDate, from_Date1);
        }
        System.out.println("Opening " + openingBalance);


        List<AccountStatementDetails> staffList = transactionRowRepo.getAccountStatement(from_Date1, to_Date1, accountId);
        System.out.println(staffList.size());
        AccountStatementDetails accountStatementDetails = new AccountStatementDetails();
        if(openingBalance < 0)
            accountStatementDetails.setAmountDr(BigDecimal.valueOf(openingBalance));
        else
            accountStatementDetails.setAmountCr(BigDecimal.valueOf(openingBalance));

        accountStatementDetails.setNarration("Opening Balance ");

        staffList.add(0, accountStatementDetails);

        if (staffList.size() != 0) {
            return staffList;
        } else {
            return new ArrayList<AccountStatementDetails>();
        }
    }

    //*****************************  noc management ****************************

    // Send noc ......................................................
    public List<SendNocDetails> nocSendMnagement(String search) {
        List<SendNocDetails> sendnoc = nocRepo.getSendNoc(search);

        if (sendnoc.size() != 0) {
            return sendnoc;
        } else {
            return new ArrayList<SendNocDetails>();
        }
    }

    // return noc ......................................................
    public List<ReturnNocDetails> returnNoc() {
        List<ReturnNocDetails> returnNoc = nocRepo.returnNoc(); // null check already in service....
        // return ledgerItem;
        if (returnNoc.size() != 0) {
            return returnNoc;
        } else {
            return new ArrayList<ReturnNocDetails>();
        }
    }

    // receive noc ............................................................
    public List<iReceiveNocDetails> receiveNoc() {
        List<iReceiveNocDetails> receiveNoc = nocRepo.receiveNoc();
        if (receiveNoc.size() != 0) {
            return receiveNoc;
        } else {
            return new ArrayList<iReceiveNocDetails>();
        }
    }


    //Add SM account.......................................
    public String addSMaccount(SMAccountsDetails sm) {
        Accounts accounts = new Accounts();

        String lastAccountNumber = smAccountsRepo.getLastSMAccount();
        Integer lastSMAccount = Integer.parseInt(lastAccountNumber.replaceAll("[\\D]", ""));
        lastSMAccount += 1;
        accounts.setAccountNumber("SM" + lastSMAccount);
        accounts.setAmount(sm.getAmount());

        Integer checkMember = accountsRepo.checkSMMember(sm.getMemberId());

        if (checkMember != null) {
            return "SM Account for this member already exist !";
        }

        accounts.setMemberId(sm.getMemberId());
        accounts.setSchemeId(sm.getSchemeId());
        accounts.setBranchId(sm.getBranchId());
        accounts.setNominee(sm.getNominee());
        accounts.setNomineeAge(sm.getNomineeAge());
        accounts.setRelationWithNominee(sm.getRelationWithNominee());
        accounts.setActiveStatus(sm.getActiveStatus());
        accounts.setAccountType("SM");
        Date date = new Date();
        accounts.setCreatedAt(date);
        accounts.setStaffId(0);
        accounts.setPandLgroup(" ");
        accounts.setDealerId(0);
        accounts.setIsDirty((byte) 0);
        accounts.setBikeSurrendered((byte) 0);
        accounts.setIsInLegal((byte) 0);
        accounts.setInsuranceTenure("1 year");
        accounts.setBankAccountLimit(0);
        accounts.setStaffId(sm.getStaffId());
        smAccountsRepo.save(accounts);

        //Make transaction for new member...................................................
        AccountDetails accountDetailsFrom = new AccountDetails();
        if (sm.getDebitAccount() == null) {
            accountDetailsFrom = accountsRepo.getCashAccounts(sm.getBranchId());
        } else {
            accountDetailsFrom = accountsRepo.getAccountInfoById(sm.getDebitAccount());
        }

        System.out.println(accountDetailsFrom.getId());
        Branches branches = branchesRepository.getOne(sm.getBranchId());
        String branchCode = branches.getCode();
        System.out.println(branchCode);

        Integer accountToId = accounts.getId();
        System.out.println(accountToId);

        DepositeDetails depositeDetails = new DepositeDetails();
        depositeDetails.setStaffId(sm.getStaffId());
        Members members = membersRepo.findById(sm.getMemberId()).get();
        depositeDetails.setNarration("Share Account Opened For Member " + members.getName() + " [" + members.getMemberNo() + "] ");
        depositeDetails.setAmount(sm.getAmount());

        //Create transaction........................................
        transactionService.createTransactions(depositeDetails, accountDetailsFrom.getId(), accountToId, 38, accountToId, branches.getId());

        //Create Shares..............................................
        ShareCertificate shareCertificate = new ShareCertificate();

        Integer lastShareCertificateName = shareCertificateRepo.getLastShareCertificateName();
        Integer currentSCName = lastShareCertificateName + 1;

        shareCertificate.setName(currentSCName);
        shareCertificate.setStatus("Issued");
        shareCertificate.setCreatedAt(new Date());
        shareCertificate.setSubmittedAt(new Date());
        shareCertificateRepo.save(shareCertificate);

        Integer SharesAmount = (sm.getAmount().intValue());
        Integer ShareCount = SharesAmount / 100;

        Integer lastNo = shareRepository.getLastNo();
        for (int i = 0; i < ShareCount; i++) {
            Share share = new Share();
            share.setCurrentMemberId(sm.getMemberId());
            share.setBuybackLockingMonths("36");
            share.setTransferLockingMonths("36");
            share.setShareCertificateId(shareCertificate.getId());
            share.setStatus("Issued");
            lastNo++;
            share.setNo(lastNo);
            shareRepository.save(share);
        }

        return "Account Added Successfully.";
    }


    public void addOtherAccount(OtherAccountDetails oa) {
        Accounts accounts = new Accounts();
        accounts.setAccountNumber(oa.getAccountNumber());
        accounts.setMemberId(oa.getMemberId());
        accounts.setSchemeId(oa.getSchemaId());
        accounts.setActiveStatus(oa.getActiveStatus());
        accounts.setAccountType(oa.getAccountType());
        accounts.setStaffId(oa.getStaffId());
        accounts.setBranchId(oa.getBranchId());
        accounts.setPandLgroup(oa.getPAndLGroup());
        accounts.setCreatedAt(new Date());
        accounts.setDealerId(0);
        accounts.setIsDirty((byte) 0);
        accounts.setBikeSurrendered((byte) 0);
        accounts.setIsInLegal((byte) 0);
        accounts.setInsuranceTenure("1 year");
        accounts.setBankAccountLimit(0);
        smAccountsRepo.save(accounts);
    }


    //Update SM account..............................................
    public void editSMaccount(SMAccountsDetails sm) {
        Accounts accounts = smAccountsRepo.getOne(sm.getId());
        accounts.setAccountNumber(sm.getAccountNumber());
        accounts.setAmount(sm.getAmount());
        accounts.setMemberId(sm.getMemberId());
        accounts.setNominee(sm.getNominee());
        accounts.setNomineeAge(sm.getNomineeAge());
        accounts.setRelationWithNominee(sm.getRelationWithNominee());
        accounts.setActiveStatus(sm.getActiveStatus());
        smAccountsRepo.save(accounts);
    }

    //Add Saving account...........................................................
    public void addSavingAccount(SavingAccountDetails sm) {
        Accounts accounts = new Accounts();
        Jointmembers jointmembers = new Jointmembers();

        String lastAccountNumber = smAccountsRepo.getLastSavingAccount(sm.getBranchId(), "SavingAndCurrent" );
        Integer lastSavingAccount = Integer.parseInt(lastAccountNumber.replaceAll("[\\D]", ""));
        lastSavingAccount += 1;

        Branches branches = branchesRepository.getOne(sm.getBranchId());
        String branchCode = branches.getCode();
        System.out.println(branchCode);

        accounts.setAccountNumber(branchCode + "SB" + lastSavingAccount);
        accounts.setAmount(sm.getAmount());
        accounts.setMemberId(sm.getMemberId());
        accounts.setSchemeId(sm.getSchemeId());
        accounts.setNominee(sm.getNominee());
        accounts.setNomineeAge(sm.getNomineeAge());
        accounts.setRelationWithNominee(sm.getRelationWithNominee());
        accounts.setActiveStatus(sm.getActiveStatus());
        accounts.setAccountType(sm.getAccountType());
        accounts.setModeOfOperation(sm.getModeOfOperation());
        accounts.setTeamId(sm.getTeamId());
        accounts.setAgentId(sm.getAgentId());
        Date date = new Date();
        accounts.setCreatedAt(date);
        accounts.setLastCurrentInterestUpdatedAt(date);
        accounts.setCurrentInterest("0.00");
        accounts.setStaffId(sm.getStaffId());
        accounts.setBranchId(sm.getBranchId());
        accounts.setPandLgroup("SavingAndCurrent");
        accounts.setGroupType("SavingAndCurrent");
        accounts.setDealerId(0);
        accounts.setIsDirty((byte) 0);
        accounts.setBikeSurrendered((byte) 0);
        accounts.setIsInLegal((byte) 0);
        accounts.setInsuranceTenure("1 year");
        accounts.setBankAccountLimit(0);
        smAccountsRepo.save(accounts);
        Accounts ac = smAccountsRepo.getOne(accounts.getId());

        if (sm.getMember2() != null) {
            Members m1 = membersRepo.getOne(sm.getMember2());
            jointmembers.setAccounts(ac);
            jointmembers.setMembers(m1);
            jointmemberrepo.save(jointmembers);
        }
        if (sm.getMember3() != null) {
            Members m2 = membersRepo.getOne(sm.getMember3());
            jointmembers.setAccounts(ac);
            jointmembers.setMembers(m2);
            jointmemberrepo.save(jointmembers);
        }
        if (sm.getMember4() != null) {
            Members m3 = membersRepo.getOne(sm.getMember4());
            jointmembers.setAccounts(ac);
            jointmembers.setMembers(m3);
            jointmemberrepo.save(jointmembers);
        }

        //Make transaction for new member...................................................
        AccountDetails accountDetailsFrom = new AccountDetails();
        accountDetailsFrom = accountsRepo.getCashAccounts(sm.getBranchId());
        System.out.println(accountDetailsFrom.getId());

        Integer accountToId = accounts.getId();
        System.out.println(accountToId);

        DepositeDetails depositeDetails = new DepositeDetails();
        depositeDetails.setStaffId(sm.getStaffId());
        Members members = membersRepo.findById(sm.getMemberId()).get();
        depositeDetails.setNarration("Saving Account Opened For Member " + members.getName() + " [" + members.getMemberNo() + "] ");
        depositeDetails.setAmount(sm.getAmount());

        //Create transaction........................................
        transactionService.createTransactions(depositeDetails, accountDetailsFrom.getId(), accountToId, 4, accountToId, branches.getId());
    }


    //edit Saving account.........................................................
    public void editSavingAccount(SavingAccountDetails sm) {
        Accounts accounts = smAccountsRepo.getOne(sm.getId());
        accounts.setAccountNumber(sm.getAccountNumber());
        accounts.setMemberId(sm.getMemberId());
        accounts.setAgentId(sm.getAgentId());
        accounts.setNominee(sm.getNominee());
        accounts.setNomineeAge(sm.getNomineeAge());
        accounts.setRelationWithNominee(sm.getRelationWithNominee());
        accounts.setActiveStatus(sm.getActiveStatus());
        accounts.setTeamId(sm.getTeamId());
        smAccountsRepo.save(accounts);

    }

    //Add DDS accounts.....................................
    public void addDdsAccount(DDSAccountDetails sm) {
        Accounts accounts = new Accounts();
        Jointmembers jointmembers = new Jointmembers();

        String lastAccountNumber = smAccountsRepo.getLastSavingAccount(sm.getBranchId(), "DDS");
        Integer lastSavingAccount = Integer.parseInt(lastAccountNumber.replaceAll("[\\D]", ""));
        lastSavingAccount += 1;

        Branches branches = branchesRepository.getOne(sm.getBranchId());
        String branchCode = branches.getCode();
        System.out.println(branchCode);

        accounts.setAccountNumber(branchCode + "DDS" + lastSavingAccount);
        accounts.setAmount(sm.getAmount());
        accounts.setMemberId(sm.getMemberId());
        accounts.setSchemeId(sm.getSchemaId());
        accounts.setNominee(sm.getNominee());
        accounts.setNomineeAge(sm.getNomineeAge());
        accounts.setRelationWithNominee(sm.getRelationWithNominee());
        accounts.setActiveStatus(sm.getActiveStatus());
        accounts.setAccountType("DDS");
        accounts.setModeOfOperation(sm.getModeOfOperation());
        accounts.setTeamId(sm.getTeamId());
        accounts.setAgentId(sm.getAgentId());
        accounts.setCollectorId(sm.getCollectorId());
        accounts.setMinorNomineeParentName(sm.getMinorNomineeParentName());
        accounts.setNewOrRenew(sm.getNewOrRenew());
        Date date = new Date();
        accounts.setCreatedAt(date);
        accounts.setStaffId(0);
        accounts.setPandLgroup("DDS");
        accounts.setGroupType("DDS");
        accounts.setDealerId(0);
        accounts.setIsDirty((byte) 0);
        accounts.setBikeSurrendered((byte) 0);
        accounts.setIsInLegal((byte) 0);
        accounts.setInsuranceTenure("1 year");
        accounts.setBankAccountLimit(0);
        accounts.setBranchId(sm.getBranchId());
        smAccountsRepo.save(accounts);

        Accounts ac = smAccountsRepo.getOne(accounts.getId());

        if (sm.getMember2() != null) {
            Members m1 = membersRepo.getOne(sm.getMember2());
            jointmembers.setAccounts(ac);
            jointmembers.setMembers(m1);
            jointmemberrepo.save(jointmembers);
        }
        if (sm.getMember3() != null) {
            Members m2 = membersRepo.getOne(sm.getMember3());
            jointmembers.setAccounts(ac);
            jointmembers.setMembers(m2);
            jointmemberrepo.save(jointmembers);
        }
        if (sm.getMember4() != null) {
            Members m3 = membersRepo.getOne(sm.getMember4());
            jointmembers.setAccounts(ac);
            jointmembers.setMembers(m3);
            jointmemberrepo.save(jointmembers);
        }

        Schemes schemes = schemeRepo.getOne(accounts.getSchemeId());
        Integer maturityPeriod= schemes.getMaturityPeriod();

        String input = schemes.getAccountOpenningCommission();
        String[] strings = input.split(",");
        Double[] commissions = new Double[strings.length];
        for (int i = 0; i < commissions.length; i++)
        {
            commissions[i] = Double.parseDouble(strings[i]);
            System.out.println(commissions[i]);
        }
        Integer commissionSize = commissions.length;

        String input2 = schemes.getCollectorCommissionRate();
        String[] strings2 = input2.split(",");
        Double[] collections = new Double[strings2.length];
        for (int i = 0; i < collections.length; i++)
        {
            collections[i] = Double.parseDouble(strings2[i]);
            System.out.println(collections[i]);
        }
        Integer collectionSize = collections.length;

        for(int i = 1; i <= maturityPeriod; i ++){

            Premiums premiums = new Premiums();
            premiums.setAccountId(accounts.getId());
            premiums.setAmount(sm.getMonthlyAmount());
            premiums.setPaid(0);
            premiums.setSkipped(false);
            premiums.setCreatedAt(new Date());
            premiums.setUpdatedAt(new Date());
            premiums.setAgentCommissionSend(false);
            premiums.setAgentCollectionChargesSend(false);
            premiums.setPaneltyCharged(BigDecimal.valueOf(0));
            premiums.setPaneltyPosted(BigDecimal.valueOf(0));
            premiums.setDueDate(date);
            premiums.setAgentCommissionPercentage(commissionSize > i ? commissions[i] : commissions[commissionSize-1]);
            premiums.setAgentCollectionChargesPercentage(collectionSize > i ? BigDecimal.valueOf(collections[i]) : BigDecimal.valueOf(commissions[commissionSize-1]));
            premuimRepo.save(premiums);

            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.MONTH, 1);
            date = c.getTime();

        }

        DepositeDetails depositeDetails = new DepositeDetails();
        if(sm.getDebitAccountId() != null){
            depositeDetails.setAcFrom(sm.getDebitAccountId());
        }
        depositeDetails.setAcTo(accounts.getId());
        depositeDetails.setBranchId(sm.getBranchId());
        depositeDetails.setLoginBranch(sm.getBranchId());
        depositeDetails.setAmount(sm.getAmount());
        depositeDetails.setNarration(sm.getNarration());
        depositeDetails.setShares(false);
        depositeDetails.setStaffId(sm.getStaffId());
        transactionService.transactionDeposite(depositeDetails);


    }

    //Update DDs accounts..................
    public void updateDdsAccount(DDSAccountDetails sm) {
        Accounts accounts = smAccountsRepo.getOne(sm.getId());
        accounts.setAccountNumber(sm.getAccountNumber());
        accounts.setMemberId(sm.getMemberId());
        accounts.setNominee(sm.getNominee());
        accounts.setNomineeAge(sm.getNomineeAge());
        accounts.setRelationWithNominee(sm.getRelationWithNominee());
        accounts.setActiveStatus(sm.getActiveStatus());
        accounts.setTeamId(sm.getTeamId());
        accounts.setAgentId(sm.getAgentId());
        accounts.setCollectorId(sm.getCollectorId());
        accounts.setMinorNomineeParentName(sm.getMinorNomineeParentName());
        accounts.setNewOrRenew(sm.getNewOrRenew());
        smAccountsRepo.save(accounts);
    }

    //Add recurring accounts..........................................
    public void addRecuringAccount(RecurringAccountDetails sm) {
        Accounts accounts = new Accounts();
        Jointmembers jointmembers = new Jointmembers();

        String lastAccountNumber = smAccountsRepo.getLastSavingAccount(sm.getBranchId(), "Recurring");
        Integer lastSavingAccount = Integer.parseInt(lastAccountNumber.replaceAll("[\\D]", ""));
        lastSavingAccount += 1;

        Branches branches = branchesRepository.getOne(sm.getBranchId());
        String branchCode = branches.getCode();
        System.out.println(branchCode);

        accounts.setAccountNumber(branchCode + "RD" + lastSavingAccount);
        accounts.setAmount(sm.getAmount());
        accounts.setMemberId(sm.getMemberId());
        accounts.setSchemeId(sm.getSchemaId());
        accounts.setNominee(sm.getNominee());
        accounts.setNomineeAge(sm.getNomineeAge());
        accounts.setRelationWithNominee(sm.getRelationWithNominee());
        accounts.setActiveStatus(sm.getActiveStatus());
        accounts.setAccountType("Recurring");
        accounts.setModeOfOperation(sm.getModeOfOperation());
        accounts.setTeamId(sm.getTeamId());
        accounts.setAgentId(sm.getAgentId());
        accounts.setCollectorId(sm.getCollectorId());
        accounts.setMinorNomineeParentName(sm.getMinorNomineeParentName());
        accounts.setNewOrRenew(sm.getNewOrRenew());
        Date date = new Date();
        accounts.setCreatedAt(date);
        accounts.setStaffId(0);
        accounts.setPandLgroup("Recurring");
        accounts.setGroupType("Recurring");
        accounts.setDealerId(0);
        accounts.setIsDirty((byte) 0);
        accounts.setBikeSurrendered((byte) 0);
        accounts.setIsInLegal((byte) 0);
        accounts.setInsuranceTenure("1 year");
        accounts.setBankAccountLimit(0);
        accounts.setBranchId(sm.getBranchId());
        smAccountsRepo.save(accounts);

        Accounts ac = smAccountsRepo.getOne(accounts.getId());

        if (sm.getMember2() != null) {
            Members m1 = membersRepo.getOne(sm.getMember2());
            jointmembers.setAccounts(ac);
            jointmembers.setMembers(m1);
            jointmemberrepo.save(jointmembers);
        }
        if (sm.getMember3() != null) {
            Members m2 = membersRepo.getOne(sm.getMember3());
            jointmembers.setAccounts(ac);
            jointmembers.setMembers(m2);
            jointmemberrepo.save(jointmembers);
        }
        if (sm.getMember4() != null) {
            Members m3 = membersRepo.getOne(sm.getMember4());
            jointmembers.setAccounts(ac);
            jointmembers.setMembers(m3);
            jointmemberrepo.save(jointmembers);
        }

        Schemes schemes = schemeRepo.getOne(accounts.getSchemeId());
        Integer maturityPeriod= schemes.getMaturityPeriod();

        String input = schemes.getAccountOpenningCommission();
        String[] strings = input.split(",");
        Double[] commissions = new Double[strings.length];
        for (int i = 0; i < commissions.length; i++)
        {
            commissions[i] = Double.parseDouble(strings[i]);
            System.out.println(commissions[i]);
        }
        Integer commissionSize = commissions.length;

        String input2 = schemes.getCollectorCommissionRate();
        String[] strings2 = input2.split(",");
        Double[] collections = new Double[strings2.length];
        for (int i = 0; i < collections.length; i++)
        {
            collections[i] = Double.parseDouble(strings2[i]);
            System.out.println(collections[i]);
        }
        Integer collectionSize = collections.length;

        for(int i = 1; i <= maturityPeriod; i ++){

            Premiums premiums = new Premiums();
            premiums.setAccountId(accounts.getId());
            premiums.setAmount(sm.getMonthlyAmount());
            premiums.setPaid(0);
            premiums.setSkipped(false);
            premiums.setCreatedAt(new Date());
            premiums.setUpdatedAt(new Date());
            premiums.setAgentCommissionSend(false);
            premiums.setAgentCollectionChargesSend(false);
            premiums.setPaneltyCharged(BigDecimal.valueOf(0));
            premiums.setPaneltyPosted(BigDecimal.valueOf(0));
            premiums.setDueDate(date);
            premiums.setAgentCommissionPercentage(commissionSize > i ? commissions[i] : commissions[commissionSize-1]);
            premiums.setAgentCollectionChargesPercentage(collectionSize > i ? BigDecimal.valueOf(collections[i]) : BigDecimal.valueOf(commissions[commissionSize-1]));
            premuimRepo.save(premiums);

            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.MONTH, 1);
            date = c.getTime();

        }

        DepositeDetails depositeDetails = new DepositeDetails();
        if(sm.getDebitAccountId() != null){
            depositeDetails.setAcFrom(sm.getDebitAccountId());
        }
        depositeDetails.setAcTo(accounts.getId());
        depositeDetails.setBranchId(sm.getBranchId());
        depositeDetails.setLoginBranch(sm.getBranchId());
        depositeDetails.setAmount(sm.getAmount());
        depositeDetails.setNarration(sm.getNarration());
        depositeDetails.setShares(false);
        depositeDetails.setStaffId(sm.getStaffId());
        transactionService.transactionDeposite(depositeDetails);
    }


    //Update recurring accounts.............................................
    public void updateRecuringAccount(RecurringAccountDetails sm) {
        Accounts accounts = smAccountsRepo.getOne(sm.getId());
        accounts.setAccountNumber(sm.getAccountNumber());
        accounts.setMemberId(sm.getMemberId());
        accounts.setNominee(sm.getNominee());
        accounts.setNomineeAge(sm.getNomineeAge());
        accounts.setRelationWithNominee(sm.getRelationWithNominee());
        accounts.setActiveStatus(sm.getActiveStatus());
        accounts.setTeamId(sm.getTeamId());
        accounts.setAgentId(sm.getAgentId());
        accounts.setCollectorId(sm.getCollectorId());
        accounts.setMinorNomineeParentName(sm.getMinorNomineeParentName());
        accounts.setNewOrRenew(sm.getNewOrRenew());
        smAccountsRepo.save(accounts);
    }

    //Add fixedAndMis accounts..........................................
    public void addfixedAccounts(FixedAccountDetails sm) {
        Accounts accounts = new Accounts();

        String lastAccountNumber = smAccountsRepo.getLastFDMISaccount(sm.getBranchId(), sm.getAccountType());
        Integer lastSavingAccount = Integer.parseInt(lastAccountNumber.replaceAll("[\\D]", ""));
        lastSavingAccount += 1;

        Branches branches = branchesRepository.getOne(sm.getBranchId());
        String branchCode = branches.getCode();
        System.out.println(branchCode);

        accounts.setAccountNumber(branchCode + sm.getAccountType() + lastSavingAccount);
        accounts.setAmount(sm.getAmount());
        accounts.setMemberId(sm.getMemberId());
        accounts.setSchemeId(sm.getSchemaId());
        accounts.setNominee(sm.getNominee());
        accounts.setNomineeAge(sm.getNomineeAge());
        accounts.setRelationWithNominee(sm.getRelationWithNominee());
        accounts.setActiveStatus(sm.getActiveStatus());
        accounts.setAccountType(sm.getAccountType()); //FD or MIS
        accounts.setModeOfOperation(sm.getModeOfOperation());
        accounts.setTeamId(sm.getTeamId());
        accounts.setAgentId(sm.getAgentId());
        accounts.setCollectorId(sm.getCollectorId());
        accounts.setMinorNomineeParentName(sm.getMinorNomineeParentName());
        accounts.setNewOrRenew(sm.getNewOrRenew());
        accounts.setMaturityToAccountId(sm.getMaturityToAccountId());
        accounts.setIntrestToAccountId(sm.getIntrestToAccountId());
        accounts.setMoId(sm.getMoId());
        Date date = new Date();
        accounts.setCreatedAt(date);
        accounts.setStaffId(0);
        accounts.setPandLgroup("FixedAndMis");
        accounts.setGroupType("FixedAndMis");
        accounts.setDealerId(0);
        accounts.setIsDirty((byte) 0);
        accounts.setBikeSurrendered((byte) 0);
        accounts.setIsInLegal((byte) 0);
        accounts.setInsuranceTenure("1 year");
        accounts.setBankAccountLimit(0);
        accounts.setBranchId(sm.getBranchId());
        smAccountsRepo.save(accounts);

        DepositeDetails depositeDetails = new DepositeDetails();
        if(sm.getDebitAccountId() != null){
            depositeDetails.setAcFrom(sm.getDebitAccountId());
        }
        depositeDetails.setAcTo(accounts.getId());
        depositeDetails.setBranchId(sm.getBranchId());
        depositeDetails.setLoginBranch(sm.getBranchId());
        depositeDetails.setAmount(sm.getAmount());
        depositeDetails.setNarration(sm.getNarration());
        depositeDetails.setShares(false);
        depositeDetails.setStaffId(sm.getStaffId());
        transactionService.transactionDeposite(depositeDetails);


    }

    //update FixedAndMis account.................................
    public void updatefixedAccounts(FixedAccountDetails sm) {
        Accounts accounts = smAccountsRepo.getOne(sm.getId());
        accounts.setAccountNumber(sm.getAccountNumber());
        accounts.setMemberId(sm.getMemberId());
        accounts.setNominee(sm.getNominee());
        accounts.setNomineeAge(sm.getNomineeAge());
        accounts.setRelationWithNominee(sm.getRelationWithNominee());
        accounts.setActiveStatus(sm.getActiveStatus());
        accounts.setTeamId(sm.getTeamId());
        accounts.setAgentId(sm.getAgentId());
        accounts.setCollectorId(sm.getCollectorId());
        accounts.setMinorNomineeDob(sm.getMinorNomineeDob());
        accounts.setNewOrRenew(sm.getNewOrRenew());
        accounts.setMaturityToAccountId(sm.getMaturityToAccountId());
        accounts.setIntrestToAccountId(sm.getIntrestToAccountId());
        smAccountsRepo.save(accounts);
    }

    //Update other account......................
    public void updateOtherAccount(OtherAccountDetails oa) {
        Accounts accounts = smAccountsRepo.getOne(oa.getId());
        accounts.setAccountNumber(oa.getAccountNumber());
        accounts.setMemberId(oa.getMemberId());
        accounts.setSchemeId(oa.getSchemaId());
        accounts.setActiveStatus(oa.getActiveStatus());
        accounts.setPandLgroup(oa.getPAndLGroup());
        smAccountsRepo.save(accounts);
    }


    public List<SchemaDetail> getSchemesSM(String name) {
        List<SchemaDetail> scheme = schemeRepo.getSchemesSM(name);
        System.out.println(scheme);
        if (scheme.size() != 0) {
            return scheme;
        } else {
            return new ArrayList<SchemaDetail>();
        }
    }


    public List<Teamdetails> getTeam(String name) {
        List<Teamdetails> team = teamRepository.getTeam(name);
        System.out.println(team);
        if (team.size() != 0) {
            return team;
        } else {
            return new ArrayList<Teamdetails>();
        }
    }

    // Get API of "Accounts" tab inside "Loan" tab inside "Accounts" tab.............
    public Map<String, Object> getAllAccount(Integer setPageNumber, Integer setMaxResults, String search) {
        Pageable pageable = PageRequest.of(setPageNumber, setMaxResults);
        Page<LoanAccountDetails> list = smAccountsRepo.getAllAccount(search, pageable);
        Map<String, Object> monthMap = new HashMap<String, Object>();
        if (list.hasContent()) {
            monthMap.put("pageSize", list.getSize());
            monthMap.put("totalElement", list.getTotalElements());
            monthMap.put("totalPage", list.getTotalPages());
            monthMap.put("ShareDetail", list.getContent());
            return monthMap;
        } else {
            return monthMap;
        }
    }

    // Get Documents API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab.............
    public List<DocumentsSubmittedDetails> getDocumentsOfAccount(Integer id) {
        List<DocumentsSubmittedDetails> list = docSubmittedRepo.getDocumentsOfAccount(id);
        System.out.println("***********" + list.size());
        if (list.size() != 0) {
            return list;
        } else {
            return new ArrayList<DocumentsSubmittedDetails>();
        }
    }


    public String deleteAccount(Integer id) {

        Integer TransactionRowCount = transactionRowRepo.getTransactionCountForAccount(id);
        if(TransactionRowCount > 0){
            return "Account Contains Transactions, Cannot Delete";
        }

        Integer TransactionCount = transactionsRepo.getTransactionCountForAccount(id);
        if(TransactionCount > 0){
            return "Related Transaction Found, Cannot Delete";
        }

        premuimRepo.deletePremiums(id);
        jointmemberrepo.deleteJointMembers(id);
        docSubmittedRepo.deleteDocumentSubmitted(id);
        accountGuarantorRepo.deleteAccountGuarantorRepo();
        commentRepo.deleteComment(id);
        bikeSurrenderHistoryRepo.deleteBikeSurrenderHistory(id);

        smAccountsRepo.deleteById(id);
        return "Item Deleted Successfully";
    }

    // edit API of "Accounts" tab inside "Loan" tab inside "Accounts" tab.............
    public void updateAccount(LoanAccountDetails details) {
        Accounts account = smAccountsRepo.getOne(details.getAccountId());
        account.setAccountType(details.getAccountType());
        account.setAccountNumber(details.getAccountNumber());
        account.setMemberId(details.getMemberId());
        account.setActiveStatus(details.getActiveStatus());
        account.setLoanAgainstAccountId(details.getLoanAgainstAccountId());
        account.setDealerId((details.getDealerId() == null ? 0 : details.getDealerId()));
        account.setRepaymentMode(details.getRepaymentMode());
        smAccountsRepo.save(account);
    }


    // Add Documents API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab.............
    public String addDocumentsOfAccount(DocumentsSubmittedDetails details) {
        DocumentsSubmitted ds = new DocumentsSubmitted();
        ds.setAccountsId(details.getAccountId());

        Integer documentExists = documnetsRepo.checkDocumentExists(details.getAccountId(), details.getDocumentId());
        if(documentExists > 0){
            return "Entry Already Exists, Try to edit it";
        }

        ds.setDocumentsId(details.getDocumentId());
        ds.setDescription(details.getDescription());
        ds.setSubmittedOn(new Date());
        docSubmittedRepo.save(ds);
        return "Successfully Added !";
    }

    // Update Documents API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab.............
    public void updateDocumentsOfAccount(DocumentsSubmittedDetails details) {
        DocumentsSubmitted ds = docSubmittedRepo.getOne(details.getDocSubmittedId());
        Date currentDate = DateFormater.getCurrentDate();
        System.out.println("***" + currentDate);
        ds.setAccountsId(details.getAccountId());
        ds.setDocumentsId(details.getDocumentId());
        ds.setDescription(details.getDescription());
        ds.setSubmittedOn(currentDate);
        docSubmittedRepo.save(ds);
    }

    // delete Documents API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab.............
    public String deleteDocumentsOfAccount(Integer id) {
        try {
            docSubmittedRepo.deleteById(id);
        } catch (Exception e) {
            return "Try again after sometime" + e;
        }
        return "Item Deleted Successfully";
    }

    // get Comments API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab..........
    public List<CommentDetails> getCommentsOnAccounts(Integer id) {
        List<CommentDetails> list = commentRepo.getCommentsOnAccounts(id);
        if (list.size() != 0) {
            return list;
        } else {
            return new ArrayList<>();
        }
    }

    // add Comments API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab..........
    public void addCommentsOnAccounts(CommentDetails details) {
        Comment comment = new Comment();
        Accounts account = smAccountsRepo.getOne(details.getAccountId());
        Members member = membersRepo.getOne(details.getMemberId());
        comment.setAccounts(account);
        comment.setMembers(member);
        comment.setNarration(details.getNarration());
        Date currentDate = DateFormater.getCurrentDateWithTime();
        comment.setCreatedAt(currentDate);
        comment.setUpdatedAt(currentDate);
        commentRepo.save(comment);
    }

    // update Comments API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab..........
    public void updateCommentsOnAccounts(CommentDetails details) {
        Comment comment = commentRepo.getOne(details.getCommentId());
        Accounts account = smAccountsRepo.getOne(details.getAccountId());
        Members member = membersRepo.getOne(details.getMemberId());
        comment.setAccounts(account);
        comment.setMembers(member);
        comment.setNarration(details.getNarration());
        Date currentDate = DateFormater.getCurrentDateWithTime();
        comment.setUpdatedAt(currentDate);
        commentRepo.save(comment);
    }

    // delete Comments API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab..........
    public String deleteCommentsOnAccounts(Integer id) {
        try {
            commentRepo.deleteById(id);
        } catch (Exception e) {
            return "Try again after sometime" + e;
        }
        return "Item Deleted Successfully";
    }


    // get Account Guarantor details API for "Edit Guarantor" tab inside "Accounts" tab inside "Loan" tab inside "Accounts" tab...........
    public List<AccountGuarantorDetails> getAccountGuarantor(Integer id) {
        System.out.println("******** id: " + id);
        List<AccountGuarantorDetails> list = accountGuarantorRepo.getAccountGuarantor(id);
        System.out.println("*********" + list.size());
        if (list.size() != 0) {
            return list;
        } else {
            return new ArrayList<AccountGuarantorDetails>();
        }
    }

    // add Account Guarantor details API for "Edit Guarantor" tab inside "Accounts" tab inside "Loan" tab inside "Accounts" tab...........
    public void addAccountGuarantor(Integer memberId, Integer accountId) {
        AccountGuarantors ag = new AccountGuarantors();
        Accounts a = smAccountsRepo.getOne(accountId);
        Members m = membersRepo.getOne(memberId);
        Date currentDate = DateFormater.getCurrentDate();
        System.out.println("*********Date: " + currentDate);
        ag.setAccounts(a);
        ag.setMembers(m);
        ag.setCreatedAt(currentDate);
        accountGuarantorRepo.save(ag);

    }

    // update Account Guarantor details API for "Edit Guarantor" tab inside "Accounts" tab inside "Loan" tab inside "Accounts" tab...........
    public void updateAccountGuarantor(Integer id, Integer memberId, Integer accountId) {
        AccountGuarantors ag = accountGuarantorRepo.getOne(id);
        Accounts a = smAccountsRepo.getOne(accountId);
        Members m = membersRepo.getOne(memberId);
        Date currentDate = DateFormater.getCurrentDate();
        System.out.println("*********Date: " + currentDate);
        ag.setAccounts(a);
        ag.setMembers(m);
        ag.setCreatedAt(currentDate);
        accountGuarantorRepo.save(ag);

    }

    // update Account Guarantor details API for "Edit Guarantor" tab inside "Accounts" tab inside "Loan" tab inside "Accounts" tab...........
    public String deleteAccountGuarantor(Integer id) {
        try {
            accountGuarantorRepo.deleteById(id);

        } catch (Exception e) {
            return "Try again after sometime" + e;
        }
        return "Item Deleted Successfully";
    }


    // Add "Manage Legal Case & Hearing" tab form "Loan" tab............
    public void addLoanManageCaseAndHearing(MngLegalCaseHearing details) {
        AccountLegalCase alc = new AccountLegalCase();
        alc.setAccountId(details.getAccountId());
        alc.setName(details.getLegalCaseNo());
        alc.setBccsFileNo(details.getBccsFileNo());
        alc.setCourt(details.getCourt());
        alc.setAutorisedPerson(details.getAuthorisedPerson());
        alc.setCaseType(details.getCaseType());
        alc.setStage(details.getStage());
        alc.setCaseOn(details.getCaseOn());
        alc.setFileVerifiedBy(details.getFileVerifiedBy());
        alc.setAdvocate(details.getAdvocate());
        alc.setRemarks(details.getRemarks());
        alcRepo.save(alc);
    }

    // Update "Manage Legal Case & Hearing" tab form "Loan" tab............
    public void updateLoanManageCaseAndHearing(MngLegalCaseHearing details) {
        AccountLegalCase alc = alcRepo.getOne(details.getAccountLegalCaseId());
        alc.setAccountId(details.getAccountId());
        alc.setName(details.getLegalCaseNo());
        alc.setBccsFileNo(details.getBccsFileNo());
        alc.setCourt(details.getCourt());
        alc.setAutorisedPerson(details.getAuthorisedPerson());
        alc.setCaseType(details.getCaseType());
        alc.setStage(details.getStage());
        alc.setCaseOn(details.getCaseOn());
        alc.setFileVerifiedBy(details.getFileVerifiedBy());
        alc.setAdvocate(details.getAdvocate());
        alc.setRemarks(details.getRemarks());
        alcRepo.save(alc);
    }

    // delete "Manage Legal Case & Hearing" tab form "Loan" tab............
    public String deleteLoanManageCaseAndHearing(Integer id) {
        Integer legalcaseExists = alchRepo.checkLegalcaseExists(id);
        if(legalcaseExists > 0){
            return "Please remove the hearing records first !";
        }
        alchRepo.deleteById(id);
        return "Item Deleted Successfully";
    }


    // Get "LegalCaseHearing" tab inside "Manage Legal Case & Hearing" tab form "Loan" tab............
    public List<iMngLegalCaseHearing> getLegalCaseHearing(Integer id) {
        List<iMngLegalCaseHearing> list = smAccountsRepo.getLegalCaseHearing(id);
        return list;
    }

    // add "LegalCaseHearing" tab inside "Manage Legal Case & Hearing" tab form "Loan" tab............
    public void addLegalCaseHearing(MngLegalCaseHearing details) {
        AccountLegalCaseHearing alc = new AccountLegalCaseHearing();
        Date currentDate = DateFormater.getCurrentDate();
        alc.setHearingDate(currentDate);
        alc.setLegalcaseId(details.getAccountLegalCaseId());
        alc.setRemarks(details.getRemarks());
        alc.setStage(details.getStage());
        alchRepo.save(alc);
    }

    // update "LegalCaseHearing" tab inside "Manage Legal Case & Hearing" tab form "Loan" tab............
    public void updateLegalCaseHearing(MngLegalCaseHearing details) {
        AccountLegalCaseHearing alc = alchRepo.getOne(details.getAccountLegalCaseHearingId());
        alc.setHearingDate(details.getLasttHearingDate());
        alc.setLegalcaseId(details.getAccountLegalCaseId());
        alc.setRemarks(details.getRemarks());
        alc.setStage(details.getStage());
        alchRepo.save(alc);
    }

    // delete  "LegalCaseHearing" tab inside "Manage Legal Case & Hearing" tab form "Loan" tab............
    public String deleteLegalCaseHearing(Integer id) {
        alchRepo.deleteById(id);
        return "Item Deleted Successfully";
    }


    //Add send NOC.................................................
    public void addSendNoc(SendNocDetails nc) {
        Noclog n = new Noclog();
        n.setAccountsId(nc.getAccountsId());
        n.setNocLetterReceivedOn(nc.getNocLetterReceivedOn());
        n.setToBranchId(nc.getToBranchId());
        n.setSendNarration(nc.getSendNarration());
        n.setIsDispatchToCustomer(nc.getIsDispatchToCustomer());
        n.setDispatchNarration(nc.getDispatchNarration());
        n.setIsNocNotMade(nc.getIsNocNotMade());
        n.setIsNocHold(nc.getIsNocHold());
        n.setNocHoldDueTo(nc.getNocHoldDueTo());
        n.setNocNotMadeDueTo(nc.getNocNotMadeDueTo());
        n.setReturnById(0);
        n.setReturnNarration("");
        n.setDispatchById(0);
        n.setReturnAt(dateformater.getFromatDate("00-00-0000"));
        if(nc.getIsDispatchToCustomer() == 1)
            n.setDispatchAt(new Date());
        else
            n.setDispatchAt(dateformater.getFromatDate("00-00-0000"));
        n.setIsReturn(0);
        n.setReceivedAt(dateformater.getFromatDate("00-00-0000"));
        n.setReceivedNarration("");
        Date date = new Date();
        n.setSendAt(date);
        n.setCreatedById(nc.getLoginId());
        n.setFromBranchId(nc.getFromBranchId());
        n.setReturnReceivedById(0);
        nocRepo.save(n);
    }


    public List<AgentDetailsList> getAgentList(String name) {
        List<AgentDetailsList> list = agentsRepositoty.getAgentList2(name);
        return list;

/*        String name = names.replaceAll("\\s", "");
        List<AgentDetailsList> moAgentAssociationList = moAssociationRepo.getAgentAssociationList(name);
        if (moAgentAssociationList.size() == 0) {
            String[] s1 = names.split("\\s");
            List<AgentDetailsList> moAgentAssociationSubList = new ArrayList<AgentDetailsList>();
//							List<AssociationDetails> moAgentAssociationListArray = new ArrayList<AssociationDetails>();
            for (String nameList : s1) {
                if (!nameList.isEmpty()) {
                    moAgentAssociationSubList = moAssociationRepo.getAgentAssociationList(nameList);
                    moAgentAssociationList.addAll(moAgentAssociationSubList);
                }
            }
        }
//						List<AssociationDetails> moAgentAssociationList = moAssociationRepo.getMoAgentAssociationList(name);
        return moAgentAssociationList;*/
    }


    //Update send NOC......................
    public void editSendNoc(SendNocDetails nc) {
        Noclog n = nocRepo.getOne(nc.getId());
        n.setAccountsId(nc.getAccountId());
        n.setNocLetterReceivedOn(nc.getNocLetterReceivedOn());
        n.setToBranchId(nc.getToBranchId());
        n.setSendNarration(nc.getSendNarration());
        n.setIsDispatchToCustomer(nc.getIsDispatchToCustomer());
        n.setDispatchNarration(nc.getDispatchNarration());
        n.setIsNocNotMade(nc.getIsNocNotMade());
        n.setIsNocHold(nc.getIsNocHold());
        n.setNocHoldDueTo(nc.getNocHoldDueTo());
        n.setNocNotMadeDueTo(nc.getNocNotMadeDueTo());
        nocRepo.save(n);
    }


    // get Dealer list API for three character search..................
    public List<LoanAccountDetails> getDealerList(String name) {
        name = name.replaceAll("\\s", "");
        return dealerRepo.getDealerList(name);
    }

    //Action button in Return NOC...................................
    public void editReturnNoc(ReturnNocDetails nc) {
        Noclog noclog = nocRepo.getOne(nc.getId());
        noclog.setReturnReceivedById(nc.getReturnReceivedId());
        noclog.setReturnReceivedNarration(nc.getReturnReceivedNarration());
        nocRepo.save(noclog);

    }

    public String deleteSendNOC(Integer id) {
        try {
            nocRepo.deleteById(id);

        } catch (Exception e) {
            return "Try again after sometime" + e;
        }
        return "Item Deleted Successfully";
    }


    public void updatemngSurrenderBike(MngSuurenderBikeDetails details) {
        Accounts account = smAccountsRepo.getOne(details.getId());
        account.setBikeSurrendered(details.getBikeSurrendered());
        account.setBikeSurrenderedOn(details.getBikeSurrenderedOn());
        account.setBikeSurrenderedBy(details.getBikeSurrenderedBy());
        account.setIsGivenForLegalProcess(details.getIsGivenForLegalProcess());
        account.setLegalProcessGivenDate(details.getLegalProcessGivenDate());
        account.setIsInLegal(details.getIsInLegal());
        account.setLegalFilingDate(details.getLegalFilingDate());
        account.setIsGodownchargeDebited(details.getIsGodownchargeDebited());
        account.setGodownchargeDebitedOn(details.getGodownchargeDebitedOn());
        account.setIsLegalNoticeSentForBikeAuction(details.getIsLegalNoticeSentForBikeAuction());
        account.setLegalNoticeSentForBikeAuctionOn(details.getLegalNoticeSentForBikeAuctionOn());
        account.setIsBikeAuctioned(details.getIsBikeAuctioned());
        account.setBikeAuctionedOn(details.getBikeAuctionedOn());
        account.setIsFinalRecoveryNoticeSent(details.getIsFinalRecoveryNoticeSent());
        account.setFinalRecoveryNoticeSentOn(details.getFinalRecoveryNoticeSentOn());
        account.setIsChequePresentedInBank(details.getIsChequePresentedInBank());
        account.setChequePresentedInBankOn(details.getChequePresentedInBankOn());
        account.setIsChequeReturned(details.getIsChequeReturned());
        account.setChequeReturnedOn(details.getChequeReturnedOn());
        account.setIsNoticeSentAfterChequeReturned(details.getIsNoticeSentAfterChequeReturned());
        account.setNoticeSentAfterChequeReturnedOn(details.getNoticeSentAfterChequeReturnedOn());
        account.setIsLegalCaseFinalised(details.getIsLegalCaseFinalised());
        account.setLegalCaseFinalisedOn(details.getLegalCaseFinalisedOn());
        account.setIsBikeReturned(details.getIsBikeReturned());
        account.setBikeReturnedOn(details.getBikeReturnedOn());
        account.setBikeNotSoldReason(details.getBikeNotSoldReason());
        account.setLegalCaseNotSubmittedReason(details.getLegalCaseNotSubmittedReason());
        account.setIsInArbitration(details.getIsInArbitration());
        account.setArbitrationOn(details.getArbitrationOn());
        account.setIsSocietyNoticeSent(details.getIsSocietyNoticeSent());
        account.setSocietyNoticeSentOn(details.getSocietyNoticeSentOn());
        account.setIsLegalNoticeSent(details.getIsLegalNoticeSent());
        account.setLegalNoticeSentOn(details.getLegalNoticeSentOn());
        account.setIsVisitDone(details.getIsVisitDone());
        account.setVisitDoneOn(details.getVisitDoneOn());
        account.setIsNocHandlingChargeReceived(details.getIsNocHandlingChargeReceived());
        account.setNocHandlingChargeReceivedOn(details.getNocHandlingChargeReceivedOn());
        smAccountsRepo.save(account);

    }


    public String deleteSendNoc(Integer id) {
        try {
            nocRepo.deleteById(id);

        } catch (Exception e) {
            return "Try again after sometime" + e;
        }
        return "Item Deleted Successfully";
    }


    public List<DocumentsSubmittedDetails> getDocumentsList(String name) {

        return documnetsRepo.getDocumentsList(name);
    }


    public List<AccountGuarantorDetails> getAcGuarantorsList(String name) {
        return accountGuarantorRepo.getAcGuarantorsList(name);
    }


    public void editReceiveNoc(ReceiveNocDetails nc) {
        Noclog noclog = nocRepo.getOne(nc.getId());
        Date date = new Date();
        noclog.setReceivedAt(date);
        noclog.setReceivedById(nc.getRecievedbyId());
        noclog.setReceivedNarration(nc.getReceivedNarration());
        nocRepo.save(noclog);

    }

    public void editReceive2Noc(ReceiveNocDetails nc) {
        Noclog noclog = nocRepo.getOne(nc.getId());
        Date date = new Date();
        noclog.setDispatchAt(date);
        noclog.setDispatchById(nc.getDispatchById());
        noclog.setDispatchNarration(nc.getDispatchNarration());
        noclog.setIsDispatchToCustomer(nc.getIsDispatchToCustomer());
        nocRepo.save(noclog);
    }


    public void editReceive3Noc(ReceiveNocDetails nc) {
        Noclog noclog = nocRepo.getOne(nc.getId());
        Date date = new Date();
        noclog.setReturnAt(date);
        noclog.setReturnById(nc.getReturnById());
        noclog.setReturnNarration(nc.getReturnNarration());
        noclog.setIsReturn(nc.getIsReturn());
        nocRepo.save(noclog);
    }

    //Search for accounts in MAD - Agent.............................................................................
    public List<LoanAccountDetails> getAllAccounts(String accountNumber) {
        List<LoanAccountDetails> list = accountsRepo.getAllLoanAgainstAccounts(accountNumber);
        if (list.size() != 0) {
            return list;
        } else {
            return new ArrayList<LoanAccountDetails>();
        }
    }


    public List<iJointMember> getJointMember(Integer accountId) {
        List<iJointMember> list = jointmemberrepo.getJointMember(accountId);
        return list;
    }

    public void addJointMember(Integer accountId, Integer memberId) {
        Jointmembers jointmembers = new Jointmembers();
        Accounts accounts = accountsRepo.findById(accountId).get();
        Members members = membersRepo.findById(memberId).get();
        jointmembers.setAccounts(accounts);
        jointmembers.setMembers(members);
        jointmemberrepo.save(jointmembers);

    }

    public void updateJointMember(Integer id, Integer memberId) {
        Jointmembers jointmembers = jointmemberrepo.findById(id).get();
        Members members = membersRepo.findById(memberId).get();
        jointmembers.setMembers(members);
        jointmemberrepo.save(jointmembers);
    }

    public void deleteJointMember(Integer id) {
        jointmemberrepo.deleteById(id);
    }



    public void addPendingAccount(AccountsPendingDetails accountsPending) {

        AccountsPending ac = new AccountsPending();
        ac.setAccountType(accountsPending.getAccountType());
        ac.setAccountNumber(accountsPending.getAccountNumber());
        ac.setMemberId(accountsPending.getMemberId());
        ac.setSchemeId(accountsPending.getSchemeId());
        ac.setAmount(accountsPending.getAmount());
        ac.setRepaymentMode(accountsPending.getRepaymentMode());
        ac.setInsuranceTenure(accountsPending.getInsuranceTenure());
        ac.setActiveStatus(accountsPending.getActiveStatus());
        ac.setLoanInsurranceDate(accountsPending.getLoanInsurranceDate());
        ac.setDealerId(accountsPending.getDealerId());
        ac.setSigImageId(accountsPending.getSigImageId());

        ac.setCreatedAt(new Date());
        ac.setStaffId(accountsPending.getStaffId());
        ac.setPandLgroup(" ");
        ac.setIsDirty((byte) 0);
        ac.setBikeSurrendered((byte) 0);
        ac.setIsInLegal((byte) 0);
        ac.setBankAccountLimit(0);
        ac.setLegalFilingDate(new Date(0));
        ac.setNewOrRenew("");
        ac.setBranchId(accountsPending.getBranchId());
        ac.setIsApproved(false);

        OtherValues otherValues= new OtherValues();
        otherValues.setJointMember(accountsPending.getJointMember());
        otherValues.setDocumentFeeded(accountsPending.getDocumentFeeded());
        otherValues.setSmAmount(accountsPending.getSMAmount());
        otherValues.setAccountCrAmount(accountsPending.getAccountCrAmount());
        otherValues.setLoanFromAccount(accountsPending.getLoanFromAccount());

        Gson gson = new Gson();
        gson.toJson(otherValues);
        ac.setExtraInfo(gson.toJson(otherValues));
        System.out.println(gson.toJson(otherValues));
        loanRepo.save(ac);

    }

    public List<AccountStatementDetail> getAccountStatementGST(Integer accountId, String fromDate, String toDate) {
        Date from_Date1 = null;
        Date to_Date1 = null;
        if (fromDate == null) {
            from_Date1 = DateFormater.getOldDate();
        } else {
            from_Date1 = dateformater.getFromatDate(fromDate);
        }
        if (toDate == null) {
            to_Date1 = DateFormater.getCurrentDate();
        } else {
            to_Date1 = dateformater.getFromatDate(toDate);
        }

        List<AccountStatementDetail> staffList = memorandomTransRow.accountStatement(accountId, from_Date1, to_Date1);


        if (staffList.size() != 0) {
            return staffList;
        } else {
            return new ArrayList<AccountStatementDetail>();
        }
    }

    public List<iDeleteVoucherDetails> getTransactionDetails(Integer transactionId) {
        List<iDeleteVoucherDetails> list = transactionRowRepo.getTransactionDetails(transactionId);
        return list;
    }

    public List<CollectorDetails> getCollectorList(String name) {
        List<CollectorDetails> list = agentsRepositoty.getCollectorList(name);
        return list;
    }
}
