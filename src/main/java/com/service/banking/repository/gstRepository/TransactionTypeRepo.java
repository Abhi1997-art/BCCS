package com.service.banking.repository.gstRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.TransactionTypes;
import com.service.banking.model.GstModel.SupplierDetails;

public interface TransactionTypeRepo  extends JpaRepository<TransactionTypes,Integer>{
	
	
	// get all transaction type....
		@Query("from TransactionTypes")  
		public List<TransactionTypes> transactioType(); // 


}
