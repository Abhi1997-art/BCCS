package com.service.banking.model.superAdminModel;

import com.service.banking.hibernateEntity.Staffs;

public class AclDetails {
	
	public Integer id;
	public String staffName;
	public Integer staffId;
	public String class_;
	public Boolean canView;
	public Boolean isAllBranchAllowed;
	public Boolean allowAdd;
	public Boolean allowEdit;
	public Boolean allowDel;
	
	public String documentName;
	public Integer documentId;
	
	
	
	public AclDetails() {
		super();
	}
	//int, java.lang.String, int, java.lang.String, boolean, boolean, boolean, boolean, boolean
	
	public AclDetails(Integer id, String staffName, Integer staffId, String class_, Boolean canView,
			Boolean isAllBranchAllowed, Boolean allowAdd, Boolean allowEdit, Boolean allowDel) {
		super();
		this.id = id;
		this.staffName = staffName;
		this.staffId = staffId;
		this.class_ = class_;
		this.canView = canView;
		this.isAllBranchAllowed = isAllBranchAllowed;
		this.allowAdd = allowAdd;
		this.allowEdit = allowEdit;
		this.allowDel = allowDel;
	}
	
	public AclDetails(Integer id, String staffName, Integer staffId, String class_, Boolean canView,
			Boolean isAllBranchAllowed, Boolean allowAdd, Boolean allowEdit, Boolean allowDel,String documentName,Integer documentId) {
		super();
		this.id = id;
		this.staffName = staffName;
		this.staffId = staffId;
		this.class_ = class_;
		this.canView = canView;
		this.isAllBranchAllowed = isAllBranchAllowed;
		this.allowAdd = allowAdd;
		this.allowEdit = allowEdit;
		this.allowDel = allowDel;
		this.documentName=documentName;
		this.documentId=documentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getClass_() {
		return class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public Boolean getCanView() {
		return canView;
	}

	public void setCanView(Boolean canView) {
		this.canView = canView;
	}

	public Boolean getIsAllBranchAllowed() {
		return isAllBranchAllowed;
	}

	public void setIsAllBranchAllowed(Boolean isAllBranchAllowed) {
		this.isAllBranchAllowed = isAllBranchAllowed;
	}

	public Boolean getAllowAdd() {
		return allowAdd;
	}

	public void setAllowAdd(Boolean allowAdd) {
		this.allowAdd = allowAdd;
	}

	public Boolean getAllowEdit() {
		return allowEdit;
	}

	public void setAllowEdit(Boolean allowEdit) {
		this.allowEdit = allowEdit;
	}

	public Boolean getAllowDel() {
		return allowDel;
	}

	public void setAllowDel(Boolean allowDel) {
		this.allowDel = allowDel;
	}
	
	
	
	
}
