<%@page import="Model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	 
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=01, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap"
	rel="stylesheet">

<title>E-Commerce Website - User-Login Page</title>

<!-- Additional Bootstrap Files -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">

<!-- Additional CSS Files -->
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
	href="assets/css/font-awesome.css">

<link rel="stylesheet" href="assets/css/templatemo-hexashop.css">

<link rel="stylesheet" href="assets/css/owl-carousel.css">

<link rel="stylesheet" href="assets/css/lightbox.css">

</head>

<body>

	<%@include file="header.jsp"%>


	<!-- ***** login Area Starts ***** -->

	<div class="card mx-auto my-5">
		<div class="container">
			<div class="row">
				<div class="card w-50 mx-auto my-5">
					<div class="card-header text-center">User Login</div>
					
					<% String msg = (String)request.getAttribute("msg"); %>
					<% if(msg!=null){  %>
						<div class="card-header text-center">
							<h4><%out.print(msg); %></h4>
						</div>
					<%} %>
					
					<% String msg1 = (String)request.getAttribute("msg1"); %>
					<% if(msg1!=null){  %>
						<div class="card-header text-center">
							<h4><%out.print(msg1); %></h4>
						</div>
					<%} %>
					
					
					
					
					<div class="card-body">
						<form id="subscribe" name="sentMessage" novalidate="novalidate" action="UserController" method="post">
							<div class="form-group">
								<label>Email Address</label> 
								<input name="email" 
									type="email" class="form-control" id="email"
									placeholder="Your Email Address" required="required"
									data-validation-required-message="please enter your email" />
							</div>
							<div class="form-group">
								<label>Password</label> 
								<input name="password"
									type="password" class="form-control" id="password"
									placeholder="********" required="required"
									data-validation-required-message="please enter a password"/>
							</div>
							<div class="text-center">
								<button type="submit" id="sendMessageButton" name="action" value="login" class="main-dark-button">Login</button>
							</div>
							<h4><a href="user-forgot-password.jsp">Forgot Password ?</a></h4>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- ***** Login Ends ***** -->


	<%@include file="footer.jsp"%>


	<!-- jQuery -->
	<script src="assets/js/jquery-2.1.0.min.js"></script>

	<!-- Bootstrap -->
	<script src="assets/js/popper.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>

	<!-- Plugins -->
	<script src="assets/js/owl-carousel.js"></script>
	<script src="assets/js/accordions.js"></script>
	<script src="assets/js/datepicker.js"></script>
	<script src="assets/js/scrollreveal.min.js"></script>
	<script src="assets/js/waypoints.min.js"></script>
	<script src="assets/js/jquery.counterup.min.js"></script>
	<script src="assets/js/imgfix.min.js"></script>
	<script src="assets/js/slick.js"></script>
	<script src="assets/js/lightbox.js"></script>
	<script src="assets/js/isotope.js"></script>

	<!-- Global Init -->
	<script src="assets/js/custom.js"></script>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"
		crossorigin="anonymous"></script>


	<script>
		$(function() {
			var selectedClass = "";
			$("p").click(function() {
				selectedClass = $(this).attr("data-rel");
				$("#portfolio").fadeTo(50, 0.1);
				$("#portfolio div").not("." + selectedClass).fadeOut();
				setTimeout(function() {
					$("." + selectedClass).fadeIn();
					$("#portfolio").fadeTo(50, 1);
				}, 500);

			});
		});
	</script>

</body>
</html>