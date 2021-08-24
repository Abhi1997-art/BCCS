package com.service.banking.repository.transaction;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Transactions;
import com.service.banking.model.superAdminModel.StaffModel;
import com.service.banking.model.transaction.ITransactionModel;

public interface TransactionsRepo extends JpaRepository<Transactions, Integer> {

	@Query(value = "select t.voucher_no as lastVoucherNo from transactions t where branch_id = ?1 order by t.id desc limit 1;", nativeQuery = true)
	ITransactionModel getTotalDebitSide(Integer accountId);

	@Query(value = "select t.voucher_no as vocherNo, t.created_at as createdAt from transactions t where t.branch_id = ?1 and t.created_at >= ?2 and t.created_at < ?3",nativeQuery = true)
	List<ITransactionModel> getListVoucher(Integer branchId, String rangeFrom, String rangeTo);

	@Query("select new com.service.banking.model.superAdminModel.StaffModel(count(tr.id) as transactions) from Transactions tr  \r\n"
			+ "left join Staffs s on s.id = tr.staffId \r\n"
			+ "where s.id = ?1 ")
	StaffModel getTransactions(Integer id);

	@Query(value = "select count(*) from transactions t \n" +
			"where t.reference_id = ?1",
	nativeQuery = true)
    Integer getTransactionCountForAccount(Integer id);
}
