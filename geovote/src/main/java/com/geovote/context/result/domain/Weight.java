package com.geovote.context.result.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Weight {

	private Double quantity;
	private Double availablePercentage;

	public Weight() {

	}

	public Weight(Double quantity, Double availablePercentage) {
		this.quantity = quantity;
		this.availablePercentage = availablePercentage;

	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getAvailablePercentage() {
		return availablePercentage;
	}

	public void setAvailablePercentage(Double availablePercentage) {
		this.availablePercentage = availablePercentage;
	}
	
	

}
