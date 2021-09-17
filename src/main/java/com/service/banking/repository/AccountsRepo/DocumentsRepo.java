package com.service.banking.repository.AccountsRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Documents;
import com.service.banking.model.accountsModel.DocumentsSubmittedDetails;

public interface DocumentsRepo extends JpaRepository<Documents, Integer>{

	@Query("Select new com.service.banking.model.accountsModel.DocumentsSubmittedDetails(d.id as documentId , d.name as documentName) from Documents d where d.name like %?1%")
	List<DocumentsSubmittedDetails> getDocumentsList(String name);

	@Query(value = "select count(*) from documents_submitted ds \n" +
			"left join documents d on d.id = ds.documents_id \n" +
			"where ds.accounts_id = ?1 and ds.documents_id = ?2 \n",
	nativeQuery = true)
    Integer checkDocumentExists(Integer accountId, Integer documentId);
}
