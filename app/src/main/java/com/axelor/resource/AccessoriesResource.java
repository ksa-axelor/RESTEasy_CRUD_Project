package com.axelor.resource;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.axelor.db.Accessories;
import com.axelor.service.AccessoriesService;
import com.google.inject.Inject;

@Path("/Accessories")
public class AccessoriesResource {
	@Inject
	AccessoriesService as;

	@POST
	@Path("/addAccessories")
	public void addAccessories(@Context HttpServletRequest req , @Context HttpServletResponse res) throws ServletException, IOException {
		int pid =Integer.parseInt(req.getParameter("pid"));
		String aName = req.getParameter("accessories");
		Accessories a = new Accessories(aName);
		as.addAccessories(a, pid);
		req.setAttribute("pid", pid);
		res.sendRedirect(req.getContextPath()+"/product/showProduct");
	}
	
	@POST
	@Path("/updateAccessories")
	public void updateAccessories(@Context HttpServletRequest req , @Context HttpServletResponse res) throws IOException {
		int aid = Integer.parseInt(req.getParameter("aid"));
		String name= req.getParameter("name");
		as.updateAccessories(aid, name);
		res.sendRedirect(req.getContextPath()+"/product/showProduct");
		
		
	}
	
	@GET
	@Path("/deleteAccessories")
	public void deleteAccessories(@Context HttpServletRequest req, @Context HttpServletResponse res) throws ServletException, IOException {
		int aid = Integer.parseInt(req.getParameter("aid"));
		as.deleteAccessories(aid);
		res.sendRedirect(req.getContextPath()+"/product/showProduct");
	}
}
