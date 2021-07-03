package com.service.banking.model.newStock;

public class StockContainerRow {
	  //sc.id,br.name,sct.name,sc.name
		Integer id;
		Integer branchId;
		String branchName;
		String caintainerType;
		Integer containerTypeId;
		Integer stocknewContainerRowId;
		String stockNewContainerRowName;
		String name;
		
		Boolean isDefault;
		
		
		
		public StockContainerRow() {
			super();
		}



		public StockContainerRow(Integer id, String branchName, String caintainerType, String name) {
			super();
			this.id = id;
			this.branchName = branchName;
			this.caintainerType = caintainerType;
			this.name = name;
		}
		
		public StockContainerRow(Integer id, String name) {
			super();
			this.id = id;
			this.name = name;
		}


		public StockContainerRow(Integer id, Integer branchId, String branchName, String caintainerType,
				Integer containerTypeId, String name) {
			super();
			this.id = id;
			this.branchId = branchId;
			this.branchName = branchName;
			this.caintainerType = caintainerType;
			this.containerTypeId = containerTypeId;
			this.name = name;
		}
		public StockContainerRow(Integer id, String containerName, Integer branchId, String stockNewContainerRowName, Boolean isDefault) {
			this.id = id;
			this.name = containerName;
			this.branchId = branchId;
			this.stockNewContainerRowName = stockNewContainerRowName;
			this.isDefault = isDefault;
		}



		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
		
		public Boolean getIsDefault() {
			return isDefault;
		}

		public void setIsDefault(Boolean isDefault) {
			this.isDefault = isDefault;
		}
		
		

		public String getStockNewContainerRowName() {
			return stockNewContainerRowName;
		}



		public void setStockNewContainerRowName(String stockNewContainerRowName) {
			this.stockNewContainerRowName = stockNewContainerRowName;
		}



		public Integer getStocknewContainerRowId() {
			return stocknewContainerRowId;
		}



		public void setStocknewContainerRowId(Integer stocknewContainerRowId) {
			this.stocknewContainerRowId = stocknewContainerRowId;
		}



		public Integer getContainerTypeId() {
			return containerTypeId;
		}



		public void setContainerTypeId(Integer containerTypeId) {
			this.containerTypeId = containerTypeId;
		}



		public Integer getBranchId() {
			return branchId;
		}



		public void setBranchId(Integer branchId) {
			this.branchId = branchId;
		}



		public String getBranchName() {
			return branchName;
		}



		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}



		public String getCaintainerType() {
			return caintainerType;
		}



		public void setCaintainerType(String caintainerType) {
			this.caintainerType = caintainerType;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}
		
		
		
	}