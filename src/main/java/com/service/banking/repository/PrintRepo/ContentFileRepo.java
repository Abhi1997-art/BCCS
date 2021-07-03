package com.service.banking.repository.PrintRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.ContentFiles;
import com.service.banking.model.printingModel.MemberDetail;

public interface ContentFileRepo  extends JpaRepository<ContentFiles, Integer> {

	    // get all content file for printing .............
		@Query("from ContentFiles")
		public List<ContentFiles> getContentFile();
}
