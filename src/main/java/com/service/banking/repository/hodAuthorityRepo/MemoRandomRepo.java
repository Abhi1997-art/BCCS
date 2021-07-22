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
	@Query(value = "select mtr.id as memorandumTransactionrowId, stf.id as staffId, stf.name as staffName, br.id as branchId, br.name as branchName, mt.name as name, \r\n"
			+ "mt.memorandum_type as memorandumType, mt.narration as narration, mt.created_at as createdAt, SUM(mtr.amountCr) as amountCr, SUM(mtr.amountDr) as amountDr, \r\n"
			+ "Group_CONCAT(IF(mtr.amountCr > 0, a.AccountNumber, null) separator ', ') as crAccountNumber, \r\n"
			+ "Group_CONCAT(IF(mtr.amountDr > 0, a.AccountNumber, null) separator ', ') as drAccountNumber, \r\n"
			+ "GROUP_CONCAT(IF(mtr.amountCr > 0, m.name, null) separator ', ') as crMemberName, GROUP_CONCAT(IF(mtr.amountDr > 0, m.name, null) separator ', ') as drMemberName, \r\n"
			+ "GROUP_CONCAT(IF(mtr.amountCr > 0,  IFNULL(m.FatherName, ' NA'), null) separator ', ') as crFatherName, \r\n"
			+ "GROUP_CONCAT(IF(mtr.amountDr > 0,  IFNULL(m.FatherName, ' NA'), null) separator ', ') as drFatherName, \r\n"
			+ "Max(mtr.tax_amount) as taxAmount, mt.id as memorandomTransactionId from memorandum_transactions mt left join memorandum_transactionsrow mtr \r\n"
			+ "on mt.id = mtr.memorandum_transaction_id left join accounts a on a.id = mtr.account_id left join members m on a.member_id = m.id \r\n"
			+ "left join staffs stf on mt.staff_id = stf.id left join branches br on mt.branch_id = br.id "
			+ " GROUP by mtr.memorandum_transaction_id", countQuery = "select count(mt.id) from memorandum_transactions mt ", nativeQuery = true)
	public Page<Object[]> getAllMemorandoms(Pageable pageable);
}
