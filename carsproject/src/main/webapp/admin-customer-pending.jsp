<%@ page import="dao.ServiceDao"%>
	<%@ page import="model.Serviceman_Services"%>
	<%@ page import="java.util.List"%>
	<%@ page import="dao.BookingDao" %>
	<%@ page import="model.BookService" %>
	<%@ page import="dao.ServicemanDao" %>
	<%@ page import="model.ServiceMan" %>
	
	
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
<title>Admin- Customer- Pending-List- CarsWash- AutoWash</title>
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
					<h4 class="header-line">Customer-Pending-Services</h4>

				</div>

			</div>
			<div class="row">
				<div class="col-md-12">
					<!--   Basic Table  -->
					<div class="panel panel-default">
						<div class="panel-heading">Customer-Pending-Services Table</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th>ServiceMan Name</th>
											<th>Car Model</th>
											<th>Service Price</th>
											<th>Service Duration</th>
											<th>Service_Status</th>
											<th>Payment_Status</th>
										</tr>
									</thead>
									<tbody>
									
										<%List<BookService> list = BookingDao.getPendingServiceByCustomerId(s.getId()); %>
											<%for(BookService s1:list){ %>
											<%ServiceMan ser = ServicemanDao.getServicemanById(s1.getServiceman_id()); %>
										<%Serviceman_Services service = ServiceDao.getSingleServiceBySid(s1.getSid()); %>
										<tr>
											<td><%=ser.getName()%></td>
											<td><%=service.getCar_model() %></td>
											<td><%=service.getSprice()%></td>
											<td><%=service.getDuration()%></td>
											<td><%=s1.getBooking_status() %></td>
											<td><%=s1.getPayment_status()%></td>
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