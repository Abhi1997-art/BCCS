package com.service.banking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.id.IntegralDataTypeHolder;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.service.banking.hibernateEntity.StocknewCategory;
import com.service.banking.hibernateEntity.StocknewContainer;
import com.service.banking.hibernateEntity.StocknewContainerrow;
import com.service.banking.hibernateEntity.StocknewContainertype;
import com.service.banking.hibernateEntity.StocknewItems;
import com.service.banking.hibernateEntity.StocknewMembers;
import com.service.banking.hibernateEntity.StocknewTransactions;
import com.service.banking.hibernateEntity.StocknewTransactiontemplate;
import com.service.banking.model.newStock.CatogoryDetails;
import com.service.banking.model.newStock.IStockNewItemDetails;
import com.service.banking.model.newStock.MemberDetails;
import com.service.banking.model.newStock.StockNewItemDetails;
import com.service.banking.model.newStock.TransTemplateDeatils;
import com.service.banking.model.newStock.StockContainerRow;
import com.service.banking.model.newStock.StockContainerTypeDetails;
import com.service.banking.model.newStock.StockNewCategoryDetails;
import com.service.banking.model.newStock.TransactionDeatils;
import com.service.banking.model.stockModel.StockContainerModel;
import com.service.banking.model.superAdminModel.Branch;
import com.service.banking.repository.newStock.CategoryRepo;
import com.service.banking.repository.newStock.MemberRepo;
import com.service.banking.repository.newStock.SockNewItemRepo;
import com.service.banking.repository.newStock.StockNewContainerRepo;
import com.service.banking.repository.newStock.StockNewContainerRowRepo;
import com.service.banking.repository.newStock.TransactionNewStockRepo;
import com.service.banking.repository.newStock.TransactionTemplateRepo;
import com.service.banking.repository.newStock.ContainerRowRepo;
import com.service.banking.repository.newStock.ContainerTypeRepo;
import com.service.banking.repository.stockRepo.RowItemQtyRepo;
import com.service.banking.repository.stockRepo.StocknewTransactionsRepo;
import com.service.banking.repository.superAdminRepo.BranchesRepository;
import com.service.banking.utils.DateFormater;

import java.lang.String;
import java.math.BigDecimal;

@Service
public class NewStockService {

	@Autowired
	SockNewItemRepo stockRepo;
	
	@Autowired
	CategoryRepo catRepo;
	
	@Autowired
	MemberRepo mebRepo;
	
	@Autowired
	TransactionNewStockRepo transRepo;
	
	@Autowired
	ContainerRowRepo contRow;

	@Autowired
	ContainerTypeRepo contType;

	@Autowired
	TransactionTemplateRepo transTemp;
	
	@Autowired
	StockNewContainerRepo stockNewContainerRepo;
	
	@Autowired
	BranchesRepository branchRepo;
	
	@Autowired
	StockNewContainerRowRepo stockNewContainerRowRepo;
	@Autowired
	CategoryRepo categoryRepo;
	
	@Autowired
	StocknewTransactionsRepo stocknewTransactionsRepo;

	
	//******************************************************master*************************************************************

	//  for  item ......................	
  public List<StockNewItemDetails>  getItem()
  {
	  List<StockNewItemDetails> conList = stockRepo.getAllItems();
		if (conList.size() != 0) {
			return conList;
		} else {
			return new ArrayList<StockNewItemDetails>();
		}
  }

	//  for  category ......................	
  public List<CatogoryDetails>  getCategory()
  {
	  List<CatogoryDetails> catList = catRepo.getCategory();
		if (catList.size() != 0) {
			return catList;
		} else {
			return new ArrayList<CatogoryDetails>();
		}
  }

  
//for  member ......................	
public List<MemberDetails>  getAllMember()
{
	  List<MemberDetails> catList = mebRepo.getMember();
		if (catList.size() != 0) {
			return catList;
		} else {
			return new ArrayList<MemberDetails>();
		}
}

//for  transactions ......................	
public List<TransactionDeatils>  getAllTransaction()
{
	  List<TransactionDeatils> catList = transRepo.getTransaction();
		if (catList.size() != 0) {
			return catList;
		} else {
			return new ArrayList<TransactionDeatils>();
		}
}

//for  container row ......................	
public List<StockContainerRow>  getContainerRow()
{
	  List<StockContainerRow> contList = contRow.conatinerRow();
		if (contList.size() != 0) {
			return contList;
		} else {
			return new ArrayList<StockContainerRow>();
		}
}

 //for container type ...................... 
  public List<StockContainerTypeDetails> getContainerType()
  {
  List<StockContainerTypeDetails> contTypeList = contType.getStockContainer() ;
  if (contTypeList.size() != 0) {
      return contTypeList
		  ; } 
  else
  {
	  return new ArrayList<StockContainerTypeDetails>();
  } 
  }
// for transaction template..........................
  
  public List<TransTemplateDeatils>  TransactionTamplate()
	  {
	  List<TransTemplateDeatils> tranTemp =  transTemp.gettransTemplate() ;
	  if (tranTemp.size() != 0) {
	      return tranTemp
			  ; } 
	  else
	  {
		  return new ArrayList<TransTemplateDeatils>();
	  }
	  
	  }
  
//for edit transaction   template name.............................
  
 public List<TransTemplateDeatils>  TransactionTamplatName()
	  {
	  List<TransTemplateDeatils> tranTemp =  transTemp.transTemplateName();
	  if (tranTemp.size() != 0) {
	      return tranTemp
			  ; } 
	  else
	  {
		  return new ArrayList<TransTemplateDeatils>();
	  }
	  
	  }
 
 
 	private SessionFactory hibernateFactory;

	@Autowired
	public NewStockService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.hibernateFactory = factory.unwrap(SessionFactory.class);
	}

	//Over All Stock Report..............
	@SuppressWarnings("deprecation")
	public List<StockNewItemDetails> getOverAllStockReport() {
		List<StockNewItemDetails> conList = new ArrayList<StockNewItemDetails>();

		Session s = hibernateFactory.openSession();
		String query = "SELECT si.id FROM stocknew_items si";
		@SuppressWarnings("rawtypes")
		  SQLQuery sq = s.createSQLQuery("select si.id, si.name, sc.name as catName,si.code ,sc.allowed_in_transactions ,si.description ,si.is_active ,si.is_fixed_asset, \r\n"
			+ "st1.transaction_template_type_id, sum(IF(st1.transaction_template_type_id='1' and st1.created_at <'2019-12-23',st1.qty,0)), "
			+ " sum(IF(st1.transaction_template_type_id='2' and st1.created_at <'2019-12-23',st1.qty,0)), sum(IF(st1.transaction_template_type_id='3' and st1.created_at <'2019-12-23',st1.qty,0)), "
			+ " sum(IF(st1.transaction_template_type_id='4' and st1.created_at <'2019-12-23',st1.qty,0)), sum(IF(st1.transaction_template_type_id='5' and st1.created_at <'2019-12-23',st1.qty,0)), "
			+ " sum(IF(st1.transaction_template_type_id='6' and st1.created_at <'2019-12-23',st1.qty,0)), sum(IF(st1.transaction_template_type_id='7' and st1.created_at <'2019-12-23',st1.qty,0)), "
			+ " sum(IF(st1.transaction_template_type_id='8' and st1.created_at <'2019-12-23',st1.qty,0)), sum(IF(st1.transaction_template_type_id='9' and st1.created_at <'2019-12-23',st1.qty,0)), "
			+ " sum(IF(st1.transaction_template_type_id='10' and st1.created_at <'2019-12-23',st1.qty,0)) from \r\n"
			+ " stocknew_items si inner join stocknew_category sc  on sc.id = si.category_id \r\n"
			+ "inner join stocknew_transactions st1 on si.id = st1.item_id group by si.id order by si.name");
		  List<Object[]> result = sq.list();
		  
		  for (Object[] row : result) {
			  StockNewItemDetails details = new StockNewItemDetails();
			  System.out.println("row length: "+row .length);
			  try {
				  details.setId((Integer)row[0]);
			  }
			  catch(NullPointerException e) {
					details.setId(0);
			  }
			  try {
				  details.setName(row[1].toString());
			  }
			  catch(NullPointerException e) {
					details.setName("");
			  }
			  try {
				  details.setCatName(row[2].toString());
			  }
			  catch(NullPointerException e) {
					details.setCatName("");
			  }
			  try {
				  details.setCode(row[3].toString());
			  }
			  catch(NullPointerException e) {
					details.setCode("");
			  }
			  try {
				  details.setAllowedInTransactions(row[4].toString());
			  }
			  catch(NullPointerException e) {
					details.setAllowedInTransactions("");
			  }
			  try {
				  details.setDescription(row[5].toString());
			  }
			  catch(NullPointerException e) {
					details.setDescription("");
			  }
			  try {
				  details.setIsActive((Boolean)row[6]);
			  }
			  catch(NullPointerException e) {
					details.setIsActive(false);
			  }
			  try {
				  details.setIsFixedAsset((Boolean)row[7]);
			  }
			  catch(NullPointerException e) {
					details.setIsFixedAsset(false);
			  }
			  try {
				  details.setStocknewTransactiontemplateId((Integer)row[8]);
			  }
			  catch(NullPointerException e) {
					details.setStocknewTransactiontemplateId(0);
			  }
			  System.out.println("row 9 content: "+row[9]);
			  try {
				  details.setOpening((Double)row[9]);
			  }
			  catch(NullPointerException e) {
					details.setOpening(0.0);
			  }
			  try {
				  details.setPurchase((Double)row[10]);
			  }
			  catch(NullPointerException e) {
					details.setPurchase(0.0);
			  }
			  try {
				  details.setPurchaseReturn((Double)row[11]);
			  }
			  catch(NullPointerException e) {
					details.setPurchaseReturn(0.0);
			  }
			  try {
				  details.setInternalMove((Double)row[12]);
			  }
			  catch(NullPointerException e) {
					details.setInternalMove(0.0);
			  }
			  try {
				  details.setBranchTransfer((Double)row[13]);
			  }
			  catch(NullPointerException e) {
					details.setBranchTransfer(0.0);
			  }
			  try {
				  details.setIssue((Double)row[14]);
			  }
			  catch(NullPointerException e) {
					details.setIssue(0.0);
			  }
			  try {
				  details.setConsume((Double)row[15]);
			  }
			  catch(NullPointerException e) {
					details.setConsume(0.0);
			  }
			  try {
				  details.setSubmit((Double)row[16]);
			  }
			  catch(NullPointerException e) {
					details.setSubmit(0.0);
			  }
			  try {
				  details.setUsedSubmit((Double)row[17]);
			  }
			  catch(NullPointerException e) {
					details.setUsedSubmit(0.0);
			  }
			  try {
				  details.setDeadSubmit((Double)row[18]);
			  }
			  catch(NullPointerException e) {
					details.setDeadSubmit(0.0);
			  }
			  conList.add(details);
		  }
		  System.out.print("*" + conList.size());
			s.close();
			return conList;
 }
	
	 public List<StockContainerRow> getContainerList(){
		 List<StockContainerRow> containerList = stockNewContainerRepo.getContainerList();
		 return containerList;
	 }
	 
	 public List<StockNewItemDetails> getItemsList(String name){
		 String details = name.replaceAll(" ", "");
		 List<StockNewItemDetails> itemDetails = stockRepo.getItemDetails(details);
		 return itemDetails;
	 }
	 
	 public void addStockNewItem(StockNewItemDetails details) {
			StocknewCategory stocknewCategory = catRepo.getOne(details.getCatId());
			StocknewItems si = new StocknewItems();
			si.setName(details.getName());
			si.setCode(details.getCode());
			si.setDescription(details.getDescription());
			si.setIsActive(details.getIsActive());
			si.setIsFixedAsset(details.getIsFixedAsset());
			si.setStocknewCategory(stocknewCategory);
			stockRepo.save(si);
		}

		public void updateStockNewItem(StockNewItemDetails details) {
			StocknewCategory stocknewCategory = catRepo.getOne(details.getCatId());
			StocknewItems si = stockRepo.getOne(details.getId());
			si.setName(details.getName());
			si.setCode(details.getCode());
			si.setDescription(details.getDescription());
			si.setIsActive(details.getIsActive());
			si.setIsFixedAsset(details.getIsFixedAsset());
			si.setStocknewCategory(stocknewCategory);
			stockRepo.save(si);
		}

		public String deleteStockNewItem(Integer id) {
			try {
				stockRepo.deleteById(id);
			}
			catch(Exception e)
			{
			return "Try again after sometime"+e;
			}
		return "Item Deleted Successfully";
		}

		// for "Add StockNewMember" button inside "Members" tab inside "Master" tab...............
		 public void addStockNewMember(MemberDetails details) {
			 StocknewMembers sm = new StocknewMembers();
			 sm.setName(details.getName());
			 sm.setAddress(details.getAddress());
			 sm.setPhNo(details.getPhNo());
			 sm.setType(details.getType());
			 sm.setIsActive(details.getIsActive());
			 mebRepo.save(sm);
		 }
		 
		// for "Edit StockNewMember" button inside "Members" tab inside "Master" tab...............
		public void updateStockNewMember(MemberDetails details) {
			 StocknewMembers sm = mebRepo.getOne(details.getId());
			 sm.setName(details.getName());
			 sm.setAddress(details.getAddress());
			 sm.setPhNo(details.getPhNo());
			 sm.setType(details.getType());
			 sm.setIsActive(details.getIsActive());
			 mebRepo.save(sm);
		}

		// for "Delete StockNewMember" button inside "Members" tab inside "Master" tab...............
		public String deleteStockNewMember(Integer id) {
			try {
				mebRepo.deleteById(id);
			}
			catch(Exception e)
			{
			return "Try again after sometime"+e;
			}
		return "Item Deleted Successfully";
		}
		
		// add StockNewContainer...............
		public void addStockNewContainer(StockContainerRow details) {
			StocknewContainer snc = new StocknewContainer();
			snc.setName(details.getName());
			snc.setBranches(branchRepo.getOne(details.getBranchId()));
			snc.setStocknewContainertype(contType.getOne(details.getContainerTypeId()));
			contRow.save(snc);
		}

		// edit StockNewController.............
		public void updateStockNewContainer(StockContainerRow details) {
			Integer id = details.getId();
			System.out.println("r=this is id "+id);
			StocknewContainer snc = contRow.getOne(id);
			snc.setName(details.getName());
			snc.setBranches(branchRepo.getOne(details.getBranchId()));
			snc.setStocknewContainertype(contType.getOne(details.getContainerTypeId()));
			contRow.save(snc);
		}

		// delete StockNewController...........
		public String deleteStockNewContainer(Integer id) {
			try {
				contRow.deleteById(id);
			}
			catch(Exception e)
			{
			return "Try again after sometime"+e;
			}
		return "Item Deleted Successfully";
		}


		  // for add container type...........
		  public void addContainerType(StockContainerTypeDetails details) {
			  StocknewContainertype sc = new StocknewContainertype();
			  sc.setName(details.getName());
			  contType.save(sc);
		  }
		  
		//for edit container type...........
		 public void updateContainerType(StockContainerTypeDetails details) {
			  StocknewContainertype sc = contType.getOne(details.getId());
			  sc.setName(details.getName());
			  contType.save(sc);
		 }
		 
		//for delete container type...........
		public String deleteContainerType(Integer id) {
			try {
				contType.deleteById(id);
			}
			catch(Exception e)
			{
			return "Try again after sometime"+e;
			}
		return "Item Deleted Successfully";
		}
		
		// for Add "StockNew ContainerRow" inside "StockNew_ContainerRow" tab inside "Containers&Rows" tab...........
		public void addStockNewContainerRow(StockContainerRow details) {
			StocknewContainerrow scr = new StocknewContainerrow();
			scr.setName(details.getName());
			scr.setIsDefault(details.getIsDefault());
			scr.setStocknewContainer(stockNewContainerRepo.getOne(details.getId()));
			stockNewContainerRowRepo.save(scr);
		}

		//for Update "StockNew ContainerRow" inside "StockNew_ContainerRow" tab inside "Containers&Rows" tab...........
		public void updateStockNewContainerRow(StockContainerRow details) {
			StocknewContainerrow scr =	stockNewContainerRowRepo.getOne(details.getStocknewContainerRowId());
			scr.setName(details.getName());
			scr.setIsDefault(details.getIsDefault());
			stockNewContainerRowRepo.save(scr);
		}

		// for delete "StockNew ContainerRow" inside "StockNew_ContainerRow" tab inside "Containers&Rows" tab...........
		public String deleteStockNewContainerRow(Integer id) {
			try {
				stockNewContainerRowRepo.deleteById(id);
			}
			catch(Exception e)
			{
			return "Try again after sometime"+e;
			}
		return "Item Deleted Successfully";
		}
		
		//for add transaction template tag inside transaction templates tag inside master tag..........
		  public void addTransactionTemplate(@RequestBody TransTemplateDeatils details) {
			  StocknewTransactiontemplate st = new StocknewTransactiontemplate();
			  st.setName(details.getName());
			  st.setFromBranch(details.getFromBranch());
			  st.setFromSupplier(details.getFromSupplier());
			  st.setFromStaff(details.getFromStaff());
			  st.setFromAgent(details.getFromAgent());
			  st.setFromAgent(details.getFromAgent());
			  st.setFromDealer(details.getFromDealer());
			  st.setItemCategories(details.getItemCategories());
			  st.setFromContainer(details.getFromContainer());
			  st.setFromContainerRow(details.getFromContainerRow());
			  st.setFromContainerTypes(details.getFromContainerTypes());
			  st.setToBranch(details.getToBranch());
			  st.setToSupplier(details.getToSupplier());
			  st.setToStaff(details.getToStaff());
			  st.setToAgent(details.getToAgent());
			  st.setToDealer(details.getToDealer());
			  st.setToContainerTypes(details.getToContainerTypes());
			  st.setToContainerRow(details.getToContainerRow());
			  st.setQty(details.getQty());
			  st.setNarration(details.getNarration());
			  st.setItems(details.getItems());
			  st.setRate(details.getRate());
			  st.setAlwaysFromCurrentBranch(details.getAlwaysFromCurrentBranch());
			  st.setFromDefaultContainerRow(details.getFromDefaultContainerRow());
			  st.setAlwaysToCurrentBranch(details.getAlwaysToCurrentBranch());
			  st.setToDefaultContainerRow(details.getToDefaultContainerRow());
			  st.setCheckFromQty(details.getCheckFromQty());
			  st.setSubtractQtyFrom(details.getSubtractQtyFrom());
			  st.setAddQtyTo(details.getAddQtyTo());
			  st.setAllowedToAccesslevel(details.getAllowedToAccesslevel());
			  transTemp.save(st);
		  }
		  
		//for update transaction template tag inside transaction templates tag inside master tag..........
		  public void updateTransactionTemplate(@RequestBody TransTemplateDeatils details) {
			  StocknewTransactiontemplate st = transTemp.getOne(details.getId());
			  st.setName(details.getName());
			  st.setFromBranch(details.getFromBranch());
			  st.setFromSupplier(details.getFromSupplier());
			  st.setFromStaff(details.getFromStaff());
			  st.setFromAgent(details.getFromAgent());
			  st.setFromAgent(details.getFromAgent());
			  st.setFromDealer(details.getFromDealer());
			  st.setItemCategories(details.getItemCategories());
			  st.setFromContainer(details.getFromContainer());
			  st.setFromContainerRow(details.getFromContainerRow());
			  st.setFromContainerTypes(details.getFromContainerTypes());
			  st.setToBranch(details.getToBranch());
			  st.setToSupplier(details.getToSupplier());
			  st.setToStaff(details.getToStaff());
			  st.setToAgent(details.getToAgent());
			  st.setToDealer(details.getToDealer());
			  st.setToContainerTypes(details.getToContainerTypes());
			  st.setToContainerRow(details.getToContainerRow());
			  st.setQty(details.getQty());
			  st.setNarration(details.getNarration());
			  st.setItems(details.getItems());
			  st.setRate(details.getRate());
			  st.setAlwaysFromCurrentBranch(details.getAlwaysFromCurrentBranch());
			  st.setFromDefaultContainerRow(details.getFromDefaultContainerRow());
			  st.setAlwaysToCurrentBranch(details.getAlwaysToCurrentBranch());
			  st.setToDefaultContainerRow(details.getToDefaultContainerRow());
			  st.setCheckFromQty(details.getCheckFromQty());
			  st.setSubtractQtyFrom(details.getSubtractQtyFrom());
			  st.setAddQtyTo(details.getAddQtyTo());
			  st.setAllowedToAccesslevel(details.getAllowedToAccesslevel());
			  transTemp.save(st);
		  }
		  
		//for delete transaction template tag inside transaction templates tag inside master tag..........
		  public String deleteTransactionTemplate(Integer id) {
			  try {
				  transTemp.deleteById(id);
			  }
			  catch (Exception e) {
				  return "Try again after sometime"+e;
				}
			return "Item Deleted Successfully";
		  }

		  //Ledger............................
		public List<TransactionDeatils> getAllLedgers(){
		List<TransactionDeatils> result = transRepo.getTransaction();
		if (result.size() != 0) {
			return result;
		} else {
			return new ArrayList<TransactionDeatils>();
		}
	}
		
		public List<StockContainerRow> getAllContainersName(){
			List<StockContainerRow> result = contRow.getAllContainersName();
			return result;
		}

		// for dropdown.............
		public List<StockContainerRow> getAllContainersRowName(){
			List<StockContainerRow> message = stockNewContainerRowRepo.getAllContainersRowName();
			return message;
		}

		public void addStockNewcategory(StockNewCategoryDetails details) {
			StocknewCategory snc=new StocknewCategory();
			List<String> list = new ArrayList<String>();
			list.add(details.getOpening());
			list.add(details.getPurchase());
			list.add(details.getPurchaseReturn());
			list.add(details.getInternalMove());
			list.add(details.getBranchTransfer());
			list.add(details.getIssue());
			list.add(details.getConsumes());
			list.add(details.getSubmit());
			list.add(details.getUsedSubmit());
			list.add(details.getDeadSubmit());
			list.removeAll(Arrays.asList("", null));
			String[] allowedTransaction = list.toArray(new String[0]); 
			snc.setAllowedInTransactions(Arrays.toString(allowedTransaction));
			snc.setName(details.getName());
			categoryRepo.save(snc);
			
		}

		@SuppressWarnings("deprecation")
		 public List<StockNewItemDetails> getFilterStockLocation(Integer containerId, Integer itemId){
//			 List<StockNewItemDetails> filterStockLocation = stockRepo.getFilterStockLocation();
//			 return filterStockLocation;
			 
			 List<StockNewItemDetails> conList = new ArrayList<StockNewItemDetails>();
			 Session s = hibernateFactory.openSession();
			 @SuppressWarnings("rawtypes")
			  SQLQuery sq=null;
			 if(containerId == null && itemId == null) {
				  sq = s.createSQLQuery("SELECT si.id, si.name, si.code, si.is_active, si.is_fixed_asset, SUM(st.qty), SUM(IF(st.rate is NULL ,st.qty,0)) "
				  		+ "from stocknew_items si left join stocknew_transactions st on si.id = st.item_id group by si.id order by si.name");
			 }
			 else if(containerId != null && itemId == null) {
				 sq = s.createSQLQuery("SELECT si.id, si.name, si.code, si.is_active, si.is_fixed_asset, SUM(st.qty), SUM(IF(st.rate is NULL ,st.qty,0)) "
				  		+ "from stocknew_items si left join stocknew_transactions st on si.id = st.item_id where st.to_container_id= :containerId"
				  		+ " group by si.id order by si.name");
				 sq.setParameter("containerId", containerId);
			 }
			 else if(containerId == null && itemId != null) {
				 sq = s.createSQLQuery("SELECT si.id, si.name, si.code, si.is_active, si.is_fixed_asset, SUM(st.qty), SUM(IF(st.rate is NULL ,st.qty,0)) "
				  		+ "from stocknew_items si left join stocknew_transactions st on si.id = st.item_id where si.id= :itemId"
				  		+ " group by si.id order by si.name");
				 sq.setParameter("itemId", itemId);
			 }
			 else if(containerId != null && itemId != null) {
				 
				  sq = s.createSQLQuery("SELECT si.id, si.name, si.code, si.is_active, si.is_fixed_asset, SUM(st.qty), SUM(IF(st.rate is NULL ,st.qty,0)) "
				  		+ "from stocknew_items si left join stocknew_transactions st on si.id = st.item_id  where si.id= :itemId and st.to_container_id= :containerId"
				  		+ " group by si.id order by si.name");
				  sq.setParameter("itemId", itemId);
				  sq.setParameter("containerId", containerId);
			 }
			  
			  List<Object[]> result = sq.list();
			  for (Object[] row : result) {
				  StockNewItemDetails details = new StockNewItemDetails();
				  System.out.println("row length: "+row .length);
				  try {
					  details.setId((Integer)row[0]);
				  }
				  catch(NullPointerException e) {
					// TODO: handle exception
						details.setId(0);
				  }
				  try {
					  details.setName(row[1].toString());
				  }
				  catch(NullPointerException e) {
					// TODO: handle exception
						details.setName("");
				  }
				  try {
					  details.setCode(row[2].toString());
				  }
				  catch(NullPointerException e) {
					// TODO: handle exception
						details.setCode("");
				  }
				  try {
					  details.setIsActive((Boolean)row[3]);
				  }
				  catch(NullPointerException e) {
					// TODO: handle exception
						details.setIsActive(false);
				  }
				  try {
					  details.setIsFixedAsset((Boolean)row[4]);
				  }
				  catch(NullPointerException e) {
					// TODO: handle exception
						details.setIsFixedAsset(false);
				  }
				  try {
					  details.setTotalIn((Double)row[5]);
				  }
				  catch(NullPointerException e) {
					// TODO: handle exception
						details.setTotalIn(0.0);
				  }
				  try {
					  details.setTotalOut((Double)row[6]);
				  }
				  catch(NullPointerException e) {
					// TODO: handle exception
						details.setTotalOut(0.0);
				  }
				  conList.add(details);
			  }
			  System.out.print("***" + conList.size());
				s.close();
				return conList;
		 }

		public List<TransactionDeatils> getLedgerFilterByData(Integer branchId, Integer stocknew_containerId, Integer stocknew_containerrowId,
				 Integer stocknew_membersId, Integer stocknew_itemsId, String fromDate, String toDate){


			List<TransactionDeatils> conList = new ArrayList<TransactionDeatils>();
			List<Object[]> list = transRepo.getLedgerFilterByData(branchId, stocknew_containerId, stocknew_containerrowId,
					 stocknew_membersId, stocknew_itemsId, fromDate, toDate);
			for(Object[] ob: list) {
				TransactionDeatils legal = new TransactionDeatils();
				System.out.println("****** "+ ob.length);
				
				legal.setId(Optional.ofNullable(ob[0]).isPresent() ? (Integer)ob[0] : 0);
				legal.setTransTemplateName(Optional.ofNullable(ob[1]).isPresent() ? ob[1].toString() : "");
				legal.setFromBrnchName(Optional.ofNullable(ob[2]).isPresent() ? ob[2].toString() : "");
				legal.setFromMemberName(Optional.ofNullable(ob[3]).isPresent() ? ob[3].toString() : "");
				legal.setFromContName(Optional.ofNullable(ob[4]).isPresent() ? ob[4].toString() : "");
				legal.setFromContRowName(Optional.ofNullable(ob[5]).isPresent() ? ob[5].toString() : "");
				legal.setToBrnchName(Optional.ofNullable(ob[6]).isPresent() ? ob[6].toString() : "");
				legal.setToMemberName(Optional.ofNullable(ob[7]).isPresent() ? ob[7].toString() : "");
				legal.setToContName(Optional.ofNullable(ob[8]).isPresent() ? ob[8].toString() : "");
				legal.setToContRowName(Optional.ofNullable(ob[9]).isPresent() ? ob[9].toString() : "");
				legal.setItemName(Optional.ofNullable(ob[10]).isPresent() ? ob[10].toString() : "");
				legal.setQty(Optional.ofNullable(ob[11]).isPresent() ? ob[11].toString() : "");
				legal.setRate(Optional.ofNullable(ob[12]).isPresent() ? (BigDecimal)ob[12] : null);
				legal.setNarration(Optional.ofNullable(ob[13]).isPresent() ? ob[13].toString() : "");
				legal.setCreatedAt(Optional.ofNullable(ob[14]).isPresent() ? ob[14].toString() : "");
				conList.add(legal);
			}
			System.out.print("***" + conList.size());
			return conList;

		}

		// filtered overall stock report..............
		 public List<IStockNewItemDetails> getFilteredOverAllStockReport(Integer branchId, Integer stocknew_containerId, Integer stocknew_containerrowId,
				 Integer stocknew_membersId, Integer stocknew_itemsId, Integer categoryId){
			 List<IStockNewItemDetails> list = stockRepo.getFilteredOverAllStockReports(branchId, stocknew_containerId, stocknew_containerrowId,
					 stocknew_membersId, stocknew_itemsId, categoryId);
			 return list;
		 }

		public void stockTransaction(StocknewTransactions stocknewTransactions) {
			StocknewTransactions sTransactions = new StocknewTransactions();
			sTransactions.setStocknewTransactiontemplate(stocknewTransactions.getStocknewTransactiontemplate());
			sTransactions.setBranchesByFromBranchId(stocknewTransactions.getBranchesByFromBranchId());
			sTransactions.setStocknewMembersByFromMemberId(stocknewTransactions.getStocknewMembersByFromMemberId());
			sTransactions.setStocknewContainerByFromContainerId(stocknewTransactions.getStocknewContainerByFromContainerId());
			sTransactions.setStocknewContainerrowByFromContainerRowId(stocknewTransactions.getStocknewContainerrowByFromContainerRowId());
			sTransactions.setBranchesByToBranchId(stocknewTransactions.getBranchesByToBranchId());
			sTransactions.setStocknewMembersByToMemberId(stocknewTransactions.getStocknewMembersByToMemberId());
			sTransactions.setStocknewContainerByToContainerId(stocknewTransactions.getStocknewContainerByToContainerId());
			sTransactions.setStocknewContainerrowByToContainerRowId(stocknewTransactions.getStocknewContainerrowByToContainerRowId());
			sTransactions.setStocknewItems(stocknewTransactions.getStocknewItems());
			sTransactions.setQty(stocknewTransactions.getQty());
			sTransactions.setRate(stocknewTransactions.getRate());
			sTransactions.setNarration(stocknewTransactions.getNarration());
			Date date = new Date();
			sTransactions.setCreatedAt(DateFormater.getformatDate(date));
			System.out.println(sTransactions);
		}

}
