package com.service.banking.repository.superAdminRepo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.service.banking.hibernateEntity.ShareCertificate;
import com.service.banking.model.superAdminModel.MeberDetail;
import com.service.banking.model.superAdminModel.ShareCertificateDetail;
import com.service.banking.model.superAdminModel.ShareCertificateDetails;

public interface ShareCertificateRepo extends JpaRepository<ShareCertificate, Integer> {

	// get share certificate......
		@Query("select new com.service.banking.model.superAdminModel.ShareCertificateDetails (sc.id , sc.name ,sc.status , MIN(s.no) as startShare, MAX(s.no) as endShare  ,sc.createdAt ,sc.submittedAt, count(distinct  s.no) as Sharecount, m.name, CASE WHEN (m.memberNo is null) THEN 0 ELSE m.memberNo END ,m.currentAddress, m.landmark ,CASE WHEN (m.isDefaulter is null) THEN false ELSE m.isDefaulter END, a.accountNumber, a.memberId)  from ShareCertificate sc" + 
				" left join  Share s on sc.id = s.shareCertificateId" + 
				" left join Members m on m.id=s.currentMemberId left join Accounts a on a.memberId=s.currentMemberId where a.accountType = 'SM'"
				+ " and sc.status = 'Issued'" + 
				" GROUP by (sc.name)")
		Page<ShareCertificateDetails> getShareCertificate(Pageable pageable);
		
		// get all share certificate for share add and update dropdown...................................
		@Query("select new com.service.banking.model.superAdminModel.ShareCertificateDetail(s.id,s.name) from ShareCertificate s " +  
				"where s.name LIKE CONCAT('%', :name, '%')  ")
		List<ShareCertificateDetail> getShareCertificate(@Param("name") Integer name);

}

