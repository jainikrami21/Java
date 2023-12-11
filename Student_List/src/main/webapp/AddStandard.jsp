<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Standard</title>

</head>
<body>
	
	<h1>Add Standard</h1>
	<form action="Standard_servlet" method="post" enctype="multipart/form-date">
		
		<br>
		<label for="name">Name:</label>
		<input type="text" name="name" required><br><br>
		<label for="status">Status:</label>
		<input type="radio" name="status" value="Active"> 
		Active 
	 <input type="radio" name="status" value="Inactive">Inactive <br><br>
	<button type="submit" name="action" value="AddStandard">Add Standard</button> 
	
	</form>
	<br>
	<a href="list_standard.jsp" target="">Back to List</a>
</body>
</html>