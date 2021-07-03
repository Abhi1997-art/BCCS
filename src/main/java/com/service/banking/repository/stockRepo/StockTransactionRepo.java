package com.service.banking.repository.stockRepo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StockTransactions;
import com.service.banking.model.stockModel.ItemName;
import com.service.banking.model.stockModel.LedgerItemDetails;
import com.service.banking.model.stockModel.StaffName;
import com.service.banking.model.stockModel.StockTranDetails;
import com.service.banking.model.stockModel.LedSupplierDetails;
import com.service.banking.model.stockModel.TransactionDetails;

public interface StockTransactionRepo extends JpaRepository<StockTransactions,Integer>{
	
	//..........for UsedSubmit.................
	
	@Query("select new com.service.banking.model.stockModel.StockTranDetails(scr.id ,scr.qty ,si.name as itemName,scr.narration,scr.amount ,scr.createdAt, scr.transactionType,m.name as memberName) from StockTransactions scr\r\n" + 
			"left join Branches bt on scr.branches.id =bt.id \r\n" + 
			"left join Branches b on scr.branches.id =b.id \r\n" + 
			"left join  StockItems si on scr.stockItems.id = si.id\r\n" + 
			"left join  StockMembers m on scr.stockMembers.id =m.id\r\n" + 
			"WHERE   b.name ='Default' and scr.transactionType ='UsedSubmit' ORDER by si.name ")
	      List<StockTranDetails>  getUsedSubmit();
	
	//..........for Dead Submit...............
	@Query("select new com.service.banking.model.stockModel.StockTranDetails(scr.id ,scr.qty ,si.name as itemName,scr.narration,scr.amount ,scr.createdAt, scr.transactionType,m.name as memberName) from StockTransactions scr\r\n" + 
			"left join Branches bt on scr.branches.id =bt.id \r\n" + 
			"left join Branches b on scr.branches.id =b.id \r\n" + 
			"left join  StockItems si on scr.stockItems.id = si.id\r\n" + 
			"left join  StockMembers m on scr.stockMembers.id =m.id\r\n" + 
			"WHERE   b.name ='Default' and scr.transactionType ='DeadSubmit' ORDER by si.name ")
	      List<StockTranDetails>  getDeadSubmit();
	
	
	//..........for Submit...........................
	@Query("select new com.service.banking.model.stockModel.StockTranDetails(scr.id ,scr.qty ,si.name as itemName,scr.narration,scr.amount ,scr.createdAt, scr.transactionType,m.name as memberName) from StockTransactions scr\r\n" + 
			"left join Branches bt on scr.branches.id =bt.id \r\n" + 
			"left join Branches b on scr.branches.id =b.id \r\n" + 
			"left join  StockItems si on scr.stockItems.id = si.id\r\n" + 
			"left join  StockMembers m on scr.stockMembers.id =m.id\r\n" + 
			"WHERE   b.name ='Default' and scr.transactionType ='submit' ORDER by si.name ")
	      List<StockTranDetails>  getSubmit();
	
	
	//..........for consume.............................
	@Query("select new com.service.banking.model.stockModel.StockTranDetails(scr.id ,scr.qty ,si.name as itemName,scr.narration,scr.amount ,scr.createdAt, scr.transactionType,m.name as memberName) from StockTransactions scr\r\n" + 
			"left join Branches bt on scr.branches.id =bt.id \r\n" + 
			"left join Branches b on scr.branches.id =b.id \r\n" + 
			"left join  StockItems si on scr.stockItems.id = si.id\r\n" + 
			"left join  StockMembers m on scr.stockMembers.id =m.id\r\n" + 
			"WHERE   b.name ='Default' and scr.transactionType ='consume' ORDER by si.name ")
	      List<StockTranDetails>  getComsume();
	
	//..........for issue............................
	    @Query("select new com.service.banking.model.stockModel.StockTranDetails(scr.id ,scr.qty ,si.name as itemName,scr.narration,scr.amount ,scr.createdAt, scr.transactionType,m.name as memberName) from StockTransactions scr\r\n" + 
			"left join Branches bt on scr.branches.id =bt.id \r\n" + 
			"left join Branches b on scr.branches.id =b.id \r\n" + 
			"left join  StockItems si on scr.stockItems.id = si.id\r\n" + 
			"left join  StockMembers m on scr.stockMembers.id =m.id\r\n" + 
			"WHERE   b.name ='Default' and scr.transactionType ='issue' ORDER by si.name")
	      List<StockTranDetails>  getIsuue();
	
		//..........for transfer.......
	   @Query("select new com.service.banking.model.stockModel.StockTranDetails(scr.id ,scr.qty ,si.name as itemName ,scr.rate ,scr.createdAt ,scr.narration,scr.amount ,bt.name as toBranchName,b.name as branchName)from StockTransactions scr\r\n" + 
			"left join Branches bt on scr.branches.id =bt.id \r\n" + 
			"left join Branches b on scr.branches.id =b.id \r\n" + 
			"left join  StockItems si on scr.stockItems.id = si.id\r\n" + 
			"WHERE   b.name ='Default' and scr.transactionType ='transfer' ORDER by si.name")
	    List<StockTranDetails>  getTransfer();
	
		//..........for opening.......                                              
	        @Query("select new com.service.banking.model.stockModel.StockTranDetails(scr.id ,scr.qty,si.name as itemName ,scr.narration,scr.createdAt,scr.rate , b.name  as branchName) from StockTransactions scr\r\n" + 
	        		"left join Branches b on scr.branches.id =b.id \r\n" + 
	        		"left join  StockItems si on scr.stockItems.id = si.id\r\n" + 
	        		"WHERE b.name ='Default' and scr.transactionType ='openning' ORDER by si.name ")
		    List<StockTranDetails>  getOpening();
	        
	    	//..........for purchase.......
	        @Query("select new com.service.banking.model.stockModel.StockTranDetails(scr.id ,b.name  as branchName,si.name as itemName ,scr.rate ,scr.createdAt ,scr.narration,m.name as memberName,scr.qty) from StockTransactions scr\r\n" + 
	        		"left join Branches b on scr.branches.id =b.id \r\n" + 
	        		"left join  StockItems si on scr.stockItems.id = si.id\r\n" + 
	        		"left join  StockMembers m on scr.stockMembers.id =m.id \r\n" + 
	        		"WHERE b.name ='Default' and scr.transactionType ='purchase' ORDER by si.name")
		    List<StockTranDetails>  getPurchase();
	        
	    	//..........for purchase return.......                                 
		                                                                                                                                                         
	        @Query("select new com.service.banking.model.stockModel.StockTranDetails(scr.id ,b.name  as branchName,si.name as itemName ,scr.rate ,scr.createdAt ,scr.narration,m.name as memberName,scr.qty) from StockTransactions scr\r\n" + 
	        		"left join Branches b on scr.branches.id =b.id \r\n" + 
	        		"left join  StockItems si on scr.stockItems.id = si.id\r\n" + 
	        		"left join  StockMembers m on scr.stockMembers.id =m.id \r\n" +
	        		"WHERE b.name ='Default' and scr.transactionType ='purchasereturn'  ORDER by si.name")
		    List<StockTranDetails>  getPurchasereturn();
	        
	    	//..........for move.......                                            
		                                                                           
	        @Query("select new com.service.banking.model.stockModel.StockTranDetails( scr.id ,scr.qty ,si.name as itemName ,scr.narration,scr.createdAt ,scr.rate ,scf.name as fromContainer,sc.name as toContainer,srf.name as fromRow,sr.name  as toRow) from StockTransactions scr\r\n" + 
	        		"left join   StockRows sr on scr.stockRowsByToRowId.id =sr.id \r\n" + 
	        		"left join   StockRows srf on scr.stockRowsByFromRowId.id =srf.id \r\n" + 
	        		"left join  StockContainers sc  on scr.stockContainersByToContainerId.id = sc.id\r\n" + 
	        		"left join  StockContainers scf on scr.stockContainersByFromContainerId.id = scf.id\r\n" + 
	        		"left join  StockItems si on scr.stockItems.id = si.id\r\n" + 
	        		"left join Branches b on scr.branches.id =b.id \r\n" + 
	        		"WHERE   b.name ='Default' and scr.transactionType ='move' ORDER by si.name")
		    List<StockTranDetails>  getMove();
	        
	       // ................for item name in search.......................
	        @Query("select new com.service.banking.model.stockModel.ItemName( si.id,si.name) from  StockItems si order by si.name")
	        List<ItemName>  getItemName();	
	        
	        // ...........for search transactions...........
             @Query("select new com.service.banking.model.stockModel.TransactionDetails(scr.id ,scr.qty ,si.name as itemName,scr.narration,scr.amount ,scr.createdAt, scr.transactionType,m.name as smemberName) from StockTransactions scr\r\n" +  
	        		"left join Branches b on scr.branches.id =b.id \r\n" + 
	        		"left join  StockItems si on scr.stockItems.id = si.id  \r\n" + 
	        		"left join  StockMembers m on scr.stockMembers.id =m.id \r\n" + 
	        		"WHERE   b.name ='Default' and scr.transactionType = ?4 and scr.createdAt >=?1 and scr.createdAt <=?2 \r\n" + 
	        		"and si.name =?3")
	        List<TransactionDetails> getTransaction(Date fromDate,Date toDate,String name,String transType);

             
 //****************************for ledger tab *******************************************************
             
             // ........... for  item .........
             
             @Query("select new com.service.banking.model.stockModel.LedgerItemDetails(scr.id ,scr.qty ,si.name,scr.narration,scr.createdAt, scr.transactionType,scr.toBranchId) from StockTransactions scr\r\n" + 
            		 "left join Branches b on scr.branches.id =b.id \r\n" + 
 	        		"left join  StockItems si on scr.stockItems.id = si.id  \r\n" +
             		"WHERE   b.name ='Default'  and scr.createdAt >?1 and scr.createdAt <?2 \r\n" + 
             		"and si.name = ?3")
             List<LedgerItemDetails> ledgerItem(Date fromDate,Date toDate,String name);
           
          // ................ for staff name in ledger staff tab .......................
   	        @Query("select new com.service.banking.model.stockModel.StaffName( si.id,si.name) from  StockMembers si"
   	        		+ "  where si.type='staff' order by si.name")
   	        List<StaffName>  getStaffName();	
   	       
            // ........... for ledgers staff and agents and dealer  consume.........
             
             @Query("select new com.service.banking.model.stockModel.LedgerItemDetails(scr.id ,scr.qty ,si.name,scr.narration,scr.createdAt, scr.transactionType,scr.toBranchId) from StockTransactions scr\r\n" + 
            		 "left join Branches b on scr.branches.id =b.id \r\n" + 
 	        		"left join  StockItems si on scr.stockItems.id = si.id  \r\n" +
 	        		"left join  StockMembers m on scr.stockMembers.id =m.id \r\n" +
             		"WHERE   b.name ='Default'  and scr.createdAt >?1 and scr.createdAt <?2 \r\n" + 
             		"and si.name = ?3 and m.name=?4 and si.isConsumable= true")
             List<LedgerItemDetails> staffConsume(Date fromDate,Date toDate,String itemName,String name) ;
             
// ........... for ledgers staff and agents and dealer  ISSUE.........
             
             @Query("select new com.service.banking.model.stockModel.LedgerItemDetails(scr.id ,scr.qty ,si.name,scr.narration,scr.createdAt, scr.transactionType,scr.toBranchId) from StockTransactions scr\r\n" + 
            		 "left join Branches b on scr.branches.id =b.id \r\n" + 
 	        		"left join  StockItems si on scr.stockItems.id = si.id  \r\n" +
 	        		"left join  StockMembers m on scr.stockMembers.id =m.id \r\n" +
             		"WHERE   b.name ='Default'  and scr.createdAt >?1 and scr.createdAt <?2 \r\n" + 
             		"and si.name = ?3 and m.name=?4 and si.isIssueable= true")
             List<LedgerItemDetails> staffIsuue(Date fromDate,Date toDate,String itemName,String name) ;
             
      // ........... for ledgers staff  and agents and dealer FixedAssets.........
             
             @Query("select new com.service.banking.model.stockModel.LedgerItemDetails(scr.id ,scr.qty ,si.name,scr.narration,scr.createdAt, scr.transactionType,scr.toBranchId) from StockTransactions scr\r\n" + 
            		 "left join Branches b on scr.branches.id =b.id \r\n" + 
 	        		"left join  StockItems si on scr.stockItems.id = si.id  \r\n" +
 	        		"left join  StockMembers m on scr.stockMembers.id =m.id \r\n" +
             		"WHERE   b.name ='Default'  and scr.createdAt >?1 and scr.createdAt <?2 \r\n" + 
             		"and si.name = ?3 and m.name=?4 and si.isFixedassets= true")
             List<LedgerItemDetails> staffFixedAssets(Date fromDate,Date toDate,String itemName,String name) ;
             
  	        // .......for agents name in agent tab in ledger.........
  	        @Query("select new com.service.banking.model.stockModel.StaffName(sm.id,sm.name) from  StockMembers sm  \r\n" + 
  	        		"left join Branches b on sm.branches.id =b.id \r\n" + 
  	        		"where b.name ='default' and sm.type='agent'  order by sm.name")
  	      List<StaffName>  getAgentName();	
  	        
  	   // .......for dealer name in dealer tab in ledger.........
  	        @Query("select new com.service.banking.model.stockModel.StaffName(sm.id,sm.name) from  StockMembers sm  \r\n" + 
  	        		"left join Branches b on sm.branches.id =b.id \r\n" + 
  	        		"where b.name ='default' and sm.type='Dealer'  order by sm.name")
  	        
  	      List<StaffName>  getDealerName();	
  	        
  		   // .......for supplier name in supplier tab in ledger.........
  	        @Query("select new com.service.banking.model.stockModel.StaffName(sm.id,sm.name) from  StockMembers sm  \r\n" + 
  	        		"left join Branches b on sm.branches.id =b.id \r\n" + 
  	        		"where b.name ='default' and sm.type='supplier'  order by sm.name")
  	        
  	      List<StaffName>  getSupplierName();	
  	        
  	// ......................for supplier..............
  	      @Query("select new com.service.banking.model.stockModel.LedSupplierDetails(scr.id ,scr.qty ,si.name,scr.narration,scr.createdAt, scr.transactionType,scr.toBranchId) from StockTransactions scr\r\n" + 
         		 "left join Branches b on scr.branches.id =b.id \r\n" + 
	        		"left join  StockItems si on scr.stockItems.id = si.id  \r\n" +
	        		"left join  StockMembers m on scr.stockMembers.id =m.id \r\n" +
          		"WHERE   b.name ='Default'  and scr.createdAt >?1 and scr.createdAt <?2 \r\n" + 
          		"and si.id = ?3 and m.id=?4 ")
          List<LedSupplierDetails> getSupplier(Date fromDate,Date toDate,int itemId,int nameId);
                
  	        

}
