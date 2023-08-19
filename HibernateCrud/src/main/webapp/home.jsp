
<%@page import="dao.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	
	<h1>Welcome,</h1>
	<br>
	<h3></h3>
	<br>

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Contact</th>
			<th>Address</th>
			<th>Email</th>
			<th>Password</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
				<form action="UserController" method="post">
					<input type="hidden" name="id" value=>
					<input type="submit" name="action" value="edit">
				</form>
			</td>
			<td>
				<form action="UserController" method="post">
					<input type="hidden" name="id" value=>
					<input type="submit" name="action" value="delete">
				</form>
			</td>
		</tr>
		
	</table>
	<h1>
		<a href="logout.jsp">Logout</a>
	</h1>
</body>
</html>
