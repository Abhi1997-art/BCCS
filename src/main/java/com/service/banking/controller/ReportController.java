package com.service.banking.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.banking.model.accountsModel.AgentDetailsList;
import com.service.banking.model.hodAuthorityModel.AssociationDetails;
import com.service.banking.model.report.BookDayDetail;
import com.service.banking.model.report.iAgentsAccount;
import com.service.banking.model.report.iBikeLegalReport;
import com.service.banking.model.report.iDayBook;
import com.service.banking.model.report.iDealerReport;
import com.service.banking.model.report.iDepositeReport;
import com.service.banking.model.report.iDsaReport;
import com.service.banking.model.report.iEmployee;
import com.service.banking.model.report.iGeneralReport;
import com.service.banking.model.report.iLoanReport;
import com.service.banking.model.report.iMemberReport;
import com.service.banking.model.report.iNewLoanMemberInsuranceReport;
import com.service.banking.model.superAdminModel.StaffModel;
import com.service.banking.repository.AccountsRepo.AccountsRepo;
import com.service.banking.service.HodAuthorityService;
import com.service.banking.service.ReportService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service
@RequestMapping("/service/report")
public class ReportController {
	
	@Autowired
	ReportService reportservice;
	
	@GetMapping("/dayBook")
	List<iDayBook> getDayBook(@RequestParam String fromDate, @RequestParam String toDate){
		List<iDayBook> dayBooks = reportservice.getDayBook(fromDate , toDate);
		return dayBooks;
	}
	
	@GetMapping("/cash_book")
	List<iDayBook> getCashBook(@RequestParam String fromDate, @RequestParam String toDate){
		List<iDayBook> cashBooks = reportservice.getCashBook(fromDate , toDate);
		return cashBooks;
	}
	
	@GetMapping("/voucher_search")
	List<iDayBook> getVoucherSearch(@RequestParam String fromDate, @RequestParam String toDate, @RequestParam Integer voucher){
		List<iDayBook> books = reportservice.getVoucherSearch(fromDate , toDate, voucher);
		return books;
	}
	
	@GetMapping("/transaction_count")
	List<iDayBook> getTransactionCount(){
		List<iDayBook> books = reportservice.getTransactionCount();
		return books;
	}

	
	//Member Report.............................................................................................................................
	
	@GetMapping("/memberReport/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> getMemberReport(@PathVariable("setFirstResult") Integer setFirstResult, @PathVariable("setMaxResults") Integer setMaxResults){
		Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
		Map<String, Object> list = reportservice.getMemberReport(setPageNumber, setMaxResults);
		return list;
	}
	
	@GetMapping("/new_loan_member_insurance_report")
	List<iNewLoanMemberInsuranceReport> getNewLoanMemberInsuranceReport(@RequestParam String fromDate, @RequestParam String toDate){
		List<iNewLoanMemberInsuranceReport> dayBooks = reportservice.getNewLoanMemberInsuranceReport(fromDate , toDate);
		return dayBooks;	}
	
	@GetMapping("/depositeMemberInsurance/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> getDepositeMemberInsurance(@PathVariable("setFirstResult") Integer setFirstResult, @PathVariable("setMaxResults") Integer setMaxResults,
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam String type){
		Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
		Map<String, Object> list = reportservice.getDepositeMemberInsurance(type, fromDate, toDate, setPageNumber, setMaxResults);
		return list;
	}
	
	@GetMapping("/defaulter_list/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> getDefaulterList(@PathVariable("setFirstResult") Integer setFirstResult, @PathVariable("setMaxResults") Integer setMaxResults,
			@RequestParam String fromDate, @RequestParam String toDate){
		Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
		Map<String, Object> list = reportservice.getDefaulterList(fromDate, toDate, setPageNumber, setMaxResults);
		return list;
	}
	
	
	
	
	//Dealer / DSA Report.........................................................................................................................
	
	@GetMapping("/dealer_report")
	List<iDealerReport> getDealerReport(@RequestParam Integer dealerId){
		List<iDealerReport> report = reportservice.getDealerReport(dealerId);
		return report;
	}
	
	@GetMapping("/dsa_report")
	List<iDsaReport> getDsaReport(@RequestParam Integer dsaId){
		List<iDsaReport> report = reportservice.getDsaReport(dsaId);
		return report;
	}
	
	
	//Agent Report.........................................................................................................................
	
	@GetMapping("/agent_accounts")
	List<iAgentsAccount> getAgentAccounts(@RequestParam Integer id){
		List<iAgentsAccount> report = reportservice.getAgentAccounts(id);
		return report;
	}
	
	
	
	//General Report.................................................................
	@GetMapping("/periodical_accounts")
	List<iGeneralReport> getPeriodicalAccounts(){
		List<iGeneralReport> report = reportservice.getPeriodicalAccounts();
		return report;
	}
	
	@GetMapping("/closing_balance_of_accounts/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> getClosingBalanceOfAccounts(@PathVariable("setFirstResult") Integer setFirstResult, @PathVariable("setMaxResults") Integer setMaxResults){
		Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
		Map<String, Object> list = reportservice.getClosingBalanceOfAccounts(setPageNumber, setMaxResults);
		return list;
	}
	
	@GetMapping("/account_close_report/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> getAccountCloseReport(@PathVariable("setFirstResult") Integer setFirstResult, @PathVariable("setMaxResults") Integer setMaxResults){
		Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
		Map<String, Object> list = reportservice.getAccountCloseReport(setPageNumber, setMaxResults);
		return list;
	}
	
	@GetMapping("/fixed_assets_report")
	List<iGeneralReport> getFixedAssetReport(){
		List<iGeneralReport> report = reportservice.getFixedAssetReport();
		return report;
	}
	
	@GetMapping("/scheme_wise_account")
	List<iGeneralReport> getSchemeWiseAccount(){
		List<iGeneralReport> report = reportservice.getSchemeWiseAccount();
		return report;
	}
	
	
	//Employee Report.................................................................
	
	@GetMapping("/conveyance_report")
	List<iEmployee> getConveyanceReport(@RequestParam("accountId") Integer accountId){
		List<iEmployee> report = reportservice.getConveyanceReport(accountId);
		return report;
	}
	
	@GetMapping("/fuel_report")
	List<iEmployee> getFuelReport(@RequestParam("accountId") Integer accountId){
		List<iEmployee> report = reportservice.getFuelReport(accountId);
		return report;
	}
	
	@GetMapping("/mo_performance")
	public List<AssociationDetails> getMoAssociations(@RequestBody AssociationDetails associationDetails) {
		List<AssociationDetails> moassociationList = reportservice.getMoAssociation(associationDetails);
		return moassociationList;
	}
	
	
	//Loan Report
	@GetMapping("/insurance_due_list")
	List<iLoanReport> getInsuranceDueListReport(@RequestParam("dealerId") Integer dealerId){
		List<iLoanReport> report = reportservice.getInsuranceDueListReport(dealerId);
		return report;
	}
	
	@GetMapping("/loan_dispatch")
	List<iLoanReport> getLoanDispatchReport(@RequestParam("dealerId") Integer dealerId){
		List<iLoanReport> report = reportservice.getLoanDispatchReport(dealerId);
		return report;
	}
	
	@GetMapping("/rc_due_list")
	List<iLoanReport> getDueListReport(@RequestParam("dealerId") Integer dealerId){
		List<iLoanReport> report = reportservice.getDueListReport(dealerId);
		return report;
	}
	
	@GetMapping("/dealer_statement")
	List<iLoanReport> getDealerStatementReport(@RequestParam("dealerId") Integer dealerId, @RequestParam("activeStatus") Boolean activeStatus){
		List<iLoanReport> report = reportservice.getDealerStatementReport(dealerId, activeStatus);
		return report;
	}
	
	@GetMapping("/dealer_wise_loan_report")
	List<iLoanReport> getDealerWiseLoanReport(){
		List<iLoanReport> report = reportservice.getDealerWiseLoanReport();
		return report;
	}
	
	//Deposit Report
	@GetMapping("/premium_recieved_list")
	List<iDepositeReport> getPremiumRecievedList( @RequestParam("agentId") Integer agentId){
		List<iDepositeReport> report = reportservice.getPremiumRecievedList(agentId);
		return report;
	}
	
	@GetMapping("/advanced_cheque_payement")
	List<iDepositeReport> getAdvancedChequePayement( @RequestParam("agentId") Integer agentId){
		List<iDepositeReport> report = reportservice.getAdvancedChequePayement(agentId);
		return report;
	}
	
	@GetMapping("/matured_account_with_cr_balance")
	List<iDepositeReport> getMaturedAccountWithBalance(@RequestParam("currentDate") String currentDate, @RequestParam("agentId") Integer agentId){
		List<iDepositeReport> report = reportservice.getMaturedAccountWithBalance(currentDate, agentId);
		return report;
	}
	
	@GetMapping("/funds_flow")
	List<iDepositeReport> getFundsFlow(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate){
		List<iDepositeReport> report = reportservice.getFundsFlow(fromDate, toDate);
		return report;
	}
	
	@GetMapping("/non_active_rd_holders/rd")
	List<iDepositeReport> getRDHolders(){
		List<iDepositeReport> report = reportservice.getRDHolders();
		return report;
	}
	
	@GetMapping("/non_active_rd_holders/fd")
	List<iDepositeReport> getFDHolders(){
		List<iDepositeReport> report = reportservice.getFDHolders();
		return report;
	}

	//Bike & Legal Report.........................................................
	
	@GetMapping("/bike_in_stock")
	List<iBikeLegalReport> getBikeInStock(){
		List<iBikeLegalReport> report = reportservice.getBikeInStock();
		return report;
	}
	
	@GetMapping("/bike_sra/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> getBikeSRA(@PathVariable("setFirstResult") Integer setFirstResult, @PathVariable("setMaxResults") Integer setMaxResults,
			@RequestParam("choice") Integer choice, @RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate){
		Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
		Map<String, Object> list = reportservice.getBikeSRA(setPageNumber, setMaxResults, choice,fromDate,toDate);
		return list;
	}
	
	@GetMapping("/final_recovery_notice_due")
	List<iBikeLegalReport> getFinalRecoveryNoticeDue(){
		List<iBikeLegalReport> report = reportservice.getFinalRecoveryNoticeDue();
		return report;
	}	
	
	@GetMapping("/cheque_return_notice_due")
	List<iBikeLegalReport> getCheckReturnNoticeDue(){
		List<iBikeLegalReport> report = reportservice.getCheckReturnNoticeDue();
		return report;
	}
	
	
	@GetMapping("/legal_case_submit_due")
	List<iBikeLegalReport> getLegalCaseSubmitDue(){
		List<iBikeLegalReport> report = reportservice.getLegalCaseSubmitDue();
		return report;
	}
	
	
	
	//Search...................................................................................................................................
	@GetMapping("/agent_list")
	public List<AgentDetailsList> getAgentList(@RequestParam String name) {
		List<AgentDetailsList> list = reportservice.getAgentList(name);
		return list;
	}
	
	
	
}
