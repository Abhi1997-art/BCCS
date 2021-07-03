package com.service.banking.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.banking.hibernateEntity.GstPercentage;
import com.service.banking.hibernateEntity.Supplier;
import com.service.banking.hibernateEntity.TransactionTypes;
import com.service.banking.model.GstModel.AccountDetail;
import com.service.banking.model.GstModel.AccountStatementDetail;
import com.service.banking.model.GstModel.PurchaseAccountDetails;
import com.service.banking.model.GstModel.SupplierDetails;
import com.service.banking.model.GstModel.TransactionType;
import com.service.banking.model.GstModel.UpdateSupplierDetails;
import com.service.banking.model.accountsModel.AccountStatementReq;
import com.service.banking.model.dashboardModel.DailyDueResultModel;
import com.service.banking.model.printingModel.FDAccountDetails;
import com.service.banking.model.stockModel.ItemRequestDetails;
import com.service.banking.model.superAdminModel.BranchesDetails;
import com.service.banking.model.transaction.NewPageReq;
import com.service.banking.repository.gstRepository.GstPercentageRepo;
import com.service.banking.service.DashBoardService;
import com.service.banking.service.GstService;
import com.service.banking.utils.Constant;
import com.service.banking.utils.DateFormater;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service
@RequestMapping("/service/gst")
public class GstController {

	@Autowired
	GstService gstService;

	
	@Autowired
	GstPercentageRepo gstPercntage;
	
	
	// To get proper date format.........
	DateFormater dateformater = new DateFormater();
		
	// Get all supplier Management..
	@GetMapping("/supplier_managment")
	List<SupplierDetails> getAllService() {
		List<SupplierDetails> supplier = gstService.getSuplier(); // null check already in service....
		return supplier;
	}
	
	// Update the supplier Management..
	@PutMapping("/update_supplier_managment")
	Supplier updateSupplier(@RequestBody UpdateSupplierDetails supplierDetails) {
		Supplier  supplier = gstService.updateSupllier(supplierDetails); // null check already in service....
		return supplier;
	}
		
	// Add the supplier Management..
	@PostMapping("/add_supplier_managment")
	Supplier addSupplier(@RequestBody UpdateSupplierDetails supplierDetail) {
			Supplier  supplier = gstService.addSupllier(supplierDetail); // null check already in service....
			return supplier;
		}
				
	//Delete supplier..
	@DeleteMapping("/delete_supplier/{id}")
	public String deleteBranches(@PathVariable("id") Integer Id) {
		String message =gstService.deleteSupplier(Id);
		return message;
	}
	
	// custom api for Table column names......................
		@GetMapping("/constant/tax")
		List<GstPercentage> tax() {
			
			List<GstPercentage> gstList=gstPercntage.findAll();
			if (gstList.size()!=0) {
				return gstList;
				
			}
			else {
				return new ArrayList<GstPercentage>();
			}
			
		}
		// get all supplier
		// managemnent.............................................................................
		@GetMapping("/transaction_type")
		ResponseEntity<Map<String, String>> transType() {
			Map<String, String> transType = new HashMap<String, String>();
			transType.put("nachReg",Constant.nach_registration_fees_charge_received);
			transType.put("nachTrans",Constant.nach_transaction_file_canceling_charge_received);
			transType.put("society",Constant.society_notice_sent);
			transType.put("visit",Constant.visit_charge);
			transType.put("legalNotice",Constant.legal_notice_sent);
			transType.put("gowdown",Constant.godowncharge_debited);
			transType.put("legalNotice",Constant.legal_notice_sent_for_bike_auction);
			transType.put("finalRecovery",Constant.final_recovery_notice_sent);
			transType.put("cheque",Constant.cheque_returned);
			transType.put("noticeSend",Constant.notice_sent_after_cheque_returned);
			transType.put("legelExpendes",Constant.legal_expenses_received);
			transType.put("nocHandling",Constant.noc_handling_charge_received);
			transType.put("insurrence",Constant.insurance_processing_fees);
			transType.put("fileCancel",Constant.file_cancel_charge);
			transType.put("staffStationary",Constant.staff_stationary_charge_received);
			return new ResponseEntity<Map<String, String>>(transType, new HttpHeaders(), HttpStatus.OK);
		}
	
 // purchase account in popup in purchase panel .............................
		@GetMapping("/purchase_account")
		List<PurchaseAccountDetails> purchaseAccount() {
			List<PurchaseAccountDetails> purAccnt = gstService.getpurchaseAccount(); // null check already in service....
			return purAccnt;
		}
		
		// account for gst deposite gst panel ....................................
				@GetMapping("/gst_deposit/account")
				List<PurchaseAccountDetails> accountDetails() {
					List<PurchaseAccountDetails> accountDetails = gstService.getGSTAccount(); // null check already in service....
					return accountDetails;
				}
				// account for ACCOUNT STATEMENT gst panel .................
				@GetMapping("/account_statement/account")
				List<PurchaseAccountDetails> accountStatement() {
					List<PurchaseAccountDetails> accountDetails = gstService.accountStatement(); // null check already in service....
					return accountDetails;
				}
				// account for gENERAL GST gst panel .................
				@GetMapping("/general_gst/DR_account")
				List<PurchaseAccountDetails> DRAccount() {
					List<PurchaseAccountDetails> accountDetails = gstService.DRaccount(); // null check already in service....
					return accountDetails;
				}
				// account for gENERAL GST gst panel ...................
				@GetMapping("/general_gst/CR_account")
				List<PurchaseAccountDetails> CRAccount() {
					List<PurchaseAccountDetails> accountDetails = gstService.CRaccount(); // null check already in service....
					return accountDetails;
				}
				
		// new api for account statement............................
				
				// account for gENERAL GST gst panel .................
				@PostMapping("/account_statement")
				List<AccountStatementDetail> getAccountStatement(@RequestBody AccountStatementReq acntReq) {
					Date fromDate= dateformater.getFromatDate(acntReq.getFromDate());
					Date toDate= dateformater.getFromatDate(acntReq.getToDate());
					List<AccountStatementDetail> accountDetails = gstService.getAccountStatement(acntReq.getId(),fromDate,toDate); // null check already in service....
					return accountDetails;
				}
					
				// get all accountsfor account statement...................................
				@GetMapping("/all_account_detail")
				List<AccountDetail> getFdAccounts(@RequestParam("accountName") String accountName) {
					List<AccountDetail> fdAccounts = gstService.getAccounts(accountName); // null check already in service....
					System.out.println("**********"+fdAccounts.size());
				    return fdAccounts;	
				}
				
}
