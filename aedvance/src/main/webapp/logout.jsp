<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout Page</title>
</head>
<body>
<% 
session.removeAttribute("data");
session.invalidate();
response.sendRedirect("login.jsp");
%>
</body>
</html>