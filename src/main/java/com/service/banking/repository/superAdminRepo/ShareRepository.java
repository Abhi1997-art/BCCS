package com.service.banking.repository.superAdminRepo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Share;
import com.service.banking.model.superAdminModel.ShareDetails;

public interface ShareRepository extends JpaRepository<Share, Integer> {

	// Get share................................................................................................
	@Query("select  new  com.service.banking.model.superAdminModel.ShareDetails(s.id, s.currentMemberId, m.name , CASE WHEN (m.memberNo is null) THEN 0 ELSE m.memberNo END, m.currentAddress ,m.landmark, CASE WHEN (m.isDefaulter is null) THEN false ELSE m.isDefaulter END ,CASE WHEN (s.shareCertificateId is null) THEN 0 ELSE s.shareCertificateId END, s.no,s.buybackLockingMonths ,s.transferLockingMonths ,s.status ,a.accountNumber, a.createdAt, sc.name) from Share s"
			+ " left join Members m on m.id=s.currentMemberId" + " left join Accounts a on a.memberId=s.currentMemberId left join ShareCertificate sc on s.shareCertificateId = sc.id where a.accountType = 'SM'")
	Page<ShareDetails> getShare(Pageable pageable);

	// Get share by id................................................................................................
		@Query("select  new  com.service.banking.model.superAdminModel.ShareDetails(s.id, s.currentMemberId, m.name , CASE WHEN (m.memberNo is null) THEN 0 ELSE m.memberNo END, m.currentAddress ,m.landmark, CASE WHEN (m.isDefaulter is null) THEN false ELSE m.isDefaulter END ,CASE WHEN (s.shareCertificateId is null) THEN 0 ELSE s.shareCertificateId END, s.no,s.buybackLockingMonths ,s.transferLockingMonths ,s.status ,a.accountNumber, a.createdAt, sc.name) from Share s"
				+ " left join Members m on m.id=s.currentMemberId" + " left join Accounts a on a.memberId=s.currentMemberId left join ShareCertificate sc on s.shareCertificateId = sc.id where a.accountType = 'SM' and sc.id= ?1")
	List<ShareDetails> getSharebyID(Integer id);

		@Query(value = "select s.`no` from share s \n" +
				"order by s.id DESC \n" +
				"limit 1",
		nativeQuery = true)
    Integer getLastNo();
}