package com.project.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@Column
	private long id;

	@Column
	private String id_s;

	@Column
	private String email;

	@Column
	private BigDecimal total;

	@Column
	private Date date_created;

	@OneToMany(targetEntity = ProductOrder.class, mappedBy = "fk", fetch = FetchType.EAGER)
	private List<ProductOrder> products;

	public Order() {
		this.id = UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE;
		this.id_s = Long.toString(id);
		this.date_created = new Date();
	}

	public Order(String email, BigDecimal total) {
		this.id = UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE;
		this.id_s = Long.toString(id);
		this.email = email;
		this.total = total;
		this.date_created = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getId_s() {
		return id_s;
	}

	public void setId_s(String id_s) {
		this.id_s = id_s;
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

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public List<ProductOrder> getProducts() {
		return products;
	}

	public void setProducts(List<ProductOrder> products) {
		this.products = products;
	}

}
