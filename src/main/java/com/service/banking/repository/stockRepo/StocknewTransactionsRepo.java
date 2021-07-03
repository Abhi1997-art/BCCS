package com.service.banking.repository.stockRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.banking.hibernateEntity.StocknewTransactions;

public interface StocknewTransactionsRepo extends JpaRepository<StocknewTransactions, Integer>{

}
