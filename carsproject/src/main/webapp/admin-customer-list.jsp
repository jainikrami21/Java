<%@page import="dao.CustomerDao"%>
<%@page import="model.Customer"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta name="description" content="" />
<meta name="author" content="" />
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
<title>Admin- Customer- List- CarsWash- AutoWash</title>
<!-- BOOTSTRAP CORE STYLE  -->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONT AWESOME STYLE  -->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLE  -->
<link href="assets/css/style.css" rel="stylesheet" />
<!-- GOOGLE FONT -->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />

</head>
<body>

	<%@include file="admin-navbar.jsp"%>



	<!-- MENU SECTION END-->
	<div class="content-wrapper">
		<div class="container">
			<div class="row pad-botm">
				<div class="col-md-12">
					<h4 class="header-line">Customer</h4>

				</div>

			</div>
			<div class="row">
				<div class="col-md-12">
					<!--   Basic Table  -->
					<div class="panel panel-default">
						<div class="panel-heading">Customer Table</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th>ID</th>
											<th>Name</th>
											<th>Contact</th>
											<th>Address</th>
											<th>Email</th>
											<th>Password</th>
											<th>Edit</th>
											<th>Delete</th>
										</tr>
									</thead>
									<tbody>
									
										<% List<Customer> list = CustomerDao.getAllCustomer(); %>
										<%for(Customer s1: list){ %>
										<tr>
											<td><%=s1.getId()%></td>
											<td><%=s1.getName() %></td>
											<td><%=s1.getContact() %></td>
											<td><%=s1.getAddress() %></td>
											<td><%=s1.getEmail() %></td>
											<td><%=s1.getPassword() %></td>
											<td><a href="admin-customer-edit-list.jsp?id=<%=s1.getId()%>">Edit</a></td>
											<td><a href="admin-customer-delete-list.jsp?id=<%=s1.getId()%>">Delete</a></td>
										</tr>
										<%} %>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- End  Basic Table  -->
				</div>
			</div>

		</div>

	</div>



	<section class="footer-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					&copy; 2014 Yourdomain.com |<a href="http://www.binarytheme.com/"
						target="_blank"> Designed by : binarytheme.com</a>
				</div>

			</div>
		</div>
	</section>
	<!-- FOOTER SECTION END-->


	<!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
	<!-- CORE JQUERY  -->
	<script src="assets/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS  -->
	<script src="assets/js/bootstrap.js"></script>
	<!-- CUSTOM SCRIPTS  -->
	<script src="assets/js/custom.js"></script>

</body>
</html>