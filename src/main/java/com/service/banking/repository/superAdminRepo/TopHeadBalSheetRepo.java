package com.service.banking.repository.superAdminRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.BalanceSheet;

public interface TopHeadBalSheetRepo extends JpaRepository<BalanceSheet, Integer> {

	// get top head balance sheet.......................
	@Query("from BalanceSheet")
	List<BalanceSheet> getTopbalanceSheets();
}
