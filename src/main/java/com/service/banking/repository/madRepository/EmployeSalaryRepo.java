package com.service.banking.repository.madRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.EmployeeSalaryRecord;
import com.service.banking.model.MadModel.SalaryManagement;

public interface EmployeSalaryRepo extends JpaRepository<EmployeeSalaryRecord, Integer> {

	
	
	 @Query("select new com.service.banking.model.MadModel.SalaryManagement(esr.id,b.name,xe.name,xe.empCode,esr.cl,esr.ccl ,esr.lwp, esr.absent,esr.monthlyOff,xe.basicSalary ,esr.totalDays ,esr.paidDays " + 
	 		",esr.leave ,esr.salary,esr.pfSalary ,esr.pfAmount ,esr.ded ,esr.otherAllowance  ,esr.incentive ,esr.allowPaid " + 
	 		",esr.netPayable ,xe.isActive,esr.month ,esr.year ,esr.narration ,esr.totalMonthDay) " + 
	 		"from EmployeeSalaryRecord esr " + 
	 		"left join Branches b on b.id=esr.branches.id " + 
	 		"left join XbankEmployees xe on xe.id=esr.xbankEmployees.id " + 
	 		"where esr.branches.id =?1 and esr.month =?2 and esr.year =?3 and esr.xbankEmployees.id=?4")
	       List<SalaryManagement> salaryManagement(Integer branchId,String month,String year,Integer empId);
	 
	 

	 @Query("select new com.service.banking.model.MadModel.SalaryManagement(xe.id,b.name,xe.name,xe.empCode,esr.cl,esr.ccl ,esr.lwp, esr.absent,esr.monthlyOff,xe.basicSalary ,esr.totalDays ,esr.paidDays " + 
	 		",esr.leave ,esr.salary,esr.pfSalary ,esr.pfAmount ,esr.ded ,esr.otherAllowance  ,esr.incentive ,esr.allowPaid " + 
	 		",esr.netPayable ,xe.isActive,esr.month ,esr.year ,esr.narration ,esr.totalMonthDay) " + 
	 		"from EmployeeSalaryRecord esr " + 
	 		"left join Branches b on b.id=esr.branches.id " + 
	 		"left join XbankEmployees xe on xe.id=esr.xbankEmployees.id " + 
	 		"where  esr.month =?1 and esr.year =?2 and xe.isActive =1 ")
	       List<SalaryManagement> salaryStructure(String month,String year);
}
