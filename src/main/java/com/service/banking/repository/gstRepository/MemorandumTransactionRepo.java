package com.service.banking.repository.gstRepository;

import com.service.banking.hibernateEntity.MemorandumTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemorandumTransactionRepo extends JpaRepository<MemorandumTransactions, Integer> {
}
