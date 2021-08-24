package com.service.banking.repository.AccountsRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.DocumentsSubmitted;
import com.service.banking.model.accountsModel.DocumentsSubmittedDetails;
import com.service.banking.model.report.iDepositeReport;
import org.springframework.transaction.annotation.Transactional;

public interface DocumentsSubmittedRepo extends JpaRepository<DocumentsSubmitted, Integer> {


    // Get Documents API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab.............
    @Query("select new com.service.banking.model.accountsModel.DocumentsSubmittedDetails(ds.id, ds.accountsId, d.id, d.name, ds.description, ds.docImageId, ds.submittedOn) from DocumentsSubmitted ds "
            + "left join Documents d on ds.documentsId = d.id where ds.accountsId = ?1")
    public List<DocumentsSubmittedDetails> getDocumentsOfAccount(Integer accountId);


    @Query(value = "select  a2.AccountNumber, m.name, m.PhoneNos , s.name as schemeName, a2.Amount, \r\n"
            + "DATE_ADD(DATE(a2.created_at) , INTERVAL s.MaturityPeriod day) as maturity,\r\n"
            + "ds.Description, m2.name as agentName ,m2.PhoneNos as agentPhoneno, a2.created_at from documents_submitted ds  \r\n"
            + "left join accounts a2 on a2.id = ds.accounts_id \r\n"
            + "left join members m on m.id = a2.member_id \r\n"
            + "left join schemes s on s.id = a2.scheme_id \r\n"
            + "left join agents a3 on a3.id = a2.agent_id \r\n"
            + "left join members m2 on m2.id = a3.member_id \r\n"
            + "where ds.accounts_id IN (select a.id from accounts a where a.agent_id=?1) and a2.ActiveStatus=1\r\n"
            + "order by ds.id DESC ", nativeQuery = true)
    public List<iDepositeReport> getPremiumRecievedList(Integer agentId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM documents_submitted \n" +
            "where accounts_id = ?1",
            nativeQuery = true)
    void deleteDocumentSubmitted(Integer id);
}