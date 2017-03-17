<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<c:url value='/static/commonStyle.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/userRegStyle.css' />" rel="stylesheet"></link>
	<title>List of Users</title>
</head>
	<body>
		<div class="login">
			<div class="loginWelcome">Welcome UserName</div>
			<div class="loginButton">Login</div>
			<div class="logoutButton">Logout</div>
		</div>
		<div style="clear:all;"></div>
					
		<nav class="menu">
			<ul>
				<li><a href="<c:url value='/main' />">Main</a></li>
				<li><a href="<c:url value='/usersList' />">Users</a></li>
				<li class=disabled><a href="<c:url value='/tagsList' />">Tags</a></li>
				
				<!-- "buttons" below will be available for admin only -->
				<li><a href="<c:url value='/newUser' />">New User</a></li>
				<li><a href="<c:url value='/newTag' />">New Tag</a></li>
			</ul>
		</nav>
		<div style="clear:both;"></div>

		<div class="systemMessage"> ${success} </div>
	
	<p> To be implemented </p>
	
	<!--  
	<table>
		<c:forEach items='${users}' var="user">
			<tr>
			<td><a href="<c:url value='/user-${user.userId}-info' />">${user.login}</a></td>
			</tr>
		</c:forEach>
	</table>
	-->
	
	
</body>
</html>