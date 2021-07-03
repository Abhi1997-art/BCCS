package com.service.banking.model.accountsModel;

import java.util.Date;

public class DocumentsSubmittedDetails {
	private Integer docSubmittedId;
	private Integer accountId;
	private Integer documentId;
	private String documentName;
	private String description;
	private Integer docImageId;
	private Date submittedOn;
	
	public DocumentsSubmittedDetails() {
		super();
	}
	
	
	
	public DocumentsSubmittedDetails(Integer documentId, String documentName) {
		super();
		this.documentId = documentId;
		this.documentName = documentName;
	}



	public DocumentsSubmittedDetails(Integer docSubmittedId, Integer accountId, Integer documentId, String documentName, String description, Integer docImageId, Date submittedOn) {
		super();
		this.docSubmittedId = docSubmittedId;
		this.accountId = accountId;
		this.documentId = documentId;
		this.documentName = documentName;
		this.description = description;
		this.docImageId = docImageId;
		this.submittedOn = submittedOn;
	}

	public Integer getDocSubmittedId() {
		return docSubmittedId;
	}

	public void setDocSubmittedId(Integer docSubmittedId) {
		this.docSubmittedId = docSubmittedId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDocImageId() {
		return docImageId;
	}

	public void setDocImageId(Integer docImageId) {
		this.docImageId = docImageId;
	}

	public Date getSubmittedOn() {
		return submittedOn;
	}

	public void setSubmittedOn(Date submittedOn) {
		this.submittedOn = submittedOn;
	}
	
	
	
}