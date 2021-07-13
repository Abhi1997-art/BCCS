package com.service.banking.repository.dashBoardRepo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Premiums;
import com.service.banking.model.dashboardModel.DailyDueResultModel;
import com.service.banking.model.dashboardModel.DueDeatailsModel;
import com.service.banking.model.dashboardModel.DueTotalSize;
import com.service.banking.model.dashboardModel.PremiusDetails;

public interface DailyDueRepository extends JpaRepository<Premiums, Integer> {

	// Get DDS daily due........................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name ,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1 and p.dueDate <=?1  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='DDS'")
	List<DueDeatailsModel> getDdsDailyDue(Date dueDate);

	// Get Recurring daily due........................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name ,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1 and p.dueDate <=?1  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Recurring'")
	List<DueDeatailsModel> getRecurringDailyDue(Date dueDate);
	
	// Get HL daily due........................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name ,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1 and p.dueDate <=?1  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Home Loan' ")
	List<DueDeatailsModel> getHLDailyDue(Date dueDate);
	
	// Get ML daily due........................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name ,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1 and p.dueDate <=?1  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Mortgage Loan' ")
	List<DueDeatailsModel> getMLDailyDue(Date dueDate);
	
	// Get PL daily due........................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name ,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1 and p.dueDate <=?1  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Personal Loan' ")
	List<DueDeatailsModel> getPLDailyDue(Date dueDate);
	
	// Get VL daily due........................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name ,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1 and p.dueDate <=?1  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Two Wheeler Loan' ")
	List<DueDeatailsModel> getVLDailyDue(Date dueDate);
	
	// Get FVL daily due........................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name ,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1 and p.dueDate <=?1  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Auto Loan' ")
	List<DueDeatailsModel> getFVLDailyDue(Date dueDate);
	
	// Get Other daily due........................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name ,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1 and p.dueDate <=?1  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Other' ")
	List<DueDeatailsModel> getOTHERDailyDue(Date dueDate);
	
	// get DDS weekly due...............................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='DDS' ")
	List<DueDeatailsModel> getDdsWeeklyDue(Date firstDate, Date lastDate);
	
	// get Recurring weekly due...........................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Recurring' ")
	List<DueDeatailsModel> getRecurringWeeklyDue(Date firstDate, Date lastDate);
	
	// get HL weekly due...............................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Home Loan' ")
	List<DueDeatailsModel> getHLWeeklyDue(Date firstDate, Date lastDate);
	
	// get VL weekly due...............................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Two Wheeler Loan' ")
	List<DueDeatailsModel> getVLWeeklyDue(Date firstDate, Date lastDate);
	
	// get FVL weekly due...............................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Auto Loan' ")
	List<DueDeatailsModel> getFVLWeeklyDue(Date firstDate, Date lastDate);
	
	// get ML weekly due...............................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Mortgage Loan' ")
	List<DueDeatailsModel> getMLWeeklyDue(Date firstDate, Date lastDate);
	
	// get PL weekly due...............................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Personal Loan' ")
	List<DueDeatailsModel> getPLWeeklyDue(Date firstDate, Date lastDate);
	
	// get OTHER weekly due...............................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Other' ")
	List<DueDeatailsModel> getOTHERWeeklyDue(Date firstDate, Date lastDate);

	// Get DDS monthly due....................................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='DDS'")
	Page<DueDeatailsModel> getMonthlyDdsDue(Date month_firstDay, Date month_lastday, Pageable pageable);
	
	// Get Recurring monthly due.................................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Recurring'")
	Page<DueDeatailsModel> getMonthlyRecurringDue(Date month_firstDay, Date month_lastday, Pageable pageable);
	
	// Get HL monthly due......................................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Home Loan'")
	Page<DueDeatailsModel> getMonthlyHLDue(Date month_firstDay, Date month_lastday, Pageable pageable);
	
	// Get VL monthly due......................................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Two Wheeler Loan'")
	Page<DueDeatailsModel> getMonthlyVLDue(Date month_firstDay, Date month_lastday, Pageable pageable);
	
	// Get FVL monthly due......................................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Auto Loan'")
	Page<DueDeatailsModel> getMonthlyFVLDue(Date month_firstDay, Date month_lastday, Pageable pageable);
	
	// Get ML monthly due......................................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Mortgage Loan'")
	Page<DueDeatailsModel> getMonthlyMLDue(Date month_firstDay, Date month_lastday, Pageable pageable);
	
	// Get PL monthly due......................................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Personal Loan'")
	Page<DueDeatailsModel> getMonthlyPLDue(Date month_firstDay, Date month_lastday, Pageable pageable);
	
	// Get OTHER monthly due......................................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' and a.accountType='Other'")
	Page<DueDeatailsModel> getMonthlyOTHERDue(Date month_firstDay, Date month_lastday, Pageable pageable);
	
	// Get all monthly due.................................................................................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,p.amount,p.dueDate,\r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name,a.accountType, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' ")
	Page<DueDeatailsModel> getMonthlyDue(Date month_firstDay, Date month_lastday, Pageable pageable);

	// get total size of monthly due..................................

	@Query("select new  com.service.banking.model.dashboardModel.DueTotalSize(count(distinct a.id) as accountNumber)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='1'  and p.paid = '0' ")
	// @Query("Select new
	// com.service.banking.model.dashboardModel.DailyDueResultModel(a.accountNumber,m.name
	// ,m.fatherName ,m.permanentAddress ,m.phoneNos
	// ,p.amount,p.dueDate,d.name,a.accountType) from Premiums p ,Accounts a
	// ,Dealers d,Members m where p.accountId=a.id and a.memberId=m.id and
	// a.dealerId =d.id and dueDate >=?1 and dueDate <=?2 and p.paid='0' and
	// a.activeStatus='1' ")
	DueTotalSize MonthlyDueForPagination(Date month_firstDay, Date month_lastday);

	// get DDS view for daily due..................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,a.currentBalanceDr,p.dueDate, \r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate =?1  and a.activeStatus ='0' and a.accountType = 'DDS'  and a.maturedStatus ='1' ")
	// @Query("Select new
	// com.service.banking.model.dashboardModel.DailyDueResultModel(a.accountNumber,m.name
	// ,m.fatherName ,m.permanentAddress ,m.phoneNos
	// ,p.amount,p.dueDate,d.name,a.accountType) from Premiums p ,Accounts a
	// ,Dealers d,Members m where p.accountId=a.id and a.memberId=m.id and
	// a.dealerId =d.id and dueDate >=?1 and dueDate <=?2 and p.paid='0' and
	// a.activeStatus='1' ")
	List<DueDeatailsModel> getDDSView(Date dueDate);

	// get recurring view for daily due..................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,a.currentBalanceDr,p.dueDate, \r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate =?1  and a.activeStatus ='0' and a.accountType = 'Recurring'  and a.maturedStatus ='1' ")
	// @Query("Select new
	// com.service.banking.model.dashboardModel.DailyDueResultModel(a.accountNumber,m.name
	// ,m.fatherName ,m.permanentAddress ,m.phoneNos
	// ,p.amount,p.dueDate,d.name,a.accountType) from Premiums p ,Accounts a
	// ,Dealers d,Members m where p.accountId=a.id and a.memberId=m.id and
	// a.dealerId =d.id and dueDate >=?1 and dueDate <=?2 and p.paid='0' and
	// a.activeStatus='1' ")
	List<DueDeatailsModel> getRecurringView(Date dueDate);

	// get FD and MIS view for daily due..................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,a.currentBalanceDr,p.dueDate, \r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate =?1  and a.activeStatus ='0' and a.accountType = 'FD,MIS'  and a.maturedStatus ='1' ")
	// @Query("Select new
	// com.service.banking.model.dashboardModel.DailyDueResultModel(a.accountNumber,m.name
	// ,m.fatherName ,m.permanentAddress ,m.phoneNos
	// ,p.amount,p.dueDate,d.name,a.accountType) from Premiums p ,Accounts a
	// ,Dealers d,Members m where p.accountId=a.id and a.memberId=m.id and
	// a.dealerId =d.id and dueDate >=?1 and dueDate <=?2 and p.paid='0' and
	// a.activeStatus='1' ")
	List<DueDeatailsModel> getFDMISView(Date dueDate);

	// get DDS view for weekly due..................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,a.currentBalanceDr,p.dueDate, \r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2 and a.activeStatus ='0' and a.accountType = 'DDS'  and a.maturedStatus ='1' ")
	// @Query("Select new
	// com.service.banking.model.dashboardModel.DailyDueResultModel(a.accountNumber,m.name
	// ,m.fatherName ,m.permanentAddress ,m.phoneNos
	// ,p.amount,p.dueDate,d.name,a.accountType) from Premiums p ,Accounts a
	// ,Dealers d,Members m where p.accountId=a.id and a.memberId=m.id and
	// a.dealerId =d.id and dueDate >=?1 and dueDate <=?2 and p.paid='0' and
	// a.activeStatus='1' ")
	List<DueDeatailsModel> DdsWeeklyView(Date firstDate, Date lastDate);

	// get recurring view for weekly due..................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,a.currentBalanceDr,p.dueDate, \r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='0' and a.accountType = 'Recurring'  and a.maturedStatus ='1' ")
	// @Query("Select new
	// com.service.banking.model.dashboardModel.DailyDueResultModel(a.accountNumber,m.name
	// ,m.fatherName ,m.permanentAddress ,m.phoneNos
	// ,p.amount,p.dueDate,d.name,a.accountType) from Premiums p ,Accounts a
	// ,Dealers d,Members m where p.accountId=a.id and a.memberId=m.id and
	// a.dealerId =d.id and dueDate >=?1 and dueDate <=?2 and p.paid='0' and
	// a.activeStatus='1' ")
	List<DueDeatailsModel> RecurringWeeklyView(Date firstDate, Date lastDate);

	// get FD and MIS view for weekly due..................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,a.currentBalanceDr,p.dueDate, \r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2 and a.activeStatus ='0' and a.accountType = 'FD,MIS'  and a.maturedStatus ='1' ")
	// @Query("Select new
	// com.service.banking.model.dashboardModel.DailyDueResultModel(a.accountNumber,m.name
	// ,m.fatherName ,m.permanentAddress ,m.phoneNos
	// ,p.amount,p.dueDate,d.name,a.accountType) from Premiums p ,Accounts a
	// ,Dealers d,Members m where p.accountId=a.id and a.memberId=m.id and
	// a.dealerId =d.id and dueDate >=?1 and dueDate <=?2 and p.paid='0' and
	// a.activeStatus='1' ")
	List<DueDeatailsModel> FDMISWeeklyView(Date firstDate, Date lastDate);

	// get DDS view for monthly due..................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,a.currentBalanceDr,p.dueDate, \r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2 and a.activeStatus ='0' and a.accountType = 'DDS'  and a.maturedStatus ='1' ")
	// @Query("Select new
	// com.service.banking.model.dashboardModel.DailyDueResultModel(a.accountNumber,m.name
	// ,m.fatherName ,m.permanentAddress ,m.phoneNos
	// ,p.amount,p.dueDate,d.name,a.accountType) from Premiums p ,Accounts a
	// ,Dealers d,Members m where p.accountId=a.id and a.memberId=m.id and
	// a.dealerId =d.id and dueDate >=?1 and dueDate <=?2 and p.paid='0' and
	// a.activeStatus='1' ")
	List<DueDeatailsModel> DdsMonthlyView(Date month_firstDay, Date month_lastday);

	// get recurring view for monthly due..................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,a.currentBalanceDr,p.dueDate, \r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2  and a.activeStatus ='0' and a.accountType = 'Recurring'  and a.maturedStatus ='1' ")
	// @Query("Select new
	// com.service.banking.model.dashboardModel.DailyDueResultModel(a.accountNumber,m.name
	// ,m.fatherName ,m.permanentAddress ,m.phoneNos
	// ,p.amount,p.dueDate,d.name,a.accountType) from Premiums p ,Accounts a
	// ,Dealers d,Members m where p.accountId=a.id and a.memberId=m.id and
	// a.dealerId =d.id and dueDate >=?1 and dueDate <=?2 and p.paid='0' and
	// a.activeStatus='1' ")
	List<DueDeatailsModel> RecurringMonthlyView(Date month_firstDay, Date month_lastday);

	// get FD and MIS view for monthly due..................................
	@Query("select new  com.service.banking.model.dashboardModel.DueDeatailsModel(a.id,a.accountNumber,m.name ,m.fatherName ,m.permanentAddress ,m.phoneNos ,a.currentBalanceDr,p.dueDate, \r\n"
			+ "  ag.codeNo ,mg.name,mg.memberNo ,mg.permanentAddress ,mg.landmark ,mg.isDefaulter ,d.name, m.id)  from Premiums p \r\n"
			+ "left join  Accounts a on p.accountId =a.id \r\n" + "left join Dealers d on a.dealerId = d.id \r\n"
			+ "left join Members  m on a.memberId =m.id \r\n" + "left join Agents  ag on a.agentId  = ag.id \r\n"
			+ "left join Members mg on ag.memberId =mg.id \r\n" + "left join Schemes sc on sc.id = a.schemeId \r\n"
			+ "WHERE p.dueDate >=?1  and p.dueDate <=?2 and a.activeStatus ='0' and a.accountType = 'FD,MIS'  and a.maturedStatus ='1' ")
	// @Query("Select new
	// com.service.banking.model.dashboardModel.DailyDueResultModel(a.accountNumber,m.name
	// ,m.fatherName ,m.permanentAddress ,m.phoneNos
	// ,p.amount,p.dueDate,d.name,a.accountType) from Premiums p ,Accounts a
	// ,Dealers d,Members m where p.accountId=a.id and a.memberId=m.id and
	// a.dealerId =d.id and dueDate >=?1 and dueDate <=?2 and p.paid='0' and
	// a.activeStatus='1' ")
	List<DueDeatailsModel> FDMISMonthlyView(Date month_firstDay, Date month_lastday);

	// for premium details............................

	@Query("select new  com.service.banking.model.dashboardModel.PremiusDetails(p.id,p.dueDate ,p.amount ,p.paid ,p.paidOn ,p.agentCommissionSend ,p.agentCommissionPercentage ,p.agentCollectionChargesPercentage ,p.agentCollection"
			+ "ChargesSend ,p.paneltyCharged ,p.paneltyPosted)" + " from Premiums p where p.accountId =?1 ")
	List<PremiusDetails> getPremiusDetails(Integer accountId);





}