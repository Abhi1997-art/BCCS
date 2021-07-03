package com.service.banking.repository.newStock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StocknewMembers;
import com.service.banking.model.newStock.MemberDetails;
import com.service.banking.model.newStock.StockNewItemDetails;
import com.service.banking.model.printingModel.MemberDetail;

public interface MemberRepo  extends JpaRepository<StocknewMembers,Integer> {
	
	@Query("select new com.service.banking.model.newStock.MemberDetails(m.id,m.name ,m.address,m.phNo ,m.type ,m.isActive)from  StocknewMembers m")
		public List<MemberDetails> getMember();
	
	

}
