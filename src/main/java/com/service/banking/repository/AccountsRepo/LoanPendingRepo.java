package com.service.banking.repository.AccountsRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.service.banking.hibernateEntity.AccountsPending;
import com.service.banking.model.accountsModel.PendingLoanDetails;

public interface LoanPendingRepo extends JpaRepository<AccountsPending,Integer> {

	//loan pending deatils...........
	/*
	 * @Query("select new com.service.banking.model.accountsModel.SendNocDetails(n.id,a.accountNumber ,m.name ,m.fatherName ,n.nocLetterReceivedOn , s.name ,n.sendAt ,n.sendNarration , \r\n"
	 * + "n.isDispatchToCustomer,n.isReturn) from Noclog n  \r\n" +
	 * "left join Accounts a on a.id=n.accountsId    \r\n" +
	 * "left join Staffs s on s.id=n.createdById    \r\n" +
	 * "left join Members m on m.id=a.memberId     \r\n" +
	 * "where n.receivedById IS NULL or n.receivedById = '0' ")
	 */
	
	@Query("from AccountsPending ap  where ap.isApproved='0' ")				
	List<PendingLoanDetails> loanPending();

	
}
