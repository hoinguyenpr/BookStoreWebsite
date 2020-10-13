<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<jsp:directive.include file = "header.jsp"/>
	
	<br/><br/>
	
	<div align="center">
		<h2>Please login</h2>
		<form action="/BookStoreWebsite/LoginServlet" method = "post">
			<label for="username">Username: </label><br>
			<input type = "text" id = "username" name = "username"><br>
			<label for="password">Password: </label><br>
			<input type = "text" id = "password" name = "password"><br><br>
			<input type = "submit" value = "Login">
		</form>
	</div>
	
	<br/>
	
	<jsp:directive.include file = "footer.jsp"/>
	
</body>
</html>