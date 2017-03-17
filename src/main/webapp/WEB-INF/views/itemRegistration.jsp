<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<c:url value='/static/commonStyle.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/itemRegStyle.css' />" rel="stylesheet"></link>
	<title>Item Registration</title>

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
				<li><a href="<c:url value='/newUser' />">New User</a></li>
				<li><a href="<c:url value='/newTag' />">New Tag</a></li>
			</ul>
		</nav>
		<div style="clear:both;"></div>
 
	<form:form method="POST" modelAttribute="item">
		<form:input type="hidden" path="itemId" id="id"/>
		<table>
			<tr>
				<td><label for="title">Title: </label> </td>
				<td><form:input path="title" id="title"/></td>
				<td><form:errors path="title" cssClass="error"/></td>
		    </tr>
		    <tr>
				<td><label for="body">Body: </label> </td>
				<td><form:input path="body" id="body"/></td>
				<td><form:errors path="body" cssClass="error"/></td>
		    </tr>
		     <tr>
				<td><label for="type">Priority: </label> </td>
				<td><form:select path="type" id="type">
					<option value=BUG>BUG</option>
					<option value=TASK>TASK</option>
					<option value=FEATURE>FEATURE</option>
				</form:select></td>
				<td><form:errors path="priority" cssClass="error"/></td>
		    </tr>
		    <tr>
				<td><label for="priority">Priority: </label> </td>
				<td><form:select path="priority" id="priority">
					<option value=1>1</option>
					<option value=2>2</option>
					<option value=3>3</option>
					<option value=4>4</option>
					<option value=5>5</option>
				</form:select></td>
				<td><form:errors path="priority" cssClass="error"/></td>
		    </tr>
		    <tr>
				<td><label for="severity">Severity: </label> </td>
				<td><form:select path="severity" id="severity">
					<option value=1>1</option>
					<option value=2>2</option>
					<option value=3>3</option>
				</form:select></td>
				<td><form:errors path="severity" cssClass="error"/></td>
		    </tr>
		      <tr>
				<td><label for="originalEstimate">Estimate: </label> </td>
				<td><form:input path="originalEstimate" id="originalEstimate"/></td>
				<td><form:errors path="originalEstimate" cssClass="error"/></td>
		    </tr>
		      <tr>
				<td><label for="remainingTime">Remaining: </label> </td>
				<td><form:input path="remainingTime" id="remainingTime"/></td>
				<td><form:errors path="remainingTime" cssClass="error"/></td>
		    </tr>
		      <tr>
				<td><label for="completitionTime">Completition: </label> </td>
				<td><form:input path="completitionTime" id="secompletitionTimeverity"/></td>
				<td><form:errors path="completitionTime" cssClass="error"/></td>
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