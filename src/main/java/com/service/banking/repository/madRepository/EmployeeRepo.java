package com.service.banking.repository.madRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.XbankEmployees;
import com.service.banking.model.MadModel.EmployeName;
import com.service.banking.model.MadModel.EmployeeDetails;

public interface EmployeeRepo extends JpaRepository<XbankEmployees,Integer> {
	// new com.service.banking.model.MadModel.DsaDetails
	
	@Query("SELECT new com.service.banking.model.MadModel.EmployeeDetails(xe.id,b.name as branches ,xe.empCode ,xe.name ,xe.designation ,xe.contactNo ,xe.department,xe.dateOfJoining ,xe.emergencyNo ,\r\n" + 
			"xe.fatherName,xe.motherName ,xe.dob ,xe.maritalStatus ,xe.lastQualification ,xe.emailId ,xe.permanentAddress \r\n" + 
			",xe.presentAddress ,xe.panNo,xe.drivingLicenceNo ,xe.validityOfDrivingLicence ,xe.bankName ,xe.bankAccountNo ,xe.experince \r\n" + 
			",xe.prevCompany ,xe.prevDepartment ,xe.prevLeavingCompanyDate ,xe.leavingResion ,xe.pfJoiningDate ,xe.pfNo ,xe.pfNominee \r\n" + 
			",xe.relationWithNominee ,xe.pfDeduct ,xe.esiNo ,xe.agreementDate ,xe.paymemtMode ,xe.employeeStatus ,xe.basicSalary , \r\n" + 
			"xe.otherAllowance ,xe.societyContri ,xe.netPayable ,xe.netSalary ,xe.employeeImagePhoto ,xe.employeeImageSignature \r\n" + 
			",xe.dateOfLeaving ,xe.isActive ,xe.effectiveClDate ,xe.openingCl \r\n" + 
			")from XbankEmployees xe \r\n" + 
			"right join Branches b on xe.branches.id=b.id \r\n" + 
			" where xe.isActive = 1 and xe.isActive  IS NOT NULL")
	List<EmployeeDetails> getAllEmployee();
	
	
	// get inactive employee.......
	@Query("SELECT new com.service.banking.model.MadModel.EmployeeDetails(xe.id,b.name as branches ,xe.empCode ,xe.name ,xe.designation ,xe.contactNo ,xe.department,xe.dateOfJoining ,xe.emergencyNo ,\r\n" + 
			"xe.fatherName,xe.motherName ,xe.dob ,xe.maritalStatus ,xe.lastQualification ,xe.emailId ,xe.permanentAddress\r\n" + 
			",xe.presentAddress ,xe.panNo,xe.drivingLicenceNo ,xe.validityOfDrivingLicence ,xe.bankName ,xe.bankAccountNo ,xe.experince\r\n" + 
			",xe.prevCompany ,xe.prevDepartment ,xe.prevLeavingCompanyDate ,xe.leavingResion ,xe.pfJoiningDate ,xe.pfNo ,xe.pfNominee\r\n" + 
			",xe.relationWithNominee ,xe.pfDeduct ,xe.esiNo ,xe.agreementDate ,xe.paymemtMode ,xe.employeeStatus ,xe.basicSalary ,\r\n" + 
			"xe.otherAllowance ,xe.societyContri ,xe.netPayable ,xe.netSalary ,xe.employeeImagePhoto ,xe.employeeImageSignature \r\n" + 
			",xe.dateOfLeaving ,xe.isActive ,xe.effectiveClDate ,xe.openingCl \r\n" + 
			")from XbankEmployees xe\r\n" + 
			"right join Branches b on xe.branches.id=b.id \r\n" + 
			" where xe.isActive = 0 ")
	List<EmployeeDetails> getinactiveEmployee();
	
	
	 @Query("Select  new com.service.banking.model.MadModel.EmployeeDetails(c.id,c.name) from XbankEmployees c")
	 List<EmployeeDetails> findByPlaceContaining();
	 
	 
		// get employee for share add and update dropdown...................................
		@Query("select new com.service.banking.model.MadModel.EmployeName(m.id,m.name) from XbankEmployees m " +  
				"where m.name LIKE %?1% ")
		List<EmployeName> getEmployee(String empName);

}
