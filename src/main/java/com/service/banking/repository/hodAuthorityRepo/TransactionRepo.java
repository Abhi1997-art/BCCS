package com.service.banking.repository.hodAuthorityRepo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Transactions;
import com.service.banking.model.hodAuthorityModel.IInvoiceDetails;
import com.service.banking.model.hodAuthorityModel.TransactionRowDetails;

public interface TransactionRepo extends JpaRepository<Transactions, Integer> {
	// get all invoice transaction...............
	@Query("from Transactions   where invoiceNo !=' ' ")
	List<Transactions> allTransactions();


	@Query(value = "select t.id as id, tt.id as transactionTypeId, tt.name as transactionTypeName, s.id as StaffId, s.name as StaffName, "
			+ "a.AccountNumber as referenceAccountNumber, a.id as referenceAccountId, m.id as referenceMemberId, \r\n"
			+ "			m.name as referenceMemberName, m.FatherName as referenceFatherName, b.id as branchId, b.name as branchName, "
			+ "t.voucher_no_original as voucherNoOriginal, t.voucher_no as VoucherNo, t.narration as narration, t.created_at as createdAt, "
			+ "t.updated_at as updatedAt, t.invoice_no as invoiceNo, t.is_invoice_cancel as isInvoiceCancel, \r\n"
			+ "			tr.id as transactionRowId,  SUM(tr.amountCr) as CrSum, sum(tr.amountDr) as DrSum from transactions t left join transaction_types tt \r\n"
			+ "			on t.transaction_type_id = tt.id left join staffs s on t.staff_id = s.id left join accounts a on t.reference_id = a.id \r\n"
			+ "			left join branches b on t.branch_id = b.id left join transaction_row tr on tr.transaction_id = t.id left join members m \r\n"
			+ "			on m.id = a.member_id group by tr.transaction_id", countQuery = "select count(*) from transactions t left join transaction_types tt \r\n"
					+ "			on t.transaction_type_id = tt.id left join staffs s on t.staff_id = s.id left join accounts a on t.reference_id = a.id \r\n"
					+ "			left join branches b on t.branch_id = b.id left join transaction_row tr on tr.transaction_id = t.id left join members m \r\n"
					+ "			on m.id = a.member_id group by tr.transaction_id", nativeQuery = true)
	public Page<IInvoiceDetails> getInvoices(Pageable pageable);


	@Query("select new com.service.banking.model.hodAuthorityModel.TransactionRowDetails(t.id, tr.accountId, a.accountNumber, m.id, m.name, m.fatherName, "
			+ "sc.id, sc.name, bl.id, bl.name, tr.amountDr, tr.amountCr, tr.side, tr.accountsInSide, tr.createdAt, tr.voucherNo, tr.narration, tt.id, "
			+ "tt.name, b.id, b.name, a1.id, a1.accountNumber, m1.id, m1.name, m1.fatherName) "
			+ "from Transactions t left join TransactionRow tr on t.id = tr.transactionId left join TransactionTypes tt on tr.transactionTypeId = tt.id"
			+ " left join Accounts a on tr.accountId = a.id left join Members m "
			+ "on m.id = a.memberId left join Schemes sc on tr.schemeId = sc.id left join BalanceSheet bl on bl.id = tr.balanceSheetId left join Branches b "
			+ "on b.id = tr.branchId left join Accounts a1 on tr.referenceAccountId = a1.id left join Members m1 on m1.id = a1.memberId "
			+ "where t.id = ?1")
	public List<TransactionRowDetails> getTransactionRowForInvoice(Integer id);
}
