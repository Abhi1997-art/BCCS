package com.service.banking.repository.superAdminRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Acls;
import com.service.banking.hibernateEntity.Staffs;
import com.service.banking.model.superAdminModel.AclDetails;

public interface StaffAclRepo  extends JpaRepository<Acls, Integer> {
	
	  
		 @Query("select new com.service.banking.model.superAdminModel.AclDetails(a.id,s.name,s.id,a.class_,a.canView ,a.isAllBranchAllowed ,a.allowAdd ,a.allowEdit ,a.allowDel) from Acls a "
		 		+ "left join Staffs s on s.id=a.staffs.id " + 
		 		 "where a.staffs.id =?1 ")
		 List<AclDetails> getStsffAcl(Integer Id);
		 
		 
		 @Query("select new com.service.banking.model.superAdminModel.AclDetails(a.id,s.name,s.id,a.class_,a.canView ,a.isAllBranchAllowed ,a.allowAdd ,a.allowEdit ,a.allowDel,d.name,d.id) from Acls a "
			 		+ "left join Staffs s on s.id=a.staffs.id " + 
			 		"left join Documents d on d.id= a.documentsId " + 
			 		 "where a.staffs.id =?1 and d.id=a.documentsId ")
			 List<AclDetails> getStaffAclDocument(Integer Id);

}
