package com.axelor.resource;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.axelor.db.Accessories;
import com.axelor.db.Product;
import com.axelor.service.AccessoriesService;
import com.axelor.service.ProductService;
import com.google.inject.Inject;

@Path("product")
public class ProductResource {
	
	@Inject
	ProductService ps ;
	@Inject
	AccessoriesService as ;
	
	@POST
	@Path("/addProduct")
	public void addProduct(@Context HttpServletRequest req, @Context HttpServletResponse res, @FormParam("name") String name, @FormParam("value") int value) throws ServletException,IOException {
		String accessories = req.getParameter("accessories");
		Product p = new Product(name , value);
		ps.addProduct(p);
		int pid = p.getPid();
		Accessories a = new Accessories(accessories);
		as.addAccessories(a, pid);
		res.sendRedirect(req.getContextPath()+"/product/showProduct");	
	}
	
//	@POST
//	@Produces(MediaType.TEXT_PLAIN)
	@GET
	@Path("/showProduct")
	public void showProduct(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		List<Product> p = ps.showProduct() ;
		req.setAttribute("list",p);
		RequestDispatcher rd =  req.getRequestDispatcher("/index.jsp");
		rd.forward(req, res);
	}
	
	@POST
	@Path("/deleteProduct")
	public void deleteProduct(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ps.deleteProduct(id);
		res.sendRedirect(req.getContextPath()+"/product/showProduct");	
	}
	
	@POST
	@Path("/updateProduct")
	public void updateProduct(@Context HttpServletRequest req, @Context HttpServletResponse res, @FormParam("id") int id,@FormParam("name") String name, @FormParam("value") int value) throws IOException, ServletException{
		String aname = req.getParameter("aname");
		ps.updateProduct(id,name,value);
		as.updateAccessories(id, aname);
		showProduct(req, res);
	}
	
	@POST
	@Path("/searchProduct")
	public void searchProduct(@Context HttpServletRequest req, @Context HttpServletResponse res,@FormParam("name") String name) throws IOException, ServletException{
		List<Product> p = ps.searchProduct(name);
		req.setAttribute("list",p);
		RequestDispatcher rd =  req.getRequestDispatcher("/index.jsp");
		rd.forward(req, res);
	}
	
}
