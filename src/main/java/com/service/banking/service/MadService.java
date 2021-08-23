package com.service.banking.service;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.service.banking.model.transaction.DepositeDetails;
import com.service.banking.repository.superAdminRepo.BranchesRepository;
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
import com.service.banking.hibernateEntity.BankBranches;
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
import com.service.banking.model.MadModel.iBankBranchDetails;
import com.service.banking.model.MadModel.iMemberInsuDetails;
import com.service.banking.model.accountsModel.AccountDetails;
import com.service.banking.model.hodAuthorityModel.MoRoDetails;
import com.service.banking.model.hodAuthorityModel.iCommentDetails;
import com.service.banking.model.superAdminModel.MeberDetail;
import com.service.banking.repository.AccountsRepo.AccountsRepo;
import com.service.banking.repository.dashBoardRepo.AccountsOpenTodayRepo;
import com.service.banking.repository.hodAuthorityRepo.BankBranchRepo;
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
    @Autowired
    BankBranchRepo bankBranchRepo;
    @Autowired
    AccountsRepo accountsRepo;
    @Autowired
    BranchesRepository branchesRepository;
    @Autowired
    TransactionService transactionService;



    //Get all members of MAD.....................................................................
    public Map<String, Object> getAllmember(int setPageNumber, int maxSize, String search) {
        Pageable paging = PageRequest.of(setPageNumber, maxSize);
        Page<MemberDetails> memberList = membersRepo.getAllMembers(paging, search);
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
        Members members = membersRepo.getOne(memberDetails.getId());
        Date date = new Date();
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
        members.setUpdatedAt(date);
        membersRepo.save(members);
    }

    //Add MAD member..................................................................................
    public void addMembers(MemberDetails memberDetails) {
        Members members = new Members();
        Date date = new Date();
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
        members.setCreatedAt(date);
        members.setUpdatedAt(date);
        members.setParentMemberId(0);
        members.setIsDefaulter(false);

        Integer lastMemberNo = membersRepo.getLastMemberNo();
        Integer currentMemberNo = lastMemberNo + 1;
        members.setMemberNo(currentMemberNo);

        membersRepo.save(members);

        Members savedMembers = membersRepo.findById(members.getId()).get();
        savedMembers.setUsername(members.getId().toString());
        savedMembers.setPassword(members.getId().toString() + members.getMemberNo());

        //Member completely saved........................................................
        membersRepo.save(savedMembers);

        //Make transaction for new member...................................................
        AccountDetails accountDetailsFrom = new AccountDetails();
        if(memberDetails.debitAccount == null) {
            accountDetailsFrom = accountsRepo.getCashAccounts(memberDetails.getLoginBranch());
        }
        else {
            accountDetailsFrom = accountsRepo.getAccountInfoById(memberDetails.getDebitAccount());
        }
        System.out.println(accountDetailsFrom.getId());
        Branches branches = branchesRepository.getOne(memberDetails.loginBranch);
        String branchCode = branches.getCode();
        System.out.println(branchCode);

        Integer accountToId  = accountsRepo.getAdmissionAccounts(branchCode);
        System.out.println(accountToId);

        DepositeDetails depositeDetails = new DepositeDetails();
        depositeDetails.setStaffId(memberDetails.getStaffId());
        depositeDetails.setNarration("Member Registration Fee for " + savedMembers.getMemberNo());
        depositeDetails.setAmount(10.00);

        //Create transaction........................................
        transactionService.createTransactions(depositeDetails, accountDetailsFrom.getId(), accountToId, 3, accountToId, branches.getId());

    }

    //Update active of member of MAD................................................................
    public boolean activeMember(Integer id) {
        Members members = membersRepo.getOne(id);
        members.setIsActive((boolean) (members.getIsActive() == false ? true : false));
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

        try{
            Integer accounts = accountsRepo.findAccounts(id).size();
            Integer agents = agentsRepo.findAgents(id).size();
            if(accounts > 0){
                return "Cannot delete this Member, It contains Accounts !";
            }else {
                membersRepo.deleteById(id);
            }
            if(agents > 0){
                return "Cannot delete this Member, It contains Agents !";
            }else {
                membersRepo.deleteById(id);
            }
        }
        catch (Exception e){
            return ("Cannot Delete !");
        }

        return "Member Deleted Successfully";
    }

    //Comment ADD MAD Member...............................................................................
    public void addCommentMember(Integer id, String narration) {
        Members members = membersRepo.getOne(id);
        Comment comment = new Comment();
        comment.setMembers(members);
        comment.setNarration(narration);
        Date date = new Date();
        comment.setCreatedAt(date);
        comment.setUpdatedAt(date);
        commentRepo.save(comment);
    }

    //Comment EDIT MAD Member...............................................................................
    public void editCommentMember(Integer id, String narration) {
        Comment comment = commentRepo.getOne(id);
        comment.setNarration(narration);
        Date date = new Date();
        comment.setUpdatedAt(date);
        commentRepo.save(comment);
    }

    public void deleteComment(Integer id) {
        commentRepo.deleteById(id);
    }


    // Get All Agents of MAD.............................................................................
    public Map<String, Object> getallAgents(int setPageNumber, int maxSize, String search) {
        Pageable paging = PageRequest.of(setPageNumber, maxSize);
        Page<AgentDetails> agentsList = agentsRepo.getAllAgents(paging,search);
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
    public String addAgents(AgentDetails agentDetails) {
        Agents agents = new Agents();
        Date date = new Date();
        agents.setMoId(agentDetails.getMoId());

        Integer checkMember = agentsRepo.checkMember(agentDetails.getMemberId());

        if(checkMember != null){
            return "Agent already exist !! Code: BCCSAG" + checkMember;
        }

        agents.setMemberId(agentDetails.getMemberId());
        agents.setSponsorId(agentDetails.getSponsorId());
        agents.setAccountId(agentDetails.getAccountId());
        agents.setCadreId(agentDetails.getCadreId());
        agents.setUsername(agentDetails.getUserName());
        agents.setPassword(agentDetails.getPassword());
        Integer lastCodeNo = agentsRepo.getLastCodeNo();
        agents.setCodeNo(lastCodeNo+1);
        agents.setAddedBy(agentDetails.getAddedBy());
        agents.setActiveStatus(agentDetails.getActiveStatus());
        agents.setCreatedAt(date);
        agents.setUpdatedAt(date);
        agentsRepo.save(agents);

        Members members = membersRepo.findById(agentDetails.getMemberId()).get();
        members.setIsAgent(true);
        membersRepo.save(members);

        return "Agent added successfully";
    }

    //Update MAD agents..................................................................................
    public void updateAgents(AgentDetails agentDetails) {
        Agents agents = agentsRepo.getOne(agentDetails.getId());
        Date date = new Date();
        agents.setMoId(agentDetails.getMoId());
        agents.setSponsorId(agentDetails.getSponsorId());
        agents.setAccountId(agentDetails.getAccountId());
        agents.setCadreId(agentDetails.getCadreId());
        agents.setUsername(agentDetails.getUserName());
        agents.setPassword(agentDetails.getPassword());
        agents.setCodeNo(agentDetails.getCodeNo());
        agents.setAddedBy(agentDetails.getAddedBy());
        agents.setActiveStatus(agentDetails.getActiveStatus());
        agents.setUpdatedAt(date);
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
    public List<DealerDeatails> getAllDelers(String search) {
        List<DealerDeatails> dealers = dealerRepo.getAllDealers(search);
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
    public Map<String, Object> getAllMemberInsuurence(int setPageNumber, int maxSize, String search) {
        Pageable paging = PageRequest.of(setPageNumber, maxSize);
        Page<MemberInsuDetails> memberList = meminsuRepo.getAllMemInsurrence(paging, search);
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
    public List<EmployeeDetails> getAllEmployee(String search) {
        List<EmployeeDetails> emp = empRepo.getAllEmployee(search);
        if (emp.size() != 0) {
            System.out.println("*********" + emp.size());
            return emp;
        } else {
            return new ArrayList<EmployeeDetails>();
        }
    }

    // get inactive employeee of mad
    // ....................................................
    public List<EmployeeDetails> getInactiveEmployee(String search) {
        List<EmployeeDetails> emp = empRepo.getinactiveEmployee(search);
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
    public void addDealers(DealerDeatails dealers) {
        Dealers d = new Dealers();

        Dsa dsa = dsaRepo.findById(dealers.getDsid()).get();
        d.setDsa(dsa);

        d.setName(dealers.getName());
        d.setProperitorName(dealers.getProperitorName());
        d.setProperitorPhoneNo1(dealers.getProperitorPhoneNo1());
        d.setProperitorPhoneNo2(dealers.getProperitorPhoneNo2());
        d.setEmailId1(dealers.getEmailId1());
        d.setEmailId2(dealers.getEmailId2());
        d.setProduct(dealers.getProduct());
        d.setUsername(dealers.getUsername());
        d.setPassword(dealers.getPassword());
        d.setAddress(dealers.getAddress());
        d.setLoanPaneltyPerDay(dealers.getLoanPaneltyPerDay());
        d.setTimeOverCharge(dealers.getTimeOverCharge());
        d.setDealerMonthlyDate(dealers.getDealerMonthlyDate());
        d.setActiveStatus(dealers.getActiveStatus());
        dealerRepo.save(d);
    }

    //Update dealers......................................................................................
    public void updateDealers(DealerDeatails dealers) {
        Dealers d = dealerRepo.findById(dealers.getId()).get();

        Dsa dsa = dsaRepo.findById(dealers.getDsid()).get();
        d.setDsa(dsa);

        d.setName(dealers.getName());
        d.setProperitorName(dealers.getProperitorName());
        d.setProperitorPhoneNo1(dealers.getProperitorPhoneNo1());
        d.setProperitorPhoneNo2(dealers.getProperitorPhoneNo2());
        d.setEmailId1(dealers.getEmailId1());
        d.setEmailId2(dealers.getEmailId2());
        d.setProduct(dealers.getProduct());
        d.setUsername(dealers.getUsername());
        d.setPassword(dealers.getPassword());
        d.setAddress(dealers.getAddress());
        d.setLoanPaneltyPerDay(dealers.getLoanPaneltyPerDay());
        d.setTimeOverCharge(dealers.getTimeOverCharge());
        d.setDealerMonthlyDate(dealers.getDealerMonthlyDate());
        dealerRepo.save(d);
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
    public void addDSA(DsaDetails dsa) {
        Dsa d = new Dsa();
        d.setName(dsa.getName());
        d.setUsername(dsa.getUsername());
        d.setPassword(dsa.getPassword());
        d.setPhoneNo1(dsa.getPhoneNo1());
        d.setPhoneNo2(dsa.getPhoneNo2());
        d.setEmailId1(dsa.getEmailId1());
        d.setEmailId2(dsa.getEmailId2());

        Members members = membersRepo.findById(dsa.getMemberId()).get();
        d.setMembers(members);

        dsaRepo.save(d);
    }

    //Update DSA......................................................................................
    public void updateDSA(DsaDetails dsa) {
        Dsa d = dsaRepo.findById(dsa.getId()).get();
        d.setName(dsa.getName());
        d.setUsername(dsa.getUsername());
        d.setPassword(dsa.getPassword());
        d.setPhoneNo1(dsa.getPhoneNo1());
        d.setPhoneNo2(dsa.getPhoneNo2());
        d.setEmailId1(dsa.getEmailId1());
        d.setEmailId2(dsa.getEmailId2());

        Members members = membersRepo.findById(dsa.getMemberId()).get();
        d.setMembers(members);

        dsaRepo.save(d);
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
    public void addMemberInsurance(MemberInsuDetails memberIns) {
        MemberInsurance memberInsurance = new MemberInsurance();
        memberInsurance.setAccountsId(memberIns.getId());
        memberInsurance.setInsuranceDuration(memberIns.getInsuranceDuration());
        memberInsurance.setInsuranceStartDate(memberIns.getInsuranceStartDate());
        memberInsurance.setNarration(memberIns.getNarration());
        memberInsurance.setName(memberIns.getInsuranceName());
        memberInsurance.setMemberId(accRepo.getMemberId(memberIns.getId()));

        Calendar calender = Calendar.getInstance();
        calender.setTime(memberIns.getInsuranceStartDate());
        calender.add(Calendar.YEAR, memberIns.getInsuranceDuration());
        Date nextInsuranceDueDate = calender.getTime();
        memberInsurance.setNextInsuranceDueDate(nextInsuranceDueDate);

        meminsuRepo.save(memberInsurance);
    }

    // Update Member Insurance........................................................................................
    public void updateMemberInsurance(MemberInsuDetails memberIns) {
        MemberInsurance memberInsurance = meminsuRepo.getOne(memberIns.getInsuranceId());
        memberInsurance.setAccountsId(memberIns.getId());
        memberInsurance.setInsuranceDuration(memberIns.getInsuranceDuration());
        memberInsurance.setInsuranceStartDate(memberIns.getInsuranceStartDate());
        memberInsurance.setNarration(memberIns.getNarration());
        memberInsurance.setName(memberIns.getInsuranceName());
        memberInsurance.setMemberId(accRepo.getMemberId(memberIns.getId()));

        Calendar calender = Calendar.getInstance();
        calender.setTime(memberIns.getInsuranceStartDate());
        calender.add(Calendar.YEAR, memberIns.getInsuranceDuration());
        Date nextInsuranceDueDate = calender.getTime();
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
        if (list.size() != 0) {
            return list;
        } else {
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
    public List<DsaGuarantorDetails> getDsaGuarantor(Integer id) {
        List<DsaGuarantorDetails> dsaGuarantor = dsgRepo.getDsaGuarantor(id);
        if (dsaGuarantor.size() != 0) {
            return dsaGuarantor;
        } else {
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
    public void updateDsaGuarantor(Integer id, Integer memberId) {
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
        if(acType.equals("All")){
            acType=null;
        }
        List<iMemberInsuDetails> memberInsuDetails = accRepo.getMultipleInsurance(fromDate, toDate, acType,
                currentDate);
        if (memberInsuDetails.size() != 0) {
            return memberInsuDetails;
        } else {
            return new ArrayList<iMemberInsuDetails>();
        }
    }

    public List<iCommentDetails> getComments(Integer memberId) {
        List<iCommentDetails> comments = commentRepo.getComments(memberId);
        return comments;
    }

    public List<iBankBranchDetails> getBankBranch() {
        List<iBankBranchDetails> bankBranchDetails = bankBranchRepo.getBankBranch();
        return bankBranchDetails;
    }


    public List<AccountDetails> getSavingAccount(Integer id) {
        List<AccountDetails> accounts = accountsRepo.getSavingAccount(id);
        return  accounts;
    }

    public List<AccountDetails> getDebitAccount(Integer branchId) {
        List<AccountDetails> accounts = accountsRepo.getDebitAccount(branchId);
        return accounts;
    }

    public List<AccountDetails> getLoanAccounts(String accountNumber) {
        List<AccountDetails> list = accountsRepo.getAllLoanAccounts(accountNumber);
        if (list.size() != 0) {
            return list;
        } else {
            return new ArrayList<AccountDetails>();
        }
    }
}
