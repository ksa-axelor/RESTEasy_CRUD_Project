<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1" />
		<title>RESTEasy Project</title>
	</head>
	<body>
		<h1>RESTEasy Project</h1>
		<hr />
		<hr />
		<form action="product/updateProduct" method="post">
			<h3>Update products</h3>
			<label>Id of Product:</label>
			<input type="number" name="id" required /><br />
			<label>Name of Product:</label>
			<input type="text" name="name" required /><br />
			<label>Value of Product:</label>
			<input type="number" name="value" required /><br />

			<input type="submit" value="submit" /><br />
		</form>
		<hr />
			<h3><a href="../app">Home</a></h3>
	</body>
</html>