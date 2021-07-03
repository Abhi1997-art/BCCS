package com.service.banking.service;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.banking.hibernateEntity.Accounts;
import com.service.banking.hibernateEntity.AgentGuarantors;
import com.service.banking.hibernateEntity.Agents;
import com.service.banking.hibernateEntity.Branches;
import com.service.banking.hibernateEntity.Comment;
import com.service.banking.hibernateEntity.Dealers;
import com.service.banking.hibernateEntity.Dsa;
import com.service.banking.hibernateEntity.DsaGuarantors;
import com.service.banking.hibernateEntity.EmployeeSalaryRecord;
import com.service.banking.hibernateEntity.MemberInsurance;
import com.service.banking.hibernateEntity.Members;
import com.service.banking.hibernateEntity.XbankEmployees;
import com.service.banking.model.MadModel.AgentDetails;
import com.service.banking.model.MadModel.AgentGuarantorDetails;
import com.service.banking.model.MadModel.DealerDeatails;
import com.service.banking.model.MadModel.DsaDetails;
import com.service.banking.model.MadModel.DsaGuarantorDetails;
import com.service.banking.model.MadModel.EmployeName;
import com.service.banking.model.MadModel.EmployeeDetails;
import com.service.banking.model.MadModel.MemberDetails;
import com.service.banking.model.MadModel.MemberInsuDetails;
import com.service.banking.model.MadModel.MultipleMemberInsuranceDetails;
import com.service.banking.model.MadModel.SalaryManagement;
import com.service.banking.model.MadModel.SalaryManagementReq;
import com.service.banking.model.MadModel.SalaryStructureReq;
import com.service.banking.model.MadModel.TotalMember;
import com.service.banking.model.MadModel.iMemberInsuDetails;
import com.service.banking.model.accountsModel.AccountDetails;
import com.service.banking.model.hodAuthorityModel.MoRoDetails;
import com.service.banking.model.superAdminModel.MeberDetail;
import com.service.banking.repository.AccountsRepo.AccountsRepo;
import com.service.banking.repository.dashBoardRepo.AccountsOpenTodayRepo;
import com.service.banking.repository.hodAuthorityRepo.MoRoRepository;
import com.service.banking.repository.madRepository.AgentGuarantorRepo;
import com.service.banking.repository.madRepository.AgentsRepositoty;
import com.service.banking.repository.madRepository.CommentRepo;
import com.service.banking.repository.madRepository.DealerRepository;
import com.service.banking.repository.madRepository.DsaGuarantorRepo;
import com.service.banking.repository.madRepository.DsaRepository;
import com.service.banking.repository.madRepository.EmployeSalaryRepo;
import com.service.banking.repository.madRepository.EmployeeRepo;
import com.service.banking.repository.madRepository.MemberInsurrenceRepo;
import com.service.banking.repository.madRepository.MembersRepo;
import com.service.banking.utils.DateFormater;


@Service
public class MadService {

	@Autowired
	MembersRepo membersRepo;
	@Autowired
	AgentsRepositoty agentsRepo;
	@Autowired
	DealerRepository dealerRepo;
	@Autowired
	DsaRepository dsaRepo;
	@Autowired
	MemberInsurrenceRepo meminsuRepo;
	@Autowired
	EmployeeRepo empRepo;
	@Autowired
	EmployeSalaryRepo empsalaryRepo;
	@Autowired
	CommentRepo commentRepo;
	@Autowired
	AccountsRepo accRepo;
	@Autowired
	MoRoRepository moroRepo;
	@Autowired
	MembersRepo mRepo;
	@Autowired
	AgentGuarantorRepo agentGuarantorRepo;
	
	@Autowired
	DsaGuarantorRepo dsgRepo;


	//Get all members of MAD.....................................................................
	public Map<String, Object> getAllmember(int firstSet, int maxSize) {
		Pageable paging = PageRequest.of(firstSet, maxSize);
		Page<MemberDetails> memberList = membersRepo.getAllMembers(paging);
		Map<String, Object> members = new HashMap<String, Object>(); 
		if (memberList.hasContent()) {
			members.put("pageSize", memberList.getSize());
			members.put("totalElement", memberList.getTotalElements());
			members.put("totalPage", memberList.getTotalPages());
			members.put("ShareDetail", memberList.getContent());
			return members;
		} else {
			return members;
		}
	}
	
	//Update member of MAD........................................................................
	public void updateMembers(MemberDetails memberDetails) {
		Members members= membersRepo.getOne(memberDetails.getId());
		members.setBranchId(memberDetails.getBranchId());
		members.setTitle(memberDetails.getTitle());
		members.setName(memberDetails.getName());
		members.setFatherName(memberDetails.getFatherName());
		members.setRelationWithFatherField(memberDetails.getRelationWithFather());
		members.setCast(memberDetails.getCast());
		members.setLandmark(memberDetails.getLandmark());
		members.setTehsil(memberDetails.getTehsil());
		members.setCity(memberDetails.getCity());
		members.setState(memberDetails.getState());
		members.setDistrict(memberDetails.getDistrict());
		members.setPinCode(memberDetails.getPinCode());
		members.setCurrentAddress(memberDetails.getCurrentAddress());
		members.setOccupation(memberDetails.getOccupation());
		members.setPhoneNos(memberDetails.getPhoneNos());
		members.setDob(DateFormater.gettDate(memberDetails.getDob()));
		members.setPanNo(memberDetails.getPanNo());
		members.setAdharNumber(memberDetails.getAdharNumber());
		members.setGstin(memberDetails.getGstin());
		members.setBankbranchAId(memberDetails.getBankbranchAId());
		members.setBankbranchBId(memberDetails.getBankbranchBId());
		members.setBankAccountNumber1(memberDetails.getBankAccountNumber1());
		members.setBankAccountNumber2(memberDetails.getBankAccountNumber2());
		members.setMemebrType(memberDetails.getMemebrType());
		members.setWitness1name(memberDetails.getWitness1name());
		members.setWitness1fatherName(memberDetails.getWitness1fatherName());
		members.setWitness1address(memberDetails.getWitness1address());
		members.setWitness2name(memberDetails.getWitness2name());
		members.setWitness2fatherName(memberDetails.getWitness2fatherName());
		members.setWitness2address(memberDetails.getWitness2address());
		members.setIsActive(memberDetails.getIsActive());
		members.setMemberNo(memberDetails.getMemberNo());
		members.setUsername(memberDetails.getUsername());
		members.setPassword(memberDetails.getPassword());	
		membersRepo.save(members);
	}
	
	//Add MAD member..................................................................................
	public void addMembers(MemberDetails memberDetails) {
		Members members= new Members();
		members.setAccountNumber(memberDetails.getAccountNumber());
		members.setFilledForm60(memberDetails.getFilledForm60());
		members.setBranchId(memberDetails.getBranchId());
		members.setTitle(memberDetails.getTitle());
		members.setName(memberDetails.getName());
		members.setFatherName(memberDetails.getFatherName());
		members.setRelationWithFatherField(memberDetails.getRelationWithFather());
		members.setCast(memberDetails.getCast());
		members.setLandmark(memberDetails.getLandmark());
		members.setTehsil(memberDetails.getTehsil());
		members.setCity(memberDetails.getCity());
		members.setState(memberDetails.getState());
		members.setDistrict(memberDetails.getDistrict());
		members.setPinCode(memberDetails.getPinCode());
		members.setCurrentAddress(memberDetails.getCurrentAddress());
		members.setOccupation(memberDetails.getOccupation());
		members.setPhoneNos(memberDetails.getPhoneNos());
		members.setDob(DateFormater.gettDate(memberDetails.getDob()));
		members.setPanNo(memberDetails.getPanNo());
		members.setAdharNumber(memberDetails.getAdharNumber());
		members.setGstin(memberDetails.getGstin());
		members.setBankbranchAId(memberDetails.getBankbranchAId());
		members.setBankbranchBId(memberDetails.getBankbranchBId());
		members.setBankAccountNumber1(memberDetails.getBankAccountNumber1());
		members.setBankAccountNumber2(memberDetails.getBankAccountNumber2());
		members.setMemebrType(memberDetails.getMemebrType());
		members.setWitness1name(memberDetails.getWitness1name());
		members.setWitness1fatherName(memberDetails.getWitness1fatherName());
		members.setWitness1address(memberDetails.getWitness1address());
		members.setWitness2name(memberDetails.getWitness2name());
		members.setWitness2fatherName(memberDetails.getWitness2fatherName());
		members.setWitness2address(memberDetails.getWitness2address());
		members.setIsActive(memberDetails.getIsActive());
		members.setUsername(memberDetails.getUsername());
		members.setPassword(memberDetails.getPassword());	
		membersRepo.save(members);
		
	}

	//Update active of member of MAD................................................................
	public boolean activeMember(Integer id) {
		Members members = membersRepo.getOne(id);
		members.setIsActive((boolean)(members.getIsActive() == false ? true : false ));
		membersRepo.save(members);
		return members.getIsActive();
	}
	
	//Update defaulter of member of MAD................................................................
	public MemberDetails defaulterMember(Integer id) {
		Members members = membersRepo.getOne(id);
		MemberDetails memberDetails = new MemberDetails();
		if (members.getIsDefaulter() == false) {
			members.setIsDefaulter(true);
			Date date = new Date();
			members.setDefaulterOn(date);
			membersRepo.save(members);

			// Just for passing data in the controller..
			memberDetails.setDefaulterOn(DateFormater.getformatDate(date));
			memberDetails.setIsDefaulter(true);
		} else {
			members.setIsDefaulter(false);
			membersRepo.save(members);

			memberDetails.setIsDefaulter(false);
		}
		return memberDetails;
	}
	
	//Delete MAD Member................................................................................
	public String deleteMember(Integer id) {
		try {
			membersRepo.deleteById(id);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";
	}
	
	//Comment MAD Member...............................................................................
	public void commentMember(Integer id, String narration) {
		Members members = membersRepo.getOne(id);
		Comment comment = new Comment();
		comment.setMembers(members);
		comment.setNarration(narration);
		Date date = new Date();
		comment.setCreatedAt(date);
		comment.setUpdatedAt(date);
		commentRepo.save(comment);
	}
	

	// Get All Agents of MAD.............................................................................
	public Map<String, Object> getallAgents(int firstSet, int maxSize) {
		Pageable paging = PageRequest.of(firstSet, maxSize);
		Page<AgentDetails> agentsList = agentsRepo.getAllAgents(paging);
		Map<String, Object> agents = new HashMap<String, Object>(); 
		if (agentsList.hasContent()) {
			agents.put("pageSize", agentsList.getSize());
			agents.put("totalElement", agentsList.getTotalElements());
			agents.put("totalPage", agentsList.getTotalPages());
			agents.put("ShareDetail", agentsList.getContent());
			return agents;
		} else {
			return agents;
		}
	}
	
	//Add MAD agents..................................................................................
	public void addAgents(AgentDetails agentDetails) {
		Agents agents=new Agents();
		agents.setMoId(agentDetails.getModId());
		agents.setMemberId(agentDetails.getMemberId());
		agents.setSponsorId(agentDetails.getSponsorId());
		agents.setAccountId(agentDetails.getAccountId());
		agents.setCadreId(agentDetails.getCadreId());
		agents.setUsername(agentDetails.getUserName());
		agents.setPassword(agentDetails.getPassword());
		agents.setCodeNo(agentDetails.getCodeNo());
		agents.setAddedBy(agentDetails.getAddedBy());
		agents.setActiveStatus(agentDetails.getActiveStatus());
		agentsRepo.save(agents);	
	}
	
	//Update MAD agents..................................................................................
	public void updateAgents(AgentDetails agentDetails) {
		Agents agents=agentsRepo.getOne(agentDetails.getId());
		agents.setMoId(agentDetails.getModId());
		agents.setSponsorId(agentDetails.getSponsorId());
		agents.setAccountId(agentDetails.getAccountId());
		agents.setCadreId(agentDetails.getCadreId());
		agents.setUsername(agentDetails.getUserName());
		agents.setPassword(agentDetails.getPassword());
		agents.setCodeNo(agentDetails.getCodeNo());
		agents.setAddedBy(agentDetails.getAddedBy());
		agents.setActiveStatus(agentDetails.getActiveStatus());
		agentsRepo.save(agents);		
	}

	//Delete MAD Member................................................................................
	public String deleteAgents(Integer id) {
		try {
			agentsRepo.deleteById(id);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";
	}

	
	// get all dealers of mad .....................................................
	public List<DealerDeatails> getAllDelers() {
		List<DealerDeatails> dealers = dealerRepo.getAllDealers();
		if (dealers.size() != 0) {
			System.out.println("*********" + dealers.size());
			return dealers;
		} else {
			return new ArrayList<DealerDeatails>();
		}
	}

	// get all dsa of mad .....................................................
	public List<DsaDetails> getAllDsa() {
		List<DsaDetails> dsa = dsaRepo.getAlldsa();
		if (dsa.size() != 0) {
			System.out.println("*********" + dsa.size());
			return dsa;
		} else {
			return new ArrayList<DsaDetails>();
		}
	}

	// Get all member insurance of mad.....................................................
	public Map<String, Object> getAllMemberInsuurence(int firstSet, int maxSize) {
		Pageable paging = PageRequest.of(firstSet, maxSize);
		Page<MemberInsuDetails> memberList = meminsuRepo.getAllMemInsurrence(paging);
		Map<String, Object> members = new HashMap<String, Object>(); 
		if (memberList.hasContent()) {
			members.put("pageSize", memberList.getSize());
			members.put("totalElement", memberList.getTotalElements());
			members.put("totalPage", memberList.getTotalPages());
			members.put("ShareDetail", memberList.getContent());
			return members;
		} else {
			return members;
		}
	}
	

	// get employee of mad ....................................................
	public List<EmployeeDetails> getAllEmployee() {
		List<EmployeeDetails> emp = empRepo.getAllEmployee();
		if (emp.size() != 0) {
			System.out.println("*********" + emp.size());
			return emp;
		} else {
			return new ArrayList<EmployeeDetails>();
		}
	}

	// get inactive employeee of mad
	// ....................................................
	public List<EmployeeDetails> getInactiveEmployee() {
		List<EmployeeDetails> emp = empRepo.getinactiveEmployee();
		if (emp.size() != 0) {
			System.out.println("*********" + emp.size());
			return emp;
		} else {
			return new ArrayList<EmployeeDetails>();
		}
	}

	// Get salary management employee of mad ...................................................................................
	public List<SalaryManagement> salaryManagement(SalaryManagementReq smReq) {
		List<SalaryManagement> emp = empsalaryRepo.salaryManagement(smReq.getBranchId(), smReq.getMonth(), smReq.getYear(), smReq.getEmpId());
		if (emp.size() != 0) {
			System.out.println("****" + emp.size());
			return emp;
		} else {
			return new ArrayList<SalaryManagement>();
		}
	}

	// get salary management employeee of mad .........................
	public List<SalaryManagement> salaryStruture(SalaryStructureReq smReq) {
		List<SalaryManagement> emp = empsalaryRepo.salaryStructure(smReq.getMonth(), smReq.getYear());
		if (emp.size() != 0) {
			System.out.println("****" + emp.size());
			return emp;
		} else {
			return new ArrayList<SalaryManagement>();
		}
	}

	// get employeee name of mad
	// ....................................................
	public List<EmployeeDetails> getEmployeName() {
		List<EmployeeDetails> nameList = empRepo.findByPlaceContaining();
		if (nameList.size() != 0) {
			System.out.println("*********" + nameList.size());
			return nameList;
		} else {
			return new ArrayList<EmployeeDetails>();
		}
	}

	// get all employee for employement dropdown...................................
	public List<EmployeName> getEmploye(String empName) {
		List<EmployeName> accounts = empRepo.getEmployee(empName);
		if (accounts.size() != 0) {
			return accounts;
		} else {
			return new ArrayList<EmployeName>();
		}
	}

	// Add dealers........................................................................................
	public void addDealers(Dealers dealers) {
		dealerRepo.save(dealers);
	}

	//Update dealers......................................................................................
	public void updateDealers(Dealers dealers) {
		dealerRepo.save(dealers);
	}

	//Delete dealers......................................................................................
	public String deleteDealers(Integer id) {
		try {
			dealerRepo.deleteById(id);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";
		
	}

	// Add DSA........................................................................................
	public void addDSA(Dsa dsa) {
		dsaRepo.save(dsa);
	}

	//Update DSA......................................................................................
	public void updateDSA(Dsa dsa) {
		dsaRepo.save(dsa);
	}

	//Delete DSA.......................................................................................
	public String deleteDSA(Integer id) {
		try {
			dsaRepo.deleteById(id);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";
		
	}

	// Add Member Insurance........................................................................................
	public void addMemberInsurance(MemberInsurance memberIns) {
		MemberInsurance memberInsurance = new MemberInsurance();
		memberInsurance.setAccountsId(memberIns.getAccountsId());
		memberInsurance.setInsuranceDuration(memberIns.getInsuranceDuration());
		memberInsurance.setInsuranceStartDate(memberIns.getInsuranceStartDate());
		memberInsurance.setNarration(memberIns.getNarration());
		memberInsurance.setName(memberIns.getName());
		memberInsurance.setMemberId(accRepo.getMemberId(memberIns.getAccountsId()));
		
		Calendar calender=Calendar.getInstance();
		calender.setTime(memberIns.getInsuranceStartDate());
		calender.add(Calendar.YEAR, memberIns.getInsuranceDuration());
		Date nextInsuranceDueDate=calender.getTime();
		memberInsurance.setNextInsuranceDueDate(nextInsuranceDueDate);
		
		meminsuRepo.save(memberInsurance);
	}

	// Update Member Insurance........................................................................................
	public void updateMemberInsurance(MemberInsurance memberIns) {
		MemberInsurance memberInsurance = meminsuRepo.getOne(memberIns.getId());
		memberInsurance.setAccountsId(memberIns.getAccountsId());
		memberInsurance.setInsuranceDuration(memberIns.getInsuranceDuration());
		memberInsurance.setInsuranceStartDate(memberIns.getInsuranceStartDate());
		memberInsurance.setNarration(memberIns.getNarration());
		memberInsurance.setName(memberIns.getName());
		memberInsurance.setMemberId(accRepo.getMemberId(memberIns.getAccountsId()));
		
		Calendar calender=Calendar.getInstance();
		calender.setTime(memberIns.getInsuranceStartDate());
		calender.add(Calendar.YEAR, memberIns.getInsuranceDuration());
		Date nextInsuranceDueDate=calender.getTime();
		memberInsurance.setNextInsuranceDueDate(nextInsuranceDueDate);
		
		meminsuRepo.save(memberInsurance);	
	}

	// Delete Member Insurance........................................................................................
	public String deleteMemberInsurance(Integer id) {
		try {
			meminsuRepo.deleteById(id);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";
	}

	//Add Active Employee.........................................................................................
	public void addEmployee(XbankEmployees xbankEmployees) {
		xbankEmployees.setIsActive(true);
		empRepo.save(xbankEmployees);
		
	}

	//Update Active Employee.........................................................................................
	public void updateEmployee(XbankEmployees xbankEmployees) {
		xbankEmployees.setIsActive(true);
		empRepo.save(xbankEmployees);
		
	}

	//Delete Employee.........................................................................................
	public String deleteEmployee(Integer id) {
		try {
			empRepo.deleteById(id);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";
	}
	
	//Add InActive Employee.........................................................................................
	public void addInActiveEmployee(XbankEmployees xbankEmployees) {
		xbankEmployees.setIsActive(false);
		empRepo.save(xbankEmployees);
		
	}

	//Update InActive Employee.........................................................................................
	public void updateInActiveEmployee(XbankEmployees xbankEmployees) {
		xbankEmployees.setIsActive(false);
		empRepo.save(xbankEmployees);	
	}

	//DeActivate Employee.........................................................................................
	public String deActivateEmployee(Integer id) {
		XbankEmployees xbankEmployees = empRepo.getOne(id);
		xbankEmployees.setIsActive(false);
		empRepo.save(xbankEmployees);
		return "Deactivated Successfully";
	}

	//Activate Employee.........................................................................................
	public String ActivateEmployee(Integer id) {
		XbankEmployees xbankEmployees = empRepo.getOne(id);
		xbankEmployees.setIsActive(true);
		empRepo.save(xbankEmployees);
		return "Activated Successfully";
	}
	
	
	//DROPDOWN.....................................................................................................
	public List<MoRoDetails> getMO(String moName) {
		List<MoRoDetails> list = moroRepo.getMo(moName);
		if (list.size() != 0) {
			return list;
		} else {
			return new ArrayList<MoRoDetails>();
		}

	}

	public List<DsaDetails> getDsa() {
		List<DsaDetails> list = dsaRepo.getDsa();
		if (list.size() != 0) {
			return list;
		} else {
			return new ArrayList<DsaDetails>();
		}
	}

	//Search for sponsor name for MAD - Agent..............................................................................
	public List<MeberDetail> getSponsor(String sponsorName) {
		List<MeberDetail> list = mRepo.getSponsor(sponsorName);
		if (list.size() != 0) {
			return list;
		} else {
			return new ArrayList<MeberDetail>();
		}
	}

	//Search for saving account in MAD - Agent.............................................................................
	public List<AccountDetails> getSaving(String accountNumber) {
		List<AccountDetails> list = accRepo.getSaving(accountNumber);
		if (list.size() != 0) {
			return list;
		} else {
			return new ArrayList<AccountDetails>();
		}
	}
		
		//Search for accounts in MAD - Agent.............................................................................
		public List<AccountDetails> getAllAccounts(String accountNumber) {
			List<AccountDetails> list = accRepo.getAllAccounts(accountNumber);
			if (list.size() != 0) {
				return list;
			} else {
				return new ArrayList<AccountDetails>();
			}
	}

		// get agentGuarantor associated with agent................
	public List<AgentGuarantorDetails> getAgentGuarantorInAgent(Integer id) {
		List<AgentGuarantorDetails> list = agentsRepo.getAgentGuarantorInAgent(id);
		if(list.size() != 0) {
			return list;
		}
		else {
			return new ArrayList<AgentGuarantorDetails>();
		}
	}
	
	// add agentGuarantor associated with agent......
	public void addAgentGuarantorInAgent(Integer agentId, Integer memberId) {
		AgentGuarantors ag = new AgentGuarantors();
		Agents a = agentsRepo.getOne(agentId);
		Members m = membersRepo.getOne(memberId);
		ag.setAgents(a);
		ag.setMembers(m);
		agentGuarantorRepo.save(ag);
	}
	
	// edit agentGuarantor associated with agent......
	public void editAgentGuarantorInAgent(Integer id, Integer memberId) {
		AgentGuarantors ag = agentGuarantorRepo.getOne(id);
		Members m = membersRepo.getOne(memberId);
		ag.setMembers(m);
		agentGuarantorRepo.save(ag);
	}
		
	// delete agentGuarantor associated with agent......
	public String deleteAgentGuarantorInAgent(Integer id) {
		try {
			agentGuarantorRepo.deleteById(id);
		} catch (Exception e) {
			return "Try again after sometime" + e;
		}
		return "Item Deleted Successfully";
	}


	// get dsa guarantor of dsa...............
		public List<DsaGuarantorDetails> getDsaGuarantor(Integer id){
			List<DsaGuarantorDetails> dsaGuarantor = dsgRepo.getDsaGuarantor(id);
			if(dsaGuarantor.size() != 0) {
				return dsaGuarantor;
			}
			else {
				return new ArrayList<DsaGuarantorDetails>();
			}
		}
		
		// add dsa Guarantor of dsa.............
		public void addDsaGuarantor(Integer dsId, Integer memberId) {
			DsaGuarantors dsg = new DsaGuarantors();
			Members m = membersRepo.getOne(memberId);
			Dsa dsa = dsaRepo.getOne(dsId);
			dsg.setDsa(dsa);
			dsg.setMembers(m);
			dsgRepo.save(dsg);
		}
		
		// edit dsa guarantor of dsa............
		public void updateDsaGuarantor( Integer id,  Integer memberId) {
			DsaGuarantors dsg = dsgRepo.getOne(id);
			Members m = membersRepo.getOne(memberId);
			dsg.setMembers(m);
			dsgRepo.save(dsg);
		}
		
		// delete agentGuarantor associated with agent......
		public String deleteDsaGuarantor(Integer id) {
			try {
				dsgRepo.deleteById(id);
			} catch (Exception e) {
				return "Try again after sometime" + e;
			}
			return "Item Deleted Successfully";
		}

		public void multipleMemberInsurance(MultipleMemberInsuranceDetails multipleMemberInsuranceDetails) {
			for (Integer i : multipleMemberInsuranceDetails.getAccountsId()) {
				MemberInsurance memberInsurance = new MemberInsurance();
				memberInsurance.setAccountsId(i);
				memberInsurance.setInsuranceDuration(multipleMemberInsuranceDetails.getInsuranceDuration());
				memberInsurance.setInsuranceStartDate(multipleMemberInsuranceDetails.getInsuranceStartDate());
				memberInsurance.setNarration(multipleMemberInsuranceDetails.getNarration());
				memberInsurance.setName("-");
				memberInsurance.setMemberId(accRepo.getMemberId(i));

				Calendar calender = Calendar.getInstance();
				calender.setTime(multipleMemberInsuranceDetails.getInsuranceStartDate());
				calender.add(Calendar.YEAR, multipleMemberInsuranceDetails.getInsuranceDuration());
				Date nextInsuranceDueDate = calender.getTime();
				memberInsurance.setNextInsuranceDueDate(nextInsuranceDueDate);
				meminsuRepo.save(memberInsurance);
			}
		}

		public List<iMemberInsuDetails> getMultipleInsurance(String fromDate, String toDate, String acType) {
			Date date = new Date();
			String currentDate = DateFormater.getformatDate(date);
			List<iMemberInsuDetails> memberInsuDetails = accRepo.getMultipleInsurance(fromDate, toDate, acType,
					currentDate);
			if (memberInsuDetails.size() != 0) {
				return memberInsuDetails;
			} else {
				return new ArrayList<iMemberInsuDetails>();
			}
		}




	}
