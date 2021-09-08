package com.axelor.resource;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.spi.HttpResponse;

import com.axelor.db.Product;
import com.axelor.service.ProductService;
import com.google.inject.Inject;

@Path("product")
public class ProductResource {
	
	@Inject
	ProductService ps ;
	
	@POST
	@Path("/addProduct")
	public Response addProduct(@FormParam("name") String name, @FormParam("value") int value) {
//		@Context HttpServletResponse res
		Product p = new Product(name , value);
		ps.addProduct(p);
		return Response.ok("Product Added !").build();
		
	}
	
	@POST
	@Path("/showProduct")
	@Produces(MediaType.TEXT_PLAIN)
	public Response showProduct() {
		return Response.ok(ps.showProduct()).build();
	}
	
	@POST
	@Path("/deleteProduct")
	public Response deleteProduct(@FormParam("id") int id) {
		ps.deleteProduct(id);
		return Response.ok("Product deleted !").build();
	}
	
	@POST
	@Path("/updateProduct")
	public Response updateProduct(@FormParam("id") int id,@FormParam("name") String name, @FormParam("value") int value) {
		ps.updateProduct(id,name,value);
		return Response.ok("Product Updated !").build();
	}
	
	
	
}
