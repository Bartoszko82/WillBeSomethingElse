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

	<p>User ID: ${user.userId}</p> <br/>
	<p>Login: ${user.login}</p> <br/>
	<p>Password: ${user.password}</p> <br/>
	<p>e-mail: ${user.email}</p> <br/>
	<p>Tasks: tu bedzie tabela z taskami</p> <br/>
	<br/>
	<a href="<c:url value='/edit-${user.userId}-user' />">edit User</a>
	<a href="<c:url value='/delete-${user.userId}-user' />">delete User</a>
	<br/>
	
	Go back to <a href="<c:url value='/usersList' />">Users List</a>
	<br/>
	Go back to <a href="<c:url value='/main' />">Main</a>
</body>
</html>