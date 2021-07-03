package com.service.banking.repository.superAdminRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.BalanceSheet;
import com.service.banking.model.superAdminModel.BalanceSheetHead;
import com.service.banking.model.superAdminModel.ShareDetails;

public interface BalanceSheetRepo  extends JpaRepository<BalanceSheet, Integer> {
	
	// get balancesheet.................
	@Query("select  new  com.service.banking.model.superAdminModel.BalanceSheetHead(b.id,b.name) from BalanceSheet b")
	List<BalanceSheetHead> getBalanceSheetHead();  

}
