package com.project.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column
	private long id;

	@Column
	private String id_s;

	@Column
	private String name;

	@Column
	private BigDecimal price;

	@Column
	private Date date_created;

	public Product() {
		this.id = UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE;
		this.id_s = Long.toString(id);
		this.date_created = new Date();
	}

	public Product(String name, BigDecimal price) {
		this.id = UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE;
		this.id_s = Long.toString(id);
		this.name = name;
		this.price = price;
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

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

}
