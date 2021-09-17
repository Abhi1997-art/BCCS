package com.service.banking.repository.AccountsRepo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Comment;
import com.service.banking.model.accountsModel.CommentDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CommentsRepo extends JpaRepository<Comment, Integer>{
	//get Comments API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab...........
	@Query("select new com.service.banking.model.accountsModel.CommentDetails(c.id, c.accounts.id, c.members.id, "
			+ "c.narration, c.createdAt, c.updatedAt, c.accounts.accountNumber, c.members.name, c.members.fatherName) from Comment c " +
			" where c.accounts.id = ?1 ")
	public List<CommentDetails> getCommentsOnAccounts(Integer id);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Comment \n" +
			"where account_id = ?1",
			nativeQuery = true)
    void deleteComment(Integer id);
}