package com.service.banking.repository.superAdminRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.banking.hibernateEntity.Documents;

public interface AclDocumentRepo extends JpaRepository<Documents, Integer> {

}
