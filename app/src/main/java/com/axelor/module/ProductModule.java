package com.axelor.module;

import com.axelor.resource.AccessoriesResource;
import com.axelor.resource.ProductResource;
import com.axelor.service.AccessoriesService;
import com.axelor.service.ProductService;
import com.google.inject.AbstractModule;

public class ProductModule extends AbstractModule {
	
	@Override
	protected void configure() {
		// TODO Auto-generated method stub
//		super.configure();
		bind(ProductService.class);
		bind(ProductResource.class);
		bind(AccessoriesService.class);
		bind(AccessoriesResource.class);		
	}
}
