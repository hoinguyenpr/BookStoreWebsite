<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Admin login</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<div align="center">
		<h1>Bookstore Administration</h1>
		<h2>Admin Login</h2>
		
		<div>
		
			<c:if test="${message != null}">
				<tr>
					<td><p class = "messsage">
								${message}
					</p></td>
				</tr>
			</c:if>
		
		</div>
		
		<form id = "formLogin" action="login" method = "post">
		
			<table>
			
				<tr>
					<td>Email: </td>
					<td><input type = "text" name = "email" id = "email" size = "20">
				</tr>
				
				<tr>
					<td>Password: </td>
					<td><input type = "password" name = "password" id = "password" size = "20">
				</tr>
				
				<tr align="center">
					<td colspan="2">
						<button type = "submit">Login</button>
					</td>
				</tr>
			
			</table>
		
		</form>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$("#formLogin").validate({
			rules:{
				email: {
					required: true,
					email: true
				},
				password: "required"
			},
			messages: {
				email: {
					required: "Email is required!",
					email: "Please enter an valid email address"
				},
				password: "Password is required!"
			}
		});
	});
	
</script>
</html>