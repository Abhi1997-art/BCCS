package com.service.banking.repository.superAdminRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Branches;
import com.service.banking.model.superAdminModel.Branch;
import com.service.banking.model.superAdminModel.BranchDetail;
import com.service.banking.model.superAdminModel.BranchesDetails;
import com.service.banking.model.superAdminModel.ClosingDetails;

public interface BranchesRepository extends JpaRepository<Branches, Integer> {

	/*
	 * // get all branches............UNION
	 * 
	 * @Query("select new  org.cssinfotech.banking.model.superAdminModel.Branches(b.name,b.Address,b.Code ,c.daily ,b.PerformClosings ,b.SendSMS ,b.published ,b.allow_login) from closings c left join branches b on c.branch_id =b.id  union select b.name,b.Address,b.Code ,c.daily ,b.PerformClosings ,b.SendSMS ,b.published ,b.allow_login from closings c right join branches b on c.branch_id =b.id"
	 * ) List<org.cssinfotech.banking.model.superAdminModel.Branches> getBranches();
	 */

	// get all branches............USING THIS WAY INSTEAD OF UNION
	// get all branches.......
		@Query("select  new com.service.banking.model.superAdminModel.BranchDetail(b.id, b.name, b.address , b.code ,b.allowLogin ,b.performClosings ,b.published, b.sendSms , c.daily) from Branches b " +
				" left join Closings c on c.branchId =b.id  ")
		List<BranchDetail> getBranches();
		
	// get closing...............
	@Query("select  new com.service.banking.model.superAdminModel.ClosingDetails(b.id,b.name ,c.daily) from Branches b left join Closings c on c.branchId = b.id where  b.performClosings ='1' ")
	List<ClosingDetails> closingDetails();

	@Query("select new com.service.banking.model.superAdminModel.BranchDetail(b.id) from Branches b left join Accounts a on a.branchId = b.id where a.id =?1 ")
	BranchDetail getBranchesId(Integer accountId);

	@Query(value = "select new com.service.banking.model.superAdminModel.BranchDetail(b.id, b.code) from Branches b")
	List<BranchDetail> getTotalBranches();
}
