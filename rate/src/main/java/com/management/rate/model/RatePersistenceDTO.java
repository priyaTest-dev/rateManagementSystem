package com.management.rate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;

@Entity
@Table(name = "rate_mgmt_tbl")
public class RatePersistenceDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rate_id")
	private Long rateId;

	@Column(name = "rate_desc")
	private String rateDescription;

	@Column(name = "rate_eff_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date rateEffectiveDate;

	@Column(name = "rate_exp_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date rateExpirationDate;

	@Column(name = "amount")
	private int amount;

	public Long getRateId() {
		return rateId;
	}

	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}

	public String getRateDescription() {
		return rateDescription;
	}

	public void setRateDescription(String rateDescription) {
		this.rateDescription = rateDescription;
	}

	public Date getRateEffectiveDate() {
		return rateEffectiveDate;
	}

	public void setRateEffectiveDate(Date rateEffectiveDate) {
		this.rateEffectiveDate = rateEffectiveDate;
	}

	public Date getRateExpirationDate() {
		return rateExpirationDate;
	}

	public void setRateExpirationDate(Date rateExpirationDate) {
		this.rateExpirationDate = rateExpirationDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Rate [rateId=" + rateId + ", rateDescription=" + rateDescription + ", rateEffectiveDate="
				+ rateEffectiveDate + ", rateExpirationDate=" + rateExpirationDate + ", amount=" + amount + "]";
	}

	
	
}
