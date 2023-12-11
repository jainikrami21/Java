<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
	<h1>Add Student</h1>

	<form action="Student_servlet" method="post"
		enctype="multipart/form-data">

		<label for="Standard">Standard:</label> 
		<select name="standard_id"
			id="standard"></select> <br>
		<br> First Name: <input type="text" name="firstName" required>
		<br>
		<br> Last Name: <input type="text" name="lastName" required>
		<br>
		<br> Date of Birth: <input type="date" name="Dob" required>
		<br>
		<br> Image: <input type="file" name="image" required> <br>
		<br> Status: <input type="radio" name="Status" value="Active">
		Active <input type="radio" name="Status" value="Inactive">Inactive
		<br>
		<br>
		<button type="submit" name="action" value=AddStudent>Add
			Student</button>
	</form>
	<br>
	<a href="list_student.jsp" target="blank">Back to List</a>


</body>
</html>