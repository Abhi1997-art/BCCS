package com.service.banking.repository.transaction;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.TransactionRow;
import com.service.banking.model.dashboardModel.iCashBankReport;
import com.service.banking.model.report.BookDayDetail;
import com.service.banking.model.report.iDayBook;
import com.service.banking.model.report.iDepositeReport;
import com.service.banking.model.report.iEmployee;
import com.service.banking.model.report.iNewLoanMemberInsuranceReport;
import com.service.banking.model.transaction.ITransactionModel;
import com.service.banking.model.transaction.iBalance;
import com.service.banking.model.transaction.transactionModel;

public interface TransactionRowRepo extends JpaRepository<TransactionRow, Integer> {

	@Query(value = "Select sum(tr.amountDr) as totalAmountDr from transaction_row tr \r\n"
			+ "left join accounts a on a.id = tr.account_id \r\n"
			+ "where a.id = ?1", nativeQuery = true)
	ITransactionModel getTotalDebitSide(Integer accountId);
	
	@Query(value = "select tr.voucher_no as voucherNo, tr.Narration, a.AccountNumber , m.name , m.FatherName , tr.amountDr , tr. amountCr, tr.branch_id as branchId from transaction_row tr\r\n"
			+ "left join accounts a on a.id = tr.account_id \r\n"
			+ "left join members m on m.id = a.member_id \r\n"
			+ "where tr.created_at >= ?1 and tr.created_at <  ?2 \r\n"
			+ "and a.group_type =\"CASH ACCOUNT\" ",nativeQuery = true)
	List<iDayBook> getCashBook(String fromDate, String toDate);
	
	@Query(value = "select tr.created_at ,tr.voucher_no as voucherNo, b.name as branchName,tr.Narration, a.AccountNumber , m.name , m.FatherName , tr.amountDr , tr. amountCr, tr.branch_id as branchId from transaction_row tr\r\n"
			+ "left join accounts a on a.id = tr.account_id \r\n"
			+ "left join members m on m.id = a.member_id \r\n"
			+ "left join branches b on b.id = tr.branch_id \r\n"
			+ "where tr.created_at >= ?1 and tr.created_at < ?2 \r\n"
			+ "and tr.voucher_no = ?3",nativeQuery = true)
	List<iDayBook> getVoucherSearch(String fromDate, String toDate, Integer voucher);
	
	@Query(value = "select tt.name, count(tr.transaction_type_id) as count from transaction_row tr \r\n"
			+ "right join transaction_types tt on tt.id=tr.transaction_type_id \r\n"
			+ "group by tt.id",nativeQuery = true)
	List<iDayBook> getTransactionCount();
	
	@Query(value = "select tr.voucher_no as voucherNo, tr.Narration, a.AccountNumber , m.name , m.FatherName , tr.amountDr , tr. amountCr, tr.branch_id as branchId from transaction_row tr \r\n"
			+ " left join accounts a on a.id = tr.account_id \r\n"
			+ " left join members m on m.id = a.member_id \r\n"
			+ " where tr.created_at >= ?1 and tr.created_at < ?2",nativeQuery = true)
	List<iDayBook> getDayBook(String fromDate, String toDate);

	@Query(value = "select a.AccountNumber , a.created_at, m.title , m.name , m.FatherName ,m.CurrentAddress ,m.PhoneNos ,m.DOB , m.Nominee ,m.RelationWithNominee , a.Amount, m.memebr_type , m.PanNo , m.AdharNumber , a.ActiveStatus from accounts a\r\n"
			+ "left join members m on m.id = a.member_id \r\n"
			+ "where a.account_type = \"Loan Against Deposit\" and a.created_at >= \"2019-05-08\" and a.created_at <=\"2019-05-23\"\r\n"
			+ "order by a.branch_id" , nativeQuery = true)
	List<iNewLoanMemberInsuranceReport> getNewLoanMemberInsuranceReport(String fromDate, String toDate);
	
	
	@Query(value = "select (sum(tr.amountCr) - sum(tr.amountDr)) as balance from transaction_row tr \r\n"
			+ "where tr.account_id = ?1", nativeQuery = true)
	iBalance getBalance(Integer accountId);

	@Query(value = "select a.id, a.AccountNumber,m.name, m.FatherName, s.name as schemeName, tr.amountCr , tr.voucher_no ,tr.Narration , tr.created_at from transaction_row tr \r\n"
			+ "left join accounts a on a.id=tr.account_id \r\n"
			+ "left join schemes s on a.scheme_id =s.id\r\n"
			+ "left join members m on m.id= a.member_id \r\n"
			+ "where tr.transaction_type_id = 42 and \r\n"
			+ "tr.account_id = ?1", nativeQuery = true)
	List<iEmployee> getConveyanceReport(Integer accountId);

	@Query(value = "select a.id, a.AccountNumber,m.name, m.FatherName, s.name as schemeName, tr.amountCr , tr.voucher_no ,tr.Narration , tr.created_at from transaction_row tr \r\n"
			+ "left join accounts a on a.id=tr.account_id \r\n"
			+ "left join schemes s on a.scheme_id =s.id\r\n"
			+ "left join members m on m.id= a.member_id \r\n"
			+ "where tr.transaction_type_id = 44 and \r\n"
			+ "tr.account_id = ?1", nativeQuery = true)
	List<iEmployee> getFuelReport(Integer accountId);

	@Query(value = "select a.AccountNumber , tr.created_at, m.name ,m.PhoneNos , m.FatherName , m.CurrentAddress , m.landmark , \r\n"
			+ "tr.amountCr , tr.Narration, a.account_type ,\r\n"
			+ "s2.name as schemeName from transaction_row tr \r\n"
			+ "left join transactions t on t.id = tr.transaction_id \r\n"
			+ "left join accounts a on a.id=tr.account_id \r\n"
			+ "left join agents a2 on a2.id=a.id \r\n"
			+ "left join members m on m.id = a.member_id \r\n"
			+ "left join schemes s2 on s2.id=a.scheme_id \r\n"
			+ "where \r\n"
			+ "(CASE WHEN (EXISTS(select a3.agent_id from accounts a3 where a3.agent_id = ?1)) \r\n"
			+ " THEN a.agent_id IN (select a4.agent_id from accounts a4 where a4.agent_id = ?1)\r\n"
			+ " ELSE a.agent_id NOT IN (select a4.agent_id from accounts a4 where a4.agent_id = ?1) END)\r\n"
			+ " and\r\n"
			+ "t.transaction_type_id =10\r\n"
			+ "and tr.created_at >= ?2 and tr.created_at <= ?3  \r\n"
			+ "order by tr.created_at DESC ", nativeQuery = true)
	List<iDepositeReport> getPremiumRecievedList(Integer agentId, String dateFrom, String dateTo);

	
	@Query(value = "select a.AccountNumber, a.created_at , m2.name , m2.PhoneNos , s.SchemeType , m3.name as agentName, a2.code_no , m3.CurrentAddress , m3.is_defaulter , m3.PhoneNos as agentPhoneno, a.ActiveStatus ,\r\n"
			+ "case when a.account_type = \"MIS\" then DATE_ADD(DATE(a.created_at) , INTERVAL s.MaturityPeriod day) \r\n"
			+ "when a.account_type = \"Recurring\" then DATE_ADD(DATE(a.created_at) , INTERVAL s.MaturityPeriod month)\r\n"
			+ "end as maturity,\r\n"
			+ "(sum(tr.amountCr) - sum(tr.amountDr)) as balance from transaction_row tr \r\n"
			+ "left join accounts a on a.id= tr.account_id \r\n"
			+ "left join schemes s on s.id=a.scheme_id \r\n"
			+ "left join members m2 on m2.id = a.member_id \r\n"
			+ "left join agents a2 on a2.id = a.agent_id \r\n"
			+ "left join members m3 on m3.id = a2.member_id \r\n"
			+ "where \r\n"
			+ "case \r\n"
			+ "when a.account_type = \"MIS\" then DATE_ADD(DATE(a.created_at) , INTERVAL s.MaturityPeriod day) <= ?1 \r\n"
			+ "when a.account_type = \"Recurring\" then DATE_ADD(DATE(a.created_at) , INTERVAL s.MaturityPeriod month) <= ?1 \r\n"
			+ "end\r\n"
			+ "and a2.id =  ?2 \r\n"
			+ "group by tr.account_id ", nativeQuery = true)
	List<iDepositeReport> getMaturedAccountWithBalance(String currentDate, Integer agentId);

	@Query(value = "select a.AccountNumber,m.name, m.member_no , m.CurrentAddress , m.PanNo , tr.amountCr , tr.amountDr,m.is_defaulter ,\r\n"
			+ "m2.name as agentName, a2.code_no , m2.CurrentAddress as agentAddress, m2.is_defaulter as agentDefaulter from transaction_row tr \r\n"
			+ "left join accounts a on a.id= tr.account_id \r\n"
			+ "left join schemes s on s.id=a.scheme_id \r\n"
			+ "left join members m on m.id= a.member_id \r\n"
			+ "left join agents a2 on a2.id = a.agent_id \r\n"
			+ "left join members m2 on m2.id = a2.member_id \r\n"
			+ "where tr.id in \r\n"
			+ "(select max(tr2.id) from transaction_row tr2 \r\n"
			+ "left join accounts a2 on a2.id= tr2.account_id \r\n"
			+ "where tr2.created_at >= ?1 and tr2.created_at <= ?2 \r\n"
			+ "and\r\n"
			+ "(a2.account_type =\"Recurring\" or a2.account_type =\"FD\" or a2.account_type =\"MIS\" or a2.account_type =\"DDS\" or a2.account_type=\"saving\")\r\n"
			+ "group by tr2.account_id  )", nativeQuery = true)
	List<iDepositeReport> getFundsFlow(String fromDate, String toDate);

	
	@Query(value = "select * from \r\n"
			+ "(select a.id as firstId, a.AccountNumber, (sum(tr.amountCr) - sum(tr.amountDr)) as OpeningBalance\r\n"
			+ "from transaction_row tr \r\n"
			+ "left join accounts a on tr.account_id = a.id \r\n"
			+ "where a.account_type = \"Default\" and a.group_type = \"Bank Accounts\" and a.PAndLGroup = \"Bank Accounts\"\r\n"
			+ "and tr.created_at < ?1 \r\n"
			+ "group by a.id) firstTable\r\n"
			+ "left join \r\n"
			+ "(select (sum(tr1.amountCr)) as TodaysPayment,  (sum(tr1.amountDr)) as TodaysReceived, a1.id as secondId\r\n"
			+ "from transaction_row tr1 \r\n"
			+ "left join accounts a1 on tr1.account_id = a1.id \r\n"
			+ "where a1.account_type = \"Default\" and a1.group_type = \"Bank Accounts\" and a1.PAndLGroup = \"Bank Accounts\"\r\n"
			+ "and (tr1.created_at >= ?1 and tr1.created_at < DATE_ADD( ?1, INTERVAL 1 DAY))\r\n"
			+ "group by a1.id) secondTable\r\n"
			+ "on firstTable.firstId = secondTable.secondId", nativeQuery = true)
	List<iCashBankReport> getCashBankReport1(String date);
	
	@Query(value = "select * from \r\n"
			+ "(select a.id as firstId, a.AccountNumber, (sum(tr.amountCr) - sum(tr.amountDr)) as OpeningBalance\r\n"
			+ "from transaction_row tr \r\n"
			+ "left join accounts a on tr.account_id = a.id \r\n"
			+ "where a.account_type = \"Default\" and a.group_type = \"BANK OD\" and a.PAndLGroup = \"BANK OD\"\r\n"
			+ "and tr.created_at < ?1 \r\n"
			+ "group by a.id) firstTable\r\n"
			+ "left join \r\n"
			+ "(select (sum(tr1.amountCr)) as TodaysPayment,  (sum(tr1.amountDr)) as TodaysReceived, a1.id as secondId\r\n"
			+ "from transaction_row tr1 \r\n"
			+ "left join accounts a1 on tr1.account_id = a1.id \r\n"
			+ "where a1.account_type = \"Default\" and a1.group_type = \"BANK OD\" and a1.PAndLGroup = \"BANK OD\"\r\n"
			+ "and (tr1.created_at >= ?1 and tr1.created_at < DATE_ADD(?1, INTERVAL 1 DAY))\r\n"
			+ "group by a1.id) secondTable\r\n"
			+ "on firstTable.firstId = secondTable.secondId", nativeQuery = true)
	List<iCashBankReport> getCashBankReport2(String date);

	@Query(value = "select * from \r\n"
			+ "(select a.id as firstId, a.AccountNumber, (sum(tr.amountCr) - sum(tr.amountDr)) as OpeningBalance\r\n"
			+ "from transaction_row tr \r\n"
			+ "left join accounts a on tr.account_id = a.id \r\n"
			+ "where a.account_type = \"Default\" and a.group_type = \"Cash Account\" and a.PAndLGroup = \"Cash Account\"\r\n"
			+ "and tr.created_at < ?1 \r\n"
			+ "group by a.id) firstTable\r\n"
			+ "left join \r\n"
			+ "(select (sum(tr1.amountCr)) as TodaysPayment,  (sum(tr1.amountDr)) as TodaysReceived, a1.id as secondId \r\n"
			+ "from transaction_row tr1 \r\n"
			+ "left join accounts a1 on tr1.account_id = a1.id \r\n"
			+ "where a1.account_type = \"Default\" and a1.group_type = \"Cash Account\" and a1.PAndLGroup = \"Cash Account\"\r\n"
			+ "and (tr1.created_at >= ?1 and tr1.created_at < DATE_ADD(?1, INTERVAL 1 DAY))\r\n"
			+ "group by a1.id) secondTable\r\n"
			+ "on firstTable.firstId = secondTable.secondId", nativeQuery = true)
	List<iCashBankReport> getCashBankReport3(String date);



}
