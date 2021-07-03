package com.service.banking.repository.hodAuthorityRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Bank;

public interface BankListRepo extends JpaRepository<Bank, Integer> {

	// get all bank......................
	@Query("select new com.service.banking.hibernateEntity.Bank(b.id,b.name) from Bank b")
	public List<Bank> bankList();

}
