<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@page
import="com.axelor.service.ProductService,com.axelor.resource.ProductResource,java.util.*"%>
<%@page import="com.axelor.db.Product"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	List<Product> list = (List<Product>)request.getAttribute("list");
	if (list == null){
		response.sendRedirect(request.getContextPath()+"/product/showProduct");	
	}
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>RESTEasy Project</title>
		<style>
			<%@ include file ="/table.css" %>
		</style>
	</head>
	<body>
		<h1 class="heading">RESTEasy Project</h1>
		<h1 class="mini_heading">Product List</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Value</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="p">
					<tr>
						<td>${p.pid}</td>
						<td>${p.pname}</td>
						<td>${p.pvalue}</td>
						<td>
							<a
								class="edit"
								href="../update.jsp?id=${p.pid}&pname=${p.pname}&pvalue=${p.pvalue}"
								>Edit</a
							>
						</td>
						<td>
							<a
								class="delete"
								href="../delete.jsp?id=${p.pid}&pname=${p.pname}&pvalue=${p.pvalue}"
								>Delete</a
							>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="add" href="/app/add.jsp">Add New Product</a>
	</body>
</html>
