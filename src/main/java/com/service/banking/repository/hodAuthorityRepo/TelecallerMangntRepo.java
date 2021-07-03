package com.service.banking.repository.hodAuthorityRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Telecaller;
import com.service.banking.model.hodAuthorityModel.TeleCallerHistoryDetails;

public interface TelecallerMangntRepo extends JpaRepository<Telecaller, Integer> {
	// get all telecaller .....................
	@Query("from Telecaller ")
	public List<Telecaller> getTelecaller();

	@Query("select new com.service.banking.model.hodAuthorityModel.TeleCallerHistoryDetails( th.id,th.accountId,th.telecallerId ,t2.name, a.accountNumber,m.name as memberName ,m.fatherName  ,th.fromDate,th.finalToDate ) from Telecaller t2 ,TelecallerAccountHistory  th ,Accounts a ,Members m where a.id = th.accountId and a.memberId =m.id  and t2.id=th.telecallerId")
	public List<TeleCallerHistoryDetails> telecallerHistory();
	
	// get telecaller list by name
		@Query("Select t from Telecaller t where t.name like %?1%")
		public List<Telecaller> getTelecallerList(String name);
	
}
