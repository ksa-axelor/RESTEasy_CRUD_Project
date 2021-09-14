package com.axelor.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	public void addProduct(Product p) {
		EntityManager em = emp.get();
		em.persist(p);
	}
	
	@Transactional
	public List<Product> showProduct() {
		EntityManager em = emp.get();
		Query q = em.createQuery("from Product order by pid" , Product.class);
		@SuppressWarnings("unchecked")
		List<Product> p = q.getResultList();
		return p;
	}

	@Transactional
	public void deleteProduct(int pid) {
		EntityManager em = emp.get();
		Product p =em.find(Product.class, pid);
		em.remove(p);
	}

	@Transactional
	public void updateProduct(int pid, String name, int value) {
		EntityManager em = emp.get();
		Product p =em.find(Product.class, pid);
		p.setPname(name);
		p.setPvalue(value);
	}
	
	@Transactional
	public List<Product> searchProduct(String name) {
		EntityManager em = emp.get();
		TypedQuery<Product> q = em.createQuery("SELECT c FROM Product c WHERE Lower(c.pname) LIKE '%" + name.toLowerCase() + "%'" , Product.class);
		@SuppressWarnings("unchecked")
		List<Product> p = q.getResultList();
		return p;
	}
	
}
