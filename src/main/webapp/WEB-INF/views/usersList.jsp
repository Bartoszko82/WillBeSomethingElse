<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>MAIN</title>
</head>
<body>
	<h2>Choose User</h2>	

	
	<table>
		<tr>
			<td>Id</td><td>Login</td>
		</tr>
		<c:forEach items='${users}' var="user">
			<tr>
			<td><a href="<c:url value='/user-${user.id}-info' />">${user.login}</a></td>
			</tr>
		</c:forEach>
	</table>
	Go back to <a href="<c:url value='/main' />">Main</a>
	
</body>
</html>