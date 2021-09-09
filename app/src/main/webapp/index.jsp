<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> 
<%@page import="com.axelor.service.ProductService,com.axelor.resource.ProductResource,java.util.*"%>
<%@page import="com.axelor.db.Product"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%
List<Product> list = (List<Product>) request.getAttribute("list");
if(list == null){
	String s = request.getContextPath()+"/product/showProduct"; 
	response.sendRedirect(s);
}
%> 
<%
out.print(list); 
%>
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>RESTEasy Project</title>
	</head>
	<body>
		<h1>RESTEasy Project</h1>
		<hr />
		<hr />
		<h1>Product List</h1>
		<table border="1" width="90%" style= "border-collapse: collapse;">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Value</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${list}" var="p">
				<tr>
					<td>${p.getPid}</td>
					<td>${p.getPname()}</td>
					<td>${p.getPvalue()}</td>
					<td><a href="../edit.jsp?id=${p.getPid()}">Edit</a></td>
					<td><a href="../delete.jsp?id=${p.getPid()}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br /><a href="../add.jsp">Add New Product</a>
	</body>
</html>
