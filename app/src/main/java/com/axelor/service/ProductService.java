package com.axelor.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.axelor.db.Product;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

@Singleton
public class ProductService {
	
	@Inject
	Provider<EntityManager> emp;
	
	@Transactional
	public String addProduct(Product p) {
		EntityManager em = emp.get();
		em.persist(p);
		return "Product added !";
	}
	
	@Transactional
	public List<Product> showProduct() {
		EntityManager em = emp.get();
		Query q = em.createQuery("from Product" , Product.class);
		@SuppressWarnings("unchecked")
		List<Product> p = q.getResultList();
		return p;
	}

	@Transactional
	public String deleteProduct(int pid) {
		EntityManager em = emp.get();
		Product p =em.find(Product.class, pid);
		em.remove(p);
		return "Product Deleted !";
	}

	@Transactional
	public String updateProduct(int pid, String name, int value) {
		EntityManager em = emp.get();
		Product p =em.find(Product.class, pid);
		p.setPname(name);
		p.setPvalue(value);
		return "Product Updated !";
	}
}
