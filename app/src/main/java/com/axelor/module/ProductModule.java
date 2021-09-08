package com.axelor.module;

import com.axelor.resource.ProductResource;
import com.google.inject.AbstractModule;

public class ProductModule extends AbstractModule {
	
	@Override
	protected void configure() {
		// TODO Auto-generated method stub
//		super.configure();
		bind(ProductResource.class);
	}
}
