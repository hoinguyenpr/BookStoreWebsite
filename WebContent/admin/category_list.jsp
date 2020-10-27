<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Manage category</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<br />
	<br />

	<div align="center">
		<h2 class = "pageheading">Categories Management</h2>
		<h3><a href="category_form.jsp">Create new Category</a></h3>
	</div>
	
	<br>
	
	<c:if test="${message != null}">
		<div align="center">
		
			<h4 class = "message">${message} </h4>
		
		</div>
	</c:if>
	
	<br>
	
	<div align="center">
		<table border="1" cellpadding = "6">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Category Name</th>
				<th>Actions</th>
			</tr>
			<c:forEach var = "category" items = "${listCategory}" varStatus = "status">
				<tr>
					<td>${status.index +  1 }</td>
					<td>${category.categoryId}</td>
					<td>${category.name}</td>
					<td>
						<a href="edit_category?id=${category.categoryId}">Edit</a> &nbsp
						<a href="javascript:void(0);" class = "deleteLink" id = "${category.categoryId}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<jsp:directive.include file="footer.jsp" />
	
	<script type="text/javascript">

		$(document).ready(function(){
			$(".deleteLink").each(function(){
				$(this).on("click", function(){
					categoryId = $(this).attr("id");
					if(confirm('Are you sure you want to delete the category with ID '+ categoryId + ' ?')){
						window.location = 'delete_category?id=' + categoryId;
					}
				});
			});
		});
	
	</script>
	
</body>
</html>