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
		<h1 class="mini_heading">Add Product</h1>
		<form
			class="form"
			action="<%=request.getContextPath()%>/product/addProduct"
			method="post"
			onsubmit="return alert('Product added successfully !');"
		>
			<div class="div">
				<label>Name of Product:</label>
				<input type="text" name="name" required /><br />
			</div>
			<div class="div">
				<label>Value of Product:</label>
				<input type="number" name="value" required /><br />
			</div>

			<input class="submit" type="submit" value="submit" />
		</form>
		<h3>
			<a class="home" href="<%=request.getContextPath()%>/product/showProduct"
				>Home</a
			>
		</h3>
	</body>
</html>
