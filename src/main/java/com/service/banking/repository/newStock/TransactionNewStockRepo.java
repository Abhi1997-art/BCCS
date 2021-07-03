package com.service.banking.repository.newStock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StocknewTransactions;
import com.service.banking.model.newStock.StockNewItemDetails;
import com.service.banking.model.newStock.TransactionDeatils;

public interface TransactionNewStockRepo extends JpaRepository<StocknewTransactions,Integer>
{
	@Query("select new com.service.banking.model.newStock.TransactionDeatils (st.id, tp.name,frombr.name,fromM.name ,scfrom.name ,scrfrom.name,tobr.name,toMb.name ,scto.name ,scrto.name ,si.name ,\r\n" + 
			"st.qty ,st.rate ,st.narration,st.createdAt) \r\n" + 
			"from StocknewTransactions st\r\n" + 
			"left join StocknewItems si on si.id=st.stocknewItems.id \r\n" + 
			"left join StocknewTransactiontemplate tp on tp.id=st.stocknewTransactiontemplate.id \r\n" + 
			"left join StocknewMembers fromM on fromM.id=st.stocknewMembersByFromMemberId.id \r\n" + 
			"left join StocknewMembers toMb on toMb.id=st.stocknewMembersByToMemberId.id \r\n" + 
			"left join Branches frombr on frombr.id =st.branchesByFromBranchId.id \r\n" + 
			"left join Branches tobr on tobr.id=st.branchesByToBranchId.id \r\n" + 
			"left join StocknewContainer scfrom on scfrom .id=st.stocknewContainerByFromContainerId.id \r\n" + 
			"left join StocknewContainer scto on scto.id=st.stocknewContainerByToContainerId.id \r\n" + 
			"left join StocknewContainerrow scrfrom on scrfrom.id=st.stocknewContainerrowByFromContainerRowId.id \r\n" + 
			"left join StocknewContainerrow scrto on scrto.id=st.stocknewContainerrowByToContainerRowId.id ")
		public List<TransactionDeatils> getTransaction();

	@Query(value = "select st.id as stock_new_transaction_id, tp.name as transaction_template, frombr.name as from_branch_name, fromM.name  as from_Member_name, scfrom.name as from_container, scrfrom.name as from_container_row, tobr.name as to_branch_name, \r\n"
			+ "	toMb.name as to_member_name, scto.name as to_container_name, scrto.name as to_container_row_name ,si.name as item_name, st.qty ,st.rate ,st.narration,st.created_at \r\n"
			+ "	from stocknew_transactions st \r\n"
			+ "	left join stocknew_items si on si.id=st.item_id \r\n"
			+ "	left join stocknew_transactiontemplate tp on tp.id=st.transaction_template_type_id \r\n"
			+ "	left join stocknew_members fromM on fromM.id=st.from_member_id \r\n"
			+ "	left join stocknew_members toMb on toMb.id=st.to_member_id \r\n"
			+ "	left join branches frombr on frombr.id =st.from_branch_id \r\n"
			+ "	left join branches tobr on tobr.id=st.to_branch_id \r\n"
			+ "	left join stocknew_container scfrom on scfrom .id=st.from_container_id \r\n"
			+ "	left join stocknew_container scto on scto.id=st.to_container_id \r\n"
			+ "	left join stocknew_containerrow scrfrom on scrfrom.id=st.from_container_row_id \r\n"
			+ "	left join stocknew_containerrow scrto on scrto.id=st.to_container_row_id \r\n"
			+ "	where (CASE WHEN (EXISTS (select b2.id from branches b2 where b2.id = ?1)) THEN (frombr.id in (select b3.id from branches b3 where b3.id = ?1) or tobr.id in (select b3.id from branches b3 where b3.id = ?1)) \r\n"
			+ "	ELSE (frombr.id not in (select b3.id from branches b3 where b3.id = ?1) or tobr.id not in (select b3.id from branches b3 where b3.id = ?1)) END) and\r\n"
			+ "	(CASE WHEN (EXISTS (select scfrom2.id from stocknew_container scfrom2 where scfrom2.id = ?2)) THEN (scfrom.id in (select scfrom3.id from stocknew_container scfrom3 where scfrom3.id = ?2) or scto.id in (select scfrom3.id from stocknew_container scfrom3 where scfrom3.id = ?2)) \r\n"
			+ "	ELSE (scfrom.id not in (select scfrom3.id from stocknew_container scfrom3 where scfrom3.id = ?2) or scto.id not in (select scfrom3.id from stocknew_container scfrom3 where scfrom3.id = ?2)) END ) and\r\n"
			+ "	(CASE WHEN (EXISTS (select scrfrom2.id from stocknew_containerrow scrfrom2 where scrfrom2.id = ?3)) THEN (scrfrom.id in (select scrfrom3.id from stocknew_containerrow scrfrom3 where scrfrom3.id = ?3) or scrto.id in (select scrfrom3.id from stocknew_containerrow scrfrom3 where scrfrom3.id = ?3)) \r\n"
			+ "	ELSE (scrfrom.id not in (select scrfrom3.id from stocknew_containerrow scrfrom3 where scrfrom3.id = ?3) or scrto.id not in (select scrfrom3.id from stocknew_containerrow scrfrom3 where scrfrom3.id = ?3)) END ) and\r\n"
			+ "	(CASE WHEN (EXISTS (select fromM2.id from stocknew_members fromM2 where fromM2.id = ?4)) THEN (fromM.id in (select fromM3.id from stocknew_members fromM3 where fromM3.id = ?4) or toMb.id in (select fromM3.id from stocknew_members fromM3 where fromM3.id = ?4)) \r\n"
			+ "	ELSE (fromM.id not in (select fromM3.id from stocknew_members fromM3 where fromM3.id = ?4) or toMb.id not in (select fromM3.id from stocknew_members fromM3 where fromM3.id = ?4)) END ) and\r\n"
			+ "	(CASE WHEN (EXISTS (select si2.id from stocknew_items si2 where si2.id = ?5)) THEN (si.id in (select si2.id from stocknew_items si2 where si2.id = ?5)) \r\n"
			+ "	ELSE (si.id not in (select si2.id from stocknew_items si2 where si2.id = ?5)) END )\r\n"
			+ "	and\r\n"
			+ "	(CASE WHEN (EXISTS (select st2.created_at from stocknew_transactions st2 where st2.created_at > ?6)) THEN (st.created_at in (select st3.created_at from stocknew_transactions st3 where st3.created_at > ?6)) \r\n"
			+ "	ELSE (st.created_at not in (select st3.created_at from stocknew_transactions st3 where st3.created_at > ?6)) END ) \r\n"
			+ "	and\r\n"
			+ "	(CASE WHEN (EXISTS (select st2.created_at from stocknew_transactions st2 where st2.created_at < ?7)) THEN (st.created_at in (select st3.created_at from stocknew_transactions st3 where st3.created_at < ?7)) \r\n"
			+ "	ELSE (st.created_at not in (select st2.created_at from stocknew_transactions st2 where st2.created_at < ?7)) END )", nativeQuery = true)
	public List<Object []> getLedgerFilterByData(Integer branchId, Integer stocknew_containerId, Integer stocknew_containerrowId,
			 Integer stocknew_membersId, Integer stocknew_itemsId, String fromDate, String toDate);
}
