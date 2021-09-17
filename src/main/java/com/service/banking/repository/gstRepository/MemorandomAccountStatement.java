package com.service.banking.repository.gstRepository;

import java.util.Date;
import java.util.List;

import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.MemorandumTransactionsrow;
import com.service.banking.model.GstModel.AccountStatementDetail;

public interface MemorandomAccountStatement extends JpaRepository<MemorandumTransactionsrow, Integer> {
	
	// get account statement.....
			@Query("select new com.service.banking.model.GstModel.AccountStatementDetail(mr.id,mt.memorandumType ,a.accountNumber ,m.name ,m.fatherName,mt.narration ,mr.createdAt ,mr.tax ,mr.taxAmount ,mr.taxNarration, " + 
					"mr.amountCr ,mr.amountDr, sum(mr2.amountCr) - sum(mr2.amountDr) as balance) from MemorandumTransactionsrow mr " +
					"left join MemorandumTransactions mt on mt.id=mr.memorandumTransactionId " + 
					"left join Accounts a on a.id=mr.accountId " + 
					"left join Members m on m.id=a.memberId " +
					" left join MemorandumTransactionsrow mr2 on mr2.accountId = a.id and mr2.createdAt <= mr.createdAt " +
					"where mr.accountId =?1 and date(mr.createdAt) >=?2 and date(mr.createdAt) <=?3 " +
					" group by mr.id  order by mr.createdAt ")
			public List<AccountStatementDetail> accountStatement(Integer id,Date fromDate,Date toDate);  
	

}
