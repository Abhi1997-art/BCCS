package com.service.banking.model.hodAuthorityModel;

import java.util.ArrayList;
import java.util.List;

public class changeMoDetail {

	Integer moId;
	Boolean removeMo;
	List<Integer> ids = new ArrayList<Integer>();
	
	
	public changeMoDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public changeMoDetail(Integer moId, Boolean removeMo, List<Integer> ids) {
		super();
		this.moId = moId;
		this.removeMo = removeMo;
		this.ids = ids;
	}


	public Integer getMoId() {
		return moId;
	}


	public void setMoId(Integer moId) {
		this.moId = moId;
	}


	public List<Integer> getIds() {
		return ids;
	}


	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Boolean getRemoveMo() {
		return removeMo;
	}

	public void setRemoveMo(Boolean removeMo) {
		this.removeMo = removeMo;
	}



	
	
	
}
