package com.service.banking.model.newStock;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.service.banking.hibernateEntity.Branches;
import com.service.banking.hibernateEntity.StocknewContainer;
import com.service.banking.hibernateEntity.StocknewContainerrow;
import com.service.banking.hibernateEntity.StocknewItems;
import com.service.banking.hibernateEntity.StocknewMembers;
import com.service.banking.hibernateEntity.StocknewTransactiontemplate;

@JsonInclude(Include.NON_NULL)
public class TransactionDeatils {
	
	
	
	public Integer id;
	
	public Integer transTemplateId;
	public String transTemplateName;
	
	public Integer fromBrnchId;
	public String fromBrnchName;
	
	public Integer fromMemberId;
	public String fromMemberName;
	
	public Integer fromContId;
	public String fromContName;
	
	public Integer fromContRowId;
	public String fromContRowName;
	
	public Integer toBrnchId;
	public String toBrnchName;
	
	public Integer toMemberId;
	public String toMemberName;
	
	public Integer toContId;
	public String toContName;
	
	public Integer toContRowId;
	public String toContRowName;
	
	public Integer itemId;
	public String itemName;
	
	public String qty;
	public BigDecimal rate;
	public String narration;
	public String createdAt;
	
	
	public TransactionDeatils() {
		super();
	}
	
//	public TransactionDeatils(Integer id, Integer transTemplateId, Integer fromBrnchId, Integer fromMemberId,
//			Integer fromContId, Integer fromContRowId, Integer toBrnchId, Integer toMemberId, Integer toContId, 
//			Integer toContRowId, Integer itemId, String qty, BigDecimal rate, String narration, String createdAt) {
//		this.id = id;
//		this.transTemplateId = transTemplateId;
//		this.fromBrnchId = fromBrnchId;
//		this.fromMemberId = fromMemberId;
//		this.fromContId = fromContId;
//		this.fromContRowId = fromContRowId;
//		this.toBrnchId = toBrnchId;
//		this.toMemberId = toMemberId;
//		this.toContId = toContId;
//		this.toContRowId = toContRowId;
//		this.itemId = itemId;
//		this.qty = qty;
//		this.rate = rate;
//		this.narration = narration;
//		this.createdAt = createdAt;
//	}
	
	public TransactionDeatils(Integer id, String transTemplateName, String fromBrnchName, String fromMemberName,
			String fromContName, String fromContRowName, String toBrnchName, String toMemberName, String toContName,
			String toContRowName, String itemName, String qty, BigDecimal rate, String narration, String createdAt) {
		super();
		this.id = id;
		this.transTemplateName = transTemplateName;
		this.fromBrnchName = fromBrnchName;
		this.fromMemberName = fromMemberName;
		this.fromContName = fromContName;
		this.fromContRowName = fromContRowName;
		this.toBrnchName = toBrnchName;
		this.toMemberName = toMemberName;
		this.toContName = toContName;
		this.toContRowName = toContRowName;
		this.itemName = itemName;
		this.qty = qty;
		this.rate = rate;
		this.narration = narration;
		this.createdAt = createdAt;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTransTemplateName() {
		return transTemplateName;
	}
	public void setTransTemplateName(String transTemplateName) {
		this.transTemplateName = transTemplateName;
	}
	public String getFromBrnchName() {
		return fromBrnchName;
	}
	public void setFromBrnchName(String fromBrnchName) {
		this.fromBrnchName = fromBrnchName;
	}
	public String getFromMemberName() {
		return fromMemberName;
	}
	public void setFromMemberName(String fromMemberName) {
		this.fromMemberName = fromMemberName;
	}
	public String getFromContName() {
		return fromContName;
	}
	public void setFromContName(String fromContName) {
		this.fromContName = fromContName;
	}
	public String getFromContRowName() {
		return fromContRowName;
	}
	public void setFromContRowName(String fromContRowName) {
		this.fromContRowName = fromContRowName;
	}
	public String getToBrnchName() {
		return toBrnchName;
	}
	public void setToBrnchName(String toBrnchName) {
		this.toBrnchName = toBrnchName;
	}
	public String getToMemberName() {
		return toMemberName;
	}
	public void setToMemberName(String toMemberName) {
		this.toMemberName = toMemberName;
	}
	public String getToContName() {
		return toContName;
	}
	public void setToContName(String toContName) {
		this.toContName = toContName;
	}
	public String getToContRowName() {
		return toContRowName;
	}
	public void setToContRowName(String toContRowName) {
		this.toContRowName = toContRowName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public String getNarration() {
		return narration;
	}
	public void setNarration(String narration) {
		this.narration = narration;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	public Integer getTransTemplateId() {
		return transTemplateId;
	}


	public void setTransTemplateId(Integer transTemplateId) {
		this.transTemplateId = transTemplateId;
	}


	public Integer getFromBrnchId() {
		return fromBrnchId;
	}


	public void setFromBrnchId(Integer fromBrnchId) {
		this.fromBrnchId = fromBrnchId;
	}


	public Integer getFromMemberId() {
		return fromMemberId;
	}


	public void setFromMemberId(Integer fromMemberId) {
		this.fromMemberId = fromMemberId;
	}


	public Integer getFromContId() {
		return fromContId;
	}


	public void setFromContId(Integer fromContId) {
		this.fromContId = fromContId;
	}


	public Integer getFromContRowId() {
		return fromContRowId;
	}


	public void setFromContRowId(Integer fromContRowId) {
		this.fromContRowId = fromContRowId;
	}


	public Integer getToBrnchId() {
		return toBrnchId;
	}


	public void setToBrnchId(Integer toBrnchId) {
		this.toBrnchId = toBrnchId;
	}


	public Integer getToMemberId() {
		return toMemberId;
	}


	public void setToMemberId(Integer toMemberId) {
		this.toMemberId = toMemberId;
	}


	public Integer getToContId() {
		return toContId;
	}


	public void setToContId(Integer toContId) {
		this.toContId = toContId;
	}


	public Integer getToContRowId() {
		return toContRowId;
	}


	public void setToContRowId(Integer toContRowId) {
		this.toContRowId = toContRowId;
	}


	public Integer getItemId() {
		return itemId;
	}


	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
}