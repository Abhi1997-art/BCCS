package com.service.banking.repository.hodAuthorityRepo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Members;
import com.service.banking.model.hodAuthorityModel.AccountAndMemberDetails;
import com.service.banking.model.hodAuthorityModel.FilterMoAgentUpdateDetails;

public interface memberRepository extends JpaRepository<Members, Integer>{

	
	// FilterMoAgentUpdateDetails
	@Query("select new com.service.banking.model.hodAuthorityModel.FilterMoAgentUpdateDetails(ag.codeNo, m.name, m.id, m.permanentAddress, m.landmark, m.isDefaulter, mos.name, ag.id) from Members m "
			+ "right join Agents ag on m.id = ag.memberId "
			+ "left join Mos mos on ag.moId = mos.id where m.branchId = ?1 order by ag.codeNo")
	public List<FilterMoAgentUpdateDetails> getFilterMoAgentUpdateDetails(Integer id);
	
	@Query("Select new com.service.banking.model.hodAuthorityModel.AccountAndMemberDetails(CASE WHEN (a.id is NULL) THEN 0 ELSE a.id END, "
			+ "a.accountNumber, m.name, m.fatherName) from Members m left join Accounts a on m.id = a.memberId "
			+ "where CONCAT( a.accountNumber, REPLACE(m.name, ' ', ''), REPLACE(m.fatherName, ' ', '') ) like %?1% ")
	public List<AccountAndMemberDetails> getAccountAndMemberList(String name);
}
