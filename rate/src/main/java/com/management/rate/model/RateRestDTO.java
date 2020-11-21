package com.management.rate.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RateRestDTO {

	private String surchargeRate;
	private String surchargeDescription;
	
	private Optional<RatePersistenceDTO> rateDetails;

	public String getSurchargeRate() {
		return surchargeRate;
	}

	public void setSurchargeRate(String surchargeRate) {
		this.surchargeRate = surchargeRate;
	}

	public String getSurchargeDescription() {
		return surchargeDescription;
	}

	public void setSurchargeDescription(String surchargeDescription) {
		this.surchargeDescription = surchargeDescription;
	}

	public Optional<RatePersistenceDTO> getRateDetails() {
		return rateDetails;
	}

	public void setRateDetails(Optional<RatePersistenceDTO> dbRate) {
		this.rateDetails = dbRate;
	}
	
	

}
