package com.service.banking.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.service.banking.service.HodAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.service.banking.hibernateEntity.Acls;
import com.service.banking.hibernateEntity.BalanceSheet;
import com.service.banking.hibernateEntity.Cadres;
import com.service.banking.hibernateEntity.ContentFiles;
import com.service.banking.hibernateEntity.Documents;
import com.service.banking.hibernateEntity.Schemes;
import com.service.banking.hibernateEntity.Staffs;
import com.service.banking.model.GstModel.AccountDetail;
import com.service.banking.model.superAdminModel.AclDetails;
import com.service.banking.model.superAdminModel.AclDocumentDetail;
import com.service.banking.model.superAdminModel.AclReportDetails;
import com.service.banking.model.superAdminModel.BalanceSheetHead;
import com.service.banking.model.superAdminModel.BalanceSheetReq;
import com.service.banking.model.superAdminModel.BranchDetail;
import com.service.banking.model.superAdminModel.BranchesDetails;
import com.service.banking.model.superAdminModel.Cadre;
import com.service.banking.model.superAdminModel.CadreDetails;
import com.service.banking.model.superAdminModel.ClosingDetails;
import com.service.banking.model.superAdminModel.MeberDetail;
import com.service.banking.model.superAdminModel.ShareCertificateDetail;
import com.service.banking.model.superAdminModel.ShareCertificateDetails;
import com.service.banking.model.superAdminModel.ShareDetails;
import com.service.banking.model.superAdminModel.ShareHistoryDetails;
import com.service.banking.model.superAdminModel.StaffModel;
import com.service.banking.model.superAdminModel.StaffPreviewDetail;
import com.service.banking.repository.superAdminRepo.BalanceSheetRepo;
import com.service.banking.service.DashBoardService;
import com.service.banking.service.SuperAdminService;
import com.service.banking.utils.DateFormater;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service
@RequestMapping("/service/superadmin")
public class SuperAdminController {

	@Autowired
	SuperAdminService superAdminService;

	@Autowired
	BalanceSheetRepo balanceSheetRepo;

	// Get Active staff.................................................................................
	@GetMapping("/activeStaff")
	public List<StaffModel> getActiveStaff() {
		List<StaffModel> activeStaff = superAdminService.getActiveStaff();
		return activeStaff;
	}

	// Get InActive staff................................................................................
	@GetMapping("/InActiveStaff")
	public List<StaffModel> getInactiveStaff() {
		List<StaffModel> InActiveStaff = superAdminService.getInActiveStaff();
		return InActiveStaff;
	}

	// Get all branches...................................................................................
	@GetMapping("/branches")
	public List<BranchDetail> getBranches() {
		List<BranchDetail> branches = superAdminService.getallBranches();
		return branches;
	}

	// Add Branches.......................................................................................
	@PostMapping("/add_branches")
	public void addBranches(@RequestBody BranchesDetails branchesDetails) {
		superAdminService.addBranchesDetails(branchesDetails);
	}

	// Delete Branches....................................................................................
	@DeleteMapping("/delete_branches/{id}")
	public void deleteBranches(@PathVariable("id") Integer Id) {
		String message = superAdminService.deleteBranchesDetails(Id);
	}

	// Update Branches.......................................................................................
	@PutMapping("/update_branches")
	public void updateBranches(@RequestBody BranchesDetails branchesDetails) {
		superAdminService.updateBranchesDetails(branchesDetails);
	}

	// Get all top head branches..............................................................................
	@GetMapping("/topHead_BalanceSheet")
	public List<BalanceSheet> getTopHeadBalSheet() {
		List<BalanceSheet> balanceSheets = superAdminService.getTopHeadBalance();
		return balanceSheets;
	}

	// Update Balance sheet....................................................................................
	@PutMapping("/update_TopHead_BalanceSheet")
	public void updateTopHeadBalSheet(@RequestBody BalanceSheetReq balanceSheet) {
		superAdminService.updateBalanceSheet(balanceSheet);
	}

	// Add Balance sheet........................................................................................
	@PostMapping("/add_TopHead_BalanceSheet")
	public void addTopHeadBalSheet(@RequestBody BalanceSheetReq balanceSheet) {
		superAdminService.addBalanceSheet(balanceSheet);
	}

	// Delete Balance Sheet.....................................................................................
	@DeleteMapping("/delete_TopHead_BalanceSheet/{id}")
	public void deleteTopHeadBalSheet(@PathVariable("id") Integer Id) {
		String message = superAdminService.deleteBalanceSheet(Id);

	}

	// Get Agent Cadres for edit Drop-down......................................................................
	@GetMapping("/agentCadres")
	public List<Cadre> getAllCadres() {
		List<Cadre> cadres = superAdminService.getCadres();
		return cadres;
	}

	// Get all Agent Cadres.....................................................................................
	@GetMapping("/agentCadres_details")
	public List<CadreDetails> getCadresDetails() {
		List<CadreDetails> cadres = superAdminService.getCadresDetails();
		return cadres;
	}

	// Update Agent cadres......................................................................................
	@PutMapping("/update_agentCadres")
	public void updateCadres(@RequestBody Cadres cadres) {
		superAdminService.updateAgentCadres(cadres);
	}

	// Add agent cadres.........................................................................................
	@PostMapping("/add_AgentCadres")
	public void addCadres(@RequestBody Cadres cadres) {
		superAdminService.addAgentCadres(cadres);
	}

	// Delete agent cadres.................................................................................
	@DeleteMapping("/delete_AgentCadres/{id}")
	public void deleteCadres(@PathVariable("id") Integer Id) {
		String message = superAdminService.deleteAgentCadres(Id);
	}

	// get closing.................
	@GetMapping("/closing")
	public List<ClosingDetails> getClosing() {
		List<ClosingDetails> closingDetails = superAdminService.getClosing();
		return closingDetails;
	}

	// get content Management.........
	@GetMapping("/content_management")
	public List<ContentFiles> getContentManagement() {
		List<ContentFiles> contentList = superAdminService.getcontentMangement();
		return contentList;
	}

	// Delete content Management........
	@DeleteMapping("/delete_content_management/{id}")
	public void deleteContentManagement(@PathVariable("id") Integer Id) {
		String message = superAdminService.deletecontentMangement(Id);
	}

	// Add content Management....send without id
	@PostMapping("/add_content_management")
	public void addContentManagement(@RequestBody ContentFiles contentFiles) {
		superAdminService.addcontentMangement(contentFiles);
	}

	// update content Management....send with id
	@PostMapping("/update_content_management")
	public void updateContentManagement(@RequestBody ContentFiles contentFiles) {
		superAdminService.updatecontentMangement(contentFiles);
	}

	// Get all share....................................................................................................
	@GetMapping("/share/{setPageNumber}/{setPageSize}")
	public Map<String, Object> getShare(@PathVariable("setPageNumber") Integer setPageNumber,
			@PathVariable("setPageSize") Integer setPageSize) {
		Integer pageNumber = DateFormater.pageNumber(setPageNumber);
		Map<String, Object> share = superAdminService.getShare(pageNumber, setPageSize);
		return share;
	}
		

	//Update share......................................................................................................
	@PutMapping("/update_share")
	public void updateShare(@RequestBody ShareDetails sd) {
		superAdminService.updateShareDetails(sd);
	}

	@PostMapping("/add_share")
	public void addShareDetails(@RequestBody ShareDetails scd) {
		superAdminService.addShareDetails(scd);
	}

	@DeleteMapping("/delete_share/{id}")
	public void deleteShareDetails(@PathVariable("id") Integer id) {
		String message = superAdminService.deleteShareDetails(id);
	}
	
	// Get share history....................................................................................................
	@GetMapping("/share_history/{shareId}")
	public List<ShareHistoryDetails> getShareHistory(@PathVariable("shareId") Integer shareId) {
		List<ShareHistoryDetails> share = superAdminService.getShareHistory(shareId);
		return share;
	}
	
	//Add share history........................................................................................................
	@PostMapping("/add_share_history")
	public void addShareHistory(@RequestBody ShareHistoryDetails shareHistoryDetails) {
		superAdminService.addShareHistory(shareHistoryDetails);
	}
	
	//Edit share history........................................................................................................
	@PutMapping("/update_share_history")
	public void updateShareHistory(@RequestBody ShareHistoryDetails shareHistoryDetails) {
		superAdminService.updateShareHistory(shareHistoryDetails);
	}
	
	// Delete share history....................................................................................................
	@DeleteMapping("/delete_share_history/{id}")
	public void deleteShareHistory(@PathVariable("id") Integer Id) {
		String message = superAdminService.deleteShareHistory(Id);
	}

	// Get all share certificate.............................................................................................
	@GetMapping("/share_certificate/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> getShareCertificate(@PathVariable("setFirstResult") Integer setFirstResult,
			@PathVariable("setMaxResults") Integer setMaxResults) {
		Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
		Map<String, Object> shareCertifiacte = superAdminService.getShareCertificate(setPageNumber, setMaxResults);
		return shareCertifiacte;
	}

	@PutMapping("/update_share_certificate")
	public void updateShareCertificateDetails(@RequestBody ShareCertificateDetails scd) {
		superAdminService.updateShareCertificateDetails(scd);
	}

	@PostMapping("/add_share_certificate")
	public void addShareCertificateDetails(@RequestBody ShareCertificateDetails scd) {
		superAdminService.addShareCertificateDetails(scd);
	}

	@DeleteMapping("/delete_share_certificate/{id}")
	public void deleteShareCertificateDetails(@PathVariable("id") Integer id) {
		String message = superAdminService.deleteShareCertificateDetails(id);
	}
	
	// Get shareCertcate share....................................................................................................
	@GetMapping("/share_certificate_share/{id}")
	public List<ShareDetails> getShareCertificateShare(@PathVariable("id") Integer id) {
		List<ShareDetails> share = superAdminService.getShareCertificateShare(id);
		return share;
	}


	// Get all member for share add and update Drop-down...................................
	@GetMapping("/all_member_deatil")
	List<MeberDetail> getMember(@RequestParam("memeberName") String memeberName) {
		List<MeberDetail> allmemeber = superAdminService.getMember(memeberName); // null check already in service....
		System.out.println("**********" + allmemeber.size());
		return allmemeber;
	}

	// Get all share certificate for share add and update Dropdown....................................................................
	@GetMapping("/all_share_certificate")
	List<ShareCertificateDetail> getShareCertificate(@RequestParam("name") Integer name) {
		List<ShareCertificateDetail> sharecertificate = superAdminService.getShareCertificate(name);
		return sharecertificate;
	}

	// staff acl documment...........................
	@GetMapping("/staff_acl_document/{Id}")
	public List<AclDetails> staffAclDocument(@PathVariable("Id") Integer Id) {
		List<AclDetails> staffAcl = superAdminService.getStaffAclDocument(Id);
		return staffAcl;
	}

	// get all document name.......................................
	@GetMapping("/staff_acl_documentName")
	public List<AclDocumentDetail> staffAclDocument() {
		List<AclDocumentDetail> aclDocument = superAdminService.getAclDocument();
		return aclDocument;
	}

	// edit acl document
	@PutMapping("/edit_acl_document")
	public void editAclDocument(@RequestBody AclDetails acld) {
		superAdminService.updateDocumentAcl(acld);
	}

	// Delete acl document................................
	@DeleteMapping("/delete_acl_document/{Id}")
	public void deleteAclDocument(@PathVariable("Id") Integer Id) {
		String message = superAdminService.deleteAclDocument(Id);
	}

	// add acl documrnt................................
	@PostMapping("/add_acl_document")
	public void addAclDocument(@RequestBody AclDetails acltDetail) {
		superAdminService.addDocumentAcl(acltDetail);
	}

	// getting all document acl documment..............................
	@GetMapping("/acl_document")
	public List<Documents> getAclDocument() {
		List<Documents> documents = superAdminService.allDocumentACl();
		return documents;
	}

	// get acl for staff...........data
	@GetMapping("/staff_acl/{Id}")
	public List<AclDetails> staffAcl(@PathVariable("Id") Integer Id) {
		List<AclDetails> staffAcl = superAdminService.getStaffAcl(Id);
		return staffAcl;
	}

	// Update Acl.... data
	@PutMapping("/update_staff_acl")
	public void updateAclStaff(@RequestBody AclDetails acld) {
		superAdminService.updateAclStaff(acld);
	}

	// Add Acl data....
	@PostMapping("/add_staff_acl_data")
	public void addAclStaff(@RequestBody AclDetails acld) {
		superAdminService.addAclStaff(acld);
	}

	// Delete Acl data.................................
	@DeleteMapping("/delete_staff_acl_data/{id}")
	public void deleteAclStaff(@PathVariable("id") Integer Id) {
		String message = superAdminService.deleteAclStaff(Id);
	}

	// Delete Acl report..........................
	@DeleteMapping("/delete_staff_acl_report/{Id}")
	public void deleteAclStaffReport(@PathVariable("Id") Integer Id) {
		String message = superAdminService.deleteAclStaffReport(Id);
	}

	// Acl for staff....report gett
	@GetMapping("/staff_acl_report/{Id}")
	public List<AclReportDetails> staffAclReport(@PathVariable("Id") Integer Id) {
		List<AclReportDetails> staffAclreport = superAdminService.getStaffAclReport(Id);
		return staffAclreport;
	}

	// Update Acl report....
	@PutMapping("/update_staff_acl_report")
	public void updateAclReport(@RequestBody AclReportDetails ard) {
		superAdminService.updateAclStaffReport(ard);
	}


	// Update active Staff.....
	@PutMapping("/update_active_staffs")
	public void updateActiveStaffs(@RequestBody Staffs staffs) {
		superAdminService.updateActiveStaff(staffs);

	}

	// Update Inactive Staff.....
	@PutMapping("/update_inactive_staffs")
	public void updateInactiveStaffs(@RequestBody Staffs staffs) {
		superAdminService.updateInactiveStaff(staffs);
	}

	// Add active Staff.....
	@PostMapping("/add_active_staffs")
	public void addActiveStaffs(@RequestBody Staffs staffs) {
		superAdminService.addActiveStaff(staffs);
	}

	// Add inactive Staff.....
	@PostMapping("/add_inactive_staffs")
	public void addInactiveStaffs(@RequestBody Staffs staffs) {
		superAdminService.addInactiveStaff(staffs);
	}

	// Delete active Staff........................
	@DeleteMapping("/delete_active_staffs/{id}")
	public void deleteActiveStaffs(@PathVariable("id") Integer Id) {
		String message = superAdminService.deleteActiveStaff(Id);
	}

	// Delete Inactive Staff....................
	@DeleteMapping("/delete_Inactive_staffs/{id}")
	public void deleteInactiveStaffs(@PathVariable("id") Integer Id) {
		String message = superAdminService.deleteInactiveStaff(Id);
	}

	// preview active and Inactive Staff....................
	@GetMapping("/preview_active_inactive_staff/{id}")
	public StaffPreviewDetail getStaffPreview(@PathVariable("id") Integer Id) {
		StaffPreviewDetail staffs = superAdminService.getStaffPreview(Id);
		if (staffs != null) {
			return staffs;
		} else {
			return new StaffPreviewDetail();
		}
	}

	// in activate the staff for active staff....................
	@GetMapping("/inActivate_Staff/{id}")
	public void inActivateStaff(@PathVariable("id") Integer Id) {
		superAdminService.inActivatedTheStaff(Id);
	}

	// activate the staff for Inactive staff....................
	@GetMapping("/activate_Staff/{id}")
	public void activateStaff(@PathVariable("id") Integer Id) {
		superAdminService.activatedTheStaff(Id);
	}
	
	// Extra API for JSON
	@GetMapping("/schema")
	public List<Schemes> Schema() {
		List<Schemes> Schemas = superAdminService.Schemes();
		return Schemas;
	}

	// add schema Staff.....
	@PostMapping("/add_schema_loan")
	public void addSchemaLOAN(@RequestBody Schemes schema) {
		superAdminService.addSchemaLOAN(schema);
	}

	// add schema Staff.....
	@PostMapping("/add_schema_cc")
	public void addSchemaCC(@RequestBody Schemes schema) {
		superAdminService.addSchemaCC(schema);
	}

	// add schema Staff.....
		@PostMapping("/add_schema")
		public void addSchema(@RequestBody Schemes schema) {
			superAdminService.addSchemes(schema);
		}

	// Update schema Staff.....
	@PutMapping("/update_schema")
	public void updateSchema(@RequestBody Schemes schema) {
		superAdminService.updateSchemes(schema);
	}

	// Delete Inactive Staff....................
	@DeleteMapping("/delete_schema/{id}")
	public ResponseEntity<String> deleteSchema(@PathVariable("id") Integer Id) {
		String message = superAdminService.deleteSchema(Id);
		return ResponseEntity.ok(message);
	}

	// Head schema.....
	@GetMapping("/head_scheme")
	public List<BalanceSheetHead> headScheme() {
		List<BalanceSheetHead> balHeads = balanceSheetRepo.getBalanceSheetHead();
		if (balHeads.size() != 0) {
			return balHeads;
		} else {
			return new ArrayList<BalanceSheetHead>();
		}
	}
	
	@GetMapping("/accounts/{id}")
	public StaffModel getAccounts(@PathVariable("id") Integer id) {
		StaffModel staffAccounts= superAdminService.getAccounts(id);
		return staffAccounts;
	}
	
	@GetMapping("/transactions/{id}")
	public StaffModel getTransactions(@PathVariable("id") Integer id) {
		StaffModel staffTransactions= superAdminService.getTransactions(id);
		return staffTransactions;
	}

}
