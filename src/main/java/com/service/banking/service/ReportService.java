package com.service.banking.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.service.banking.model.accountsModel.AgentDetailsList;
import com.service.banking.model.accountsModel.SMAccountsDetails;
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
import com.service.banking.repository.AccountsRepo.AccountsRepo;
import com.service.banking.repository.AccountsRepo.DocumentsSubmittedRepo;
import com.service.banking.repository.hodAuthorityRepo.MoAssociationRepo;
import com.service.banking.repository.madRepository.AgentsRepositoty;
import com.service.banking.repository.madRepository.DealerRepository;
import com.service.banking.repository.madRepository.DsaRepository;
import com.service.banking.repository.madRepository.MembersRepo;
import com.service.banking.repository.transaction.TransactionRowRepo;

@Service
public class ReportService {

	@Autowired
	TransactionRowRepo transactionRowRepo;
	
	@Autowired
	MembersRepo membersRepo;
	
	@Autowired
	DealerRepository dealerRepository;
	
	@Autowired
	DsaRepository dsaRepository;
	
	@Autowired
	AccountsRepo accountsRepo;

	@Autowired
	MoAssociationRepo moAssociationRepo;
	
	@Autowired
	DocumentsSubmittedRepo documentsSubmittedRepo;
	
	@Autowired
	AgentsRepositoty agentsRepositoty;
	
	public List<iDayBook> getDayBook(String fromDate, String toDate) {
		List<iDayBook> dayBooks = transactionRowRepo.getDayBook(fromDate,toDate);
		return dayBooks;
	}
	
	public List<iDayBook> getCashBook(String fromDate, String toDate) {
		List<iDayBook> cashBooks = transactionRowRepo.getCashBook(fromDate,toDate);
		return cashBooks;
	}

	public List<iDayBook> getVoucherSearch(String fromDate, String toDate, Integer voucher) {
		List<iDayBook> books = transactionRowRepo.getVoucherSearch(fromDate,toDate, voucher);
		return books;
	}


	public List<iDayBook> getTransactionCount() {
		List<iDayBook> books = transactionRowRepo.getTransactionCount();
		return books;
	}


	public Map<String, Object> getMemberReport(Integer setPageNumber, Integer setMaxResults) {
		Pageable pageable= PageRequest.of(setPageNumber, setMaxResults);
		Page<iMemberReport> memberReports = membersRepo.getMemberReport(pageable);
		Map<String, Object> tempList = new HashMap<String, Object>();
		if(memberReports.hasContent()) {
			tempList.put("pageSize", memberReports.getSize());
			tempList.put("totalElement", memberReports.getTotalElements());
			tempList.put("totalPage", memberReports.getTotalPages());
			tempList.put("ShareDetail", memberReports.getContent());
			return tempList;
		}
		else {
			return tempList;
		}
	}

	public List<iNewLoanMemberInsuranceReport> getNewLoanMemberInsuranceReport(String fromDate, String toDate) {
		List<iNewLoanMemberInsuranceReport> dayBooks = transactionRowRepo.getNewLoanMemberInsuranceReport(fromDate,toDate);
		return dayBooks;
	}
	

	public Map<String, Object> getDepositeMemberInsurance(String type, String fromDate, String toDate, Integer setPageNumber, Integer setMaxResults) {
		
		Pageable pageable= PageRequest.of(setPageNumber, setMaxResults);
		Page<iMemberReport> memberReports;
		
		if(type.equals("ALL")) {
			memberReports = membersRepo.getDepositeMemberInsurance2(fromDate, toDate, pageable);
		}
		else {
			memberReports = membersRepo.getDepositeMemberInsurance1(type, fromDate, toDate, pageable);
		}
		
		Map<String, Object> tempList = new HashMap<String, Object>();
		if(memberReports.hasContent()) {
			tempList.put("pageSize", memberReports.getSize());
			tempList.put("totalElement", memberReports.getTotalElements());
			tempList.put("totalPage", memberReports.getTotalPages());
			tempList.put("ShareDetail", memberReports.getContent());
			return tempList;
		}
		else {
			return tempList;
		}
	}

	public Map<String, Object> getDefaulterList(String fromDate, String toDate, Integer setPageNumber, Integer setMaxResults) {
		Pageable pageable= PageRequest.of(setPageNumber, setMaxResults);
		Page<iMemberReport> memberReports = membersRepo.getDefaulterList(fromDate, toDate, pageable);
		Map<String, Object> tempList = new HashMap<String, Object>();
		if(memberReports.hasContent()) {
			tempList.put("pageSize", memberReports.getSize());
			tempList.put("totalElement", memberReports.getTotalElements());
			tempList.put("totalPage", memberReports.getTotalPages());
			tempList.put("ShareDetail", memberReports.getContent());
			return tempList;
		}
		else {
			return tempList;
		}
	}

	public List<iDealerReport> getDealerReport(Integer dealerId) {
		 List<iDealerReport> reports = dealerRepository.getDealerReport(dealerId);
		return reports;
	}

	public List<iDsaReport> getDsaReport(Integer dsaId) {
		List<iDsaReport> reports = dsaRepository.getDsaReport(dsaId);
		return reports;
	}

	public List<iAgentsAccount> getAgentAccounts(Integer id) {
		List<iAgentsAccount> reports = accountsRepo.getAgentAccounts(id);
		return reports;
	}

	public List<iGeneralReport> getPeriodicalAccounts() {
			List<iGeneralReport> reports = accountsRepo.getPeriodicalAccounts();
		return reports;
	}
	
	
	public Map<String, Object> getClosingBalanceOfAccounts(Integer setPageNumber, Integer setMaxResults) {
		Pageable pageable= PageRequest.of(setPageNumber, setMaxResults);
		Page<iGeneralReport> reports = accountsRepo.getClosingBalanceOfAccounts(pageable);
		Map<String, Object> tempList = new HashMap<String, Object>();
		if(reports.hasContent()) {
			tempList.put("pageSize", reports.getSize());
			tempList.put("totalElement", reports.getTotalElements());
			tempList.put("totalPage", reports.getTotalPages());
			tempList.put("ShareDetail", reports.getContent());
			return tempList;
		}
		else {
			return tempList;
		}
	}
	
	public Map<String, Object> getAccountCloseReport(Integer setPageNumber, Integer setMaxResults) {
		Pageable pageable= PageRequest.of(setPageNumber, setMaxResults);
		Page<iGeneralReport> reports = accountsRepo.getAccountCloseReport(pageable);
		Map<String, Object> tempList = new HashMap<String, Object>();
		if(reports.hasContent()) {
			tempList.put("pageSize", reports.getSize());
			tempList.put("totalElement", reports.getTotalElements());
			tempList.put("totalPage", reports.getTotalPages());
			tempList.put("ShareDetail", reports.getContent());
			return tempList;
		}
		else {
			return tempList;
		}
	}
	
	public List<iGeneralReport> getFixedAssetReport() {
		List<iGeneralReport> reports = accountsRepo.getFixedAssetReport();
	return reports;
	}
	
	public List<iGeneralReport> getSchemeWiseAccount() {
		List<iGeneralReport> reports = accountsRepo.getSchemeWiseAccount();
	return reports;
}

	public List<iEmployee> getConveyanceReport(Integer accountId) {
		List<iEmployee> reports = transactionRowRepo.getConveyanceReport(accountId);
		return reports;
	}
	
	public List<iEmployee> getFuelReport(Integer accountId) {
		List<iEmployee> reports = transactionRowRepo.getFuelReport(accountId);
		return reports;
	}

	// Get all mo associations.............................
	public List<AssociationDetails> getMoAssociation(AssociationDetails associationDetails) {
		List<AssociationDetails> moAssociationsList = moAssociationRepo.getMoPerformance(associationDetails.getMoId(), associationDetails.getFromDate(), associationDetails.getToDate());
		if (moAssociationsList.size() != 0) {
			return moAssociationsList;
		} else {
			return new ArrayList<AssociationDetails>();
		}

	}

	public List<iLoanReport> getInsuranceDueListReport(Integer dealerId) {
		List<iLoanReport> reports = dealerRepository.getInsuranceDueListReport(dealerId);
		return reports;
	}

	public List<iLoanReport> getLoanDispatchReport(Integer dealerId) {
		List<iLoanReport> reports = dealerRepository.getLoanDispatchReport(dealerId);
		return reports;
	}

	public List<iLoanReport> getDueListReport(Integer dealerId) {
		List<iLoanReport> reports = dealerRepository.getDueListReport(dealerId);
		return reports;
	}

	public List<iLoanReport> getDealerStatementReport(Integer dealerId, Boolean activeStatus) {
		List<iLoanReport> reports = dealerRepository.getDealerStatementReport(dealerId,activeStatus);
		return reports;
	}

	public List<iLoanReport> getDealerWiseLoanReport() {
		List<iLoanReport> reports = dealerRepository.getDealerWiseLoanReport();
		return reports;
	}

	public List<iDepositeReport> getPremiumRecievedList( Integer agentId) {
		List<iDepositeReport> reports = transactionRowRepo.getPremiumRecievedList(agentId);
		return reports;
	}

	public List<iDepositeReport> getAdvancedChequePayement(Integer agentId) {
		List<iDepositeReport> reports = documentsSubmittedRepo.getPremiumRecievedList(agentId);
		return reports;
	}

	public List<iDepositeReport> getMaturedAccountWithBalance(String currentDate, Integer agentId) {
		List<iDepositeReport> reports = transactionRowRepo.getMaturedAccountWithBalance(currentDate,agentId);
		return reports;
	}

	public List<iDepositeReport> getFundsFlow(String fromDate, String toDate) {
		List<iDepositeReport> reports = transactionRowRepo.getFundsFlow(fromDate,toDate);
		return reports;
	}

	public List<iDepositeReport> getRDHolders() {
		List<iDepositeReport> reports = accountsRepo.getRDHolders();
		return reports;
	}

	public List<iDepositeReport> getFDHolders() {
		List<iDepositeReport> reports = accountsRepo.getFDHolders();
		return reports;
	}

	public List<iBikeLegalReport> getBikeInStock() {
		List<iBikeLegalReport> reports = accountsRepo.getBikeInStock();
		return reports;
	}

	//Bike SRA reports in BIke reports...............................................
	Page<iBikeLegalReport> reports;
	public Map<String, Object> getBikeSRA(Integer setPageNumber, Integer setMaxResults, Integer choice,String fromDate, String toDate) {
		Pageable pageable= PageRequest.of(setPageNumber, setMaxResults);

		if (choice == 1)
			reports = accountsRepo.getBikeS(fromDate, toDate, pageable);
		else if (choice == 2)
			reports = accountsRepo.getBikeR(fromDate, toDate, pageable);
		else if (choice == 3)
			reports = accountsRepo.getBikeA(fromDate, toDate, pageable);

		Map<String, Object> tempList = new HashMap<String, Object>();
		if(reports.hasContent()) {
			tempList.put("pageSize", reports.getSize());
			tempList.put("totalElement", reports.getTotalElements());
			tempList.put("totalPage", reports.getTotalPages());
			tempList.put("ShareDetail", reports.getContent());
			return tempList;
		}
		else {
			return tempList;
		}
	}

	public List<AgentDetailsList> getAgentList(String name) {
		List<AgentDetailsList> list = agentsRepositoty.getAgentList(name);
		return list;
	}

	public List<iBikeLegalReport> getCheckReturnNoticeDue() {
		List<iBikeLegalReport> reports = accountsRepo.getCheckReturnNoticeDue();
		return reports;
	}

	public List<iBikeLegalReport> getFinalRecoveryNoticeDue() {
		List<iBikeLegalReport> reports = accountsRepo.getFinalRecoveryNoticeDue();
		return reports;
	}

	public List<iBikeLegalReport> getLegalCaseSubmitDue() {
		List<iBikeLegalReport> reports = accountsRepo.getLegalCaseSubmitDue();
		return reports;
	}

	public List<iBikeLegalReport> getBikeNotSoldDueTo() {
		List<iBikeLegalReport> reports = accountsRepo.getBikeNotSoldDueTo();
		return reports;
	}

	public List<iBikeLegalReport> getLegalCaseNotSubmitDueTo() {
		List<iBikeLegalReport> reports = accountsRepo.getLegalCaseNotSubmitDueTo();// TODO Auto-generated method stub
		return reports;
	}

	public List<iBikeLegalReport> getChequeActionPending() {
		List<iBikeLegalReport> reports = accountsRepo.getChequeActionPending();
		return reports;
	}

	public List<iBikeLegalReport> getArbitrationCaseDetailReport() {
		List<iBikeLegalReport> reports = accountsRepo.getArbitrationCaseDetailReport();
		return reports;
	}

	public List<iBikeLegalReport> getLegalFinalised(Boolean legal, Boolean process, Boolean arbitration) {
		List<iBikeLegalReport> reports = accountsRepo.getLegalFinalised(legal, process, arbitration);
		return reports;
	}






	
	
}
