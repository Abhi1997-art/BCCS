package com.service.banking.repository.hodAuthorityRepo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Mos;
import com.service.banking.model.hodAuthorityModel.AssociationDetails;
import com.service.banking.model.hodAuthorityModel.MoRoDetails;

public interface MoRoRepository extends JpaRepository<Mos, Integer> {


	// Repository for Mo/Ro tab get mapping
	@Query("select new com.service.banking.model.hodAuthorityModel.MoRoDetails(c.id,c.name as moName,c.isActive,c.branches.id as branchId,c.branches.name as branchName) from Mos c left join c.branches ")
		List<MoRoDetails> getMoRoDetails();

	@Query("select new com.service.banking.model.hodAuthorityModel.MoRoDetails(b.id,b.name as moName) from Mos b")
	List<MoRoDetails> getMos();
	
	@Query("select new com.service.banking.model.hodAuthorityModel.MoRoDetails(m.id,m.name as moName) from Mos m " +  
			"where m.name LIKE %?1% ")
	List<MoRoDetails> getMo(String name);

	@Query("Select new com.service.banking.model.hodAuthorityModel.AssociationDetails(mo.id, "
			+ " mo.name as moName) from Mos mo "
			+ "where CONCAT(REPLACE(mo.name, ' ', '') ) like %?1% ")
	public List<AssociationDetails> getmoAssociationList(String name);

	@Query("select new com.service.banking.model.hodAuthorityModel.MoRoDetails(b.id,b.name as moName) from Mos b where b.name like %?1%")
	public List<MoRoDetails> getMoList(String name);
	
	

}
