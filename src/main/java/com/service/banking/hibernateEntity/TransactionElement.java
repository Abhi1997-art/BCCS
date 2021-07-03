package com.service.banking.hibernateEntity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.id.IntegralDataTypeHolder;


@Entity
@Table(name = "transaction_elements")
public class TransactionElement {


private Integer id;
private String elementCode;
private String elementType;
private String elementDesc;

public TransactionElement() {
	super();
}

public TransactionElement(String elementCode, String elementType, String elementDesc) {
	super();
	this.elementCode = elementCode;
	this.elementType = elementType;
	this.elementDesc = elementDesc;
}


@Id
@GeneratedValue(strategy = IDENTITY)
@Column(name = "elemid", unique = true, nullable = false)
public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}
@Column(name = "elemcode",nullable = false)
public String getElementCode() {
	return elementCode;
}

public void setElementCode(String elementCode) {
	this.elementCode = elementCode;
}
@Column(name = "elemtype")
public String getElementType() {
	return elementType;
}

public void setElementType(String elementType) {
	this.elementType = elementType;
}
@Column(name = "elemdesc")
public String getElementDesc() {
	return elementDesc;
}

public void setElementDesc(String elementDesc) {
	this.elementDesc = elementDesc;
}






}
