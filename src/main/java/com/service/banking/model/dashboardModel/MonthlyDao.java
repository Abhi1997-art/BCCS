package com.service.banking.model.dashboardModel;

import java.util.List;

public class MonthlyDao {

	
	Integer size;
	Integer totalPages;
	Long totalElements;
	List<DueDeatailsModel> dueDeatailsModels;
	
	
	public MonthlyDao() {
		super();
	}
	
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	public List<DueDeatailsModel> getDueDeatailsModels() {
		return dueDeatailsModels;
	}
	public void setDueDeatailsModels(List<DueDeatailsModel> dueDeatailsModels) {
		this.dueDeatailsModels = dueDeatailsModels;
	}
	
	
	
	
}
