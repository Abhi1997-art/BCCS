package com.service.banking.repository.stockRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StockRows;
import com.service.banking.model.stockModel.StockRowModel;

public interface StockRowRepo extends JpaRepository<StockRows,Integer> {
	
	@Query("select new com.service.banking.model.stockModel.StockRowModel(sr.id ,sr.name,b.name,sc.name) from StockRows sr\r\n" + 
			"inner join Branches b on sr.branches.id =b.id  and  b.name= 'Default' and sr.name is not NULL \r\n" + 
			"inner join  StockContainers sc  on sr.stockContainers.id = sc.id")
	List<StockRowModel> getStockRow();

}
