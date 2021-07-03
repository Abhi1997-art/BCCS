package com.service.banking.repository.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.TransactionElement;
import com.service.banking.model.transaction.TransElementDetails;
import com.service.banking.model.transaction.TransPageDetails;

public interface TranElementRepo extends JpaRepository<TransactionElement, Integer> {
	
	// get all element ............................
	
      //@Query("select new com.service.banking.model.transaction.TransPageDetails(tp.id ,tp.transName ,tp.transType ,tp.pageOrderNumber ,tp.status) from  TransactionPage tp GROUP BY (tp.pageOrderNumber) ")	
		@Query(" select new com.service.banking.model.transaction.TransElementDetails(te.id ,te.elementCode,te.elementType ,te.elementDesc) from TransactionElement te") 
		List<TransElementDetails> getAllElements();

}
