package com.service.banking.repository.madRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.banking.hibernateEntity.BankBranches;

public interface BankBranchRepository extends JpaRepository<BankBranches, Integer>{

}
