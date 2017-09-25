<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="<c:url value='/static/commonStyle.css' />" rel="stylesheet"></link>
		<link href="<c:url value='/static/mainStyle.css' />" rel="stylesheet"></link>
		<title>BuildByJenkins</title>
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
				<li class=disabled><a href="<c:url value='/main' />">Main</a></li>
				<li><a href="<c:url value='/usersList' />">Users</a></li>
				<li><a href="<c:url value='/tagsList' />">Tags</a></li>
				
				<!-- "buttons" below will be available for admin only -->
				<li><a href="<c:url value='/newUser' />">New User</a></li>
				<li><a href="<c:url value='/newTag' />">New Tag</a></li>
			</ul>
		</nav>
		<div style="clear:both;"></div>

		<div class="systemMessage"> ${success} </div>
			
		<div class="columns">
			<aside>
				<div class="columnTitle">
					<h2>TO DO</h2>
				</div>
				<div class="columnItemContainer">
					<a class="columnLink" href="<c:url value='/newItem' />">Add New Item</a>
					<c:forEach items='${ready}' var="item">
						<div class ="item">
							<div class="itemTitleLink" id="${item.type}"><a href="<c:url value='item-${item.itemId}-details'/>">${item.title}</a></div>
							<p>Assigned to: </p>
							<p>Tags:</p>
							<table class="itemTable">
								<tr>
									<td class="itemTableData" id="prt${item.priority}">Priority: ${item.priority}</td>
									<td class="itemTableData" id="sev${item.severity}">Severity: ${item.severity}</td>
								</tr>	
							</table>	
							<table class="itemTable">
								<tr>
									<td class="itemLinkDisabled"><a href="<c:url value='/set-${item.itemId}-AsReady' />">&lt&lt&lt</a></td>
									<td class="itemLink"><a href="<c:url value='/edit-${item.itemId}-item' />">Edit</a></td>
									<td class="itemLink"><a href="<c:url value='/delete-${item.itemId}-item' />">Delete</a></td>
									<td class="itemLink"><a href="<c:url value='/set-${item.itemId}-AsAssigned' />">&gt&gt&gt</a></td>
								</tr>
							</table>
						</div>
					</c:forEach>
				</div>
			</aside>
			<aside>
				<div class="columnTitle">
					<h2>IN PROGRESS</h2>
				</div>
				<div class="columnItemContainer">
					<c:forEach items='${assigned}' var="item">
						<div class ="item">
							<div class="itemTitleLink" id="${item.type}"><a href="<c:url value='item-${item.itemId}-details'/>">${item.title}</a></div>
							<p>Assigned to:</p>
							<p>Tags:</p>
							<table class="itemTable">
								<tr>
									<td class="itemTableData" id="prt${item.priority}">Priority: ${item.priority}</td>
									<td class="itemTableData" id="sev${item.severity}">Severity: ${item.severity}</td>
								</tr>
							</table>	
							<table class="itemTable">	
								<tr>
									<td class="itemLink"><a href="<c:url value='/set-${item.itemId}-AsReady' />">&lt&lt&lt</a></td>
									<td class="itemLink"><a href="<c:url value='/edit-${item.itemId}-item' />">Edit</a></td>
									<td class="itemLink"><a href="<c:url value='/delete-${item.itemId}-item' />">Delete</a></td>
									<td class="itemLink"><a href="<c:url value='/set-${item.itemId}-AsDone' />">&gt&gt&gt</a></td>
								</tr>
							</table>
						</div>
					</c:forEach>
				</div>
			</aside>
			<aside>
				<div class="columnTitle">
					<h2>DONE</h2>
				</div>
				<div class="columnItemContainer">
					<c:forEach items='${done}' var="item">
						<div class ="item">
							<div class="itemTitleLink" id="${item.type}"><a href="<c:url value='item-${item.itemId}-details'/>">${item.title}</a></div>
							<p>Assigned to:</p>
							<p>Tags:</p>
							<table class="itemTable">
								<tr>
									<td class="itemTableData" id="prt${item.priority}">Priority: ${item.priority}</td>
									<td class="itemTableData" id="sev${item.severity}">Severity: ${item.severity}</td>
								</tr>	
							</table>	
							<table class="itemTable">
								<tr>
									<td class="itemLink"><a href="<c:url value='/set-${item.itemId}-AsAssigned' />">&lt&lt&lt</a></td>
									<td class="itemLink"><a href="<c:url value='/edit-${item.itemId}-item' />">Edit</a></td>
									<td class="itemLink"><a href="<c:url value='/delete-${item.itemId}-item' />">Delete</a></td>
									<td class="itemLinkDisabled"><a href="<c:url value='/set-${item.itemId}-AsDone' />">&gt&gt&gt</a></td>
								</tr>
							</table>
						</div>
					</c:forEach>
				</div>
			</aside>
		</div>
		<div style="clear:both;"></div>
		<footer>
			<p>version: 0.0.2</p>
		</footer>
	</body>
</html>