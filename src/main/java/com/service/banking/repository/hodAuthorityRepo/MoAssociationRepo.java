package com.service.banking.repository.hodAuthorityRepo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.MoAgentAssociation;
import com.service.banking.model.accountsModel.AgentDetailsList;
import com.service.banking.model.hodAuthorityModel.AssociationDetails;
import com.service.banking.model.hodAuthorityModel.MoRoDetails;

public interface MoAssociationRepo extends JpaRepository<MoAgentAssociation, Integer> {

	@Query("select new com.service.banking.model.hodAuthorityModel.AssociationDetails(maa.id, a.id, mo.id, mo.name,  CASE WHEN (a.codeNo is NULL) THEN 0 ELSE a.codeNo END, m.name, CASE WHEN (m.id is NULL) THEN 0 ELSE m.id END, m.permanentAddress, \r\n"
			+ "m.landmark, CASE WHEN (m.isDefaulter is NULL) THEN false ELSE m.isDefaulter END, maa.fromDate, maa.toDate) from Mos mo \r\n"
			+ "left join MoAgentAssociation maa on mo.id = maa.moId \r\n"
			+ "left join Agents a on maa.agentId = a.id \r\n"
			+ "left join Members m on a.memberId = m.id ")
	List<AssociationDetails> getAllMoAssociation();
	
	@Query("select new com.service.banking.model.hodAuthorityModel.AssociationDetails(maa.id, a.id, mo.id, mo.name,  CASE WHEN (a.codeNo is NULL) THEN 0 ELSE a.codeNo END, m.name, CASE WHEN (m.id is NULL) THEN 0 ELSE m.id END, m.permanentAddress, \r\n"
			+ "m.landmark, CASE WHEN (m.isDefaulter is NULL) THEN false ELSE m.isDefaulter END, maa.fromDate, maa.toDate) from Mos mo \r\n"
			+ "left join MoAgentAssociation maa on mo.id = maa.moId \r\n"
			+ "left join Agents a on maa.agentId = a.id \r\n"
			+ "left join Members m on a.memberId = m.id \r\n"
			+ "where mo.id= ?1 and (maa.fromDate >= ?2 and maa.fromDate <= ?3) ")
	List<AssociationDetails> getMoPerformance(Integer id, Date FromDate, Date ToDate);
	
	@Query("select new com.service.banking.model.hodAuthorityModel.MoRoDetails(c.id,c.name as moName,c.isActive,c.branches.id as branchId,c.branches.name as branchName) from Mos c left join c.branches ")
	List<MoRoDetails> getMoRoDetails();
	
	@Query("select new com.service.banking.model.hodAuthorityModel.AssociationDetails(maa.id, a.id, mo.id, mo.name,  CASE WHEN (a.codeNo is NULL) THEN 0 ELSE a.codeNo END, m.name, CASE WHEN (m.id is NULL) THEN 0 ELSE m.id END, m.permanentAddress, \r\n"
			+ "m.landmark, CASE WHEN (m.isDefaulter is NULL) THEN false ELSE m.isDefaulter END, maa.fromDate, maa.toDate) from Mos mo \r\n"
			+ "left join MoAgentAssociation maa on mo.id = maa.moId \r\n"
			+ "left join Agents a on maa.agentId = a.id \r\n"
			+ "left join Members m on a.memberId = m.id where mo.id = ?1")
	List<AssociationDetails> getMoAgentAssociationByMosId(Integer id);

	@Query("select new com.service.banking.model.hodAuthorityModel.AssociationDetails(a.codeNo, m.name as memberName, m.id, m.permanentAddress, \r\n"
			+ "m.landmark,m.isDefaulter) from Mos mo \r\n"
			+ "left join Agents a on mo.id = a.moId \r\n"
			+ "left join Members m on a.memberId = m.id where Concat( 'BCCSAG', Convert(a.codeNo as CHAR), REPLACE(m.name, ' ', ''), Convert(m.id as CHAR), "
			+ "REPLACE(m.permanentAddress, ' ', ''), REPLACE(m.landmark, ' ', '') ) like %?1% OR Concat( 'BCCSAG', Convert(a.codeNo as CHAR), REPLACE(m.name, ' ', ''), '[', Convert(m.id as CHAR), ']', \r\n"
			+ " '::', REPLACE(m.permanentAddress, ' ', ''), '[', REPLACE(m.landmark, ' ', ''), ']' ) like %?1%")
	List<AssociationDetails> getMoAgentAssociationList(String name);
	
	@Query("select new com.service.banking.model.accountsModel.AgentDetailsList(a.codeNo, m.name, m.id, m.permanentAddress, \r\n"
			+ "m.landmark,m.isDefaulter) from Mos mo \r\n"
			+ "left join Agents a on mo.id = a.moId \r\n"
			+ "left join Members m on a.memberId = m.id where Concat( 'BCCSAG', Convert(a.codeNo as CHAR), REPLACE(m.name, ' ', ''), Convert(m.id as CHAR), "
			+ "REPLACE(m.permanentAddress, ' ', ''), REPLACE(m.landmark, ' ', '') ) like %?1% OR Concat( 'BCCSAG', Convert(a.codeNo as CHAR), REPLACE(m.name, ' ', ''), '[', Convert(m.id as CHAR), ']', \r\n"
			+ " '::', REPLACE(m.permanentAddress, ' ', ''), '[', REPLACE(m.landmark, ' ', ''), ']' ) like %?1%")
	List<AgentDetailsList> getAgentAssociationList(String name);
}
