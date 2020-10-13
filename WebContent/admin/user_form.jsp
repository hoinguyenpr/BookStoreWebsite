<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New User</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	
	<div align="center">
		<c:if test="${user == null}">
			<h2>Create New User</h2>
		</c:if>
		<c:if test="${user != null}">
			<h2>Edit User</h2>
		</c:if>
	</div>

	<div align="center">
	
		<c:if test="${user != null}">
			<form action="update_user" method="post" onsubmit="return validateFormInput()">
			<input type ="hidden" name = "userId" value = "${user.userId }">
		</c:if>
		
		<c:if test="${user == null}">
			<form action="create_user" method="post" onsubmit="return validateFormInput()">
		</c:if>
		
			<table>
				<tr>
					<td>Email:</td>
					<td><input type="text" id="email" name="email" size="25" value="${user.email}"></td>
				</tr>
				<tr>
					<td>Full Name:</td>
					<td><input type="text" id="fullname" name="fullname" size="25" value="${user.fullName}"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" id="password" name="password"
						size="25" value="${user.password}"></td>
				</tr>

				<c:if test="${message != null}">
					<tr>
						<td><p>
								<i>${message} </i>
						</p></td>
					</tr>
				</c:if>
				
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"> &nbsp; &nbsp;&nbsp; <input type="button"
						value="Cancel" onclick="javascript:history.go(-1);"></td>
				</tr>
			</table>
		</form>
	</div>

	<jsp:directive.include file="footer.jsp" />

</body>
<script type="text/javascript">
	function validateFormInput() {
		var fieldEmail = document.getElementById("email");
		var fieldFullname = document.getElementById("fullname");
		var fieldPassword = document.getElementById("password");

		if (fieldEmail.value.length == 0) {
			alert("Email is required!")
			fieldEmail.focus();
			return false;
		}

		if (fieldFullname.value.length == 0) {
			alert("Fullname is required!")
			fieldFullname.focus();
			return false;
		}

		if (fieldPassword.value.length == 0) {
			alert("Password is required!")
			fieldPassword.focus();
			return false;
		}

		return true;
	}
</script>
</html>