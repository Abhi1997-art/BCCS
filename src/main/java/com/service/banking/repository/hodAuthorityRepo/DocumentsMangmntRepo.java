package com.service.banking.repository.hodAuthorityRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Documents;
import com.service.banking.model.superAdminModel.AclDocumentDetail;

public interface DocumentsMangmntRepo extends JpaRepository<Documents, Integer> {
	// get all Document
	@Query("from Documents")
	public List<Documents> allDocument();

	// get all Document for superadmin...........
		@Query("select new com.service.banking.model.superAdminModel.AclDocumentDetail(d.id,d.name) from Documents d")
		public List<AclDocumentDetail> getDocument();

	
}
