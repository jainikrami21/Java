
<%@page import="java.util.List"%>
<%@page import="model.BookService"%>
<%@page import="dao.BookingDao"%>

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
					<h4 class="header-line">BookServices</h4>

				</div>

			</div>
			<div class="row">
				<div class="col-md-12">
					<!--   Basic Table  -->
					<div class="panel panel-default">
						<div class="panel-heading">BookServices Table</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th>BId</th>
											<th>CId</th>
											<th>Service_Id</th>
											<th>Serviceman_Id</th>
											<th>Service_Status</th>
											<th>Payment_Status</th>
											<th>ServiceMan Pending</th>
											<th>Customer Pending</th>
											<th>ServiceMan Complete</th>
											<th>Customer Complete</th>
											<th>ServiceMan Reject</th>
											<th>Customer Reject</th>
										</tr>
									</thead>
									<tbody>
									
										<% List<BookService> list = BookingDao.getAllBookService(); %>
										<%for(BookService s1: list){ %>
										<tr>
											<td><%=s1.getBid()%></td>
											<td><%=s1.getCid() %></td>
											<td><%=s1.getSid()%></td>
											<td><%=s1.getServiceman_id()%></td>
											<td><%=s1.getBooking_status()%></td>
											<td><%=s1.getPayment_status()%></td>
											<td><a href="admin-serviceman-pending.jsp?id=<%=s1.getServiceman_id()%>">ServiceMan Pending</a></td>
											<td><a href="admin-customer-pending.jsp?id=<%=s1.getCid()%>">Customer Pending</a></td>
											<td><a href="admin-serviceman-complete.jsp?id=<%=s1.getServiceman_id()%>">ServiceMan Complete</a></td>
											<td><a href="admin-customer-complete.jsp?id=<%=s1.getCid()%>">Customer Complete</a></td>
											<td><a href="admin-serviceman-reject.jsp?id=<%=s1.getServiceman_id()%>">ServiceMan Reject</a></td>
											<td><a href="admin-customer-reject.jsp?id=<%=s1.getCid()%>">Customer Reject</a></td>
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