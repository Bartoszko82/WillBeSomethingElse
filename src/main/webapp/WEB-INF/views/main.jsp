<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style>
		div.menu {
			border-style: double;
			border-width: 2px;
		}
		
		div.itemStyle {
			border-style: dotted;
			border-width: 1px;
					
		}
	
	</style>
	
	
	<title>MAIN PAGE</title>
</head>
<body>
	<h2>Main Page</h2>	

	<a href="<c:url value='/newItem' />">Add New Item</a>
	
	
	<table>
		<c:forEach items='${items}' var="item">
					<div class="itemStyle">
						<p>${item.title}</p><br/>
						<p>${item.body}</p><br/>
						<p><a href="<c:url value='/edit-${item.itemId}-item' />">edit</a></p>
						<br/>
						<p><a href="<c:url value='/delete-${item.itemId}-item' />">delete</a></p>
					</div>
		</c:forEach>
	</table>
	
	<div class="menu">
	<a href="<c:url value='/newUser' />">Add New User</a>
	<a href="<c:url value='/usersList' />">Manage Users</a>
	</div>
</body>
</html>