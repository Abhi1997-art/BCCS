package com.service.banking.repository.madRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.banking.hibernateEntity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
