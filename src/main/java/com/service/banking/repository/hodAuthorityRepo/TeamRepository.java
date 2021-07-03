package com.service.banking.repository.hodAuthorityRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Teams;
import com.service.banking.model.hodAuthorityModel.Teamdetails;

public interface TeamRepository extends JpaRepository<Teams, Integer> {
	// get all team...................
	@Query("from Teams")
	List<Teams> getAllTeam();

	@Query("Select new com.service.banking.model.hodAuthorityModel.Teamdetails(t.id, t.name) from Teams t where t.name LIKE %?1%")
	List<Teamdetails> getTeam(String name);

}
