package com.service.banking.repository.newStock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StocknewContainerrow;
import com.service.banking.model.newStock.StockContainerRow;

public interface StockNewContainerRowRepo extends JpaRepository<StocknewContainerrow, Integer>{

	
	@Query("select new com.service.banking.model.newStock.StockContainerRow(scr.id, scr.name) from StocknewContainerrow scr")
	public List<StockContainerRow> getAllContainersRowName();
}

