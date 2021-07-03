package com.service.banking.repository.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.TransactionTypes;

public interface TransTypeRepo extends JpaRepository<TransactionTypes, Integer>{

	@Query("select new com.service.banking.hibernateEntity.TransactionTypes(t.id, t.name)from TransactionTypes t")
	List<TransactionTypes> getTransType();

}
