package com.service.banking.repository.AccountsRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Documents;
import com.service.banking.model.accountsModel.DocumentsSubmittedDetails;

public interface DocumentsRepo extends JpaRepository<Documents, Integer>{

	@Query("Select new com.service.banking.model.accountsModel.DocumentsSubmittedDetails(d.id as documentId , d.name as documentName) from Documents d where d.name like %?1%")
	List<DocumentsSubmittedDetails> getDocumentsList(String name);

	

}
