package com.service.banking.repository.hodAuthorityRepo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.AgentTds;
import com.service.banking.model.hodAuthorityModel.AgentTdsDetail;
import com.service.banking.model.hodAuthorityModel.IAgentTdsDetail;

public interface AgentsTdsRepo extends JpaRepository<AgentTds, Integer> {
	// for agents tds................
	@Query("from AgentTds")
	List<AgentTds> allAgentTds();
	
	@Query("select new com.service.banking.model.hodAuthorityModel.AgentTdsDetail(agtds.id, ag.id, m.id, ag.codeNo, m.name, m.memberNo, m.currentAddress, "
			+ "m.landmark, m.isDefaulter, a.id, a.accountNumber, m1.id, m1.name, m1.fatherName, agtds.createdAt, agtds.totalCommission, "
			+ "agtds.tds, agtds.netCommission, a.branchId, b.name) from AgentTds agtds left join "
			+ "Agents ag on agtds.agents.id = ag.id left join Members m on ag.memberId = m.id left join Accounts a on a.id = agtds.accounts.id "
			+ "left join Members m1 on m1.id = a.memberId left join Branches b on b.id = a.branchId")
	public Page<AgentTdsDetail> allAgentTds(Pageable pageable);

	// get filtered agentTds details..............
	@Query(value = "select agtds.id as id, ag.id as agentId, m.id as memberId, ag.code_no as codeNo, m.name as memberName, m.member_no as memberNo, m.CurrentAddress as currentAddress, \r\n"
			+ "m.landmark as landmark, m.is_defaulter as isDefaulter, a.id as accountId, a.AccountNumber as accountNumber, m1.id as relatedAccountMemberId, \r\n"
			+ "m1.name as relatedAccountMemberName, m1.FatherName as relatedAccountFatherName, agtds.created_at as createdAt, agtds.total_commission as totalCommission, \r\n"
			+ "agtds.tds as tds, agtds.net_commission as netCommission, a.branch_id as branchId, b.name as branchName from agent_tds agtds left join \r\n"
			+ "agents ag on agtds.agent_id = ag.id left join members m on ag.member_id = m.id left join accounts a on a.id = agtds.related_account_id \r\n"
			+ "left join members m1 on m1.id = a.member_id left join branches b on b.id = a.branch_id \r\n"
			+ "where (CASE WHEN (EXISTS (select ag1.id from agents ag1 where ag1.id = ?1)) THEN (ag.id in (select ag1.id from agents ag1 where ag1.id = ?1)) \r\n"
			+ "	ELSE (ag.id not in (select ag1.id from agents ag1 where ag1.id = ?1)) END) and \r\n"
			+ " (CASE WHEN (EXISTS (select a1.id from accounts a1 where a1.id = ?2)) THEN (a.id in (select a1.id from accounts a1 where a1.id = ?2)) \r\n"
			+ " ELSE (a.id not in (select a1.id from accounts a1 where a1.id = ?2)) END)", countQuery = "SELECT count(*) FROM agent_tds agt left join agents ag on ag.id=agt.agent_id left join accounts a on agt.related_account_id = a.id  where (CASE WHEN (EXISTS (select ag1.id from agents ag1 where ag1.id = ?1)) THEN (ag.id in (select ag1.id from agents ag1 where ag1.id = ?1)) \r\n"
					+ "	ELSE (ag.id not in (select ag1.id from agents ag1 where ag1.id = ?1)) END) and \r\n"
					+ "	(CASE WHEN (EXISTS (select a1.id from accounts a1 where a1.id = ?2)) THEN (a.id in (select a1.id from accounts a1 where a1.id = ?2)) \r\n"
					+ "	ELSE (a.id not in (select a1.id from accounts a1 where a1.id = ?2)) END)", nativeQuery = true)
		public Page<IAgentTdsDetail> getFilteredAgentTds(Integer agentId, Integer relatedAccountId, Pageable pageable);
}
