package com.service.banking.repository.newStock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StocknewContainer;
import com.service.banking.model.newStock.MemberDetails;
import com.service.banking.model.newStock.StockContainerRow;

public interface ContainerRowRepo extends JpaRepository<StocknewContainer,Integer> {

	
	@Query("select new com.service.banking.model.newStock.StockContainerRow(sc.id,br.id,br.name,sct.name,sct.id,sc.name) from StocknewContainer sc \r\n" + 
			"left join StocknewContainertype  sct on sc.stocknewContainertype.id =sct.id \r\n" + 
			"left join Branches br on sc.branches.id =br.id ")
	public List<StockContainerRow> conatinerRow();

	
	@Query("select new com.service.banking.model.newStock.StockContainerRow(sc.id, sc.name, sc.branches.id, scr.name, scr.isDefault) from StocknewContainer sc "
			+ "left join StocknewContainerrow scr on sc.id = scr.stocknewContainer.id where sc.id = ?1")
	public List<StockContainerRow> getStockNewContainerRowByContainerId(Integer id);
	
	@Query("select new com.service.banking.model.newStock.StockContainerRow(sc.id, sc.name) from StocknewContainer sc")
	public List<StockContainerRow> getAllContainersName();


}
