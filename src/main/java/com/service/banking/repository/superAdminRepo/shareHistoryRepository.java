package com.service.banking.repository.superAdminRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.ShareHistory;
import com.service.banking.model.superAdminModel.ShareHistoryDetails;

public interface shareHistoryRepository extends JpaRepository<ShareHistory, Integer>{
	
	
	@Query("select  new  com.service.banking.model.superAdminModel.ShareHistoryDetails(sh.id, sh.shareId, sh.memberId, m.name , CASE WHEN (m.memberNo is null) THEN 0 ELSE m.memberNo END, m.currentAddress ,m.landmark, CASE WHEN (m.isDefaulter is null) THEN false ELSE m.isDefaulter END ,CASE WHEN (sh.shareCertificateId is null) THEN 0 ELSE sh.shareCertificateId END, s.no ,s.status ,a.accountNumber, a.createdAt, sc.name as shareCertificateName, sh.fromDate, sh.finalToDate) from ShareHistory sh"
			+ " left join Share s on s.id = sh.shareId left join Members m on m.id=sh.memberId"
			+ " left join Accounts a on a.memberId=sh.memberId left join ShareCertificate sc on sh.shareCertificateId = sc.id where s.id = ?1 and a.accountType='SM'")
	List<ShareHistoryDetails> getShareHistory(Integer shareId);

}
