<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hoinguyen dot com Online Bookstore</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<br />
	<br />

	<div align="center">
		<h2>Administrative Dashboard</h2>
	</div>
	<div align="center">
	
		<hr width="30%">
	
		<h2>Quick Actions:</h2>
		
		<b>
		<a href="new_book">New Book</a> |
		<a href="new_user">New User</a> |
		<a href="new_category">New Category</a> |
		<a href="new_customer">New Customer</a> |
		</b>
		
		<br>
		<br>
		
		<hr width="30%">
		
	</div>
	
	<div align="center">
		<h2>Recent Sales: </h2>
	</div>
	
	<div align="center">
		<h2>Recent Reviews: </h2>
	</div>
	
		<div align="center">
		<h2>Statistics: </h2>
	</div>

	<br />

	<jsp:directive.include file="footer.jsp" />

</body>
</html>