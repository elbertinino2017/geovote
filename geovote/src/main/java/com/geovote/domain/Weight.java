package com.geovote.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Weight {

	private Double quantity;

	public Weight() {

	}

	public Weight(Double quantity) {
		this.quantity = quantity;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}
