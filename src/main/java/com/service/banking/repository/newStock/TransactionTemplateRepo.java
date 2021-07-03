package com.service.banking.repository.newStock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StocknewTransactiontemplate;
import com.service.banking.model.newStock.StockContainerRow;
import com.service.banking.model.newStock.TransTemplateDeatils;

public interface TransactionTemplateRepo extends JpaRepository<StocknewTransactiontemplate,Integer> {
	
	// for edit transaction template.........................
	@Query("select new com.service.banking.model.newStock.TransTemplateDeatils(st.id,st.name,st.fromBranch ,st.fromSupplier,st.fromStaff ,st.fromAgent ,st.fromDealer ,st.itemCategories ,st.fromContainer \r\n" + 
			",st.fromContainerRow ,st.fromContainerTypes,st.toBranch ,st.toSupplier ,st.toStaff ,st.toAgent ,st.toDealer ,st.toContainer \r\n" + 
			",st.toContainerTypes ,st.toContainerRow ,st.qty,st.narration ,st.items,st.rate ,st.alwaysFromCurrentBranch ,st.fromDefaultContainerRow\r\n" + 
			",st.alwaysToCurrentBranch ,st.toDefaultContainerRow ,st.checkFromQty ,st.subtractQtyFrom ,st.addQtyTo ,\r\n" + 
			"st.allowedToAccesslevel) from StocknewTransactiontemplate st   ")
	public List<TransTemplateDeatils> gettransTemplate();
	
	//  for edit transaction get transactiontemplate only name
	@Query("select new com.service.banking.model.newStock.TransTemplateDeatils(st.id,st.name) from StocknewTransactiontemplate st")
	public List<TransTemplateDeatils> transTemplateName();
	
	
	

}
