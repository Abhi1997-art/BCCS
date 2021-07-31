package com.service.banking.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.service.banking.hibernateEntity.Accounts;
import com.service.banking.hibernateEntity.Acls;
import com.service.banking.hibernateEntity.BalanceSheet;
import com.service.banking.hibernateEntity.Branches;
import com.service.banking.hibernateEntity.Cadres;
import com.service.banking.hibernateEntity.ContentFiles;
import com.service.banking.hibernateEntity.Documents;
import com.service.banking.hibernateEntity.Members;
import com.service.banking.hibernateEntity.Schemes;
import com.service.banking.hibernateEntity.Share;
import com.service.banking.hibernateEntity.ShareCertificate;
import com.service.banking.hibernateEntity.ShareHistory;
import com.service.banking.hibernateEntity.StaffReportAcl;
import com.service.banking.hibernateEntity.Staffs;
import com.service.banking.model.GstModel.AccountDetail;
import com.service.banking.model.dashboardModel.DueDeatailsModel;
import com.service.banking.model.dashboardModel.MonthlyDao;
import com.service.banking.model.superAdminModel.AclDetails;
import com.service.banking.model.superAdminModel.AclDocumentDetail;
import com.service.banking.model.superAdminModel.AclReportDetails;
import com.service.banking.model.superAdminModel.BalanceSheetReq;
import com.service.banking.model.superAdminModel.Branch;
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
import com.service.banking.repository.AccountsRepo.AccountsRepo;
import com.service.banking.repository.dashBoardRepo.DashBoardSchemeRepo;
import com.service.banking.repository.hodAuthorityRepo.DocumentsMangmntRepo;
import com.service.banking.repository.madRepository.MembersRepo;
import com.service.banking.repository.stockRepo.StaffAclReportRepo;
import com.service.banking.repository.superAdminRepo.AclDocumentRepo;
import com.service.banking.repository.superAdminRepo.AgentCadreRepo;
import com.service.banking.repository.superAdminRepo.BranchesRepository;
import com.service.banking.repository.superAdminRepo.ContentMnagementRepo;
import com.service.banking.repository.superAdminRepo.ShareCertificateRepo;
import com.service.banking.repository.superAdminRepo.ShareRepository;
import com.service.banking.repository.superAdminRepo.StaffAclRepo;
import com.service.banking.repository.superAdminRepo.StaffRepo;
import com.service.banking.repository.superAdminRepo.TopHeadBalSheetRepo;
import com.service.banking.repository.superAdminRepo.shareHistoryRepository;
import com.service.banking.repository.transaction.TransactionsRepo;
import com.service.banking.utils.DateFormater;

import javassist.compiler.ast.NewExpr;

@Service
public class SuperAdminService {

	@Autowired
	StaffRepo staffRepo;

	@Autowired
	DocumentsMangmntRepo documentRepo;

	@Autowired
	BranchesRepository branchesRepository;

	@Autowired
	TopHeadBalSheetRepo topHeadBalSheetRepo;

	@Autowired
	AgentCadreRepo agenetCadreRepo;

	@Autowired
	ContentMnagementRepo contentMnagementRepo;

	@Autowired
	ShareRepository shareRepository;

	@Autowired
	ShareCertificateRepo shareCertificateRepo;

	@Autowired
	StaffAclRepo aclRepo;

	@Autowired
	MembersRepo membersrepo;

	@Autowired
	StaffAclReportRepo aclReportRepo;

	@Autowired
	AclDocumentRepo aclDocumentRepo;

	@Autowired
	DashBoardSchemeRepo schemaRepo;

	@Autowired
	MembersRepo memebrRepo;

	@Autowired
	ShareCertificateRepo sharecertificateRepo;
	
	@Autowired
	shareHistoryRepository shareHistoryRepo;
	
	@Autowired
	AccountsRepo accountsRepo;
	
	@Autowired
	TransactionsRepo transactionsRepo;

	// get active staff....................
	public List<StaffModel> getActiveStaff() {
		List<StaffModel> activeStaff = staffRepo.getActiveStaffs();
		if (activeStaff.size() != 0) {
			return activeStaff;
		} else {
			return new ArrayList<StaffModel>();
		}
	}

	// get inactive staff....................
	public List<StaffModel> getInActiveStaff() {
		List<StaffModel> inactiveStaff = staffRepo.getInActiveStaff();
		if (inactiveStaff.size() != 0) {
			return inactiveStaff;
		} else {
			return new ArrayList<StaffModel>();
		}
	}

	// Get all branches.....................
	public List<BranchDetail> getallBranches() {
		List<BranchDetail> branches = branchesRepository.getBranches();
		if (branches.size() != 0) {
			return branches;
		} else {
			return new ArrayList<BranchDetail>();
		}
	}
	
	// Update Branches ....................
	public void updateBranchesDetails(BranchesDetails branchesDetails) {
		Branches branches=branchesRepository.getOne(branchesDetails.getId());
		branches.setName(branchesDetails.getName());
		branches.setAddress(branchesDetails.getAddress());
		branches.setSendSms(branchesDetails.getSendSms());
		branches.setAllowLogin(branchesDetails.getAllowLogin());
		branches.setPerformClosings(branchesDetails.getPerformClosings());
		branches.setPublished(branchesDetails.getPublished());
		branches.setCode(branchesDetails.getCode());
		branchesRepository.save(branches);	
	}

	// Add branches.......................................................................................................
	public void addBranchesDetails(BranchesDetails branchesDetails) {
		Branches branches=new Branches();
		branches.setName(branchesDetails.getName());
		branches.setAddress(branchesDetails.getAddress());
		branches.setSendSms(branchesDetails.getSendSms());
		branches.setAllowLogin(branchesDetails.getAllowLogin());
		branches.setPerformClosings(branchesDetails.getPerformClosings());
		branches.setPublished(branchesDetails.getPublished());
		branches.setCode(branchesDetails.getCode());
		branchesRepository.save(branches);		
	}

	// Delete Branches........................................................................................
	public String deleteBranchesDetails(Integer id) {
		try {
			branchesRepository.deleteById(id);
		}
		catch(Exception e)
		{
		return "Try again after sometime"+e;
		}
	return "Item Deleted Successfully";
}


	// get top head balance sheet...................
	public List<BalanceSheet> getTopHeadBalance() {
		List<BalanceSheet> balanceSheet = topHeadBalSheetRepo.getTopbalanceSheets();
		if (balanceSheet.size() != 0) {
			return balanceSheet;
		} else {
			return new ArrayList<BalanceSheet>();
		}
	}
	// Update Balancesheet

	public void updateBalanceSheet(BalanceSheetReq balanceSheet) {

		BalanceSheet balSheet = topHeadBalSheetRepo.getOne(balanceSheet.getId());
		balSheet.setName(balanceSheet.getName());
		balSheet.setPositiveSide(balanceSheet.getPositiveSide());
		balSheet.setOrderOfBalanceSheet(balanceSheet.getOrderOfBalanceSheet());
		balSheet.setIsPandl((byte) (balanceSheet.getIsPandl() ? 1 : 0));
		balSheet.setShowSub(balanceSheet.getShowSub());
		balSheet.setSubtractFrom(balanceSheet.getSubtractFrom());
		topHeadBalSheetRepo.save(balSheet);

	}

	// get agent cadres for edit management...................
	public List<Cadre> getCadres() {
		List<Cadre> cadres = agenetCadreRepo.getallCadres();
		if (cadres.size() != 0) {
			return cadres;
		} else {
			return new ArrayList<Cadre>();
		}
	}

	// Get Agent Cadres management...............................................................................
	public List<CadreDetails> getCadresDetails() {
		List<CadreDetails> cadres = agenetCadreRepo.getCadresDetails();
		if (cadres.size() != 0) {
			return cadres;
		} else {
			return new ArrayList<CadreDetails>();
		}
	}

	// Update Agents Cadres ......................................................................................
	public void updateAgentCadres(Cadres cadres) {
		agenetCadreRepo.save(cadres);
	}

	// get closing management...................
	public List<ClosingDetails> getClosing() {
		List<ClosingDetails> closingDetails = branchesRepository.closingDetails();
		if (closingDetails.size() != 0) {
			return closingDetails;
		} else {
			return new ArrayList<ClosingDetails>();
		}
	}

	// get content management...................
	public List<ContentFiles> getcontentMangement() {
		List<ContentFiles> contentFiles = contentMnagementRepo.getcontentFile();
		if (contentFiles.size() != 0) {
			return contentFiles;
		} else {
			return new ArrayList<ContentFiles>();
		}
	}

	// Get share.................................................................................................................
	public Map<String, Object> getShare(Integer pageNumber, Integer pageSize) {

		Pageable paging = PageRequest.of(pageNumber, pageSize);
		Page<ShareDetails> share = shareRepository.getShare(paging);

		Map<String, Object> shareMap = new HashMap<String, Object>(); // it not good to add different type object into
																		// single hashmap instead create POJO Class.
		if (share.hasContent()) {
			shareMap.put("pageSize", share.getSize());
			shareMap.put("totalElement", share.getTotalElements());
			shareMap.put("totalPage", share.getTotalPages());
			shareMap.put("ShareDetail", share.getContent());
			return shareMap;
		} else {
			return shareMap;
		}
	}
	
	//Get share History........................................................................................................
	public List<ShareHistoryDetails> getShareHistory(Integer shareId) {
		List<ShareHistoryDetails> shareHistory = shareHistoryRepo.getShareHistory(shareId);
		if (shareHistory.size() != 0) {
			return shareHistory;
		} else {
			return new ArrayList<ShareHistoryDetails>();
		}
	}


	// get share certificate...................
	public Map<String, Object> getShareCertificate(Integer pageNumber, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNumber, pageSize);
		Page<ShareCertificateDetails> shareCertificate = shareCertificateRepo.getShareCertificate(paging);

		Map<String, Object> shareMap = new HashMap<String, Object>(); // it not good to add different type object into
																		// single hashmap instead create POJO Class.

		if (shareCertificate.hasContent()) {
			shareMap.put("pageSize", shareCertificate.getSize());
			shareMap.put("totalElement", shareCertificate.getTotalElements());
			shareMap.put("totalPage", shareCertificate.getTotalPages());
			shareMap.put("ShareCertificate", shareCertificate.getContent());
			return shareMap;
		} else {
			return shareMap;
		}
	}

	// get staff acl...................
	public List<AclDetails> getStaffAcl(Integer Id) {
		List<AclDetails> staffAcl = aclRepo.getStsffAcl(Id);
		if (staffAcl.size() != 0) {
			return staffAcl;
		} else {
			return new ArrayList<AclDetails>();
		}
	}

	// get staff acl document...................
	public List<AclDetails> getStaffAclDocument(Integer Id) {
		List<AclDetails> staffAcl = aclRepo.getStaffAclDocument(Id);
		if (staffAcl.size() != 0) {
			return staffAcl;
		} else {
			return new ArrayList<AclDetails>();
		}
	}

	// get staff acl document...................
	public List<AclDocumentDetail> getAclDocument() {
		List<AclDocumentDetail> aclDocument = documentRepo.getDocument();
		if (aclDocument.size() != 0) {
			return aclDocument;
		} else {
			return new ArrayList<AclDocumentDetail>();
		}
	}

	// Update share certificate...................
	public void updateShareCertificateDetails(ShareCertificateDetails scd) {

		ShareCertificate shareCertificate = shareCertificateRepo.getOne(scd.getId());
		shareCertificate.setName(scd.getName());
		shareCertificate.setStatus(scd.getStatus());
		shareCertificate.setCreatedAt(DateFormater.gettDate(scd.getCreatedAt()));
		shareCertificate.setSubmittedAt(DateFormater.gettDate(scd.getSubmittedAt()));
		shareCertificateRepo.save(shareCertificate);
	}

	// add share certificate...................
	public void addShareCertificateDetails(ShareCertificateDetails scd) {
		ShareCertificate shareCertificate = new ShareCertificate();
		shareCertificate.setName(scd.getName());
		shareCertificate.setStatus(scd.getStatus());
		shareCertificate.setCreatedAt(DateFormater.gettDate(scd.getCreatedAt()));
		shareCertificate.setSubmittedAt(DateFormater.gettDate(scd.getSubmittedAt()));
		shareCertificateRepo.save(shareCertificate);
	}

	// Update share ....................................................................................................
	public String updateShareDetails(ShareDetails sd) {
		try {
			Share share = shareRepository.getOne(sd.getId());
			share.setBuybackLockingMonths(sd.getBuybackLockingMonths());
			share.setStatus(sd.getStatus());
			share.setNo(sd.getNo());
			share.setTransferLockingMonths(sd.getTransferLockingMonths());
			share.setShareCertificateId(sd.getShareCertificateId());
			share.setCurrentMemberId(sd.getMemberId());
			shareRepository.save(share);
		} catch (Exception e) {
			return "Try again sometimes" + e;
		}
		return "Sucessfully Updated";
	}

	// add share ...................
	public String addShareDetails(ShareDetails sd) {
		try {
			Share share = new Share();
			share.setCurrentMemberId(sd.getMemberId());
			share.setBuybackLockingMonths(sd.getBuybackLockingMonths());
			share.setStatus(sd.getStatus());
			share.setNo(sd.getNo());
			share.setTransferLockingMonths(sd.getTransferLockingMonths());
			share.setShareCertificateId(sd.getShareCertificateId());
			shareRepository.save(share);
		}

		catch (Exception e) {
			return "Try again sometimes" + e;
		}
		return "Sucessfully Added";

	}

	// get all memeber for share add and update
	// dropdown...................................
	public List<MeberDetail> getMember(String memberName) {
		List<MeberDetail> accounts = memebrRepo.getMember(memberName);
		if (accounts.size() != 0) {
			return accounts;
		} else {
			return new ArrayList<MeberDetail>();
		}

	}

	// get all share certificate for share add and update
	// dropdown...................................
	public List<ShareCertificateDetail> getShareCertificate(Integer name) {
		List<ShareCertificateDetail> sharecertificate = sharecertificateRepo.getShareCertificate(name);
		if (sharecertificate.size() != 0) {
			return sharecertificate;
		} else {
			return new ArrayList<ShareCertificateDetail>();
		}

	}

	// Update Staff Acl....
	public void updateAclStaff(AclDetails acld) {
		Acls acl = aclRepo.getOne(acld.getId());

		acl.setAllowAdd(acld.getAllowAdd());
		acl.setAllowDel(acld.getAllowDel());
		acl.setAllowEdit(acld.getAllowEdit());
		acl.setCanView(acld.getCanView());
		acl.setIsAllBranchAllowed(acld.getIsAllBranchAllowed());
		acl.setClass_(acld.getClass_());

		aclRepo.save(acl);

	}

	// Get Staff Acl report....
	public List<AclReportDetails> getStaffAclReport(Integer id) {
		List<AclReportDetails> staffAclReport = aclReportRepo.getStaffAclReport(id);
		if (staffAclReport.size() != 0) {
			return staffAclReport;
		} else {
			return new ArrayList<AclReportDetails>();
		}
	}

	// Update Staff Acl report....
	public void updateAclStaffReport(AclReportDetails ard) {
		StaffReportAcl sra = aclReportRepo.getOne(ard.getId());

		sra.setIsAllowed(ard.getIsAllowed());
		sra.setPage(ard.getPage());

		aclReportRepo.save(sra);
	}

	// new api

	// Update active staff....
	public void updateActiveStaff(Staffs staffs) {
		staffs.setIsActive(true);
		staffRepo.save(staffs);
	}

	// Add active staff....
	public void addActiveStaff(Staffs staffs) {
		Date date = new Date();
		staffs.setCreatedAt(DateFormater.getformatDate(date));
		staffs.setIsActive(true);
		staffRepo.save(staffs);
	}

	// Delete active staff....
	public String deleteActiveStaff(Integer id) {
		try {
			staffRepo.deleteById(id);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";
	}

	// Update Inactive staff....
	public void updateInactiveStaff(Staffs staffs) {
		staffs.setIsActive(false);
		staffRepo.save(staffs);
	}

	// Add Inactive staff.....................
	public void addInactiveStaff(Staffs staffs) {
		staffs.setIsActive(false);
		staffRepo.save(staffs);
	}

	// Delete Inactive staff....
	public String deleteInactiveStaff(Integer id) {
		try {
			staffRepo.deleteById(id);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";
	}

	// Add Balance sheet....
	public void addBalanceSheet(BalanceSheetReq balanceSheet) {

		BalanceSheet balSheet = new BalanceSheet();
		balSheet.setName(balanceSheet.getName());
		balSheet.setPositiveSide(balanceSheet.getPositiveSide());
		balSheet.setOrderOfBalanceSheet(balanceSheet.getOrderOfBalanceSheet());
		balSheet.setIsPandl((byte) (balanceSheet.getIsPandl() ? 1 : 0));
		balSheet.setShowSub(balanceSheet.getShowSub());
		balSheet.setSubtractFrom(balanceSheet.getSubtractFrom());
		topHeadBalSheetRepo.save(balSheet);
	}

	// Delete Balance Sheet....
	public String deleteBalanceSheet(Integer id) {
		try {
			topHeadBalSheetRepo.deleteById(id);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}

		return "Item Deleted Successfully";
	}

	// Add Agents Cadres....................................................................................
	public void addAgentCadres(Cadres cadres) {
		agenetCadreRepo.save(cadres);
	}

	// Delete Agents Cadres....
	public String deleteAgentCadres(Integer id) {
		try {
			agenetCadreRepo.deleteById(id);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";
	}

	// Add content files
	public void addcontentMangement(ContentFiles contentFiles) {
		contentMnagementRepo.save(contentFiles);
	}

	// update content files
	public void updatecontentMangement(ContentFiles contentFiles) {
		contentMnagementRepo.save(contentFiles);
	}

	// Delete content files
	public String deletecontentMangement(Integer id) {
		try {
			contentMnagementRepo.deleteById(id);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";
	}

	// get preview active and inactive staff....................
	public StaffPreviewDetail getStaffPreview(Integer id) {
		StaffPreviewDetail staffs = staffRepo.getStaff(id);
		return staffs;
	}

	// in activated the active staff....................
	public String inActivatedTheStaff(Integer id) {
		Staffs staffs = staffRepo.getOne(id);
		staffs.setIsActive(false);
		staffRepo.save(staffs);
		return "Successfully In Activated the Staff";
	}

	// activated the inactive staff.......................
	public String activatedTheStaff(Integer id) {
		Staffs staffs = staffRepo.getOne(id);
		staffs.setIsActive(true);
		staffRepo.save(staffs);
		return "Successfully Activated the Staff";
	}

	// Add acl staff data....
	public void addAclStaff(AclDetails acld) {
		Acls acl = new Acls();
		Staffs staffs = staffRepo.getOne(acld.getStaffId());
		acl.setStaffs(staffs);
		acl.setAllowAdd(acld.getAllowAdd());
		acl.setAllowDel(acld.getAllowDel());
		acl.setAllowEdit(acld.getAllowEdit());
		acl.setCanView(acld.getCanView());
		acl.setIsAllBranchAllowed(acld.getIsAllBranchAllowed());
		acl.setClass_(acld.getClass_());

		aclRepo.save(acl);

	}

	// Delete Acl staff report....
	public String deleteAclStaffReport(Integer acld) {
		try {
			aclReportRepo.deleteById(acld);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";
	}

	// Delete Acl document
	public String deleteAclDocument(Integer acld) {

		try {
			aclRepo.deleteById(acld);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";

	}

	// Delete Acl staff data....
	public String deleteAclStaff(Integer acld) {
		try {
			aclRepo.deleteById(acld);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";
	}

	// Add acl documemnt....
	public void addDocumentAcl(AclDetails acld) {
		Acls acl = new Acls();
		Staffs staffs = staffRepo.getOne(acld.getStaffId());
		acl.setStaffs(staffs);
		acl.setAllowDel(acld.getAllowDel());
		acl.setAllowEdit(acld.getAllowEdit());
		acl.setClass_(acld.getClass_());
		acl.setDocumentsId(acld.getDocumentId());
		aclRepo.save(acl);
	}

	// update acl documemnt....
	public void updateDocumentAcl(AclDetails acld) {
		Acls acl = new Acls();
		Staffs staffs = staffRepo.getOne(acld.getStaffId());
		acl.setStaffs(staffs);
		acl = aclRepo.getOne(acld.getId());
		acl.setAllowDel(acld.getAllowDel());
		acl.setAllowEdit(acld.getAllowEdit());
		acl.setDocumentsId(acld.getDocumentId());
		aclRepo.save(acl);

	}

	// get all document...................
	public List<Documents> allDocumentACl() {
		List<Documents> aclDocument = aclDocumentRepo.findAll();
		if (aclDocument.size() != 0) {
			return aclDocument;
		} else {
			return new ArrayList<Documents>();
		}

	}
	
	
	// add schema ....
	public void addSchemes(Schemes schema) {
		Schemes scheme = new Schemes();
		scheme = schemaRepo.save(schema);		
	}
	

	// add schema for CC and LOAN....
	public void addSchemaLOAN(Schemes scheme) {
		Schemes schema = new Schemes();
		schema = schemaRepo.save(scheme);
		
			String[] arr = {"Interest Received On", "Pre Interest Received On", "Penal Interest Received On", "Time Over Interest On"};  
			//String[] arr1 = {"Interest Received On", "Processing Fee Received On", "Penalty Due To Late Payment On", "For Close Account On", "Time Over Charge On", "Conveyence Charge Received On", "Rent Charge Received On","Legal Charge Received On"};  
			
			List<BranchDetail> branches = branchesRepository.getTotalBranches();
			for (BranchDetail b : branches) {
				
				Integer memberId = memebrRepo.getDefaultBranchMember(b.getId());
				for(int i = 0 ; i < arr.length; i++) {
					
					//Creating accounts
					Accounts accounts = new Accounts();
					accounts.setAccountNumber(b.getCode() + " " + arr[i] + " " + scheme.getName());
					accounts.setAmount(0.0);
					accounts.setMemberId(memberId);
					accounts.setSchemeId(14);
					accounts.setBranchId(b.getId());
					accounts.setActiveStatus(true);
					accounts.setAccountType("Loan");
					accounts.setModeOfOperation("Self");
					accounts.setNewOrRenew("New");
					accounts.setRepaymentMode("Cash");
					Date date = new Date();
					accounts.setCreatedAt(date);
					accounts.setLastCurrentInterestUpdatedAt(date);
					accounts.setStaffId(1);
					accounts.setPandLgroup(arr[i]);
					accounts.setGroupType(arr[i]);
					accounts.setDealerId(0);
					accounts.setIsDirty((byte) 0);
					accounts.setBikeSurrendered((byte) 0);
					accounts.setIsInLegal((byte) 0);
					accounts.setInsuranceTenure(" ");
					accounts.setBankAccountLimit(0);
					accountsRepo.save(accounts);

				}
			}
		}
	
	// add schema for CC and LOAN....
	public void addSchemaCC(Schemes scheme) {
		Schemes schema = new Schemes();
		schema = schemaRepo.save(scheme);
		
			String[] arr = {"Interest Received On", "Processing Fee Received On", "Renewal Charges Received On", "CC Overdue Charges Received On"};  
			//String[] arr1 = {"Interest Received On", "Processing Fee Received On", "Penalty Due To Late Payment On", "For Close Account On", "Time Over Charge On", "Conveyence Charge Received On", "Rent Charge Received On","Legal Charge Received On"};  
			
			List<BranchDetail> branches = branchesRepository.getTotalBranches();
			for (BranchDetail b : branches) {
				
				Integer memberId = memebrRepo.getDefaultBranchMember(b.getId());
				for(int i = 0 ; i < arr.length; i++) {
					
					//Creating accounts
					Accounts accounts = new Accounts();
					accounts.setAccountNumber(b.getCode() + " " + arr[i] + " " + scheme.getName());
					accounts.setAmount(0.0);
					accounts.setMemberId(memberId);
					accounts.setSchemeId(14);
					accounts.setBranchId(b.getId());
					accounts.setActiveStatus(true);
					accounts.setAccountType("Loan");
					accounts.setModeOfOperation("Self");
					accounts.setNewOrRenew("New");
					accounts.setRepaymentMode("Cash");
					Date date = new Date();
					accounts.setCreatedAt(date);
					accounts.setLastCurrentInterestUpdatedAt(date);
					accounts.setStaffId(1);
					accounts.setPandLgroup(arr[i]);
					accounts.setGroupType(arr[i]);
					accounts.setDealerId(0);
					accounts.setIsDirty((byte) 0);
					accounts.setBikeSurrendered((byte) 0);
					accounts.setIsInLegal((byte) 0);
					accounts.setInsuranceTenure(" ");
					accounts.setBankAccountLimit(0);
					accountsRepo.save(accounts);

				}
			}
		}
			


	// update schema ....
	public Schemes updateSchemes(Schemes scheme) {
		Schemes schema = null;
		try {
			schema = schemaRepo.save(scheme);
		} catch (Exception e) {
			return new Schemes();
		}
		return schema;
	}

	// Delete scheme ....
	public String deleteSchema(Integer id) {
		
		Integer accountCount = accountsRepo.getAccountCount(id);
		System.out.println(accountCount);
		
		if(accountCount > 0) {
			System.out.println("Scheme Contains Accounts created under this, cannot delete");
			return "Scheme Contains Accounts created under this, cannot delete";
		}
		
		Integer transactionCount = accountsRepo.getTransactionCount(id);
		
		if(transactionCount > 0) {
			System.out.println( "Account Contains Transactions, Cannot Delete");
			return  "Account Contains Transactions, Cannot Delete";
		}
		
		Schemes schemes = schemaRepo.findById(id).get();
		System.out.println(schemes.getName());
		List<BranchDetail> branch = branchesRepository.getTotalBranches();
		System.out.println(branch.size());
		
		for(BranchDetail bDetail: branch) {
			List<Accounts> accountIds = accountsRepo.getSchemeDefaultAccounts(schemes.getName(), bDetail.getCode());
			accountsRepo.deleteAll(accountIds);
		}
			schemaRepo.deleteById(id);
		return "Scheme Deleted Successfully";
	}

	// Delete share certificate staff....
	public String deleteShareCertificateDetails(Integer id) {
		try {
			shareCertificateRepo.deleteById(id);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";
	}

	// Delete share staff....
	public String deleteShareDetails(Integer id) {
		try {
			shareRepository.deleteById(id);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";
	}

	// get active staff....................
		public List<Schemes> Schemes() {
			List<Schemes> schemas = schemaRepo.schemes();
			if (schemas.size() != 0) {
				return schemas;
			} else {
				return new ArrayList<Schemes>();
			}
		}
		
		// Get shareCertcate share....................................................................................................
		public List<ShareDetails> getShareCertificateShare(Integer id) {
			List<ShareDetails> shareDetails = shareRepository.getSharebyID(id);
			if (shareDetails.size() != 0) {
				return shareDetails;
			} else {
				return new ArrayList<ShareDetails>();
			}
		}

		//Add share history..........................................................................................................
		public void addShareHistory(ShareHistoryDetails shareHistoryDetails) {
			ShareHistory shareHistory = new ShareHistory();
			shareHistory.setMemberId(shareHistoryDetails.getMemberId());
			shareHistory.setShareCertificateId(shareHistoryDetails.getShareCertificateId());
			shareHistory.setFromDate(shareHistoryDetails.getFromDate());
			shareHistory.setFinalToDate(shareHistoryDetails.getFinalToDate());
			shareHistory.setShareId(shareHistoryDetails.getShareId());
			shareHistoryRepo.save(shareHistory);
		}

		//Edit share history........................................................................................................
		public void updateShareHistory(ShareHistoryDetails shareHistoryDetails) {
			ShareHistory shareHistory=shareHistoryRepo.getOne(shareHistoryDetails.getId());
			shareHistory.setMemberId(shareHistoryDetails.getMemberId());
			shareHistory.setShareCertificateId(shareHistoryDetails.getShareCertificateId());
			shareHistory.setFromDate(shareHistoryDetails.getFromDate());
			shareHistory.setFinalToDate(shareHistoryDetails.getFinalToDate());
			System.out.println(shareHistory);
			shareHistoryRepo.save(shareHistory);
		}

		public String deleteShareHistory(Integer id) {
			try {
				shareHistoryRepo.deleteById(id);
			} catch (Exception e) {
				return "Try again after sometime" + e;
			}
			return "Item Deleted Successfully";
		}

		public StaffModel getAccounts(Integer id) {
			StaffModel staffAccounts = accountsRepo.getStaffAccounts(id);
			return staffAccounts;
		}

		public StaffModel getTransactions(Integer id) {
			StaffModel staffTransactions= transactionsRepo.getTransactions(id);
			return staffTransactions;
		}


}
