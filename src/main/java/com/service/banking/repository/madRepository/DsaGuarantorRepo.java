package com.service.banking.repository.madRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.DsaGuarantors;
import com.service.banking.model.MadModel.DsaGuarantorDetails;

public interface DsaGuarantorRepo extends JpaRepository<DsaGuarantors, Integer>{
	@Query("select new com.service.banking.model.MadModel.DsaGuarantorDetails(ds.id, ds.name, dsg.id, dsg.members.id, m.name, m.memberNo, m.currentAddress, "
			+ "m.landmark, m.isDefaulter) \r\n"
			+ " from Dsa ds right join DsaGuarantors dsg on dsg.dsa.id =  ds.id left join Members m on dsg.members.id = m.id"
			+ " where ds.id= ?1") 
	public List<DsaGuarantorDetails> getDsaGuarantor(Integer id);
}