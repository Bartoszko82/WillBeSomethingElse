<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>INFO</title>
</head>
<body>
	<h2>User Info</h2>	

	<p>User ID: ${user.id}</p> <br/>
	<p>Login: ${user.login}</p> <br/>
	<p>Password: to bedzie haslo</p> <br/>
	<p>Tasks: tu bedzie tabela z taskami</p> <br/>
	<br/>
	<a href="<c:url value='/edit-${user.id}-user' />">edit User</a></td>
	<a href="<c:url value='/delete-${user.id}-user' />">delete User</a></td>
	<br/>
	Go back to <a href="<c:url value='/todoMain' />">Main</a>
</body>
</html>