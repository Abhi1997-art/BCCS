package com.service.banking.repository.newStock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StocknewContainertype;
import com.service.banking.model.newStock.StockContainerTypeDetails;

public interface ContainerTypeRepo extends JpaRepository<StocknewContainertype,Integer>
{

	@Query("select new com.service.banking.model.newStock.StockContainerTypeDetails(sct.id,sct.name)from StocknewContainertype sct")
	List<StockContainerTypeDetails>  getStockContainer();
}
