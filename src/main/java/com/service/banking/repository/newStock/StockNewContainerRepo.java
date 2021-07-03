package com.service.banking.repository.newStock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StocknewContainer;
import com.service.banking.model.newStock.StockContainerRow;

public interface StockNewContainerRepo extends JpaRepository<StocknewContainer, Integer>{
	
	@Query("SELECT new com.service.banking.model.newStock.StockContainerRow(stnc.id, stnc.name) from StocknewContainer stnc")
	public List<StockContainerRow> getContainerList();
}
