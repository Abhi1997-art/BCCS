package com.service.banking.repository.hodAuthorityRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Branches;
import com.service.banking.model.hodAuthorityModel.BranchDetails;
import com.service.banking.model.hodAuthorityModel.IBranchDetails;

public interface BranchRepo extends JpaRepository<Branches, Integer> {

	// get all branches................

	@Query("select new com.service.banking.model.hodAuthorityModel.BranchDetails(b.id,b.name ) from Branches b ")
	public List<BranchDetails> getAllBranches();

	@Query(value = "select b.id as branchId , b.name as branchName from branches b \r\n"
			+ "where b.name LIKE CONCAT(?1,'%')", nativeQuery = true)
	public List<IBranchDetails> getBranchName(String search);

}
