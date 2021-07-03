package com.service.banking.repository.stockRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StockCategories;
import com.service.banking.model.stockModel.StockCatModel;
import com.service.banking.model.stockModel.StockRowModel;

public interface StockCategoryRepo extends JpaRepository<StockCategories,Integer> {


	@Query("select new com.service.banking.model.stockModel.StockCatModel(scat.id,scat.name,b.name) from StockCategories scat\r\n" + 
			"inner join Branches b on scat.branches.id =b.id  and  b.name= 'Default' and b.name is not NULL \r\n" + 
			"ORDER BY scat.name")
	List<StockCatModel> getStockCat();
}
