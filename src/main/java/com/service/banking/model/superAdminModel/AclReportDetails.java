package com.service.banking.model.superAdminModel;

public class AclReportDetails {

			public Integer id;
			public String staffName;
			public Integer staffId;
			public String page;
			public Boolean isAllowed;
			
			
			
			public AclReportDetails() {
				super();

			}


			public AclReportDetails(Integer id, String staffName, Integer staffId, String page, Boolean isAllowed) {
				super();
				this.id = id;
				this.staffName = staffName;
				this.staffId = staffId;
				this.page = page;
				this.isAllowed = isAllowed;
			}


			public Integer getId() {
				return id;
			}


			public void setId(Integer id) {
				this.id = id;
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


			public String getPage() {
				return page;
			}


			public void setPage(String page) {
				this.page = page;
			}


			public Boolean getIsAllowed() {
				return isAllowed;
			}


			public void setIsAllowed(Boolean isAllowed) {
				this.isAllowed = isAllowed;
			}
			
			
			
			
		}
