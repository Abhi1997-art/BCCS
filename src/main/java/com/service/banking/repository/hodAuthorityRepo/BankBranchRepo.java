package com.service.banking.repository.hodAuthorityRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.BankBranches;
import com.service.banking.model.MadModel.iBankBranchDetails;
import com.service.banking.model.hodAuthorityModel.BankBranchesDetails;

public interface BankBranchRepo extends JpaRepository<BankBranches, Integer> {

	
	// get all bank branches....................
	@Query("select new com.service.banking.model.hodAuthorityModel.BankBranchesDetails(b.id,b.name,c.id,c.name,b.ifsc) from BankBranches b left join Bank c on c.id = b.bank.id where  b.bank.id = ?1")
	public List<BankBranchesDetails> bankBranches(int branchId);

	@Query(value="select bb.id, bb.name, bb.IFSC, b.name as bankName from bank_branches bb \r\n"
			+ "left join bank b on b.id = bb.bank_id ",
			nativeQuery = true)
	public List<iBankBranchDetails> getBankBranch();



}
