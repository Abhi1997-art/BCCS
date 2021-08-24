package com.service.banking.repository.AccountsRepo;

import com.service.banking.model.accountsModel.iJointMember;
import org.springframework.data.jpa.repository.JpaRepository;

import com.service.banking.hibernateEntity.Jointmembers;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JointMemberRepo extends JpaRepository<Jointmembers, Integer>{

    @Query(value = "select j.id, a.AccountNumber , m2.name , m2.FatherName , m.name as memberName from jointmembers j \n" +
            "left join accounts a on a.id = j.account_id \n" +
            "left join members m2 on m2.id = a.member_id \n" +
            "left join members m on m.id = j.member_id \n" +
            "where a.id = ?1 ",
    nativeQuery = true)
    List<iJointMember> getJointMember(Integer accountId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM jointmembers \n" +
            "where account_id = ?1",
    nativeQuery = true)
    void deleteJointMembers(Integer id);
}
