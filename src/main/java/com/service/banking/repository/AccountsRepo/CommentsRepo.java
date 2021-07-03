package com.service.banking.repository.AccountsRepo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Comment;
import com.service.banking.model.accountsModel.CommentDetails;

public interface CommentsRepo extends JpaRepository<Comment, Integer>{
	//get Comments API inside "Accounts" tab inside "Loan" tab inside "Accounts" tab...........
	@Query("select new com.service.banking.model.accountsModel.CommentDetails(c.id, c.accounts.id, c.members.id, "
			+ "c.narration, c.createdAt, c.updatedAt) from Comment c where c.accounts.id = ?1")
	public List<CommentDetails> getCommentsOnAccounts(Integer id);
}