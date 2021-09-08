package com.axelor.listner;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.axelor.module.ProductModule;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

public class ProductListner extends GuiceResteasyBootstrapServletContextListener {
	
	@Override
	protected List<? extends Module> getModules(ServletContext context) {
		// TODO Auto-generated method stub
		return Arrays.asList(new JpaPersistModule("RESTEasy"),new ProductModule()) ;
	}
	
	@Override
	protected void withInjector(Injector injector) {
		// TODO Auto-generated method stub
		injector.getInstance(PersistService.class).start();
	}

}
