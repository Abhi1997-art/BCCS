package com.service.banking.model.transaction;

import java.util.List;

public class PageUpdateReq {
	
	public Integer id;
	public String pageName;
	public String pageType;
	public Integer pageOrder;
	public Boolean status;
	
	List<PageElementReq> pageElementReqs;

	
	
	public PageUpdateReq() {
		super();
	}

	public PageUpdateReq(Integer id, String pageName, String pageType, Integer pageOrder, Boolean status,
			List<PageElementReq> pageElementReqs) {
		super();
		this.id = id;
		this.pageName = pageName;
		this.pageType = pageType;
		this.pageOrder = pageOrder;
		this.status = status;
		this.pageElementReqs = pageElementReqs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public Integer getPageOrder() {
		return pageOrder;
	}

	public void setPageOrder(Integer pageOrder) {
		this.pageOrder = pageOrder;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<PageElementReq> getPageElementReqs() {
		return pageElementReqs;
	}

	public void setPageElementReqs(List<PageElementReq> pageElementReqs) {
		this.pageElementReqs = pageElementReqs;
	}
	
   
}
