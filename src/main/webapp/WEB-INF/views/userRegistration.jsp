<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="<c:url value='/static/commonStyle.css' />" rel="stylesheet"></link>
		<link href="<c:url value='/static/userRegStyle.css' />" rel="stylesheet"></link>
		<title>User Registration</title>
	
	<style>
	
		.error {
				color: #ff0000;
		}
	</style>
	
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
				<li><a href="<c:url value='/tagsList' />">Tags</a></li>
				
				<!-- "buttons" below will be available for admin only -->
				<li class=disabled><a href="<c:url value='/newUser' />">New User</a></li>
				<li><a href="<c:url value='/newTag' />">New Tag</a></li>
			</ul>
		</nav>
		<div style="clear:both;"></div>
 
	<form:form method="POST" modelAttribute="user">
		<form:input type="hidden" path="userId" id="id"/>
		<table>
			<tr>
				<td><label for="login">Login: </label> </td>
				<td><form:input path="login" id="login"/></td>
				<td><form:errors path="login" cssClass="error"/></td>
		    </tr>
		    <tr>
				<td><label for="password">Password: </label> </td>
				<td><form:input path="password" id="password"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
		    </tr>
		      <tr>
				<td><label for="email">Email: </label> </td>
				<td><form:input path="email" id="email"/></td>
				<td><form:errors path="email" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>