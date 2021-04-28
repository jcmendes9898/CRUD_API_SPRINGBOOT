package com.project.model;

import java.math.BigDecimal;

public class ProductDetail {

	private String name;
	private BigDecimal price;

	public ProductDetail() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
