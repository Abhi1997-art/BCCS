package com.service.banking.repository.stockRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StockContainers;
import com.service.banking.model.stockModel.StockContainerModel;

public interface StockContainerRepo extends JpaRepository<StockContainers,Integer> {
	
	
	@Query("select new com.service.banking.model.stockModel.StockContainerModel(sc.id,sc.name,b.name as branchName) from StockContainers sc \r\n" + 
			"INNER join Branches b on sc.branches.id=b.id  and  b.name= 'Default' and b.name is not NULL \r\n" + 
			"ORDER BY sc.name")
	List<StockContainerModel> getStockContainer();

}
