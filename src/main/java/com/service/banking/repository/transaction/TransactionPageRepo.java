package com.service.banking.repository.transaction;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.TransactionPage;
import com.service.banking.model.transaction.TransPageDetails;

public interface TransactionPageRepo extends  JpaRepository<TransactionPage, Integer> {

	// get all transaction page........
	//	@Query(" select new com.service.banking.model.transaction.TransPageDetails(tp.id ,tp.transName ,tp.transType ,tp.pageOrderNumber ,tp.status) from  TransactionPage tp")  //this normal fetch not group by
//	@Query("select new com.service.banking.model.transaction.TransPageDetails(tp.id, tp.transactionName,  tp.transactionType, tp.gstPercentage, tp.databaseEffected, tp.accountFilter,  tp.accountType,  tp.allowMultipleBranch, tp.supplierType, tp.tdsDeducted, tp.narration, tp.member, tp.pageOrderNumber,tp.status,tp.createdAt) from  TransactionPage tp GROUP BY (tp.pageOrderNumber) ")	
	@Query("from  TransactionPage tp GROUP BY (tp.pageOrderNumber) ")	
	List<TransactionPage> getTransPage();
	
	
}
