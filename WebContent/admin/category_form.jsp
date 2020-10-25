<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Category</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<c:if test="${category == null}">
			<h2>Create Category</h2>
		</c:if>
		<c:if test="${category != null}">
			<h2>Edit Category</h2>
		</c:if>
	</div>

	<div align="center">

		<c:if test="${category != null}">
			<form action="update_category" method="post" onsubmit="return validateFormInput()">
				<input type="hidden" name="categoryId" value="${category.categoryId}">
		</c:if>

		<c:if test="${category == null}">
			<form action="create_category" method="post" onsubmit="return validateFormInput()">
		</c:if>
				<table>
					<tr>
						<td>Name:</td>
						<td><input type="text" id="name" name="name" size="25" value="${category.name}"></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
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
							value="Cancel" onclick="javascript:history.go(-1);">
						</td>
					</tr>
				</table>
			</form>
	</div>

	<jsp:directive.include file="footer.jsp" />

</body>
<script type="text/javascript">
	function validateFormInput() {
		var feildName = document.getElementById("name");

		if (feildName.value.length == 0) {
			alert("Category name is required");
			feildName.focus();
			return false;
		}
		return true;
	}
</script>
</html>