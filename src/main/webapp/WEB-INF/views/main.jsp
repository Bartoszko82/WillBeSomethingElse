<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style>
		ul {
		    list-style-type: none;
		    margin: 0;
		    padding: 0;
		    width: 1100px;
		    background-color: #f1f1f1;
		}
		
		li {
			display: inline;
			width: 200px;
			text-align: center;
		}

		li a {
		    display: block;
		    color: #000;
		    padding: 8px 16px;
		    text-decoration: none;
		}

		li a:hover {
		    background-color: #555;
		    color: white;
		}
			
		aside {
			width: 322px;
			border-style: solid;
			border-width: 1px;
			border-color: #000000; 
			float: left;
			padding: 10px;
		}
		
		div.itemBUG {
			border-style: solid;
			border-width: 1px;
			border-color: #ff0000;
			width: 300px;
		}
		
		div.itemTASK {
			border-style: solid;
			border-width: 1px;
			border-color: #0000ff;
			width: 300px;
		}
		
		div.itemFEATURE {
			border-style: solid;
			border-width: 1px;
			border-color: #00ff00;
			width: 300px;
		}
		
		table.itemContainer {
		border-style: solid;
		border-width: 1px;
		border-color: #000000;
		}
	
	</style>
	
	
	<title>MAIN PAGE</title>
</head>
<body>
	<h2>Main Page</h2>	

	<ul>
	<li><a href="<c:url value='/newItem' />">Add New Item</a></li>
	<li><a href="<c:url value='/newUser' />">Add New User</a></li>
	<li><a href="<c:url value='/usersList' />">Manage Users</a></li>
	</ul>
	
		<aside>
			<h2>TO DO</h2>
			<table class="itemContainer">
				<c:forEach items='${ready}' var="item">
							<div class="item${item.type}">
									<p>${item.title}</p>
									<p>${item.body}</p>
									<p>Priority: ${item.priority}</p>
									<p>Severity: ${item.severity}</p>
									<table>
										<tr>
											<td><a href="<c:url value='/edit-${item.itemId}-item' />">edit</a></td>
											<td><a href="<c:url value='/delete-${item.itemId}-item' />">delete</a></td>
										</tr>
										<tr>
											<td><a href="<c:url value='/set-${item.itemId}-AsAssigned' />">&gt&gt&gt</a></td>
										</tr>
									</table>
							</div>
				</c:forEach>
			</table>
		</aside>
		
		<aside>
			<h2>IN PROGRESS</h2>
			<table>
				<c:forEach items='${assigned}' var="item">
						<div class="item${item.type}">
							<p>${item.title}</p>
							<p>${item.body}</p>
							<p>Priority: ${item.priority}</p>
							<p>Severity: ${item.severity}</p>
							<table>
										<tr>
											<td><a href="<c:url value='/edit-${item.itemId}-item' />">edit</a></td>
											<td><a href="<c:url value='/delete-${item.itemId}-item' />">delete</a></td>
										</tr>
										<tr>
											<td><a href="<c:url value='/set-${item.itemId}-AsReady' />">&lt&lt&lt</a></td>
											<td><a href="<c:url value='/set-${item.itemId}-AsDone' />">&gt&gt&gt</a></td>
										</tr>
									</table>
						</div>
				</c:forEach>
			</table>
		</aside>
		
		<aside>
			<h2>DONE</h2>
			<table>
				<c:forEach items='${done}' var="item">
					<div class="item${item.type}">
						<p>${item.title}</p>
						<p>${item.body}</p>
						<p>Priority: ${item.priority}</p>
						<p>Severity: ${item.severity}</p>
						<table>
										<tr>
											<td><a href="<c:url value='/edit-${item.itemId}-item' />">edit</a></td>
											<td><a href="<c:url value='/delete-${item.itemId}-item' />">delete</a></td>
										</tr>
										<tr>
											<td><a href="<c:url value='/set-${item.itemId}-AsAssigned' />">&lt&lt&lt</a></td>
										</tr>
									</table>
					</div>
				</c:forEach>
			</table>
		</aside>
	
</body>
</html>