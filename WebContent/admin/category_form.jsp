<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Create New Category</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<c:if test="${category == null}">
			<h2 class = "pageheading" >Create Category</h2>
		</c:if>
		<c:if test="${category != null}">
			<h2 class = "pageheading">Edit Category</h2>
		</c:if>
	</div>

	<div align="center">

		<c:if test="${category != null}">
			<form action="update_category" method="post" id = "categoryForm">
				<input type="hidden" name="categoryId" value="${category.categoryId}">
		</c:if>

		<c:if test="${category == null}">
			<form action="create_category" method="post" id = "categoryForm">
		</c:if>
				<table class = "form">
					<tr>
						<td>Name:</td>
						<td><input type="text" id="name" name="name" size="25" value="${category.name}"></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>

					<c:if test="${message != null}">
						<tr>
							<td><p class = "messsage">
									${message}
								</p></td>
						</tr>
					</c:if>

					<tr>
						<td colspan="2" align="center">
							<button type="submit">Save</button> &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; 
							<button id = "cancelButton" >Cancel</button>
						</td>
					</tr>
				</table>
			</form>
	</div>

	<jsp:directive.include file="footer.jsp" />

</body>
<script type="text/javascript">

	$(document).ready(function(){
		$("#categoryForm").validate({
			rules:{
				name: "required"
			},
			messages: {
				name: "Category name is required"
			}
		});
		$("#cancelButton").click(function(){
			history.go(-1);
		});
	});
	
</script>
</html>