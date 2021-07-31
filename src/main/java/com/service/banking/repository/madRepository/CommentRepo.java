package com.service.banking.repository.madRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.banking.hibernateEntity.Comment;
import com.service.banking.model.hodAuthorityModel.iCommentDetails;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

	@Query(value="select c.id, c.narration , c.created_at ,m.name, m.member_no , m.CurrentAddress , m.PermanentAddress , m.is_defaulter , m.FatherName from Comment c \r\n"
			+ "left join members m on m.id = c.member_id \r\n"
			+ "where m.id = ?1",
			nativeQuery = true)
	List<iCommentDetails> getComments(Integer memberId);

}
