package com.service.banking.hibernateEntity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_page_elements")
public class TransactionPageElement {
	
	private Integer id;
	private Integer pageId;
	private Integer elementId;
	private Integer elementOrder;
	private byte pageElementStatus;
	
	public TransactionPageElement() {
		super();
	}
	
	

	public TransactionPageElement(Integer pageId, Integer elementId, Integer elementOrder, byte pageElementStatus) {
		super();
		this.pageId = pageId;
		this.elementId = elementId;
		this.elementOrder = elementOrder;
		this.pageElementStatus = pageElementStatus;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "page_element_id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "page_id",nullable=false)
	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	@Column(name = "elemid")
	public Integer getElementId() {
		return elementId;
	}

	public void setElementId(Integer elementId) {
		this.elementId = elementId;
	}

	@Column(name = "elementorder")
	public Integer getElementOrder() {
		return elementOrder;
	}

	public void setElementOrder(Integer elementOrder) {
		this.elementOrder = elementOrder;
	}

	@Column(name = "page_element_status")
	public byte getPageElementStatus() {
		return pageElementStatus;
	}

	public void setPageElementStatus(byte pageElementStatus) {
		this.pageElementStatus = pageElementStatus;
	}

}
