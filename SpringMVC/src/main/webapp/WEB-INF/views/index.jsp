<%@page import="java.util.List"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Register Form</title>
</head>
<body>
	<div class="container">
		<h1 class="text-center">User Form</h1>
		<form action="register" method="get">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Name</label> <input
					type="text" name="name" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Contact</label> <input
					type="text" name="contact" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Address</label> <input
					type="text" name="address" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email
					address</label> <input type="email" name="email" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" name="password" class="form-control"
					id="exampleInputPassword1">
			</div>
			<div class="text-center">
				<button type="submit" name="action" value="register"
					class="btn btn-primary">Submit</button>
			</div>
		</form>
	</div>
	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>


</body>
</html>

<%-- <h2>Hello World!</h2>
<a href="about">About</a>
<a href="contact">Contact</a>
<%int num = (Integer)(request.getAttribute("num")); %>
<%out.print(num); %>
<h1>${num}</h1>

<%List<String> list = (List<String>)request.getAttribute("list"); %>

<%for(String s:list){ %>

<%out.print(s); %>

<%} %>
<h1> ${list}</h1> 

<c:forEach items="${list}" var="s">
	<h1>${s}</h1>	
</c:forEach> --%>