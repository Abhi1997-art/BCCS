package com.service.banking.model.superAdminModel;

import org.hibernate.id.IntegralDataTypeHolder;

public class ShareCertificateDetail {
	
	Integer id;
	Integer shareCertificateName;
	
	
	public ShareCertificateDetail(Integer id, Integer shareCertificateName) {
		super();
		this.id = id;
		this.shareCertificateName = shareCertificateName;
	}
	
	public ShareCertificateDetail() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getshareCertificateName() {
		return shareCertificateName;
	}
	public void setshareCertificateName(Integer shareCertificateName) {
		this.shareCertificateName = shareCertificateName;
	}

	
	 
}
