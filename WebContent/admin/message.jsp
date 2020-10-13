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
	
	<div align="center">
		<h3>${message}</h3>
	</div>
	<div align="center">
	
	<jsp:directive.include file="footer.jsp" />
</body>
</html>

<%-- 07/10/2019
Author: HoiNguyen
Message: This page had follow design but I think It's not suitable for normal user behavior.
		So, I do not use this page to show an error, instead, I shown message in user_form.jsp page, below Password label
		if the email of user already exists. I think it's better.
 --%>