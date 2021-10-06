package com.service.banking.repository.superAdminRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Cadres;
import com.service.banking.model.superAdminModel.Cadre;
import com.service.banking.model.superAdminModel.CadreDetails;

public interface AgentCadreRepo extends JpaRepository<Cadres, Integer> {

	// Get Cadre for edit ................................................................................................
	@Query(" select new com.service.banking.model.superAdminModel.Cadre(c.id,c.name)from Cadres c")
	List<Cadre> getallCadres();

	// Get All Agent Cadres Management.....................................................................................
	@Query("select new com.service.banking.model.superAdminModel.CadreDetails(c.id,c.name ,c.percentageShare ,c.reqUnder ,c.totalCrpb ,cd.name,cd.id)from  Cadres c "
			+ "left join  Cadres cd on cd.id = c.nextcadreId order by c.id desc")
	List<CadreDetails> getCadresDetails();

	@Query(value = "select sum(c.percentage_share) from agents a \n" +
			"left join cadres c on c.id >= a.cadre_id \n" +
			"where a.id = ?1 ",
	nativeQuery = true)
	Integer getPercentageShare(Integer id);
}
