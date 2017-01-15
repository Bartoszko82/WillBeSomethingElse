<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>MAIN</title>
</head>
<body>
	<h2>Main Page</h2>	

	<a href="<c:url value='/newItem' />">Add New Item</a>
	
	
	<table>
		<tr>
			<td>Item</td>
		</tr>
		
		<c:forEach items='${items}' var="item">
			<tr>
			<td>${item.itemId}</td>
			<td>${item.title}</td>
			
			</tr>
		</c:forEach>
	
	</table>
	
	<div>
	<a href="<c:url value='/newUser' />">Add New User</a>
	<a href="<c:url value='/usersList' />">Manage Users</a>
	</div>
</body>
</html>