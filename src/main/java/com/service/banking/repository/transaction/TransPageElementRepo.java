package com.service.banking.repository.transaction;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.TransactionPageElement;
import com.service.banking.model.transaction.PageElementDetails;
import com.service.banking.model.transaction.TransPageDetails;

public interface TransPageElementRepo extends JpaRepository<TransactionPageElement, Integer>{
	

	// get  page elements ........
	//	@Query(" select new com.service.banking.model.transaction.TransPageDetails(tp.id ,tp.transName ,tp.transType ,tp.pageOrderNumber ,tp.status) from  TransactionPage tp")  //this normal fetch not group by
	@Query("select new com.service.banking.model.transaction.PageElementDetails(te.id ,te.elementCode,te.elementType ,te.elementDesc) from TransactionPageElement tpe " + 
			"left join  TransactionElement te on te.id =tpe.elementId " + 
			"WHERE tpe.pageId =?1 GROUP by(tpe.elementOrder) ")	
	List<PageElementDetails> getPageElements(Integer id);
	

	
	// for updating page element........................................
	   // @Transactional
	 //   @Modifying
	 //   @Query(value = "UPDATE TransactionPageElement u set u.order.id=?4 and u.elementStatus=?3 where u.pageId =?1 and u.elementID =?2 ",
	    //        nativeQuery = true)
	//	List<PageElementDetails> updatePageElement(Integer pageId,Integer elementId,Boolean elementStatus,Integer elementOrder);
	
}
