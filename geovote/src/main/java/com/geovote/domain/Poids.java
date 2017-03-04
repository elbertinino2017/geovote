package com.geovote.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Poids {

	private Double quantity;

	public Poids() {

	}

	public Poids(Double quantity) {
		this.quantity = quantity;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}
