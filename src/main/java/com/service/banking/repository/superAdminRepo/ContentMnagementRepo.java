package com.service.banking.repository.superAdminRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.ContentFiles;

public interface ContentMnagementRepo extends JpaRepository<ContentFiles, Integer> {
	// get content management...........
	@Query("from ContentFiles")
	List<ContentFiles> getcontentFile();
}
