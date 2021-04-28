package com.project.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prodOrders")
public class ProductOrder {

	@Id
	@Column
	private long id;

	@Column
	private long fk;

	@Column
	private String id_s;

	@Column
	private String id_p;

	@Column
	private String name;

	@Column
	private BigDecimal price;

	@Column
	private long quantity;

	public ProductOrder() {
	}

	public ProductOrder(long fk, String id_p, String name, BigDecimal price, long quantity) {
		this.id = UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE;
		this.id_s = Long.toString(id);
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.fk = fk;
		this.id_p = id_p;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFk() {
		return fk;
	}

	public void setFk(long fk) {
		this.fk = fk;
	}

	public String getId_s() {
		return id_s;
	}

	public void setId_s(String id_s) {
		this.id_s = id_s;
	}

	public String getId_p() {
		return id_p;
	}

	public void setId_p(String id_p) {
		this.id_p = id_p;
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

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

}
