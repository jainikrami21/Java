<%@page import="dao.StudentDao"%>
<%@page import="model.student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Student</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  text-align: center;
}
</style>

</head>
<body>

<h1>List of Students</h1>

<table style="width:50%">
	<tr>
		<th>ID</th>
		<th>Standard</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Date of Birth</th>
		<th>Image</th>
		<th>Created Date</th>
		<th>Status</th>
	<tr>
		
		<% List<student> list = StudentDao.getAllstudent(); %>
		<%for(student s1: list){ %>
		<tr>
			<td><%=s1.getId()%></td>
			<td><%=s1.getStandard_id()%></td>
			<td><%=s1.getFirstName()%></td>
			<td><%=s1.getLastName()%></td>
			<td><%=s1.getDob()%></td>
			<td><%=s1.getImage()%></td>
			<td><%=s1.getCreatedDate()%></td>
			<td><%=s1.getStatus() %></td>
			
			</tr>
			<% } %>
</table>

</body>
</html>