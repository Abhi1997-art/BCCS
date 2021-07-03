package com.service.banking.repository.newStock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StocknewCategory;
import com.service.banking.model.newStock.CatogoryDetails;
import com.service.banking.model.stockModel.RowItemQtyModel;

public interface CategoryRepo extends JpaRepository<StocknewCategory,Integer> {
	
	@Query("select new com.service.banking.model.newStock.CatogoryDetails(sg.id,sg.name,sg.allowedInTransactions) from  StocknewCategory sg")
	List<CatogoryDetails> getCategory();

}
