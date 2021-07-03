package com.service.banking.repository.hodAuthorityRepo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.MoAccountAssociation;
import com.service.banking.model.hodAuthorityModel.AssociationDetails;

public interface RoAssociationsRepo extends JpaRepository<MoAccountAssociation, Integer> {

	@Query("select new com.service.banking.model.hodAuthorityModel.AssociationDetails(maa.id, m.id, ms.name,a.accountNumber,m.fatherName, m.name as memberName,"
			+ " maa.fromDate ,maa.toDate, ms.id,a.id) from MoAccountAssociation maa ,Accounts a ,Members m ,Mos ms where maa.accounts.id=a.id and a.memberId =m.id "
			+ "and maa.mos.id = ms.id")
	Page<AssociationDetails> getAllRoAssociation(Pageable pageable);

	@Query("select new com.service.banking.model.hodAuthorityModel.AssociationDetails(ms.id, m.id, ms.name,a.accountNumber,m.fatherName, m.name as memberName,"
			+ " maa.fromDate ,maa.toDate, ms.id,a.id) from MoAccountAssociation maa ,Accounts a ,Members m ,Mos ms where maa.accounts.id=a.id and a.memberId =m.id "
			+ "and maa.mos.id = ms.id and ms.id = ?1")
	public List<AssociationDetails> getRoAccountAssociationByMosId(Integer id);
}
