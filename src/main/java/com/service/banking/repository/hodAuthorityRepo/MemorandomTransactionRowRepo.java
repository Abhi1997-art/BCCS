package com.service.banking.repository.hodAuthorityRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.service.banking.hibernateEntity.MemorandumTransactionsrow;
import com.service.banking.model.hodAuthorityModel.MemoRandomTransactionRowDetails;
import com.service.banking.model.hodAuthorityModel.iDeleteVoucherDetails;

public interface MemorandomTransactionRowRepo extends JpaRepository<MemorandumTransactionsrow, Integer>{

	
	// get memorandom details api..................
	@Query("select new com.service.banking.model.hodAuthorityModel.MemoRandomTransactionRowDetails(mtr.id, mtr.memorandumTransactionId, mt.name, "
			+ "mtr.accountId, a.accountNumber, m.id, m.name, m.fatherName, mtr.tax, mtr.taxPercentage, mtr.taxAmount, mtr.taxNarration, mtr.taxExcludedAmount, mtr.amountCr, mtr.amountDr, "
			+ "mtr.createdAt, mt.memorandumType) from MemorandumTransactionsrow mtr left join "
			+ "MemorandumTransactions mt on mt.id = mtr.memorandumTransactionId left join Accounts a on mtr.accountId = a.id left join Members m on "
			+ "a.memberId = m.id where mtr.memorandumTransactionId = ?1")
	public List<MemoRandomTransactionRowDetails> getDetailsMemodandom(Integer memorandomTransactionId);

}