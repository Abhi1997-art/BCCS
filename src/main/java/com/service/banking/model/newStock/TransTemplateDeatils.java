package com.service.banking.model.newStock;

public class TransTemplateDeatils {
	
	public Integer id;
	public String name;
	public Boolean fromBranch;
	public Boolean fromSupplier;
	public Boolean fromStaff;
	public Boolean fromAgent;
	public Boolean fromDealer;
	public String itemCategories;
	public Boolean fromContainer;
	public Boolean fromContainerRow;
	public String fromContainerTypes;
	public Boolean toBranch;
	public Boolean toSupplier;
	public Boolean toStaff;
	public Boolean toAgent;
	public Boolean toDealer;
	public Boolean toContainer;
	public String toContainerTypes;
	public Boolean toContainerRow;
	public Boolean qty;
	public Boolean narration;
	public Boolean items;
	public Boolean rate;
	public Boolean alwaysFromCurrentBranch;
	public Boolean fromDefaultContainerRow;
	public Boolean alwaysToCurrentBranch;
	public Boolean toDefaultContainerRow;
	public Boolean checkFromQty;
	public Boolean subtractQtyFrom;
	public Boolean addQtyTo;
	public String allowedToAccesslevel;
	
	
	
	
	public TransTemplateDeatils(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public TransTemplateDeatils(Integer id, String name, Boolean fromBranch, Boolean fromSupplier, Boolean fromStaff,
			Boolean fromAgent, Boolean fromDealer, String itemCategories, Boolean fromContainer,
			Boolean fromContainerRow, String fromContainerTypes, Boolean toBranch, Boolean toSupplier, Boolean toStaff,
			Boolean toAgent, Boolean toDealer, Boolean toContainer, String toContainerTypes, Boolean toContainerRow,
			Boolean qty, Boolean narration, Boolean items, Boolean rate, Boolean alwaysFromCurrentBranch,
			Boolean fromDefaultContainerRow, Boolean alwaysToCurrentBranch, Boolean toDefaultContainerRow,
			Boolean checkFromQty, Boolean subtractQtyFrom, Boolean addQtyTo, String allowedToAccesslevel) {
		super();
		this.id = id;
		this.name = name;
		this.fromBranch = fromBranch;
		this.fromSupplier = fromSupplier;
		this.fromStaff = fromStaff;
		this.fromAgent = fromAgent;
		this.fromDealer = fromDealer;
		this.itemCategories = itemCategories;
		this.fromContainer = fromContainer;
		this.fromContainerRow = fromContainerRow;
		this.fromContainerTypes = fromContainerTypes;
		this.toBranch = toBranch;
		this.toSupplier = toSupplier;
		this.toStaff = toStaff;
		this.toAgent = toAgent;
		this.toDealer = toDealer;
		this.toContainer = toContainer;
		this.toContainerTypes = toContainerTypes;
		this.toContainerRow = toContainerRow;
		this.qty = qty;
		this.narration = narration;
		this.items = items;
		this.rate = rate;
		this.alwaysFromCurrentBranch = alwaysFromCurrentBranch;
		this.fromDefaultContainerRow = fromDefaultContainerRow;
		this.alwaysToCurrentBranch = alwaysToCurrentBranch;
		this.toDefaultContainerRow = toDefaultContainerRow;
		this.checkFromQty = checkFromQty;
		this.subtractQtyFrom = subtractQtyFrom;
		this.addQtyTo = addQtyTo;
		this.allowedToAccesslevel = allowedToAccesslevel;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getFromBranch() {
		return fromBranch;
	}
	public void setFromBranch(Boolean fromBranch) {
		this.fromBranch = fromBranch;
	}
	public Boolean getFromSupplier() {
		return fromSupplier;
	}
	public void setFromSupplier(Boolean fromSupplier) {
		this.fromSupplier = fromSupplier;
	}
	public Boolean getFromStaff() {
		return fromStaff;
	}
	public void setFromStaff(Boolean fromStaff) {
		this.fromStaff = fromStaff;
	}
	public Boolean getFromAgent() {
		return fromAgent;
	}
	public void setFromAgent(Boolean fromAgent) {
		this.fromAgent = fromAgent;
	}
	public Boolean getFromDealer() {
		return fromDealer;
	}
	public void setFromDealer(Boolean fromDealer) {
		this.fromDealer = fromDealer;
	}
	public String getItemCategories() {
		return itemCategories;
	}
	public void setItemCategories(String itemCategories) {
		this.itemCategories = itemCategories;
	}
	public Boolean getFromContainer() {
		return fromContainer;
	}
	public void setFromContainer(Boolean fromContainer) {
		this.fromContainer = fromContainer;
	}
	public Boolean getFromContainerRow() {
		return fromContainerRow;
	}
	public void setFromContainerRow(Boolean fromContainerRow) {
		this.fromContainerRow = fromContainerRow;
	}
	public String getFromContainerTypes() {
		return fromContainerTypes;
	}
	public void setFromContainerTypes(String fromContainerTypes) {
		this.fromContainerTypes = fromContainerTypes;
	}
	public Boolean getToBranch() {
		return toBranch;
	}
	public void setToBranch(Boolean toBranch) {
		this.toBranch = toBranch;
	}
	public Boolean getToSupplier() {
		return toSupplier;
	}
	public void setToSupplier(Boolean toSupplier) {
		this.toSupplier = toSupplier;
	}
	public Boolean getToStaff() {
		return toStaff;
	}
	public void setToStaff(Boolean toStaff) {
		this.toStaff = toStaff;
	}
	public Boolean getToAgent() {
		return toAgent;
	}
	public void setToAgent(Boolean toAgent) {
		this.toAgent = toAgent;
	}
	public Boolean getToDealer() {
		return toDealer;
	}
	public void setToDealer(Boolean toDealer) {
		this.toDealer = toDealer;
	}
	public Boolean getToContainer() {
		return toContainer;
	}
	public void setToContainer(Boolean toContainer) {
		this.toContainer = toContainer;
	}
	public String getToContainerTypes() {
		return toContainerTypes;
	}
	public void setToContainerTypes(String toContainerTypes) {
		this.toContainerTypes = toContainerTypes;
	}
	public Boolean getToContainerRow() {
		return toContainerRow;
	}
	public void setToContainerRow(Boolean toContainerRow) {
		this.toContainerRow = toContainerRow;
	}
	public Boolean getQty() {
		return qty;
	}
	public void setQty(Boolean qty) {
		this.qty = qty;
	}
	public Boolean getNarration() {
		return narration;
	}
	public void setNarration(Boolean narration) {
		this.narration = narration;
	}
	public Boolean getItems() {
		return items;
	}
	public void setItems(Boolean items) {
		this.items = items;
	}
	public Boolean getRate() {
		return rate;
	}
	public void setRate(Boolean rate) {
		this.rate = rate;
	}
	public Boolean getAlwaysFromCurrentBranch() {
		return alwaysFromCurrentBranch;
	}
	public void setAlwaysFromCurrentBranch(Boolean alwaysFromCurrentBranch) {
		this.alwaysFromCurrentBranch = alwaysFromCurrentBranch;
	}
	public Boolean getFromDefaultContainerRow() {
		return fromDefaultContainerRow;
	}
	public void setFromDefaultContainerRow(Boolean fromDefaultContainerRow) {
		this.fromDefaultContainerRow = fromDefaultContainerRow;
	}
	public Boolean getAlwaysToCurrentBranch() {
		return alwaysToCurrentBranch;
	}
	public void setAlwaysToCurrentBranch(Boolean alwaysToCurrentBranch) {
		this.alwaysToCurrentBranch = alwaysToCurrentBranch;
	}
	public Boolean getToDefaultContainerRow() {
		return toDefaultContainerRow;
	}
	public void setToDefaultContainerRow(Boolean toDefaultContainerRow) {
		this.toDefaultContainerRow = toDefaultContainerRow;
	}
	public Boolean getCheckFromQty() {
		return checkFromQty;
	}
	public void setCheckFromQty(Boolean checkFromQty) {
		this.checkFromQty = checkFromQty;
	}
	public Boolean getSubtractQtyFrom() {
		return subtractQtyFrom;
	}
	public void setSubtractQtyFrom(Boolean subtractQtyFrom) {
		this.subtractQtyFrom = subtractQtyFrom;
	}
	public Boolean getAddQtyTo() {
		return addQtyTo;
	}
	public void setAddQtyTo(Boolean addQtyTo) {
		this.addQtyTo = addQtyTo;
	}
	public String getAllowedToAccesslevel() {
		return allowedToAccesslevel;
	}
	public void setAllowedToAccesslevel(String allowedToAccesslevel) {
		this.allowedToAccesslevel = allowedToAccesslevel;
	}

	
	

}
