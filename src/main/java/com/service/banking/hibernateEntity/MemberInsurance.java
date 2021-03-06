package com.service.banking.hibernateEntity;
// Generated Feb 20, 2020 6:19:12 PM by Hibernate Tools 5.2.12.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MemberInsurance generated by hbm2java
 */
@Entity
@Table(name = "member_insurance")
public class MemberInsurance implements java.io.Serializable {

	private Integer id;
	private int memberId;
	private int accountsId;
	private String name;
	private Date insuranceStartDate;
	private byte insuranceDuration;
	private String narration;
	private Date nextInsuranceDueDate;
	private Byte isRenew;

	public MemberInsurance() {
	}

	public MemberInsurance(int memberId, int accountsId, String name, Date insuranceStartDate, byte insuranceDuration,
			String narration, Date nextInsuranceDueDate) {
		this.memberId = memberId;
		this.accountsId = accountsId;
		this.name = name;
		this.insuranceStartDate = insuranceStartDate;
		this.insuranceDuration = insuranceDuration;
		this.narration = narration;
		this.nextInsuranceDueDate = nextInsuranceDueDate;
	}

	public MemberInsurance(int memberId, int accountsId, String name, Date insuranceStartDate, byte insuranceDuration,
			String narration, Date nextInsuranceDueDate, Byte isRenew) {
		this.memberId = memberId;
		this.accountsId = accountsId;
		this.name = name;
		this.insuranceStartDate = insuranceStartDate;
		this.insuranceDuration = insuranceDuration;
		this.narration = narration;
		this.nextInsuranceDueDate = nextInsuranceDueDate;
		this.isRenew = isRenew;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "member_id", nullable = false)
	public int getMemberId() {
		return this.memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	@Column(name = "accounts_id", nullable = false)
	public int getAccountsId() {
		return this.accountsId;
	}

	public void setAccountsId(int accountsId) {
		this.accountsId = accountsId;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "insurance_start_date", nullable = false, length = 10)
	public Date getInsuranceStartDate() {
		return this.insuranceStartDate;
	}

	public void setInsuranceStartDate(Date insuranceStartDate) {
		this.insuranceStartDate = insuranceStartDate;
	}

	@Column(name = "insurance_duration", nullable = false)
	public byte getInsuranceDuration() {
		return this.insuranceDuration;
	}

	public void setInsuranceDuration(byte insuranceDuration) {
		this.insuranceDuration = insuranceDuration;
	}

	@Column(name = "narration", nullable = false, length = 65535)
	public String getNarration() {
		return this.narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "next_insurance_due_date", nullable = false, length = 10)
	public Date getNextInsuranceDueDate() {
		return this.nextInsuranceDueDate;
	}

	public void setNextInsuranceDueDate(Date nextInsuranceDueDate) {
		this.nextInsuranceDueDate = nextInsuranceDueDate;
	}

	@Column(name = "is_renew")
	public Byte getIsRenew() {
		return this.isRenew;
	}

	public void setIsRenew(Byte isRenew) {
		this.isRenew = isRenew;
	}


}
