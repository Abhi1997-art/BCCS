package com.service.banking.repository.stockRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StockItems;
import com.service.banking.model.stockModel.StockCatModel;
import com.service.banking.model.stockModel.StockItemModel;

public interface StockItemRepo  extends JpaRepository<StockItems,Integer>
{
	@Query("select  new com.service.banking.model.stockModel.StockItemModel(si.id,si.name, sc.name ,b.name,si.description ,si.isConsumable,si.isIssueable ,si.isFixedassets ,si.isActive ) from StockItems si\r\n" + 
			"left join Branches b on si.branches.id =b.id\r\n" + 
			"left join  StockCategories sc  on si.stockCategories.id = sc.id")
	List<StockItemModel> getStockItem();
	
}
