package com.service.banking.repository.newStock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StocknewItems;
import com.service.banking.model.newStock.IStockNewItemDetails;
import com.service.banking.model.newStock.StockNewItemDetails;


public interface SockNewItemRepo extends JpaRepository<StocknewItems,Integer> {
	
	@Query("select new com.service.banking.model.newStock.StockNewItemDetails(si.id,sc.name ,si.name ,si.code ,sc.allowedInTransactions ,si.description ,si.isActive ,si.isFixedAsset)from  StocknewItems si \r\n" + 
			"left join StocknewCategory sc  on sc.id =si.stocknewCategory.id \r\n" + 
			"where si.isActive =1 order by si.name")
		public List<StockNewItemDetails> getAllItems();

	@Query("SELECT new com.service.banking.model.newStock.StockNewItemDetails(si.id, si.name, si.code) from StocknewItems si where Concat(REPLACE(si.name, ' ', ''), REPLACE(si.code, ' ', '')) like %?1% or Concat(REPLACE(si.code, ' ', ''), REPLACE(si.name, ' ', '')) like %?1%")
	public List<StockNewItemDetails> getItemDetails(String details);

	@Query(value = "select st1.id as id, si. id as itemId, si.name as name, sc.id as catId, sc.name as catName,si.code as code, sc.allowed_in_transactions as allowedInTransactions,si.description as description, si.is_active as isActive, si.is_fixed_asset as isFixedAsset, \r\n"
			+ "st1.transaction_template_type_id as stocknewTransactiontemplateId, sum(IF(st1.transaction_template_type_id='1' and st1.created_at <'2019-12-23',st1.qty,0)) as opening, "
			+ " sum(IF(st1.transaction_template_type_id='2' and st1.created_at <'2019-12-23',st1.qty,0)) as purchase, sum(IF(st1.transaction_template_type_id='3' and st1.created_at <'2019-12-23',st1.qty,0)) as purchaseReturn, "
			+ " sum(IF(st1.transaction_template_type_id='4' and st1.created_at <'2019-12-23',st1.qty,0)) as internalMove, sum(IF(st1.transaction_template_type_id='5' and st1.created_at <'2019-12-23',st1.qty,0)) as branchTransfer, "
			+ " sum(IF(st1.transaction_template_type_id='6' and st1.created_at <'2019-12-23',st1.qty,0)) as issue, sum(IF(st1.transaction_template_type_id='7' and st1.created_at <'2019-12-23',st1.qty,0)) as consume, "
			+ " sum(IF(st1.transaction_template_type_id='8' and st1.created_at <'2019-12-23',st1.qty,0)) as submit, sum(IF(st1.transaction_template_type_id='9' and st1.created_at <'2019-12-23',st1.qty,0)) as usedSubmit, "
			+ " sum(IF(st1.transaction_template_type_id='10' and st1.created_at <'2019-12-23',st1.qty,0)) as deadSubmit from \r\n"
			+ " stocknew_items si inner join stocknew_category sc  on sc.id = si.category_id \r\n"
			+ "inner join stocknew_transactions st1 on si.id = st1.item_id "
			+ "	where (CASE WHEN (EXISTS (select b2.id from branches b2 where b2.id = ?1)) THEN (st1.from_branch_id in (select b3.id from branches b3 where b3.id = ?1) or st1.to_branch_id in (select b3.id from branches b3 where b3.id = ?1)) \r\n"
			+ "	ELSE (st1.from_branch_id not in (select b3.id from branches b3 where b3.id = ?1) or st1.to_branch_id not in (select b3.id from branches b3 where b3.id = ?1)) END) and\r\n"
			+ "	(CASE WHEN (EXISTS (select scfrom2.id from stocknew_container scfrom2 where scfrom2.id = ?2)) THEN (st1.from_container_id in (select scfrom3.id from stocknew_container scfrom3 where scfrom3.id = ?2) or st1.to_container_id in (select scfrom3.id from stocknew_container scfrom3 where scfrom3.id = ?2)) \r\n"
			+ "	ELSE (st1.from_container_id not in (select scfrom3.id from stocknew_container scfrom3 where scfrom3.id = ?2) or st1.to_container_id not in (select scfrom3.id from stocknew_container scfrom3 where scfrom3.id = ?2)) END ) and\r\n"
			+ "	(CASE WHEN (EXISTS (select scrfrom2.id from stocknew_containerrow scrfrom2 where scrfrom2.id = ?3)) THEN (st1.from_container_row_id in (select scrfrom3.id from stocknew_containerrow scrfrom3 where scrfrom3.id = ?3) or st1.to_container_row_id in (select scrfrom3.id from stocknew_containerrow scrfrom3 where scrfrom3.id = ?3)) \r\n"
			+ "	ELSE (st1.from_container_row_id not in (select scrfrom3.id from stocknew_containerrow scrfrom3 where scrfrom3.id = ?3) or st1.to_container_row_id not in (select scrfrom3.id from stocknew_containerrow scrfrom3 where scrfrom3.id = ?3)) END ) and\r\n"
			+ "	(CASE WHEN (EXISTS (select fromM2.id from stocknew_members fromM2 where fromM2.id = ?4)) THEN (st1.from_member_id in (select fromM3.id from stocknew_members fromM3 where fromM3.id = ?4) or st1.to_member_id in (select fromM3.id from stocknew_members fromM3 where fromM3.id = ?4)) \r\n"
			+ "	ELSE (st1.from_member_id not in (select fromM3.id from stocknew_members fromM3 where fromM3.id = ?4) or st1.to_member_id not in (select fromM3.id from stocknew_members fromM3 where fromM3.id = ?4)) END ) and\r\n"
			+ "	(CASE WHEN (EXISTS (select si2.id from stocknew_items si2 where si2.id = ?5)) THEN (st1.item_id in (select si2.id from stocknew_items si2 where si2.id = ?5)) \r\n"
			+ "	ELSE (st1.item_id not in (select si2.id from stocknew_items si2 where si2.id = ?5)) END )\r\n"
			+ "	and\r\n"
			+ "	(CASE WHEN (EXISTS (select st2.id from stocknew_category st2 where st2.id = ?6)) THEN (sc.id in (select st3.id from stocknew_category st3 where st3.id = ?6)) \r\n"
			+ "	ELSE (sc.id not in (select st3.id from stocknew_category st3 where st3.id = ?6)) END ) group by si.id order by si.name ", nativeQuery = true)
	public List<IStockNewItemDetails> getFilteredOverAllStockReports(Integer branchId, Integer stocknew_containerId,
			Integer stocknew_containerrowId, Integer stocknew_membersId, Integer stocknew_itemsId, Integer categoryId);

}


