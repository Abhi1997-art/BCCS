package com.service.banking.repository.stockRepo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.StaffReportAcl;
import com.service.banking.model.superAdminModel.AclReportDetails;

public interface StaffAclReportRepo   extends JpaRepository<StaffReportAcl, Integer> {
	
	 
	@Query("select new com.service.banking.model.superAdminModel.AclReportDetails(a.id,s.name,s.id,a.page,a.isAllowed) from StaffReportAcl a "
		 		+ "left join Staffs s on s.id=a.staffs.id " + 
		 		 "where a.staffs.id =?1 " +
		 		"order by a.page")
	List<AclReportDetails> getStaffAclReport(Integer id);

}