package com.project.model;

import java.math.BigDecimal;
import java.util.List;

public class OrderDetail {

	private String email;
	private BigDecimal total;
	private List<ProductOrder> products;

	public OrderDetail() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<ProductOrder> getProducts() {
		return products;
	}

	public void setProducts(List<ProductOrder> products) {
		this.products = products;
	}

}
