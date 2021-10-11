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
	
	@Query("select new com.service.banking.model.accountsModel.PendingLoanDetails(ap.id, ap.accountNumber , b.id, b.name, ap.createdAt , m.id, m.name, m.memberNo , m.currentAddress , m.isDefaulter,  s.id, s.name , ap.amount ,\n" +
			"ap.repaymentMode , ap.insuranceTenure , ap.activeStatus , ap.modeOfOperation, ap.loanInsurranceDate, d.id, d.name) from AccountsPending ap \n" +
			"left join Members m on ap.memberId = m.id \n" +
			"left join Branches b on b.id = ap.branchId \n" +
			"left join Schemes s on s.id = ap.schemeId \n" +
			"left join Dealers d on d.id= ap.dealerId \n" +
			"where ap.isApproved = 0")
	List<PendingLoanDetails> loanPending();

	
}
