package com.axelor.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	@Column(name = "Product_name")
	private String pname;
	@Column(name = "Product_value")
	private int pvalue;
	
	public Product() {
		super();
	}

	public Product(String pname, int pvalue) {
		super();
		this.pname = pname;
		this.pvalue = pvalue;
	}
	
	
	public int getPid() {
		return pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPvalue() {
		return pvalue;
	}
	public void setPvalue(int pvalue) {
		this.pvalue = pvalue;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pvalue=" + pvalue + "]";
	}
	
	
}
