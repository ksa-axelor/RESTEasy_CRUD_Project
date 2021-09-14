package com.axelor.service;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.axelor.db.Accessories;
import com.axelor.db.Product;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

@Singleton
public class AccessoriesService {
	
	@Inject
	public Provider<EntityManager> emp;
	
	@Transactional
	public void addAccessories(Accessories a, int pid) {
		EntityManager em = emp.get();
		Product p = em.find(Product.class, pid);
		a.setProduct(p);
		p.setAccessories(a);
	}
	
	@Transactional
	public void deleteAccessories(int aid) {
		EntityManager em = emp.get();
		Accessories as = em.find(Accessories.class, aid);
		Product p = as.getProduct();
		
		em.remove(p.getAccessories());
	}

	@Transactional
	public void updateAccessories(int pid, String aname) {
		EntityManager em = emp.get();
		Product p = em.find(Product.class, pid);
		Accessories a = p.getAccessories();
		a.setAname(aname);
	}
	
}
