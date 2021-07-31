package com.service.banking.repository.hodAuthorityRepo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.MemorandumTransactions;
import com.service.banking.model.GstModel.TransactionType;

public interface MemoRandomRepo extends JpaRepository<MemorandumTransactions, Integer> {

	// get memo random......................
	@Query("from MemorandumTransactions")
	List<MemorandumTransactions> allMemorandoms();

	// transaction type for gst memprandom apply
	@Query(" select distinct  new  com.service.banking.model.GstModel.TransactionType(mt.memorandumType) from MemorandumTransactions mt ")
	List<TransactionType> transactionType();

	// get memorandom..........
	@Query(value = "select mt.id as memorandumTransactionrowId, stf.id as staffId, stf.name as staffName, br.id as branchId, br.name as branchName, mt2.name as name, \r\n"
			+ "mt2.memorandum_type as memorandumType, mt2.narration as narration, mt2.created_at as createdAt,\r\n"
			+ "SUM(mt.amountCr) as amountCr, SUM(mt.amountDr) as amountDr, \r\n"
			+ "Group_CONCAT(IF(mt.amountCr > 0, a.AccountNumber, null) separator ', ') as crAccountNumber, \r\n"
			+ "Group_CONCAT(IF(mt.amountDr > 0, a.AccountNumber, null) separator ', ') as drAccountNumber, \r\n"
			+ "GROUP_CONCAT(IF(mt.amountCr > 0, m.name, null) separator ', ') as crMemberName, \r\n"
			+ "GROUP_CONCAT(IF(mt.amountDr > 0, m.name, null) separator ', ') as drMemberName, \r\n"
			+ "GROUP_CONCAT(IF(mt.amountCr > 0,  IFNULL(m.FatherName, ' NA'), null) separator ', ') as crFatherName, \r\n"
			+ "GROUP_CONCAT(IF(mt.amountDr > 0,  IFNULL(m.FatherName, ' NA'), null) separator ', ') as drFatherName, \r\n"
			+ "Max(mt.tax_amount) as taxAmount, mt2.id as memorandomTransactionId\r\n"
			+ "from memorandum_transactionsrow mt  \r\n"
			+ "left join memorandum_transactions mt2 on mt2.id = mt.memorandum_transaction_id \r\n"
			+ "left join accounts a on a.id = mt.account_id \r\n"
			+ "left join members m on a.member_id = m.id \r\n"
			+ "left join staffs stf on mt2.staff_id = stf.id \r\n"
			+ "left join branches br on mt2.branch_id = br.id \r\n"
			+ "GROUP by mt.memorandum_transaction_id", 
			countQuery = "select count(mt.id) from memorandum_transactionsrow mt GROUP by mt.memorandum_transaction_id", nativeQuery = true)
	public Page<Object[]> getAllMemorandoms(Pageable pageable);
}
