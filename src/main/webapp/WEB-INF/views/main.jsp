<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MAIN</title>
</head>
<body>
	<h2>Users</h2>	
	<table>
		<tr>
			<td>Id</td><td>Login</td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
			<td>${user.id}</td>
			<td>${user.login}</td>
			<td><a href="<c:url value='/edit-${user.id}-user' />">${user.id}</a></td>
			<td><a href="<c:url value='/delete-${user.id}-user' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/newUser' />">Add New User</a>
</body>
</html>