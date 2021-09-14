<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1" />
		<title>RESTEasy Project</title>
		<style>
			<%@ include file ="/form.css" %>
		</style>
	</head>
	<body>
		<h1 class="heading">RESTEasy Project</h1>
		<h1 class="mini_heading">Update product</h1>
		<form
			class="form"
			action="product/updateProduct"
			method="post"
			onsubmit="return confirm('Are you sure you want to Update ?');"
		>
			<div class="div">
				<label>Id of Product: <%=Integer.parseInt(request.getParameter("id"))%><label>
					<input type="hidden" name="id" required value
					="<%=Integer.parseInt(request.getParameter("id"))%>" readonly/><br />
			</div>
			<div class="div">
				<label>Name of Product:</label>
				<input type="text" name="name" required value =
				"<%=request.getParameter("pname")%>"/><br />
			</div>
			<div class="div">
				<label>Value of Product:</label>
				<input type="number" name="value" required value =
				"<%=Integer.parseInt(request.getParameter("pvalue"))%>"/><br />
			</div>
			<div class="div">
				<label>Accessories:</label>
				<input type="text" name="aname" required value =
				"<%=request.getParameter("aname")%>"/><br />
			</div>

			<input class="submit" type="submit" value="submit" /><br />
		</form>
		<hr />
		<h3>
			<a class="home" href="<%=request.getContextPath()%>/product/showProduct">Home</a>
		</h3>
	</body>
</html>
