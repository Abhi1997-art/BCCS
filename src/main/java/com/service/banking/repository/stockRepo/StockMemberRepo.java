package com.service.banking.repository.stockRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StockMembers;
import com.service.banking.model.stockModel.StockCatModel;
import com.service.banking.model.stockModel.StockMemberModel;

public interface StockMemberRepo extends JpaRepository<StockMembers,Integer> {

	
	@Query("select new com.service.banking.model.stockModel.StockMemberModel(sm.id ,sm.name,b.name,sm.address ,sm.phNo ,sm.type ,sm.isActive) from StockMembers sm \r\n" + 
			"	inner join Branches b on sm.branches.id =b.id  and  b.name= 'Default'")
	List<StockMemberModel> getStockMember();
	
}
