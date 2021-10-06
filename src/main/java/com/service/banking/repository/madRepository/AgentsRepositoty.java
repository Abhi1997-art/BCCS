package com.service.banking.repository.madRepository;

import java.util.Collection;
import java.util.List;

import com.service.banking.hibernateEntity.Accounts;
import com.service.banking.model.accountsModel.CollectorDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Agents;
import com.service.banking.model.MadModel.AgentDetails;
import com.service.banking.model.MadModel.AgentGuarantorDetails;
import com.service.banking.model.MadModel.MemberDetails;
import com.service.banking.model.accountsModel.AgentDetailsList;

public interface AgentsRepositoty extends JpaRepository<Agents, Integer> {


	//Get all Agents........................................................................................................
	@Query("select new com.service.banking.model.MadModel.AgentDetails(a.id ,mo.name as moName ,a.createdAt "
			+ ",mr.memberNo as memberNO ,mr.name as memmberName,mr.city,mr.fatherName,mr.district ,mr.tehsil,"
			+ "mr.state,mr.currentAddress ,ac.accountNumber,cd.name  as cadreName,a.activeStatus,a.username ,a.codeNo,a.addedBy ,a.password, "
			+ "mr.landmark,mr.isDefaulter, a.sponsorId, m3.name as sponsorName, m3.currentAddress as sponsorAddress, m3.id as sponsorMemberId,m3.landmark as sponsorLandmark, m3.isDefaulter as sponsorDefaulter,c2.name as sponsorCadre,a.currentIndividualCrpb,a.moId, a.accountId, a.cadreId) from Agents a \r\n"
			+ "left  Join Accounts ac on a.accountId =ac.id \r\n" + "left  Join Members mr on a.memberId =mr.id \r\n"
			+ "left Join  Cadres cd on a.cadreId =cd.id \r\n" + "left  Join Mos mo on a.moId =mo.id \r\n"
			+ "left join Agents a2 on a2.id =a.sponsorId \r\n" + "left join Members m3 on m3.id=a2.memberId \r\n"
			+ "left join Cadres c2 on c2.id = a2.cadreId " +
			" where mr.name like ?1% or mr.memberNo like ?1% or mo.name like ?1% or ac.accountNumber like ?1% or cd.name like ?1% or a.codeNo like ?1% or m3.name like ?1%" +
			" order by a.id DESC")
	public Page<AgentDetails> getAllAgents(Pageable pageable, String search);

	@Query("select new com.service.banking.model.MadModel.AgentGuarantorDetails(ag.id, m.id, m.memberNo, m.name, m.currentAddress, m.landmark, m.isDefaulter, "
			+ "a.codeNo, mbr.id, mbr.name, mbr.currentAddress, mbr.landmark, mbr.isDefaulter) from Agents a "
			+ "right join AgentGuarantors ag on a.id = ag.agents.id left join Members m "
			+ "on m.id = ag.members.id left join Members mbr on a.memberId = mbr.id where a.id = ?1")
	public List<AgentGuarantorDetails> getAgentGuarantorInAgent(Integer id);

	
	@Query("select new com.service.banking.model.accountsModel.AgentDetailsList(a.codeNo, m.name, a.id, m.permanentAddress, \r\n"
			+ "m.landmark,m.isDefaulter) from Agents a \r\n"
			+ "left join Members m on a.memberId = m.id \r\n" 
			+ " where m.name LIKE %?1% or a.codeNo LIKE %?1%" )
	public List<AgentDetailsList> getAgentList(String name);

	@Query("select new com.service.banking.model.accountsModel.AgentDetailsList(a.codeNo, m.name, a.id, m.permanentAddress, \r\n"
			+ "m.landmark) from Agents a \r\n"
			+ "left join Members m on a.memberId = m.id \r\n"
			+ " where m.name LIKE %?1% or a.codeNo LIKE %?1%" )
	public List<AgentDetailsList> getAgentList2(String name);


	@Query(value = "select a.code_no from  agents a \n" +
			"order by a.id DESC\n" +
			"limit 1",
	nativeQuery = true)
	public Integer getLastCodeNo();

	@Query(value = "select a.code_no from agents a \n" +
			"where member_id = ?1",
			nativeQuery = true)
	Integer checkMember(Integer memberId);

	@Query(value="SELECT * from agents a \n" +
			"where a.member_id = ?1",
			nativeQuery = true)
	List<Agents> findAgents(Integer id);

	@Query("select new com.service.banking.model.accountsModel.CollectorDetails(a.codeNo, m.name, a.id, m.permanentAddress, \r\n"
			+ "m.landmark) from Agents a \r\n"
			+ "left join Members m on a.memberId = m.id \r\n"
			+ " where m.name LIKE %?1% or a.codeNo LIKE %?1%" )
	List<CollectorDetails> getCollectorList(String name);
}
