<%@page import="dao.StandardDao"%>
<%@page import="model.standard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Standard</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  text-align: center;
}
</style>

</head>
<body>

<h1>List of Standard</h1>

<table style="width:50%;">

	<tr >
		<th>ID</th>
		<th>Name</th>
		<th>Status</th>
	</tr>
	
	
		<% List<standard> list = StandardDao.getAllstandard(); %>
		<%for(standard s1: list){ %>
		
		<tr>
			<td><%=s1.getS_id()%></td>
			<td><%=s1.getName()%></td>
			<td><%=s1.getStatus()%></td>
		</tr>
		
			<% } %>
</table>

</body>
</html>