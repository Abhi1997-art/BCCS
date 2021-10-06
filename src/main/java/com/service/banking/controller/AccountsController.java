package com.service.banking.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.service.banking.hibernateEntity.*;
import com.service.banking.model.GstModel.AccountStatementDetail;
import com.service.banking.model.accountsModel.*;
import com.service.banking.model.hodAuthorityModel.iDeleteVoucherDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.banking.model.MadModel.DealerDeatails;
import com.service.banking.model.dashboardModel.DueDeatailsModel;
import com.service.banking.model.dashboardModel.SchemaDetail;
import com.service.banking.model.hodAuthorityModel.AssociationDetails;
import com.service.banking.model.hodAuthorityModel.MoRoDetails;
import com.service.banking.model.hodAuthorityModel.Teamdetails;
import com.service.banking.model.stockModel.LedgerItemDetails;
import com.service.banking.model.stockModel.LedgerReqModel;
import com.service.banking.service.AccountsService;
import com.service.banking.service.DashBoardService;
import com.service.banking.service.HodAuthorityService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service
@RequestMapping("/service/accounts")
public class AccountsController {

    @Autowired
    AccountsService accountService;


    // ***************************accounts management ************************

    // SM Accounts..............................................................................
    @GetMapping("/sm_accounts/{setFirstResult}/{setMaxResults}")
    public Map<String, Object> smAccounts(@PathVariable("setFirstResult") Integer setFirstResult, @PathVariable("setMaxResults") Integer setMaxResults) {
        Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
        Map<String, Object> smList = accountService.smAccounts(setPageNumber, setMaxResults); // null check already in service....
        return smList;
    }

    // Add SM account...............................
    @PostMapping("/add_sm_account")
    public String addSMaccount(@RequestBody SMAccountsDetails sm) {
        return accountService.addSMaccount(sm);
    }

    // Add SM account...............................
    @PutMapping("/update_sm_account")
    public void editSMaccount(@RequestBody SMAccountsDetails sm) {
        accountService.editSMaccount(sm);
    }

    // Delete account....
    @DeleteMapping("/delete_account/{id}")
    public String deleteAccount(@PathVariable("id") Integer id) {
        String message = accountService.deleteAccount(id);
        return message;
    }

    // Saving Accounts..............................................................................
    @GetMapping("/saving_accounts/{setFirstResult}/{setMaxResults}")
    public Map<String, Object> savingAccounts(@PathVariable("setFirstResult") Integer setFirstResult,
                                              @PathVariable("setMaxResults") Integer setMaxResults) {
        Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
        Map<String, Object> smList = accountService.savingAccounts(setPageNumber, setMaxResults);
        // System.out.println("size of list*****************"+dailydue.size());
        return smList;
    }

    // Add Saving account...............................
    @PostMapping("/add_saving_account")
    public void addSavingAccount(@RequestBody SavingAccountDetails sad) {
        accountService.addSavingAccount(sad);
    }

    // Update Saving account...............................
    @PutMapping("/update_saving_account")
    public void editSavingAccount(@RequestBody SavingAccountDetails sad) {
        accountService.editSavingAccount(sad);
    }

    @GetMapping("/joint_member")
    public List<iJointMember> getJointMember(@RequestParam Integer accountId) {
        return accountService.getJointMember(accountId);
    }

    @PostMapping("/joint_member")
    public void addJointMember(@RequestParam Integer accountId,
                               @RequestParam Integer memberId) {
        accountService.addJointMember(accountId, memberId);
    }

    @PutMapping("/joint_member")
    public void updateJointMember(@RequestParam Integer id,
                                  @RequestParam Integer memberId) {
        accountService.updateJointMember(id, memberId);
    }


    @DeleteMapping("/joint_member")
    public void deleteJointMember(@RequestParam Integer id) {
        accountService.deleteJointMember(id);
    }

    // DDS Accounts.........................................................
    @GetMapping("/dds2_accounts")
    List<DDSAccountDetails> DDSAccounts() {
        List<DDSAccountDetails> ddsList = accountService.DDSAccounts(); // null check already in service....
        System.out.println("size of list*****************" + ddsList.size());
        return ddsList;
    }

    // Add DDS account...............................
    @PostMapping("/add_dds_account")
    public void addDdsAccount(@RequestBody DDSAccountDetails dds) {
        accountService.addDdsAccount(dds);
    }


    // Update DDS account...............................
    @PutMapping("/update_dds_account")
    public void updateDdsAccount(@RequestBody DDSAccountDetails dds) {
        accountService.updateDdsAccount(dds);
    }

    // Recurring Accounts..............................................................................
    @GetMapping("/recurring_accounts/{setFirstResult}/{setMaxResults}")
    public Map<String, Object> RecurringAccounts(@PathVariable("setFirstResult") Integer setFirstResult,
                                                 @PathVariable("setMaxResults") Integer setMaxResults) {
        Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
        Map<String, Object> recList = accountService.RecurringAccounts(setPageNumber, setMaxResults);
        return recList;
    }

    // Add DDS account...............................
    @PostMapping("/add_recurring_account")
    public void addRecuringAccount(@RequestBody RecurringAccountDetails rad) {
        accountService.addRecuringAccount(rad);
    }

    // Add DDS account...............................
    @PutMapping("/update_recurring_account")
    public void updateRecuringAccount(@RequestBody RecurringAccountDetails rad) {
        accountService.updateRecuringAccount(rad);
    }


    //fixed  Accounts..............................................................................
    @GetMapping("/fixed_accounts/{setFirstResult}/{setMaxResults}")
    public Map<String, Object> fixedAccounts(@PathVariable("setFirstResult") Integer setFirstResult, @PathVariable("setMaxResults") Integer setMaxResults) {
        Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
        Map<String, Object> fixedList = accountService.fixedAccounts(setPageNumber, setMaxResults); // null check already in service....
        System.out.println("size of list*****************" + fixedList.size());
        return fixedList;
    }

    // Add FixedAndMis account...............................
    @PostMapping("/add_fixed_account")
    public void addfixedAccounts(@RequestBody FixedAccountDetails fad) {
        accountService.addfixedAccounts(fad);
    }

    // Add FixedAndMis account...............................
    @PutMapping("/update_fixed_account")
    public void updatefixedAccounts(@RequestBody FixedAccountDetails fad) {
        accountService.updatefixedAccounts(fad);
    }

    //others  Accounts..............................................................................
    @GetMapping("/others_accounts/{setFirstResult}/{setMaxResults}")
    public Map<String, Object> otherAccounts(@PathVariable("setFirstResult") Integer setFirstResult, @PathVariable("setMaxResults") Integer setMaxResults) {
        Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
        Map<String, Object> otherList = accountService.otherAccounts(setPageNumber, setMaxResults); // null check already in service....
        System.out.println("size of list*****************" + otherList.size());
        return otherList;
    }

    // Add Other account...............................
    @PostMapping("/add_other_account")
    public void addOtherAccount(@RequestBody OtherAccountDetails oa) {
        accountService.addOtherAccount(oa);
    }

    // Add Other account...............................
    @PutMapping("/update_other_account")
    public void updateOtherAccount(@RequestBody OtherAccountDetails oa) {
        accountService.updateOtherAccount(oa);
    }


    // ************************loan************************************
    // loan pending
    // Accounts..............................................................................
    @GetMapping("/loan/pending")
    List<PendingLoanDetails> pending() {
        List<PendingLoanDetails> pendList = accountService.loanPending();
        return pendList;
    }

    @PostMapping("/loan/pending")
    public void addPendingAccount(@RequestBody AccountsPendingDetails accountsPending) {
            accountService.addPendingAccount(accountsPending);
    }


    //loan pending  Accounts..............................................................................
    // Manage Surrender Bike and Legal tab inside Loan tab...............
    @GetMapping("/loan/mng_surrender_bike_legal/{setFirstResult}/{setMaxResults}")
    public Map<String, Object> mngSurrenderBike(@PathVariable("setFirstResult") Integer setFirstResult,
                                                @PathVariable("setMaxResults") Integer setMaxResults,
                                                @RequestParam("search") String search) {
        Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
        Map<String, Object> pendList = accountService.manageSuurenderBike(setPageNumber, setMaxResults, search); // null check already in service....
        System.out.println("size of list*****************" + pendList.size());
        return pendList;
    }

    // Add OthManage Surrender Bike and Legal...............................
    @PutMapping("/update_mng_surrender_bike_legal")
    public void updatemngSurrenderBike(@RequestBody MngSuurenderBikeDetails a) {
        accountService.updatemngSurrenderBike(a);
    }

    // Get "Manage Legal Case & Hearing" tab form "Loan" tab............
    @GetMapping("/loan/manage_legal_case_hearing")
    public List<MngLegalCaseHearing> getLoanManageCaseAndHearing() {
        List<MngLegalCaseHearing> loanManageCaseAndHearing = accountService.getLoanManageCaseAndHearing();
        return loanManageCaseAndHearing;
    }

    // Add "Manage Legal Case & Hearing" tab form "Loan" tab............
    @PostMapping("/loan/add_manage_legal_case_hearing")
    public void addLoanManageCaseAndHearing(@RequestBody MngLegalCaseHearing details) {
        accountService.addLoanManageCaseAndHearing(details);
    }

    // Update "Manage Legal Case & Hearing" tab form "Loan" tab............
    @PutMapping("/loan/update_manage_legal_case_hearing")
    public void updateLoanManageCaseAndHearing(@RequestBody MngLegalCaseHearing details) {
        accountService.updateLoanManageCaseAndHearing(details);
    }

    // delete "Manage Legal Case & Hearing" tab form "Loan" tab............
    @DeleteMapping("/loan/delete_manage_legal_case_hearing/{id}")
    public String deleteLoanManageCaseAndHearing(@PathVariable("id") Integer id) {
        return accountService.deleteLoanManageCaseAndHearing(id);
    }

    // Get "LegalCaseHearing" tab inside "Manage Legal Case & Hearing" tab form "Loan" tab............
    @GetMapping("/loan/legal_case_hearing")
    public List<iMngLegalCaseHearing> getLegalCaseHearing(@RequestParam Integer id) {
        return accountService.getLegalCaseHearing(id);
    }

    // add "LegalCaseHearing" tab inside "Manage Legal Case & Hearing" tab form "Loan" tab............
    @PostMapping("/loan/add_legal_case_hearing")
    public void addLegalCaseHearing(@RequestBody MngLegalCaseHearing details) {
        accountService.addLegalCaseHearing(details);
    }

    // update "LegalCaseHearing" tab inside "Manage Legal Case & Hearing" tab form "Loan" tab............
    @PutMapping("/loan/update_legal_case_hearing")
    public void updateLegalCaseHearing(@RequestBody MngLegalCaseHearing details) {
        accountService.updateLegalCaseHearing(details);
    }

    // delete  "LegalCaseHearing" tab inside "Manage Legal Case & Hearing" tab form "Loan" tab............
    @DeleteMapping("/loan/delete_legal_case_hearing/{id}")
    public String deleteLegalCaseHearing(@PathVariable("id") Integer id) {
        return accountService.deleteLegalCaseHearing(id);
    }


    // Get API of "Accounts" tab inside "Loan" tab inside "Accounts" tab.............
    @GetMapping("/loan/accounts/{setFirstResult}/{setMaxResults}")
    public Map<String, Object> getAllAccount(@PathVariable("setFirstResult") Integer setFirstResult,
                                             @PathVariable("setMaxResults") Integer setMaxResults,
                                             @RequestParam("search") String search) {
        Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
        Map<String, Object> list = accountService.getAllAccount(setPageNumber, setMaxResults, search);
        return list;
    }

    // Get Documents API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab.............
    @GetMapping("/loan/accounts/documents")
    public List<DocumentsSubmittedDetails> getDocumentsOfAccount(@RequestParam Integer accountId) {
        List<DocumentsSubmittedDetails> list = accountService.getDocumentsOfAccount(accountId);
        return list;
    }

    // Edit API of "Accounts" tab inside "Loan" tab inside "Accounts" tab.............
    @PutMapping("/loan/update_accounts")
    public void updateAccount(@RequestBody LoanAccountDetails details) {
        accountService.updateAccount(details);
    }

    // Add Documents API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab.............
    @PostMapping("/loan/accounts/add_documents")
    public String addDocumentsOfAccount(@RequestBody DocumentsSubmittedDetails details) {
        return accountService.addDocumentsOfAccount(details);
    }

    // Update Documents API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab.............
    @PutMapping("/loan/accounts/update_documents")
    public void updateDocumentsOfAccount(@RequestBody DocumentsSubmittedDetails details) {
        accountService.updateDocumentsOfAccount(details);
    }

    //delete Documents API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab.............
    @DeleteMapping("/loan/accounts/delete_documents/{id}")
    public String deleteDocumentsOfAccount(@PathVariable("id") Integer id) {
        return accountService.deleteDocumentsOfAccount(id);
    }

    // get Comments API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab..........
    @GetMapping("/loan/accounts/comments")
    public List<CommentDetails> getCommentsOnAccounts(@RequestParam Integer accountId) {
        return accountService.getCommentsOnAccounts(accountId);
    }

    // add Comments API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab..........
    @PostMapping("/loan/accounts/add_comments")
    public void getCommentsOnAccounts(@RequestBody CommentDetails details) {
        accountService.addCommentsOnAccounts(details);
    }

    // update Comments API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab..........
    @PutMapping("/loan/accounts/update_comments")
    public void updateCommentsOnAccounts(@RequestBody CommentDetails details) {
        accountService.updateCommentsOnAccounts(details);
    }

    // delete Comments API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab..........
    @DeleteMapping("/loan/accounts/delete_comments/{id}")
    public String deleteCommentsOnAccounts(@PathVariable("id") Integer id) {
        return accountService.deleteCommentsOnAccounts(id);
    }

    // get Account Guarantor details API for "Edit Guarantor" tab inside "Accounts" tab inside "Loan" tab inside "Accounts" tab...........
    @GetMapping("/loan/accounts/guarantor")
    public List<AccountGuarantorDetails> getAccountGuarantor(@RequestParam Integer accountId) {
        return accountService.getAccountGuarantor(accountId);
    }

    // add Account Guarantor details API for "Edit Guarantor" tab inside "Accounts" tab inside "Loan" tab inside "Accounts" tab...........
    @PostMapping("/loan/accounts/add_guarantor")
    public void addAccountGuarantor(@RequestParam Integer memberId, @RequestParam Integer accountId) {
        accountService.addAccountGuarantor(memberId, accountId);
    }

    // update Account Guarantor details API for "Edit Guarantor" tab inside "Accounts" tab inside "Loan" tab inside "Accounts" tab...........
    @PutMapping("/loan/accounts/update_guarantor")
    public void updateAccountGuarantor(@RequestParam Integer id, @RequestParam Integer memberId, @RequestParam Integer accountId) {
        accountService.updateAccountGuarantor(id, memberId, accountId);
    }

    // delete Account Guarantor details API for "Edit Guarantor" tab inside "Accounts" tab inside "Loan" tab inside "Accounts" tab...........
    @DeleteMapping("/loan/accounts/delete_guarantor/{id}")
    public String deleteAccountGuarantor(@PathVariable("id") Integer id) {
        return accountService.deleteAccountGuarantor(id);
    }


    // ***************************accounts statement ************************

    // all accounts............................

    @GetMapping("/account_statement/accounts")
    List<AccountDetails> getAccounts() {
        List<AccountDetails> accList = accountService.getAccounts();
        return accList;
    }

    // get Accounts statement..............................................................................
    @PostMapping("/account_statement")
    List<AccountStatementDetails> getAccountStatement(@RequestBody AccountStatementReq accreq) {
        List<AccountStatementDetails> accountstament = accountService.getAccountStatement(accreq.getId(), accreq.getFromDate(), accreq.getToDate());
        return accountstament;
    }

    @PostMapping("/account_statement_gst")
    List<AccountStatementDetail> getAccountStatementGST(@RequestBody AccountStatementReq accreq) {
        List<AccountStatementDetail> accountstament = accountService.getAccountStatementGST(accreq.getId(), accreq.getFromDate(), accreq.getToDate());
        return accountstament;
    }

    @GetMapping("/transaction_details")
    public List<iDeleteVoucherDetails> getTransactionDetails(@RequestParam Integer transactionId) {
        return accountService.getTransactionDetails(transactionId);
    }

//*****************************************noc management**************************************************

    //Send noc  Accounts ..............................................................................
    @GetMapping("/noc_management/send_noc")
    List<SendNocDetails> getSendNoc(@RequestParam String search) {
        List<SendNocDetails> nocList = accountService.nocSendMnagement(search);
        return nocList;
    }


    // Add Send NOC account...............................
    @PostMapping("/noc_management/add_send_noc")
    public void addSendNoc(@RequestBody SendNocDetails nc) {
        accountService.addSendNoc(nc);
    }

    // Update Send NOC account...............................
    @PutMapping("/noc_management/update_send_noc")
    public void editSendNoc(@RequestBody SendNocDetails nc) {
        accountService.editSendNoc(nc);
    }

    //  return noc receive ..............................................................................
    @GetMapping("/noc_management/return_noc")
    List<ReturnNocDetails> getReturnNoc() {
        List<ReturnNocDetails> nocList = accountService.returnNoc();
        return nocList;
    }

    //Action button in Return NOC..............................
    @PutMapping("/noc_management/action_return_noc")
    public void editReturnNoc(@RequestBody ReturnNocDetails nc) {
        accountService.editReturnNoc(nc);
    }

    //  receive noc receive ..............................................................................
    @GetMapping("/noc_management/receive_noc")
    List<iReceiveNocDetails> getReceiveNoc() {
        List<iReceiveNocDetails> nocList = accountService.receiveNoc();
        return nocList;
    }


    //Action button of receive NOC..................
    @PutMapping("/noc_management/action_receive_noc_receive")
    public void editReceiveNoc(@RequestBody ReceiveNocDetails nc) {
        accountService.editReceiveNoc(nc);
    }

    @PutMapping("/noc_management/action_receive_noc_dispatch")
    public void editReceive2Noc(@RequestBody ReceiveNocDetails nc) {
        accountService.editReceive2Noc(nc);
    }

    @PutMapping("/noc_management/action_receive_noc_return")
    public void editReceive3Noc(@RequestBody ReceiveNocDetails nc) {
        accountService.editReceive3Noc(nc);
    }


//*******************************************************************************************************//

    @GetMapping("/schemes_list")
    public List<SchemaDetail> getSchemesSM(@RequestParam String name) {
        List<SchemaDetail> schemes = accountService.getSchemesSM(name);
        return schemes;
    }

    @GetMapping("/teams_list")
    public List<Teamdetails> getTeam(@RequestParam String name) {
        List<Teamdetails> team = accountService.getTeam(name);
        return team;
    }


    @GetMapping("/agent_list")
    public List<AgentDetailsList> getAgentList(@RequestParam String name) {
        List<AgentDetailsList> moAgentAssociationList = accountService.getAgentList(name);
        return moAgentAssociationList;
    }

    @GetMapping("/collector_list")
    public List<CollectorDetails> getCollectorList(@RequestParam String name) {
        List<CollectorDetails> list = accountService.getCollectorList(name);
        return list;
    }

    // get Dealer API for three character search....................
    @GetMapping("/loan/dealerList")
    public List<LoanAccountDetails> getDealerList(@RequestParam String name) {
        return accountService.getDealerList(name);
    }

    // Delete send NOC....
    @DeleteMapping("/delete_send_noc/{id}")
    public String deleteSendNOC(@PathVariable("id") Integer id) {
        String message = accountService.deleteSendNOC(id);
        return message;
    }

    @GetMapping("/loan/documentsList")
    public List<DocumentsSubmittedDetails> getDocumentsList(@RequestParam String name) {
        return accountService.getDocumentsList(name);
    }

    @GetMapping("/loan/acGuarantorsList")
    public List<AccountGuarantorDetails> getAcGuarantorsList(@RequestParam String name) {
        return accountService.getAcGuarantorsList(name);
    }

    //Search for LoanAgainst accounts.............................................................................
    @GetMapping("/account_name_loanAgainst")
    List<LoanAccountDetails> getAllAccounts(@RequestParam("accountNumber") String accountNumber) {
        List<LoanAccountDetails> allaccounts = accountService.getAllAccounts(accountNumber); // null check already in service....
        System.out.println("**********" + allaccounts.size());
        return allaccounts;
    }




}
