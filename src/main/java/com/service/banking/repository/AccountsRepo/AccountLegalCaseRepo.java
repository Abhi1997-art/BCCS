package com.service.banking.repository.AccountsRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.banking.hibernateEntity.AccountLegalCase;

public interface AccountLegalCaseRepo extends JpaRepository<AccountLegalCase, Integer>{

}