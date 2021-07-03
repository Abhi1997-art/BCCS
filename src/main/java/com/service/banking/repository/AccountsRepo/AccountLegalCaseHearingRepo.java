package com.service.banking.repository.AccountsRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.service.banking.hibernateEntity.AccountLegalCaseHearing;

@Repository
public interface AccountLegalCaseHearingRepo extends JpaRepository<AccountLegalCaseHearing, Integer>{
	

}