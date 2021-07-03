package com.service.banking.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.banking.hibernateEntity.Supplier;
import com.service.banking.hibernateEntity.TransactionTypes;
import com.service.banking.model.GstModel.AccountDetail;
import com.service.banking.model.GstModel.AccountStatementDetail;
import com.service.banking.model.GstModel.PurchaseAccountDetails;
import com.service.banking.model.GstModel.SupplierDetails;
import com.service.banking.model.GstModel.TransactionType;
import com.service.banking.model.GstModel.UpdateSupplierDetails;
import com.service.banking.model.dashboardModel.DailyDueResultModel;
import com.service.banking.model.printingModel.FDAccountDetails;
import com.service.banking.repository.AccountsRepo.AccountsRepo;
import com.service.banking.repository.gstRepository.MemorandomAccountStatement;
import com.service.banking.repository.gstRepository.SupplierRepo;
import com.service.banking.repository.gstRepository.TransactionTypeRepo;
import com.service.banking.repository.hodAuthorityRepo.MemoRandomRepo;

@Service
public class GstService {

	@Autowired
	SupplierRepo supplierRepo;
	
	@Autowired
	AccountsRepo  accountRepo;
	
	@Autowired
	MemoRandomRepo transRepo;
	
	
	@Autowired
	MemorandomAccountStatement accountStatementRepo;


	// Get supplier .....................................................
	public List<SupplierDetails> getSuplier() {
		List<SupplierDetails> dueList = supplierRepo.allSupplier();
		if (dueList.size() != 0) {
			return dueList;
		} else {
			return new ArrayList<SupplierDetails>();
		}
	}
    
	// Update  supplier .....................................................
	public Supplier  updateSupllier(UpdateSupplierDetails supplierDetail) {
		Supplier supplier = supplierRepo.getOne(supplierDetail.getId());
		try {
			supplier.setName(supplierDetail.getName());
			supplier.setGstin(supplierDetail.getGstin());
			supplier.setOrganization(supplierDetail.getOrganization());
			supplier.setAddress(supplierDetail.getAddress());
			supplier.setEmailIds(supplierDetail.getEmailIds());
			supplier.setPhoneNos(supplierDetail.getPhoneNos());
			supplier.setIsActive((byte) (supplierDetail.getIsActive() ? 1 : 0 ));
			supplierRepo.save(supplier);
			}
			catch(Exception e)
			{
			return supplier;
			}
			return supplier;
		}
	
		  
	// Add  Supplier .....................................................
	public Supplier  addSupllier(UpdateSupplierDetails supplierDetail) {
		Supplier supplier =new Supplier();
		try {
			supplier.setName(supplierDetail.getName());
			supplier.setOrganization(supplierDetail.getOrganization());
			supplier.setGstin(supplierDetail.getGstin());
			supplier.setEmailIds(supplierDetail.getEmailIds());
			supplier.setPhoneNos(supplierDetail.getPhoneNos());
			supplier.setAddress(supplierDetail.getAddress());
			supplier.setIsActive((byte)(supplierDetail.getIsActive() ? 1 : 0));
			supplier.setCreatedAt(supplierDetail.getCreatedAt());
			supplier=supplierRepo.save(supplier);
			}
			catch(Exception e)
			{
			return supplier;
			}
		return supplier;
	}
		

	//Delete Supplier..
	public String deleteSupplier(Integer id) {
		try {
			supplierRepo.deleteById(id);
			}
			catch(Exception e)
			{
			return "Try again after sometime"+e;
			}
		return "Item Deleted Successfully";
	}
			
	// get transaction type .....................................................
	public List<TransactionType> getTransactionType() {
		List<TransactionType> trnsList = transRepo.transactionType();
		if (trnsList.size() != 0) {
			return trnsList;
		} else {
			return new ArrayList<TransactionType>();
		}
	}

	// purchase account .....................................................
		public List<PurchaseAccountDetails> getpurchaseAccount() {
			List<PurchaseAccountDetails> purAccnt = accountRepo.purchaseAccount();
			if (purAccnt.size() != 0) {
				return purAccnt;
			} else {
				return new ArrayList<PurchaseAccountDetails>();
			}
		}


		// (amount from account) and (bank account) for gst deposit in gst panel.....................................................
			public List<PurchaseAccountDetails> getGSTAccount() {
				List<PurchaseAccountDetails> gstAccnt = accountRepo.gstAccount();
				if (gstAccnt.size() != 0) {
					return gstAccnt;
				} else {
					return new ArrayList<PurchaseAccountDetails>();
				}
			}
	
			// account for account statement in gst panel.....................................................
				 		public List<PurchaseAccountDetails> accountStatement() {
							List<PurchaseAccountDetails> statementAccnt = accountRepo.accountStatement();
							if (statementAccnt.size() != 0) {
								return statementAccnt;
							} else {
								return new ArrayList<PurchaseAccountDetails>();
							}
						}
				

						//  DR account for GENERAL GST in gst panel.....................................................
									public List<PurchaseAccountDetails> DRaccount() {
										List<PurchaseAccountDetails> DRAccnt = accountRepo.DRaccount();
										if (DRAccnt.size() != 0) {
											return DRAccnt;
										} else {
											return new ArrayList<PurchaseAccountDetails>();
										}
									}
                       
								//  CR account for GENERAL GST in gst panel.....................................................
									public List<PurchaseAccountDetails> CRaccount() {
										List<PurchaseAccountDetails> CRAccnt = accountRepo.CRaccount();
										if (CRAccnt.size() != 0) {
											return CRAccnt;
										} else {
											return new ArrayList<PurchaseAccountDetails>();
										}
									}
									
								//  for account statement.....................................................
									public List<AccountStatementDetail> getAccountStatement(Integer accountId,Date fromDate,Date toDate) {
										List<AccountStatementDetail> accountStatement = accountStatementRepo.accountStatement(accountId, fromDate, toDate);
										if (accountStatement.size() != 0) {
											return accountStatement;
										} else {
											return new ArrayList<AccountStatementDetail>();
										}
									}
					
									// get all  accounts for account statement..................
									public List<AccountDetail>  getAccounts(String accountName)
									{
										List<AccountDetail> accounts=accountRepo.account(accountName);
										if (accounts.size()!=0) {
											return accounts;
										}
										else {
											return  new  ArrayList<AccountDetail>();
										}
										
				     						}
}
