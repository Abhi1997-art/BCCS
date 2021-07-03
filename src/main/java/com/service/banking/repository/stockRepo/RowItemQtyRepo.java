package com.service.banking.repository.stockRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StockContainerrowitemqty;
import com.service.banking.model.stockModel.RowItemQtyModel;
import com.service.banking.model.stockModel.StockCatModel;

public interface RowItemQtyRepo extends JpaRepository<StockContainerrowitemqty,Integer> {
	
	@Query("select new com.service.banking.model.stockModel.RowItemQtyModel(scr.id ,scr.qty,b.name ,sc.name,sr.name,si.name) from StockContainerrowitemqty scr\r\n" + 
			"left join Branches b on scr.branches.id =b.id \r\n" + 
			"left join  StockContainers sc  on scr.stockContainers.id = sc.id\r\n" + 
			"left join StockRows sr on scr.stockRows.id =sr.id \r\n" + 
			"left join  StockItems si on scr.stockItems.id = si.id\r\n" + 
			"WHERE b.name ='Default'")
	List<RowItemQtyModel> getRowItemQty();

}
