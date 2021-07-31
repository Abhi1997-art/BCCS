package com.service.banking.controller;

import java.util.Date;
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

import com.service.banking.hibernateEntity.Dealers;
import com.service.banking.hibernateEntity.Dsa;
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
import com.service.banking.model.MadModel.iMemberInsuDetails;
import com.service.banking.model.accountsModel.AccountDetails;
import com.service.banking.model.hodAuthorityModel.MoRoDetails;
import com.service.banking.model.hodAuthorityModel.iCommentDetails;
import com.service.banking.model.superAdminModel.MeberDetail;
import com.service.banking.service.HodAuthorityService;
import com.service.banking.service.MadService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service
@RequestMapping("/service/mad")

public class MadController {

	@Autowired
	MadService madservice;

	//Get all members......................................................................................................
	@GetMapping("/members/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> getallMembers(@PathVariable("setFirstResult") Integer setFirstResult,
			@PathVariable("setMaxResults") Integer setMaxResults) {
		Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
		Map<String, Object> memeberList = madservice.getAllmember(setPageNumber, setMaxResults);																							
		return memeberList;
	}
	
	//Update MAD member................................................................................
	@PutMapping("/update_member")
	public void updateMembers(@RequestBody MemberDetails memberDetails) {
		madservice.updateMembers(memberDetails);
	}
	
	//Add MAD member..................................................................................
	@PostMapping("/add_member")
	public void addMembers(@RequestBody MemberDetails memberDetails) {
		madservice.addMembers(memberDetails);
	}
	
	//Update active of member of MAD...................................................................
	@PutMapping("/update_member/active/{id}")
	public void activeMember(@PathVariable("id") Integer id) {
		 madservice.activeMember(id);
	}
	
	//Update defaulter of member of MAD................................................................
	@PutMapping("/update_member/defaulter/{id}")
	public void defaulterMember(@PathVariable("id") Integer id) {
		madservice.defaulterMember(id);
	}
	
	//Comment MAD Member...............................................................................
	@PostMapping("/comment_member/{id}/{narration}")
	public void commentMember(@PathVariable("id") Integer id, @PathVariable("narration") String narration) {
		madservice.commentMember(id,narration);
	}
	
	@GetMapping("/comments")
	public List<iCommentDetails> getComments(@RequestParam Integer memberId) {
		List<iCommentDetails> comments = madservice.getComments(memberId);
		return comments;
	}
	
	//Delete MAD Member................................................................................
	@DeleteMapping("/delete_member/{id}")
	public void deleteMember(@PathVariable("id") Integer id) {
		madservice.deleteMember(id);
	}

	// Get all Agents of MAD............................................................................
	@GetMapping("/agents/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> getallAgents(@PathVariable("setFirstResult") Integer setFirstResult,
			@PathVariable("setMaxResults") Integer setMaxResults) {
		Integer setPageNumber = HodAuthorityService.pageNumberr(setFirstResult);
		Map<String, Object> agentsList = madservice.getallAgents(setPageNumber, setMaxResults);
		return agentsList;
	}

	//Add MAD agents..................................................................................
	@PostMapping("/add_agents")
	public void addAgents(@RequestBody AgentDetails agentDetails) {
		madservice.addAgents(agentDetails);
	}
	
	//Update MAD agents..................................................................................
	@PutMapping("/update_agents")
	public void updateAgents(@RequestBody AgentDetails agentDetails) {
		madservice.updateAgents(agentDetails);
	}
	
	//Delete MAD agents................................................................................
	@DeleteMapping("/delete_agents/{id}")
	public void deleteAgents(@PathVariable("id") Integer id) {
		madservice.deleteAgents(id);
	}
	
	// Get all dealers.................................................................................
	@GetMapping("/dealers")
	List<DealerDeatails> getallDealers() {
		List<DealerDeatails> dealers = madservice.getAllDelers();
		return dealers;
	}
	
	// Add dealers........................................................................................
	@PostMapping("/add_dealers")
	public void addDealers(@RequestBody Dealers dealers) {
		madservice.addDealers(dealers);
	}
	
	// Update dealers........................................................................................
	@PutMapping("/update_dealers")
	public void updateDealers(@RequestBody Dealers dealers) {
		madservice.updateDealers(dealers);
	}

	//Delete dealers....................................................................................
	@DeleteMapping("/delete_dealers/{id}")
	public String deleteDealers(@PathVariable("id") Integer id) {
		String msg = madservice.deleteDealers(id);
		return msg;
	}
	
	// get all DSA....................
	@GetMapping("/dsa")
	List<DsaDetails> getAllDsa() {
		List<DsaDetails> dsa = madservice.getAllDsa();// null check already in service....
		return dsa;
	}

	// Add DSA........................................................................................
	@PostMapping("/add_dsa")
	public void addDSA(@RequestBody Dsa dsa) {
		madservice.addDSA(dsa);
	}
	
	// Update DSA........................................................................................
	@PutMapping("/update_dsa")
	public void updateDSA(@RequestBody Dsa dsa) {
		madservice.updateDSA(dsa);
	}

	//Delete DSA....................................................................................
	@DeleteMapping("/delete_dsa/{id}")
	public String deleteDSA(@PathVariable("id") Integer id) {
		String msg = madservice.deleteDSA(id);
		return msg;
	}
	
	// get all member insurance....................
	@GetMapping("/members_insurance/{setFirstResult}/{setMaxResults}")
	public Map<String, Object> gaetAllMemInsurrence(@PathVariable("setFirstResult") Integer setFirstResult,
			@PathVariable("setMaxResults") Integer setMaxResults) {
		Map<String, Object> memeberList = madservice.getAllMemberInsuurence(setFirstResult, setMaxResults);																							
		return memeberList;
	}
	
	// Add Member Insurance........................................................................................
	@PostMapping("/add_member_insurance")
	public void addMemberInsurance(@RequestBody MemberInsurance memberInsurance) {
		madservice.addMemberInsurance(memberInsurance);
	}
	
	// Update Member Insurance........................................................................................
	@PutMapping("/update_member_insurance")
	public void updateMemberInsurance(@RequestBody MemberInsurance memberInsurance) {
		madservice.updateMemberInsurance(memberInsurance);
	}
	
	//Delete Member Insurance....................................................................................
	@DeleteMapping("/delete_member_insurance/{id}")
	public String deleteMemberInsurance(@PathVariable("id") Integer id) {
		String msg = madservice.deleteMemberInsurance(id);
		return msg;
	}
	
	// Get multiple member insurance....
	@GetMapping("/get_mul_member_insurance")
	List<iMemberInsuDetails> getMultipleInsurance(@RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String acType) {
		List<iMemberInsuDetails> memberInsuDetails = madservice.getMultipleInsurance(fromDate, toDate, acType);
		return memberInsuDetails;
	}

	// Update multiple member insurance in new/renew tab....
	@PostMapping("/new_renew_member_insurance")
	public void multipleMemberInsurance(@RequestBody MultipleMemberInsuranceDetails multipleMemberInsuranceDetails) {
		madservice.multipleMemberInsurance(multipleMemberInsuranceDetails);
	}
	
	
		
	

	// get all EMPLOYEE..............................................................................................
	@GetMapping("/employee")
	List<EmployeeDetails> getAllEmployee() {
		List<EmployeeDetails> emp = madservice.getAllEmployee();// null check already in service....
		return emp;
	}
	
	// Add active EMPLOYEE........................................................................................
	@PostMapping("/add_active_employee")
	public void addEmployee(@RequestBody XbankEmployees xbankEmployees) {
		madservice.addEmployee(xbankEmployees);
	}
	
	// Update active EMPLOYEE........................................................................................
	@PutMapping("/update_active_employee")
	public void updateEmployee(@RequestBody XbankEmployees xbankEmployees) {
		madservice.updateEmployee(xbankEmployees);
	}
	
	// Deactivate active EMPLOYEE........................................................................................
	@PutMapping("/deactivate_active_employee/{id}")
	public String deActivateEmployee(@PathVariable("id") Integer id) {
		String msg = madservice.deActivateEmployee(id);
		return msg;
	}
	

	//Delete active EMPLOYEE....................................................................................
	@DeleteMapping("/delete_employee/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		String msg = madservice.deleteEmployee(id);
		return msg;
	}
	
	// get all In active employee....................
	@GetMapping("/inactive_employee")
	List<EmployeeDetails> getInactiveEmployee() {
		List<EmployeeDetails> emp = madservice.getInactiveEmployee();// null check already in service....
		return emp;
	}
	
	// Add InActive EMPLOYEE........................................................................................
	@PostMapping("/add_inactive_employee")
	public void addInActiveEmployee(@RequestBody XbankEmployees xbankEmployees) {
		madservice.addInActiveEmployee(xbankEmployees);
	}
	
	// Update InActive EMPLOYEE........................................................................................
	@PutMapping("/update_inactive_employee")
	public void updateInActiveEmployee(@RequestBody XbankEmployees xbankEmployees) {
		madservice.updateInActiveEmployee(xbankEmployees);
	}
	
	// Activate InActive EMPLOYEE........................................................................................
	@PutMapping("/activate_active_employee/{id}")
	public String ActivateEmployee(@PathVariable("id") Integer id) {
		String msg = madservice.ActivateEmployee(id);
		return msg;
	}

	//Salary management for employement tab................................................................................
	@GetMapping("/salary_management")
	List<SalaryManagement> salaryManagement(@RequestBody SalaryManagementReq smReq) {
		List<SalaryManagement> emp = madservice.salaryManagement(smReq);// null check already in service....
		return emp;
	}

	// salary management for employeement tab....................
	@GetMapping("/salary_structure")
	List<SalaryManagement> salaryStruture(@RequestBody SalaryStructureReq smReq) {
		List<SalaryManagement> emp = madservice.salaryStruture(smReq);// null check already in service....
		return emp;
	}

	// employe for employeement tab for salary management....................
	@GetMapping("/all_employe")
	List<EmployeName> getEmloyee(@RequestParam("empName") String empName) {
		List<EmployeName> emp = madservice.getEmploye(empName);// null check already in service....
		return emp;
	}

	// get all employee name............................................................................................
	@GetMapping("/employeName")
	List<EmployeeDetails> getEmpName() {
		List<EmployeeDetails> emp = madservice.getEmployeName();// null check already in service....
		return emp;
	}
	
	//DROPDOWNS............................................................................................................................
	
	//Search for all MO for MAD - agent................................................................................
	@GetMapping("/mo_name")
	List<MoRoDetails> getMO(@RequestParam("moName") String moName) {
		List<MoRoDetails> allmo = madservice.getMO(moName); // null check already in service....
		System.out.println("**********" + allmo.size());
		return allmo;
	}
	
	//Search all member for MAD-Agent
	//SuperAdminController - getMember()
	
	//Drop-down for DSA for MAD - Dealer................................................................................
	@GetMapping("/dsa_name")
	List<DsaDetails> getDsa() {
		List<DsaDetails> alldsa = madservice.getDsa(); // null check already in service....
		System.out.println("**********" + alldsa.size());
		return alldsa;
	}
	
	//Search for sponsor name for MAD - Agent..............................................................................
	@GetMapping("/sponsor_name")
	List<MeberDetail> getSponsor(@RequestParam("sponsorName") String sponsorName) {
		List<MeberDetail> allsponsor = madservice.getSponsor(sponsorName); // null check already in service....
		System.out.println("**********" + allsponsor.size());
		return allsponsor;
	}
	
	//Search for saving account in MAD - Agent.............................................................................
	@GetMapping("/saving_name")
	List<AccountDetails> getSaving(@RequestParam("accountNumber") String accountNumber) {
		List<AccountDetails> allsaving = madservice.getSaving(accountNumber); // null check already in service....
		System.out.println("**********" + allsaving.size());
		return allsaving;
	}
	
	//Search for accounts in MAD - Member Insurance.............................................................................
	@GetMapping("/account_name")
	List<AccountDetails> getAllAccounts(@RequestParam("accountNumber") String accountNumber) {
		List<AccountDetails> allaccounts = madservice.getAllAccounts(accountNumber); // null check already in service....
		System.out.println("**********" + allaccounts.size());
		return allaccounts;
	}
	
	// get Agent Guarantors in Agent....................
		@GetMapping("/agents/agent_guarantor")
		public List<AgentGuarantorDetails> getAgentGuarantorInAgent(@RequestParam Integer id){
			return madservice.getAgentGuarantorInAgent(id);
		}
		
		// add Agent Guarantors in Agent........
		@PostMapping("/agents/add_agent_guarantor")
		public void addAgentGuarantorInAgent(@RequestParam Integer agentId, @RequestParam Integer memberId) {
			madservice.addAgentGuarantorInAgent(agentId, memberId);
		}
		
		// edit Agent Guarantors in Agent........
		@PutMapping("/agents/update_agent_guarantor")
		public void editAgentGuarantorInAgent(@RequestParam Integer id, @RequestParam Integer memberId) {
			madservice.editAgentGuarantorInAgent(id, memberId);
		}
		
		// delete Agent Guarantors in Agent........
		@DeleteMapping("/agents/delete_agent_guarantor/{id}")
		public String deleteAgentGuarantorInAgent(@PathVariable Integer id) {
			return madservice.deleteAgentGuarantorInAgent(id);
		}
		
		// get dsa guarantor............
		@GetMapping("/dsa/dsa_guarantor")
		public List<DsaGuarantorDetails> getDsaGuarantor(@RequestParam Integer id){
			return madservice.getDsaGuarantor(id);
		}
		
		// add dsa Guarantor of dsa.............
		@PostMapping("/dsa/add_dsa_guarantor")
		public void addDsaGuarantor(@RequestParam Integer dsId, @RequestParam Integer memberId) {
			madservice.addDsaGuarantor(dsId, memberId);
		}
		
		// edit dsa guarantor of dsa.............
		@PutMapping("/dsa/update_dsa_guarantor")
		public void updateDsaGuarantor(@RequestParam Integer id, @RequestParam Integer memberId) {
			madservice.updateDsaGuarantor(id, memberId);
		}
		
		// delete agentGuarantor associated with agent......
		@DeleteMapping("dsa/delete_dsa_guarantor/{id}")
		public String deleteDsaGuarantor(@PathVariable Integer id) {
			return madservice.deleteDsaGuarantor(id);
		}
		
		
}
