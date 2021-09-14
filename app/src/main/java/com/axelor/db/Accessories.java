package com.axelor.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Accessories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	@Column(name = "Cloth_Name")
	private String aname;
	@OneToOne()
	private Product product;
	
	public Accessories() {
		super();
	}

	public Accessories(String aname) {
		super();
		this.aname = aname;
	}

	public int getAid() {
		return aid;
	}
	@Override
	public String toString() {
		return "Accessories [aname=" + aname + ", product=" + product + "]";
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
