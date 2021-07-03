package com.service.banking.model.accountsModel;

import java.util.Date;

public class CommentDetails {
	private Integer commentId;
	private Integer accountId;
	private Integer memberId;
	private String narration;
	private Date createdAt;
	private Date updatedAt;
	
	public CommentDetails() {
		super();
	}
	public CommentDetails(Integer commentId, Integer accountId, Integer memberId, String narration, Date createdAt, Date updatedAt) {
		super();
		this.commentId = commentId;
		this.accountId = accountId;
		this.memberId = memberId;
		this.narration = narration;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getNarration() {
		return narration;
	}
	public void setNarration(String narration) {
		this.narration = narration;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}