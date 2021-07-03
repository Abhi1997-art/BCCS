package com.service.banking.repository.madRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Dsa;
import com.service.banking.model.MadModel.DsaDetails;
import com.service.banking.model.report.iDsaReport;

public interface DsaRepository extends JpaRepository<Dsa,Integer> {
	
	
	@Query("select new com.service.banking.model.MadModel.DsaDetails(ds.id,m.name as memberName,m.id as memberId,m.currentAddress\r\n" + 
			",ds.name,ds.username ,ds.password ,ds.phoneNo1, ds.phoneNo2 ,ds.emailId1 ,ds.emailId2, m.isDefaulter) from Dsa ds \r\n" + 
			"left join Members m on ds.members.id =m.id")
	List<DsaDetails> getAlldsa();
	
	@Query(" select new com.service.banking.model.MadModel.DsaDetails(d.id,d.name) from Dsa d")
	List<DsaDetails> getDsa();

	@Query(value = "select ds.id, ds.name, d.name as firmname, d.properitor_name ,properitor_phone_no_1 ,d.properitor_phone_no_2 ,\r\n"
			+ "d.email_id_1 ,d.email_id_2 , d.product , d.username , d.password , d.ActiveStatus , d.Address , d.loan_panelty_per_day, \r\n"
			+ "d.time_over_charge , d.dealer_monthly_date from dealers d \r\n"
			+ "left join dsa ds on ds.id = d.dsa_id \r\n"
			+ "where ds.id = ?1",
			nativeQuery= true)
	List<iDsaReport> getDsaReport(Integer dsaId); 

}
