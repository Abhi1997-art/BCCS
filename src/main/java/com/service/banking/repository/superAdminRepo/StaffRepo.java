package com.service.banking.repository.superAdminRepo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Staffs;
import com.service.banking.model.superAdminModel.StaffModel;
import com.service.banking.model.superAdminModel.StaffPreviewDetail;

public interface StaffRepo extends JpaRepository<Staffs, Integer> {

	// Get active staffs.......................................................................
	@Query(" select new com.service.banking.model.superAdminModel.StaffModel(s.id,b.name,s.name,s.username,s.isActive,s.password,s.accountNo,s.accessLevel, b.id,s.createdAt, count(a.id) as Accounts) from Staffs s"
			+ " left join Branches b on b.id = s.branchId" 
			+ " right join Accounts a on a.staffId = s.id"
			+ " where s.isActive = 1 " 
			+ " group by s.id ")
	List<StaffModel> getActiveStaffs();

	// get all in active staff...........
	// " left join Accounts a on a.staffId=s.id" + count(distinct a.id) as
	// totalAccounts,
	@Query(" select new com.service.banking.model.superAdminModel.StaffModel(s.id,b.name,s.name,s.username,s.isActive,s.password,s.accountNo,s.accessLevel, b.id,s.createdAt, count(a.id) as Accounts) from Staffs s"
			+ " left join Branches b on b.id = s.branchId" 
			+ " right join Accounts a on a.staffId = s.id"
			+ " where s.isActive = 0 " 
			+ " group by s.id ")
	List<StaffModel> getInActiveStaff();

	// get all in active staff...........
	@Query(" select new com.service.banking.model.superAdminModel.StaffPreviewDetail(s.id,s.username,s.accessLevel, s.name, s.fatherName, s.pfAmount, s.basicPay,s.variablePay,s.createdAt,s.presentAddress,s.parmanentAddress,s.mobileNo,s.landlineNo, s.dob,s.password,s.motherName,"
			+ "s.isActive,s.marriatalStatus,s.bloodGroup ,s.empCode,s.emergencyNo,s.panNo,s.role,s.lastQualification,s.designation, s.remark,s.amountOfIncrement,s.yearlyIncrementAmount,s.salary, s.relavingDateIfNotActive,s.securityAmount,s.depositDate,s.totalDepAmount,s.postingAt,s.pfNo,"
			+ "s.bankName, s.ifscCode, s.accountNo,s.lastDateOfIncrement,s.nomineeName,s.nomineeAge,s.relationWithNominee) from Staffs s"
			+ " where s.id=?1 ")
	StaffPreviewDetail getStaff(Integer id);

}