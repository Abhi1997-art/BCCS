package com.service.banking.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.service.banking.hibernateEntity.AgentTds;
import com.service.banking.hibernateEntity.Bank;
import com.service.banking.hibernateEntity.BankBranches;
import com.service.banking.hibernateEntity.Documents;
import com.service.banking.hibernateEntity.MemorandumTransactions;
import com.service.banking.hibernateEntity.Teams;
import com.service.banking.hibernateEntity.Telecaller;
import com.service.banking.hibernateEntity.Transactions;
import com.service.banking.model.hodAuthorityModel.AccountAndMemberDetails;
import com.service.banking.model.hodAuthorityModel.AgentTdsDetail;
import com.service.banking.model.hodAuthorityModel.AssociationDetails;
import com.service.banking.model.hodAuthorityModel.BankBranchesDetails;
import com.service.banking.model.hodAuthorityModel.BranchDetails;
import com.service.banking.model.hodAuthorityModel.FilterMoAgentUpdateDetails;
import com.service.banking.model.hodAuthorityModel.InvoiceDetails;
import com.service.banking.model.hodAuthorityModel.LockUnlockAcntDetails;
import com.service.banking.model.hodAuthorityModel.LogCheckDetails;
import com.service.banking.model.hodAuthorityModel.LogCheckModel;
import com.service.banking.model.hodAuthorityModel.LogCheckReq;
import com.service.banking.model.hodAuthorityModel.MemoRandomTransactionRowDetails;
import com.service.banking.model.hodAuthorityModel.MemorandomTransactionDetails;
import com.service.banking.model.hodAuthorityModel.MoRoDetails;
import com.service.banking.model.hodAuthorityModel.ODLimitsDetails;
import com.service.banking.model.hodAuthorityModel.PremiumDetails;
import com.service.banking.model.hodAuthorityModel.TeleCallerHistoryDetails;
import com.service.banking.model.hodAuthorityModel.TransactionRowDetails;
import com.service.banking.model.hodAuthorityModel.UnlockAccountsDetails;
import com.service.banking.model.hodAuthorityModel.changeMoDetail;
import com.service.banking.model.hodAuthorityModel.iDeleteVoucherDetails;
import com.service.banking.model.superAdminModel.MeberDetail;
import com.service.banking.model.superAdminModel.ShareCertificateDetail;
import com.service.banking.service.HodAuthorityService;

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("/service/hod_authority")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service
public class HodAuthorityController {
	@Autowired
	HodAuthorityService hodAuthorityService;

	// get branches of mo agents update----------------------
	@GetMapping("/branchs")
	public List<BranchDetails> getAllBranches() {
		List<BranchDetails> branches = hodAuthorityService.getAllBranches();
		return branches;
	}

	// get mo for mo agents update................
	@GetMapping("/all_mo")
	public List<MoRoDetails> getAllMo() {
		List<MoRoDetails> allMo = hodAuthorityService.getAllMo();
		return allMo;
	}

	// For mo association.......................
	@GetMapping("/mo_association")
	public List<AssociationDetails> getMoAssociations() {
		List<AssociationDetails> moassociationList = hodAuthorityService.getMoAssociation();
		return moassociationList;
	}

	// get all ro associations.............................
	@GetMapping("/ro_association/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> getRoAssociation(@PathVariable("setFirstResult") Integer setFirstResult,
			@PathVariable("setMaxResults") Integer setMaxResults) {
		Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
		Map<String, Object> roAssociations = hodAuthorityService.getRoAssociation(setPageNumber, setMaxResults);
		return roAssociations;
	}

	// get all telle-caller associations.............................
		@GetMapping("/tellecaller_history/{setFirstResult}/{setMaxResults}")
		public Map<String, Object> getTellecallerHistory(@PathVariable("setFirstResult") Integer setFirstResult,@PathVariable("setMaxResults") Integer setMaxResults) {
			Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
			Map<String, Object> tellecallerHistory = hodAuthorityService.getAllTelecallerHistiory(setPageNumber, setMaxResults);
			return tellecallerHistory;
		}

	// get all premiums ............................
	@GetMapping("/premiums/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> getAllPremiums(@PathVariable("setFirstResult") Integer setFirstResult,@PathVariable("setMaxResults") Integer setMaxResults) {
		Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
		Map<String, Object> premiums = hodAuthorityService.getAllPremiums(setPageNumber, setMaxResults);
		return premiums;
	}


	// Get premiums....
	@GetMapping("/premiums/{accountNumber}")
	public List<PremiumDetails> getPremiums(@PathVariable("accountNumber") String accountNumber) {
		List<PremiumDetails> premiums = hodAuthorityService.getPremiums(accountNumber);
		return premiums;
	}

	// Get all log check............................
	@GetMapping("/logcheck")
	public List<LogCheckDetails> getAllLogCheck(@RequestBody LogCheckReq logCheckReq) {
		List<LogCheckDetails> logcheck = hodAuthorityService.getallXlog(logCheckReq);
		return logcheck;
	}

	// get model for getting log check details
	// dropdown...................................
	@GetMapping("/logcheck_model")
	List<LogCheckModel> getModelName() {
		List<LogCheckModel> allModel = hodAuthorityService.getLogCheckModel(); // null check already in service....
		System.out.println("**********" + allModel.size());
		return allModel;
	}

	// Extra
	@GetMapping("/lock_unlock_deatils")
	public List<UnlockAccountsDetails> getLockUnlockDetails() {
		List<UnlockAccountsDetails> lockUnlockDeatils = hodAuthorityService.getLockUnlockDetails();
		return lockUnlockDeatils;
	}

	// get all TRANSACTIONS details ............................
	@GetMapping("/transactions")
	public List<Transactions> getTransactions() {
		List<Transactions> transactions = hodAuthorityService.getTransactions();
		return transactions;
	}

	// get all memeorandoms details ............................
	@GetMapping("/memeorandoms")
	public List<MemorandumTransactions> getMemorandoms() {
		List<MemorandumTransactions> memeorandoms = hodAuthorityService.getMemorandoms();
		return memeorandoms;
	}

	// get all agentTds details ............................
	@GetMapping("/agentsTds")
	public List<AgentTds> getAllAgentdTds() {
		List<AgentTds> agentsTds = hodAuthorityService.getAllAgentdTds();
		return agentsTds;
	}

	// Get team details................
	@GetMapping("/team")
	public List<Teams> getActiveStaff() {
		List<Teams> staffList = hodAuthorityService.getTeams();
		return staffList;
	}

	// Edit team....
	@PutMapping("/updateTeam")
	public void updateTeam(@RequestBody Teams teams) {
		hodAuthorityService.updateTeam(teams);
	}

	// Add team....
	@PostMapping("/addTeam")
	public void addTeam(@RequestBody Teams teams) {
		hodAuthorityService.addTeam(teams);
	}

	// Delete team....
	@DeleteMapping("/deleteTeam/{id}")
	public void deleteTeam(@PathVariable("id") Integer id) {
		hodAuthorityService.deleteTeam(id);
	}

	// Get all document............................
	@GetMapping("/documents")
	public List<Documents> getAllDocument() {
		List<Documents> documents = hodAuthorityService.getAllDocument();
		return documents;
	}

	// Edit Documents.............
	@PutMapping("/updateDocuments")
	public void updateDocuments(@RequestBody Documents documents) {
		hodAuthorityService.updateDocuments(documents);
	}

	// Add Documents....
	@PostMapping("/addDocuments")
	public void addDocuments(@RequestBody Documents documents) {
		hodAuthorityService.addDocuments(documents);
	}

	// Delete Documents....
	@DeleteMapping("/deleteDocuments/{id}")
	public void deleteDocuments(@PathVariable("id") Integer id) {
		 hodAuthorityService.deleteDocuments(id);
	}

	// Get all bank list..
	@GetMapping("/bankList")
	public List<Bank> getAllBank() {
		List<Bank> bankList = hodAuthorityService.getAllBank();
		return bankList;
	}

	// Edit Bank....
	@PutMapping("/updateBank")
	public void updateBank(@RequestBody Bank bank) {
		hodAuthorityService.updateBank(bank);
	}

	// Add Bank....
	@PostMapping("/addBank")
	public void addBank(@RequestBody Bank bank) {
		hodAuthorityService.addBank(bank);
	}

	// Delete bank....
	@DeleteMapping("/deleteBank/{id}")
	public void deleteBank(@PathVariable("id") Integer id) {
		 hodAuthorityService.deleteBank(id);
	}

	// Get all bank branches....
	@GetMapping("/bank_Branch/{bankId}")
	public List<BankBranchesDetails> getAllBank(@PathVariable("bankId") int bankId) {
		List<BankBranchesDetails> bankBranch = hodAuthorityService.getAllBankBranche(bankId);
		return bankBranch;
	}

	// Edit Bank Branch....
	@PutMapping("/updateBankBranch")
	public void updateBankBranch(@RequestBody BankBranches bank) {
		hodAuthorityService.updateBankBranch(bank);
	}

	// Add Bank Branch....
	@PostMapping("/addBankBranch")
	public void addBankBranch(@RequestBody BankBranches bank) {
		hodAuthorityService.addBankBranch(bank);
	}

	// Delete bank Branch....
	@DeleteMapping("/deleteBankBranch/{id}")
	public void deleteBankBranch(@PathVariable("id") int id) {
		hodAuthorityService.deleteBankBranch(id);
	}

	// Get all OD LIMIT............................
	@GetMapping("/od_limit")
	public List<ODLimitsDetails> getAllOdLimit() {
		List<ODLimitsDetails> odLimits = hodAuthorityService.getodLimit();
		return odLimits;
	}

	// Edit OD LIMIT....
	@PutMapping("/updateODLimit")
	public void updateODLimit(@RequestBody ODLimitsDetails odlimitsDetails) {
		hodAuthorityService.updateODLimit(odlimitsDetails);
	}

	// Get lock/unlock accounts............................................
	@GetMapping("/lock_unlock/{accountNumber}")
	public List<LockUnlockAcntDetails> getLockUnlock(@PathVariable("accountNumber") String accountNumber) {
		List<LockUnlockAcntDetails> lockUnlock = hodAuthorityService.getUnlockDetails(accountNumber);
		return lockUnlock;
	}

	// Swap Locking status.................................................
	@PutMapping("/swapLockingStatus")
	public void updateLockingStatus(@RequestBody LockUnlockAcntDetails lockUnlockAcntDetails) {
		hodAuthorityService.updateLockingStatus(lockUnlockAcntDetails);
	}

	// Swap Locking status....................................................
	@PutMapping("/swapActiveStatus")
	public void updateActiveStatus(@RequestBody LockUnlockAcntDetails lockUnlockAcntDetails) {
		hodAuthorityService.updateActiveStatus(lockUnlockAcntDetails);
	}

	// Swap Locking status.........................................................
	@PutMapping("/swapMaturedStatus")
	public void updateMaturedStatus(@RequestBody LockUnlockAcntDetails lockUnlockAcntDetails) {
		hodAuthorityService.updateMaturedStatus(lockUnlockAcntDetails);
	}

	// Get mo and ro list................
	@GetMapping("/moro_list")
	public List<MoRoDetails> getAllMoRo() {
		List<MoRoDetails> moroList = hodAuthorityService.getMoRo();
		return moroList;
	}

	// Edit Mo/Ro List....
	@PutMapping("/updateMoro")
	public void updateMoro(@RequestBody MoRoDetails moroDetails) {
		hodAuthorityService.updateMoro(moroDetails);
	}

	// Add Mo/Ro List....
	@PostMapping("/addMoro")
	public void addMoro(@RequestBody MoRoDetails moroDetails) {
		hodAuthorityService.addMoro(moroDetails);
	}

	// Delete team....
	@DeleteMapping("/deleteMoro/{id}")
	public void deleteMoro(@PathVariable Integer id) {
		hodAuthorityService.deleteMoro(id);
	}

	// get all tellecaller associations.............................
	@GetMapping("/tellecaller")
	public List<Telecaller> getTellecaller() {
		List<Telecaller> tellecallerList = hodAuthorityService.getalltellecaller();
		return tellecallerList;
	}

	// Edit Telecallers....
	@PutMapping("/updateTelecaller")
	public void updateTelecaller(@RequestBody Telecaller telecaller) {
		hodAuthorityService.updateTelecaller(telecaller);
	}

	// Add Telecallers....
	@PostMapping("/addTeleCaller")
	public void addTeleCaller(@RequestBody Telecaller telecaller) {
		hodAuthorityService.addTeleCaller(telecaller);
	}

	// Delete Telecaller....
	@DeleteMapping("/deleteTelecaller/{id}")
	public void deleteTeleCaller(@PathVariable Integer id) {
		hodAuthorityService.deleteTeleCaller(id);
	}
		
		// Add button that appears as pop up box after clicking the Add MoAgentAssociation button present inside Mo Associations tab inside MO/RO Association Edit........................
		@PostMapping("/addMoAgentAssociationAdd")
		public void addMoAgentAssociationAdd(@RequestBody AssociationDetails details) {
			hodAuthorityService.addMoAgentAssociationAdd(details);
		}
		
		// edit button inside Mo Associations inside MO/RO Association Edit...................
		@PutMapping("/updateMoAgentAssociation")
		public void updateMoAgentAssociation(@RequestBody AssociationDetails details) {
			hodAuthorityService.updateMoAgentAssociation(details);
		}
		
		// delete button inside Mo Association inside MO/RO Association Delete................
		@DeleteMapping("/deleteMoAgentAssociation/{id}")
		public void deleteMoAgentAssociation(@PathVariable("id") int id) {
			hodAuthorityService.deleteMoAgentAssociation(id);
		}
		
		// filter button controller present inside Mo Associations tab inside MO/RO Association Edit.................
		@GetMapping("/filterMoAgentAssociationsDetails")
		public List<AssociationDetails> getFilterMoAgentAssociationsDetails(@RequestParam Integer id) {
			List<AssociationDetails> moassociationList = hodAuthorityService.getFilterMoAgentAssociationsDetails(id);
			return moassociationList;
		}
		
		// for "Add MoAccountAssociation" tab inside "Ro Association" tab inside "MO/RO Association Edit" tab..................
		@PostMapping("/add_mo_account_association")
		public void addMoAccountAssociation(@RequestBody AssociationDetails details) {
			hodAuthorityService.addMoAccountAssociation(details);
		}
		
		// for "Edit MoAccountAssociation" tab inside "Ro Association" tab inside "MO/RO Association Edit" tab..................
		@PutMapping("/update_mo_account_association")
		public void updateMoAccountAssociation(@RequestBody AssociationDetails details) {
			hodAuthorityService.updateMoAccountAssociation(details);
		}
		
		// for "Delete MoAccountAssociation" tab inside "Ro Association" tab inside "MO/RO Association Edit" tab..................
		@DeleteMapping("/delete_mo_account_association/{id}")
		public void deleteMoAccountAssociation(@PathVariable("id") Integer id) {
			hodAuthorityService.deleteMoAccountAssociation(id);
		}
		
		// controller for filter button inside Ro Associations tab inside MO/RO Association Edit.................
		@GetMapping("/filterRoAccountAssociation")
		public List<AssociationDetails> getFilterRoAccountAssociation(@RequestParam Integer id){
			List<AssociationDetails> associationDetails = hodAuthorityService.getFilterRoAccountAssociation(id);
			return associationDetails;
		}
		
		// add TeleCallerAccountHistory button controller from Telecaller History tab..........................
		@PostMapping("/addTelecallerAccountHistory")
		public void addTellecallerAccountHistory(@RequestBody TeleCallerHistoryDetails details) {
			hodAuthorityService.addTeleCallerHistoryDetails(details);
		}
		
		// edit TeleCallerAccountHistory button controller from Telecaller History tab..........................
		@PutMapping("/updateTelecallerAccountHistory")
		public void updateTelecallerAccountHistory(@RequestBody TeleCallerHistoryDetails details) {
			hodAuthorityService.updateTelecallerAccountHistory(details);
		}
		
		// delete TeleCallerAuthorityHistory button controller from Telecaller History tab............................
		@DeleteMapping("/deleteTelecallerAuthorityHistory/{id}")
		public void deleteTelecallerAuthorityHistory(@PathVariable("id") Integer id) {
			 hodAuthorityService.deleteTelecallerAuthorityHistory(id);
		}
		
		// Controller for 'filter' button present inside 'Mo Agent Update' tab................
		@GetMapping("/filterMoAgentUpdateDetails")
		public List<FilterMoAgentUpdateDetails> getFilterMoAgentUpdateDetails(@RequestParam Integer id) {
			List<FilterMoAgentUpdateDetails> filterMoAgentUpdateDetails = hodAuthorityService.getFilterMoAgentUpdateDetails(id);
			return filterMoAgentUpdateDetails;
		}
		
		//Change Mo in the MO agent update.....
		@PutMapping("/changeMo")
		public void changeMo(@RequestBody changeMoDetail changeMoDetail) {
			hodAuthorityService.changeMo(changeMoDetail);
		}
		
		// get moAgentAssociationList (in Adding new MoAgentAssociation pop up box of Add MoAgentAssociation button which is present inside Mo Association in MO/RO Association Edit)
		@GetMapping("/moAgentAssociationList")
		public List<AssociationDetails> getMoAgentAssociationList(@RequestParam String name){
			List<AssociationDetails> moAgentAssociationList = hodAuthorityService.getMoAgentAssociationList(name);
			return moAgentAssociationList;
		}
		
		// get telle-caller name for pop-up box that appears when Add TeleCallerAccountHistory button (from Telecaller History Edit tab) is pressed..................
		@GetMapping("/tellecallerList")
		public List<Telecaller> getTellecallerList(@RequestParam String name){
			List<Telecaller> telecaller = hodAuthorityService.getTellecallerList(name);
			return telecaller;
		}
		
		// get account and member details (Account number + Member name + Father name) for pop-up box that appears when Add TeleCallerAccountHistory button
		// (from Telecaller History Edit tab) is pressed.......................
		@GetMapping("/accountAndMemberDetails")
		public List<AccountAndMemberDetails> getAccountAndMemberDetails(@RequestParam String name){
			List<AccountAndMemberDetails> accountAndMemberDetails= hodAuthorityService.getAccountAndMemberDetails(name);
			return accountAndMemberDetails;
		}
		
		// for Mo search by String.........
		@GetMapping("/mo_associationList")
		public List<AssociationDetails> getmoAssociationList(@RequestParam String name){
			List<AssociationDetails> list = hodAuthorityService.getmoAssociationList(name);
			return list;
		}
		
		// three character suggestion controller for 'Mo' that appears in 'Add MoAgentAssociation' tag pop up box....................
		@GetMapping("/moList")
		public List<MoRoDetails> getMoList(@RequestParam String name) {
			List<MoRoDetails> moList = hodAuthorityService.getMoList(name);
			return moList;
		}
		
		// for account number API inside 'Lock Unlock Accounts' tab (3 character search API)............
		@GetMapping("/lock_unlock/account_list")
		public List<LockUnlockAcntDetails> getAccountList(@RequestParam String name){
			List<LockUnlockAcntDetails> accountList = hodAuthorityService.getAccountList(name);
			return accountList;
		}
		
		// get account association details that appears in popup box when Add MoAccount Association is 
		//clicked which is inside Ro Associations inside MO/Ro Association Edit.............. 
		@GetMapping("/roAccountAssociationList")
		public List<AssociationDetails> getRoAccountAssociationList(@RequestParam String name){
			List<AssociationDetails> associationDetails = hodAuthorityService.getRoAccountAssociationList(name);
			return associationDetails;
		}
		
		@GetMapping("/agentsTds/{setFirstResult}/{setMaxResults}")
		public Map<String, Object> getAllAgentTds(@PathVariable("setFirstResult") Integer setFirstResult, @PathVariable("setMaxResults") Integer setMaxResults) {
			Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
			Map<String, Object> agentsTds = hodAuthorityService.getAllAgentTds(setPageNumber, setMaxResults);
			return agentsTds;
		}
		
		// get filtered agentTds details................
		@GetMapping("/filtered_agentsTds/{setFirstResult}/{setMaxResults}")
		public Map<String, Object> getFilteredAgentTds(@RequestParam Integer agentId, @RequestParam Integer relatedAccountId, @PathVariable("setFirstResult") Integer setFirstResult, @PathVariable("setMaxResults") Integer setMaxResults) {
			Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
			Map<String, Object> agentsTds = hodAuthorityService.getFilteredAgentTds(agentId, relatedAccountId, setPageNumber, setMaxResults);
			return agentsTds;
		}
		
		// add agentTds details............
		@PostMapping("/add_agentTds")
		public void addAgentTds(@RequestBody AgentTdsDetail details) {
			hodAuthorityService.addAgentTds(details);
		}
		
		// update agentTds details............
		@PutMapping("/update_agentTds")
		public void updateAgentTds(@RequestBody AgentTdsDetail details) {
			hodAuthorityService.updateAgentTds(details);
		}

		// delete agentTds details...............	
		@DeleteMapping("/delete_agentTds/{id}")
		public void deleteAgentTds(@PathVariable("id") Integer id) {
			hodAuthorityService.deleteAgentTds(id);
		}
		
		// get all invoice details..............
		@GetMapping("/invoice/{setFirstResult}/{setMaxResults}")
		public Map<String, Object> getInvoice(@PathVariable("setFirstResult") Integer setFirstResult, @PathVariable("setMaxResults") Integer setMaxResults){
			Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
			Map<String, Object> list = hodAuthorityService.getInvoice(setPageNumber, setMaxResults);
			return list;
		}
		
		// edit invoice...................
		@PutMapping("update_invoice")
		public void updateInvoice(@RequestBody InvoiceDetails details) {
			hodAuthorityService.updateInvoice(details);
		}
		
		// API for "Detail" tab inside invoice tab...............
		@GetMapping("/invoice/detail")
		public List<TransactionRowDetails> getTransactionRowForInvoice(@RequestParam Integer id) {
			return hodAuthorityService.getTransactionRowForInvoice(id);
		}
		
		// API for add detail tab inside invoice tab.............
		@PostMapping("invoice/add_detail")
		public void addTransactionRowForInvoice(@RequestBody TransactionRowDetails details) {
			hodAuthorityService.addTransactionRowForInvoice(details);
		}
		
		// API for edit detail tab inside invoice tab.............
		@PutMapping("invoice/update_detail")
		public void updateTransactionRowForInvoice(@RequestBody TransactionRowDetails details) {
			hodAuthorityService.updateTransactionRowForInvoice(details);
		}
		
		// API for add detail tab inside invoice tab.............
		@DeleteMapping("invoice/delete_detail/{id}")
		public void deleteTransactionRowForInvoice(@PathVariable("id") Integer id) {
			hodAuthorityService.deleteTransactionRowForInvoice(id);
		}
		

		// API for Invoicecancel inside Invoice tab...............
		@GetMapping("/invoice/cancel")
		public void cancelInvoice(@RequestParam Integer id) {
			hodAuthorityService.cancelInvoice(id);
		}
		
		// get all memeorandoms details ............................
		@GetMapping("/memorandoms/{setFirstResult}/{setMaxResults}")
		public Map<String, Object> getMemorandoms(@PathVariable("setFirstResult") Integer setFirstResult, @PathVariable("setMaxResults") Integer setMaxResults) {
			Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
			Map<String, Object> memeorandoms = hodAuthorityService.getMemorandoms(setPageNumber, setMaxResults);
			return memeorandoms;
		}
		
		// add memorandoms..........................
		@PostMapping("/add_memorandoms")
		public void addMemorandoms(@RequestBody MemorandomTransactionDetails details) {
			hodAuthorityService.addMemorandoms(details);
		}
		
		
		// update memorandoms.............
		@PutMapping("/update_memorandoms")
		public void updateMemorandoms(@RequestBody MemorandomTransactionDetails details) {
			hodAuthorityService.updateMemorandoms(details);
		}
		
		// delete memorandoms.................
		@DeleteMapping("/delete_memorandoms/{id}")
		public void deleteMemorandoms(@PathVariable("id") Integer id) {
			hodAuthorityService.deleteMemorandoms(id);
		}
		
		// get detail api tab for memorandoms tab......................
		@GetMapping("/memodandom/details")
		public List<MemoRandomTransactionRowDetails> getDetailsMemodandom(@RequestParam Integer memorandomTransactionId) {
			return hodAuthorityService.getDetailsMemodandom(memorandomTransactionId);
		}
		
		// add detail api for memorandoms tab..............
		@PostMapping("/memodandom/add_details")
		public void addDetailsMemorandom(@RequestBody MemoRandomTransactionRowDetails details) {
			hodAuthorityService.addDetailsMemorandom(details);
		}
		
		// update detail api for memorandoms tab..............
		@PutMapping("/memodandom/update_details")
		public void updateDetailsMemorandom(@RequestBody MemoRandomTransactionRowDetails details) {
			hodAuthorityService.updateDetailsMemorandom(details);
		}
		
		// delete detail API for memorandoms tab...............
		@DeleteMapping("/memodandom/delete_details/{id}")
		public void deleteDetailsMemorandom(@PathVariable("id") Integer id) {
			 hodAuthorityService.deleteDetailsMemorandom(id);
		}
		
		@GetMapping("/dirty_voucher/{currentDate}")
		public List<iDeleteVoucherDetails> getDirtyVoucher(@RequestParam Integer branchId, @RequestParam Integer voucherNo, @RequestParam Integer voucherUuid,
				@PathVariable("currentDate") String currentDate) throws Exception{
			return hodAuthorityService.getDirtyVoucher(branchId,voucherNo,voucherUuid,currentDate);
		}
		
		@DeleteMapping("/transaction_remove_delete")
		public void removeTransaction(@RequestParam Integer branchId, @RequestParam Integer voucherNo, @RequestParam Integer voucherUuid) {
			hodAuthorityService.removeTransaction(branchId,voucherNo,voucherUuid);
		}
		
		@PutMapping("/narration_edit")
		public void narrationEdit(@RequestParam Integer branchId, @RequestParam Integer voucherNo, @RequestParam Integer voucherUuid, @RequestParam String narration) {
			hodAuthorityService.narrationEdit(branchId,voucherNo,voucherUuid,narration);
		}
		
		@PutMapping("/edit_accounts")
		public void editAccounts(@RequestParam Integer id, @RequestParam Integer accountId) {
			hodAuthorityService.editAccounts(id, accountId);
		}
		
		
		
		

		
		 
}