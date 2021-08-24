package com.service.banking.repository.AccountsRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.AccountGuarantors;
import com.service.banking.model.accountsModel.AccountGuarantorDetails;
import org.springframework.transaction.annotation.Transactional;

public interface AccountGuarantorRepo extends JpaRepository<AccountGuarantors, Integer>{
	
	// get Account Guarantor details API for "Edit Guarantor" tab inside "Accounts" tab inside "Loan" tab inside "Accounts" tab...........
	@Query("select new com.service.banking.model.accountsModel.AccountGuarantorDetails(ag.id, ag.accounts.id, m.id, m.name, m.memberNo, "
			+ " m.permanentAddress, m.landmark, m.isDefaulter, ag.createdAt) from AccountGuarantors ag left join "
			+ "Members m on ag.members.id = m.id where ag.accounts.id = ?1")
	public List<AccountGuarantorDetails> getAccountGuarantor(Integer id);

	@Query("select new com.service.banking.model.accountsModel.AccountGuarantorDetails(ag.id, ag.accounts.id, m.id, m.name, m.memberNo, "
			+ " m.permanentAddress, m.landmark, m.isDefaulter, ag.createdAt) from AccountGuarantors ag left join "
			+ "Members m on ag.members.id = m.id where m.name LIKE %?1% or m.memberNo LIKE %?1% or m.permanentAddress LIKE %?1% or m.landmark LIKE %?1% ")
	public List<AccountGuarantorDetails> getAcGuarantorsList(String name);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM account_guarantors \n" +
			"where account_id = ?1",
			nativeQuery = true)
    void deleteAccountGuarantorRepo();
}