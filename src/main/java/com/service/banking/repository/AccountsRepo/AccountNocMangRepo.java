package com.service.banking.repository.AccountsRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Noclog;
import com.service.banking.model.LoginUserDeails;
import com.service.banking.model.accountsModel.PendingLoanDetails;
import com.service.banking.model.accountsModel.ReceiveNocDetails;
import com.service.banking.model.accountsModel.ReturnNocDetails;
import com.service.banking.model.accountsModel.SendNocDetails;
import com.service.banking.model.accountsModel.iReceiveNocDetails;

public interface AccountNocMangRepo extends JpaRepository<Noclog, Integer> {

    // send noc deatils...........
    @Query("select new com.service.banking.model.accountsModel.SendNocDetails(n.id, a.accountNumber ,m.name ,m.fatherName ,n.nocLetterReceivedOn , tob.name ,n.sendAt ,n.sendNarration , \r\n"
            + "n.isDispatchToCustomer,n.isReturn, s.name, a.id, tob.id) from Noclog n  \r\n"
            + "left join Accounts a on a.id=n.accountsId    \r\n" + "left join Staffs s on s.id=n.createdById    \r\n"
            + "left join Members m on m.id=a.memberId     \r\n" + "left join Branches frob on frob.id=n.fromBranchId    \r\n" +
			" left join Branches tob on tob.id=n.toBranchId " +
            " where n.receivedById = 0 or  n.receivedById = null " +
            " and a.accountNumber like %?1% "
            + "order by n.id DESC ")
    List<SendNocDetails> getSendNoc(String search);

    // return noc deatils...........
    @Query("select new com.service.banking.model.accountsModel.ReturnNocDetails( n.id,a.accountNumber ,m.name  ,n.nocLetterReceivedOn ,n.sendAt,cr_s.name ,frob.name, n.sendNarration ,n.receivedAt,rcv_s.name ,tob.name ,n.receivedNarration ,n.isReturn ,n.returnAt ,rtrn_s.name ,n.returnNarration,rtrn_rcv_s.name ,n.returnReceivedNarration) \r\n"
            + "from Noclog n\r\n" + "left join Accounts a on a.id=n.accountsId \r\n"
            + "left join Branches frob on frob.id=n.fromBranchId \r\n"
            + "left join Branches tob on tob.id=n.toBranchId \r\n"
            + "left join Staffs cr_s on cr_s.id=n.createdById \r\n"
            + "left join Staffs rcv_s on rcv_s.id=n.receivedById \r\n"
            + "left join Staffs rtrn_s on rtrn_s.id=n.returnById \r\n"
            + "left join Staffs dis_n on dis_n.id = n.dispatchById \r\n"
            + "left join Staffs rtrn_rcv_s on rtrn_rcv_s.id=n.returnReceivedById \r\n"
            + "left join Members m on m.id=a.memberId \r\n" + "where n.isReturn = 1 order by n.id DESC")
    List<ReturnNocDetails> returnNoc();


    // recieve noc deatils...........
    @Query(value = "select \r\n"
            + "n.id, a.AccountNumber ,m.name  ,\r\n"
            + "n.noc_letter_received_on as nocLetterReceivedOn,\r\n"
            + "CASE WHEN (n.send_at IS NULL) THEN \"0000-00-00\" ELSE n.send_at END as sendAt,\r\n"
            + "cr_s.name as createdBy,\r\n"
            + "frob.name as fromBranchName, \r\n"
            + "n.send_narration as sendNarration,\r\n"
            + "CASE WHEN (n.received_at IS NULL) THEN \"0000-00-00\" ELSE n.received_at END as receivedAt,\r\n"
            + "rcv_s.name  as receivedByIdName,\r\n"
            + "tob.name as toBranchName ,\r\n"
            + "n.received_narration as receivedNarration,\r\n"
            + "n.is_dispatch_to_customer as isDispatchtoCustomer ,\r\n"
            + "CASE WHEN (n.dispatch_at IS NULL) THEN \"0000-00-00\" ELSE n.dispatch_at END as dispatchAt,\r\n"
            + "dis_patch.name as dispatchByIdName,\r\n"
            + "n.dispatch_narration  as dispatchNarration,\r\n"
            + "n.is_return as isReturn,\r\n"
            + "CASE WHEN (n.return_at IS NULL) THEN \"0000-00-00\" ELSE n.return_at END as returnAt,\r\n"
            + "rtrn_s.name as returnByIdName,\r\n"
            + "n.return_narration as returnNarration,\r\n"
            + "rtrn_rcv_s.name as returnRecivedName,\r\n"
            + "n.return_received_narration as returnReceivedName,\r\n"
            + "n.noc_hold_due_to as nocHoldDueTo,\r\n"
            + "n.noc_not_made_due_to as nocNotMadeDue\r\n"
            + "from noclog n \r\n"
            + "left join accounts a on a.id=n.accounts_id \r\n"
            + "left join branches frob on frob.id=n.from_branch_id \r\n"
            + "left join branches tob on tob.id=n.to_branch_id \r\n"
            + "left join staffs cr_s on cr_s.id=n.created_by_id \r\n"
            + "left join staffs rcv_s on rcv_s.id=n.received_by_id \r\n"
            + "left join staffs dis_patch on dis_patch.id=n.dispatch_by_id \r\n"
            + "left join staffs rtrn_rcv_s on rtrn_rcv_s.id=n.return_received_by_id \r\n"
            + "left join staffs rtrn_s on rtrn_s.id=n.return_by_id \r\n"
            + "left join members m on m.id=a.member_id order by n.id DESC", nativeQuery = true)
    public List<iReceiveNocDetails> receiveNoc();


}
