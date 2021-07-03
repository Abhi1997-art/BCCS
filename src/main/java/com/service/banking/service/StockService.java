package com.service.banking.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.banking.hibernateEntity.StockContainers;
import com.service.banking.model.dashboardModel.DailyDueResultModel;
import com.service.banking.model.stockModel.ItemName;
import com.service.banking.model.stockModel.LedgerItemDetails;
import com.service.banking.model.stockModel.RowItemQtyModel;
import com.service.banking.model.stockModel.StaffName;
import com.service.banking.model.stockModel.StockCatModel;
import com.service.banking.model.stockModel.StockContainerModel;
import com.service.banking.model.stockModel.StockItemModel;
import com.service.banking.model.stockModel.StockMemberModel;
import com.service.banking.model.stockModel.StockRowModel;
import com.service.banking.model.stockModel.StockTranDetails;
import com.service.banking.model.stockModel.LedSupplierDetails;
import com.service.banking.model.stockModel.TransactionDetails;
import com.service.banking.repository.stockRepo.RowItemQtyRepo;
import com.service.banking.repository.stockRepo.StockCategoryRepo;
import com.service.banking.repository.stockRepo.StockContainerRepo;
import com.service.banking.repository.stockRepo.StockItemRepo;
import com.service.banking.repository.stockRepo.StockMemberRepo;
import com.service.banking.repository.stockRepo.StockRowRepo;
import com.service.banking.repository.stockRepo.StockTransactionRepo;
import com.service.banking.utils.DateFormater;

@Service
public class StockService {

	 DateFormater dateformater= new DateFormater();
	 
	@Autowired
	StockContainerRepo stockConRepo;
	
	@Autowired
	StockRowRepo SRowRepo;
	
	@Autowired
	StockCategoryRepo stockCatgry;

	@Autowired
	StockItemRepo stockitem;
	
	@Autowired
	StockMemberRepo stockMember;
	
	@Autowired
	StockTransactionRepo stockTranRepo;
	
	@Autowired
	RowItemQtyRepo ItemQtyRepo;
	
	//******************************************************master*************************************************************

	//  for container......................	
  public List<StockContainerModel>  getAllContainer()
  {
	  List<StockContainerModel> conList = stockConRepo.getStockContainer();
		if (conList.size() != 0) {
			return conList;
		} else {
			return new ArrayList<StockContainerModel>();
		}
  }
	//  for row......................	
  public List<StockRowModel>  getAllRow()
  {
	  List<StockRowModel> conList = SRowRepo.getStockRow();
		if (conList.size() != 0) {
			return conList;
		} else {
			return new ArrayList<StockRowModel>();
		}
  }
  
//for category......................	
public List<StockCatModel>  getAllCategory()
{
	  List<StockCatModel> conList = stockCatgry.getStockCat();
		if (conList.size() != 0) {
			return conList;
		} else {
			return new ArrayList<StockCatModel>();
		}
}
  
//for item......................	
public List<StockItemModel>  getAllItem()
{
	  List<StockItemModel> conList = stockitem.getStockItem();
		if (conList.size() != 0) {
			return conList;
		} else {
			return new ArrayList<StockItemModel>();
		}
}

//for members......................	
public List<StockMemberModel>  getAllMember()
{
	  List<StockMemberModel> conList = stockMember.getStockMember();
		if (conList.size() != 0) {
			return conList;
		} else {
			return new ArrayList<StockMemberModel>();
		}
}

//for row item qty......................	
public List<RowItemQtyModel>  getRowItemQTY()
{
	  List<RowItemQtyModel> conList = ItemQtyRepo.getRowItemQty();
		if (conList.size() != 0) {
			return conList;
		} else {
			return new ArrayList<RowItemQtyModel>();
		}
}

  // **************************************transaction.............................
  
  //..........for UsedSubmit.......
  
  public List<StockTranDetails>  getTransUsedSubmit()
  {
	  List<StockTranDetails> tranList = stockTranRepo.getUsedSubmit();
		if (tranList.size() != 0) {
			return tranList;
		} else {
			return new ArrayList<StockTranDetails>();
		}
  }
  
  //..........for DeadSubmit.......
  
  public List<StockTranDetails>  getTransDeadSubmit()
  {
	  List<StockTranDetails> tranList = stockTranRepo.getDeadSubmit();
		if (tranList.size() != 0) {
			return tranList;
		} else {
			return new ArrayList<StockTranDetails>();
		}
  }
  
  //..........for Submit.......
  
  public List<StockTranDetails> getTransSubmit(){
	  
	  List<StockTranDetails> tranList = stockTranRepo.getSubmit();
		if (tranList.size() != 0) {
			return tranList;
		} else {
			return new ArrayList<StockTranDetails>();
		}
	  
  }
  
  //..........for consume.......
  
 public List<StockTranDetails> getTransConsume(){
	  
	  List<StockTranDetails> tranList = stockTranRepo.getComsume();
		if (tranList.size() != 0) {
			return tranList;
		} else {
			return new ArrayList<StockTranDetails>();
		}
	  
  }
 
 
 //..........for issue.......
 public List<StockTranDetails> getTransIsuue(){
	  
	  List<StockTranDetails> tranList = stockTranRepo.getIsuue();
		if (tranList.size() != 0) {
			return tranList;
		} else {
			return new ArrayList<StockTranDetails>();
		}
	  
 }
  //..........for transfer.......
 public List<StockTranDetails> getTransTransfer(){
	  
	  List<StockTranDetails> tranList = stockTranRepo.getTransfer();
		if (tranList.size() != 0) {
			return tranList;
		} else {
			return new ArrayList<StockTranDetails>();
		}
	  
 }
 //..........for opening.......
 public List<StockTranDetails> getTransOpening(){
	  
	  List<StockTranDetails> tranList = stockTranRepo.getOpening();
		if (tranList.size() != 0) {
			return tranList;
		} else {
			return new ArrayList<StockTranDetails>();
		}
	  
}
 //..........for purchase.......
 public List<StockTranDetails> getTransPurchase(){
	  
	  List<StockTranDetails> tranList = stockTranRepo.getPurchase();
		if (tranList.size() != 0) {
			return tranList;
		} else {
			return new ArrayList<StockTranDetails>();
		}
	  
}
 //..........for purchase return.......
 public List<StockTranDetails> getPurchaseReturn(){
	  
	  List<StockTranDetails> tranList = stockTranRepo.getPurchasereturn();
		if (tranList.size() != 0) {
			return tranList;
		} else {
			return new ArrayList<StockTranDetails>();
		}
	  
}
 //..........for move.......
 public List<StockTranDetails> getTransMove(){
	  
	  List<StockTranDetails> tranList = stockTranRepo.getMove();
		if (tranList.size() != 0) {
			return tranList;
		} else {
			return new ArrayList<StockTranDetails>();
		}
	  
}
 //..........for item name .......
 public List<ItemName> itemName(){
	  
	  List<ItemName> nameList = stockTranRepo.getItemName();
		if (nameList.size() != 0) {
			return nameList;
		} else {
			return new ArrayList<ItemName>();
		}
	  
}
 
 //..........for  transaction search.................
 
 public List<TransactionDetails> transaction(String fromDate, String toDate,String name,String transType){
	 Date fromDATE= dateformater.getFromatDate(fromDate);
	 Date toDATE= dateformater.getFromatDate(toDate);
	  List<TransactionDetails> tranList = stockTranRepo.getTransaction(fromDATE,toDATE,name,transType);
			if (tranList.size() != 0) {
				return tranList;
			} else {
				return new ArrayList<TransactionDetails>();
			}
		
 }
 
 //******************for ledger******************
 
 // .............. for item..............
 public List<LedgerItemDetails> getledgerItem(String fromDate, String toDate,String name){
	 Date fromDATE= dateformater.getFromatDate(fromDate);
	 Date toDATE= dateformater.getFromatDate(toDate);
	  List<LedgerItemDetails> tranList = stockTranRepo.ledgerItem(fromDATE,toDATE,name);
			if (tranList.size() != 0) {
				return tranList;
			} else {
				return new ArrayList<LedgerItemDetails>();
			}
		
 }
 
//.......... concume for staff  and agents and dealer  tab.................
public List<LedgerItemDetails> getStaffConsume(String fromDate, String toDate,String itemName,String name){
	 Date fromDATE= dateformater.getFromatDate(fromDate);
	 Date toDATE= dateformater.getFromatDate(toDate);
	  List<LedgerItemDetails> staffList = stockTranRepo.staffConsume(fromDATE,toDATE,itemName,name);
			if (staffList.size() != 0) {
				return staffList;
			} else {
				return new ArrayList<LedgerItemDetails>();
			}
		
}


//.......... issue for staff  and agents and dealer  tab.................
public List<LedgerItemDetails> getStaffIsuue(String fromDate, String toDate,String itemName,String name){
	 Date fromDATE= dateformater.getFromatDate(fromDate);
	 Date toDATE= dateformater.getFromatDate(toDate);
	  List<LedgerItemDetails> staffList = stockTranRepo.staffIsuue(fromDATE,toDATE,itemName,name);
			if (staffList.size() != 0) {
				return staffList;
			} else {
				return new ArrayList<LedgerItemDetails>();
			}
		
}

//.......... fixedAssets for staff  and agents and dealer tab.................
public List<LedgerItemDetails> getStaffFixedAssets(String fromDate, String toDate,String itemName,String name){
	 Date fromDATE= dateformater.getFromatDate(fromDate);
	 Date toDATE= dateformater.getFromatDate(toDate);
	  List<LedgerItemDetails> staffList = stockTranRepo.staffFixedAssets(fromDATE,toDATE,itemName,name);
			if (staffList.size() != 0) {
				return staffList;
			} else {
				return new ArrayList<LedgerItemDetails>();
			}
		
}

//..........staff name for staff tab .......
public List<StaffName> staffName(){
	  
	  List<StaffName> nameList = stockTranRepo.getStaffName();
		if (nameList.size() != 0) {
			return nameList;
		} else {
			return new ArrayList<StaffName>();
		}
	  
}

//..........agents name for  agent tab......
public List<StaffName> agentsName(){
	  
	  List<StaffName> nameList = stockTranRepo.getAgentName();
		if (nameList.size() != 0) {
			return nameList;
		} else {
			return new ArrayList<StaffName>();
		}
	  
}

//..........dealer name for  dealer tab......
public List<StaffName> dealerName(){
	  
	  List<StaffName> nameList = stockTranRepo.getDealerName();
		if (nameList.size() != 0) {
			return nameList;
		} else {
			return new ArrayList<StaffName>();
		}
	  
}

//..........supplier name for  supplier tab......
public List<StaffName> supplierName(){
	  
	  List<StaffName> nameList = stockTranRepo.getSupplierName();
		if (nameList.size() != 0) {
			return nameList;
		} else {
			return new ArrayList<StaffName>();
		}
	  
}

//..........for suppleir .................
public List<LedSupplierDetails> getSupplier(String fromDate, String toDate,int itemId,int nameId){
	 Date fromDATE= dateformater.getFromatDate(fromDate);
	 Date toDATE= dateformater.getFromatDate(toDate);
	  List<LedSupplierDetails> suppList = stockTranRepo.getSupplier(fromDATE,toDATE,itemId,nameId);
			if (suppList.size() != 0) {
				return suppList;
			} else {
				return new ArrayList<LedSupplierDetails>();
			}
		
}

}
