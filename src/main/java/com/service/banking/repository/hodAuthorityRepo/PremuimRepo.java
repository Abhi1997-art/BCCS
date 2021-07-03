package com.service.banking.repository.hodAuthorityRepo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Premiums;
import com.service.banking.model.dashboardModel.DailyDueResultModel;
import com.service.banking.model.hodAuthorityModel.PremiumDetails;

public interface PremuimRepo extends JpaRepository<Premiums, Integer> {
	// get all premium................
		// @Query("select p.amount ,a.accountNumber from Premiums p ,Accounts a,Members
		// m where p.accountId =a.id and a.memberId =m.id")
		// List<Object> allPremiums();

		@Query("select new com.service.banking.model.hodAuthorityModel.PremiumDetails(p.id ,a.accountNumber,m.name ,m.fatherName,p.amount,p.paid,p.skipped ,p.dueDate ,p.paidOn ,p.agentCommissionSend ,p.agentCommissionPercentage ,p.agentCollectionChargesSend,p.agentCollectionChargesPercentage ,p.paneltyCharged, p.paneltyPosted ,p.updatedAt ,p.createdAt) from Premiums p ,Accounts a,Members m where p.accountId =a.id and a.memberId =m.id order by p.id")
		//List<PremiumDetails> allPremiums();
		Page<PremiumDetails> allPremiums(Pageable pageable);

		//Get Premiums...
		@Query("select new com.service.banking.model.hodAuthorityModel.PremiumDetails(p.id ,a.accountNumber,m.name ,m.fatherName,p.amount,p.paid,p.skipped ,p.dueDate ,p.paidOn ,p.agentCommissionSend ,p.agentCommissionPercentage ,p.agentCollectionChargesSend,p.agentCollectionChargesPercentage ,p.paneltyCharged, p.paneltyPosted ,p.updatedAt ,p.createdAt) from Premiums p  left join Accounts a on p.accountId =a.id  left join Members m on a.memberId =m.id where a.accountNumber = ?1 order by p.id")
		List<PremiumDetails> getByAccountNumber(String accountNumber);

		@Query("select new com.service.banking.model.hodAuthorityModel.PremiumDetails(p.amount,p.paid,p.paidOn) from Premiums p  left join Accounts a on p.accountId =a.id  left join Members m on a.memberId =m.id where a.id = ?1 order by p.id")
		List<PremiumDetails> getByPremiumAmounts(Integer accountId);

	
}