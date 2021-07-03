package com.service.banking.repository.gstRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Supplier;
import com.service.banking.model.GstModel.SupplierDetails;

public interface SupplierRepo extends JpaRepository<Supplier, Integer> {

	// get all supplier....
	@Query("select new com.service.banking.model.GstModel.SupplierDetails(sp.id,sp.name,sp.organization,sp.gstin,sp.emailIds,sp.phoneNos,sp.address,sp.createdAt,sp.isActive,br.name,br.code) "+
			"from Supplier sp \r\n" +  
			"left join Branches br on br.id=1")  // put loged in  staff branch id and remove hard code id==1.......
	public List<SupplierDetails> allSupplier(); // 

}
